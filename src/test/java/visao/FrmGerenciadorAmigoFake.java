package visao;

import javax.swing.JOptionPane;

public class FrmGerenciadorAmigoFake extends FrmGerenciadorAmigo {
    
   public FrmGerenciadorAmigoFake() {
        super();
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        //Atribui a mensagem ao atributo para ser utilizado nos testes
        setMensagem(mensagem);

        //Mostra a mensagem
        System.out.println("Mensagem:" + mensagem);
    }


    public int confirmarApagarAmigo() {
        return JOptionPane.YES_OPTION; // Simula clique no "Sim"
    }

    public void inicializarLista() {
        carregaTabela();
    }

    public void selecionarLinha(int linha) {
        getJTableAmigos().setRowSelectionInterval(linha, linha);
    }


    public javax.swing.JTextField getJTFNome() {
        return super.getJTFNome();  //
    }


    public javax.swing.JTextField getJTFTelefone() {
        return super.getJTFTelefone();
    }

    public void clicarBotaoEditar() {
        super.getJBEditar().doClick();
    }

    public void clicarBotaoApagar() {
        super.getJBApagar().doClick();
    }
    
     public void clicarBotaoCancelar() {
        super.getJBCancelar().doClick();
    }
    
     
}

    
    

