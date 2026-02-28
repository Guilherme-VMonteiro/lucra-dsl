package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.utils.TypeUtils
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.utils.ImportManager

class EntityAttributeGenerator {
	
	val typeUtils = new TypeUtils()

	def generateField(EntityField field, ImportManager importManager) {
		'''
			private «field.resolveJavaTypeDeclaration(importManager)» «field.name»;
		'''
	}

	private def resolveJavaTypeDeclaration(EntityField field, ImportManager importManager) {
		var fieldType = typeUtils.resolveTypeName(field, importManager)

		if (field.isList) {
			importManager.addImport("java.util.List")

			return '''List<«fieldType»>'''
		}

		return '''«fieldType»'''
	}
}
