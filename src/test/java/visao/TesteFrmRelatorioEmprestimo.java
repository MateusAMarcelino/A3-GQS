package visao;

import dao.AmigoDAO;
import dao.FerramentaDAO;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteFrmRelatorioEmprestimo {
    
    Emprestimo emp;
    Amigo migo;
    Ferramenta fer;
    
    FrmRelatorioEmprestimoFake frmRelatorioEmprestimo;
    
     TesteFrmRelatorioEmprestimo() {
    }
    
    @BeforeEach
    void setUp() {
        
        emp = new Emprestimo(1, 1, 1, "2025-01-21", "FERRAMENTA NUNCA DEVOLVIDA");
        migo = new Amigo(1, "Osmar", "123456789", "Osmarzinho@gmail.com");
        fer = new Ferramenta(1, "Chave de fenda", "Tramontina", 7.50);
        
        frmRelatorioEmprestimo = new FrmRelatorioEmprestimoFake();
    }
    
    @Test
    void testCancelarFechaJanela() {
        FrmRelatorioEmprestimo janela = new FrmRelatorioEmprestimo();

        assertTrue(janela.isDisplayable());

        janela.simularCliqueCancelar();

        assertFalse(janela.isDisplayable());
    }
    
    @Test
    void testDeletarEmprestimo(){
        migo.insertAmigoBD("Osmar", "123456789", "Osmarzinho@gmail.com");
        fer.InsertFerramentaDB("Chave de fenda", "Tramontina", 7.50);
        emp.insertEmprestimoBD(1, 1, "2025-01-21");
        
        frmRelatorioEmprestimo.inicializarTabela();
        frmRelatorioEmprestimo.selecionarLinha(0);
        
        frmRelatorioEmprestimo.clicarBotaoApagar();
        
        assertEquals("Emprestimo apagado com sucesso!", frmRelatorioEmprestimo.getMensagem());
    }
    
    @AfterEach
     void tearDown() {
        AmigoDAO amigodao = new AmigoDAO();
        amigodao.deleteAmigoBD(1);
        
        FerramentaDAO ferramentadao = new FerramentaDAO();
        ferramentadao.DeleteFerramentaDB(1);
    }

}
