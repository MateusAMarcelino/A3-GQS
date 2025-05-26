package modelo;

import dao.EmprestimoDAO;
import modelo.Emprestimo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoDAOTest {

    private static EmprestimoDAO dao;
    private static int idTeste;

    @BeforeAll
    static void setup() {
        dao = new EmprestimoDAO();
    }

    @Test
    void testInsertEmprestimoBD() {
        int novoId = dao.maiorIDEmprestimo() + 1;
        Emprestimo emp = new Emprestimo(novoId, 1, 1, "2025-05-25", "2025-06-01");
        boolean resultado = dao.insertEmprestimoBD(emp);
        assertTrue(resultado, "Falha ao inserir empréstimo.");
        idTeste = novoId;
    }

    @Test
    void testGetListaEmprestimo() {
        ArrayList<Emprestimo> lista = dao.getListaEmprestimo();
        assertNotNull(lista, "A lista de empréstimos está nula.");
        assertFalse(lista.isEmpty(), "A lista de empréstimos está vazia.");
    }

    
}