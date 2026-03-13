package br.com.lucra.ui.highlighting;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class LucraHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
    public static final String ENTITY = "entity";
    public static final String ENUM = "enum";
    public static final String PRIMITIVE_TYPE = "primitiveType";
    public static final String COMPLEX_TYPE_REF = "complexTypeRef";

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);

        acceptor.acceptDefaultHighlighting(
            ENTITY,
            "Entity",
            entityTextStyle()
        );

        acceptor.acceptDefaultHighlighting(
            ENUM,
            "Enum",
            keywordAccentTextStyle()
        );

        acceptor.acceptDefaultHighlighting(
            PRIMITIVE_TYPE,
            "Primitive Type",
            keywordAccentTextStyle()
        );

        acceptor.acceptDefaultHighlighting(
            COMPLEX_TYPE_REF,
            "Complex Type Reference",
            complexTypeRefTextStyle()
        );
    }

    @Override
    public TextStyle keywordTextStyle() {
        return keywordAccentTextStyle();
    }

    public TextStyle entityTextStyle() {
        return keywordAccentTextStyle();
    }

    public TextStyle keywordAccentTextStyle() {
        TextStyle style = defaultTextStyle().copy();
        style.setColor(new RGB(255, 167, 89));
        style.setStyle(SWT.BOLD);

        return style;
    }

    public TextStyle complexTypeRefTextStyle() {
        TextStyle style = defaultTextStyle().copy();
        style.setColor(new RGB(115, 208, 255));

        return style;
    }
}
