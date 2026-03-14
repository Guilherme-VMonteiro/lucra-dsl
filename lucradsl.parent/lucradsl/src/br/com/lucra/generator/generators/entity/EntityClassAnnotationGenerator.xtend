package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.RecordDsl
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils

class EntityClassAnnotationGenerator {

	def generateClassAnnotations(Element element, ImportManager imports, ArtifactType artifactType) {
		switch artifactType {
			case DOMAIN_CLASS: generateDomainClassAnnotations(element as Entity, imports)
			case DTO: generateDtoClassAnnotations(element as Entity, imports)
			case REST_HANDLER: generateRestHandlerClassAnnotations(element as Entity, imports)
			case RECORD: generateRecordClassAnnotations(element as RecordDsl, imports)
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

	private def generateRestHandlerClassAnnotations(Entity entity, ImportManager imports) {
		imports.addImports(
			"org.springframework.web.bind.annotation.RestController",
			"org.springframework.web.bind.annotation.RequestMapping",
			"lombok.RequiredArgsConstructor"
		)

		val entityName = entity.name

		'''
			@RestController
			@RequestMapping("/api/entity/«entityName»")
			@RequiredArgsConstructor
		'''
	}
	
	private def generateRecordClassAnnotations(RecordDsl record, ImportManager imports) {
		imports.addImport("lombok.Builder")

		'''
			@Builder
		'''
	}
	
	// Utils
	
	private def tableAttributes(Entity entity) {
		val parts = newArrayList

		if (StringUtils.isCamelCase(entity.name)) {
			parts.add('''name = "«StringUtils.toSnakeCase(entity.name)»"''')
		}

		parts.join(", ")
	}
}
