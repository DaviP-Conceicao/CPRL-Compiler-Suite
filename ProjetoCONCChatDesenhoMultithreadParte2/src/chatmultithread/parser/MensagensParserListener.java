// Generated from gramaticas/MensagensParser.g4 by ANTLR 4.13.2
package chatmultithread.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MensagensParser}.
 */
public interface MensagensParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MensagensParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(MensagensParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link MensagensParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(MensagensParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mensagemNegrito}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void enterMensagemNegrito(MensagensParser.MensagemNegritoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mensagemNegrito}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void exitMensagemNegrito(MensagensParser.MensagemNegritoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mensagemItalico}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void enterMensagemItalico(MensagensParser.MensagemItalicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mensagemItalico}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void exitMensagemItalico(MensagensParser.MensagemItalicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mensagemCor}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void enterMensagemCor(MensagensParser.MensagemCorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mensagemCor}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void exitMensagemCor(MensagensParser.MensagemCorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code partes}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void enterPartes(MensagensParser.PartesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code partes}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void exitPartes(MensagensParser.PartesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mensagemDesenho}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void enterMensagemDesenho(MensagensParser.MensagemDesenhoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mensagemDesenho}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 */
	void exitMensagemDesenho(MensagensParser.MensagemDesenhoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MensagensParser#texto}.
	 * @param ctx the parse tree
	 */
	void enterTexto(MensagensParser.TextoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MensagensParser#texto}.
	 * @param ctx the parse tree
	 */
	void exitTexto(MensagensParser.TextoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code desenhoPonto}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void enterDesenhoPonto(MensagensParser.DesenhoPontoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code desenhoPonto}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void exitDesenhoPonto(MensagensParser.DesenhoPontoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code desenhoLinha}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void enterDesenhoLinha(MensagensParser.DesenhoLinhaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code desenhoLinha}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void exitDesenhoLinha(MensagensParser.DesenhoLinhaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code desenhoRetangulo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void enterDesenhoRetangulo(MensagensParser.DesenhoRetanguloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code desenhoRetangulo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void exitDesenhoRetangulo(MensagensParser.DesenhoRetanguloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code desenhoCirculo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void enterDesenhoCirculo(MensagensParser.DesenhoCirculoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code desenhoCirculo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void exitDesenhoCirculo(MensagensParser.DesenhoCirculoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code desenhoCor}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void enterDesenhoCor(MensagensParser.DesenhoCorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code desenhoCor}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 */
	void exitDesenhoCor(MensagensParser.DesenhoCorContext ctx);
}