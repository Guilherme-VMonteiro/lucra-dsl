package br.com.lucra.generator.generators.entity;

import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EntityField;
import br.com.lucra.utils.ImportManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class EntityFieldGenerator {
  private final EntityAttributeAnnotationGenerator entityAttributeAnnotationGenerator = new EntityAttributeAnnotationGenerator();

  private final EntityAttributeGenerator entityAttributeGenerator = new EntityAttributeGenerator();

  public CharSequence generateFields(final Entity entity, final ImportManager importManager) {
    CharSequence _xblockexpression = null;
    {
      final Function1<EntityField, String> _function = (EntityField it) -> {
        return it.getName();
      };
      final String fieldNames = IterableExtensions.join(ListExtensions.<EntityField, String>map(entity.getFields(), _function), ", ");
      System.out.println(String.format("generateFields entity: \'%s\'. Fields: \'[%s]\'", entity.getName(), fieldNames));
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<EntityField> _fields = entity.getFields();
        for(final EntityField field : _fields) {
          _builder.newLine();
          _builder.append("\t");
          CharSequence _generateFieldAnnotation = this.entityAttributeAnnotationGenerator.generateFieldAnnotation(field, importManager);
          _builder.append(_generateFieldAnnotation, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          Object _generateField = this.entityAttributeGenerator.generateField(field, importManager);
          _builder.append(_generateField, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
