package br.com.lucra.generator

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator
import br.com.lucra.generator.generators.entity.EntityFieldGenerator
import br.com.lucra.generator.generators.enums.EnumGenerator
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.utils.ImportManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ElementGenerator extends AbstractGenerator {

	val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator()
	val entityFieldGenerator = new EntityFieldGenerator()
	val enumGenerator = new EnumGenerator()

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (element : resource.allContents.toIterable.filter(Element)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(element, ArtifactType.DOMAIN_CLASS).toString(),
				element.compileElement
			)
		}
	}

	private def compileElement(Element element) {
		val importManager = new ImportManager()
		val classPackage = PackagePathResolver.resolve(element, ArtifactType.DOMAIN_CLASS)
		val classType = ClassNameResolver.resolveKeyword(element)
		val className = ClassNameResolver.resolve(element, ArtifactType.DOMAIN_CLASS)
		val classAnnotations = generateClassAnnotations(element, importManager)
		val classFields = generateClassFields(element, importManager)

		'''
			package «classPackage»;
			
			«importManager.render»
			
			«classAnnotations»
			public «classType» «className» {
				«classFields»
			}
		'''
	}

	private def generateClassAnnotations(Element element, ImportManager importManager) {
		switch element {
			Entity: entityClassAnnotationGenerator.generateClassAnnotations(element, importManager, ArtifactType.DOMAIN_CLASS)
			default: ''
		}
	}

	private def generateClassFields(Element element, ImportManager importManager) {
		switch element {
			Entity: entityFieldGenerator.generateFields(element, importManager, ArtifactType.DOMAIN_CLASS)
			EnumDsl: enumGenerator.generateFields(element)
		}
	}
}
