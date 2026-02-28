package br.com.lucra.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import br.com.lucra.services.LucraDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLucraDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'number'", "'date'", "'uuid'", "'money'", "'boolean'", "'contains'", "'contained'", "'refers'", "'entity'", "'{'", "'}'", "'enum'", "'*'", "'?'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalLucraDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLucraDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLucraDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLucraDSL.g"; }


    	private LucraDSLGrammarAccess grammarAccess;

    	public void setGrammarAccess(LucraDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleLucraDSL"
    // InternalLucraDSL.g:53:1: entryRuleLucraDSL : ruleLucraDSL EOF ;
    public final void entryRuleLucraDSL() throws RecognitionException {
        try {
            // InternalLucraDSL.g:54:1: ( ruleLucraDSL EOF )
            // InternalLucraDSL.g:55:1: ruleLucraDSL EOF
            {
             before(grammarAccess.getLucraDSLRule()); 
            pushFollow(FOLLOW_1);
            ruleLucraDSL();

            state._fsp--;

             after(grammarAccess.getLucraDSLRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLucraDSL"


    // $ANTLR start "ruleLucraDSL"
    // InternalLucraDSL.g:62:1: ruleLucraDSL : ( ( rule__LucraDSL__ElementsAssignment )* ) ;
    public final void ruleLucraDSL() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:66:2: ( ( ( rule__LucraDSL__ElementsAssignment )* ) )
            // InternalLucraDSL.g:67:2: ( ( rule__LucraDSL__ElementsAssignment )* )
            {
            // InternalLucraDSL.g:67:2: ( ( rule__LucraDSL__ElementsAssignment )* )
            // InternalLucraDSL.g:68:3: ( rule__LucraDSL__ElementsAssignment )*
            {
             before(grammarAccess.getLucraDSLAccess().getElementsAssignment()); 
            // InternalLucraDSL.g:69:3: ( rule__LucraDSL__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==20||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLucraDSL.g:69:4: rule__LucraDSL__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__LucraDSL__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getLucraDSLAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLucraDSL"


    // $ANTLR start "entryRuleType"
    // InternalLucraDSL.g:78:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalLucraDSL.g:79:1: ( ruleType EOF )
            // InternalLucraDSL.g:80:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalLucraDSL.g:87:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:91:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalLucraDSL.g:92:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalLucraDSL.g:92:2: ( ( rule__Type__Alternatives ) )
            // InternalLucraDSL.g:93:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalLucraDSL.g:94:3: ( rule__Type__Alternatives )
            // InternalLucraDSL.g:94:4: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalLucraDSL.g:103:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalLucraDSL.g:104:1: ( rulePrimitiveType EOF )
            // InternalLucraDSL.g:105:1: rulePrimitiveType EOF
            {
             before(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getPrimitiveTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalLucraDSL.g:112:1: rulePrimitiveType : ( ( rule__PrimitiveType__Group__0 ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:116:2: ( ( ( rule__PrimitiveType__Group__0 ) ) )
            // InternalLucraDSL.g:117:2: ( ( rule__PrimitiveType__Group__0 ) )
            {
            // InternalLucraDSL.g:117:2: ( ( rule__PrimitiveType__Group__0 ) )
            // InternalLucraDSL.g:118:3: ( rule__PrimitiveType__Group__0 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getGroup()); 
            // InternalLucraDSL.g:119:3: ( rule__PrimitiveType__Group__0 )
            // InternalLucraDSL.g:119:4: rule__PrimitiveType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleComplexTypeRef"
    // InternalLucraDSL.g:128:1: entryRuleComplexTypeRef : ruleComplexTypeRef EOF ;
    public final void entryRuleComplexTypeRef() throws RecognitionException {
        try {
            // InternalLucraDSL.g:129:1: ( ruleComplexTypeRef EOF )
            // InternalLucraDSL.g:130:1: ruleComplexTypeRef EOF
            {
             before(grammarAccess.getComplexTypeRefRule()); 
            pushFollow(FOLLOW_1);
            ruleComplexTypeRef();

            state._fsp--;

             after(grammarAccess.getComplexTypeRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComplexTypeRef"


    // $ANTLR start "ruleComplexTypeRef"
    // InternalLucraDSL.g:137:1: ruleComplexTypeRef : ( ( rule__ComplexTypeRef__TypeAssignment ) ) ;
    public final void ruleComplexTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:141:2: ( ( ( rule__ComplexTypeRef__TypeAssignment ) ) )
            // InternalLucraDSL.g:142:2: ( ( rule__ComplexTypeRef__TypeAssignment ) )
            {
            // InternalLucraDSL.g:142:2: ( ( rule__ComplexTypeRef__TypeAssignment ) )
            // InternalLucraDSL.g:143:3: ( rule__ComplexTypeRef__TypeAssignment )
            {
             before(grammarAccess.getComplexTypeRefAccess().getTypeAssignment()); 
            // InternalLucraDSL.g:144:3: ( rule__ComplexTypeRef__TypeAssignment )
            // InternalLucraDSL.g:144:4: rule__ComplexTypeRef__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeRef__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeRefAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexTypeRef"


    // $ANTLR start "entryRuleElement"
    // InternalLucraDSL.g:153:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalLucraDSL.g:154:1: ( ruleElement EOF )
            // InternalLucraDSL.g:155:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalLucraDSL.g:162:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:166:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalLucraDSL.g:167:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalLucraDSL.g:167:2: ( ( rule__Element__Alternatives ) )
            // InternalLucraDSL.g:168:3: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // InternalLucraDSL.g:169:3: ( rule__Element__Alternatives )
            // InternalLucraDSL.g:169:4: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleEntity"
    // InternalLucraDSL.g:178:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalLucraDSL.g:179:1: ( ruleEntity EOF )
            // InternalLucraDSL.g:180:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalLucraDSL.g:187:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:191:2: ( ( ( rule__Entity__Group__0 ) ) )
            // InternalLucraDSL.g:192:2: ( ( rule__Entity__Group__0 ) )
            {
            // InternalLucraDSL.g:192:2: ( ( rule__Entity__Group__0 ) )
            // InternalLucraDSL.g:193:3: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // InternalLucraDSL.g:194:3: ( rule__Entity__Group__0 )
            // InternalLucraDSL.g:194:4: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleEntityField"
    // InternalLucraDSL.g:203:1: entryRuleEntityField : ruleEntityField EOF ;
    public final void entryRuleEntityField() throws RecognitionException {
        try {
            // InternalLucraDSL.g:204:1: ( ruleEntityField EOF )
            // InternalLucraDSL.g:205:1: ruleEntityField EOF
            {
             before(grammarAccess.getEntityFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleEntityField();

            state._fsp--;

             after(grammarAccess.getEntityFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntityField"


    // $ANTLR start "ruleEntityField"
    // InternalLucraDSL.g:212:1: ruleEntityField : ( ( rule__EntityField__Group__0 ) ) ;
    public final void ruleEntityField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:216:2: ( ( ( rule__EntityField__Group__0 ) ) )
            // InternalLucraDSL.g:217:2: ( ( rule__EntityField__Group__0 ) )
            {
            // InternalLucraDSL.g:217:2: ( ( rule__EntityField__Group__0 ) )
            // InternalLucraDSL.g:218:3: ( rule__EntityField__Group__0 )
            {
             before(grammarAccess.getEntityFieldAccess().getGroup()); 
            // InternalLucraDSL.g:219:3: ( rule__EntityField__Group__0 )
            // InternalLucraDSL.g:219:4: rule__EntityField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EntityField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntityField"


    // $ANTLR start "entryRuleEnumDsl"
    // InternalLucraDSL.g:228:1: entryRuleEnumDsl : ruleEnumDsl EOF ;
    public final void entryRuleEnumDsl() throws RecognitionException {
        try {
            // InternalLucraDSL.g:229:1: ( ruleEnumDsl EOF )
            // InternalLucraDSL.g:230:1: ruleEnumDsl EOF
            {
             before(grammarAccess.getEnumDslRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumDsl();

            state._fsp--;

             after(grammarAccess.getEnumDslRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumDsl"


    // $ANTLR start "ruleEnumDsl"
    // InternalLucraDSL.g:237:1: ruleEnumDsl : ( ( rule__EnumDsl__Group__0 ) ) ;
    public final void ruleEnumDsl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:241:2: ( ( ( rule__EnumDsl__Group__0 ) ) )
            // InternalLucraDSL.g:242:2: ( ( rule__EnumDsl__Group__0 ) )
            {
            // InternalLucraDSL.g:242:2: ( ( rule__EnumDsl__Group__0 ) )
            // InternalLucraDSL.g:243:3: ( rule__EnumDsl__Group__0 )
            {
             before(grammarAccess.getEnumDslAccess().getGroup()); 
            // InternalLucraDSL.g:244:3: ( rule__EnumDsl__Group__0 )
            // InternalLucraDSL.g:244:4: rule__EnumDsl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumDslAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumDsl"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalLucraDSL.g:253:1: entryRuleEnumLiteral : ruleEnumLiteral EOF ;
    public final void entryRuleEnumLiteral() throws RecognitionException {
        try {
            // InternalLucraDSL.g:254:1: ( ruleEnumLiteral EOF )
            // InternalLucraDSL.g:255:1: ruleEnumLiteral EOF
            {
             before(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumLiteral();

            state._fsp--;

             after(grammarAccess.getEnumLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalLucraDSL.g:262:1: ruleEnumLiteral : ( ( rule__EnumLiteral__NameAssignment ) ) ;
    public final void ruleEnumLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:266:2: ( ( ( rule__EnumLiteral__NameAssignment ) ) )
            // InternalLucraDSL.g:267:2: ( ( rule__EnumLiteral__NameAssignment ) )
            {
            // InternalLucraDSL.g:267:2: ( ( rule__EnumLiteral__NameAssignment ) )
            // InternalLucraDSL.g:268:3: ( rule__EnumLiteral__NameAssignment )
            {
             before(grammarAccess.getEnumLiteralAccess().getNameAssignment()); 
            // InternalLucraDSL.g:269:3: ( rule__EnumLiteral__NameAssignment )
            // InternalLucraDSL.g:269:4: rule__EnumLiteral__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__EnumLiteral__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "ruleRelationType"
    // InternalLucraDSL.g:278:1: ruleRelationType : ( ( rule__RelationType__Alternatives ) ) ;
    public final void ruleRelationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:282:1: ( ( ( rule__RelationType__Alternatives ) ) )
            // InternalLucraDSL.g:283:2: ( ( rule__RelationType__Alternatives ) )
            {
            // InternalLucraDSL.g:283:2: ( ( rule__RelationType__Alternatives ) )
            // InternalLucraDSL.g:284:3: ( rule__RelationType__Alternatives )
            {
             before(grammarAccess.getRelationTypeAccess().getAlternatives()); 
            // InternalLucraDSL.g:285:3: ( rule__RelationType__Alternatives )
            // InternalLucraDSL.g:285:4: rule__RelationType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RelationType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRelationTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationType"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalLucraDSL.g:293:1: rule__Type__Alternatives : ( ( rulePrimitiveType ) | ( ruleComplexTypeRef ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:297:1: ( ( rulePrimitiveType ) | ( ruleComplexTypeRef ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=11 && LA2_0<=16)) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalLucraDSL.g:298:2: ( rulePrimitiveType )
                    {
                    // InternalLucraDSL.g:298:2: ( rulePrimitiveType )
                    // InternalLucraDSL.g:299:3: rulePrimitiveType
                    {
                     before(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:304:2: ( ruleComplexTypeRef )
                    {
                    // InternalLucraDSL.g:304:2: ( ruleComplexTypeRef )
                    // InternalLucraDSL.g:305:3: ruleComplexTypeRef
                    {
                     before(grammarAccess.getTypeAccess().getComplexTypeRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleComplexTypeRef();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getComplexTypeRefParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__PrimitiveType__NameAlternatives_1_0"
    // InternalLucraDSL.g:314:1: rule__PrimitiveType__NameAlternatives_1_0 : ( ( 'string' ) | ( 'number' ) | ( 'date' ) | ( 'uuid' ) | ( 'money' ) | ( 'boolean' ) );
    public final void rule__PrimitiveType__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:318:1: ( ( 'string' ) | ( 'number' ) | ( 'date' ) | ( 'uuid' ) | ( 'money' ) | ( 'boolean' ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            case 14:
                {
                alt3=4;
                }
                break;
            case 15:
                {
                alt3=5;
                }
                break;
            case 16:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalLucraDSL.g:319:2: ( 'string' )
                    {
                    // InternalLucraDSL.g:319:2: ( 'string' )
                    // InternalLucraDSL.g:320:3: 'string'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:325:2: ( 'number' )
                    {
                    // InternalLucraDSL.g:325:2: ( 'number' )
                    // InternalLucraDSL.g:326:3: 'number'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameNumberKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameNumberKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLucraDSL.g:331:2: ( 'date' )
                    {
                    // InternalLucraDSL.g:331:2: ( 'date' )
                    // InternalLucraDSL.g:332:3: 'date'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameDateKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameDateKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLucraDSL.g:337:2: ( 'uuid' )
                    {
                    // InternalLucraDSL.g:337:2: ( 'uuid' )
                    // InternalLucraDSL.g:338:3: 'uuid'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameUuidKeyword_1_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameUuidKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLucraDSL.g:343:2: ( 'money' )
                    {
                    // InternalLucraDSL.g:343:2: ( 'money' )
                    // InternalLucraDSL.g:344:3: 'money'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameMoneyKeyword_1_0_4()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameMoneyKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLucraDSL.g:349:2: ( 'boolean' )
                    {
                    // InternalLucraDSL.g:349:2: ( 'boolean' )
                    // InternalLucraDSL.g:350:3: 'boolean'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_1_0_5()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_1_0_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__NameAlternatives_1_0"


    // $ANTLR start "rule__Element__Alternatives"
    // InternalLucraDSL.g:359:1: rule__Element__Alternatives : ( ( ruleEntity ) | ( ruleEnumDsl ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:363:1: ( ( ruleEntity ) | ( ruleEnumDsl ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==23) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalLucraDSL.g:364:2: ( ruleEntity )
                    {
                    // InternalLucraDSL.g:364:2: ( ruleEntity )
                    // InternalLucraDSL.g:365:3: ruleEntity
                    {
                     before(grammarAccess.getElementAccess().getEntityParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEntity();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getEntityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:370:2: ( ruleEnumDsl )
                    {
                    // InternalLucraDSL.g:370:2: ( ruleEnumDsl )
                    // InternalLucraDSL.g:371:3: ruleEnumDsl
                    {
                     before(grammarAccess.getElementAccess().getEnumDslParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEnumDsl();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getEnumDslParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__RelationType__Alternatives"
    // InternalLucraDSL.g:380:1: rule__RelationType__Alternatives : ( ( ( 'contains' ) ) | ( ( 'contained' ) ) | ( ( 'refers' ) ) );
    public final void rule__RelationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:384:1: ( ( ( 'contains' ) ) | ( ( 'contained' ) ) | ( ( 'refers' ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=2;
                }
                break;
            case 19:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalLucraDSL.g:385:2: ( ( 'contains' ) )
                    {
                    // InternalLucraDSL.g:385:2: ( ( 'contains' ) )
                    // InternalLucraDSL.g:386:3: ( 'contains' )
                    {
                     before(grammarAccess.getRelationTypeAccess().getCONTAINSEnumLiteralDeclaration_0()); 
                    // InternalLucraDSL.g:387:3: ( 'contains' )
                    // InternalLucraDSL.g:387:4: 'contains'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelationTypeAccess().getCONTAINSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:391:2: ( ( 'contained' ) )
                    {
                    // InternalLucraDSL.g:391:2: ( ( 'contained' ) )
                    // InternalLucraDSL.g:392:3: ( 'contained' )
                    {
                     before(grammarAccess.getRelationTypeAccess().getCONTAINEDEnumLiteralDeclaration_1()); 
                    // InternalLucraDSL.g:393:3: ( 'contained' )
                    // InternalLucraDSL.g:393:4: 'contained'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelationTypeAccess().getCONTAINEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLucraDSL.g:397:2: ( ( 'refers' ) )
                    {
                    // InternalLucraDSL.g:397:2: ( ( 'refers' ) )
                    // InternalLucraDSL.g:398:3: ( 'refers' )
                    {
                     before(grammarAccess.getRelationTypeAccess().getREFERSEnumLiteralDeclaration_2()); 
                    // InternalLucraDSL.g:399:3: ( 'refers' )
                    // InternalLucraDSL.g:399:4: 'refers'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelationTypeAccess().getREFERSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationType__Alternatives"


    // $ANTLR start "rule__PrimitiveType__Group__0"
    // InternalLucraDSL.g:407:1: rule__PrimitiveType__Group__0 : rule__PrimitiveType__Group__0__Impl rule__PrimitiveType__Group__1 ;
    public final void rule__PrimitiveType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:411:1: ( rule__PrimitiveType__Group__0__Impl rule__PrimitiveType__Group__1 )
            // InternalLucraDSL.g:412:2: rule__PrimitiveType__Group__0__Impl rule__PrimitiveType__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PrimitiveType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group__0"


    // $ANTLR start "rule__PrimitiveType__Group__0__Impl"
    // InternalLucraDSL.g:419:1: rule__PrimitiveType__Group__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:423:1: ( ( () ) )
            // InternalLucraDSL.g:424:1: ( () )
            {
            // InternalLucraDSL.g:424:1: ( () )
            // InternalLucraDSL.g:425:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeAction_0()); 
            // InternalLucraDSL.g:426:2: ()
            // InternalLucraDSL.g:426:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group__1"
    // InternalLucraDSL.g:434:1: rule__PrimitiveType__Group__1 : rule__PrimitiveType__Group__1__Impl ;
    public final void rule__PrimitiveType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:438:1: ( rule__PrimitiveType__Group__1__Impl )
            // InternalLucraDSL.g:439:2: rule__PrimitiveType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group__1"


    // $ANTLR start "rule__PrimitiveType__Group__1__Impl"
    // InternalLucraDSL.g:445:1: rule__PrimitiveType__Group__1__Impl : ( ( rule__PrimitiveType__NameAssignment_1 ) ) ;
    public final void rule__PrimitiveType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:449:1: ( ( ( rule__PrimitiveType__NameAssignment_1 ) ) )
            // InternalLucraDSL.g:450:1: ( ( rule__PrimitiveType__NameAssignment_1 ) )
            {
            // InternalLucraDSL.g:450:1: ( ( rule__PrimitiveType__NameAssignment_1 ) )
            // InternalLucraDSL.g:451:2: ( rule__PrimitiveType__NameAssignment_1 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAssignment_1()); 
            // InternalLucraDSL.g:452:2: ( rule__PrimitiveType__NameAssignment_1 )
            // InternalLucraDSL.g:452:3: rule__PrimitiveType__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // InternalLucraDSL.g:461:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:465:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalLucraDSL.g:466:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // InternalLucraDSL.g:473:1: rule__Entity__Group__0__Impl : ( 'entity' ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:477:1: ( ( 'entity' ) )
            // InternalLucraDSL.g:478:1: ( 'entity' )
            {
            // InternalLucraDSL.g:478:1: ( 'entity' )
            // InternalLucraDSL.g:479:2: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // InternalLucraDSL.g:488:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:492:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // InternalLucraDSL.g:493:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Entity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // InternalLucraDSL.g:500:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:504:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalLucraDSL.g:505:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalLucraDSL.g:505:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalLucraDSL.g:506:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalLucraDSL.g:507:2: ( rule__Entity__NameAssignment_1 )
            // InternalLucraDSL.g:507:3: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__2"
    // InternalLucraDSL.g:515:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:519:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // InternalLucraDSL.g:520:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Entity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2"


    // $ANTLR start "rule__Entity__Group__2__Impl"
    // InternalLucraDSL.g:527:1: rule__Entity__Group__2__Impl : ( '{' ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:531:1: ( ( '{' ) )
            // InternalLucraDSL.g:532:1: ( '{' )
            {
            // InternalLucraDSL.g:532:1: ( '{' )
            // InternalLucraDSL.g:533:2: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2__Impl"


    // $ANTLR start "rule__Entity__Group__3"
    // InternalLucraDSL.g:542:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:546:1: ( rule__Entity__Group__3__Impl rule__Entity__Group__4 )
            // InternalLucraDSL.g:547:2: rule__Entity__Group__3__Impl rule__Entity__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Entity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3"


    // $ANTLR start "rule__Entity__Group__3__Impl"
    // InternalLucraDSL.g:554:1: rule__Entity__Group__3__Impl : ( ( rule__Entity__FieldsAssignment_3 )* ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:558:1: ( ( ( rule__Entity__FieldsAssignment_3 )* ) )
            // InternalLucraDSL.g:559:1: ( ( rule__Entity__FieldsAssignment_3 )* )
            {
            // InternalLucraDSL.g:559:1: ( ( rule__Entity__FieldsAssignment_3 )* )
            // InternalLucraDSL.g:560:2: ( rule__Entity__FieldsAssignment_3 )*
            {
             before(grammarAccess.getEntityAccess().getFieldsAssignment_3()); 
            // InternalLucraDSL.g:561:2: ( rule__Entity__FieldsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLucraDSL.g:561:3: rule__Entity__FieldsAssignment_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Entity__FieldsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getFieldsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3__Impl"


    // $ANTLR start "rule__Entity__Group__4"
    // InternalLucraDSL.g:569:1: rule__Entity__Group__4 : rule__Entity__Group__4__Impl ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:573:1: ( rule__Entity__Group__4__Impl )
            // InternalLucraDSL.g:574:2: rule__Entity__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4"


    // $ANTLR start "rule__Entity__Group__4__Impl"
    // InternalLucraDSL.g:580:1: rule__Entity__Group__4__Impl : ( '}' ) ;
    public final void rule__Entity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:584:1: ( ( '}' ) )
            // InternalLucraDSL.g:585:1: ( '}' )
            {
            // InternalLucraDSL.g:585:1: ( '}' )
            // InternalLucraDSL.g:586:2: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4__Impl"


    // $ANTLR start "rule__EntityField__Group__0"
    // InternalLucraDSL.g:596:1: rule__EntityField__Group__0 : rule__EntityField__Group__0__Impl rule__EntityField__Group__1 ;
    public final void rule__EntityField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:600:1: ( rule__EntityField__Group__0__Impl rule__EntityField__Group__1 )
            // InternalLucraDSL.g:601:2: rule__EntityField__Group__0__Impl rule__EntityField__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__EntityField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__0"


    // $ANTLR start "rule__EntityField__Group__0__Impl"
    // InternalLucraDSL.g:608:1: rule__EntityField__Group__0__Impl : ( ( rule__EntityField__NameAssignment_0 ) ) ;
    public final void rule__EntityField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:612:1: ( ( ( rule__EntityField__NameAssignment_0 ) ) )
            // InternalLucraDSL.g:613:1: ( ( rule__EntityField__NameAssignment_0 ) )
            {
            // InternalLucraDSL.g:613:1: ( ( rule__EntityField__NameAssignment_0 ) )
            // InternalLucraDSL.g:614:2: ( rule__EntityField__NameAssignment_0 )
            {
             before(grammarAccess.getEntityFieldAccess().getNameAssignment_0()); 
            // InternalLucraDSL.g:615:2: ( rule__EntityField__NameAssignment_0 )
            // InternalLucraDSL.g:615:3: rule__EntityField__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EntityField__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEntityFieldAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__0__Impl"


    // $ANTLR start "rule__EntityField__Group__1"
    // InternalLucraDSL.g:623:1: rule__EntityField__Group__1 : rule__EntityField__Group__1__Impl rule__EntityField__Group__2 ;
    public final void rule__EntityField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:627:1: ( rule__EntityField__Group__1__Impl rule__EntityField__Group__2 )
            // InternalLucraDSL.g:628:2: rule__EntityField__Group__1__Impl rule__EntityField__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__EntityField__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityField__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__1"


    // $ANTLR start "rule__EntityField__Group__1__Impl"
    // InternalLucraDSL.g:635:1: rule__EntityField__Group__1__Impl : ( ( rule__EntityField__TypeAssignment_1 ) ) ;
    public final void rule__EntityField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:639:1: ( ( ( rule__EntityField__TypeAssignment_1 ) ) )
            // InternalLucraDSL.g:640:1: ( ( rule__EntityField__TypeAssignment_1 ) )
            {
            // InternalLucraDSL.g:640:1: ( ( rule__EntityField__TypeAssignment_1 ) )
            // InternalLucraDSL.g:641:2: ( rule__EntityField__TypeAssignment_1 )
            {
             before(grammarAccess.getEntityFieldAccess().getTypeAssignment_1()); 
            // InternalLucraDSL.g:642:2: ( rule__EntityField__TypeAssignment_1 )
            // InternalLucraDSL.g:642:3: rule__EntityField__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EntityField__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityFieldAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__1__Impl"


    // $ANTLR start "rule__EntityField__Group__2"
    // InternalLucraDSL.g:650:1: rule__EntityField__Group__2 : rule__EntityField__Group__2__Impl rule__EntityField__Group__3 ;
    public final void rule__EntityField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:654:1: ( rule__EntityField__Group__2__Impl rule__EntityField__Group__3 )
            // InternalLucraDSL.g:655:2: rule__EntityField__Group__2__Impl rule__EntityField__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__EntityField__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityField__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__2"


    // $ANTLR start "rule__EntityField__Group__2__Impl"
    // InternalLucraDSL.g:662:1: rule__EntityField__Group__2__Impl : ( ( rule__EntityField__ListAssignment_2 )? ) ;
    public final void rule__EntityField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:666:1: ( ( ( rule__EntityField__ListAssignment_2 )? ) )
            // InternalLucraDSL.g:667:1: ( ( rule__EntityField__ListAssignment_2 )? )
            {
            // InternalLucraDSL.g:667:1: ( ( rule__EntityField__ListAssignment_2 )? )
            // InternalLucraDSL.g:668:2: ( rule__EntityField__ListAssignment_2 )?
            {
             before(grammarAccess.getEntityFieldAccess().getListAssignment_2()); 
            // InternalLucraDSL.g:669:2: ( rule__EntityField__ListAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLucraDSL.g:669:3: rule__EntityField__ListAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__EntityField__ListAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityFieldAccess().getListAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__2__Impl"


    // $ANTLR start "rule__EntityField__Group__3"
    // InternalLucraDSL.g:677:1: rule__EntityField__Group__3 : rule__EntityField__Group__3__Impl rule__EntityField__Group__4 ;
    public final void rule__EntityField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:681:1: ( rule__EntityField__Group__3__Impl rule__EntityField__Group__4 )
            // InternalLucraDSL.g:682:2: rule__EntityField__Group__3__Impl rule__EntityField__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__EntityField__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityField__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__3"


    // $ANTLR start "rule__EntityField__Group__3__Impl"
    // InternalLucraDSL.g:689:1: rule__EntityField__Group__3__Impl : ( ( rule__EntityField__NullableAssignment_3 )? ) ;
    public final void rule__EntityField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:693:1: ( ( ( rule__EntityField__NullableAssignment_3 )? ) )
            // InternalLucraDSL.g:694:1: ( ( rule__EntityField__NullableAssignment_3 )? )
            {
            // InternalLucraDSL.g:694:1: ( ( rule__EntityField__NullableAssignment_3 )? )
            // InternalLucraDSL.g:695:2: ( rule__EntityField__NullableAssignment_3 )?
            {
             before(grammarAccess.getEntityFieldAccess().getNullableAssignment_3()); 
            // InternalLucraDSL.g:696:2: ( rule__EntityField__NullableAssignment_3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalLucraDSL.g:696:3: rule__EntityField__NullableAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__EntityField__NullableAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityFieldAccess().getNullableAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__3__Impl"


    // $ANTLR start "rule__EntityField__Group__4"
    // InternalLucraDSL.g:704:1: rule__EntityField__Group__4 : rule__EntityField__Group__4__Impl ;
    public final void rule__EntityField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:708:1: ( rule__EntityField__Group__4__Impl )
            // InternalLucraDSL.g:709:2: rule__EntityField__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EntityField__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__4"


    // $ANTLR start "rule__EntityField__Group__4__Impl"
    // InternalLucraDSL.g:715:1: rule__EntityField__Group__4__Impl : ( ( rule__EntityField__RelationAssignment_4 )? ) ;
    public final void rule__EntityField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:719:1: ( ( ( rule__EntityField__RelationAssignment_4 )? ) )
            // InternalLucraDSL.g:720:1: ( ( rule__EntityField__RelationAssignment_4 )? )
            {
            // InternalLucraDSL.g:720:1: ( ( rule__EntityField__RelationAssignment_4 )? )
            // InternalLucraDSL.g:721:2: ( rule__EntityField__RelationAssignment_4 )?
            {
             before(grammarAccess.getEntityFieldAccess().getRelationAssignment_4()); 
            // InternalLucraDSL.g:722:2: ( rule__EntityField__RelationAssignment_4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=17 && LA9_0<=19)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLucraDSL.g:722:3: rule__EntityField__RelationAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__EntityField__RelationAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityFieldAccess().getRelationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__Group__4__Impl"


    // $ANTLR start "rule__EnumDsl__Group__0"
    // InternalLucraDSL.g:731:1: rule__EnumDsl__Group__0 : rule__EnumDsl__Group__0__Impl rule__EnumDsl__Group__1 ;
    public final void rule__EnumDsl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:735:1: ( rule__EnumDsl__Group__0__Impl rule__EnumDsl__Group__1 )
            // InternalLucraDSL.g:736:2: rule__EnumDsl__Group__0__Impl rule__EnumDsl__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__EnumDsl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__0"


    // $ANTLR start "rule__EnumDsl__Group__0__Impl"
    // InternalLucraDSL.g:743:1: rule__EnumDsl__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumDsl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:747:1: ( ( 'enum' ) )
            // InternalLucraDSL.g:748:1: ( 'enum' )
            {
            // InternalLucraDSL.g:748:1: ( 'enum' )
            // InternalLucraDSL.g:749:2: 'enum'
            {
             before(grammarAccess.getEnumDslAccess().getEnumKeyword_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getEnumDslAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__0__Impl"


    // $ANTLR start "rule__EnumDsl__Group__1"
    // InternalLucraDSL.g:758:1: rule__EnumDsl__Group__1 : rule__EnumDsl__Group__1__Impl rule__EnumDsl__Group__2 ;
    public final void rule__EnumDsl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:762:1: ( rule__EnumDsl__Group__1__Impl rule__EnumDsl__Group__2 )
            // InternalLucraDSL.g:763:2: rule__EnumDsl__Group__1__Impl rule__EnumDsl__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__EnumDsl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__1"


    // $ANTLR start "rule__EnumDsl__Group__1__Impl"
    // InternalLucraDSL.g:770:1: rule__EnumDsl__Group__1__Impl : ( ( rule__EnumDsl__NameAssignment_1 ) ) ;
    public final void rule__EnumDsl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:774:1: ( ( ( rule__EnumDsl__NameAssignment_1 ) ) )
            // InternalLucraDSL.g:775:1: ( ( rule__EnumDsl__NameAssignment_1 ) )
            {
            // InternalLucraDSL.g:775:1: ( ( rule__EnumDsl__NameAssignment_1 ) )
            // InternalLucraDSL.g:776:2: ( rule__EnumDsl__NameAssignment_1 )
            {
             before(grammarAccess.getEnumDslAccess().getNameAssignment_1()); 
            // InternalLucraDSL.g:777:2: ( rule__EnumDsl__NameAssignment_1 )
            // InternalLucraDSL.g:777:3: rule__EnumDsl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumDsl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumDslAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__1__Impl"


    // $ANTLR start "rule__EnumDsl__Group__2"
    // InternalLucraDSL.g:785:1: rule__EnumDsl__Group__2 : rule__EnumDsl__Group__2__Impl rule__EnumDsl__Group__3 ;
    public final void rule__EnumDsl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:789:1: ( rule__EnumDsl__Group__2__Impl rule__EnumDsl__Group__3 )
            // InternalLucraDSL.g:790:2: rule__EnumDsl__Group__2__Impl rule__EnumDsl__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__EnumDsl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__2"


    // $ANTLR start "rule__EnumDsl__Group__2__Impl"
    // InternalLucraDSL.g:797:1: rule__EnumDsl__Group__2__Impl : ( '{' ) ;
    public final void rule__EnumDsl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:801:1: ( ( '{' ) )
            // InternalLucraDSL.g:802:1: ( '{' )
            {
            // InternalLucraDSL.g:802:1: ( '{' )
            // InternalLucraDSL.g:803:2: '{'
            {
             before(grammarAccess.getEnumDslAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getEnumDslAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__2__Impl"


    // $ANTLR start "rule__EnumDsl__Group__3"
    // InternalLucraDSL.g:812:1: rule__EnumDsl__Group__3 : rule__EnumDsl__Group__3__Impl rule__EnumDsl__Group__4 ;
    public final void rule__EnumDsl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:816:1: ( rule__EnumDsl__Group__3__Impl rule__EnumDsl__Group__4 )
            // InternalLucraDSL.g:817:2: rule__EnumDsl__Group__3__Impl rule__EnumDsl__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__EnumDsl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__3"


    // $ANTLR start "rule__EnumDsl__Group__3__Impl"
    // InternalLucraDSL.g:824:1: rule__EnumDsl__Group__3__Impl : ( ( rule__EnumDsl__LiteralsAssignment_3 )* ) ;
    public final void rule__EnumDsl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:828:1: ( ( ( rule__EnumDsl__LiteralsAssignment_3 )* ) )
            // InternalLucraDSL.g:829:1: ( ( rule__EnumDsl__LiteralsAssignment_3 )* )
            {
            // InternalLucraDSL.g:829:1: ( ( rule__EnumDsl__LiteralsAssignment_3 )* )
            // InternalLucraDSL.g:830:2: ( rule__EnumDsl__LiteralsAssignment_3 )*
            {
             before(grammarAccess.getEnumDslAccess().getLiteralsAssignment_3()); 
            // InternalLucraDSL.g:831:2: ( rule__EnumDsl__LiteralsAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalLucraDSL.g:831:3: rule__EnumDsl__LiteralsAssignment_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__EnumDsl__LiteralsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getEnumDslAccess().getLiteralsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__3__Impl"


    // $ANTLR start "rule__EnumDsl__Group__4"
    // InternalLucraDSL.g:839:1: rule__EnumDsl__Group__4 : rule__EnumDsl__Group__4__Impl ;
    public final void rule__EnumDsl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:843:1: ( rule__EnumDsl__Group__4__Impl )
            // InternalLucraDSL.g:844:2: rule__EnumDsl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumDsl__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__4"


    // $ANTLR start "rule__EnumDsl__Group__4__Impl"
    // InternalLucraDSL.g:850:1: rule__EnumDsl__Group__4__Impl : ( '}' ) ;
    public final void rule__EnumDsl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:854:1: ( ( '}' ) )
            // InternalLucraDSL.g:855:1: ( '}' )
            {
            // InternalLucraDSL.g:855:1: ( '}' )
            // InternalLucraDSL.g:856:2: '}'
            {
             before(grammarAccess.getEnumDslAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getEnumDslAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__Group__4__Impl"


    // $ANTLR start "rule__LucraDSL__ElementsAssignment"
    // InternalLucraDSL.g:866:1: rule__LucraDSL__ElementsAssignment : ( ruleElement ) ;
    public final void rule__LucraDSL__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:870:1: ( ( ruleElement ) )
            // InternalLucraDSL.g:871:2: ( ruleElement )
            {
            // InternalLucraDSL.g:871:2: ( ruleElement )
            // InternalLucraDSL.g:872:3: ruleElement
            {
             before(grammarAccess.getLucraDSLAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getLucraDSLAccess().getElementsElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LucraDSL__ElementsAssignment"


    // $ANTLR start "rule__PrimitiveType__NameAssignment_1"
    // InternalLucraDSL.g:881:1: rule__PrimitiveType__NameAssignment_1 : ( ( rule__PrimitiveType__NameAlternatives_1_0 ) ) ;
    public final void rule__PrimitiveType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:885:1: ( ( ( rule__PrimitiveType__NameAlternatives_1_0 ) ) )
            // InternalLucraDSL.g:886:2: ( ( rule__PrimitiveType__NameAlternatives_1_0 ) )
            {
            // InternalLucraDSL.g:886:2: ( ( rule__PrimitiveType__NameAlternatives_1_0 ) )
            // InternalLucraDSL.g:887:3: ( rule__PrimitiveType__NameAlternatives_1_0 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_1_0()); 
            // InternalLucraDSL.g:888:3: ( rule__PrimitiveType__NameAlternatives_1_0 )
            // InternalLucraDSL.g:888:4: rule__PrimitiveType__NameAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__NameAssignment_1"


    // $ANTLR start "rule__ComplexTypeRef__TypeAssignment"
    // InternalLucraDSL.g:896:1: rule__ComplexTypeRef__TypeAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ComplexTypeRef__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:900:1: ( ( ( RULE_ID ) ) )
            // InternalLucraDSL.g:901:2: ( ( RULE_ID ) )
            {
            // InternalLucraDSL.g:901:2: ( ( RULE_ID ) )
            // InternalLucraDSL.g:902:3: ( RULE_ID )
            {
             before(grammarAccess.getComplexTypeRefAccess().getTypeElementCrossReference_0()); 
            // InternalLucraDSL.g:903:3: ( RULE_ID )
            // InternalLucraDSL.g:904:4: RULE_ID
            {
             before(grammarAccess.getComplexTypeRefAccess().getTypeElementIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComplexTypeRefAccess().getTypeElementIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getComplexTypeRefAccess().getTypeElementCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeRef__TypeAssignment"


    // $ANTLR start "rule__Entity__NameAssignment_1"
    // InternalLucraDSL.g:915:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:919:1: ( ( RULE_ID ) )
            // InternalLucraDSL.g:920:2: ( RULE_ID )
            {
            // InternalLucraDSL.g:920:2: ( RULE_ID )
            // InternalLucraDSL.g:921:3: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_1"


    // $ANTLR start "rule__Entity__FieldsAssignment_3"
    // InternalLucraDSL.g:930:1: rule__Entity__FieldsAssignment_3 : ( ruleEntityField ) ;
    public final void rule__Entity__FieldsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:934:1: ( ( ruleEntityField ) )
            // InternalLucraDSL.g:935:2: ( ruleEntityField )
            {
            // InternalLucraDSL.g:935:2: ( ruleEntityField )
            // InternalLucraDSL.g:936:3: ruleEntityField
            {
             before(grammarAccess.getEntityAccess().getFieldsEntityFieldParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEntityField();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getFieldsEntityFieldParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__FieldsAssignment_3"


    // $ANTLR start "rule__EntityField__NameAssignment_0"
    // InternalLucraDSL.g:945:1: rule__EntityField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EntityField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:949:1: ( ( RULE_ID ) )
            // InternalLucraDSL.g:950:2: ( RULE_ID )
            {
            // InternalLucraDSL.g:950:2: ( RULE_ID )
            // InternalLucraDSL.g:951:3: RULE_ID
            {
             before(grammarAccess.getEntityFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityFieldAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__NameAssignment_0"


    // $ANTLR start "rule__EntityField__TypeAssignment_1"
    // InternalLucraDSL.g:960:1: rule__EntityField__TypeAssignment_1 : ( ruleType ) ;
    public final void rule__EntityField__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:964:1: ( ( ruleType ) )
            // InternalLucraDSL.g:965:2: ( ruleType )
            {
            // InternalLucraDSL.g:965:2: ( ruleType )
            // InternalLucraDSL.g:966:3: ruleType
            {
             before(grammarAccess.getEntityFieldAccess().getTypeTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getEntityFieldAccess().getTypeTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__TypeAssignment_1"


    // $ANTLR start "rule__EntityField__ListAssignment_2"
    // InternalLucraDSL.g:975:1: rule__EntityField__ListAssignment_2 : ( ( '*' ) ) ;
    public final void rule__EntityField__ListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:979:1: ( ( ( '*' ) ) )
            // InternalLucraDSL.g:980:2: ( ( '*' ) )
            {
            // InternalLucraDSL.g:980:2: ( ( '*' ) )
            // InternalLucraDSL.g:981:3: ( '*' )
            {
             before(grammarAccess.getEntityFieldAccess().getListAsteriskKeyword_2_0()); 
            // InternalLucraDSL.g:982:3: ( '*' )
            // InternalLucraDSL.g:983:4: '*'
            {
             before(grammarAccess.getEntityFieldAccess().getListAsteriskKeyword_2_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getEntityFieldAccess().getListAsteriskKeyword_2_0()); 

            }

             after(grammarAccess.getEntityFieldAccess().getListAsteriskKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__ListAssignment_2"


    // $ANTLR start "rule__EntityField__NullableAssignment_3"
    // InternalLucraDSL.g:994:1: rule__EntityField__NullableAssignment_3 : ( ( '?' ) ) ;
    public final void rule__EntityField__NullableAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:998:1: ( ( ( '?' ) ) )
            // InternalLucraDSL.g:999:2: ( ( '?' ) )
            {
            // InternalLucraDSL.g:999:2: ( ( '?' ) )
            // InternalLucraDSL.g:1000:3: ( '?' )
            {
             before(grammarAccess.getEntityFieldAccess().getNullableQuestionMarkKeyword_3_0()); 
            // InternalLucraDSL.g:1001:3: ( '?' )
            // InternalLucraDSL.g:1002:4: '?'
            {
             before(grammarAccess.getEntityFieldAccess().getNullableQuestionMarkKeyword_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEntityFieldAccess().getNullableQuestionMarkKeyword_3_0()); 

            }

             after(grammarAccess.getEntityFieldAccess().getNullableQuestionMarkKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__NullableAssignment_3"


    // $ANTLR start "rule__EntityField__RelationAssignment_4"
    // InternalLucraDSL.g:1013:1: rule__EntityField__RelationAssignment_4 : ( ruleRelationType ) ;
    public final void rule__EntityField__RelationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:1017:1: ( ( ruleRelationType ) )
            // InternalLucraDSL.g:1018:2: ( ruleRelationType )
            {
            // InternalLucraDSL.g:1018:2: ( ruleRelationType )
            // InternalLucraDSL.g:1019:3: ruleRelationType
            {
             before(grammarAccess.getEntityFieldAccess().getRelationRelationTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleRelationType();

            state._fsp--;

             after(grammarAccess.getEntityFieldAccess().getRelationRelationTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityField__RelationAssignment_4"


    // $ANTLR start "rule__EnumDsl__NameAssignment_1"
    // InternalLucraDSL.g:1028:1: rule__EnumDsl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumDsl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:1032:1: ( ( RULE_ID ) )
            // InternalLucraDSL.g:1033:2: ( RULE_ID )
            {
            // InternalLucraDSL.g:1033:2: ( RULE_ID )
            // InternalLucraDSL.g:1034:3: RULE_ID
            {
             before(grammarAccess.getEnumDslAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumDslAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__NameAssignment_1"


    // $ANTLR start "rule__EnumDsl__LiteralsAssignment_3"
    // InternalLucraDSL.g:1043:1: rule__EnumDsl__LiteralsAssignment_3 : ( ruleEnumLiteral ) ;
    public final void rule__EnumDsl__LiteralsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:1047:1: ( ( ruleEnumLiteral ) )
            // InternalLucraDSL.g:1048:2: ( ruleEnumLiteral )
            {
            // InternalLucraDSL.g:1048:2: ( ruleEnumLiteral )
            // InternalLucraDSL.g:1049:3: ruleEnumLiteral
            {
             before(grammarAccess.getEnumDslAccess().getLiteralsEnumLiteralParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumLiteral();

            state._fsp--;

             after(grammarAccess.getEnumDslAccess().getLiteralsEnumLiteralParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumDsl__LiteralsAssignment_3"


    // $ANTLR start "rule__EnumLiteral__NameAssignment"
    // InternalLucraDSL.g:1058:1: rule__EnumLiteral__NameAssignment : ( RULE_ID ) ;
    public final void rule__EnumLiteral__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLucraDSL.g:1062:1: ( ( RULE_ID ) )
            // InternalLucraDSL.g:1063:2: ( RULE_ID )
            {
            // InternalLucraDSL.g:1063:2: ( RULE_ID )
            // InternalLucraDSL.g:1064:3: RULE_ID
            {
             before(grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteral__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000900002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000001F810L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000030E0000L});

}