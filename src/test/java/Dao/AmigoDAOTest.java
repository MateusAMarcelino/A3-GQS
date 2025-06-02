package Dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import dao.AmigoDAO;
import modelo.Amigo;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lorenzoeid
 */
public class AmigoDAOTest {
    private Connection conexao;

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
        AmigoDAO dao = new AmigoDAO();
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
    
    
}
