// Generated from C:/Users/MY/IdeaProjects/hw2/src/main\gram.g4 by ANTLR 4.7
package com.company.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TERMINATOR=1, WS=2, COMMA=3, TARGET=4, MEANS=5, OR=6, AND=7, NOT=8, LPAREN=9, 
		RPAREN=10, EXISTS=11, FORALL=12, EQUALS=13, PLUS=14, MUL=15, ADDONE=16, 
		ZERO=17, Name=18, Variable=19, GenericPredicate=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TERMINATOR", "WS", "COMMA", "TARGET", "MEANS", "OR", "AND", "NOT", "LPAREN", 
		"RPAREN", "EXISTS", "FORALL", "EQUALS", "PLUS", "MUL", "ADDONE", "ZERO", 
		"Name", "Variable", "GenericPredicate"
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


	public gramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26n\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\5\2\60\n\2\3\3\6\3\63\n"+
		"\3\r\3\16\3\64\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\5\23Z\n\23\3\23\3\23\7\23^\n\23\f\23\16\23"+
		"a\13\23\3\24\3\24\7\24e\n\24\f\24\16\24h\13\24\3\25\6\25k\n\25\r\25\16"+
		"\25l\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\7\4\2\f\f\17\17\4\2\13\13\"\""+
		"\3\2C\\\3\2\62;\3\2c|\2t\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3/\3\2\2"+
		"\2\5\62\3\2\2\2\78\3\2\2\2\t:\3\2\2\2\13=\3\2\2\2\r@\3\2\2\2\17B\3\2\2"+
		"\2\21D\3\2\2\2\23F\3\2\2\2\25H\3\2\2\2\27J\3\2\2\2\31L\3\2\2\2\33N\3\2"+
		"\2\2\35P\3\2\2\2\37R\3\2\2\2!T\3\2\2\2#V\3\2\2\2%Y\3\2\2\2\'b\3\2\2\2"+
		")j\3\2\2\2+\60\t\2\2\2,-\7\17\2\2-\60\7\f\2\2.\60\7\2\2\3/+\3\2\2\2/,"+
		"\3\2\2\2/.\3\2\2\2\60\4\3\2\2\2\61\63\t\3\2\2\62\61\3\2\2\2\63\64\3\2"+
		"\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\b\3\2\2\67\6\3\2"+
		"\2\289\7.\2\29\b\3\2\2\2:;\7~\2\2;<\7/\2\2<\n\3\2\2\2=>\7/\2\2>?\7@\2"+
		"\2?\f\3\2\2\2@A\7~\2\2A\16\3\2\2\2BC\7(\2\2C\20\3\2\2\2DE\7#\2\2E\22\3"+
		"\2\2\2FG\7*\2\2G\24\3\2\2\2HI\7+\2\2I\26\3\2\2\2JK\7A\2\2K\30\3\2\2\2"+
		"LM\7B\2\2M\32\3\2\2\2NO\7?\2\2O\34\3\2\2\2PQ\7-\2\2Q\36\3\2\2\2RS\7,\2"+
		"\2S \3\2\2\2TU\7)\2\2U\"\3\2\2\2VW\7\62\2\2W$\3\2\2\2XZ\7&\2\2YX\3\2\2"+
		"\2YZ\3\2\2\2Z[\3\2\2\2[_\t\4\2\2\\^\t\5\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2"+
		"\2\2_`\3\2\2\2`&\3\2\2\2a_\3\2\2\2bf\t\6\2\2ce\t\5\2\2dc\3\2\2\2eh\3\2"+
		"\2\2fd\3\2\2\2fg\3\2\2\2g(\3\2\2\2hf\3\2\2\2ik\t\4\2\2ji\3\2\2\2kl\3\2"+
		"\2\2lj\3\2\2\2lm\3\2\2\2m*\3\2\2\2\t\2/\64Y_fl\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}