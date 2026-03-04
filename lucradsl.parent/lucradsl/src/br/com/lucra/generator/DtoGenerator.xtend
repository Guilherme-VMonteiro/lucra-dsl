package br.com.lucra.generator

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator
import br.com.lucra.generator.generators.entity.EntityFieldGenerator
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

class DtoGenerator extends AbstractGenerator {

	val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator()
	val entityFieldGenerator = new EntityFieldGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.DTO).toString(),
				entity.compileDto
			)
		}
	}

	private def compileDto(Entity entity) {
		val importManager = new ImportManager()

		val classPackage = PackagePathResolver.resolve(entity, ArtifactType.DTO)
		val className = ClassNameResolver.resolve(entity, ArtifactType.DTO)
		val classAnnotations = entityClassAnnotationGenerator.generateClassAnnotations(entity, importManager, ArtifactType.DTO)
		val classFields = entityFieldGenerator.generateFields(entity, importManager, ArtifactType.DTO)

		'''
			package «classPackage»;
			
			«importManager.render»
			
			«classAnnotations»
			public class «className» {
				«classFields»
			}
		'''
	}
}
