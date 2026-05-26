package chatmultithread.gui.comandos;

import chatmultithread.gui.JanelaDesenho;

/**
 * Comando de desenho de retângulos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ComandoDesenhoRetangulo extends ComandoDesenho {
    
    public ComandoDesenhoRetangulo( int x1, int y1, int x2, int y2 ) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void desenhar( JanelaDesenho janela ) {
        janela.drawRectangle( 
            x1 < x2 ? x1 : x2,
            y1 < y2 ? y1 : y2,
            Math.abs( x2 - x1 ),
            Math.abs( y2 - y1 ),
            janela.getCor()
        );
    }
    
}
