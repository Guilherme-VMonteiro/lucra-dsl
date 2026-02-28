package br.com.lucra.generator.generators.entity

import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.utils.ImportManager
import br.com.lucra.lucraDSL.ComplexTypeRef
import br.com.lucra.utils.StringUtils
import br.com.lucra.lucraDSL.PrimitiveType
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl

class EntityAttributeAnnotationGenerator {

	val stringUtils = new StringUtils()
	val entityRelationshipAnnotationGenerator = new EntityRelationshipAnnotationGenerator()

	def generateFieldAnnotation(EntityField field, ImportManager importManager) {
		val type = field.type

		switch type {
			case type instanceof ComplexTypeRef: '''«generateComplexTypeAnnotations(field, importManager)»'''
			case type instanceof PrimitiveType: '''«generatePrimitiveTypeAnnotations(field, importManager)»'''
		}
	}

	private def generatePrimitiveTypeAnnotations(EntityField field, ImportManager importManager) {
		if (field.isId) {
			return generateIdAnnotations(importManager)
		}

		if (field.nullable || stringUtils.isCamelCase(field.name)) {
			return generateColumnAnnotation(field, importManager)
		}

		return ''''''
	}

	private def generateComplexTypeAnnotations(EntityField field, ImportManager importManager) {
		val type = (field.type as ComplexTypeRef).type
		
		System.out.println(String.format("generateComplexTypeAnnotations ComplexTypeRef: '%s'", type.eClass.name))

		switch type {
			case type instanceof Entity: {
				return entityRelationshipAnnotationGenerator.generateRelationshipAnnotations(field, importManager)
			}
			case type instanceof EnumDsl: {
				return generateEnumeratedAnnotation(importManager)
			}
			default: {
				return ''''''
			}
		}
	}

	private def generateIdAnnotations(ImportManager importManager) {
		importManager.addImports(
			"jakarta.persistence.Id",
			"jakarta.persistence.GeneratedValue",
			"jakarta.persistence.GenerationType",
			"lombok.EqualsAndHashCode"
		)

		return '''
			@Id
			@GeneratedValue(strategy = GenerationType.UUID)
			@EqualsAndHashCode.Include
		'''
	}

	private def generateColumnAnnotation(EntityField field, ImportManager importManager) {
		importManager.addImport("jakarta.persistence.Column")

		return '''@Column(«field.columnAnnotationParameters»)'''
	}

	private def getColumnAnnotationParameters(EntityField field) {
		val parts = newArrayList

		if (stringUtils.isCamelCase(field.name)) {
			parts.add('''name = "«stringUtils.toSnakeCase(field.name)»"''')
		}

		if (field.isNullable) {
			parts.add("nullable = true")
		}

		parts.join(", ")
	}

	private def generateEnumeratedAnnotation(ImportManager importManager) {
		importManager.addImports(
			"jakarta.persistence.Enumerated",
			"jakarta.persistence.EnumType"
		)

		return '''@Enumerated(EnumType.STRING)'''
	}

	private def isId(EntityField field) {
		field.name == "id" && field.type instanceof PrimitiveType && (field.type as PrimitiveType).name == "uuid"
	}
}
