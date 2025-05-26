package modelo;


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
}
