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
    
    /**
     * Testa o construtor sem argumentos do Amigo.
     */
    @Test
    public void testAmigo(){
        assertTrue((instancia.getIdAmigo() == 0) && "".equals(instancia.getNomeAmigo()) && "".equals(instancia.getTelefoneAmigo()) && "".equals(instancia.getEmailAmigo()));
    }
    
    @Test
    public void testIdAmigoInt(){
        instancia.setIdAmigo(1);
        instancia.setNomeAmigo("");
        instancia.setTelefoneAmigo("");
        instancia.setEmailAmigo("");
        assertTrue((instancia.getIdAmigo() == 1) && "".equals(instancia.getNomeAmigo()) && "".equals(instancia.getTelefoneAmigo()) && "".equals(instancia.getEmailAmigo()));
    }
    
    @Test
    public void testListaAmigo(){
        Amigo amigo = new Amigo(new AmigoFake());
        ArrayList<Amigo> lista = amigo.ListaAmigo();

        assertNotNull(lista);
        assertEquals(1, lista.size());
        assertEquals("Osmar", lista.get(0).getNomeAmigo());
    }
    
    @Test
    void testInsertAmigoBD() {
        AmigoFake fake = new AmigoFake();
        Amigo amigo = new Amigo(fake);

        boolean resultado = amigo.insertAmigoBD("Osmar", "123456", "Osmar@gmail.com");

        assertTrue(resultado);
        assertEquals(1, fake.chamaMaiorID);
        assertNotNull(fake.ultimoAmigoInserido);
        assertEquals(2, fake.ultimoAmigoInserido.getIdAmigo());
        assertEquals("Osmar", fake.ultimoAmigoInserido.getNomeAmigo());
    }

    @Test
    void testDeleteAmigoBD(){
        AmigoFake fake = new AmigoFake();
        Amigo amigo = new Amigo(fake);
        
        boolean resultado = amigo.deleteAmigoBD(99);
        
        assertTrue(resultado);
        assertTrue(fake.foiChamado);
        assertEquals(99, fake.ultimoIdDeletado);
    }
}
