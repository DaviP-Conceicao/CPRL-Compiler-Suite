package chatmultithread.gui.comandos;

import chatmultithread.gui.JanelaDesenho;

/**
 * Comando de desenho de círculos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ComandoDesenhoCirculo extends ComandoDesenho {
    
    private int raio;
    
    public ComandoDesenhoCirculo( int x, int y, int raio ) {
        this.x1 = x;
        this.y1 = y;
        this.raio = raio;
    }
    
    public void desenhar( JanelaDesenho janela ) {
        janela.drawCircle( x1, y1, raio, janela.getCor() );
    }
    
}
