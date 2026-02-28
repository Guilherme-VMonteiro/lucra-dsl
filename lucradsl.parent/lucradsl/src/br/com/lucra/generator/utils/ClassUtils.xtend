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
	static val entityClassAnnotationGenerator = new EntityClassAnnotationGenerator();
	static val entityFieldGenerator = new EntityFieldGenerator()
	static val enumGenerator = new EnumGenerator();

	static def generateFilePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePath»«element.name»/«element.generateClassName».java'''
			EnumDsl: '''«Constants.serverGenBasePath»enums/«element.generateClassName».java'''
			default: {
				throw new IllegalArgumentException(
					String.format("Unsupported Element: '%s'", element.eClass.name)
				)
			}
		}
	}

	static def generatePackagePath(Element element) {
		switch element {
			Entity: '''«Constants.serverGenBasePackage»«element.name»'''
			EnumDsl: '''«Constants.serverGenBasePackage»enums'''
		}
	}

	static def generateClassName(Element element) {
		switch element {
			Entity: '''«stringUtils.capitalize(element.name)»Entity'''
			EnumDsl: '''«stringUtils.capitalize(element.name)»Enum'''
		}
	}

	static def generateImport(Element element) {
		return generatePackagePath(element) + "." + generateClassName(element)
	}

	static def getClassType(Element element) {
		switch element {
			Entity: '''class'''
			EnumDsl: '''enum'''
		}
	}

	static def generateClassAnnotations(Element element, ImportManager importManager) {
		switch element {
			Entity: '''«ClassUtils.entityClassAnnotationGenerator.generateClassAnnotations(element, importManager)»'''
			EnumDsl: ''''''
		}
	}

	static def generateClassFields(Element element, ImportManager importManager) {
		switch element {
			Entity: '''«entityFieldGenerator.generateFields(element, importManager)»'''
			EnumDsl: '''«enumGenerator.generateFields(element)»'''
		}
	}

	static def generateClassImports(Element element, ImportManager importManager) {
		switch element {
			EnumDsl: ''''''
			default: {
				'''
					«importManager.render»
				'''
			}
		}
	}
}
