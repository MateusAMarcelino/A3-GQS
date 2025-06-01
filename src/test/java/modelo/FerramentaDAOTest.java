package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para os métodos da classe FerramentaDAO.
 * Utiliza JUnit 5 para testar as funcionalidades do DAO responsável pelas ferramentas.
 * 
 * Autor: guiho
 */
public class FerramentaDAOTest {

    public FerramentaDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Executado antes de todos os testes da classe
    }

    @AfterAll
    public static void tearDownClass() {
        // Executado após todos os testes da classe
    }

    @BeforeEach
    public void setUp() {
        // Executado antes de cada método de teste
    }

    @AfterEach
    public void tearDown() {
        // Executado após cada método de teste
    }

    /**
     * Testa o método getListaFerramentas().
     */
    @Test
    public void testGetListaFerramentas() {
        System.out.println("Testando getListaFerramentas");
        FerramentaDAO instance = new FerramentaDAO();
        ArrayList<Ferramenta> result = instance.getListaFerramentas();
        assertNotNull(result); // Verifica se a lista não é nula
    }

    /**
     * Testa o método setListaFerramentas().
     */
    @Test
    public void testSetListaFerramentas() {
        System.out.println("Testando setListaFerramentas");
        ArrayList<Ferramenta> lista = new ArrayList<>();
        lista.add(new Ferramenta(1, "Martelo", "Tramontina", 25.0));

        FerramentaDAO.setListaFerramentas(lista);
        assertEquals(lista, FerramentaDAO.getListaFerramentas());
    }

    /**
     * Testa o método MaiorIdFerramentas().
     */
    @Test
    public void testMaiorIdFerramentas() {
        System.out.println("Testando MaiorIdFerramentas");
        FerramentaDAO instance = new FerramentaDAO();
        int result = instance.MaiorIdFerramentas();
        assertTrue(result >= 0); // O ID deve ser maior ou igual a zero
    }

    /**
     * Testa o método InsertFerramentaDB().
     */
    @Test
    public void testInsertFerramentaDB() {
        System.out.println("Testando InsertFerramentaDB");
        Ferramenta ferramenta = new Ferramenta(9999, "Chave de Fenda", "Gedore", 15.0);
        FerramentaDAO instance = new FerramentaDAO();
        boolean result = instance.InsertFerramentaDB(ferramenta);
        assertTrue(result); // Espera-se que a inserção seja bem-sucedida
    }

    /**
     * Testa o método RecuperaFerramentaDB().
     */
    @Test
    public void testRecuperaFerramentaDB() {
        System.out.println("Testando RecuperaFerramentaDB");
        int id = 9999; // Certifique-se de que esse ID existe no banco
        FerramentaDAO instance = new FerramentaDAO();
        Ferramenta result = instance.RecuperaFerramentaDB(id);
        assertNotNull(result); // Verifica se a ferramenta foi encontrada
        assertEquals(id, result.getId()); // Verifica se o ID confere
    }

    /**
     * Testa o método UpdateFerramentaDB().
     */
    @Test
    public void testUpdateFerramentaDB() {
        System.out.println("Testando UpdateFerramentaDB");
        Ferramenta ferramenta = new Ferramenta(9999, "Chave de Fenda", "Stanley", 18.0);
        FerramentaDAO instance = new FerramentaDAO();
        boolean result = instance.UpdateFerramentaDB(ferramenta);
        assertTrue(result); // Espera-se que a atualização seja bem-sucedida
    }

    /**
     * Testa o método DeleteFerramentaDB().
     */
    @Test
    public void testDeleteFerramentaDB() {
        System.out.println("Testando DeleteFerramentaDB");
        int id = 9999; // Certifique-se que esse ID existe para deletar
        FerramentaDAO instance = new FerramentaDAO();
        boolean result = instance.DeleteFerramentaDB(id);
        assertTrue(result); // Espera-se que a exclusão ocorra
    }

    /**
     * Testa o método CalcularSoma().
     */
    @Test
    public void testCalcularSoma() {
        System.out.println("Testando CalcularSoma");
        ArrayList<Ferramenta> lista = new ArrayList<>();
        lista.add(new Ferramenta(1, "Martelo", "Tramontina", 25.0));
        lista.add(new Ferramenta(2, "Alicate", "Vonder", 30.0));
        double expected = 55.0;
        double result = FerramentaDAO.CalcularSoma(lista);
        assertEquals(expected, result, 0.01); // Margem de erro de 0.01
    }
}
