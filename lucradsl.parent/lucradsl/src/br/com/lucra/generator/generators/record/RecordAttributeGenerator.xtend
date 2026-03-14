package br.com.lucra.generator.generators.record

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.TypeUtils
import br.com.lucra.lucraDSL.RecordField
import br.com.lucra.utils.ImportManager

class RecordAttributeGenerator {

	val typeUtils = new TypeUtils()

	def generateField(RecordField field, ImportManager importManager, ArtifactType artifactType) {
		'''«field.resolveJavaTypeDeclaration(importManager, artifactType)» «field.name»'''
	}

	private def resolveJavaTypeDeclaration(RecordField field, ImportManager importManager, ArtifactType artifactType) {
		var fieldType = typeUtils.resolveTypeName(field, importManager, artifactType)

		if (field.isList) {
			importManager.addImport("java.util.List")

			return '''List<«fieldType»>'''
		}

		return '''«fieldType»'''
	}
}
