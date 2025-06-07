package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilitario {
    
private static final Logger LOGGER = Logger.getLogger(Utilitario.class.getName());

public Connection getConexao(){
    return getConexao("jdbc:sqlite:db_a3.db");
}

public Connection getConexao(String url) {
        Connection connection = null;
        Statement stmt = null;
        
        try {
            // 1. Estabelece conexão
            connection = DriverManager.getConnection(url);
            LOGGER.info("Status: Conectado!");

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

           

            return connection;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao se conectar ou ao criar as tabelas", e);
            // Fecha a conexão se aberta (evita vazamento)
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Erro ao fechar a conexão com a tabela", ex);
                }
            }
            return null;
        } finally {
            // Fecha o Statement (mas mantém a Connection aberta para uso externo)
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                     LOGGER.log(Level.SEVERE, "Erro ao fechar o statement");
                }
                }
            }
        }
    }

    