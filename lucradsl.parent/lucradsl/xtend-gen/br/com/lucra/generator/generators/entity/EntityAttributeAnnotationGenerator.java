package br.com.lucra.generator.generators.entity;

import br.com.lucra.lucraDSL.ComplexTypeRef;
import br.com.lucra.lucraDSL.Element;
import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EntityField;
import br.com.lucra.lucraDSL.EnumDsl;
import br.com.lucra.lucraDSL.PrimitiveType;
import br.com.lucra.lucraDSL.Type;
import br.com.lucra.utils.ImportManager;
import br.com.lucra.utils.StringUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EntityAttributeAnnotationGenerator {
  private final StringUtils stringUtils = new StringUtils();

  private final EntityRelationshipAnnotationGenerator entityRelationshipAnnotationGenerator = new EntityRelationshipAnnotationGenerator();

  public CharSequence generateFieldAnnotation(final EntityField field, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      final Type type = field.getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if ((type instanceof ComplexTypeRef)) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateComplexTypeAnnotations = this.generateComplexTypeAnnotations(field, importManager);
        _builder.append(_generateComplexTypeAnnotations);
        _switchResult = _builder;
      }
      if (!_matched) {
        if ((type instanceof PrimitiveType)) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          String _generatePrimitiveTypeAnnotations = this.generatePrimitiveTypeAnnotations(field, importManager);
          _builder_1.append(_generatePrimitiveTypeAnnotations);
          _switchResult = _builder_1;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private String generatePrimitiveTypeAnnotations(final EntityField field, final ImportManager importManager) {
    boolean _isId = this.isId(field);
    if (_isId) {
      return this.generateIdAnnotations(importManager);
    }
    if ((field.isNullable() || this.stringUtils.isCamelCase(field.getName()))) {
      return this.generateColumnAnnotation(field, importManager);
    }
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }

  private String generateComplexTypeAnnotations(final EntityField field, final ImportManager importManager) {
    Type _type = field.getType();
    final Element type = ((ComplexTypeRef) _type).getType();
    System.out.println(String.format("generateComplexTypeAnnotations ComplexTypeRef: \'%s\'", type.eClass().getName()));
    boolean _matched = false;
    if ((type instanceof Entity)) {
      _matched=true;
      return this.entityRelationshipAnnotationGenerator.generateRelationshipAnnotations(field, importManager);
    }
    if (!_matched) {
      if ((type instanceof EnumDsl)) {
        _matched=true;
        return this.generateEnumeratedAnnotation(importManager);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }

  private String generateIdAnnotations(final ImportManager importManager) {
    importManager.addImports(
      "jakarta.persistence.Id", 
      "jakarta.persistence.GeneratedValue", 
      "jakarta.persistence.GenerationType", 
      "lombok.EqualsAndHashCode");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Id");
    _builder.newLine();
    _builder.append("@GeneratedValue(strategy = GenerationType.UUID)");
    _builder.newLine();
    _builder.append("@EqualsAndHashCode.Include");
    _builder.newLine();
    return _builder.toString();
  }

  private String generateColumnAnnotation(final EntityField field, final ImportManager importManager) {
    importManager.addImport("jakarta.persistence.Column");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Column(");
    String _columnAnnotationParameters = this.getColumnAnnotationParameters(field);
    _builder.append(_columnAnnotationParameters);
    _builder.append(")");
    return _builder.toString();
  }

  private String getColumnAnnotationParameters(final EntityField field) {
    String _xblockexpression = null;
    {
      final ArrayList<Object> parts = CollectionLiterals.<Object>newArrayList();
      boolean _isCamelCase = this.stringUtils.isCamelCase(field.getName());
      if (_isCamelCase) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("name = \"");
        String _snakeCase = this.stringUtils.toSnakeCase(field.getName());
        _builder.append(_snakeCase);
        _builder.append("\"");
        parts.add(_builder.toString());
      }
      boolean _isNullable = field.isNullable();
      if (_isNullable) {
        parts.add("nullable = true");
      }
      _xblockexpression = IterableExtensions.join(parts, ", ");
    }
    return _xblockexpression;
  }

  private String generateEnumeratedAnnotation(final ImportManager importManager) {
    importManager.addImports(
      "jakarta.persistence.Enumerated", 
      "jakarta.persistence.EnumType");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Enumerated(EnumType.STRING)");
    return _builder.toString();
  }

  private boolean isId(final EntityField field) {
    return ((Objects.equals(field.getName(), "id") && (field.getType() instanceof PrimitiveType)) && Objects.equals(((PrimitiveType) field.getType()).getName(), "uuid"));
  }
}
