package Dao;

import static org.junit.jupiter.api.Assertions.*;

import modelo.Ferramenta;
import dao.FerramentaDAO;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import modelo.FakeFerramentaDAO;

class FerramentaDAOTest {

    private FerramentaDAO dao;

    @BeforeEach
void setUp() {
    dao = new FakeFerramentaDAO();  // Usando DAO falsa
}


    @Test
    void testInsertAndRetrieveFerramenta() {
        int novoId = dao.MaiorIdFerramentas() + 1;
        Ferramenta ferramenta = new Ferramenta(novoId, "Martelo", "Tramontina", 25.99);

        assertTrue(dao.InsertFerramentaDB(ferramenta), "Falha ao inserir ferramenta");

        Ferramenta recuperada = dao.RecuperaFerramentaDB(novoId);
        assertEquals(ferramenta.getIdFerramentas(), recuperada.getIdFerramentas());
        assertEquals(ferramenta.getNomeFerramentas(), recuperada.getNomeFerramentas());
        assertEquals(ferramenta.getMarcaFerramentas(), recuperada.getMarcaFerramentas());
        assertEquals(ferramenta.getCustoFerramentas(), recuperada.getCustoFerramentas());
    }

    @Test
    void testUpdateFerramenta() {
        int novoId = dao.MaiorIdFerramentas() + 1;
        Ferramenta ferramenta = new Ferramenta(novoId, "Chave de Fenda", "Vonder", 10.00);
        dao.InsertFerramentaDB(ferramenta);

        ferramenta.setNomeFerramentas("Chave Phillips");
        ferramenta.setCustoFerramenta(12.50);
        assertTrue(dao.UpdateFerramentaDB(ferramenta), "Falha ao atualizar ferramenta");

        Ferramenta atualizada = dao.RecuperaFerramentaDB(novoId);
        assertEquals("Chave Phillips", atualizada.getNomeFerramentas());
        assertEquals(12.50, atualizada.getCustoFerramentas());
    }

    @Test
    void testDeleteFerramenta() {
        int novoId = dao.MaiorIdFerramentas() + 1;
        Ferramenta ferramenta = new Ferramenta(novoId, "Serrote", "Black&Decker", 45.00);
        dao.InsertFerramentaDB(ferramenta);

        assertTrue(dao.DeleteFerramentaDB(novoId), "Falha ao deletar ferramenta");

        Ferramenta excluida = dao.RecuperaFerramentaDB(novoId);
        // O nome estará null se a recuperação falhar
        assertNull(excluida.getNomeFerramentas(), "Ferramenta ainda existe após exclusão");
    }

    @Test
    void testCalcularSoma() {
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();
        ferramentas.add(new Ferramenta(1, "Alicate", "Tramontina", 30.0));
        ferramentas.add(new Ferramenta(2, "Martelo", "Stanley", 40.0));
        ferramentas.add(new Ferramenta(3, "Chave", "Vonder", 20.0));

        double soma = FerramentaDAO.CalcularSoma(ferramentas);
        assertEquals(90.0, soma);
    }
}
