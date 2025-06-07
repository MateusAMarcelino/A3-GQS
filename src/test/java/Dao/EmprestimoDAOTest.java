package Dao;

import dao.EmprestimoDAO;
import dao.Utilitario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Emprestimo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import modelo.Emprestimo;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoDAOTest {

    private static EmprestimoDAO dao;
    private static int idTeste;
 
    /**
     * Este método é executado uma única vez antes de todos os testes.
     * Ele instancia o objeto DAO que será utilizado nos testes.
     */
    @BeforeAll
    static void setup() {
        dao = new EmprestimoDAO();
    }

    /**
     * Testa a inserção de um novo empréstimo no banco de dados.
     * Verifica se a operação retorna `true`, indicando sucesso.
     * Também armazena o ID do empréstimo inserido para ser usado nos testes seguintes.
     */
    @Test
    void testInsertEmprestimoBD() {
        int novoId = dao.maiorIDEmprestimo() + 1;
        Emprestimo emp = new Emprestimo(novoId, 1, 1, "2025-05-25", "2025-06-01");
        boolean resultado = dao.insertEmprestimoBD(emp);
        assertTrue(resultado, "Falha ao inserir empréstimo.");
        idTeste = novoId;
    }

     /**
     * Testa a recuperação da lista de empréstimos.
     * Primeiro insere um empréstimo para garantir que a lista não estará vazia.
     * Em seguida, verifica se a lista retornada não é nula nem vazia.
     */
    @Test
    void testGetListaEmprestimo() {
    int novoId = dao.maiorIDEmprestimo() + 1;
    Emprestimo emp = new Emprestimo(novoId, 1, 1, "2025-05-25", "2025-06-01");
    dao.insertEmprestimoBD(emp); // <-- insere um empréstimo

    ArrayList<Emprestimo> lista = dao.getListaEmprestimo();
    assertNotNull(lista, "A lista de empréstimos está nula.");
    assertFalse(lista.isEmpty(), "A lista de empréstimos está vazia .");
}

/**
     * Testa a recuperação de um empréstimo específico a partir de seu ID.
     * Verifica se o objeto retornado possui o mesmo ID utilizado na inserção.
     */

    @Test
    void testRecuperaEmprestimoDB() {
        Utilitario ut = new Utilitario();

        // Primeiro insere um empréstimo no banco
        try (Connection conn = ut.getConexao();
            Statement stmt = conn.createStatement()) {
        
            stmt.execute("INSERT INTO tb_emprestimos VALUES (1, 100, 200, '2025-01-21', '2025-01-28')");
        } catch (SQLException e) {
        fail("Erro ao preparar o teste: " + e.getMessage());
        }
        
        Emprestimo emp = dao.RecuperaEmprestimoDB(1);
        
        assertEquals(1, emp.getIdEmprestimo());
        assertEquals(100, emp.getIdAmigo());
        assertEquals(200, emp.getIdFerramentas());
        assertEquals("2025-01-21", emp.getDataEmp());
        assertEquals("2025-01-28", emp.getDataDev());
    }

    /**
     * Testa a atualização de um empréstimo já existente.
     * Altera a data de devolução e verifica se a atualização retorna `true`.
     */
    @Test
    void testUpdateEmprestimoBD() {
        Emprestimo emp = dao.RecuperaEmprestimoDB(idTeste);
        emp.setDataDev("2025-06-05"); // Atualiza a data de devolução
        boolean result = dao.updateEmprestimoBD(emp);
        assertTrue(result, "Falha ao atualizar empréstimo.");
    }
    
        @AfterEach
    void limpar() {
        EmprestimoDAO dao = new EmprestimoDAO();
        dao.deleteEmprestimoBD(1);
        dao.deleteEmprestimoBD(2);
        dao.deleteEmprestimoBD(3);
    }
}