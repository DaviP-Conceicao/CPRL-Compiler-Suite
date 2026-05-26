package chatmultithread.gui.comandos;

import chatmultithread.gui.JanelaDesenho;
import java.awt.Color;

/**
 * Comando de desenho para troca de cor.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ComandoDesenhoCor extends ComandoDesenho {
    
    private Color cor;
    
    public ComandoDesenhoCor( Color cor ) {
        this.cor = cor;
    }
    
    public void desenhar( JanelaDesenho janela ) {
    }

    public Color getCor() {
        return cor;
    }
    
}
