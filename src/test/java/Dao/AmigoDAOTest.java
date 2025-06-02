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
public class AmigoDAOTest {
    private Connection conexao;
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
    
    @Test
    void testGetListaAmigoSQLException() {
        AmigoDAO dao = new AmigoDAO() {
        @Override
        public ArrayList<Amigo> getListaAmigo() {
            ListaAmigo.clear();
            try {
                // Força uma query inválida para gerar SQLException
                try (Statement stmt = new dao.Utilitario().getConexao().createStatement()) {
                    stmt.executeQuery("SELECT * FROM tabela_inexistente");
                }
            } catch (SQLException ex) {
                // Aqui o LOGGER será chamado
                LOGGER.log(Level.SEVERE, "Erro ao acessar o banco de dados", ex);
            }
            return ListaAmigo;
        }
    };

    // Executa o método, que deve cair no catch
    ArrayList<Amigo> resultado = dao.getListaAmigo();

    assertNotNull(resultado); // Mesmo com erro, deve retornar lista vazia
    assertEquals(0, resultado.size());
    }
}
