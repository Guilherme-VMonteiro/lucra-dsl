package br.com.lucra.generator.generators.enums

import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.EnumLiteral
import br.com.lucra.utils.StringUtils

class EnumGenerator {

	val stringUtils = new StringUtils()

	def generateFields(EnumDsl enumm) {
		'''
			«FOR literal : enumm.literals SEPARATOR ',\n'»«literal.generateLiteral().toString.trim»«ENDFOR»
		'''
	}

	private def generateLiteral(EnumLiteral literal) {
		'''«stringUtils.toUpperCaseSpaced(literal.name)»'''
	}
}
