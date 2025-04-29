package visao;

import modelo.Ferramenta;
import javax.swing.JOptionPane;



public class FrmCadastrarFerramenta extends javax.swing.JFrame {

   
    /*
    Inicia os componentes, carregando a tela cadastrar ferramentas.
    */
    public FrmCadastrarFerramenta() {
        initComponents();
        new Ferramenta();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JTFNomeF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFMarcaF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFCustoF = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Cadastro de Ferramentas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        JTFNomeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeFActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Marca:");

        JTFMarcaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMarcaFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Custo:");

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(JTFNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFMarcaF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(JTFCustoF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFMarcaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFCustoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Fecha a tela de cadastrar ferramenta.
     * @param evt, que seria clicar o botão, ativa o codigo fehcando a janela
     */
    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed
    
    
    /**
     * Cadastra uma ferramenta, pegando as informações dos javatextfield.
     * @param evt que seria clicar o botão, ativa o codigo cadastrando uma ferramenta.
     */
    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        // TODO add your handling code here:
        try{
            
          Ferramenta ferramenta = new Ferramenta();  
          String NomeFerramentas = "";
          double CustoFerrametas = 0.0;
          String MarcaFerramentas = "";
          
          if(this.JTFNomeF.getText().length() < 2){ /*Caso o texto no field tenha menos que 2 caracteres, manda um aviso dizendo que deve ter mais de 2 caracteres. */
              throw new Mensagem("Nome deve conter ao menos dois caracteres.");
          }else { /*Caso o texto no field seja maior de 2 caracteres, pega o texto e coloca na variavel NomeFerrramenta */
            NomeFerramentas = this.JTFNomeF.getText();
          }
          
          if(this.JTFCustoF.getText().length() <= 0){ /*Caso o texto inserido no textfield seja menor que 0, numericamente , manda um aviso dizendo que deve ser maior que 0. */
              throw new Mensagem("Custo deve ser maior que zero.");
          }else{ /*Caso o texto no field seja maior que 0, pega o texto covnerte para um valor tipo INT e coloca na variavel CustoFerramenta */
           CustoFerrametas = Double.parseDouble(this.JTFCustoF.getText());
          }
          if(this.JTFMarcaF.getText().length() < 2){ /*Caso o texto no field tenha menos que 2 caracteres, manda um aviso dizendo que deve ter mais de 2 caracteres. */
              throw new Mensagem("Marca deve conter dois caracteres.");
          }else{ /*Caso o texto no field seja maior de 2 caracteres, pega o texto e coloca na variavel MarcaFerramenta */
           MarcaFerramentas = this.JTFMarcaF.getText();
          }
          
          if(ferramenta.InsertFerramentaDB(NomeFerramentas, MarcaFerramentas, CustoFerrametas)){ /*Se tudo estiver de acordo com os requisitos acima, manda uma mensagem avisando que a ferramenta foi cadastrada com sucesso
              e apaga todos os text fields.*/
              JOptionPane.showMessageDialog(null, "Ferramenta Cadastrado com Sucesso!");
              this.JTFNomeF.setText("");
              this.JTFCustoF.setText("");
              this.JTFMarcaF.setText("");
            }
          
        } catch (Mensagem erro){ /* Caso não esteja de acordo com os requisitos acimas, manda aviso falando que não foi possivel */
            JOptionPane.showMessageDialog(null,erro.getMessage());
        } catch (NumberFormatException erro2){
            JOptionPane.showMessageDialog(null, "Informe um número valido.");
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JTFMarcaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMarcaFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMarcaFActionPerformed

    private void JTFNomeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeFActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCustoF;
    private javax.swing.JTextField JTFMarcaF;
    private javax.swing.JTextField JTFNomeF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
