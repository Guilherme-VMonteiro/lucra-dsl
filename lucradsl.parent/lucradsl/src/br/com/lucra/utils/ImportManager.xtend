package br.com.lucra.utils

import java.util.TreeSet

class ImportManager {

	val imports = new TreeSet<String>()

	def void addImport(String qualifiedName) {
		if (qualifiedName !== null && !qualifiedName.empty) {
			imports.add(qualifiedName)
		}
	}

	def void addImports(String... qualifiedNames) {
		qualifiedNames.forEach[addImport(it)]
	}

	def CharSequence render() '''
		«FOR imp : imports»
			import «imp»;
		«ENDFOR»
	'''
}
