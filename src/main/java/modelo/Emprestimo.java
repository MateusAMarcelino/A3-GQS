package modelo;

import dao.EmprestimoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Classe do empréstimo, com IdEmprestimo, IdAmigo, IdFerramentas, dataEmp.
 */
public class Emprestimo {

    private int IdEmprestimo;
    private int IdAmigo;
    private int IdFerramentas;
    private String dataEmp;
    private String dataDev;
    private EmprestimoDAO dao;

/**
* Construtor para a classe Emprestimo, inicializa o empréstimo com IdAmigo do amigo, id da ferramenta e data do emprestimo.
*/
    public Emprestimo() {
        this(0, 0, 0, "", "");
    }

/**
* @param IdEmprestimo; Id do empréstimo feito.
* @param IdAmigo; Nome do amigo fazendo o empréstimo.
* @param IdFerramentas; Id da ferramenta emprestada.
* @param dataEmp; Data do empréstimo
*/
    public Emprestimo(int IdEmprestimo, int IdAmigo, int IdFerramentas, String dataEmp, String dataDev) {
        this.IdEmprestimo = IdEmprestimo;
        this.IdAmigo = IdAmigo;
        this.IdFerramentas = IdFerramentas;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
        this.dao = new EmprestimoDAO();
        new Ferramenta();
    }

    
/**
* Obtém o IdAmigo do amigo.
* 
* @return O IdAmigo do amigo.
*/
    public int getIdAmigo() {
        return IdAmigo;
    }

/**
* Define o IdAmigo do amigo.
* 
* @param IdAmigo ; O IdAmigo a ser definido.
    */
    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

    /**
* Obtém o IdEmprestimo do emprestimo.
* 
* @return O IdEmprestimo do emprestimo.
*/
    public int getIdEmprestimo() {
        return IdEmprestimo;
    }

/**
* Define o IdEmprestimo do emprestimo.
* 
* @param IdEmprestimo ; O IdEmprestimo a ser definido.
*/
    public void setIdEmprestimo(int IdEmprestimo) {
        this.IdEmprestimo = IdEmprestimo;
    }

/**
* Obtém a Data do emprestimo.
* 
* @return a Data do emprestimo.
*/
    public String getDataEmp() {
        return dataEmp;
    }

/**
* Define a Data do emprestimo.
* 
* @param dataEmp ; A Data do emprestimo a ser definida.
*/
    public void setDataEmp(String dataEmp) {
        this.dataEmp = dataEmp;
    }
    
/**
* Obtém a Data de devolução.
* 
* @return a Data de devolução.
*/

