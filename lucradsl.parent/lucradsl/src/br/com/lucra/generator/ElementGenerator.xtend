package br.com.lucra.generator

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.ClassUtils
import br.com.lucra.lucraDSL.Element
import br.com.lucra.utils.ImportManager
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ElementGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (element : resource.allContents.toIterable.filter(Element)) {
			fsa.generateFile(
				ClassUtils.generateFilePath(element, ArtifactType.DOMAIN_CLASS).toString(),
				element.compile
			)
		}
	}

	private def compile(Element element) {
		val importManager = new ImportManager()
		val classPackage = ClassUtils.generatePackagePath(element, ArtifactType.DOMAIN_CLASS)
		val classType = ClassUtils.getClassType(element)
		val className = ClassUtils.generateClassName(element, ArtifactType.DOMAIN_CLASS)
		val classAnnotations = ClassUtils.generateClassAnnotations(element, importManager)
		val classFields = ClassUtils.generateClassFields(element, importManager)
		val classImports = ClassUtils.generateClassImports(element, importManager)

		'''
			package «classPackage»;
			
			«classImports»
			
			«classAnnotations»
			public «classType» «className» {
				«classFields»
			}
		'''
	}
}
