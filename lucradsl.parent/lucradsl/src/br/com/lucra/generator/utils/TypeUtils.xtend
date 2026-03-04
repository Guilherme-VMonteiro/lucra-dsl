package br.com.lucra.generator.utils

import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.lucraDSL.ComplexTypeRef
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.PrimitiveType
import br.com.lucra.utils.ImportManager

import static br.com.lucra.generator.utils.ArtifactType.DOMAIN_CLASS

class TypeUtils {

	def resolveTypeName(EntityField field, ImportManager importManager, ArtifactType artifactType) {
		val type = field.type

		switch type {
			case type instanceof PrimitiveType: {
				return getPrimitiveType((type as PrimitiveType), importManager)
			}
			case type instanceof ComplexTypeRef: {
				return getComplexType((type as ComplexTypeRef), importManager, artifactType)
			}
		}
	}

	private def getPrimitiveType(PrimitiveType type, ImportManager importManager) {
		val typeName = type.name

		switch (typeName) {
			case "string": {
				return "String"
			}
			case "number": {
				"double"
			}
			case "date": {
				importManager.addImport("java.time.LocalDate")

				return "LocalDate"
			}
			case "uuid": {
				importManager.addImport("java.util.UUID")

				return "UUID"
			}
			case "money": {
				importManager.addImport("java.math.BigDecimal")

				return "BigDecimal"
			}
			case "boolean": {
				return "boolean"
			}
			default: {
				throw new IllegalArgumentException(String.format("Unsupported primitive type. Type: '%s'", typeName))
			}
		}
	}

	private def getComplexType(ComplexTypeRef ref, ImportManager importManager, ArtifactType artifactType) {
		val type = ref.type

		switch type {
			case type instanceof Entity: {				
				importManager.addImport(ClassNameResolver.resolveFullyQualifiedName(type, artifactType))

				return ClassNameResolver.resolve(type, artifactType)
			}
			case type instanceof EnumDsl: {
				importManager.addImport(ClassNameResolver.resolveFullyQualifiedName(type, DOMAIN_CLASS))

				return ClassNameResolver.resolve(type, DOMAIN_CLASS)
			}
		}
	}
}
