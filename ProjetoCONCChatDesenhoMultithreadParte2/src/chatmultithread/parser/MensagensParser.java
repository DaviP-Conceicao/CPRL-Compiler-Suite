// Generated from gramaticas/MensagensParser.g4 by ANTLR 4.13.2
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
		NEG_ESQ=1, NEG_DIR=2, ITA_ESQ=3, ITA_DIR=4, COR_ESQ=5, COR_DIR=6, CMD_PONTO_INI=7, 
		CMD_LINHA_INI=8, CMD_RETANGULO_INI=9, CMD_CIRCULO_INI=10, CMD_COR_INI=11, 
		STRING=12, CHAR=13, CMD_FIM=14, NUM_INT=15, NUM_HEX_TOK=16, SEP=17;
	public static final int
		RULE_inicio = 0, RULE_mensagem = 1, RULE_texto = 2, RULE_desenho = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "mensagem", "texto", "desenho"
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

	@Override
	public String getGrammarFileName() { return "MensagensParser.g4"; }

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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitInicio(this);
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
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				mensagem();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8106L) != 0) );
			setState(13);
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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterMensagemCor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitMensagemCor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitMensagemCor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MensagemDesenhoContext extends MensagemContext {
		public DesenhoContext desenho() {
			return getRuleContext(DesenhoContext.class,0);
		}
		public MensagemDesenhoContext(MensagemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterMensagemDesenho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitMensagemDesenho(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitMensagemDesenho(this);
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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterMensagemItalico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitMensagemItalico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitMensagemItalico(this);
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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterPartes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitPartes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitPartes(this);
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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterMensagemNegrito(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitMensagemNegrito(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitMensagemNegrito(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensagemContext mensagem() throws RecognitionException {
		MensagemContext _localctx = new MensagemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mensagem);
		try {
			int _alt;
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG_ESQ:
				_localctx = new MensagemNegritoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				match(NEG_ESQ);
				setState(16);
				mensagem();
				setState(17);
				match(NEG_DIR);
				}
				break;
			case ITA_ESQ:
				_localctx = new MensagemItalicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(ITA_ESQ);
				setState(20);
				mensagem();
				setState(21);
				match(ITA_DIR);
				}
				break;
			case COR_ESQ:
				_localctx = new MensagemCorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				match(COR_ESQ);
				setState(24);
				mensagem();
				setState(25);
				match(COR_DIR);
				}
				break;
			case STRING:
				_localctx = new PartesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(27);
				texto();
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(28);
						mensagem();
						}
						} 
					}
					setState(33);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				break;
			case CMD_PONTO_INI:
			case CMD_LINHA_INI:
			case CMD_RETANGULO_INI:
			case CMD_CIRCULO_INI:
			case CMD_COR_INI:
				_localctx = new MensagemDesenhoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				desenho();
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
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterTexto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitTexto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitTexto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextoContext texto() throws RecognitionException {
		TextoContext _localctx = new TextoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_texto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoContext extends ParserRuleContext {
		public DesenhoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desenho; }
	 
		public DesenhoContext() { }
		public void copyFrom(DesenhoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoCirculoContext extends DesenhoContext {
		public TerminalNode CMD_CIRCULO_INI() { return getToken(MensagensParser.CMD_CIRCULO_INI, 0); }
		public List<TerminalNode> NUM_INT() { return getTokens(MensagensParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(MensagensParser.NUM_INT, i);
		}
		public TerminalNode CMD_FIM() { return getToken(MensagensParser.CMD_FIM, 0); }
		public DesenhoCirculoContext(DesenhoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterDesenhoCirculo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitDesenhoCirculo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitDesenhoCirculo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoPontoContext extends DesenhoContext {
		public TerminalNode CMD_PONTO_INI() { return getToken(MensagensParser.CMD_PONTO_INI, 0); }
		public List<TerminalNode> NUM_INT() { return getTokens(MensagensParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(MensagensParser.NUM_INT, i);
		}
		public TerminalNode CMD_FIM() { return getToken(MensagensParser.CMD_FIM, 0); }
		public DesenhoPontoContext(DesenhoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterDesenhoPonto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitDesenhoPonto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitDesenhoPonto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoRetanguloContext extends DesenhoContext {
		public TerminalNode CMD_RETANGULO_INI() { return getToken(MensagensParser.CMD_RETANGULO_INI, 0); }
		public List<TerminalNode> NUM_INT() { return getTokens(MensagensParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(MensagensParser.NUM_INT, i);
		}
		public TerminalNode CMD_FIM() { return getToken(MensagensParser.CMD_FIM, 0); }
		public DesenhoRetanguloContext(DesenhoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterDesenhoRetangulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitDesenhoRetangulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitDesenhoRetangulo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoLinhaContext extends DesenhoContext {
		public TerminalNode CMD_LINHA_INI() { return getToken(MensagensParser.CMD_LINHA_INI, 0); }
		public List<TerminalNode> NUM_INT() { return getTokens(MensagensParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(MensagensParser.NUM_INT, i);
		}
		public TerminalNode CMD_FIM() { return getToken(MensagensParser.CMD_FIM, 0); }
		public DesenhoLinhaContext(DesenhoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterDesenhoLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitDesenhoLinha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitDesenhoLinha(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DesenhoCorContext extends DesenhoContext {
		public TerminalNode CMD_COR_INI() { return getToken(MensagensParser.CMD_COR_INI, 0); }
		public TerminalNode NUM_HEX_TOK() { return getToken(MensagensParser.NUM_HEX_TOK, 0); }
		public TerminalNode CMD_FIM() { return getToken(MensagensParser.CMD_FIM, 0); }
		public DesenhoCorContext(DesenhoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).enterDesenhoCor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MensagensParserListener ) ((MensagensParserListener)listener).exitDesenhoCor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MensagensParserVisitor ) return ((MensagensParserVisitor<? extends T>)visitor).visitDesenhoCor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesenhoContext desenho() throws RecognitionException {
		DesenhoContext _localctx = new DesenhoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_desenho);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CMD_PONTO_INI:
				_localctx = new DesenhoPontoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(CMD_PONTO_INI);
				setState(40);
				match(NUM_INT);
				setState(41);
				match(NUM_INT);
				setState(42);
				match(CMD_FIM);
				}
				break;
			case CMD_LINHA_INI:
				_localctx = new DesenhoLinhaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(CMD_LINHA_INI);
				setState(44);
				match(NUM_INT);
				setState(45);
				match(NUM_INT);
				setState(46);
				match(NUM_INT);
				setState(47);
				match(NUM_INT);
				setState(48);
				match(CMD_FIM);
				}
				break;
			case CMD_RETANGULO_INI:
				_localctx = new DesenhoRetanguloContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				match(CMD_RETANGULO_INI);
				setState(50);
				match(NUM_INT);
				setState(51);
				match(NUM_INT);
				setState(52);
				match(NUM_INT);
				setState(53);
				match(NUM_INT);
				setState(54);
				match(CMD_FIM);
				}
				break;
			case CMD_CIRCULO_INI:
				_localctx = new DesenhoCirculoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(CMD_CIRCULO_INI);
				setState(56);
				match(NUM_INT);
				setState(57);
				match(NUM_INT);
				setState(58);
				match(NUM_INT);
				setState(59);
				match(CMD_FIM);
				}
				break;
			case CMD_COR_INI:
				_localctx = new DesenhoCorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(CMD_COR_INI);
				setState(61);
				match(NUM_HEX_TOK);
				setState(62);
				match(CMD_FIM);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0011B\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0004\u0000\n\b"+
		"\u0000\u000b\u0000\f\u0000\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0001"+
		"\u0003\u0001$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003@\b\u0003"+
		"\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000G\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000\u0000\u0004%\u0001"+
		"\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\b\n\u0003\u0002\u0001"+
		"\u0000\t\b\u0001\u0000\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b"+
		"\t\u0001\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000\u0000\f\r\u0001\u0000"+
		"\u0000\u0000\r\u000e\u0005\u0000\u0000\u0001\u000e\u0001\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0005\u0001\u0000\u0000\u0010\u0011\u0003\u0002\u0001"+
		"\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012$\u0001\u0000\u0000\u0000"+
		"\u0013\u0014\u0005\u0003\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000"+
		"\u0015\u0016\u0005\u0004\u0000\u0000\u0016$\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005\u0005\u0000\u0000\u0018\u0019\u0003\u0002\u0001\u0000\u0019"+
		"\u001a\u0005\u0006\u0000\u0000\u001a$\u0001\u0000\u0000\u0000\u001b\u001f"+
		"\u0003\u0004\u0002\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 $\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000\"$\u0003\u0006\u0003\u0000#\u000f"+
		"\u0001\u0000\u0000\u0000#\u0013\u0001\u0000\u0000\u0000#\u0017\u0001\u0000"+
		"\u0000\u0000#\u001b\u0001\u0000\u0000\u0000#\"\u0001\u0000\u0000\u0000"+
		"$\u0003\u0001\u0000\u0000\u0000%&\u0005\f\u0000\u0000&\u0005\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0007\u0000\u0000()\u0005\u000f\u0000\u0000)*\u0005"+
		"\u000f\u0000\u0000*@\u0005\u000e\u0000\u0000+,\u0005\b\u0000\u0000,-\u0005"+
		"\u000f\u0000\u0000-.\u0005\u000f\u0000\u0000./\u0005\u000f\u0000\u0000"+
		"/0\u0005\u000f\u0000\u00000@\u0005\u000e\u0000\u000012\u0005\t\u0000\u0000"+
		"23\u0005\u000f\u0000\u000034\u0005\u000f\u0000\u000045\u0005\u000f\u0000"+
		"\u000056\u0005\u000f\u0000\u00006@\u0005\u000e\u0000\u000078\u0005\n\u0000"+
		"\u000089\u0005\u000f\u0000\u00009:\u0005\u000f\u0000\u0000:;\u0005\u000f"+
		"\u0000\u0000;@\u0005\u000e\u0000\u0000<=\u0005\u000b\u0000\u0000=>\u0005"+
		"\u0010\u0000\u0000>@\u0005\u000e\u0000\u0000?\'\u0001\u0000\u0000\u0000"+
		"?+\u0001\u0000\u0000\u0000?1\u0001\u0000\u0000\u0000?7\u0001\u0000\u0000"+
		"\u0000?<\u0001\u0000\u0000\u0000@\u0007\u0001\u0000\u0000\u0000\u0004"+
		"\u000b\u001f#?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}