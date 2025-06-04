package visao;

import dao.FerramentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmCadastrarFerramentaFake extends FrmCadastrarFerramenta {
    
    
    private static final Logger LOGGER = Logger.getLogger(FerramentaDAO.class.getName());
    
    public FrmCadastrarFerramentaFake() {
        super();
}
    
    public void mostrarmensagem(String Mensagem) {
        setMensagem(Mensagem);
        
         LOGGER.log(Level.WARNING, "Mensagem :" + Mensagem);
    }

    public javax.swing.JTextField getJTFNomedoF() {
        return super.getJTFNomeF();
    }
    
    public javax.swing.JTextField getJTFCustoF() {
        return super.getJTFCustoF();
    }
    
    public javax.swing.JTextField getJTFMarcaF() {
        return super.getJTFMarcaF();
    }
    
    public void clicarBotaoCadastrar() {
        super.getJBCadastrar().doClick();
    }
     
      public void clicarBotaoCancelar() {
        super.getJBCancelar().doClick();
    }

    
}
