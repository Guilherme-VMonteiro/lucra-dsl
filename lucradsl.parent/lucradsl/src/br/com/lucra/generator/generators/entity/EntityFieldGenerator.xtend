package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.utils.ImportManager

class EntityFieldGenerator {

	val entityAttributeAnnotationGenerator = new EntityAttributeAnnotationGenerator()
	val entityAttributeGenerator = new EntityAttributeGenerator()

	def generateFields(Entity entity, ImportManager importManager, ArtifactType artifactType) {
		
		val fields = switch artifactType {
			case DTO: entity.fields.filter[omitDto === null]
			default: entity.fields
		}
		

		'''
			«FOR field : fields»
				
					«entityAttributeAnnotationGenerator.generateFieldAnnotation(field, importManager, artifactType)»
					«entityAttributeGenerator.generateField(field, importManager, artifactType)»
			«ENDFOR»
		'''
	}

}
