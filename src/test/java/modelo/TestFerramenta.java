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
    
 /**
     * Testa os getters e setters da ferramenta.
     */
    @Test
    public void testSettersAndGetters() {
        ferramenta.setIdFerramentas(2);
        ferramenta.setNomeFerramentas("Chave de Fenda");
        ferramenta.setMarcaFerramentas("Vonder");
        ferramenta.setCustoFerramenta(25.50);

        assertEquals(2, ferramenta.getIdFerramentas());
        assertEquals("Chave de Fenda", ferramenta.getNomeFerramentas());
        assertEquals("Vonder", ferramenta.getMarcaFerramentas());
        assertEquals(25.50, ferramenta.getCustoFerramentas(), 0.01);
    }

    /**
     * Testa se a ferramenta é marcada como disponível quando não está em empréstimo.
     * Este teste assume que não há empréstimos ativos no momento.
     */
    @Test
    public void testDisponibilidadeFerramentaSemEmprestimo() {
        // O método depende do EmpréstimoDAO
        assertTrue(ferramenta.getDisponibilidadeFerramenta(1));
    }

    /**
     * Testa se a ferramenta é coolocada corretamente no banco de dados.
     * Este teste depende de uma implementação do DAO (depois olhar o DAO).
     */
    @Test
    public void testColocaFerramentaDB() {
        boolean colocado = ferramenta.InsertFerramentaDB("Alicate", "Bosch", 29.99);
        assertTrue(colocado);
    }
}