package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilitario {

    public Connection getConexao() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:db_a3.db";
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Status: Conectado!");

                Statement stmt = connection.createStatement();

                // Cria as tabelas, caso não existam.
                String Amigos = "CREATE TABLE IF NOT EXISTS tb_amigos ("
                        + "IdAmigo INTEGER NOT NULL PRIMARY KEY,"
                        + "NomeAmigo VARCHAR(100),"
                        + "TelefoneAmigo INTEGER,"
                        + "EmailAmigo VARCHAR(100)"
                        + ");";

                String Ferramentas = "CREATE TABLE IF NOT EXISTS tb_ferramentas ("
                        + "IdFerramentas INTEGER NOT NULL PRIMARY KEY,"
                        + "NomeFerramentas VARCHAR(100),"
                        + "MarcaFerramentas VARCHAR(100),"
                        + "CustoFerramentas DOUBLE"
                        + ");";

                String Emprestimos = "CREATE TABLE IF NOT EXISTS tb_emprestimos ("
                        + "IdEmprestimo INTEGER NOT NULL PRIMARY KEY,"
                        + "IdAmigo INTEGER,"
                        + "IdFerramentas INTEGER,"
                        + "DataEmprestimo DATE,"
                        + "DataDevolucao DATE"
                        + ");";

                // Executando os comandos
                stmt.execute(Amigos);
                stmt.execute(Ferramentas);
                stmt.execute(Emprestimos);
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou criar tabelas: " + e.getMessage());
            return null;
        }
    }
}
