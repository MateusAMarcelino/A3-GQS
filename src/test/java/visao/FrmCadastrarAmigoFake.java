package visao;

import dao.FerramentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmCadastrarAmigoFake extends FrmCadastrarAmigo {

    private static final Logger LOGGER = Logger.getLogger(FerramentaDAO.class.getName());

    private String mensagem;

    public FrmCadastrarAmigoFake() {
        super();
    }

    protected void mostrarMensagem(String mensagem) {
        this.mensagem = mensagem;
        LOGGER.log(Level.WARNING, "Mensagem: {0}", mensagem);
    }

    // Método para recuperar a última mensagem mostrada (para testes)
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    // Métodos auxiliares para os testes automatizados
    public javax.swing.JTextField getJTFNomedoAmigo() {
        return super.getJTFNome();
    }

    public javax.swing.JTextField getJTFTelefone() {
        return super.getJTFTelefone();
    }

    public javax.swing.JTextField getJTFEmail() {
        return super.getJTFEmail();
    }

    public void clicarBotaoCadastrar() {
        super.getJBCadastrar().doClick();
    }

    public void clicarBotaoCancelar() {
        super.getJBCancelar().doClick();
    }
}