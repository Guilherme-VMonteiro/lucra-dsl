package br.com.lucra.generator

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator
import br.com.lucra.generator.generators.record.RecordAttributeGenerator
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.lucraDSL.RecordDsl
import br.com.lucra.utils.ImportManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class RecordGenerator extends AbstractGenerator {

	val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator()
	val recordAttributeGenerator = new RecordAttributeGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (recordDsl : resource.allContents.toIterable.filter(RecordDsl)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(recordDsl, ArtifactType.RECORD).toString(),
				recordDsl.compileRecord
			)
		}
	}

	private def compileRecord(RecordDsl recordDsl) {
		val importManager = new ImportManager()

		val classPackage = PackagePathResolver.resolve(recordDsl, ArtifactType.RECORD)
		val className = ClassNameResolver.resolve(recordDsl, ArtifactType.RECORD)
		val classAnnotations = entityClassAnnotationGenerator.generateClassAnnotations(
			recordDsl,
			importManager,
			ArtifactType.RECORD
		)
		val classFields = recordDsl.fields
			.map[recordAttributeGenerator.generateField(it, importManager, ArtifactType.RECORD).toString]
			.join(",\n")

		'''
			package «classPackage»;
			
			«importManager.render»
			
			«classAnnotations»
			public record «className»(
				«classFields»
			){}
		'''
	}
}
