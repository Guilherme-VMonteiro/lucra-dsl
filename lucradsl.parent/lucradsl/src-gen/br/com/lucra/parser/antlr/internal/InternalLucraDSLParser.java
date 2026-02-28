package br.com.lucra.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import br.com.lucra.services.LucraDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLucraDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'number'", "'date'", "'uuid'", "'money'", "'boolean'", "'entity'", "'{'", "'}'", "'*'", "'?'", "'enum'", "'contains'", "'contained'", "'refers'"
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

        public InternalLucraDSLParser(TokenStream input, LucraDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "LucraDSL";
       	}

       	@Override
       	protected LucraDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleLucraDSL"
    // InternalLucraDSL.g:65:1: entryRuleLucraDSL returns [EObject current=null] : iv_ruleLucraDSL= ruleLucraDSL EOF ;
    public final EObject entryRuleLucraDSL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLucraDSL = null;


        try {
            // InternalLucraDSL.g:65:49: (iv_ruleLucraDSL= ruleLucraDSL EOF )
            // InternalLucraDSL.g:66:2: iv_ruleLucraDSL= ruleLucraDSL EOF
            {
             newCompositeNode(grammarAccess.getLucraDSLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLucraDSL=ruleLucraDSL();

            state._fsp--;

             current =iv_ruleLucraDSL; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLucraDSL"


    // $ANTLR start "ruleLucraDSL"
    // InternalLucraDSL.g:72:1: ruleLucraDSL returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleLucraDSL() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:78:2: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalLucraDSL.g:79:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalLucraDSL.g:79:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLucraDSL.g:80:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalLucraDSL.g:80:3: (lv_elements_0_0= ruleElement )
            	    // InternalLucraDSL.g:81:4: lv_elements_0_0= ruleElement
            	    {

            	    				newCompositeNode(grammarAccess.getLucraDSLAccess().getElementsElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getLucraDSLRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"br.com.lucra.LucraDSL.Element");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLucraDSL"


    // $ANTLR start "entryRuleType"
    // InternalLucraDSL.g:101:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalLucraDSL.g:101:45: (iv_ruleType= ruleType EOF )
            // InternalLucraDSL.g:102:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalLucraDSL.g:108:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ComplexTypeRef_1= ruleComplexTypeRef ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ComplexTypeRef_1 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:114:2: ( (this_PrimitiveType_0= rulePrimitiveType | this_ComplexTypeRef_1= ruleComplexTypeRef ) )
            // InternalLucraDSL.g:115:2: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexTypeRef_1= ruleComplexTypeRef )
            {
            // InternalLucraDSL.g:115:2: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexTypeRef_1= ruleComplexTypeRef )
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
                    // InternalLucraDSL.g:116:3: this_PrimitiveType_0= rulePrimitiveType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;


                    			current = this_PrimitiveType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:125:3: this_ComplexTypeRef_1= ruleComplexTypeRef
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getComplexTypeRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComplexTypeRef_1=ruleComplexTypeRef();

                    state._fsp--;


                    			current = this_ComplexTypeRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalLucraDSL.g:137:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalLucraDSL.g:137:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalLucraDSL.g:138:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalLucraDSL.g:144:1: rulePrimitiveType returns [EObject current=null] : ( () ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;


        	enterRule();

        try {
            // InternalLucraDSL.g:150:2: ( ( () ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) ) ) )
            // InternalLucraDSL.g:151:2: ( () ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) ) )
            {
            // InternalLucraDSL.g:151:2: ( () ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) ) )
            // InternalLucraDSL.g:152:3: () ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) )
            {
            // InternalLucraDSL.g:152:3: ()
            // InternalLucraDSL.g:153:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeAction_0(),
            					current);
            			

            }

            // InternalLucraDSL.g:159:3: ( ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) ) )
            // InternalLucraDSL.g:160:4: ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) )
            {
            // InternalLucraDSL.g:160:4: ( (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' ) )
            // InternalLucraDSL.g:161:5: (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' )
            {
            // InternalLucraDSL.g:161:5: (lv_name_1_1= 'string' | lv_name_1_2= 'number' | lv_name_1_3= 'date' | lv_name_1_4= 'uuid' | lv_name_1_5= 'money' | lv_name_1_6= 'boolean' )
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
                    // InternalLucraDSL.g:162:6: lv_name_1_1= 'string'
                    {
                    lv_name_1_1=(Token)match(input,11,FOLLOW_2); 

                    						newLeafNode(lv_name_1_1, grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:173:6: lv_name_1_2= 'number'
                    {
                    lv_name_1_2=(Token)match(input,12,FOLLOW_2); 

                    						newLeafNode(lv_name_1_2, grammarAccess.getPrimitiveTypeAccess().getNameNumberKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalLucraDSL.g:184:6: lv_name_1_3= 'date'
                    {
                    lv_name_1_3=(Token)match(input,13,FOLLOW_2); 

                    						newLeafNode(lv_name_1_3, grammarAccess.getPrimitiveTypeAccess().getNameDateKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalLucraDSL.g:195:6: lv_name_1_4= 'uuid'
                    {
                    lv_name_1_4=(Token)match(input,14,FOLLOW_2); 

                    						newLeafNode(lv_name_1_4, grammarAccess.getPrimitiveTypeAccess().getNameUuidKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalLucraDSL.g:206:6: lv_name_1_5= 'money'
                    {
                    lv_name_1_5=(Token)match(input,15,FOLLOW_2); 

                    						newLeafNode(lv_name_1_5, grammarAccess.getPrimitiveTypeAccess().getNameMoneyKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalLucraDSL.g:217:6: lv_name_1_6= 'boolean'
                    {
                    lv_name_1_6=(Token)match(input,16,FOLLOW_2); 

                    						newLeafNode(lv_name_1_6, grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_1_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_6, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleComplexTypeRef"
    // InternalLucraDSL.g:234:1: entryRuleComplexTypeRef returns [EObject current=null] : iv_ruleComplexTypeRef= ruleComplexTypeRef EOF ;
    public final EObject entryRuleComplexTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeRef = null;


        try {
            // InternalLucraDSL.g:234:55: (iv_ruleComplexTypeRef= ruleComplexTypeRef EOF )
            // InternalLucraDSL.g:235:2: iv_ruleComplexTypeRef= ruleComplexTypeRef EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexTypeRef=ruleComplexTypeRef();

            state._fsp--;

             current =iv_ruleComplexTypeRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexTypeRef"


    // $ANTLR start "ruleComplexTypeRef"
    // InternalLucraDSL.g:241:1: ruleComplexTypeRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleComplexTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalLucraDSL.g:247:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalLucraDSL.g:248:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalLucraDSL.g:248:2: ( (otherlv_0= RULE_ID ) )
            // InternalLucraDSL.g:249:3: (otherlv_0= RULE_ID )
            {
            // InternalLucraDSL.g:249:3: (otherlv_0= RULE_ID )
            // InternalLucraDSL.g:250:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getComplexTypeRefRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getComplexTypeRefAccess().getTypeElementCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexTypeRef"


    // $ANTLR start "entryRuleElement"
    // InternalLucraDSL.g:264:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalLucraDSL.g:264:48: (iv_ruleElement= ruleElement EOF )
            // InternalLucraDSL.g:265:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalLucraDSL.g:271:1: ruleElement returns [EObject current=null] : (this_Entity_0= ruleEntity | this_EnumDsl_1= ruleEnumDsl ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_EnumDsl_1 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:277:2: ( (this_Entity_0= ruleEntity | this_EnumDsl_1= ruleEnumDsl ) )
            // InternalLucraDSL.g:278:2: (this_Entity_0= ruleEntity | this_EnumDsl_1= ruleEnumDsl )
            {
            // InternalLucraDSL.g:278:2: (this_Entity_0= ruleEntity | this_EnumDsl_1= ruleEnumDsl )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==22) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalLucraDSL.g:279:3: this_Entity_0= ruleEntity
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:288:3: this_EnumDsl_1= ruleEnumDsl
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getEnumDslParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumDsl_1=ruleEnumDsl();

                    state._fsp--;


                    			current = this_EnumDsl_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleEntity"
    // InternalLucraDSL.g:300:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalLucraDSL.g:300:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalLucraDSL.g:301:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalLucraDSL.g:307:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEntityField ) )* otherlv_4= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:313:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEntityField ) )* otherlv_4= '}' ) )
            // InternalLucraDSL.g:314:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEntityField ) )* otherlv_4= '}' )
            {
            // InternalLucraDSL.g:314:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEntityField ) )* otherlv_4= '}' )
            // InternalLucraDSL.g:315:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEntityField ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalLucraDSL.g:319:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLucraDSL.g:320:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLucraDSL.g:320:4: (lv_name_1_0= RULE_ID )
            // InternalLucraDSL.g:321:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLucraDSL.g:341:3: ( (lv_fields_3_0= ruleEntityField ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLucraDSL.g:342:4: (lv_fields_3_0= ruleEntityField )
            	    {
            	    // InternalLucraDSL.g:342:4: (lv_fields_3_0= ruleEntityField )
            	    // InternalLucraDSL.g:343:5: lv_fields_3_0= ruleEntityField
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getFieldsEntityFieldParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_fields_3_0=ruleEntityField();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fields",
            	    						lv_fields_3_0,
            	    						"br.com.lucra.LucraDSL.EntityField");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleEntityField"
    // InternalLucraDSL.g:368:1: entryRuleEntityField returns [EObject current=null] : iv_ruleEntityField= ruleEntityField EOF ;
    public final EObject entryRuleEntityField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityField = null;


        try {
            // InternalLucraDSL.g:368:52: (iv_ruleEntityField= ruleEntityField EOF )
            // InternalLucraDSL.g:369:2: iv_ruleEntityField= ruleEntityField EOF
            {
             newCompositeNode(grammarAccess.getEntityFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityField=ruleEntityField();

            state._fsp--;

             current =iv_ruleEntityField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityField"


    // $ANTLR start "ruleEntityField"
    // InternalLucraDSL.g:375:1: ruleEntityField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleType ) ) ( (lv_list_2_0= '*' ) )? ( (lv_nullable_3_0= '?' ) )? ( (lv_relation_4_0= ruleRelationType ) )? ) ;
    public final EObject ruleEntityField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_list_2_0=null;
        Token lv_nullable_3_0=null;
        EObject lv_type_1_0 = null;

        Enumerator lv_relation_4_0 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:381:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleType ) ) ( (lv_list_2_0= '*' ) )? ( (lv_nullable_3_0= '?' ) )? ( (lv_relation_4_0= ruleRelationType ) )? ) )
            // InternalLucraDSL.g:382:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleType ) ) ( (lv_list_2_0= '*' ) )? ( (lv_nullable_3_0= '?' ) )? ( (lv_relation_4_0= ruleRelationType ) )? )
            {
            // InternalLucraDSL.g:382:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleType ) ) ( (lv_list_2_0= '*' ) )? ( (lv_nullable_3_0= '?' ) )? ( (lv_relation_4_0= ruleRelationType ) )? )
            // InternalLucraDSL.g:383:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleType ) ) ( (lv_list_2_0= '*' ) )? ( (lv_nullable_3_0= '?' ) )? ( (lv_relation_4_0= ruleRelationType ) )?
            {
            // InternalLucraDSL.g:383:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalLucraDSL.g:384:4: (lv_name_0_0= RULE_ID )
            {
            // InternalLucraDSL.g:384:4: (lv_name_0_0= RULE_ID )
            // InternalLucraDSL.g:385:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEntityFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalLucraDSL.g:401:3: ( (lv_type_1_0= ruleType ) )
            // InternalLucraDSL.g:402:4: (lv_type_1_0= ruleType )
            {
            // InternalLucraDSL.g:402:4: (lv_type_1_0= ruleType )
            // InternalLucraDSL.g:403:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getEntityFieldAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_1_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityFieldRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"br.com.lucra.LucraDSL.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLucraDSL.g:420:3: ( (lv_list_2_0= '*' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalLucraDSL.g:421:4: (lv_list_2_0= '*' )
                    {
                    // InternalLucraDSL.g:421:4: (lv_list_2_0= '*' )
                    // InternalLucraDSL.g:422:5: lv_list_2_0= '*'
                    {
                    lv_list_2_0=(Token)match(input,20,FOLLOW_9); 

                    					newLeafNode(lv_list_2_0, grammarAccess.getEntityFieldAccess().getListAsteriskKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityFieldRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_2_0 != null, "*");
                    				

                    }


                    }
                    break;

            }

            // InternalLucraDSL.g:434:3: ( (lv_nullable_3_0= '?' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLucraDSL.g:435:4: (lv_nullable_3_0= '?' )
                    {
                    // InternalLucraDSL.g:435:4: (lv_nullable_3_0= '?' )
                    // InternalLucraDSL.g:436:5: lv_nullable_3_0= '?'
                    {
                    lv_nullable_3_0=(Token)match(input,21,FOLLOW_10); 

                    					newLeafNode(lv_nullable_3_0, grammarAccess.getEntityFieldAccess().getNullableQuestionMarkKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityFieldRule());
                    					}
                    					setWithLastConsumed(current, "nullable", lv_nullable_3_0 != null, "?");
                    				

                    }


                    }
                    break;

            }

            // InternalLucraDSL.g:448:3: ( (lv_relation_4_0= ruleRelationType ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=23 && LA8_0<=25)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalLucraDSL.g:449:4: (lv_relation_4_0= ruleRelationType )
                    {
                    // InternalLucraDSL.g:449:4: (lv_relation_4_0= ruleRelationType )
                    // InternalLucraDSL.g:450:5: lv_relation_4_0= ruleRelationType
                    {

                    					newCompositeNode(grammarAccess.getEntityFieldAccess().getRelationRelationTypeEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_relation_4_0=ruleRelationType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityFieldRule());
                    					}
                    					set(
                    						current,
                    						"relation",
                    						lv_relation_4_0,
                    						"br.com.lucra.LucraDSL.RelationType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityField"


    // $ANTLR start "entryRuleEnumDsl"
    // InternalLucraDSL.g:471:1: entryRuleEnumDsl returns [EObject current=null] : iv_ruleEnumDsl= ruleEnumDsl EOF ;
    public final EObject entryRuleEnumDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumDsl = null;


        try {
            // InternalLucraDSL.g:471:48: (iv_ruleEnumDsl= ruleEnumDsl EOF )
            // InternalLucraDSL.g:472:2: iv_ruleEnumDsl= ruleEnumDsl EOF
            {
             newCompositeNode(grammarAccess.getEnumDslRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumDsl=ruleEnumDsl();

            state._fsp--;

             current =iv_ruleEnumDsl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumDsl"


    // $ANTLR start "ruleEnumDsl"
    // InternalLucraDSL.g:478:1: ruleEnumDsl returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleEnumLiteral ) )* otherlv_4= '}' ) ;
    public final EObject ruleEnumDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_literals_3_0 = null;



        	enterRule();

        try {
            // InternalLucraDSL.g:484:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleEnumLiteral ) )* otherlv_4= '}' ) )
            // InternalLucraDSL.g:485:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleEnumLiteral ) )* otherlv_4= '}' )
            {
            // InternalLucraDSL.g:485:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleEnumLiteral ) )* otherlv_4= '}' )
            // InternalLucraDSL.g:486:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleEnumLiteral ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumDslAccess().getEnumKeyword_0());
            		
            // InternalLucraDSL.g:490:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLucraDSL.g:491:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLucraDSL.g:491:4: (lv_name_1_0= RULE_ID )
            // InternalLucraDSL.g:492:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumDslAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumDslRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumDslAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLucraDSL.g:512:3: ( (lv_literals_3_0= ruleEnumLiteral ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalLucraDSL.g:513:4: (lv_literals_3_0= ruleEnumLiteral )
            	    {
            	    // InternalLucraDSL.g:513:4: (lv_literals_3_0= ruleEnumLiteral )
            	    // InternalLucraDSL.g:514:5: lv_literals_3_0= ruleEnumLiteral
            	    {

            	    					newCompositeNode(grammarAccess.getEnumDslAccess().getLiteralsEnumLiteralParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_literals_3_0=ruleEnumLiteral();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnumDslRule());
            	    					}
            	    					add(
            	    						current,
            	    						"literals",
            	    						lv_literals_3_0,
            	    						"br.com.lucra.LucraDSL.EnumLiteral");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumDslAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumDsl"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalLucraDSL.g:539:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalLucraDSL.g:539:52: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalLucraDSL.g:540:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalLucraDSL.g:546:1: ruleEnumLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalLucraDSL.g:552:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalLucraDSL.g:553:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalLucraDSL.g:553:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalLucraDSL.g:554:3: (lv_name_0_0= RULE_ID )
            {
            // InternalLucraDSL.g:554:3: (lv_name_0_0= RULE_ID )
            // InternalLucraDSL.g:555:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEnumLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "ruleRelationType"
    // InternalLucraDSL.g:574:1: ruleRelationType returns [Enumerator current=null] : ( (enumLiteral_0= 'contains' ) | (enumLiteral_1= 'contained' ) | (enumLiteral_2= 'refers' ) ) ;
    public final Enumerator ruleRelationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalLucraDSL.g:580:2: ( ( (enumLiteral_0= 'contains' ) | (enumLiteral_1= 'contained' ) | (enumLiteral_2= 'refers' ) ) )
            // InternalLucraDSL.g:581:2: ( (enumLiteral_0= 'contains' ) | (enumLiteral_1= 'contained' ) | (enumLiteral_2= 'refers' ) )
            {
            // InternalLucraDSL.g:581:2: ( (enumLiteral_0= 'contains' ) | (enumLiteral_1= 'contained' ) | (enumLiteral_2= 'refers' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt10=1;
                }
                break;
            case 24:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalLucraDSL.g:582:3: (enumLiteral_0= 'contains' )
                    {
                    // InternalLucraDSL.g:582:3: (enumLiteral_0= 'contains' )
                    // InternalLucraDSL.g:583:4: enumLiteral_0= 'contains'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getRelationTypeAccess().getCONTAINSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRelationTypeAccess().getCONTAINSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLucraDSL.g:590:3: (enumLiteral_1= 'contained' )
                    {
                    // InternalLucraDSL.g:590:3: (enumLiteral_1= 'contained' )
                    // InternalLucraDSL.g:591:4: enumLiteral_1= 'contained'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getRelationTypeAccess().getCONTAINEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRelationTypeAccess().getCONTAINEDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalLucraDSL.g:598:3: (enumLiteral_2= 'refers' )
                    {
                    // InternalLucraDSL.g:598:3: (enumLiteral_2= 'refers' )
                    // InternalLucraDSL.g:599:4: enumLiteral_2= 'refers'
                    {
                    enumLiteral_2=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getRelationTypeAccess().getREFERSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRelationTypeAccess().getREFERSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001F810L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000003B00002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000003A00002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000003800002L});

}