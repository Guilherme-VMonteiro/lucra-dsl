package br.com.lucra.generator.utils.helpers.artifactPath

import br.com.lucra.lucraDSL.Element

interface ArtifactPathStrategy {
	def String generateFilePath(Element element)
}