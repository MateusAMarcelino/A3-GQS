package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

public class FerramentaDAO {

    /**
     * Inicializa o Utilitario para podermos realizar a conecxão com o banco de
     * dados.
     */
    private Utilitario ut = new Utilitario();

    /**
     * Cria um ArrayList para as ferramentas.
     */
    public static ArrayList<Ferramenta> ListaFerramentas = new ArrayList<>();

    /**
     * Coleta as informações das ferramentas do banco de dados e cria um objeto
     * com essas informações no ArrayList da ListaFerramentas.
     *
     * @return A lista de ferramentas após pegar os dados.
     */
    public ArrayList<Ferramenta> getListaFerramentas() {
        ListaFerramentas.clear();
        try {
            Statement smt = ut.getConexao().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_ferramentas");
            while (res.next()) {
                int IdFerramentas = res.getInt("IdFerramentas");
                String NomeFerramentas = res.getString("NomeFerramentas");
                String MarcaFerramentas = res.getString("MarcaFerramentas");
                double CustoFerramentas = res.getDouble("CustoFerramentas");
                Ferramenta objeto = new Ferramenta(IdFerramentas, NomeFerramentas, MarcaFerramentas, CustoFerramentas);

                ListaFerramentas.add(objeto);
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro : " + erro);
        }
        return ListaFerramentas;
    }

    public static void setListaFerramentas(ArrayList<Ferramenta> ListaFerramentas) {
        FerramentaDAO.ListaFerramentas = ListaFerramentas;
    }

    /**
     * Procura o maior ID entre as ferramentas, buscando por todas as
     * ferramentas no banco de dados.
     *
     * @return O maior ID encontrado.
     */
    public int MaiorIdFerramentas() {
        int MaiorIdFerramentas = 0;
        try {
            Statement smt = ut.getConexao().createStatement();
            ResultSet res = smt.executeQuery("select MAX(IdFerramentas)IdFerramentas from tb_ferramentas");
            res.next();
            MaiorIdFerramentas = res.getInt("IdFerramentas");
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro : " + erro);
        }
        return MaiorIdFerramentas;
    }

    /**
     * Insere as informações como uma ferramenta no banco de dados.
     *
     * @param ferramenta é o objeto ferramenta, que carrega as informações, como
     * ID, Nome etc..
     * @return True, caso seja possivel inserir, ou retorna um erro caso não
     * seja possivel.
     */
    public boolean InsertFerramentaDB(Ferramenta ferramenta) {
        String res = "INSERT INTO tb_ferramentas (IdFerramentas, NomeFerramentas, MarcaFerramentas, CustoFerramentas) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement smt = ut.getConexao().prepareStatement(res);
            smt.setInt(1, ferramenta.getIdFerramentas());
            smt.setString(2, ferramenta.getNomeFerramentas());
            smt.setString(3, ferramenta.getMarcaFerramentas());
            smt.setDouble(4, ferramenta.getCustoFerramentas());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            throw new RuntimeException(erro);
        }
    }

    /*
    Recupera uma ferramenta do nosso DB, procurando ele pelo Id da ferramenta.
    @param IdFerramentas é o id da ferramenta a ser recuperada.
    @return retorna a ferramenta recuperada com base no IdFerramentas.
     */
    public Ferramenta RecuperaFerramentaDB(int IdFerramentas) {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setIdFerramentas(IdFerramentas);
        try {
            Statement smt = ut.getConexao().createStatement();
            ResultSet res = smt.executeQuery("Select * from tb_ferramentas where IdFerramentas = " + IdFerramentas);
            while (res.next()) {
                String NomeFerramentas = res.getString("NomeFerramentas");
                String MarcaFerramentas = res.getString("MarcaFerramentas");
                double CustoFerramentas = res.getDouble("CustoFerramentas");
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro : " + erro);
        }
        return ferramenta;
    }

    /**
     * Atualiza as informações de uma ferramenta já existente no banco de dados.
     *
     * @param ferramenta é o objeto da ferramenta, o qual será atualizado.
     * @return True, caso seja possivel atualizar, ou retorna um erro caso não
     * seja possivel.
     */
    public boolean UpdateFerramentaDB(Ferramenta ferramenta) {
        String res = "UPDATE tb_ferramentas SET NomeFerramentas=?, MarcaFerramentas=?, CustoFerramentas=? WHERE IdFerramentas=?";
        try {
            PreparedStatement smt = ut.getConexao().prepareStatement(res);
            smt.setString(1, ferramenta.getNomeFerramentas());
            smt.setString(2, ferramenta.getMarcaFerramentas());
            smt.setDouble(3, ferramenta.getCustoFerramentas());
            smt.setInt(4, ferramenta.getIdFerramentas());
            smt.executeUpdate();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Deleta uma ferramenta do banco de dados.
     *
     * @param IdFerramentas É o ID da ferramenta que deve ser deletada.
     * @return True, caso seja possivel deletar, ou retorna um erro caso não
     * seja possivel.
     */
    public boolean DeleteFerramentaDB(int IdFerramentas) {
        try {
            Statement smt = ut.getConexao().createStatement();
            int res = smt.executeUpdate(("delete from tb_ferramentas where IdFerramentas=" + IdFerramentas));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro : " + erro);
            throw new RuntimeException(erro);
        }
        return true;
    }

    public static double CalcularSoma(ArrayList<Ferramenta> custo) {
        double soma = 0.0;
        for (Ferramenta ferramenta : custo) {
            soma += ferramenta.getCustoFerramentas();
        }
        return soma;
    }

}
