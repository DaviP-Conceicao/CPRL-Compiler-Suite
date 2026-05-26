package chatmultithread.parser.impl.visitor;

import chatmultithread.gui.JanelaDesenho;
import chatmultithread.gui.comandos.ComandoDesenhoCirculo;
import chatmultithread.gui.comandos.ComandoDesenhoCor;
import chatmultithread.gui.comandos.ComandoDesenhoLinha;
import chatmultithread.gui.comandos.ComandoDesenhoPonto;
import chatmultithread.gui.comandos.ComandoDesenhoRetangulo;
import chatmultithread.parser.MensagensParser;
import chatmultithread.parser.MensagensParserBaseVisitor;
import chatmultithread.utils.Utils;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Implementação do visitor para a gramática de mensagens.
 *
 * No padrão visitor, a travessia da árvore sintática é controlada
 * explicitamente: cada método visit decide quais filhos visitar e em que
 * ordem. O estado de formatação (negrito, itálico, cor) é mantido em
 * contadores e em uma pilha; ao alcançar um nó folha (texto), o estado
 * acumulado pelos ancestrais já está completo e é aplicado ao texto.
 *
 * @author Prof. Dr. David Buzatto
 */
public class MensagensVisitorImpl extends MensagensParserBaseVisitor<Void> {

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
    
    // acesso à janela de desenho
    private JanelaDesenho janelaDesenho;

    public MensagensVisitorImpl( JTextPane textPane, JanelaDesenho janelaDesenho ) {

        this.textPane = textPane;
        this.attrSet = new SimpleAttributeSet();
        this.pilhaCor = new ArrayDeque<>();

        // cor padrão na base da pilha: garante que peek() nunca retorne null
        this.pilhaCor.push( Color.BLACK );
        
        this.janelaDesenho = janelaDesenho;

    }

    @Override
    public Void visitMensagemNegrito( MensagensParser.MensagemNegritoContext ctx ) {

        // incrementa antes de visitar os filhos: todo texto dentro do [b]...[/b]
        // enxergará contNegrito > 0
        contNegrito++;
        visit( ctx.mensagem() );

        // decrementa após: restaura o estado de quem chamou este nó
        contNegrito--;

        return null;

    }

    @Override
    public Void visitMensagemItalico( MensagensParser.MensagemItalicoContext ctx ) {

        // mesmo padrão do negrito: incrementa antes, decrementa após
        contItalico++;
        visit( ctx.mensagem() );
        contItalico--;

        return null;

    }

    @Override
    public Void visitMensagemCor( MensagensParser.MensagemCorContext ctx ) {

        // empilha a cor extraída do token [c #RRGGBB] antes de visitar os filhos
        pilhaCor.push( Utils.processarCor( ctx.COR_ESQ().toString() ) );
        visit( ctx.mensagem() );

        // desempilha ao sair, restaurando a cor ativa do contexto externo
        pilhaCor.pop();

        return null;

    }

    @Override
    public Void visitPartes( MensagensParser.PartesContext ctx ) {

        // partes = texto mensagem*; visitChildren visita ambos na ordem da árvore
        visitChildren( ctx );

        return null;

    }

    @Override
    public Void visitTexto( MensagensParser.TextoContext ctx ) {

        // nó folha: o estado de formatação acumulado pelos ancestrais já está
        // completo; atualiza os atributos e insere o texto no componente
        atualizarAttributeSet();
        Utils.adicionarTextoFormatado( ctx.getText(), textPane, attrSet );

        return null;

    }

    @Override
    public Void visitMensagemDesenho( MensagensParser.MensagemDesenhoContext ctx ) {
        Utils.adicionarTextoNaoFormatado( ctx.getText(), textPane );
        return super.visitMensagemDesenho( ctx );
    }
    
    @Override
    public Void visitDesenhoPonto( MensagensParser.DesenhoPontoContext ctx ) {
        
        janelaDesenho.adicionarComando( 
            new ComandoDesenhoPonto(
                Integer.parseInt( ctx.NUM_INT(0).getText() ),
                Integer.parseInt( ctx.NUM_INT(1).getText() )
            )
        );

        return null;

    }

    @Override
    public Void visitDesenhoLinha( MensagensParser.DesenhoLinhaContext ctx ) {

        janelaDesenho.adicionarComando( 
            new ComandoDesenhoLinha(
                Integer.parseInt( ctx.NUM_INT(0).getText() ),
                Integer.parseInt( ctx.NUM_INT(1).getText() ),
                Integer.parseInt( ctx.NUM_INT(2).getText() ),
                Integer.parseInt( ctx.NUM_INT(3).getText() )
            )
        );

        return null;

    }

    @Override
    public Void visitDesenhoRetangulo( MensagensParser.DesenhoRetanguloContext ctx ) {

        janelaDesenho.adicionarComando( 
            new ComandoDesenhoRetangulo(
                Integer.parseInt( ctx.NUM_INT(0).getText() ),
                Integer.parseInt( ctx.NUM_INT(1).getText() ),
                Integer.parseInt( ctx.NUM_INT(2).getText() ),
                Integer.parseInt( ctx.NUM_INT(3).getText() )
            )
        );

        return null;

    }

    @Override
    public Void visitDesenhoCirculo( MensagensParser.DesenhoCirculoContext ctx ) {
        
        janelaDesenho.adicionarComando( 
            new ComandoDesenhoCirculo(
                Integer.parseInt( ctx.NUM_INT(0).getText() ),
                Integer.parseInt( ctx.NUM_INT(1).getText() ),
                Integer.parseInt( ctx.NUM_INT(2).getText() )
            )
        );

        return null;

    }

    @Override
    public Void visitDesenhoCor( MensagensParser.DesenhoCorContext ctx ) {
        
        janelaDesenho.adicionarComando( 
            new ComandoDesenhoCor(
                new Color( Integer.parseInt( ctx.NUM_HEX_TOK().getText().replace( "#", "" ), 16 ) )
            )
        );
        
        return null;
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
