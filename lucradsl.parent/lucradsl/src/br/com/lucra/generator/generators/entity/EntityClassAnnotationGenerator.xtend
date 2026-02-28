package br.com.lucra.generator.generators.entity

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils

class EntityClassAnnotationGenerator {
	
	val stringUtils = new StringUtils()
	
	def generateClassAnnotations(Entity entity, ImportManager imports) {
		imports.addImports(
			"lombok.Getter",
			"lombok.Setter",
			"lombok.AllArgsConstructor",
			"lombok.NoArgsConstructor",
			"lombok.Builder",
			"lombok.EqualsAndHashCode",
			"jakarta.persistence.Entity"
		)

		if (stringUtils.isCamelCase(entity.name)) {
			imports.addImport("jakarta.persistence.Table")
		}

		'''
			@Getter
			@Setter
			@AllArgsConstructor
			@NoArgsConstructor
			@Builder
			@EqualsAndHashCode(onlyExplicitlyIncluded = true)
			«IF stringUtils.isCamelCase(entity.name)»
				@Table(«entity.tableAttributes»)
			«ENDIF»
			@Entity
		'''
	}
	
	private def tableAttributes(Entity entity) {
		val parts = newArrayList
	
		if (stringUtils.isCamelCase(entity.name)) {
			parts.add('''name = "«stringUtils.toSnakeCase(entity.name)»"''')			
		}
	
		parts.join(", ")
	}
}
