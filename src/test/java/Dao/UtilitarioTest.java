package Dao;

import dao.Utilitario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.sql.*;

class UtilitarioTest {
    
    private Utilitario ut = new Utilitario();
    
    @Test
    void testErroConexaoComBanco() {

        // URL inválida
        Connection conn = ut.getConexao("jdbc:sqlite:/caminho/errado/naoexiste.db");

        assertNull(conn);
    }
}
