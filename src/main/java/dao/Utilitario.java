package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilitario {
    
private static final Logger LOGGER = Logger.getLogger(Utilitario.class.getName());

public Connection getConexao() {
        Connection connection = null;
        Statement stmt = null;
        
        try {
            // 1. Estabelece conexão
            String url = "jdbc:sqlite:db_a3.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Status: Conectado!");

            // 2. Cria tabelas (usando try-with-resources para Statement)
            stmt = connection.createStatement();
            
            String sqlAmigos = "CREATE TABLE IF NOT EXISTS tb_amigos ("
                        + "IdAmigo INTEGER NOT NULL PRIMARY KEY,"
                        + "NomeAmigo VARCHAR(100),"
                        + "TelefoneAmigo INTEGER,"
                        + "EmailAmigo VARCHAR(100)"
                        + ");";

            String sqlFerramentas = "CREATE TABLE IF NOT EXISTS tb_ferramentas ("
                        + "IdFerramentas INTEGER NOT NULL PRIMARY KEY,"
                        + "NomeFerramentas VARCHAR(100),"
                        + "MarcaFerramentas VARCHAR(100),"
                        + "CustoFerramentas DOUBLE"
                        + ");";

            String sqlEmprestimos = "CREATE TABLE IF NOT EXISTS tb_emprestimos ("
                        + "IdEmprestimo INTEGER NOT NULL PRIMARY KEY,"
                        + "IdAmigo INTEGER,"
                        + "IdFerramentas INTEGER,"
                        + "DataEmprestimo DATE,"
                        + "DataDevolucao DATE"
                        + ");";


            stmt.execute(sqlAmigos);
            stmt.execute(sqlFerramentas);
            stmt.execute(sqlEmprestimos);

           } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Erro ao se conectar ou ao criar as tabelas", e);
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar a conexão", ex);
            }
        }
        return null;
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro ao fechar o statement");
            }
        }
    }

    return connection; // <- AGORA está dentro do método corretamente
}