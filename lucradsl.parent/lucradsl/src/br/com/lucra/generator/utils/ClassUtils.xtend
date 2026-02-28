package br.com.lucra.generator.utils

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator
import br.com.lucra.generator.generators.entity.EntityFieldGenerator
import br.com.lucra.generator.generators.enums.EnumGenerator
import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.utils.Constants
import br.com.lucra.utils.ImportManager
import br.com.lucra.utils.StringUtils

class ClassUtils {

	static val stringUtils = new StringUtils()
	static val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator()
	static val entityFieldGenerator = new EntityFieldGenerator()
	static val enumGenerator = new EnumGenerator()

	static def generateFilePath(Element element, ArtifactType artifactType) {
		switch artifactType {
			case DOMAIN_CLASS: getDomainClassFilePath(element)
			case REPOSITORY:   getRepositoryFilePath(element)
		}
	}

	static def generatePackagePath(Element element, ArtifactType artifactType) {
		switch artifactType {
			case DOMAIN_CLASS: getDomainClassPackagePath(element)
			case REPOSITORY:   getRepositoryPackagePath(element)
		}
	}

	static def generateClassName(Element element, ArtifactType artifactType) {
		switch artifactType {
			case DOMAIN_CLASS: getDomainClassName(element)
			case REPOSITORY:   getRepositoryClassName(element)
		}
	}

	private static def getDomainClassFilePath(Element element) {
		switch element {
			Entity:  '''«Constants.serverGenBasePath»«element.name»/«getDomainClassName(element)».java'''
			EnumDsl: '''«Constants.serverGenBasePath»enums/«getDomainClassName(element)».java'''
			default: throw new IllegalArgumentException(
				String.format("Unsupported Element for DOMAIN_CLASS: '%s'", element.eClass.name)
			)
		}
	}

	private static def getDomainClassPackagePath(Element element) {
		switch element {
			Entity:  '''«Constants.serverGenBasePackage»«element.name»'''
			EnumDsl: '''«Constants.serverGenBasePackage»enums'''
		}
	}

	private static def getDomainClassName(Element element) {
		switch element {
			Entity:  '''«stringUtils.capitalize(element.name)»Entity'''
			EnumDsl: '''«stringUtils.capitalize(element.name)»Enum'''
		}
	}

	private static def getRepositoryFilePath(Element element) {
		switch element {
			Entity:  '''«Constants.serverGenBasePath»«element.name»/«getRepositoryClassName(element)».java'''
			default: throw new IllegalArgumentException(
				String.format("Unsupported Element for REPOSITORY: '%s'", element.eClass.name)
			)
		}
	}

	private static def getRepositoryPackagePath(Element element) {
		switch element {
			Entity:  '''«Constants.serverGenBasePackage»«element.name»'''
			default: throw new IllegalArgumentException(
				String.format("Unsupported Element for REPOSITORY: '%s'", element.eClass.name)
			)
		}
	}

	private static def getRepositoryClassName(Element element) {
		switch element {
			Entity:  '''«stringUtils.capitalize(element.name)»Repository'''
			default: throw new IllegalArgumentException(
				String.format("Unsupported Element for REPOSITORY: '%s'", element.eClass.name)
			)
		}
	}

	static def generateImport(Element element) {
		getDomainClassPackagePath(element) + "." + getDomainClassName(element)
	}

	static def getClassType(Element element) {
		switch element {
			Entity:  '''class'''
			EnumDsl: '''enum'''
		}
	}

	static def generateClassAnnotations(Element element, ImportManager importManager) {
		switch element {
			Entity:  '''«entityClassAnnotationGenerator.generateClassAnnotations(element, importManager)»'''
			EnumDsl: ''''''
		}
	}

	static def generateClassFields(Element element, ImportManager importManager) {
		switch element {
			Entity:  '''«entityFieldGenerator.generateFields(element, importManager)»'''
			EnumDsl: '''«enumGenerator.generateFields(element)»'''
		}
	}

	static def generateClassImports(Element element, ImportManager importManager) {
		switch element {
			EnumDsl: ''''''
			default: '''
				«importManager.render»
			'''
		}
	}
}
