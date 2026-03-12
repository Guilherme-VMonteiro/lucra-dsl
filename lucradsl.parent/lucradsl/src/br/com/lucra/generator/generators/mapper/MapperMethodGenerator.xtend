package br.com.lucra.generator.generators.mapper

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.lucraDSL.ComplexTypeRef
import br.com.lucra.lucraDSL.Entity
import br.com.lucra.lucraDSL.EntityField
import br.com.lucra.lucraDSL.EnumDsl
import br.com.lucra.lucraDSL.PrimitiveType
import br.com.lucra.utils.ImportManager

class MapperMethodGenerator {
	
	def generateMethods(
		Entity entity,
		ImportManager importManager
	) {
		
		importManager.addImport("static java.util.Objects.isNull")
		importManager.addImport("java.util.List")
		
		val entityClassName = ClassNameResolver.resolve(entity, ArtifactType.DOMAIN_CLASS)
		val dtoClassName = ClassNameResolver.resolve(entity, ArtifactType.DTO)
		val toTargetMappings = generateMappings(entity, true)
		val toSourceMappings = generateMappings(entity, false)
		
		'''
			@Override
			public «dtoClassName» toTarget(«entityClassName» source) {
				if (isNull(source)) return null;
				
				return «dtoClassName».builder()
					«toTargetMappings»
					.build();
			}
			
			@Override
			public «entityClassName» toSource(«dtoClassName» target) {
				if (isNull(target)) return null;
				
				return «entityClassName».builder()
					«toSourceMappings»
					.build();
			}
		'''
	}

	def generateDependencyFields(Entity entity, ImportManager importManager) {
		val dependencies = entity.fields
			.filter[omitDto === null]
			.map[getRelatedEntity]
			.filter[it !== null && it !== entity]
			.toSet

		if (dependencies.empty) {
			return ''
		}

		'''
			«FOR relatedEntity : dependencies»
				«addMapperImport(relatedEntity, importManager)»
				private final «ClassNameResolver.resolve(relatedEntity, ArtifactType.MAPPER)» «mapperFieldName(relatedEntity)»;
			«ENDFOR»
		'''
	}

	private def generateMappings(Entity entity, boolean toTarget) {
		val fields = entity.fields.filter[omitDto === null]

		'''
			«FOR field : fields»
				«val assignment = field.generateFieldAssignment(entity, toTarget)»
				«IF !assignment.empty»
					«assignment»
				«ENDIF»
			«ENDFOR»
		'''
	}

	private def generateFieldAssignment(EntityField field, Entity currentEntity, boolean toTarget) {
		if (!isCompatible(field)) {
			return ''
		}

		val sourceVar = if (toTarget) "source" else "target"
		val accessExpr = sourceAccessor(field, sourceVar)
		val mapperMethod = if (toTarget) "toTarget" else "toSource"
		val relatedEntity = field.getRelatedEntity

		if (field.list) {
			if (relatedEntity !== null) {
				val mapperRef = mapperRef(currentEntity, relatedEntity)

				return '''.«field.name»(isNull(«accessExpr») ? List.of() : «accessExpr».stream().map(«mapperRef»::«mapperMethod»).toList())'''
			}

			return '''.«field.name»(isNull(«accessExpr») ? List.of() : «accessExpr».stream().toList())'''
		}

		if (relatedEntity !== null) {
			val mapperRef = mapperRef(currentEntity, relatedEntity)

			return '''.«field.name»(isNull(«accessExpr») ? null : «mapperRef».«mapperMethod»(«accessExpr»))'''
		}

		return '''.«field.name»(«accessExpr»)'''
	}

	private def sourceAccessor(EntityField field, String sourceVar) {
		val accessorPrefix = if (field.isPrimitiveBoolean && !field.list) "is" else "get"
		return '''«sourceVar».«accessorPrefix»«field.name.toFirstUpper»()'''
	}

	private def mapperRef(Entity currentEntity, Entity relatedEntity) {
		if (relatedEntity === currentEntity) {
			return "this"
		}

		mapperFieldName(relatedEntity)
	}

	private def mapperFieldName(Entity relatedEntity) {
		ClassNameResolver.resolve(relatedEntity, ArtifactType.MAPPER).toFirstLower
	}

	private def addMapperImport(Entity relatedEntity, ImportManager importManager) {
		importManager.addImport(ClassNameResolver.resolveFullyQualifiedName(relatedEntity, ArtifactType.MAPPER))
		""
	}

	private def getRelatedEntity(EntityField field) {
		if (!(field.type instanceof ComplexTypeRef)) {
			return null
		}

		val complexType = field.type as ComplexTypeRef
		if (complexType.type instanceof Entity) {
			return complexType.type as Entity
		}

		null
	}

	private def isCompatible(EntityField field) {
		switch field.type {
			PrimitiveType: true
			ComplexTypeRef:
				switch (field.type as ComplexTypeRef).type {
					Entity: true
					EnumDsl: true
					default: false
				}
			default: false
		}
	}

	private def isPrimitiveBoolean(EntityField field) {
		if (!(field.type instanceof PrimitiveType)) {
			return false
		}

		(field.type as PrimitiveType).name == "boolean"
	}
}