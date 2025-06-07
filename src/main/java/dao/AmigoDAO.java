package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AmigoDAO {

    /*
    Inicia o Utilitario,realizando a conecxão com o DB.
     */
    private Utilitario ut = new Utilitario();
    private static final Logger LOGGER = Logger.getLogger(AmigoDAO.class.getName());

    /**
     * Cria a ArrayList para os amigos.
     */
    public static ArrayList<Amigo> ListaAmigo = new ArrayList<>();

    /**
     * Coleta as informações dos amigos do banco de dados e cria um objeto com
     * essas informações no ArrayList da ListaAmigos.
     *
     * @return A lista de ferramentas após pegar os dados.
     */
    public ArrayList<Amigo> getListaAmigo() {

        ListaAmigo.clear(); // Limpa nosso ArrayList.

        try {
    try (Statement stmt = ut.getConexao().createStatement()) {
        ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
                while (res.next()) {

                    int IdAmigo = res.getInt("IdAmigo");
                    String NomeAmigo = res.getString("NomeAmigo");
                    String TelefoneAmigo = res.getString("TelefoneAmigo");
                    String EmailAmigo = res.getString("EmailAmigo");

                    Amigo objeto = new Amigo(IdAmigo, NomeAmigo, TelefoneAmigo, EmailAmigo);

                    ListaAmigo.add(objeto);
                }
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao acessar o banco de dados", ex);
        }
        return ListaAmigo;
    }

    public static void setListaAmigo(ArrayList<Amigo> ListaAmigo) {
        AmigoDAO.ListaAmigo = ListaAmigo;
    }

    /**
     * Procura o maior ID entre os amigos, buscando entre todos os amigos no
     * banco de dados.
     *
     * @return O maior ID encontrado.
     */
    public int maiorIDAmigo() {
        int maiorID = 0;
        try {
            try (Statement stmt = ut.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(IdAmigo) IdAmigo FROM tb_amigos");
                res.next();
                maiorID = res.getInt("IdAmigo");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao localizar o Maior ID", ex);
        }
        return maiorID;
    }

    /**
     * Insere as informações como um amigo no banco de dados.
     *
     * @param objeto é o objeto de amigos, que carrega as informações, como id,
     * nome, etc..
     * @return True, caso seja possivel inserir o amigo, retornando um erro caso
     * não seja possivel.
     */
    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(IdAmigo,NomeAmigo,TelefoneAmigo,EmailAmigo) VALUES(?,?,?,?)";
        try {
            try (PreparedStatement stmt = ut.getConexao().prepareStatement(sql)) {
                stmt.setInt(1, objeto.getIdAmigo());
                stmt.setString(2, objeto.getNomeAmigo());
                stmt.setString(3, objeto.getTelefoneAmigo());
                stmt.setString(4, objeto.getEmailAmigo());

                stmt.execute();
            }

            return true;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao inserir amigo na Tabela", ex);
        }
        return false;
    }

    /**
     * Deleta um amigo do banco de dados.
     *
     * @param IdAmgio é o id do amigo que será deletado.
     * @return True, caso seja possivel deletar, retornando um erro caso não
     * seja possivel.
     */
    public boolean deleteAmigoBD(int IdAmigo) {
        try {
            try (Statement stmt = ut.getConexao().createStatement()) {
                stmt.executeUpdate("DELETE FROM tb_amigos WHERE IdAmigo = " + IdAmigo);
            }

         } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar amigo na Tabela", ex);
        }
        
        return true;
    }

    /*
    Recupera um amigo do nosso DB, procurando ele pelo Id.
    @param id é o id do amigo a ser  recuperado.
    @return o amigo recuperado com base no Id.
     */
    public Amigo RecuperaAmigoBD(int id) {
        Amigo amigo = new Amigo();
        amigo.setIdAmigo(id);
        try {
            try (Statement smt = ut.getConexao().createStatement()) {
                ResultSet res = smt.executeQuery("select * from tb_amigos where IdAmigo = " + id);
                res.next();
                amigo.setNomeAmigo(res.getString("NomeAmigo"));
                amigo.setTelefoneAmigo(res.getString("TelefoneAmigo"));
                amigo.setEmailAmigo(res.getString("EmailAmigo"));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao achar amigo na Tabela", ex);
        
        }
        return amigo;

    }

    /**
     * Atualiza as informações de um amigo já existente no banco de dados.
     *
     * @param objeto é o objeto do amigo, o qual será atualizado.
     * @return True, caso seja possivel atualizar, retornando um erro caso não
     * seja possivel.
     */
    public boolean updateAmigoBD(Amigo objeto) {

        String sql = "UPDATE tb_amigos set NomeAmigo = ? ,TelefoneAmigo = ? ,EmailAmigo = ?  WHERE IdAmigo = ?";

        try {
            try (PreparedStatement stmt = ut.getConexao().prepareStatement(sql)) {
                stmt.setString(1, objeto.getNomeAmigo());
                stmt.setString(2, objeto.getTelefoneAmigo());
                stmt.setString(3, objeto.getEmailAmigo());
                stmt.setInt(4, objeto.getIdAmigo());

                stmt.execute();
            }

            return true;

         } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar amigo na Tabela", ex);
        }
        return false;
    }
}
