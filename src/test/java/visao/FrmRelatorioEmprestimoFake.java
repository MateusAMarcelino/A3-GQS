package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class FrmRelatorioEmprestimoFake extends FrmRelatorioEmprestimo {
    
    public FrmRelatorioEmprestimoFake(){
        super();
    }
    
    @Override
    public void mostrarMensagem(String mensagem) {
        //Atribui a mensagem ao atributo para ser utilizado nos testes
        setMensagem(mensagem);

        //Mostra a mensagem
        System.out.println("Mensagem:" + mensagem);
    }
    
    public void inicializarTabela(){
        CarregaListaEmprestimo();
    }
    
    public void selecionarLinha(int linha) {
        JTable tabela = this.getJTableEmprestimosAtivos();
        if (linha >= 0 && linha < tabela.getRowCount()) {
            tabela.setRowSelectionInterval(linha, linha);

            String id = tabela.getValueAt(linha, 0).toString();
            getJLId().setText(id);
        }
    }
    
    public void clicarBotaoApagar() {
        super.getJBApagar().doClick();
    }
}