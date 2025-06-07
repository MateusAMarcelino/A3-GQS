package modelo;

import dao.EmprestimoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Emprestimo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


class TestEmprestimo {
    
    @BeforeEach
    void inicializarEmprestimos() {
        EmprestimoDAO dao = new EmprestimoDAO();

        // Empréstimo com data de devolução futura (ativo)
        Emprestimo emprestimo01 = new Emprestimo(3, 3, 7, "2025-06-01", "2025-12-31");
        dao.insertEmprestimoBD(emprestimo01);

        // Empréstimo com data de devolução passada (inativo)
        Emprestimo emprestimo02 = new Emprestimo(5, 6, 9, "2025-03-22", "2025-04-01");
        dao.insertEmprestimoBD(emprestimo02);

        // Empréstimo sem data de devolução (ativo)
        Emprestimo emprestimo03 = new Emprestimo(7, 9, 4, "2025-06-01", null);
        dao.insertEmprestimoBD(emprestimo03);
    }
    
    @AfterEach
     void limpar() {
        EmprestimoDAO dao = new EmprestimoDAO();
        dao.deleteEmprestimoBD(3);
        dao.deleteEmprestimoBD(5);
        dao.deleteEmprestimoBD(7);
    }
    
    
    @Test
    void TestGetListaEmprestimo() {
        EmprestimoDAO dao = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimo = dao.getListaEmprestimo();
        int retornoEsperado = 3;
        assertEquals(retornoEsperado, listaEmprestimo.size());

    }
    
    @Test
    void TestMaiorID() {
        EmprestimoDAO dao = new EmprestimoDAO();
        int retornoEsperado = 7;
        assertEquals(retornoEsperado, dao.maiorIDEmprestimo());
    }
    
    @Test
    void testEmprestimoAtivoComDataDevolucaoFutura() {
        Emprestimo emp = new Emprestimo();
        String resultado = emp.emprestimoAtivo(3);
        assertEquals("Sim", resultado, "Empréstimo com data futura deveria estar ativo");
    }

    @Test
    void testEmprestimoAtivoSemDataDevolucao() {
        Emprestimo emp = new Emprestimo();
        String resultado = emp.emprestimoAtivo(7);
        assertEquals("Sim", resultado, "Empréstimo sem data de devolução deveria estar ativo");
    }

    @Test
    void testEmprestimoInativoComDataPassada() {
        Emprestimo emp = new Emprestimo();
        String resultado = emp.emprestimoAtivo(5);
        assertEquals("Não", resultado, "Empréstimo com data de devolução passada deveria estar inativo");
    }

    @Test
    void testEmprestimoInexistente() {
        Emprestimo emp = new Emprestimo();
        String resultado = emp.emprestimoAtivo(999); // ID que não foi cadastrado
        assertEquals("Não", resultado, "Empréstimo inexistente deve retornar 'Não'");
    }
    
    @Test
    public void testProcuraIndiceEncontrado() {
        Emprestimo emp = new Emprestimo();
        int indice = emp.procuraIndice(2);
        assertEquals(-1, indice); // índice 1 porque emp2 foi o segundo adicionado
    }
    
    @Test
    public void testProcuraIndiceNaoEncontrado() {
        Emprestimo emp = new Emprestimo();
        int indice = emp.procuraIndice(99); // ID inexistente
        assertEquals(-1, indice);
    }
}
