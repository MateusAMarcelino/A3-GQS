package visao;

import dao.FerramentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmCadastrarAmigoFake extends FrmCadastrarAmigo {
     /**
     * Inicializa os atributos.
     */
    
    private static final Logger LOGGER = Logger.getLogger(FerramentaDAO.class.getName());
    
    public FrmCadastrarAmigoFake() {
        super();
    }
    
    public void mostrarmensagem(String Mensagem) {
        setMensagem(Mensagem);
        
         LOGGER.log(Level.WARNING, "Mensagem :" + Mensagem);
    }
    
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
