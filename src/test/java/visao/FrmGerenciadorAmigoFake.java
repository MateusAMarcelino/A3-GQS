package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmGerenciadorAmigoFake extends FrmGerenciadorAmigo {
    
    public FrmGerenciadorAmigoFake() {
        super();
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Telefone", "Email"}, 0);
        JTable tabelaFalsa = new JTable(modelo);
        
        setJTableAmigos(tabelaFalsa);
    }

    public void mostrarMensagem(String mensagem) {

        setMensagem(mensagem);
        
        System.out.println("Mensagem:" + mensagem);
    }

    public void inicializar() {
        this.setVisible(false);
        this.carregaTabela();
    }

    public void clicarBotaoJBApagar() {
        if (this.getJTableAmigos().getRowCount() > 0) {
            getJTableAmigos().setRowSelectionInterval(0, 0);
        }
        JOptionPane pane = new JOptionPane();
        pane.setValue(JOptionPane.YES_OPTION);

        super.getJBApagar().doClick();
    }

    public void clicarBotaoJBEditar() {
        if (this.getJTableAmigos().getRowCount() > 0) {
            getJTableAmigos().setRowSelectionInterval(0, 0);

        }
        super.getJBEditar().doClick();
    }
}
