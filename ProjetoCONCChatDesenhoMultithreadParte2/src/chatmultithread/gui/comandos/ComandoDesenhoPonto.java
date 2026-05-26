package chatmultithread.gui.comandos;

import chatmultithread.gui.JanelaDesenho;

/**
 * Comando de desenho de pontos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ComandoDesenhoPonto extends ComandoDesenho {
    
    public ComandoDesenhoPonto( int x, int y ) {
        this.x1 = x;
        this.y1 = y;
    }
    
    public void desenhar( JanelaDesenho janela ) {
        janela.drawPixel( x1, y1, janela.getCor() );
    }
    
}
