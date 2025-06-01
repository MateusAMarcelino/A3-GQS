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
 * Classe de testes para os métodos da classe FerramentaDAO.
 * Usa JUnit 5.
 */
public class FerramentaDAOTest {

    public FerramentaDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Executado uma vez antes de todos os testes
    }

    @AfterAll
    public static void tearDownClass() {
        // Executado uma vez depois de todos os testes
    }

    @BeforeEach
    public void setUp() {
        // Executado antes de cada teste
    }

    @AfterEach
    public void tearDown() {
        // Executado depois de cada teste
    }

    /**
     * Testa o método getListaFerramentas().
     */
    @Test
    public void testGetListaFerramentas() {
        System.out.println("Testando getListaFerramentas");
        FerramentaDAO dao = new FerramentaDAO();
        ArrayList<Ferramenta> result = dao.getListaFerramentas();
        assertNotNull(result); // Verifica se a lista foi retornada
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
        FerramentaDAO dao = new FerramentaDAO();
        assertEquals(lista, dao.getListaFerramentas());
    }

    /**
     * Testa o método MaiorIdFerramentas().
     */
    @Test
    public void testMaiorIdFerramentas() {
        System.out.println("Testando MaiorIdFerramentas");
        FerramentaDAO dao = new FerramentaDAO();
        int result = dao.MaiorIdFerramentas();
        assertTrue(result >= 0);
    }

    /**
     * Testa o método InsertFerramentaDB().
     */
    @Test
    public void testInsertFerramentaDB() {
        System.out.println("Testando InsertFerramentaDB");
        Ferramenta ferramenta = new Ferramenta(9999, "Chave de Fenda", "Gedore", 15.0);
        FerramentaDAO dao = new FerramentaDAO();
        boolean result = dao.InsertFerramentaDB(ferramenta);
        assertTrue(result);
    }

    /**
     * Testa o método RecuperaFerramentaDB().
     */
    @Test
    public void testRecuperaFerramentaDB() {
        System.out.println("Testando RecuperaFerramentaDB");
        int id = 9999;
        FerramentaDAO dao = new FerramentaDAO();
        Ferramenta result = dao.RecuperaFerramentaDB(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    /**
     * Testa o método UpdateFerramentaDB().
     */
    @Test
    public void testUpdateFerramentaDB() {
        System.out.println("Testando UpdateFerramentaDB");
        Ferramenta ferramenta = new Ferramenta(9999, "Chave de Fenda", "Stanley", 18.0);
        FerramentaDAO dao = new FerramentaDAO();
        boolean result = dao.UpdateFerramentaDB(ferramenta);
        assertTrue(result);
    }

    /**
     * Testa o método DeleteFerramentaDB().
     */
    @Test
    public void testDeleteFerramentaDB() {
        System.out.println("Testando DeleteFerramentaDB");
        int id = 9999;
        FerramentaDAO dao = new FerramentaDAO();
        boolean result = dao.DeleteFerramentaDB(id);
        assertTrue(result);
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
        double esperado = 55.0;
        double resultado = FerramentaDAO.CalcularSoma(lista);
        assertEquals(esperado, resultado, 0.01);
    }
}
