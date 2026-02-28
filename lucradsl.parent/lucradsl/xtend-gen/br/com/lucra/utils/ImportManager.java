package br.com.lucra.utils;

import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class ImportManager {
  private final TreeSet<String> imports = new TreeSet<String>();

  public void addImport(final String qualifiedName) {
    if (((qualifiedName != null) && (!qualifiedName.isEmpty()))) {
      this.imports.add(qualifiedName);
    }
  }

  public void addImports(final String... qualifiedNames) {
    final Consumer<String> _function = (String it) -> {
      this.addImport(it);
    };
    ((List<String>)Conversions.doWrapArray(qualifiedNames)).forEach(_function);
  }

  public CharSequence render() {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final String imp : this.imports) {
        _builder.append("import ");
        _builder.append(imp);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
