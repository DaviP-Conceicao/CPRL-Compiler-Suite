package chatmultithread.utils;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Métodos utilitários para inserção de texto formatado em um JTextPane
 * e para suporte à análise e depuração do parser ANTLR.
 *
 * @author Prof. Dr. David Buzatto
 */
public class Utils {

    /**
     * Insere texto no final do documento do textPane aplicando
     * os atributos de formatação definidos em attrSet.
     *
     * @param texto    texto a ser inserido
     * @param textPane componente de destino
     * @param attrSet  atributos de formatação (negrito, itálico, cor, etc.)
     */
    public static void adicionarTextoFormatado( String texto, JTextPane textPane, SimpleAttributeSet attrSet ) {

        Document document = textPane.getDocument();

        try {
            // getLength() como posição de inserção garante que o texto sempre
            // seja acrescentado ao final do documento
            document.insertString( document.getLength(), texto, attrSet );
        } catch ( BadLocationException exc ) {
            exc.printStackTrace();
        }

    }

    /**
     * Insere texto no final do documento do textPane sem
     * nenhuma formatação (atributos padrão).
     *
     * @param texto    texto a ser inserido
     * @param textPane componente de destino
     */
    public static void adicionarTextoNaoFormatado( String texto, JTextPane textPane ) {

        Document document = textPane.getDocument();

        try {
            // SimpleAttributeSet vazio equivale a texto sem formatação explícita
            document.insertString( document.getLength(), texto, new SimpleAttributeSet() );
        } catch ( BadLocationException exc ) {
            exc.printStackTrace();
        }

    }

    /**
     * Extrai a cor RGB de um token COR_ESQ no formato [c #RRGGBB].
     *
     * @param texto texto do token COR_ESQ produzido pelo lexer
     * @return a cor correspondente ao valor hexadecimal encontrado
     */
    public static Color processarCor( String texto ) {

        // localiza os delimitadores do valor hexadecimal dentro do token
        int ini = texto.indexOf( "#" );
        int fim = texto.indexOf( "]" );

        if ( ini >= 0 && fim >= 0 && ini <= fim ) {

            // extrai os 6 dígitos hex e converte para Color
            String hex = texto.substring( ini + 1, fim );
            return new Color( Integer.parseInt( hex, 16 ) );

        }

        // ramo inalcançável dado que a gramática garante o formato [c #RRGGBB]
        return Color.BLACK;

    }

    /**
     * Exibe no console os dados da análise léxica e sintática para fins de
     * depuração. Opcionalmente abre o inspetor visual de árvore do ANTLR.
     *
     * @param tokens          stream de tokens produzido pelo lexer; pode ser null
     * @param parser          instância do parser; necessário para toStringTree
     * @param tree            raiz da árvore sintática; necessário para toStringTree
     * @param mostrarTestRig  se true, abre o inspetor visual (GUI) da árvore
     */
    public static void mostrarDadosAnalise(
            CommonTokenStream tokens,
            Parser parser,
            ParseTree tree,
            boolean mostrarTestRig ) {

        if ( tokens != null ) {
            // imprime cada token com seu tipo, texto e posição no fluxo
            for ( Token t : tokens.getTokens() ) {
                System.out.println( t );
            }
        }

        if ( parser != null && tree != null ) {

            // representação textual compacta da árvore (texto concatenado)
            System.out.println( tree.getText() );

            // representação em parênteses aninhados legível pelo ANTLR TestRig
            System.out.println( tree.toStringTree( parser ) );

            if ( mostrarTestRig ) {
                // abre a janela gráfica do inspetor de árvore do ANTLR
                Trees.inspect( tree, parser );
            }

        }

    }

}
