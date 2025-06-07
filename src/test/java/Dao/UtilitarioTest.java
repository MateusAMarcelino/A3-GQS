package Dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.sql.*;

public class UtilitarioTest {
    
    @Test
    public void testErroConexaoComBanco() {
       // Simula erro passando uma URL inválida
       String urlInvalida = "jdbc:sqlite:/caminho/inexistente/naoexiste.db";
       Connection connection = null;
       Statement stmt = null;

        try {
            // Força erro de conexão
            connection = DriverManager.getConnection(urlInvalida); // Vai para o catch
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro esperado capturado: " + e.getMessage());
            assertNull(connection);
        return;
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ignored) {}
        }
    }

    fail("Era esperado erro de conexão, mas não ocorreu.");
    
    new File("db_a3.db").delete();
    }
}
