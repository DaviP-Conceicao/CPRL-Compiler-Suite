// Generated from gramatica/Mensagens.g4 by ANTLR 4.13.2
package chatmultithread.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MensagensParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEG_ESQ=1, NEG_DIR=2, ITA_ESQ=3, ITA_DIR=4, COR_ESQ=5, COR_DIR=6, STRING=7, 
		CHAR=8;
	public static final int
		RULE_inicio = 0, RULE_mensagem = 1, RULE_texto = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "mensagem", "texto"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[b]'", "'[/b]'", "'[i]'", "'[/i]'", null, "'[/c]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEG_ESQ", "NEG_DIR", "ITA_ESQ", "ITA_DIR", "COR_ESQ", "COR_DIR", 
			"STRING", "CHAR"
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

	@Override
	public String getGrammarFileName() { return "Mensagens.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MensagensParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MensagensParser.EOF, 0); }
		public List<MensagemContext> mensagem() {
			return getRuleContexts(MensagemContext.class);
		}
		public MensagemContext mensagem(int i) {
			return getRuleContext(MensagemContext.class,i);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				mensagem();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 170L) != 0) );
			setState(11);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MensagemContext extends ParserRuleContext {
		public MensagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensagem; }
	 
		public MensagemContext() { }
		public void copyFrom(MensagemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MensagemCorContext extends MensagemContext {
		public TerminalNode COR_ESQ() { return getToken(MensagensParser.COR_ESQ, 0); }
		public MensagemContext mensagem() {
			return getRuleContext(MensagemContext.class,0);
		}
		public TerminalNode COR_DIR() { return getToken(MensagensParser.COR_DIR, 0); }
		public MensagemCorContext(MensagemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterMensagemCor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitMensagemCor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitMensagemCor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MensagemItalicoContext extends MensagemContext {
		public TerminalNode ITA_ESQ() { return getToken(MensagensParser.ITA_ESQ, 0); }
		public MensagemContext mensagem() {
			return getRuleContext(MensagemContext.class,0);
		}
		public TerminalNode ITA_DIR() { return getToken(MensagensParser.ITA_DIR, 0); }
		public MensagemItalicoContext(MensagemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterMensagemItalico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitMensagemItalico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitMensagemItalico(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PartesContext extends MensagemContext {
		public TextoContext texto() {
			return getRuleContext(TextoContext.class,0);
		}
		public List<MensagemContext> mensagem() {
			return getRuleContexts(MensagemContext.class);
		}
		public MensagemContext mensagem(int i) {
			return getRuleContext(MensagemContext.class,i);
		}
		public PartesContext(MensagemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterPartes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitPartes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitPartes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MensagemNegritoContext extends MensagemContext {
		public TerminalNode NEG_ESQ() { return getToken(MensagensParser.NEG_ESQ, 0); }
		public MensagemContext mensagem() {
			return getRuleContext(MensagemContext.class,0);
		}
		public TerminalNode NEG_DIR() { return getToken(MensagensParser.NEG_DIR, 0); }
		public MensagemNegritoContext(MensagemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterMensagemNegrito(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitMensagemNegrito(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitMensagemNegrito(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensagemContext mensagem() throws RecognitionException {
		MensagemContext _localctx = new MensagemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mensagem);
		try {
			int _alt;
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG_ESQ:
				_localctx = new MensagemNegritoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(NEG_ESQ);
				setState(14);
				mensagem();
				setState(15);
				match(NEG_DIR);
				}
				break;
			case ITA_ESQ:
				_localctx = new MensagemItalicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(ITA_ESQ);
				setState(18);
				mensagem();
				setState(19);
				match(ITA_DIR);
				}
				break;
			case COR_ESQ:
				_localctx = new MensagemCorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				match(COR_ESQ);
				setState(22);
				mensagem();
				setState(23);
				match(COR_DIR);
				}
				break;
			case STRING:
				_localctx = new PartesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				texto();
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(26);
						mensagem();
						}
						} 
					}
					setState(31);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TextoContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MensagensParser.STRING, 0); }
		public TextoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).enterTexto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensListener ) ((MensagensListener)listener).exitTexto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensVisitor ) return ((MensagensVisitor<? extends T>)visitor).visitTexto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextoContext texto() throws RecognitionException {
		TextoContext _localctx = new TextoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_texto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(STRING);
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

	public static final String _serializedATN =
		"\u0004\u0001\b%\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000"+
		"\t\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001"+
		"\n\u0001\f\u0001\u001f\t\u0001\u0003\u0001!\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000&\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004\""+
		"\u0001\u0000\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001"+
		"\u0000\u0000\u0000\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000"+
		"\u0000\t\n\u0001\u0000\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b"+
		"\f\u0005\u0000\u0000\u0001\f\u0001\u0001\u0000\u0000\u0000\r\u000e\u0005"+
		"\u0001\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0010\u0005"+
		"\u0002\u0000\u0000\u0010!\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0003"+
		"\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005\u0004"+
		"\u0000\u0000\u0014!\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0005\u0000"+
		"\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0018\u0005\u0006\u0000"+
		"\u0000\u0018!\u0001\u0000\u0000\u0000\u0019\u001d\u0003\u0004\u0002\u0000"+
		"\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000 \r\u0001\u0000\u0000\u0000 \u0011\u0001"+
		"\u0000\u0000\u0000 \u0015\u0001\u0000\u0000\u0000 \u0019\u0001\u0000\u0000"+
		"\u0000!\u0003\u0001\u0000\u0000\u0000\"#\u0005\u0007\u0000\u0000#\u0005"+
		"\u0001\u0000\u0000\u0000\u0003\t\u001d ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}