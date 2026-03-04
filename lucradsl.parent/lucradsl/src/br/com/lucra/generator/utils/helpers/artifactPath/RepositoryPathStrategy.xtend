package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.Constants
import br.com.lucra.utils.StringUtils

class RepositoryPathStrategy implements ArtifactPathStrategy {

	override generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«getRepositoryClassName(element)».java'''
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private def getRepositoryClassName(Element element) {
		switch element {
			Entity: '''«StringUtils.capitalize(element.name)»Repository'''
			default: {
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
			}
		}
	}
}
