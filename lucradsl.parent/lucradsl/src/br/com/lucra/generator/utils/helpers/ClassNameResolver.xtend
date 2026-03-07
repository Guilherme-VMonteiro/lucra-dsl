package br.com.lucra.generator.utils.helpers

import br.com.lucra.lucraDSL.Element
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.utils.StringUtils
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl

class ClassNameResolver {

	static def String resolve(Element element, ArtifactType type) {
		val baseName = baseName(element)
		val suffix = suffix(type, element)
		return baseName + suffix
	}

	static def String resolveKeyword(Element element) {
		switch element {
			Entity: "class"
			EnumDsl: "enum"
			default: unsupported("KEYWORD", element)
		}
	}

	static def String resolveFullyQualifiedName(Element element, ArtifactType type) {
		return PackagePathResolver.resolve(element, type) + "." + resolve(element, type)
	}

	private static def dispatch String baseName(Entity e) {
		StringUtils.capitalize(e.name)
	}

	private static def dispatch String baseName(EnumDsl e) {
		StringUtils.capitalize(e.name)
	}

	private static def String suffix(ArtifactType type, Element element) {
		switch type {
			case DOMAIN_CLASS:
				switch element {
					Entity: return "Entity"
					EnumDsl: return "Enum"
					default: unsupported(type, element)
				}
			case DTO: {
				ensureEntity(type, element)
				return "Dto"
			}
			case REPOSITORY: {
				ensureEntity(type, element)
				return "Repository"
			}
			case SERVICE: {
				ensureEntity(type, element)
				return "Service"
			}
			case REST_HANDLER: {
				ensureEntity(type, element)
				return "RestHandler"
			}
			default: {
				unsupported(type, element)
			}
		}
	}

	private static def void ensureEntity(ArtifactType type, Element element) {
		if (!(element instanceof Entity)) {
			unsupported(type, element)
		}
	}

	private static def String unsupported(Object type, Element element) {
		throw new IllegalArgumentException(
			String.format(
				"%s - Unsupported combination: artifact '%s' for element '%s'",
				ClassNameResolver.simpleName,
				type,
				element.eClass.name
			)
		)
	}
}
