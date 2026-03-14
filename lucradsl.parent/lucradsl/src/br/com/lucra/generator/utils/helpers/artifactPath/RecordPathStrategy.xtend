package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.utils.Constants
import br.com.lucra.lucraDSL.RecordDsl
import br.com.lucra.utils.StringUtils
import br.com.lucra.lucraDSL.Element

class RecordPathStrategy implements ArtifactPathStrategy {

	override generateFilePath(Element element) {
		switch element {
			RecordDsl: '''«Constants.serverGenBasePath»/records/«getRecordName(element)».java'''
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass().getSimpleName(), element.name))
		}
	}

	private static def getRecordName(Element element) {
		switch element {
			RecordDsl: '''«StringUtils.capitalize(element.name)»'''
			default: ''''''
		}
	}
}
