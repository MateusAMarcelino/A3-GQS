package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;


/**
 * Classe do Amigo com ; NomeAmigo, IdAmigo, EmailAmigo, TelefoneAmigo.
 * 
 */
public class Amigo {

    private String NomeAmigo;
    private int IdAmigo;
    private String EmailAmigo;
    private String TelefoneAmigo;
    AmigoDAO dao;


/**
 * Construtor para a classe Amigo, incializa o amigo com NomeAmigo e EmailAmigo sendo strings vazias, IdAmigo e TelefoneAmigo são iniciados com o valor 0.
 *  */
    public Amigo() {
        
        this(0, "", "", "");
    }

    
   /**
    * 
    * @param IdAmigo
    * @param NomeAmigo
    * @param TelefoneAmigo
    * @param EmailAmigo
    * 
    * Inicializa todos com os valores iniciais acima, que são :
    * IdAmigo = 0
    * NomeAmigo = "" ( vazio )
    * TelefoneAmigo = 0
    * EmailAmigo = "" ( vazio )
    */ 
    public Amigo(int IdAmigo, String NomeAmigo, String TelefoneAmigo, String EmailAmigo) {
        this.IdAmigo = IdAmigo;
        this.NomeAmigo = NomeAmigo;
        this.TelefoneAmigo = TelefoneAmigo;
        this.EmailAmigo = EmailAmigo;
        this.dao = new AmigoDAO();
    }
    
    public Amigo(AmigoDAO dao) {
        this.dao = dao;
    }

/**
* Obtém o NomeAmigo do amigo.
* 
* @return O NomeAmigo do amigo.
*/
    public String getNomeAmigo() {
        return NomeAmigo;
    }

/**
* Define o NomeAmigo do amigo.
* 
* @param NomeAmigo ; O NomeAmigo a ser definido.
*/
    public void setNomeAmigo(String NomeAmigo) {
        this.NomeAmigo = NomeAmigo;
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
* Obtém o EmailAmigo do amigo.
* 
* @return O EmailAmigo do amigo.
*/
    public String getEmailAmigo() {
        return EmailAmigo;
    }

/**
* Define o EmailAmigo do amigo.
* 
* @param EmailAmigo ; O EmailAmigo a ser definido.
*/
    public void setEmailAmigo(String EmailAmigo) {
        this.EmailAmigo = EmailAmigo;
    }

/**
* Obtém o número de TelefoneAmigo do amigo.
* 
* @return O número de TelefoneAmigo do amigo.
*/
    public String getTelefoneAmigo() {
        return TelefoneAmigo;
    }

/**
* Define o número de TelefoneAmigo do amigo.
* 
* @param TelefoneAmigo ; O número de TelefoneAmigo a ser definido.
*/
    public void setTelefoneAmigo(String TelefoneAmigo) {
        this.TelefoneAmigo = TelefoneAmigo;
    }

/**
* Retorna uma lista de todos os amigos.
* 
* @return Uma lista de objetos Amigo.
*/
    public ArrayList<Amigo> ListaAmigo() {
        return dao.getListaAmigo();
    }

/**
* Cadastra um novo amigo.
* 
* @param Nome ; O NomeAmigo do amigo.
* @param TelefoneAmigo ; O número de TelefoneAmigo do amigo.
* @param EmailAmigo ; O EmailAmigo do amigo.
* @return true se o amigo foi inserido com sucesso, false caso contrário.
*/
    public boolean insertAmigoBD(String Nome, String TelefoneAmigo, String EmailAmigo) {
        int MaiorID = dao.maiorIDAmigo() + 1;
        Amigo objeto = new Amigo(MaiorID, Nome, TelefoneAmigo, EmailAmigo);
        dao.insertAmigoBD(objeto);
        return true;
    }

/**
* Deleta um amigo pelo ID.
* 
* @param IdAmigo ; O ID do amigo a ser deletado.
* @return true se o amigo foi deletado com sucesso, false caso contrário.
*/
    public boolean deleteAmigoBD(int IdAmigo) {
        dao.deleteAmigoBD(IdAmigo);
        return true;
    }

/**
* Atualiza os dados de um amigo no banco de dados.
* 
* @param IdAmigo ; O ID do amigo.
* @param Nome ; O NomeAmigo do amigo.
* @param TelefoneAmigo ; O número de TelefoneAmigo do amigo.
* @param EmailAmigo ; O EmailAmigo do amigo.
* @return true se os dados do amigo foram atualizados com sucesso, false caso contrário.
*/
    public boolean updateAmigoBD(int IdAmigo, String Nome, String TelefoneAmigo, String EmailAmigo) {
        Amigo amigo = new Amigo(IdAmigo, Nome, TelefoneAmigo, EmailAmigo);
        dao.updateAmigoBD(amigo);
        return true;
    }
    
    /**
     * Recupera o amigo baseado no Id dele.  
     * @param IdAmigo o Id do amigo a ser recuperado do banco de dados.
     * @return o amigo recuperado de acordo com o Id.
     */

    
    public Amigo RecuperaAmigoDB(int IdAmigo) {
        return dao.RecuperaAmigoBD(IdAmigo);
    }
 
/**
* Procura o INDICE de objeto da ListaAmigo que contem o ID enviado.
* 
* @param IdAmigo ; O ID do amigo.
* @return O objeto Amigo com os dados carregados, ou nada se não encontrado.
*/
    public int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AmigoDAO.ListaAmigo.size(); i++) {
            if (AmigoDAO.ListaAmigo.get(i).getIdAmigo() == id) {
                indice = i;
            }
        }
        return indice;
    }

/**
* Retorna o maior ID existente na base de dados.
* 
* @return O maior ID.
*/
    public int MaiorID() {
        return dao.maiorIDAmigo();

    }
  
    public boolean possuiEmprestimoAtivo(int IdAmigo) {
        boolean emprestimoAtivo = false;
        
        Emprestimo emp = new Emprestimo();
        
        ArrayList<Emprestimo> ListaEmprestimo = emp.getListaEmprestimoAtivo();
        
        for (int i = 0; i < ListaEmprestimo.size(); i++) {
            
            if(ListaEmprestimo.get(i).getIdAmigo() == IdAmigo) {
                emprestimoAtivo = true;
            }
        }
        return emprestimoAtivo;
    } 
    
    
    /**
     * Verifica a quantidade de emprestimos, para verificar qual amigo fez mais emprestimos.
     * @param IdAmigo, é o Id que é buscado para fazer essa comparação.
     * @return a som, que é a soma dos emprestimos de um amigo por Id.
     */
    public int quantidadeEmprestimo(int IdAmigo) {
        int som = 0;
        Emprestimo emp = new Emprestimo();
        ArrayList<Emprestimo> ListaEmprestimo = emp.ListaEmprestimo();
        for (int i = 0; i < ListaEmprestimo.size(); i++) {
            if (ListaEmprestimo.get(i).getIdAmigo() == IdAmigo) {
                som++;
            }
        }
        return som;
    }
}
