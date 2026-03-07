package br.com.lucra.generator.generators.restHandler

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.ArtifactType

class RestHandlerMethodGenerator {

	def generateMethods(
		Entity entity,
		ImportManager importManager,
		RestHandlerBaseMethod... serviceBaseMethods
	) {
		'''
			«FOR method : serviceBaseMethods»
				«generateMethod(entity, importManager, method)»
			«ENDFOR»
		'''
	}

	def generateMethod(
		Entity entity,
		ImportManager importManager,
		RestHandlerBaseMethod serviceBaseMethod
	) {
		switch serviceBaseMethod {
			case FIND_BY_ID:
				generateFindById(entity, importManager)
			case LIST:
				generateList(entity, importManager)
			case SAVE:
				generateSave(entity, importManager)
			case DELETE:
				generateDelete(entity, importManager)
			default: {
				throw new IllegalArgumentException(
					String.format("Unsupported service base method. %s", serviceBaseMethod)
				)
			}
		}
	}

	def generateFindById(Entity entity, ImportManager importManager) {
		importManager.addImports(
			"org.springframework.web.bind.annotation.GetMapping",
			"org.springframework.web.bind.annotation.PathVariable",
			"java.util.UUID"
		)

		val serviceName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE).toString().toFirstLower()
		val dtoType = ClassNameResolver.resolve(entity, ArtifactType.DTO)

		'''
			
			@GetMapping("/{id}")
			public «dtoType» findById(@PathVariable UUID id) {
				return «serviceName».findById(id);
			}
		'''
	}

	def generateList(Entity entity, ImportManager importManager) {
		importManager.addImports(
			"org.springframework.web.bind.annotation.GetMapping",
			"org.springframework.data.domain.Page",
			"org.springframework.data.domain.Pageable"
		)

		val serviceName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE).toString().toFirstLower()
		val dtoType = ClassNameResolver.resolve(entity, ArtifactType.DTO)

		'''
			
			@GetMapping
			public Page<«dtoType»> list(Pageable pageable) {
			    return «serviceName».list(pageable);
			}
		'''
	}

	def generateSave(Entity entity, ImportManager importManager) {
		importManager.addImports(
			"org.springframework.web.bind.annotation.GetMapping",
			"org.springframework.web.bind.annotation.PostMapping",
			"org.springframework.web.bind.annotation.RequestBody"
		)

		val serviceName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE).toString().toFirstLower()
		val dtoType = ClassNameResolver.resolve(entity, ArtifactType.DTO)

		'''
			
			@PostMapping
			public «dtoType» save(@RequestBody «dtoType» dto) {
			    return «serviceName».save(dto);
			}
		'''
	}

	def generateDelete(Entity entity, ImportManager importManager) {
		importManager.addImports(
			"org.springframework.web.bind.annotation.DeleteMapping",
			"org.springframework.web.bind.annotation.PathVariable",
			"java.util.UUID"
		)

		val serviceName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE).toString().toFirstLower()

		'''
			
			@DeleteMapping("/{id}")
			public void delete(@PathVariable UUID id) {
				«serviceName».delete(id);
			}
		'''
	}

}
