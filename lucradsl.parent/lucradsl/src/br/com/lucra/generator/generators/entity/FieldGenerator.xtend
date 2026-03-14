package br.com.lucra.generator.generators.entity

import br.com.lucra.generator.generators.record.RecordAttributeGenerator
import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.lucraDSL.Element
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.RecordDsl
import br.com.lucra.utils.ImportManager

class FieldGenerator {

	val entityAttributeAnnotationGenerator = new EntityAttributeAnnotationGenerator()
	val entityAttributeGenerator = new EntityAttributeGenerator()
	val recordAttributeGenerator = new RecordAttributeGenerator()

	def generateFields(Element element, ImportManager importManager, ArtifactType artifactType) {
		switch element {
			Entity: generateClassFields(element, importManager, artifactType)
			RecordDsl: generateRecordFields(element, importManager, artifactType)
			default:
				throw new IllegalArgumentException(
					String.format("%s - Unsupported element '%s'", this.getClass.simpleName, element.eClass.name)
				)
		}
	}

	private def generateClassFields(Entity entity, ImportManager importManager, ArtifactType artifactType) {
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

	private def generateRecordFields(RecordDsl recordDsl, ImportManager importManager, ArtifactType artifactType) {
		val fields = recordDsl.fields

		'''
			«FOR field : fields SEPARATOR ',\n'»
				«recordAttributeGenerator.generateField(field, importManager, artifactType).toString.trim»
			«ENDFOR»
		'''
	}
}
