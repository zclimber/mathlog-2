// Generated from C:/Users/MY/IdeaProjects/hw2/src/main\gram.g4 by ANTLR 4.7
package com.company.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TERMINATOR=1, WS=2, COMMA=3, TARGET=4, MEANS=5, OR=6, AND=7, NOT=8, LPAREN=9, 
		RPAREN=10, EXISTS=11, FORALL=12, EQUALS=13, PLUS=14, MUL=15, ADDONE=16, 
		ZERO=17, Name=18, Variable=19, GenericPredicate=20;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_rootExpression = 2, RULE_expression = 3, 
		RULE_disj = 4, RULE_conj = 5, RULE_unary = 6, RULE_tieVariable = 7, RULE_tieVariableExist = 8, 
		RULE_tieVariableForAll = 9, RULE_predicate = 10, RULE_add = 11, RULE_mul = 12, 
		RULE_term = 13, RULE_arglist = 14;
	public static final String[] ruleNames = {
		"file", "header", "rootExpression", "expression", "disj", "conj", "unary", 
		"tieVariable", "tieVariableExist", "tieVariableForAll", "predicate", "add", 
		"mul", "term", "arglist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "','", "'|-'", "'->'", "'|'", "'&'", "'!'", "'('", "')'", 
		"'?'", "'@'", "'='", "'+'", "'*'", "'''", "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TERMINATOR", "WS", "COMMA", "TARGET", "MEANS", "OR", "AND", "NOT", 
		"LPAREN", "RPAREN", "EXISTS", "FORALL", "EQUALS", "PLUS", "MUL", "ADDONE", 
		"ZERO", "Name", "Variable", "GenericPredicate"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> TERMINATOR() { return getTokens(gramParser.TERMINATOR); }
		public TerminalNode TERMINATOR(int i) {
			return getToken(gramParser.TERMINATOR, i);
		}
		public List<RootExpressionContext> rootExpression() {
			return getRuleContexts(RootExpressionContext.class);
		}
		public RootExpressionContext rootExpression(int i) {
			return getRuleContext(RootExpressionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			header();
			setState(31);
			match(TERMINATOR);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LPAREN) | (1L << EXISTS) | (1L << FORALL) | (1L << ZERO) | (1L << Name) | (1L << Variable))) != 0)) {
				{
				{
				setState(32);
				rootExpression();
				setState(33);
				match(TERMINATOR);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode TARGET() { return getToken(gramParser.TARGET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gramParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gramParser.COMMA, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LPAREN) | (1L << EXISTS) | (1L << FORALL) | (1L << ZERO) | (1L << Name) | (1L << Variable))) != 0)) {
				{
				setState(40);
				expression();
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(41);
					match(COMMA);
					setState(42);
					expression();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(50);
			match(TARGET);
			setState(51);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RootExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterRootExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitRootExpression(this);
		}
	}

	public final RootExpressionContext rootExpression() throws RecognitionException {
		RootExpressionContext _localctx = new RootExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rootExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public DisjContext disj() {
			return getRuleContext(DisjContext.class,0);
		}
		public TerminalNode MEANS() { return getToken(gramParser.MEANS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				disj(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(56);
				disj(0);
				setState(57);
				match(MEANS);
				setState(58);
				expression();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjContext extends ParserRuleContext {
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public DisjContext disj() {
			return getRuleContext(DisjContext.class,0);
		}
		public TerminalNode OR() { return getToken(gramParser.OR, 0); }
		public DisjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterDisj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitDisj(this);
		}
	}

	public final DisjContext disj() throws RecognitionException {
		return disj(0);
	}

	private DisjContext disj(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisjContext _localctx = new DisjContext(_ctx, _parentState);
		DisjContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_disj, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(63);
			conj(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisjContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_disj);
					setState(65);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(66);
					match(OR);
					setState(67);
					conj(0);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConjContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public TerminalNode AND() { return getToken(gramParser.AND, 0); }
		public ConjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterConj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitConj(this);
		}
	}

	public final ConjContext conj() throws RecognitionException {
		return conj(0);
	}

	private ConjContext conj(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConjContext _localctx = new ConjContext(_ctx, _parentState);
		ConjContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_conj, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(74);
			unary();
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConjContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conj);
					setState(76);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(77);
					match(AND);
					setState(78);
					unary();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NOT() { return getToken(gramParser.NOT, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(gramParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(gramParser.RPAREN, 0); }
		public TieVariableContext tieVariable() {
			return getRuleContext(TieVariableContext.class,0);
		}
		public TerminalNode Name() { return getToken(gramParser.Name, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unary);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(NOT);
				setState(86);
				unary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(LPAREN);
				setState(88);
				expression();
				setState(89);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				tieVariable();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(Name);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TieVariableContext extends ParserRuleContext {
		public TieVariableExistContext tieVariableExist() {
			return getRuleContext(TieVariableExistContext.class,0);
		}
		public TieVariableForAllContext tieVariableForAll() {
			return getRuleContext(TieVariableForAllContext.class,0);
		}
		public TieVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tieVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterTieVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitTieVariable(this);
		}
	}

	public final TieVariableContext tieVariable() throws RecognitionException {
		TieVariableContext _localctx = new TieVariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tieVariable);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXISTS:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				tieVariableExist();
				}
				break;
			case FORALL:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				tieVariableForAll();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TieVariableExistContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(gramParser.EXISTS, 0); }
		public TerminalNode Variable() { return getToken(gramParser.Variable, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TieVariableExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tieVariableExist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterTieVariableExist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitTieVariableExist(this);
		}
	}

	public final TieVariableExistContext tieVariableExist() throws RecognitionException {
		TieVariableExistContext _localctx = new TieVariableExistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tieVariableExist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(EXISTS);
			setState(100);
			match(Variable);
			setState(101);
			unary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TieVariableForAllContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(gramParser.FORALL, 0); }
		public TerminalNode Variable() { return getToken(gramParser.Variable, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TieVariableForAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tieVariableForAll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterTieVariableForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitTieVariableForAll(this);
		}
	}

	public final TieVariableForAllContext tieVariableForAll() throws RecognitionException {
		TieVariableForAllContext _localctx = new TieVariableForAllContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tieVariableForAll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(FORALL);
			setState(104);
			match(Variable);
			setState(105);
			unary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(gramParser.Name, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(gramParser.EQUALS, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_predicate);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Name:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(Name);
				setState(108);
				arglist();
				}
				break;
			case LPAREN:
			case ZERO:
			case Variable:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				add(0);
				setState(110);
				match(EQUALS);
				setState(111);
				add(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(gramParser.PLUS, 0); }
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		return add(0);
	}

	private AddContext add(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddContext _localctx = new AddContext(_ctx, _parentState);
		AddContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_add, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(116);
			mul(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_add);
					setState(118);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(119);
					match(PLUS);
					setState(120);
					mul(0);
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public TerminalNode MUL() { return getToken(gramParser.MUL, 0); }
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitMul(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		return mul(0);
	}

	private MulContext mul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulContext _localctx = new MulContext(_ctx, _parentState);
		MulContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_mul, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(127);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mul);
					setState(129);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(130);
					match(MUL);
					setState(131);
					term(0);
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(gramParser.Variable, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(gramParser.LPAREN, 0); }
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(gramParser.RPAREN, 0); }
		public TerminalNode ZERO() { return getToken(gramParser.ZERO, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADDONE() { return getToken(gramParser.ADDONE, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(138);
				match(Variable);
				setState(139);
				arglist();
				}
				break;
			case 2:
				{
				setState(140);
				match(Variable);
				}
				break;
			case 3:
				{
				setState(141);
				match(LPAREN);
				setState(142);
				add(0);
				setState(143);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(145);
				match(ZERO);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(148);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(149);
					match(ADDONE);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(gramParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(gramParser.RPAREN, 0); }
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gramParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gramParser.COMMA, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitArglist(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LPAREN);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << ZERO) | (1L << Variable))) != 0)) {
				{
				setState(156);
				add(0);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(157);
					match(COMMA);
					setState(158);
					add(0);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(166);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return disj_sempred((DisjContext)_localctx, predIndex);
		case 5:
			return conj_sempred((ConjContext)_localctx, predIndex);
		case 11:
			return add_sempred((AddContext)_localctx, predIndex);
		case 12:
			return mul_sempred((MulContext)_localctx, predIndex);
		case 13:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean disj_sempred(DisjContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conj_sempred(ConjContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean add_sempred(AddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mul_sempred(MulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00ab\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\5\3\63"+
		"\n\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7R\n\7\f\7"+
		"\16\7U\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\t\3\t\5\td"+
		"\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\ft"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u0087\n\16\f\16\16\16\u008a\13\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0095\n\17\3\17\3\17\7\17\u0099\n"+
		"\17\f\17\16\17\u009c\13\17\3\20\3\20\3\20\3\20\7\20\u00a2\n\20\f\20\16"+
		"\20\u00a5\13\20\5\20\u00a7\n\20\3\20\3\20\3\20\2\7\n\f\30\32\34\21\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u00af\2 \3\2\2\2\4\62\3\2\2"+
		"\2\6\67\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fK\3\2\2\2\16_\3\2\2\2\20c\3\2\2"+
		"\2\22e\3\2\2\2\24i\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32\u0080\3\2\2\2\34"+
		"\u0094\3\2\2\2\36\u009d\3\2\2\2 !\5\4\3\2!\'\7\3\2\2\"#\5\6\4\2#$\7\3"+
		"\2\2$&\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)"+
		"\'\3\2\2\2*/\5\b\5\2+,\7\5\2\2,.\5\b\5\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
		"\2/\60\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\62*\3\2\2\2\62\63\3\2\2\2\63"+
		"\64\3\2\2\2\64\65\7\6\2\2\65\66\5\b\5\2\66\5\3\2\2\2\678\5\b\5\28\7\3"+
		"\2\2\29?\5\n\6\2:;\5\n\6\2;<\7\7\2\2<=\5\b\5\2=?\3\2\2\2>9\3\2\2\2>:\3"+
		"\2\2\2?\t\3\2\2\2@A\b\6\1\2AB\5\f\7\2BH\3\2\2\2CD\f\3\2\2DE\7\b\2\2EG"+
		"\5\f\7\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JH\3\2\2\2"+
		"KL\b\7\1\2LM\5\16\b\2MS\3\2\2\2NO\f\3\2\2OP\7\t\2\2PR\5\16\b\2QN\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\r\3\2\2\2US\3\2\2\2V`\5\26\f\2WX\7\n"+
		"\2\2X`\5\16\b\2YZ\7\13\2\2Z[\5\b\5\2[\\\7\f\2\2\\`\3\2\2\2]`\5\20\t\2"+
		"^`\7\24\2\2_V\3\2\2\2_W\3\2\2\2_Y\3\2\2\2_]\3\2\2\2_^\3\2\2\2`\17\3\2"+
		"\2\2ad\5\22\n\2bd\5\24\13\2ca\3\2\2\2cb\3\2\2\2d\21\3\2\2\2ef\7\r\2\2"+
		"fg\7\25\2\2gh\5\16\b\2h\23\3\2\2\2ij\7\16\2\2jk\7\25\2\2kl\5\16\b\2l\25"+
		"\3\2\2\2mn\7\24\2\2nt\5\36\20\2op\5\30\r\2pq\7\17\2\2qr\5\30\r\2rt\3\2"+
		"\2\2sm\3\2\2\2so\3\2\2\2t\27\3\2\2\2uv\b\r\1\2vw\5\32\16\2w}\3\2\2\2x"+
		"y\f\3\2\2yz\7\20\2\2z|\5\32\16\2{x\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3"+
		"\2\2\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0081\b\16\1\2\u0081\u0082\5\34"+
		"\17\2\u0082\u0088\3\2\2\2\u0083\u0084\f\3\2\2\u0084\u0085\7\21\2\2\u0085"+
		"\u0087\5\34\17\2\u0086\u0083\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0089\33\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\b\17\1\2\u008c\u008d\7\25\2\2\u008d\u0095\5\36\20\2\u008e\u0095"+
		"\7\25\2\2\u008f\u0090\7\13\2\2\u0090\u0091\5\30\r\2\u0091\u0092\7\f\2"+
		"\2\u0092\u0095\3\2\2\2\u0093\u0095\7\23\2\2\u0094\u008b\3\2\2\2\u0094"+
		"\u008e\3\2\2\2\u0094\u008f\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u009a\3\2"+
		"\2\2\u0096\u0097\f\4\2\2\u0097\u0099\7\22\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\35\3\2\2"+
		"\2\u009c\u009a\3\2\2\2\u009d\u00a6\7\13\2\2\u009e\u00a3\5\30\r\2\u009f"+
		"\u00a0\7\5\2\2\u00a0\u00a2\5\30\r\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\7\f\2\2\u00a9\37\3\2\2\2\21\'/\62>HS_cs}\u0088\u0094"+
		"\u009a\u00a3\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}