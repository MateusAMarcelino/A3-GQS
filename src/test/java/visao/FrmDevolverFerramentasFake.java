package visao;

import javax.swing.*;

public class FrmDevolverFerramentasFake extends FrmDevolverFerramentas {
    
    public FrmDevolverFerramentasFake() {
        super();
    }

    public void mostrarMensagem(String mensagem) {

        setMensagem(mensagem);
        
        System.out.println("Mensagem:" + mensagem);
    }

    public void inicializar() {
        carregaCBEmprestimo();
    }

    public void clicarBotaoCadastrar() {
        super.getJBCadastrar().doClick();
    }

    public JComboBox<String> getJCBEmprestimo() {
        return super.getJCBEmprestimo();
    }

    public JComboBox<String> getJCBTipoRegistro() {
        return super.getJCBTipoRegistro();
    }
}
