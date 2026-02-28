package br.com.lucra.generator.generators.entity;

import br.com.lucra.generator.utils.TypeUtils;
import br.com.lucra.lucraDSL.EntityField;
import br.com.lucra.utils.ImportManager;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EntityAttributeGenerator {
  private final TypeUtils typeUtils = new TypeUtils();

  public Object generateField(final EntityField field, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _resolveJavaTypeDeclaration = this.resolveJavaTypeDeclaration(field, importManager);
    _builder.append(_resolveJavaTypeDeclaration);
    _builder.append(" ");
    String _name = field.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private String resolveJavaTypeDeclaration(final EntityField field, final ImportManager importManager) {
    CharSequence fieldType = this.typeUtils.resolveTypeName(field, importManager);
    boolean _isList = field.isList();
    if (_isList) {
      importManager.addImport("java.util.List");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("List<");
      _builder.append(fieldType);
      _builder.append(">");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(fieldType);
    return _builder_1.toString();
  }
}
