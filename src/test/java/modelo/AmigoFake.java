package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Classe que cria um amigo falso para ser utilizado nos testes.
 * @author lorenzoeid
 */
public class AmigoFake extends AmigoDAO {
    
    /**
     * Sobrescreve a ArrayList para o teste
     */
    @Override
    public ArrayList<Amigo> getListaAmigo(){
        ArrayList<Amigo> lista = new ArrayList<>();
        lista.add(new Amigo(1, "Osmar", "1234", "Osmar@gmail.com"));
        return lista;
    }
    
    /**
     * Sobrescreve o método maiorIDAmigo para o teste
     */
    public int chamaMaiorID = 0;
    public Amigo ultimoAmigoInserido = null;

    @Override
    public int maiorIDAmigo() {
        chamaMaiorID++;
        return 1;
    }

    /**
     * Sobrescreve o método insertAmigoBD para o teste
     */
    @Override
    public boolean insertAmigoBD(Amigo amigo) {
        this.ultimoAmigoInserido = amigo;
        return true;
    }
    
    /**
     * Sobrescreve o método deleteAmigoBD para o teste
     */
    public int ultimoIdDeletado = -1;
    public boolean foiChamado = false;

    @Override
    public boolean deleteAmigoBD(int IdAmigo) {
        ultimoIdDeletado = IdAmigo;
        foiChamado = true;
        return true;
    }
    
    /**
     * Sobrescreve o método updateAmigoBD para o teste
     */
    public Amigo ultimoAmigoAtualizado;
    public boolean metodoChamado = false;
    
    @Override
    public boolean updateAmigoBD(Amigo amigo) {
        this.ultimoAmigoAtualizado = amigo;
        this.metodoChamado = true;
        return true;
    }
    
    /**
     * Sobrescreve o método recuperaAmigoDB
     */
    public int idRecebido;
    
    @Override
    public Amigo RecuperaAmigoDB(int id) {
        this.idRecebido = id;
        return new Amigo(id, "Osmar", "123456", "Osmar@gmail.com");
    }
}
