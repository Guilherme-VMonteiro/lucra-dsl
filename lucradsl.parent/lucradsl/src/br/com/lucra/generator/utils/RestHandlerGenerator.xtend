package br.com.lucra.generator.utils

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator
import br.com.lucra.generator.generators.restHandler.RestHandlerBaseMethod
import br.com.lucra.generator.generators.restHandler.RestHandlerMethodGenerator
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class RestHandlerGenerator extends AbstractGenerator {

	val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator()
	val restHandlerMethodGenerator = new RestHandlerMethodGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.REST_HANDLER).toString(),
				entity.compileElement
			)
		}
	}

	private def compileElement(Entity entity) {
		val importManager = new ImportManager()
		val classPackage = PackagePathResolver.resolve(entity, ArtifactType.REST_HANDLER)
		val classType = ClassNameResolver.resolveKeyword(entity)
		val restHandlerName = ClassNameResolver.resolve(entity, ArtifactType.REST_HANDLER)
		val serviceName = ClassNameResolver.resolve(entity, ArtifactType.SERVICE)
		val classAnnotations = generateClassAnnotations(entity, importManager)

		val methods = #[
			RestHandlerBaseMethod.FIND_BY_ID,
			RestHandlerBaseMethod.LIST,
			RestHandlerBaseMethod.SAVE,
			RestHandlerBaseMethod.DELETE
		]

		val principal = '''
			«classAnnotations»
			public «classType» «restHandlerName» {
				
				private final «serviceName» «serviceName.toString().toFirstLower()»;
				«restHandlerMethodGenerator.generateMethods(entity, importManager, methods)»
			}
		'''

		'''
			package «classPackage»;
			
			«importManager.render»
			
			«principal»
		'''
	}

	private def generateClassAnnotations(Element element, ImportManager importManager) {
		switch element {
			Entity:
				entityClassAnnotationGenerator.generateClassAnnotations(element, importManager,
					ArtifactType.REST_HANDLER)
			default:
				''
		}
	}
}
