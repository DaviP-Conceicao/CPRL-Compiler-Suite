package chatmultithread.gui;

import chatmultithread.ChatMultithread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.SwingUtilities;

/**
 * Implementa a janela do servidor do chat multithread.
 *
 * Ao ser instanciada, abre um ServerSocket na porta informada e inicia
 * uma thread de conexão, que fica bloqueada em accept() aguardando novos
 * clientes. A cada cliente aceito, uma thread dedicada é criada para receber suas
 * mensagens de forma bloqueante. Ao receber uma mensagem, ela é exibida na área
 * de mensagens e repassada (broadcast) para todos os clientes conectados.
 *
 * A lista de clientes é mantida em uma java.util.concurrent.CopyOnWriteArrayList
 * para evitar condições de disputa entre as threads de conexão e de dados. Todas
 * as atualizações na interface gráfica são despachadas pela Event-Dispatching
 * Thread (EDT) via SwingUtilities#invokeLater.
 *
 * @author Prof. Dr. David Buzatto
 */
public class JanelaServidor extends javax.swing.JFrame {

    /*
     * Record interna que agrega o socket do cliente, seus fluxos de entrada no
     * servidor (saída do cliente) e saída do servidor (entrada no cliente).
     */
    private static record ClienteConectado( Socket socket, BufferedReader reader, PrintWriter writer ) {};

    // flag para indicar se o servidor está em execução
    private boolean executando;

    // porta de conexão
    private int porta;
    
    // socket do servidor
    private ServerSocket serverSocket;

    // lista de clientes conectados
    private List<ClienteConectado> clientes;
    
    /**
     * Creates new form JanelaServidor
     */
    public JanelaServidor( int porta ) {
        
        initComponents();
        
        this.porta = porta;
        
        /* IMPORTANTE!
         * CopyOnWriteArrayList é uma lista "protegida" contra acesso
         * concorrente, evitando assim condições de disputa (race conditions)
         */
        this.clientes = new CopyOnWriteArrayList<>();
        
        // tenta iniciar a thread do servidor
        try {
            iniciar();
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }
    
    private void iniciar() throws IOException {

        if ( !executando ) {

            // cria um socket de servidor ouvindo na porta definida
            serverSocket = new ServerSocket( porta );
            
            // marca o servidor como em execução
            executando = true;

            // thread de conexão:
            // fica bloqueada em accept(), aguardando novos clientes
            new Thread( () -> {

                while ( executando ) {

                    try {

                        // aguarda até chegar uma nova conexão
                        Socket socket = serverSocket.accept();
                        
                        // ao aceitar, cria os fluxos de entrada e saída, agrega
                        // todos em um ClienteConectado e adiciona na lista
                        ClienteConectado cliente = new ClienteConectado( 
                            socket, 
                            new BufferedReader( new InputStreamReader( socket.getInputStream() ) ), 
                            new PrintWriter( socket.getOutputStream() )
                        );
                        clientes.add( cliente );
                        
                        // atualiza a GUI
                        atualizarContadorClientes();
                        
                        // inicia uma nova thread de dados para o cliente conectado
                        iniciarThreadCliente( cliente );
                        
                    } catch ( IOException exc ) {
                        exc.printStackTrace();
                    }
                    
                }
                
            }).start();

        }

    }

    /**
     * Inicia uma nova thread de dados para um cliente conectado.
     * 
     * @param cliente O cliente que se conectou.
     */
    private void iniciarThreadCliente( ClienteConectado cliente ) {
        
        new Thread( () -> {
            
            try {
                
                // linha de dados que chegará no servidor ao receber uma mensagem
                // do cliente
                String linha;
                
                // bloqueia a thread, aguardando a chegada dos dados
                // caso retorne null, indica que o cliente foi desconectado
                while ( ( linha = cliente.reader.readLine() ) != null ) {
                    
                    // readLine() remove o terminador de linha ao ler; aqui ele é reinserido
                    final String dados = linha + "\n";
                    
                    // despacha a alteração na EDT
                    SwingUtilities.invokeLater( () -> areaMensagens.append( dados ) );
                    
                    // faz o broadcast para todos os clientes conectados
                    broadcast( dados );
                    
                }
                
            } catch ( IOException exc ) {
                exc.printStackTrace();
            } finally {
                
                // remove o cliente da lista
                clientes.remove( cliente );
                
                // atualiza a GUI
                atualizarContadorClientes();
                
                // tenta fechar o socket do cliente
                try {
                    cliente.socket.close();
                } catch ( IOException exc ) {
                    exc.printStackTrace();
                }
                
            }
            
        }).start();
        
    }

    /**
     * Faz o broadcast dos dados para todos os clientes conectados.
     * 
     * @param dados String de dados que serão enviados
     */
    private void broadcast( String dados ) {
        
        for ( ClienteConectado cliente : clientes ) {
            
            // escreve os dados
            cliente.writer.write( dados );
            
            // força o envio
            cliente.writer.flush();
            
        }
        
    }

    /**
     * Atualiza a quantidade de clientes conectados na GUI
     */
    private void atualizarContadorClientes() {
        SwingUtilities.invokeLater( () ->
            lblClientesConectados.setText( "Clientes conectados: " + clientes.size() )
        );
    }

    /**
     * Para a thread do servidor.
     * 
     * @throws IOException Caso algum erro de IO seja encontrado.
     */
    public void parar() throws IOException {
        if ( executando ) {
            serverSocket.close();
            executando = false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClientesConectados = new javax.swing.JLabel();
        scrollPaneMensagens = new javax.swing.JScrollPane();
        areaMensagens = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        lblClientesConectados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblClientesConectados.setText("Clientes conectados:");

        areaMensagens.setEditable(false);
        areaMensagens.setColumns(20);
        areaMensagens.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaMensagens.setRows(5);
        scrollPaneMensagens.setViewportView(areaMensagens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClientesConectados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientesConectados, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main( String[] args ) {
        new JanelaServidor( ChatMultithread.PORTA ).setVisible( true );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMensagens;
    private javax.swing.JLabel lblClientesConectados;
    private javax.swing.JScrollPane scrollPaneMensagens;
    // End of variables declaration//GEN-END:variables
}
