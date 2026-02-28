package br.com.lucra.generator.generators.enums;

import br.com.lucra.lucraDSL.EnumDsl;
import br.com.lucra.lucraDSL.EnumLiteral;
import br.com.lucra.utils.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EnumGenerator {
  private final StringUtils stringUtils = new StringUtils();

  public CharSequence generateFields(final EnumDsl enumm) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<EnumLiteral> _literals = enumm.getLiterals();
      boolean _hasElements = false;
      for(final EnumLiteral literal : _literals) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",\n", "");
        }
        String _trim = this.generateLiteral(literal).toString().trim();
        _builder.append(_trim);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private CharSequence generateLiteral(final EnumLiteral literal) {
    StringConcatenation _builder = new StringConcatenation();
    String _upperCaseSpaced = this.stringUtils.toUpperCaseSpaced(literal.getName());
    _builder.append(_upperCaseSpaced);
    return _builder;
  }
}
