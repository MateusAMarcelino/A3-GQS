package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Utilitario {
    
    //conexão com o banco de dados 
    public Connection getConexao() {
        
        Connection connection = null;  //instância da conexão
        
        try {
            // Carregamento do JDBC Driver
            String url = "jdbc:sqlite:db_a3.db";          
           
            connection = DriverManager.getConnection(url);
            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

               } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
    
    public void criartabela() {
      String CriarTabelaAmigos = "CREATE TABLE tb_amigos (\n" +"IdAmigo INTEGER NOT NULL,\n" +"NomeAmigo VARCHAR(100) NULL,\n" +"TelefoneAmigo INTEGER NULL,\n" +"EmailAmigo VARCHAR(100),\n" +"PRIMARY KEY(IdAmigo)\n" +");"; 
    }  
}

    

