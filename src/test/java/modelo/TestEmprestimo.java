package modelo;

import dao.EmprestimoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Emprestimo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class TestEmprestimo {
    
    @BeforeEach
    void inicializaremprestimo() {
        EmprestimoDAO dao = new EmprestimoDAO();
        Emprestimo emprestimo01 = new Emprestimo (3 , 3 , 7 , "05-12-2025" , "05-13-2025");
        dao.insertEmprestimoBD(emprestimo01);
        Emprestimo emprestimo02 = new Emprestimo (5 , 6 , 9 , "03-22-2025" , "05-12-2025");
        dao.insertEmprestimoBD(emprestimo02);       
    }
    
            @AfterEach
    void limpar() {
        EmprestimoDAO dao = new EmprestimoDAO();
        dao.deleteEmprestimoBD(3);
        dao.deleteEmprestimoBD(5);
    }
    
    
    @Test
    void TestGetListaEmprestimo() {
        EmprestimoDAO dao = new EmprestimoDAO();
        List<Emprestimo> listaEmprestimo = dao.getListaEmprestimo();
        int retornoEsperado = 2;
        assertEquals(retornoEsperado, listaEmprestimo.size());

    }
    
    @Test
    void TestMaiorID() {
        EmprestimoDAO dao = new EmprestimoDAO();
        int retornoEsperado = 5;
        assertEquals(retornoEsperado, dao.maiorIDEmprestimo());
    }
}
