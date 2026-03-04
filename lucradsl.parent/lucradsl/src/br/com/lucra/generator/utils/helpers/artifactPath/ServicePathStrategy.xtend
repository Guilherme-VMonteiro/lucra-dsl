package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.Constants
import br.com.lucra.utils.StringUtils
import br.com.lucra.lucraDSL.Element

class ServicePathStrategy implements ArtifactPathStrategy {

	boolean impl

	new(boolean impl) {
		this.impl = impl
	}

	override generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«getServiceClassName(element)»«IF this.impl»Impl«ENDIF».java'''
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private def getServiceClassName(Element element) {
		switch element {
			Entity: '''«StringUtils.capitalize(element.name)»Service'''
			default: {
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
			}
		}
	}
}
