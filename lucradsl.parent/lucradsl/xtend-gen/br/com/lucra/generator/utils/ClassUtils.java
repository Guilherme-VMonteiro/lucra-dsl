package br.com.lucra.generator.utils;

import br.com.lucra.generator.generators.entity.EntityClassAnnotationGenerator;
import br.com.lucra.generator.generators.entity.EntityFieldGenerator;
import br.com.lucra.generator.generators.enums.EnumGenerator;
import br.com.lucra.lucraDSL.Element;
import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EnumDsl;
import br.com.lucra.utils.Constants;
import br.com.lucra.utils.ImportManager;
import br.com.lucra.utils.StringUtils;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ClassUtils {
  private static final StringUtils stringUtils = new StringUtils();

  private static final EntityClassAnnotationGenerator entityClassAnnotationGenerator = new EntityClassAnnotationGenerator();

  private static final EntityFieldGenerator entityFieldGenerator = new EntityFieldGenerator();

  private static final EnumGenerator enumGenerator = new EnumGenerator();

  public static CharSequence generateFilePath(final Element element) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Constants.serverGenBasePath);
      String _name = ((Entity)element).getName();
      _builder.append(_name);
      _builder.append("/");
      CharSequence _generateClassName = ClassUtils.generateClassName(element);
      _builder.append(_generateClassName);
      _builder.append(".java");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(Constants.serverGenBasePath);
        _builder.append("enums/");
        CharSequence _generateClassName = ClassUtils.generateClassName(element);
        _builder.append(_generateClassName);
        _builder.append(".java");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      String _format = String.format("Unsupported Element: \'%s\'", element.eClass().getName());
      throw new IllegalArgumentException(_format);
    }
    return _switchResult;
  }

  public static CharSequence generatePackagePath(final Element element) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Constants.serverGenBasePackage);
      String _name = ((Entity)element).getName();
      _builder.append(_name);
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(Constants.serverGenBasePackage);
        _builder.append("enums");
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }

  public static CharSequence generateClassName(final Element element) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _capitalize = ClassUtils.stringUtils.capitalize(((Entity)element).getName());
      _builder.append(_capitalize);
      _builder.append("Entity");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _capitalize = ClassUtils.stringUtils.capitalize(((EnumDsl)element).getName());
        _builder.append(_capitalize);
        _builder.append("Enum");
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }

  public static String generateImport(final Element element) {
    CharSequence _generatePackagePath = ClassUtils.generatePackagePath(element);
    String _plus = (_generatePackagePath + ".");
    CharSequence _generateClassName = ClassUtils.generateClassName(element);
    return (_plus + _generateClassName);
  }

  public static CharSequence getClassType(final Element element) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("enum");
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }

  public static CharSequence generateClassAnnotations(final Element element, final ImportManager importManager) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateClassAnnotations = ClassUtils.entityClassAnnotationGenerator.generateClassAnnotations(((Entity)element), importManager);
      _builder.append(_generateClassAnnotations);
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }

  public static CharSequence generateClassFields(final Element element, final ImportManager importManager) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof Entity) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateFields = ClassUtils.entityFieldGenerator.generateFields(((Entity)element), importManager);
      _builder.append(_generateFields);
      _switchResult = _builder;
    }
    if (!_matched) {
      if (element instanceof EnumDsl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _generateFields = ClassUtils.enumGenerator.generateFields(((EnumDsl)element));
        _builder.append(_generateFields);
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }

  public static CharSequence generateClassImports(final Element element, final ImportManager importManager) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (element instanceof EnumDsl) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _switchResult = _builder;
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _render = importManager.render();
      _builder.append(_render);
      _builder.newLineIfNotEmpty();
      _switchResult = _builder;
    }
    return _switchResult;
  }
}
