// Generated from gramaticas/MensagensLexer.g4 by ANTLR 4.13.2
package chatmultithread.lexer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MensagensLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEG_ESQ=1, NEG_DIR=2, ITA_ESQ=3, ITA_DIR=4, COR_ESQ=5, COR_DIR=6, CMD_PONTO_INI=7, 
		CMD_LINHA_INI=8, CMD_RETANGULO_INI=9, CMD_CIRCULO_INI=10, CMD_COR_INI=11, 
		STRING=12, CHAR=13, CMD_FIM=14, NUM_INT=15, NUM_HEX_TOK=16, SEP=17;
	public static final int
		MODO_DESENHO=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "MODO_DESENHO"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEG_ESQ", "NEG_DIR", "ITA_ESQ", "ITA_DIR", "COR_ESQ", "COR_DIR", "CMD_PONTO_INI", 
			"CMD_LINHA_INI", "CMD_RETANGULO_INI", "CMD_CIRCULO_INI", "CMD_COR_INI", 
			"STRING", "CHAR", "NUM_HEX", "DIG_HEX", "CMD_FIM", "NUM_INT", "NUM_HEX_TOK", 
			"SEP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[b]'", "'[/b]'", "'[i]'", "'[/i]'", null, "'[/c]'", "'[ponto'", 
			"'[linha'", "'[retangulo'", "'[circulo'", "'[cor'", null, null, "'/]'", 
			null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEG_ESQ", "NEG_DIR", "ITA_ESQ", "ITA_DIR", "COR_ESQ", "COR_DIR", 
			"CMD_PONTO_INI", "CMD_LINHA_INI", "CMD_RETANGULO_INI", "CMD_CIRCULO_INI", 
			"CMD_COR_INI", "STRING", "CHAR", "CMD_FIM", "NUM_INT", "NUM_HEX_TOK", 
			"SEP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public MensagensLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MensagensLexer.g4"; }

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
		"\u0004\u0000\u0011\u009b\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"+
		"\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"+
		"\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"+
		"\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"+
		"\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002"+
		"\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000by\b\u000b\u000b\u000b\f\u000bz\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0003\u0010\u008f\b\u0010\u0001\u0010\u0004\u0010\u0092"+
		"\b\u0010\u000b\u0010\f\u0010\u0093\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0002\u0001\u0004"+
		"\u0002\u0006\u0003\b\u0004\n\u0005\f\u0006\u000e\u0007\u0010\b\u0012\t"+
		"\u0014\n\u0016\u000b\u0018\f\u001a\r\u001c\u0000\u001e\u0000 \u000e\""+
		"\u000f$\u0010&\u0011\u0002\u0000\u0001\u0003\u0004\u0000\n\n\r\r\"\"["+
		"]\u0003\u000009AFaf\u0001\u000009\u009a\u0000\u0002\u0001\u0000\u0000"+
		"\u0000\u0000\u0004\u0001\u0000\u0000\u0000\u0000\u0006\u0001\u0000\u0000"+
		"\u0000\u0000\b\u0001\u0000\u0000\u0000\u0000\n\u0001\u0000\u0000\u0000"+
		"\u0000\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001\u0000\u0000\u0000\u0000"+
		"\u0010\u0001\u0000\u0000\u0000\u0000\u0012\u0001\u0000\u0000\u0000\u0000"+
		"\u0014\u0001\u0000\u0000\u0000\u0000\u0016\u0001\u0000\u0000\u0000\u0000"+
		"\u0018\u0001\u0000\u0000\u0000\u0000\u001a\u0001\u0000\u0000\u0000\u0001"+
		" \u0001\u0000\u0000\u0000\u0001\"\u0001\u0000\u0000\u0000\u0001$\u0001"+
		"\u0000\u0000\u0000\u0001&\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000"+
		"\u0000\u0004,\u0001\u0000\u0000\u0000\u00061\u0001\u0000\u0000\u0000\b"+
		"5\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000\u0000\fA\u0001\u0000\u0000"+
		"\u0000\u000eF\u0001\u0000\u0000\u0000\u0010O\u0001\u0000\u0000\u0000\u0012"+
		"X\u0001\u0000\u0000\u0000\u0014e\u0001\u0000\u0000\u0000\u0016p\u0001"+
		"\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a|\u0001\u0000\u0000"+
		"\u0000\u001c~\u0001\u0000\u0000\u0000\u001e\u0086\u0001\u0000\u0000\u0000"+
		" \u0088\u0001\u0000\u0000\u0000\"\u008e\u0001\u0000\u0000\u0000$\u0095"+
		"\u0001\u0000\u0000\u0000&\u0097\u0001\u0000\u0000\u0000()\u0005[\u0000"+
		"\u0000)*\u0005b\u0000\u0000*+\u0005]\u0000\u0000+\u0003\u0001\u0000\u0000"+
		"\u0000,-\u0005[\u0000\u0000-.\u0005/\u0000\u0000./\u0005b\u0000\u0000"+
		"/0\u0005]\u0000\u00000\u0005\u0001\u0000\u0000\u000012\u0005[\u0000\u0000"+
		"23\u0005i\u0000\u000034\u0005]\u0000\u00004\u0007\u0001\u0000\u0000\u0000"+
		"56\u0005[\u0000\u000067\u0005/\u0000\u000078\u0005i\u0000\u000089\u0005"+
		"]\u0000\u00009\t\u0001\u0000\u0000\u0000:;\u0005[\u0000\u0000;<\u0005"+
		"c\u0000\u0000<=\u0005 \u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0003\u001c"+
		"\r\u0000?@\u0005]\u0000\u0000@\u000b\u0001\u0000\u0000\u0000AB\u0005["+
		"\u0000\u0000BC\u0005/\u0000\u0000CD\u0005c\u0000\u0000DE\u0005]\u0000"+
		"\u0000E\r\u0001\u0000\u0000\u0000FG\u0005[\u0000\u0000GH\u0005p\u0000"+
		"\u0000HI\u0005o\u0000\u0000IJ\u0005n\u0000\u0000JK\u0005t\u0000\u0000"+
		"KL\u0005o\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0006\u0006\u0000\u0000"+
		"N\u000f\u0001\u0000\u0000\u0000OP\u0005[\u0000\u0000PQ\u0005l\u0000\u0000"+
		"QR\u0005i\u0000\u0000RS\u0005n\u0000\u0000ST\u0005h\u0000\u0000TU\u0005"+
		"a\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0006\u0007\u0000\u0000W\u0011"+
		"\u0001\u0000\u0000\u0000XY\u0005[\u0000\u0000YZ\u0005r\u0000\u0000Z[\u0005"+
		"e\u0000\u0000[\\\u0005t\u0000\u0000\\]\u0005a\u0000\u0000]^\u0005n\u0000"+
		"\u0000^_\u0005g\u0000\u0000_`\u0005u\u0000\u0000`a\u0005l\u0000\u0000"+
		"ab\u0005o\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0006\b\u0000\u0000"+
		"d\u0013\u0001\u0000\u0000\u0000ef\u0005[\u0000\u0000fg\u0005c\u0000\u0000"+
		"gh\u0005i\u0000\u0000hi\u0005r\u0000\u0000ij\u0005c\u0000\u0000jk\u0005"+
		"u\u0000\u0000kl\u0005l\u0000\u0000lm\u0005o\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0006\t\u0000\u0000o\u0015\u0001\u0000\u0000\u0000pq\u0005"+
		"[\u0000\u0000qr\u0005c\u0000\u0000rs\u0005o\u0000\u0000st\u0005r\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000uv\u0006\n\u0000\u0000v\u0017\u0001\u0000"+
		"\u0000\u0000wy\u0003\u001a\f\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0019"+
		"\u0001\u0000\u0000\u0000|}\b\u0000\u0000\u0000}\u001b\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005#\u0000\u0000\u007f\u0080\u0003\u001e\u000e\u0000\u0080"+
		"\u0081\u0003\u001e\u000e\u0000\u0081\u0082\u0003\u001e\u000e\u0000\u0082"+
		"\u0083\u0003\u001e\u000e\u0000\u0083\u0084\u0003\u001e\u000e\u0000\u0084"+
		"\u0085\u0003\u001e\u000e\u0000\u0085\u001d\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0007\u0001\u0000\u0000\u0087\u001f\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005/\u0000\u0000\u0089\u008a\u0005]\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0006\u000f\u0001\u0000\u008c!\u0001\u0000"+
		"\u0000\u0000\u008d\u008f\u0005-\u0000\u0000\u008e\u008d\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000"+
		"\u0000\u0090\u0092\u0007\u0002\u0000\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094#\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0003\u001c\r\u0000\u0096%\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005 \u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0006\u0012\u0002\u0000\u009a\'\u0001\u0000\u0000\u0000\u0005\u0000\u0001"+
		"z\u008e\u0093\u0003\u0005\u0001\u0000\u0004\u0000\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}