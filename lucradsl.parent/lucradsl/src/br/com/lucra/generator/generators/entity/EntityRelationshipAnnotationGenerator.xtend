package br.com.lucra.generator.generators.entity

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.lucraDSL.RelationType
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils

class EntityRelationshipAnnotationGenerator {

	val stringUtils = new StringUtils()

	def generateRelationshipAnnotations(EntityField field, ImportManager importManager) {
		switch field.relation {
			case RelationType.CONTAINS:
				return generateContainsAnnotations(field, importManager)
			case RelationType.CONTAINED:
				return generateContainedAnnotations(field, importManager)
			case RelationType.REFERS:
				return generateRefersAnnotations(field, importManager)
			default: {
				throw new IllegalArgumentException(
					String.format("Unsupported relationship. Field: %s. Relationship: %s", field.name, field.relation)
				)
			}
		}
	}

	private def generateContainsAnnotations(EntityField field, ImportManager importManager) {
		if (field.list) {
			importManager.addImports(
				"jakarta.persistence.OneToMany",
				"jakarta.persistence.CascadeType"
			)

			return '''
				@OneToMany(mappedBy = "«getMappedBy(field)»", cascade = CascadeType.ALL, orphanRemoval = true)
			'''
		} else {
			importManager.addImports(
				"jakarta.persistence.OneToOne",
				"jakarta.persistence.CascadeType"
			)

			return '''
				@OneToOne(mappedBy = "«getMappedBy(field)»", cascade = CascadeType.ALL, orphanRemoval = true)
			'''
		}
	}

	private def generateContainedAnnotations(EntityField field, ImportManager importManager) {
		if (field.list) {
			throw new IllegalArgumentException(
				String.format(
					"A 'contained' relationship cannot be a list (*). The entity holding the Foreign Key can only point to a single parent. Field: %s",
					field.name)
			)
		}

		importManager.addImports(
			"jakarta.persistence.ManyToOne",
			"jakarta.persistence.JoinColumn"
		)

		return '''
			@ManyToOne
			@JoinColumn(name = "«getJoinColumnName(field.name)»")
		'''
	}

	private def generateRefersAnnotations(EntityField field, ImportManager importManager) {
		if (field.list) {
			throw new IllegalArgumentException(
				String.format(
					"A 'refers' relationship cannot be a list (*). Since ManyToMany is disabled and the current entity holds the ID, it must be a single reference. Field: %s",
					field.name)
			)
		}

		importManager.addImports(
			"jakarta.persistence.ManyToOne",
			"jakarta.persistence.JoinColumn"
		)

		return '''
			@ManyToOne
			@JoinColumn(name = "«getJoinColumnName(field.name)»")
		'''
	}

	private def getMappedBy(EntityField field) {
		val parentEntity = field.eContainer as Entity
		return parentEntity.name.toFirstLower
	}

	private def getJoinColumnName(String fieldName) {
		return stringUtils.toSnakeCase(fieldName) + "_id"
	}
}
