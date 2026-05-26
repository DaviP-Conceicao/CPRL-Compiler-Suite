package chatmultithread.gui.comandos;

import chatmultithread.gui.JanelaDesenho;

/**
 * Comando de desenho de linhas.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ComandoDesenhoLinha extends ComandoDesenho {
    
    public ComandoDesenhoLinha( int x1, int y1, int x2, int y2 ) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void desenhar( JanelaDesenho janela ) {
        janela.drawLine( x1, y1, x2, y2, janela.getCor() );
    }
    
}
