
package visao;

import dao.FerramentaDAO;
import modelo.Ferramenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static dao.FerramentaDAO.CalcularSoma;
/**
 *
 * @author guiho
 */
public class FrmGerenciamentoDeFerramentas extends javax.swing.JFrame {

    private Ferramenta ferramenta;

    /**
     * Incia os componentes, carrega a lista de ferramentas.
     */
    public FrmGerenciamentoDeFerramentas() {
        initComponents();
        this.ferramenta = new Ferramenta();
        this.CarregaListaFerramenta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableFerramentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        JTFNomeAlterar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFMarcaAlterar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFCustoAlterar = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        JLID = new javax.swing.JLabel();
        JLId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLSoma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciamento de Ferramentas");

        JTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome da Ferramenta", "Marca", "Custo", "Disponibilidade"
            }
        ));
        JTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableFerramentas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        JTFNomeAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeAlterarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");

        JTFMarcaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMarcaAlterarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Custo:");

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JLID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLID.setText("ID :");

        JLId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLId.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Custo de Aquisição :");

        JLSoma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLSoma.setText("Custo Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFNomeAlterar)
                    .addComponent(JTFMarcaAlterar)
                    .addComponent(JTFCustoAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLId))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLSoma))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBApagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLID)
                            .addComponent(JLId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFNomeAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFMarcaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFCustoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JLSoma))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBAlterar)
                            .addComponent(JBApagar)
                            .addComponent(JBCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNomeAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeAlterarActionPerformed

    private void JTFMarcaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMarcaAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMarcaAlterarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    /**
     * Faz com que sempre que clique em uma ferramenta que esteja na tabela, atualize todos os TextFields e Labels para estarem de acordo com as informações da ferramenta em questão.
     * @param evt ao clicar com o mouse.
     */
    private void JTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableFerramentasMouseClicked
        // TODO add your handling code here:
        if (this.JTableFerramentas.getSelectedRow() != -1) {
            JLId.setText(JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(),0).toString());
            JLId.setVisible(true);
            JTFNomeAlterar.setText(JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(),1).toString());
            JTFMarcaAlterar.setText(JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(),2).toString());
            JTFCustoAlterar.setText(JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(),3).toString());
            
        }
    }//GEN-LAST:event_JTableFerramentasMouseClicked

    /**
     * Altera as informações da ferramenta selecionada, baseado em oque estiver digitado nos TextFields, já enviando para a database.
     * @param evt ao clicar no botão.
     */
    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        // TODO add your handling code here:
        try {
            int IdFerramentas = Integer.parseInt(JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 0).toString());
            String NomeFerramentas = "";
            String MarcaFerramentas = "";
            double CustoFerramentas = 0;
            
            
            if (this.JTFNomeAlterar.getText().length() < 2){
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");              
            }else {
                NomeFerramentas = JTFNomeAlterar.getText();
            }
            
            if (this.JTFMarcaAlterar.getText().length() < 2){
                throw new Mensagem("A Marca deve conter ao menos 2 caracteres.");              
            }else {
                MarcaFerramentas = JTFMarcaAlterar.getText();
            }
            
            if (JTFCustoAlterar.getText().length() <= 0){
                throw new Mensagem("O custo deve ser maior que zero.");              
            }else {
                CustoFerramentas = Double.parseDouble(JTFCustoAlterar.getText());
            }

            if (this.ferramenta.updateFerramentaDB(IdFerramentas, NomeFerramentas, MarcaFerramentas,CustoFerramentas)){
                JLId.setVisible(false);
                JTFNomeAlterar.setText("");
                JTFMarcaAlterar.setText("");
                JTFCustoAlterar.setText("");
                JOptionPane.showMessageDialog(rootPane, "Ferramenta Alterada com sucesso!");
                this.CarregaListaFerramenta();
                }
        } catch (Mensagem erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());          
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    /**
     * Apaga a ferramenta selecionada, tambem deletando do banco de dados.
     * @param evt 
     */
    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        // TODO add your handling code here:
        try {
            int IdFerramentas = 0;
            if (this.JTableFerramentas.getSelectedRow() == -1){
                throw new Mensagem("Primeiro Selecione uma ferramenta para APAGAR.");
            } else {
                IdFerramentas = Integer.parseInt(this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(),0).toString());
            }
            int respostaUsuario = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja apagar essa ferramenta?");
            if(respostaUsuario == 0) {
                if(this.ferramenta.DeleteFerramentaDB(IdFerramentas)){
                    this.JLId.setText("0");
                    this.JTFNomeAlterar.setText("");
                    this.JTFMarcaAlterar.setText("");
                    this.JTFCustoAlterar.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta Apagada com sucesso!!");
                }
            }
            System.out.println(this.ferramenta.ListaFerramenta().toString());
        }  catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            CarregaListaFerramenta();
        }
    }//GEN-LAST:event_JBApagarActionPerformed


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
            java.util.logging.Logger.getLogger(FrmGerenciamentoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciamentoDeFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciamentoDeFerramentas().setVisible(true);
            }
        });
    }
    
   
public void CarregaListaFerramenta(){
    DefaultTableModel modelo = (DefaultTableModel) this.JTableFerramentas.getModel();
    JLId.setVisible(false); /* Deixa o label que informa o Id vazio até que alguma ferramenta seja clicada */
    modelo.setNumRows(0);
    ArrayList<Ferramenta> ListaFerramenta = ferramenta.ListaFerramenta();
    for (Ferramenta a : ListaFerramenta){
        modelo.addRow(new Object[]{
        a.getIdFerramentas(),
        a.getNomeFerramentas(),
        a.getMarcaFerramentas(),
        a.getCustoFerramentas(),
        a.getDisponibilidadeFerramenta(a.getIdFerramentas())
});
        double soma = FerramentaDAO.CalcularSoma(ListaFerramenta);
        JLSoma.setText(String.valueOf("R$" + soma));
}
}   
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JLabel JLID;
    private javax.swing.JLabel JLId;
    private javax.swing.JLabel JLSoma;
    private javax.swing.JTextField JTFCustoAlterar;
    private javax.swing.JTextField JTFMarcaAlterar;
    private javax.swing.JTextField JTFNomeAlterar;
    private javax.swing.JTable JTableFerramentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}