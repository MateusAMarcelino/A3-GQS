package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Classe de teste para a classe Ferramenta. Verifica se os métodos da classe
 * Ferramenta estão funcionando corretamente.
 */
class TestFerramenta {

    private Ferramenta ferramenta;

    /**
     * Inicializa uma ferramenta antes de cada teste.
     */
    @BeforeEach
    void setUp() {
        ferramenta = new Ferramenta(1, "Martelo", "Tramontina", 45.90);
    }

    /**
     * Testa o construtor da classe Ferramenta.
     */
    @Test
    void testConstrutor() {
        assertEquals(1, ferramenta.getIdFerramentas());
        assertEquals("Martelo", ferramenta.getNomeFerramentas());
        assertEquals("Tramontina", ferramenta.getMarcaFerramentas());
        assertEquals(45.90, ferramenta.getCustoFerramentas(), 0.01);
    }

    /**
     * Testa os getters e setters da ferramenta.
     */
    @Test
    void testSettersAndGetters() {
        ferramenta.setIdFerramentas(2);
        ferramenta.setNomeFerramentas("Chave de Fenda");
        ferramenta.setMarcaFerramentas("Vonder");
        ferramenta.setCustoFerramenta(25.50);

        assertEquals(2, ferramenta.getIdFerramentas());
        assertEquals("Chave de Fenda", ferramenta.getNomeFerramentas());
        assertEquals("Vonder", ferramenta.getMarcaFerramentas());
        assertEquals(25.50, ferramenta.getCustoFerramentas(), 0.01);
    }

    @Test
    void TestGetDisponibilidade() {
        Emprestimo emp = new Emprestimo();
        emp.insertEmprestimoBD(1, 1, "05-05-2005");
        boolean disponivelEsperado = false;
        boolean DisponivelRecebido = ferramenta.getDisponibilidadeFerramenta(1);
        assertEquals(disponivelEsperado, DisponivelRecebido);
        emp.deleteEmprestimoBD(1);
    }

}
