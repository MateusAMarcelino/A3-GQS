package visao;

import dao.FerramentaDAO;
import java.awt.Font;
import java.util.logging.Logger;
import javax.swing.JButton;
import modelo.Amigo;
import javax.swing.JOptionPane;

public class FrmCadastrarAmigo extends javax.swing.JFrame {

    /*
    Cria o vinculo com a classe amigo.
     */
    private Amigo objetoamigo;
    private String Fonte = "Segoe UI 14 Plain";
    private String mensagem;

    /*
    Cria e inicializa a tela de cadastar amigos.
     */
    public FrmCadastrarAmigo() {
        initComponents();
        this.objetoamigo = new Amigo();
    }

    
     public  String getMensagem() {
        return mensagem; 
    }
    
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
   

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre regenerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFTelefone = new javax.swing.JTextField();
        JBCadastrar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        JTFEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Amigo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome :");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Telefone:");

        JTFTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTelefoneActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFEmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFNome, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(JTFEmail))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.JTFNome.setText("");
        this.JTFTelefone.setText("");
        this.JTFEmail.setText("");
        this.setMensagem(null); 
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
    }//GEN-LAST:event_JTFNomeActionPerformed

    private void JTFTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTelefoneActionPerformed
    }//GEN-LAST:event_JTFTelefoneActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        /*
        Cadastra um amigo no banco de dados, usando o metodo de InsertDB da classe AmigoDAO.
        
        Ele pega as informações dos JavaTextFields, tendo seus requisitos para ser validado.
         */
         try {
            String nome = "";
            String telefone = "";
            String email = "";

            if (this.JTFNome.getText().length() < 2) {
                // Define a mensagem na variável ANTES de lançar a exceção
                setMensagem("O nome deve possuir ao menos 2 caracteres"); 
                throw new Mensagem(getMensagem()); // Lança a exceção com a mensagem
            } else {
                nome = this.JTFNome.getText();
            }

            if (this.JTFTelefone.getText().length() != 9) { // Note que era == 9 no seu código
                // Define a mensagem na variável ANTES de lançar a exceção
                setMensagem("O número de telefone deve possuir exatamente 9 digitos");
                throw new Mensagem(getMensagem());
            } else {
                telefone = (JTFTelefone.getText());
            }

            // Você não tem validação de "@" ou "." no seu FrmCadastrarAmigo, apenas comprimento.
            // Para ser consistente com o teste, você pode adicionar.
            if (this.JTFEmail.getText().length() < 11) {
                // Define a mensagem na variável ANTES de lançar a exceção
                setMensagem("O email deve conter no mínimo 11 dígitos, como: X@gmail.com");
                throw new Mensagem(getMensagem());
            } else {
                email = this.JTFEmail.getText();
            }

            // Supondo que objetoamigo.insertAmigoBD(nome, telefone, email) retorna true/false
            if (this.objetoamigo.insertAmigoBD(nome, telefone, email)) {
                // Define a mensagem de sucesso na variável
                setMensagem("Amigo inserido com sucesso!");
                JOptionPane.showMessageDialog(null, getMensagem()); // Agora o JOptionPane pega da variável
                
                // Limpa todos os campos da interface
                this.JTFNome.setText("");
                this.JTFTelefone.setText("");
                this.JTFEmail.setText("");
            } else {
                // Se a inserção falhar por algum motivo não coberto pelas validações acima
                setMensagem("Falha ao inserir amigo no banco de dados.");
                JOptionPane.showMessageDialog(null, getMensagem());
            }
            
            System.out.println(this.objetoamigo.ListaAmigo().toString()); // Boa para depuração
            
        } catch (Mensagem erro) {
            // A mensagem já foi definida pelo 'setMensagem' antes do throw
            // Apenas exiba-a ou faça outra ação de UI
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            // Define a mensagem para o erro de formato de número
            setMensagem("Informe um número válido.");
            JOptionPane.showMessageDialog(null, getMensagem());
        }
    
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFEmailActionPerformed
    }//GEN-LAST:event_JTFEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarAmigo().setVisible(true);
            }
        });
    }

    protected javax.swing.JTextField getJTFNome() {
        return this.JTFNome;  // acesso direto porque está dentro da classe
    }

    protected javax.swing.JTextField getJTFTelefone() {
        return this.JTFTelefone;  // acesso direto porque está dentro da classe
    }

    protected javax.swing.JTextField getJTFEmail() {
        return this.JTFEmail;  // acesso direto porque está dentro da classe
    }

    protected JButton getJBCadastrar() {
        return this.JBCadastrar;  // acesso direto porque está dentro da classe
    }

    protected JButton getJBCancelar() {
        return this.JBCancelar;  // acesso direto porque está dentro da classe
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFEmail;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
