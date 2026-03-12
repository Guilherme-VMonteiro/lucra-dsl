package br.com.lucra.generator

import br.com.lucra.generator.generators.service.ServiceBaseMethod
import br.com.lucra.generator.generators.service.ServiceMethodGenerator
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ServiceGenerator extends AbstractGenerator {

	val serviceMethodGenerator = new ServiceMethodGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.SERVICE).toString(),
				entity.compileInterface
			)

			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.SERVICE_IMPL).toString(),
				entity.compileImplementation
			)
		}
	}

	private def compileInterface(Entity entity) {
		val importManager = new ImportManager()
		val packagePath = PackagePathResolver.resolve(entity, ArtifactType.SERVICE)
		val serviceClassName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE)

		val methods = #[
			ServiceBaseMethod.FIND_BY_ID,
			ServiceBaseMethod.LIST,
			ServiceBaseMethod.SAVE,
			ServiceBaseMethod.DELETE
		]

		val principal = '''
			public interface «serviceClassName» {
				«serviceMethodGenerator.generateMethods(entity, importManager, false, methods)»
			}
		'''

		'''
			package «packagePath»;
			
			«importManager.render»
			
			«principal»
		'''
	}

	private def compileImplementation(Entity entity) {
		val importManager = new ImportManager()
		val packagePath = PackagePathResolver.resolve(entity, ArtifactType.SERVICE)
		val serviceClassName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE)
		val repositoryName = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY)
		val mapperName = ClassNameResolver.resolve(entity, ArtifactType.MAPPER)
		val mapperFieldName = mapperName.toFirstLower()

		val methods = #[
			ServiceBaseMethod.FIND_BY_ID,
			ServiceBaseMethod.LIST,
			ServiceBaseMethod.SAVE,
			ServiceBaseMethod.DELETE
		]

		importManager.addImport("org.springframework.stereotype.Service");
		importManager.addImport("lombok.RequiredArgsConstructor");
		importManager.addImport(ClassNameResolver.resolveFullyQualifiedName(entity, ArtifactType.MAPPER));

		val principal = '''
			@Service
			@RequiredArgsConstructor
			public class «serviceClassName»Impl implements «serviceClassName» {
			
				private final «repositoryName» «repositoryName.toString().toFirstLower()»;
				private final «mapperName» «mapperFieldName»;
				«serviceMethodGenerator.generateMethods(entity, importManager, true, methods)»
			}
		'''

		'''
			package «packagePath»;
							
			«importManager.render»
			
			«principal»
		'''
	}
}
