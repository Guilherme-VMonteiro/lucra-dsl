package br.com.lucra.generator

import org.eclipse.xtext.generator.AbstractGenerator
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.utils.ImportManager
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.generators.mapper.MapperMethodGenerator

class MapperGenerator extends AbstractGenerator {
	
	val mapperMethodGenerator = new MapperMethodGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.MAPPER).toString(),
				entity.compileMapper
			)
		}
	}
	
	private def compileMapper(Entity entity) {
		val importManager = new ImportManager()
		
		importManager.addImports(
			"br.com.lucra.core.mapper.Mapper",
			"lombok.RequiredArgsConstructor",
			"org.springframework.stereotype.Component"
		)
		
		val classPackage = PackagePathResolver.resolve(entity, ArtifactType.MAPPER)
		val className = ClassNameResolver.resolve(entity, ArtifactType.MAPPER)
		val entityClassName = ClassNameResolver.resolve(entity, ArtifactType.DOMAIN_CLASS)
		val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)
		
		val dependencies = mapperMethodGenerator.generateDependencyFields(entity, importManager)
		val methods = mapperMethodGenerator.generateMethods(entity, importManager)
		
		'''
			package «classPackage»;
			
			«importManager.render»

			@Component
			@RequiredArgsConstructor
			public class «className» implements Mapper<«entityClassName», «dtoClassName»> {
				
				«dependencies»

				«methods»
			}
		'''
	}
}
