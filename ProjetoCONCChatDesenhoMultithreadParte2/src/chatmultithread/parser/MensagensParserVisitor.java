// Generated from gramaticas/MensagensParser.g4 by ANTLR 4.13.2
package chatmultithread.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MensagensParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MensagensParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MensagensParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(MensagensParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mensagemNegrito}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensagemNegrito(MensagensParser.MensagemNegritoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mensagemItalico}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensagemItalico(MensagensParser.MensagemItalicoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mensagemCor}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensagemCor(MensagensParser.MensagemCorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partes}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartes(MensagensParser.PartesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mensagemDesenho}
	 * labeled alternative in {@link MensagensParser#mensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensagemDesenho(MensagensParser.MensagemDesenhoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MensagensParser#texto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTexto(MensagensParser.TextoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desenhoPonto}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesenhoPonto(MensagensParser.DesenhoPontoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desenhoLinha}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesenhoLinha(MensagensParser.DesenhoLinhaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desenhoRetangulo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesenhoRetangulo(MensagensParser.DesenhoRetanguloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desenhoCirculo}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesenhoCirculo(MensagensParser.DesenhoCirculoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code desenhoCor}
	 * labeled alternative in {@link MensagensParser#desenho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesenhoCor(MensagensParser.DesenhoCorContext ctx);
}