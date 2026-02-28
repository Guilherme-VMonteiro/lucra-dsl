package br.com.lucra.generator

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.ClassUtils
import br.com.lucra.lucraDSL.Entity
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class RepositoryGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ClassUtils.generateFilePath(entity, ArtifactType.REPOSITORY).toString(),
				entity.compile
			)
		}
	}

	private def compile(Entity entity) {
		val packagePath = ClassUtils.generatePackagePath(entity, ArtifactType.REPOSITORY)
		val repositoryName = ClassUtils.generateClassName(entity, ArtifactType.REPOSITORY)
		val entityClassName = ClassUtils.generateClassName(entity, ArtifactType.DOMAIN_CLASS)

		'''
			package «packagePath»;
			
			import org.springframework.data.jpa.repository.JpaRepository;
			import org.springframework.stereotype.Repository;
			import java.util.UUID;
			
			@Repository
			public interface «repositoryName» extends JpaRepository<«entityClassName», UUID> {
			}
		'''
	}
}