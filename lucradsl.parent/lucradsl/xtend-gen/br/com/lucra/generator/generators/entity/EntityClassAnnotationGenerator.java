package br.com.lucra.generator.generators.entity;

import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.utils.ImportManager;
import br.com.lucra.utils.StringUtils;
import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EntityClassAnnotationGenerator {
  private final StringUtils stringUtils = new StringUtils();

  public CharSequence generateClassAnnotations(final Entity entity, final ImportManager imports) {
    CharSequence _xblockexpression = null;
    {
      imports.addImports(
        "lombok.Getter", 
        "lombok.Setter", 
        "lombok.AllArgsConstructor", 
        "lombok.NoArgsConstructor", 
        "lombok.Builder", 
        "lombok.EqualsAndHashCode", 
        "jakarta.persistence.Entity");
      boolean _isCamelCase = this.stringUtils.isCamelCase(entity.getName());
      if (_isCamelCase) {
        imports.addImport("jakarta.persistence.Table");
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Getter");
      _builder.newLine();
      _builder.append("@Setter");
      _builder.newLine();
      _builder.append("@AllArgsConstructor");
      _builder.newLine();
      _builder.append("@NoArgsConstructor");
      _builder.newLine();
      _builder.append("@Builder");
      _builder.newLine();
      _builder.append("@EqualsAndHashCode(onlyExplicitlyIncluded = true)");
      _builder.newLine();
      {
        boolean _isCamelCase_1 = this.stringUtils.isCamelCase(entity.getName());
        if (_isCamelCase_1) {
          _builder.append("@Table(");
          String _tableAttributes = this.tableAttributes(entity);
          _builder.append(_tableAttributes);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("@Entity");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  private String tableAttributes(final Entity entity) {
    String _xblockexpression = null;
    {
      final ArrayList<Object> parts = CollectionLiterals.<Object>newArrayList();
      boolean _isCamelCase = this.stringUtils.isCamelCase(entity.getName());
      if (_isCamelCase) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("name = \"");
        String _snakeCase = this.stringUtils.toSnakeCase(entity.getName());
        _builder.append(_snakeCase);
        _builder.append("\"");
        parts.add(_builder.toString());
      }
      _xblockexpression = IterableExtensions.join(parts, ", ");
    }
    return _xblockexpression;
  }
}
