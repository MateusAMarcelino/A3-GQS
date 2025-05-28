package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Classe de teste para a classe Ferramenta.
 * Verifica se os métodos da classe Ferramenta estão funcionando corretamente.
 */
public class TestFerramenta {

    private Ferramenta ferramenta;

    /**
     * Inicializa uma ferramenta antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        ferramenta = new Ferramenta(1, "Martelo", "Tramontina", 45.90);
    }
    
    /**
     * Testa o construtor da classe Ferramenta.
     */
    @Test
    public void testConstrutor() {
        assertEquals(1, ferramenta.getIdFerramentas());
        assertEquals("Martelo", ferramenta.getNomeFerramentas());
        assertEquals("Tramontina", ferramenta.getMarcaFerramentas());
        assertEquals(45.90, ferramenta.getCustoFerramentas(), 0.01);
    }

}