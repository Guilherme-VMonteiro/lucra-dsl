package br.com.lucra.generator.generators.entity

import br.com.lucra.lucraDSL.ComplexTypeRef
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.PrimitiveType
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils
import br.com.lucra.generator.utils.ArtifactType

import static br.com.lucra.generator.utils.ArtifactType.DOMAIN_CLASS
import static br.com.lucra.generator.utils.ArtifactType.DTO

class EntityAttributeAnnotationGenerator {

	val entityRelationshipAnnotationGenerator = new EntityRelationshipAnnotationGenerator()

	def generateFieldAnnotation(EntityField field, ImportManager importManager, ArtifactType artifactType) {
		if (artifactType != DOMAIN_CLASS && artifactType != DTO) {
			return ''''''
		}

		val type = field.type

		switch type {
			case type instanceof ComplexTypeRef: '''«generateComplexTypeAnnotations(field, importManager, artifactType)»'''
			case type instanceof PrimitiveType: '''«generatePrimitiveTypeAnnotations(field, importManager, artifactType)»'''
			default: ''''''
		}
	}

	private def generatePrimitiveTypeAnnotations(
		EntityField field, //
		ImportManager importManager, //
		ArtifactType artifactType //
	) {
		switch artifactType {
			case DOMAIN_CLASS: {
				if (field.isId) {
					return generateIdAnnotations(importManager)
				}

				if (field.nullable || StringUtils.isCamelCase(field.name)) {
					return generateColumnAnnotation(field, importManager)
				}

				return ''''''
			}
			case DTO: {
				return generateDtoAnnotations(field, importManager)
			}
			default: {
				return ''''''
			}
		}

	}

	private def generateComplexTypeAnnotations(
		EntityField field, //
		ImportManager importManager, //
		ArtifactType artifactType //
	) {
		switch artifactType {
			case DOMAIN_CLASS: {
				val type = (field.type as ComplexTypeRef).type

				switch type {
					case type instanceof Entity: {
						return entityRelationshipAnnotationGenerator.
							generateRelationshipAnnotations(field, importManager)
					}
					case type instanceof EnumDsl: {
						return generateEnumeratedAnnotation(importManager)
					}
					default: {
						return ''''''
					}
				}
			}
			case DTO: {
				return generateDtoAnnotations(field, importManager)
			}
			default: ''''''
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

		if (StringUtils.isCamelCase(field.name)) {
			parts.add('''name = "«StringUtils.toSnakeCase(field.name)»"''')
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

	private def generateDtoAnnotations(EntityField field, ImportManager importManager) {
		val type = field.type

		switch type {
			case type instanceof ComplexTypeRef: '''«generateComplexTypeDtoAnnotations(field, importManager)»'''
			case type instanceof PrimitiveType: '''«generatePrimitiveTypeDtoAnnotations(field, importManager)»'''
			default: ''''''
		}
	}

	private def generateComplexTypeDtoAnnotations(EntityField field, ImportManager importManager) {
		val isRequired = !field.nullable
		val isEntity = (field.type as ComplexTypeRef).type instanceof Entity

		if (isRequired) {
			importManager.addImport('jakarta.validation.constraints.NotNull')
			if (isEntity) {
				importManager.addImport('jakarta.validation.Valid')
			}
		}

		return '''
			«IF isRequired»@NotNull«ENDIF»
			«IF isRequired && isEntity»@Valid«ENDIF»
		'''
	}

	private def generatePrimitiveTypeDtoAnnotations(
		EntityField field, //
		ImportManager importManager
	) {
		if (field.isId) {
			return ''''''
		}
		
		val isRequired = !field.nullable
		
		if (isRequired) {
			importManager.addImport('jakarta.validation.constraints.NotNull')
		}

		return '''
			«IF isRequired»@NotNull«ENDIF»
		'''
	}
}
