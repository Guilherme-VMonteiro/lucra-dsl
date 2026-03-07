package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.Constants
import br.com.lucra.utils.StringUtils
import br.com.lucra.lucraDSL.Element

class RestHandlerPathStrategy implements ArtifactPathStrategy {

	override generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«getRestHandlerClassName(element)».java'''
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private def getRestHandlerClassName(Element element) {
		switch element {
			Entity: '''«StringUtils.capitalize(element.name)»RestHandler'''
			default: {
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
			}
		}
	}
}
