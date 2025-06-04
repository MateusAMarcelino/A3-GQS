package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FrmEmprestimoDeFerramentasFake extends FrmEmprestimoDeFerramentas {

    public FrmEmprestimoDeFerramentasFake() {
        super();
    }

    public void mostrarMensagem(String mensagem) {

        setMensagem(mensagem);
        
        System.out.println("Mensagem:" + mensagem);
    }

    public int confirmarEmprestimo() {
        return JOptionPane.YES_OPTION;
    }

    public void inicializarambos() {
        carregaCBAmigo();
        carregaCBFerramenta();
    }

    public void clicarBotaoConfirmar() {
        super.getJBConfirmar().doClick();
    }

    public JComboBox<String> getjCBNomeAmigo() {
        return super.getjCBNomeAmigo();
    }

    public JComboBox<String> getjCBNomeFerramenta() {
        return super.getjCBNomeFerramenta();
    }
}
