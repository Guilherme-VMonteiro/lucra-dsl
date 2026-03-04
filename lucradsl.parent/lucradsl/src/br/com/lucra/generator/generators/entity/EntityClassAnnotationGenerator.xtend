package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils

class EntityClassAnnotationGenerator {

	def generateClassAnnotations(Entity entity, ImportManager imports, ArtifactType artifactType) {
		switch artifactType {
			case DOMAIN_CLASS: generateDomainClassAnnotations(entity, imports)
			case DTO: generateDtoClassAnnotations(entity, imports)
			default: ''
		}
	}

	private def generateDomainClassAnnotations(Entity entity, ImportManager imports) {
		imports.addImports(
			"lombok.Getter",
			"lombok.Setter",
			"lombok.AllArgsConstructor",
			"lombok.NoArgsConstructor",
			"lombok.Builder",
			"lombok.EqualsAndHashCode",
			"jakarta.persistence.Entity"
		)

		if (StringUtils.isCamelCase(entity.name)) {
			imports.addImport("jakarta.persistence.Table")
		}

		'''
			@Getter
			@Setter
			@AllArgsConstructor
			@NoArgsConstructor
			@Builder
			@EqualsAndHashCode(onlyExplicitlyIncluded = true)
			«IF StringUtils.isCamelCase(entity.name)»
				@Table(«entity.tableAttributes»)
			«ENDIF»
			@Entity
		'''
	}

	private def generateDtoClassAnnotations(Entity entity, ImportManager imports) {
		imports.addImports(
			"lombok.Getter",
			"lombok.Setter",
			"lombok.AllArgsConstructor",
			"lombok.NoArgsConstructor",
			"lombok.Builder"
		)

		'''
			@Getter
			@Setter
			@AllArgsConstructor
			@NoArgsConstructor
			@Builder
		'''
	}

	private def tableAttributes(Entity entity) {
		val parts = newArrayList

		if (StringUtils.isCamelCase(entity.name)) {
			parts.add('''name = "«StringUtils.toSnakeCase(entity.name)»"''')
		}

		parts.join(", ")
	}
}
