package visao;

import dao.EmprestimoDAO;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TesteFrmDevolverFerramentas {
    
    Amigo amigoteste;
    Ferramenta ferramentateste;
    Emprestimo emprestimoteste;
    FrmDevolverFerramentasFake frmDevolverFerramentas;
    
    @BeforeEach
     void setUp() {
        amigoteste = new Amigo(1, "Osmar", "123456789", "Osmar@gmail.com");
        ferramentateste = new Ferramenta(1, "Chave de fenda", "Tramontina", 9.50);
        emprestimoteste = new Emprestimo();
        
        frmDevolverFerramentas = new FrmDevolverFerramentasFake();
    }
    
    @AfterEach
    void finaliza() {
        Amigo amigoteste = new Amigo();
        amigoteste.deleteAmigoBD(1);
        Ferramenta ferramentateste = new Ferramenta();
        ferramentateste.DeleteFerramentaDB(1);
        Emprestimo emprestimoteste = new Emprestimo();
        emprestimoteste.deleteEmprestimoBD(1);
    }
    
    @Test
    void DevolucaoValida(){
        amigoteste.insertAmigoBD("Osmar", "123456789", "Osmar@gmail.com");
        ferramentateste.InsertFerramentaDB("Chave de fenda", "Tramontina", 9.50);
        emprestimoteste.insertEmprestimoBD(1, 1, "21-01-2025");
        
        frmDevolverFerramentas.inicializar();
        
        frmDevolverFerramentas.getJCBEmprestimo().setSelectedIndex(0);
        frmDevolverFerramentas.getJCBTipoRegistro().setSelectedIndex(0);
        
        frmDevolverFerramentas.clicarBotaoCadastrar();
        
        assertEquals("Devolucao cadastrada com sucesso", frmDevolverFerramentas.getMensagem());
    }
}
