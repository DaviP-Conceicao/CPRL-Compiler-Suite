package chatmultithread.gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import chatmultithread.gui.comandos.ComandoDesenho;
import chatmultithread.gui.comandos.ComandoDesenhoCor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Janela de desenho que usa a JSGE.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class JanelaDesenho extends EngineFrame {

    private List<ComandoDesenho> comandos;
    private Color cor;
    
    public JanelaDesenho( int largura, int altura ) {
        super( largura, altura, "Desenho", 60, true, true, false, false, false, false );
        cor = Color.BLACK;
    }
    
    @Override
    public void create() {
        comandos = new ArrayList<>();
        comandos.add( new ComandoDesenhoCor( Color.BLACK ) );
    }

    @Override
    public void update( double delta ) {
    }

    @Override
    public void draw() {
        
        clearBackground( WHITE );
        
        for ( ComandoDesenho comando : comandos ) {
            
            if ( comando instanceof ComandoDesenhoCor cCor ) {
                cor = cCor.getCor();
            } else {
                comando.desenhar( this );
            }
            
        }
        
    }
    
    public void adicionarComando( ComandoDesenho comando ) {
        comandos.add( comando );
    }

    public void setCor( Color cor ) {
        this.cor = cor;
    }
    
    public Color getCor() {
        return cor;
    }
    
}
