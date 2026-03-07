package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.lucraDSL.Element

class ArtifactPathResolver {

	static val strategies = #{
		ArtifactType.DOMAIN_CLASS -> new DomainClassPathStrategy,
		ArtifactType.DTO -> new DtoPathStrategy,
		ArtifactType.REPOSITORY -> new RepositoryPathStrategy,
		ArtifactType.SERVICE -> new ServicePathStrategy(false),
		ArtifactType.SERVICE_IMPL -> new ServicePathStrategy(true),
		ArtifactType.REST_HANDLER -> new RestHandlerPathStrategy()
	}

	static def generateFilePath(Element element, ArtifactType type) {
		val strategy = strategies.get(type)
		if (strategy === null)
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", "ArtifactPathResolver", element.name))

		strategy.generateFilePath(element)
	}
}
