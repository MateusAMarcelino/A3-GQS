package Dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import dao.AmigoDAO;
import modelo.Amigo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzoeid
 */
   class AmigoDAOTest {
    private Connection conexao;
    AmigoDAO dao = new AmigoDAO();
    int idTeste = 999;
    Amigo amigo = new Amigo(idTeste, "Teste", "123456", "teste@gmail.com");
    private static final Logger LOGGER = Logger.getLogger(AmigoDAO.class.getName());

    @BeforeEach
    void setup() throws Exception {
        conexao = new dao.Utilitario().getConexao();
        Statement stmt = conexao.createStatement();
        
        stmt.executeUpdate("DELETE FROM tb_amigos");
        stmt.executeUpdate("INSERT INTO tb_amigos (IdAmigo, NomeAmigo, TelefoneAmigo, EmailAmigo) " +
                           "VALUES (1, 'Osmar', '123456', 'Osmar@gmail.com')");
        stmt.executeUpdate("INSERT INTO tb_amigos (IdAmigo, NomeAmigo, TelefoneAmigo, EmailAmigo) " +
                           "VALUES (2, 'Maria', '654321', 'maria@gmail.com')");

        stmt.close();
    }
    
    @Test
    void testGetListaAmigo() {
        ArrayList<Amigo> lista = dao.getListaAmigo();

        assertNotNull(lista);
        assertEquals(2, lista.size());

        Amigo amigo1 = lista.get(0);
        assertEquals(1, amigo1.getIdAmigo());
        assertEquals("Osmar", amigo1.getNomeAmigo());
    }

    @AfterEach
    void cleanup() throws Exception {
        Statement stmt = conexao.createStatement();
        stmt.executeUpdate("DELETE FROM tb_amigos");
        stmt.close();
        conexao.close();
    }
       
    @Test
    void testSetListaAmigo() {
        Amigo amigo = new Amigo(1, "Osmar", "123456", "Osmar@gmail.com");
        ArrayList<Amigo> novaLista = new ArrayList<>();
        novaLista.add(amigo);

        AmigoDAO.setListaAmigo(novaLista);

        assertEquals(1, AmigoDAO.ListaAmigo.size());
        assertEquals("Osmar", AmigoDAO.ListaAmigo.get(0).getNomeAmigo());
    }
    
    @Test
    void testInsertAmigoBD() {
        boolean resultado = dao.insertAmigoBD(amigo);

        assertTrue(resultado);

        boolean encontrado = AmigoDAO.ListaAmigo.stream()
            .anyMatch(a -> a.getIdAmigo() == idTeste);

        dao.deleteAmigoBD(idTeste);

        assertTrue(resultado);
        amigo.deleteAmigoBD(idTeste);
    }
    
    @Test
    void testRecuperaAmigoDB() {
        dao.insertAmigoBD(amigo);
    
        Amigo amigoRecuperado = dao.RecuperaAmigoBD(idTeste);
        
        assertEquals(idTeste, amigoRecuperado.getIdAmigo());
        assertEquals("Teste", amigoRecuperado.getNomeAmigo());
        assertEquals("123456", amigoRecuperado.getTelefoneAmigo());
        assertEquals("teste@gmail.com", amigoRecuperado.getEmailAmigo());
        
        dao.deleteAmigoBD(idTeste);
    }
    
    @Test
    void testUpdateAmigoBD() {
        dao.insertAmigoBD(amigo);
        
        Amigo amigoAtualizado = new Amigo(idTeste, "Teste Atualizado", "999999", "testeatualizado@gmail.com");
        boolean resultadoUpdate = dao.updateAmigoBD(amigoAtualizado);
        assertTrue(resultadoUpdate, "A atualização falhou");
        
        Amigo amigoDoBanco = dao.RecuperaAmigoBD(idTeste);
        assertEquals("Teste Atualizado", amigoDoBanco.getNomeAmigo());
        assertEquals("999999", amigoDoBanco.getTelefoneAmigo());
        assertEquals("testeatualizado@gmail.com", amigoDoBanco.getEmailAmigo());
        
        dao.deleteAmigoBD(idTeste);
    }
}
