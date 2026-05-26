package chatmultithread;

import chatmultithread.gui.JanelaCliente;
import chatmultithread.gui.JanelaServidor;

/**
 * Classe principal.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ChatMultithread {
    
    public static final String HOST = "localhost";
    public static final int PORTA = 21300;  // portas liberadas pela CTI: 21300 a 21900 (TCP e UDP)
    
    private static final int QUANTIDADE_CLIENTES = 2;
    
    public static void main( String[] args ) throws Exception {
        
        JanelaServidor s = new JanelaServidor( PORTA );
        s.setVisible( true );
        
        JanelaCliente c1 = new JanelaCliente( HOST, PORTA );
        JanelaCliente c2 = new JanelaCliente( HOST, PORTA );
        JanelaCliente c3 = new JanelaCliente( HOST, PORTA );
        JanelaCliente c4 = new JanelaCliente( HOST, PORTA );
        
        switch ( QUANTIDADE_CLIENTES ) {
            
            case 1:
            default:
                c1.setVisible( true );
                c1.setLocation( s.getLocation().x - c1.getBounds().width, c1.getLocation().y );
                break;
                
            case 2:
                c1.setVisible( true );
                c1.setLocation( s.getLocation().x - c1.getBounds().width, c1.getLocation().y );
                c2.setVisible( true );
                c2.setLocation( s.getLocation().x + s.getBounds().width, c2.getLocation().y );
                break;
                
            case 4:
                c1.setVisible( true );
                c1.setLocation( s.getLocation().x - c1.getBounds().width, c1.getLocation().y - c1.getBounds().height / 2 );
                c2.setVisible( true );
                c2.setLocation( s.getLocation().x + s.getBounds().width, c2.getLocation().y - c2.getBounds().height / 2 );
                c3.setVisible( true );
                c3.setLocation( s.getLocation().x + s.getBounds().width, c3.getLocation().y + c3.getBounds().height / 2 );
                c4.setVisible( true );
                c4.setLocation( s.getLocation().x - s.getBounds().width, c4.getLocation().y + c4.getBounds().height / 2 );
                break;
                
        }
        
    }
    
}