    public String getDataDev() {
        return dataDev;
    }

/**
* Define a Data de devolução do emprestimo.
* 
* @param dataDev ; A Data de devolução a ser definida.
*/    
    public void setDataDev(String dataDev) {
        this.dataDev = dataDev;
    }

    
/**
* Obtém o IdFerramentas do emprestimo.
* 
* @return o IdFerramentas do emprestimo.
*/
    public int getIdFerramentas() {
        return IdFerramentas;
    }
    
    
/**
* Define o IdFerramentas, da ferramenta envolvida no emprestimo.
* 
* @param IdFerramentas ; o IdFerramenta a ser definido.
*/
    public void setIdFerramentas(int IdFerramentas) {
        this.IdFerramentas = IdFerramentas;
    }
    
    
/**
* Pega todos os emprestimos na ListaEmprestimo.
* @return Todos os emprestimos que estiverem na lista.
*/
    public ArrayList<Emprestimo> ListaEmprestimo() {
        return dao.getListaEmprestimo();
    }
    
    
/**
* Cadastra um novo emprestimo na lista.
* 
* @param IdAmigo : O id do amigo que está pegando o emprestimo.
* @param IdFerramentas : O Id da ferramenta que está sendo emprestada.
* @param dataEmp : A data em que o emprestimo aconteceu.
*/
    public boolean insertEmprestimoBD(int IdAmigo, int IdFerramentas, String dataEmp) {
        int maiorID = dao.maiorIDEmprestimo() + 1;
        Emprestimo emprestimo = new Emprestimo(maiorID, IdAmigo, IdFerramentas, dataEmp, null);
        dao.insertEmprestimoBD(emprestimo);
        return true;
    }

    
/**
* Busca O maior ID existente no banco de dados.
* 
* @return O maior ID encontrado no banco de dados.
*/
    public int maiorID() {
        return dao.maiorIDEmprestimo();
    }
/**
 * Deleta um emprestimo do banco de dados.
 * @param IdEmprestimo : Id do emprestimo a ser deletado.
 * @return true : se o amigo foi deletado com sucesso, false caso contrário.
 */
    public boolean deleteEmprestimoBD(int IdEmprestimo) {
        dao.deleteEmprestimoBD(IdEmprestimo);
        return true;
    }

/**
 * Atualiza um emprestimo no banco de dados.
 * @param idEmprestimo : O id do emprestimo a ser atualizado.
 * @param idAmigo : O id do amigo que vai ter seu emprestimo atualizado.
 * @param idFerramenta : O id da ferramenta que está envolvida no emprestimo que vai ser atualizado.
 * @param dataEmprestimo : A data de emprestimo do emprestimo que vai ser atualizado.
 * @param dataDevolucao : A data de devolução do emprestimo que vai ser atualizado.
 * @return 
 */
  public boolean updateEmprestimoDB(int idEmprestimo, int idAmigo, int idFerramenta, String dataEmprestimo, String dataDevolucao) {
        Emprestimo emprestimo = new Emprestimo(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao);
        dao.updateEmprestimoBD(emprestimo);
        return true;
    }
/**
 * Recupera um emprestimo do Banco de dados, baseado no ID dele.
 * @param IdEmprestimo : o Id do emprestimo que vai ser recuperado.
 * @return O emprestimo, baseado no Id.
 */
    public Emprestimo RecuperaEmprestimoDB(int IdEmprestimo) {
        return dao.RecuperaEmprestimoDB(IdEmprestimo);
    }

/**
* Procura o INDICE de objeto da ListaEmprestimo que contem o ID enviado.
* 
* @param IdEmprestimo ; O ID do emprestimo.
* @return O objeto Emprestimo com os dados carregados, ou nada se não encontrado.
*/   
  public int procuraIndice(int IdEmprestimo) {
    int indice = -1;
    for (int i = 0; i < EmprestimoDAO.ListaEmprestimo.size(); i++) {
        if (EmprestimoDAO.ListaEmprestimo.get(i).getIdEmprestimo() == IdEmprestimo) {
            indice = i;
        }
    }
    return indice;
}

/**
 * ArrayList para os emprestimos ativos, pegando a data de emprestimo e verificando com a data atual para ver se está ou não ativo.
 * @return a ListaDeEmprestimoAtivo, com todas as informações já verificadas.
 */
    public ArrayList<Emprestimo> getListaEmprestimoAtivo() {
        ArrayList<Emprestimo> listaEmprestimoAtivo = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<Emprestimo> listaEmprestimo = this.ListaEmprestimo();

            for (Emprestimo emprestimo : listaEmprestimo) {
                if (emprestimo.getDataDev() == null) {
                    listaEmprestimoAtivo.add(emprestimo);
                } else {
                    java.util.Date dataDevolucaoUtil = sdf.parse(emprestimo.getDataDev());
                    java.sql.Date dataDevolucao = new java.sql.Date(dataDevolucaoUtil.getTime());

                    java.util.Date dataAtualUtil = new java.util.Date();
                    java.sql.Date dataAtual = new java.sql.Date(dataAtualUtil.getTime());

                    if (dataAtual.compareTo(dataDevolucao) < 0) {
                        listaEmprestimoAtivo.add(emprestimo);
                    }
                }
            }
        } catch (ParseException erro) {
            erro.printStackTrace(); // Log da exceção para depuração
        }
        return listaEmprestimoAtivo;
    }

/**
 * Verifica se um emprestimo está ativo ou não, baseado no Id do emprestimo.
 * @param idEmprestimo : O id do emprestimo que vai ser verificado.
 * @return "Sim" para caso esteja ativo ou "Não" para caso não esteja ativo.
 */
    public String emprestimoAtivo(int idEmprestimo) {
        String ativo = "Não";
        Emprestimo emp = new Emprestimo();
        ArrayList<Emprestimo> listaEmprestimoAtivo = emp.getListaEmprestimoAtivo();
        for (Emprestimo emprestimo : listaEmprestimoAtivo) {
            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
                ativo = "Sim";
            }
        }
        return ativo;
    }
}