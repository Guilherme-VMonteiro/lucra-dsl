package br.com.lucra.ui.highlighting;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;

import br.com.lucra.lucraDSL.ComplexTypeRef;
import br.com.lucra.lucraDSL.Entity;
import br.com.lucra.lucraDSL.EnumDsl;
import br.com.lucra.lucraDSL.LucraDSLPackage;
import br.com.lucra.lucraDSL.PrimitiveType;

public class SemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator{

	@Override
    protected boolean highlightElement(
            EObject object,
            IHighlightedPositionAcceptor acceptor,
            CancelIndicator cancelIndicator) {

        if (object instanceof Entity) {
            highlightKeyword(object, "entity", LucraHighlightingConfiguration.ENTITY, acceptor);
        }

        if (object instanceof EnumDsl) {
            highlightKeyword(object, "enum", LucraHighlightingConfiguration.ENUM, acceptor);
        }

        if (object instanceof PrimitiveType) {
            highlightFeature(
                acceptor,
                object,
                LucraDSLPackage.Literals.PRIMITIVE_TYPE__NAME,
                LucraHighlightingConfiguration.PRIMITIVE_TYPE
            );
        }

        if (object instanceof ComplexTypeRef) {
            highlightFeature(
                acceptor,
                object,
                LucraDSLPackage.Literals.COMPLEX_TYPE_REF__TYPE,
                LucraHighlightingConfiguration.COMPLEX_TYPE_REF
            );
        }

        return false;
    }

    private void highlightKeyword(
            EObject object,
            String keyword,
            String highlightingId,
            IHighlightedPositionAcceptor acceptor) {

        INode elementNode = NodeModelUtils.findActualNodeFor(object);
        if (elementNode == null) {
            return;
        }

        elementNode
            .getLeafNodes()
            .forEach(leaf -> {

                if (keyword.equals(leaf.getText())) {
                    acceptor.addPosition(
                        leaf.getOffset(),
                        leaf.getLength(),
                        highlightingId
                    );
                }

            });
    }
}
