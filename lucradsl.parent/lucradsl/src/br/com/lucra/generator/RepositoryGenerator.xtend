package br.com.lucra.generator

import br.com.lucra.generator.utils.ArtifactType
import br.com.lucra.generator.utils.helpers.ClassNameResolver
import br.com.lucra.generator.utils.helpers.artifactPath.ArtifactPathResolver
import br.com.lucra.generator.utils.helpers.packagePath.PackagePathResolver
import br.com.lucra.lucraDSL.Entity
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class RepositoryGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (entity : resource.allContents.toIterable.filter(Entity)) {
			fsa.generateFile(
				ArtifactPathResolver.generateFilePath(entity, ArtifactType.REPOSITORY).toString(),
				entity.compile
			)
		}
	}

	private def compile(Entity entity) {
		val packagePath = PackagePathResolver.resolve(entity, ArtifactType.REPOSITORY)
		val repositoryName = ClassNameResolver.resolve(entity, ArtifactType.REPOSITORY)
		val entityClassName = ClassNameResolver.resolve(entity, ArtifactType.DOMAIN_CLASS)

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
