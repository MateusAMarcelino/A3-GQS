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
        carregaTabela();
    }

    public void clicarBotaoJBApagar() {
        getJTableAmigos().setRowSelectionInterval(0, 0);
        super.getJBApagar().doClick();
    }

    public void clicarBotaoJBEditar() {
        getJTableAmigos().setRowSelectionInterval(0, 0);
        super.getJBEditar().doClick();
    }
}
