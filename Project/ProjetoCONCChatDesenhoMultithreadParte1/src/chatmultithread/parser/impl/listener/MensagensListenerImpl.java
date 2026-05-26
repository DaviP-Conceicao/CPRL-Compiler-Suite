package chatmultithread.parser.impl.listener;

import chatmultithread.parser.MensagensBaseListener;
import chatmultithread.parser.MensagensParser;
import chatmultithread.utils.Utils;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Implementação do ouvinte (listener) para a gramática de mensagens.
 *
 * No padrão listener, a travessia da árvore é feita pelo
 * org.antlr.v4.runtime.tree.ParseTreeWalker, que dispara eventos
 * de entrada (enter) e saída (exit) para cada nó visitado. O estado de
 * formatação (negrito, itálico, cor) é mantido em contadores e em uma
 * pilha, atualizados nos eventos de entrada e saída de cada tag. O texto é
 * inserido no componente apenas em exitTexto, momento em que todos
 * os eventos enter dos nós ancestrais já foram disparados e o estado de
 * formatação está completo.
 *
 * @author Prof. Dr. David Buzatto
 */
public class MensagensListenerImpl extends MensagensBaseListener {

    // componente Swing onde o texto formatado será inserido
    private JTextPane textPane;

    // conjunto de atributos de formatação aplicado a cada trecho de texto
    private SimpleAttributeSet attrSet;

    // contadores de profundidade de aninhamento: permitem que [b][b]...[/b][/b]
    // mantenha o negrito ativo até o fechamento do último tag
    private int contNegrito;
    private int contItalico;

    // pilha de cores: ao entrar em [c], empilha a nova cor; ao sair, desempilha,
    // restaurando automaticamente a cor do contexto anterior
    private Deque<Color> pilhaCor;

    public MensagensListenerImpl( JTextPane textPane ) {
        
        this.textPane = textPane;
        this.attrSet = new SimpleAttributeSet();
        this.pilhaCor = new ArrayDeque<>();

        // cor padrão na base da pilha: garante que peek() nunca retorne null
        this.pilhaCor.push( Color.BLACK );
        
    }

    @Override
    public void enterMensagemNegrito( MensagensParser.MensagemNegritoContext ctx ) {

        // incrementa ao entrar no [b]: todo texto encontrado a partir daqui,
        // até o exitMensagemNegrito correspondente, enxergará contNegrito > 0
        contNegrito++;

    }

    @Override
    public void exitMensagemNegrito( MensagensParser.MensagemNegritoContext ctx ) {

        // decrementa ao sair do [/b]: restaura o estado de quem envolve este nó
        contNegrito--;

    }

    @Override
    public void enterMensagemItalico( MensagensParser.MensagemItalicoContext ctx ) {

        // mesmo padrão do negrito: incrementa no enter, decrementa no exit
        contItalico++;

    }

    @Override
    public void exitMensagemItalico( MensagensParser.MensagemItalicoContext ctx ) {
        contItalico--;
    }

    @Override
    public void enterMensagemCor( MensagensParser.MensagemCorContext ctx ) {

        // empilha a cor extraída do token [c #RRGGBB] ao entrar na tag de cor
        pilhaCor.push( Utils.processarCor( ctx.COR_ESQ().toString() ) );

    }

    @Override
    public void exitMensagemCor( MensagensParser.MensagemCorContext ctx ) {

        // desempilha ao sair do [/c], restaurando a cor ativa do contexto externo
        pilhaCor.pop();

    }

    @Override
    public void exitTexto( MensagensParser.TextoContext ctx ) {

        // exit (não enter): garante que todos os eventos enterMensagem* dos
        // ancestrais já foram disparados, ou seja, o estado de formatação está
        // completo no momento da inserção do texto
        atualizarAttributeSet();
        Utils.adicionarTextoFormatado( ctx.getText(), textPane, attrSet );

    }

    private void atualizarAttributeSet() {

        // != 0 em vez de > 0 para funcionar corretamente com aninhamento:
        // o negrito/itálico só se apaga quando o contador volta a zero
        StyleConstants.setBold( attrSet, contNegrito != 0 );
        StyleConstants.setItalic( attrSet, contItalico != 0 );

        // peek() retorna a cor do topo da pilha, ou seja, a mais interna ativa
        StyleConstants.setForeground( attrSet, pilhaCor.peek() );

    }

}
