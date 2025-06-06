package visao;

import modelo.Amigo;
import dao.EmprestimoDAO;
import java.awt.Window;
import javax.swing.JDialog;
import modelo.Emprestimo;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteFrmEmprestimoDeFerramentas {

    Amigo amigoteste;
    Ferramenta ferramentateste;
    Emprestimo emprestimoteste;

    FrmEmprestimoDeFerramentasFake frmEmprestimoDeFerramentas;

    @BeforeEach
    void iniciar() {

        amigoteste = new Amigo(1, "Thiago", "123456789", "emailteste@gmail.com");
        ferramentateste = new Ferramenta(1, "Machado", "Lumber", 20.5);
        emprestimoteste = new Emprestimo();

        frmEmprestimoDeFerramentas = new FrmEmprestimoDeFerramentasFake();

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
    void CadastroValido() {

        amigoteste.insertAmigoBD("Thiago", "123456789", "emailteste@gmail.com");
        ferramentateste.InsertFerramentaDB("Machado", "Lumber", 20.5);

        frmEmprestimoDeFerramentas.inicializarambos();

        frmEmprestimoDeFerramentas.getjCBNomeAmigo().setSelectedIndex(0);
        frmEmprestimoDeFerramentas.getjCBNomeFerramenta().setSelectedIndex(0);

        frmEmprestimoDeFerramentas.clicarBotaoConfirmar();
        
        assertEquals("Empréstimo cadastrado com sucesso", frmEmprestimoDeFerramentas.getMensagem());
    }
    
}
