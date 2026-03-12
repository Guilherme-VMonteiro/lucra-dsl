package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.Constants
import br.com.lucra.utils.StringUtils

class MapperPathStrategy implements ArtifactPathStrategy {

	override generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«getDtoClassName(element)».java'''
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private static def getDtoClassName(Element element) {
		switch element {
			Entity: '''«StringUtils.capitalize(element.name)»Mapper'''
			default: ''''''
		}
	}
}
