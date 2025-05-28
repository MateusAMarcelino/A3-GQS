package modelo;


import dao.AmigoDAO;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestAmigo {
    
	Amigo instancia = new Amigo();
        AmigoFake fake = new AmigoFake();
        Amigo amigo = new Amigo(fake);
    
    /**
     * Testa o construtor sem argumentos do Amigo.
     */
    @Test
    public void testAmigo(){
        assertTrue((instancia.getIdAmigo() == 0) && "".equals(instancia.getNomeAmigo()) && "".equals(instancia.getTelefoneAmigo()) && "".equals(instancia.getEmailAmigo()));
    }
    
    /**
     * Testa os getters e setters do Amigo.
     */
    @Test
    public void testIdAmigoInt(){
        instancia.setIdAmigo(1);
        instancia.setNomeAmigo("");
        instancia.setTelefoneAmigo("");
        instancia.setEmailAmigo("");
        assertTrue((instancia.getIdAmigo() == 1) && "".equals(instancia.getNomeAmigo()) && "".equals(instancia.getTelefoneAmigo()) && "".equals(instancia.getEmailAmigo()));
    }
    
    /**
     * Testa a ArrayList do Amigo utilizando a classe do AmigoFake
     */
    @Test
    public void testListaAmigo(){
        Amigo amigo = new Amigo(new AmigoFake());
        ArrayList<Amigo> lista = amigo.ListaAmigo();

        assertNotNull(lista);
        assertEquals(1, lista.size());
        assertEquals("Osmar", lista.get(0).getNomeAmigo());
    }
    
    /**
     * Testa o método insertAmigoBD do Amigo utilizando a classe do AmigoFake
     */
    @Test
    void testInsertAmigoBD() {

        boolean resultado = amigo.insertAmigoBD("Osmar", "123456", "Osmar@gmail.com");

        assertTrue(resultado);
        assertEquals(1, fake.chamaMaiorID);
        assertNotNull(fake.ultimoAmigoInserido);
        assertEquals(2, fake.ultimoAmigoInserido.getIdAmigo());
        assertEquals("Osmar", fake.ultimoAmigoInserido.getNomeAmigo());
    }

    /**
     * Testa o método deleteAmigoBD do Amigo utilizando a classe do AmigoFake
     */
    @Test
    void testDeleteAmigoBD(){
        
        boolean resultado = amigo.deleteAmigoBD(99);
        
        assertTrue(resultado);
        assertTrue(fake.foiChamado);
        assertEquals(99, fake.ultimoIdDeletado);
    }
    
    /**
     * Testa o método updateAmigoBD do Amigo utilizando a classe do AmigoFake
     */
    @Test
    void testUpdateAmigoBD() {

        boolean resultado = amigo.updateAmigoBD(1, "Osmar", "123456", "Osmar@gmail.com");

        assertTrue(resultado);
        assertTrue(fake.metodoChamado);
        assertNotNull(fake.ultimoAmigoAtualizado);
        assertEquals("Osmar", fake.ultimoAmigoAtualizado.getNomeAmigo());
        assertEquals("123456", fake.ultimoAmigoAtualizado.getTelefoneAmigo());
        assertEquals("Osmar@gmail.com", fake.ultimoAmigoAtualizado.getEmailAmigo());
        assertEquals(1, fake.ultimoAmigoAtualizado.getIdAmigo());
    }
    
    /**
     * Testa o método recuperaAmigoDB do Amigo utilizando a classe do AmigoFake
     */
    @Test
    void testRecuperaAmigoDB() {

        Amigo resultado = amigo.RecuperaAmigoDB(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdAmigo());
        assertEquals("Osmar", resultado.getNomeAmigo());
        assertEquals("123456", resultado.getTelefoneAmigo());
        assertEquals("Osmar@gmail.com", resultado.getEmailAmigo());
        assertEquals(1, fake.idRecebido); 
    }
    
    /**
     * Testa o método procuraIndice do Amigo utilizando do método updateAmigoBD
     */
    @Test
    void testProcuraIndice() {
    
        Amigo amigo = new Amigo(1, "Osmar", "123456", "Osmar@gmail.com");
        AmigoDAO.ListaAmigo.clear();
        AmigoDAO.ListaAmigo.add(amigo);

    
       Amigo migo = new Amigo(); 

    
       boolean resultado = migo.updateAmigoBD(1, "Osmarzinho", "7890", "Osmarzinho@gmail.com");

       assertTrue(resultado);
    }
}
