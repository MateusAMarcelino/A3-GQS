package visao;

import javax.swing.JOptionPane;

public class FrmGerenciamentoDeFerramentasFake extends FrmGerenciamentoDeFerramentas {

    public FrmGerenciamentoDeFerramentasFake() {
        super();
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        //Atribui a mensagem ao atributo para ser utilizado nos testes
        setMensagem(mensagem);

        //Mostra a mensagem
        System.out.println("Mensagem:" + mensagem);
    }

    public int confirmarApagarFerramenta() {
        return JOptionPane.YES_OPTION; // Simula clique no "Sim"
    }

    public void inicializarListaFerramentas() {
        CarregaListaFerramenta();
    }

    public void selecionarLinha(int linha) {
        getJTableFerramentas().setRowSelectionInterval(linha, linha);
    }

    public javax.swing.JTextField getJTFNomeAlterar() {
        return super.getJTFNomeAlterar();  //
    }

    public javax.swing.JTextField getJTFMarcaAlterar() {
        return super.getJTFMarcaAlterar();
    }

    public javax.swing.JTextField getJTFCustoAlterar() {
        return super.getJTFCustoAlterar();
    }
    

    public void clicarBotaoAlterar() {
        super.getJBAlterar().doClick();
    }

    public void clicarBotaoApagar() {
        super.getJBApagar().doClick();
    }

    public void clicarBotaoCancelar() {
        super.getJBCancelar().doClick();
    }
}
