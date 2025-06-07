package visao;

import dao.AmigoDAO;
import dao.EmprestimoDAO;
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
    
    EmprestimoDAO dao = new EmprestimoDAO();
    
    int maiorId = dao.maiorIDEmprestimo() + 1;
    
     TesteFrmRelatorioEmprestimo() {
    }
    
    @BeforeEach
    void setUp() {
        emp = new Emprestimo(maiorId, 1, 1, "2025-01-21", "FERRAMENTA NUNCA DEVOLVIDA");
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
    public void testSelecionarEmprestimo(){
    
        migo.insertAmigoBD("Osmar", "123456789", "Osmarzinho@gmail.com");
        fer.InsertFerramentaDB("Chave de fenda", "Tramontina", 7.50);
        emp.insertEmprestimoBD(1, 1, "2025-01-21");
        
        frmRelatorioEmprestimo.inicializarTabela();
        frmRelatorioEmprestimo.selecionarLinha(0);
        
        frmRelatorioEmprestimo.getMouseClicked();
        
        assertEquals(maiorId, Integer.parseInt(frmRelatorioEmprestimo.getJLId().getText()));
        assertEquals("Osmar", frmRelatorioEmprestimo.getJLNomeAmigo().getText());
        assertEquals("Chave de fenda", frmRelatorioEmprestimo.getJLNomeFerramenta().getText());
        assertEquals("2025-01-21", frmRelatorioEmprestimo.getJLdataEmp().getText());
        assertEquals("FERRAMENTA NUNCA DEVOLVIDA", frmRelatorioEmprestimo.getJLDataDevolucao().getText());
        
        emp.deleteEmprestimoBD(maiorId);
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
