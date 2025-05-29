package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilitario {

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
                    + "IdAmigo INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NomeAmigo TEXT NOT NULL,"
                    + "TelefoneAmigo TEXT,"
                    + "EmailAmigo TEXT"
                    + ");";

            String sqlFerramentas = "CREATE TABLE IF NOT EXISTS tb_ferramentas ("
                    + "IdFerramentas INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NomeFerramentas TEXT NOT NULL,"
                    + "MarcaFerramentas TEXT,"
                    + "CustoFerramentas REAL"
                    + ");";

            String sqlEmprestimos = "CREATE TABLE IF NOT EXISTS tb_emprestimos ("
                    + "IdEmprestimo INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "IdAmigo INTEGER NOT NULL,"
                    + "IdFerramentas INTEGER NOT NULL,"
                    + "DataEmprestimo TEXT,"
                    + "DataDevolucao TEXT,"
                    + "FOREIGN KEY (IdAmigo) REFERENCES tb_amigos(IdAmigo),"
                    + "FOREIGN KEY (IdFerramentas) REFERENCES tb_ferramentas(IdFerramentas)"
                    + ");";

            stmt.execute(sqlAmigos);
            stmt.execute(sqlFerramentas);
            stmt.execute(sqlEmprestimos);

            // 3. Ativa chaves estrangeiras (SQLite requer isso explicitamente)
            stmt.execute("PRAGMA foreign_keys = ON;");

            return connection;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou criar tabelas: " + e.getMessage());
            // Fecha a conexão se aberta (evita vazamento)
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.err.println("Erro ao fechar conexão: " + ex.getMessage());
                }
            }
            return null;
        } finally {
            // Fecha o Statement (mas mantém a Connection aberta para uso externo)
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar Statement: " + e.getMessage());
                }
            }
        }
    }
}
