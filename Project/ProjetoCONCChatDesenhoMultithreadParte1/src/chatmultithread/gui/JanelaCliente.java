package chatmultithread.gui;

import chatmultithread.ChatMultithread;
import chatmultithread.parser.MensagensLexer;
import chatmultithread.parser.MensagensParser;
import chatmultithread.parser.impl.listener.MensagensListenerImpl;
import chatmultithread.parser.impl.visitor.MensagensVisitorImpl;
import chatmultithread.utils.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Implementa a janela do cliente do chat multithread.
 *
 * Ao se conectar, o cliente cria um link Socket apontando para o endereço e
 * porta do servidor e instancia os fluxos de entrada e saída. Em seguida, inicia
 * uma thread de dados que fica bloqueada em readLine(), aguardando
 * mensagens enviadas pelo servidor via broadcast. O envio de mensagens é feito
 * diretamente na Event-Dispatching Thread (EDT) a partir do botão "Enviar",
 * escrevendo no PrintWriter do socket.
 *
 * O botão "Enviar" permanece desabilitado até que a conexão seja estabelecida,
 * evitando acesso nulo ao fluxo de saída. Todas as atualizações na área de
 * mensagens são despachadas pela EDT via SwingUtilities.invokeLater.
 *
 * @author Prof. Dr. David Buzatto
 */
public class JanelaCliente extends javax.swing.JFrame {
    
    // nome do cliente para identificação nas mensagens
    private String nome;
    
    // flag que indica se o cliente está conectado
    private boolean conectado;
    
    // porta de conexão
    private int porta;
    
    // representação do endereço de internet do servidor
    private InetAddress inetAddress;
    
    // socket do cliente
    private Socket socket;
    
    // fluxo de entrada do cliente
    private BufferedReader reader;
    
    // fluxo de saída do cliente
    private PrintWriter writer;
    
    private static enum TipoProcessamento {
        LISTENER,
        VISITOR;
    }
    
    /**
     * Creates new form JanelaCliente
     */
    public JanelaCliente( String host, int porta ) {
        
        // inicializa os componentes do formulário
        initComponents();
        
        // configura o botão btnEnviar como o padrão, ou seja, disparado
        // ao se teclar <ENTER>
        getRootPane().setDefaultButton( btnEnviar );
        
        try {
            
            // obtém o endereço do host (servidor)
            this.inetAddress = InetAddress.getByName( host );
            
            // define a porta
            this.porta = porta;
            
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }

    /**
     * Prepara o cliente para conexão e inicia a thread de dados.
     * 
     * @throws IOException Caso algum erro de IO ocorra
     */
    private void conectar() throws IOException {

        if ( !conectado ) {

            // tenta conectar no servidor
            socket = new Socket( inetAddress, porta );
            
            // cria o fluxo de entrada (saída no servidor)
            reader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            
            // cria o fluxo de saída (entrada no servidor)
            writer = new PrintWriter( socket.getOutputStream() );
            
            // marca como conectado
            conectado = true;

            // dispara a thread de dados do cliente
            new Thread( () -> {
                
                try {
                    
                    // linha de dados que chegará no cliente ao receber uma mensagem
                    // do servidor
                    String linha;
                    
                    // bloqueia a thread, aguardando a chegada dos dados
                    // caso retorne null, indica que o servidor caiu ou que foi
                    // desconectado do servidor
                    while ( ( linha = reader.readLine() ) != null ) {
                        
                        final String dados = linha;
                        
                        // despacha a alteração na EDT - mensagem crua
                        //SwingUtilities.invokeLater( () -> Utils.adicionarTextoNaoFormatado( dados + "\n", areaMensagens ) );
                        
                        // despacha a alteração na EDT - analisa a mensagem
                        SwingUtilities.invokeLater( () -> {
                            
                            try { 
                                // faz a análise da mensagem e insere no JTextPane
                                analisarMensagem( dados, areaMensagens, TipoProcessamento.VISITOR );
                            } catch ( ParseException exc ) {
                                // em caso de erro de análise, adiciona o texto cru
                                Utils.adicionarTextoNaoFormatado( dados, areaMensagens );
                                exc.printStackTrace();
                            }

                            // pula linha
                            Utils.adicionarTextoNaoFormatado( "\n", areaMensagens );
                            
                        });
                        
                    }
                    
                } catch ( IOException exc ) {
                    exc.printStackTrace();
                } finally {
                    
                    // marca o cliente como desconectado
                    conectado = false;
                    
                }
                
            }).start();

        }

    }
    
    /**
     * Analisa a mensagem recebida e insere o conteúdo no JTextPane.
     * 
     * @param mensagem mensagem a ser analisada
     * @param textPane container da mensagem
     * @param tipo     o tipo de processamento
     * 
     * @throws ParseException Caso ocorra algum erro durante a análise da mensagem.
     */
    public static void analisarMensagem( String mensagem, JTextPane textPane, TipoProcessamento tipo ) throws ParseException {
        
        // cria o lexer
        MensagensLexer lexer = new MensagensLexer( 
            CharStreams.fromString( mensagem )
        );
        
        // cria o fluxo de tokens usando o lexer
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        
        // cria o parser usado o fluxo de tokens
        MensagensParser parser = new MensagensParser( tokens );
        
        // faz a análise e gera a árvore sintática abstrata
        ParseTree tree = parser.inicio();
        
        // se o tipo de processamento for o de listener
        if ( tipo == TipoProcessamento.LISTENER ) {
            // percorre a árvore disparando os eventos e tratando cada um deles
            ParseTreeWalker.DEFAULT.walk( new MensagensListenerImpl( textPane ), tree );
        } else if ( tipo == TipoProcessamento.VISITOR ) {
            // cria o visitor
            MensagensVisitorImpl visitor = new MensagensVisitorImpl( textPane );
            // percorre a árvore e, ao percorrer, verifica o que aconteceu
            visitor.visit( tree );
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

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        scrollPaneMensagens = new javax.swing.JScrollPane();
        areaMensagens = new javax.swing.JTextPane();
        lblMensagem = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnConectar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        areaMensagens.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scrollPaneMensagens.setViewportView(areaMensagens);

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMensagem.setText("Mensagem:");

        txtMensagem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnEnviar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneMensagens)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConectar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem)
                    .addComponent(btnEnviar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        // escreve a mensagem no fluxo de saída, prefixada pelo nome do cliente
        writer.write( String.format( "%s: %s\n", nome, txtMensagem.getText() ) );
        
        // força o envio dos dados em buffer para o servidor
        writer.flush();
        
        // limpa o campo de mensagem para o próximo envio
        txtMensagem.setText( "" );
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        
        // obtém o nome do cliente
        this.nome = txtNome.getText().trim();
        
        // impede a conexão sem nome: o nome identifica o cliente nas mensagens
        if ( nome.isEmpty() ) {
            JOptionPane.showMessageDialog(
                this,
                "Defina um nome para conectar!",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        try {
            
            // se não estiver conectado
            if ( !conectado ) {
                
                // tenta conectar
                conectar();
                
                // altera o estado da GUI
                txtNome.setEnabled( false );
                btnConectar.setEnabled( false );
                btnEnviar.setEnabled( true );
                
                // acrescenta o nome do cliente no título da janela
                setTitle( String.format( "%s: %s", getTitle(), nome ) );
                
            }
            
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }//GEN-LAST:event_btnConectarActionPerformed

    public static void main( String[] args ) {
        new JanelaCliente( 
            ChatMultithread.HOST, 
            ChatMultithread.PORTA
        ).setVisible( true );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane areaMensagens;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JScrollPane scrollPaneMensagens;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
