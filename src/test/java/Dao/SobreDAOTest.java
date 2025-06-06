/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Mateus
 **/


import dao.SobreDAO;
import modelo.Sobre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SobreDAOTest {

    @Test
    public void testGetInformacoesSobre() {
        // Como o construtor padrão lança exceção, usamos o construtor com parâmetros
        SobreDAO sobreDAO = new SobreDAO("dummy", "dummy", "dummy", "dummy");
        
        // Obtém as informações do sistema
        Sobre informacoes = sobreDAO.getInformacoesSobre();
        
        // Verifica se o objeto retornado não é nulo
        assertNotNull(informacoes, "O objeto Sobre não deveria ser nulo");
        
        // Verifica cada um dos campos retornados
        assertEquals("Sistema de Empréstimos", informacoes.getSistema(),
                "O nome do sistema não corresponde ao esperado");
        
        assertEquals("2.0", informacoes.getVersao(),
                "A versão do sistema não corresponde ao esperado");
        
        assertEquals("Desenvolvido por Mateus, Guilherme, Pedro e Lorenzo", 
                informacoes.getDesenvolvedor(),
                "Os desenvolvedores não correspondem ao esperado");
        
        assertEquals("Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas.",
                informacoes.getDescricao(),
                "A descrição do sistema não corresponde ao esperado");
    }

    @Test
    public void testConstrutorPadraoLancaExcecao() {
        // Testa se o construtor padrão lança a exceção esperada
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            new SobreDAO();
        }, "Deveria lançar UnsupportedOperationException");
        
        assertEquals("Not supported yet.", exception.getMessage(),
                "A mensagem da exceção não corresponde ao esperado");
    }
}