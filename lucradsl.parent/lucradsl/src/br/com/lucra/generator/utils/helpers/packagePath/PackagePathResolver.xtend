package br.com.lucra.generator.utils.helpers.packagePath

import br.com.lucra.utils.Constants
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.Element
import br.com.lucra.generator.utils.ArtifactType

class PackagePathResolver {

	static def String resolve(Element element, ArtifactType type) {
		switch type {
			case DOMAIN_CLASS,
			case DTO,
			case MAPPER:
				domainPackage(element)
			case REPOSITORY,
			case SERVICE,
			case REST_HANDLER:
				entityOnlyPackage(element)
			default:
				unsupported(type, element)
		}
	}

	private static def String domainPackage(Element element) {
		switch element {
			Entity:
				entityBasePackage(element)
			EnumDsl: '''«Constants.serverGenBasePackage»enums'''
			default:
				unsupported("DOMAIN_CLASS", element)
		}
	}

	private static def String entityOnlyPackage(Element element) {
		switch element {
			Entity:
				entityBasePackage(element)
			default:
				unsupported("ENTITY_ARTIFACT", element)
		}
	}

	private static def String unsupported(Object type, Element element) {
		throw new IllegalArgumentException(
			String.format(
				"%s - Unsupported combination: artifact '%s' for element '%s'",
				PackagePathResolver.simpleName,
				type,
				element.eClass.name
			)
		)
	}

	private static def String entityBasePackage(Entity entity) {
		'''«Constants.serverGenBasePackage»«entity.name»'''
	}
}
