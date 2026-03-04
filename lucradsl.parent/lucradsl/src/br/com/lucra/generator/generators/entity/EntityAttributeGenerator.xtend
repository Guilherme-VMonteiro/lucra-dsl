package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.utils.TypeUtils
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.utils.ImportManager
import br.com.lucra.generator.utils.ArtifactType

class EntityAttributeGenerator {
	
	val typeUtils = new TypeUtils()

	def generateField(EntityField field, ImportManager importManager, ArtifactType artifactType) {
		'''
			private «field.resolveJavaTypeDeclaration(importManager, artifactType)» «field.name»;
		'''
	}

	private def resolveJavaTypeDeclaration(EntityField field, ImportManager importManager, ArtifactType artifactType) {
		var fieldType = typeUtils.resolveTypeName(field, importManager, artifactType)

		if (field.isList) {
			importManager.addImport("java.util.List")

			return '''List<«fieldType»>'''
		}

		return '''«fieldType»'''
	}
}
