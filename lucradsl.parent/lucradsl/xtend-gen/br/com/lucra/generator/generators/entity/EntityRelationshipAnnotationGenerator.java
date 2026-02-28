package br.com.lucra.generator.generators.entity;

import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EntityField;
import br.com.lucra.lucraDSL.RelationType;
import br.com.lucra.utils.ImportManager;
import br.com.lucra.utils.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EntityRelationshipAnnotationGenerator {
  private final StringUtils stringUtils = new StringUtils();

  public String generateRelationshipAnnotations(final EntityField field, final ImportManager importManager) {
    RelationType _relation = field.getRelation();
    if (_relation != null) {
      switch (_relation) {
        case CONTAINS:
          return this.generateContainsAnnotations(field, importManager);
        case CONTAINED:
          return this.generateContainedAnnotations(field, importManager);
        case REFERS:
          return this.generateRefersAnnotations(field, importManager);
        default:
          String _format = String.format("Unsupported relationship. Field: %s. Relationship: %s", field.getName(), field.getRelation());
          throw new IllegalArgumentException(_format);
      }
    } else {
      String _format = String.format("Unsupported relationship. Field: %s. Relationship: %s", field.getName(), field.getRelation());
      throw new IllegalArgumentException(_format);
    }
  }

  private String generateContainsAnnotations(final EntityField field, final ImportManager importManager) {
    boolean _isList = field.isList();
    if (_isList) {
      importManager.addImports(
        "jakarta.persistence.OneToMany", 
        "jakarta.persistence.CascadeType");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OneToMany(mappedBy = \"");
      String _mappedBy = this.getMappedBy(field);
      _builder.append(_mappedBy);
      _builder.append("\", cascade = CascadeType.ALL, orphanRemoval = true)");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    } else {
      importManager.addImports(
        "jakarta.persistence.OneToOne", 
        "jakarta.persistence.CascadeType");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@OneToOne(mappedBy = \"");
      String _mappedBy_1 = this.getMappedBy(field);
      _builder_1.append(_mappedBy_1);
      _builder_1.append("\", cascade = CascadeType.ALL, orphanRemoval = true)");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
  }

  private String generateContainedAnnotations(final EntityField field, final ImportManager importManager) {
    boolean _isList = field.isList();
    if (_isList) {
      String _format = String.format(
        "A \'contained\' relationship cannot be a list (*). The entity holding the Foreign Key can only point to a single parent. Field: %s", 
        field.getName());
      throw new IllegalArgumentException(_format);
    }
    importManager.addImports(
      "jakarta.persistence.ManyToOne", 
      "jakarta.persistence.JoinColumn");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@ManyToOne");
    _builder.newLine();
    _builder.append("@JoinColumn(name = \"");
    String _joinColumnName = this.getJoinColumnName(field.getName());
    _builder.append(_joinColumnName);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  private String generateRefersAnnotations(final EntityField field, final ImportManager importManager) {
    boolean _isList = field.isList();
    if (_isList) {
      String _format = String.format(
        "A \'refers\' relationship cannot be a list (*). Since ManyToMany is disabled and the current entity holds the ID, it must be a single reference. Field: %s", 
        field.getName());
      throw new IllegalArgumentException(_format);
    }
    importManager.addImports(
      "jakarta.persistence.ManyToOne", 
      "jakarta.persistence.JoinColumn");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@ManyToOne");
    _builder.newLine();
    _builder.append("@JoinColumn(name = \"");
    String _joinColumnName = this.getJoinColumnName(field.getName());
    _builder.append(_joinColumnName);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  private String getMappedBy(final EntityField field) {
    EObject _eContainer = field.eContainer();
    final Entity parentEntity = ((Entity) _eContainer);
    return StringExtensions.toFirstLower(parentEntity.getName());
  }

  private String getJoinColumnName(final String fieldName) {
    String _snakeCase = this.stringUtils.toSnakeCase(fieldName);
    return (_snakeCase + "_id");
  }
}
