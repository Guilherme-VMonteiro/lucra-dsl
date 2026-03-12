package br.com.lucra.generator.generators.service

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager

class ServiceMethodGenerator {

	def generateMethods(
		Entity entity,
		ImportManager importManager,
		boolean implementation,
		ServiceBaseMethod... serviceBaseMethods
	) {
		'''
			«FOR method : serviceBaseMethods»
				«generateMethod(entity, importManager,implementation, method)»
			«ENDFOR»
		'''
	}

	def generateMethod(
		Entity entity,
		ImportManager importManager,
		boolean implementation,
		ServiceBaseMethod serviceBaseMethod
	) {
		switch serviceBaseMethod {
			case ServiceBaseMethod.FIND_BY_ID:
				generateFindById(entity, importManager, implementation)
			case ServiceBaseMethod.LIST:
				generateList(entity, importManager, implementation)
			case ServiceBaseMethod.SAVE:
				generateSave(entity, importManager, implementation)
			case ServiceBaseMethod.DELETE:
				generateDelete(entity, importManager, implementation)
			default: {
				throw new IllegalArgumentException(
					String.format("Unsupported service base method. %s", serviceBaseMethod)
				)
			}
		}
	}

	private def generateFindById(Entity entity, ImportManager importManager, boolean implementation) {
		if (implementation) {
			val repository = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY).toFirstLower()
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)
			val mapperFieldName = ClassNameResolver.resolve(entity, ArtifactType.MAPPER).toFirstLower()

			importManager.addImport("java.util.Optional")
			importManager.addImport("java.util.UUID")

			'''
				
				@Override
				public Optional<«dtoClassName»> findById(UUID id) {
					return «repository».findById(id).map(«mapperFieldName»::toTarget);
				}
			'''
		} else {
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)

			importManager.addImports("java.util.Optional", "java.util.UUID")

			'''
				
				Optional<«dtoClassName»> findById(UUID id);
			'''
		}
	}

	private def generateList(Entity entity, ImportManager importManager, boolean implementation) {
		if (implementation) {
			val repository = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY).toFirstLower()
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)
			val mapperFieldName = ClassNameResolver.resolve(entity, ArtifactType.MAPPER).toFirstLower()

			importManager.addImport("org.springframework.data.domain.Page")
			importManager.addImport("org.springframework.data.domain.Pageable")

			'''
				
				@Override
				public Page<«dtoClassName»> list(Pageable pageable) {
					return «repository».findAll(pageable).map(«mapperFieldName»::toTarget);
				}
			'''
		} else {
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)

			importManager.addImports(
				"org.springframework.data.domain.Page",
				"org.springframework.data.domain.Pageable"
			)

			'''
				
				Page<«dtoClassName»> list(Pageable pageable);
			'''
		}

	}

	private def generateSave(Entity entity, ImportManager importManager, boolean implementation) {
		if (implementation) {
			val repository = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY).toFirstLower()
			val entityClassName = ClassNameResolver.resolve(entity, ArtifactType.DOMAIN_CLASS)
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)
			val mapperFieldName = ClassNameResolver.resolve(entity, ArtifactType.MAPPER).toFirstLower()

			'''
				
				@Override
				public «dtoClassName» save(«dtoClassName» dto) {
					«entityClassName» entity = «mapperFieldName».toSource(dto);
					«entityClassName» saved = «repository».save(entity);
					return «mapperFieldName».toTarget(saved);
				}
			'''
		} else {
			val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)

			'''
				
				«dtoClassName» save(«dtoClassName» entity);
			'''
		}
	}

	private def generateDelete(Entity entity, ImportManager importManager, boolean implementation) {
		if (implementation) {
			val repository = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY).toFirstLower()

			importManager.addImport("java.util.UUID")

			'''
				
				@Override
				public void delete(UUID id) {
					«repository».deleteById(id);
				}
			'''
		} else {
			importManager.addImport("java.util.UUID")

			'''
				
				void delete(UUID id);
			'''
		}
	}
}
