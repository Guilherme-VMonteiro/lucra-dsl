package br.com.lucra.generator.utils;

import br.com.lucra.lucraDSL.ComplexTypeRef;
import br.com.lucra.lucraDSL.Element;
import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EntityField;
import br.com.lucra.lucraDSL.EnumDsl;
import br.com.lucra.lucraDSL.PrimitiveType;
import br.com.lucra.lucraDSL.Type;
import br.com.lucra.utils.ImportManager;

@SuppressWarnings("all")
public class TypeUtils {
  public CharSequence resolveTypeName(final EntityField field, final ImportManager importManager) {
    final Type type = field.getType();
    boolean _matched = false;
    if ((type instanceof PrimitiveType)) {
      _matched=true;
      return this.getPrimitiveType(((PrimitiveType) type), importManager);
    }
    if (!_matched) {
      if ((type instanceof ComplexTypeRef)) {
        _matched=true;
        return this.getComplexType(((ComplexTypeRef) type), importManager);
      }
    }
    return null;
  }

  private String getPrimitiveType(final PrimitiveType type, final ImportManager importManager) {
    String _xblockexpression = null;
    {
      final String typeName = type.getName();
      String _switchResult = null;
      if (typeName != null) {
        switch (typeName) {
          case "string":
            return "String";
          case "number":
            _switchResult = "double";
            break;
          case "date":
            importManager.addImport("java.time.LocalDate");
            return "LocalDate";
          case "uuid":
            importManager.addImport("java.util.UUID");
            return "UUID";
          case "money":
            importManager.addImport("java.math.BigDecimal");
            return "BigDecimal";
          case "boolean":
            return "boolean";
          default:
            String _format = String.format("Unsupported primitive type. Type: \'%s\'", typeName);
            throw new IllegalArgumentException(_format);
        }
      } else {
        String _format = String.format("Unsupported primitive type. Type: \'%s\'", typeName);
        throw new IllegalArgumentException(_format);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private CharSequence getComplexType(final ComplexTypeRef ref, final ImportManager importManager) {
    final Element type = ref.getType();
    boolean _matched = false;
    if ((type instanceof Entity)) {
      _matched=true;
      importManager.addImport(ClassUtils.generateImport(type));
      return ClassUtils.generateClassName(type);
    }
    if (!_matched) {
      if ((type instanceof EnumDsl)) {
        _matched=true;
        importManager.addImport(ClassUtils.generateImport(type));
        return ClassUtils.generateClassName(type);
      }
    }
    return null;
  }
}
