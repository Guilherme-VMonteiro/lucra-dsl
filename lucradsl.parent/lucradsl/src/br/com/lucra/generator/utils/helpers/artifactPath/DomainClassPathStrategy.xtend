package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.RecordDsl
import br.com.lucra.utils.Constants
import br.com.lucra.utils.StringUtils

class DomainClassPathStrategy implements ArtifactPathStrategy {

	override generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«getDomainClassName(element)».java'''
			EnumDsl: '''«Constants.serverGenBasePath»enums/«getDomainClassName(element)».java'''
			RecordDsl:
				throw new IllegalArgumentException(
					String.format(
						"%s - Record '%s' must use ArtifactType.RECORD strategy",
						this.getClass().getSimpleName(),
						element.name
					)
				)
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private static def getDomainClassName(Element element) {
		switch element {
			Entity: '''«StringUtils.capitalize(element.name)»Entity'''
			EnumDsl: '''«StringUtils.capitalize(element.name)»Enum'''
		}
	}
}
