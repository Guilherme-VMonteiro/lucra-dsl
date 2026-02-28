package br.com.lucra.generator.generators.entity

import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager

class EntityFieldGenerator {

	val entityAttributeAnnotationGenerator = new EntityAttributeAnnotationGenerator()
	val entityAttributeGenerator = new EntityAttributeGenerator()

	def generateFields(Entity entity, ImportManager importManager) {

		val fieldNames = entity.fields.map[name].join(", ")
		System.out.println(String.format("generateFields entity: '%s'. Fields: '[%s]'", entity.name, fieldNames))

		'''
			«FOR field : entity.fields»
				
					«entityAttributeAnnotationGenerator.generateFieldAnnotation(field, importManager)»
					«entityAttributeGenerator.generateField(field, importManager)»
			«ENDFOR»
		'''
	}

}
