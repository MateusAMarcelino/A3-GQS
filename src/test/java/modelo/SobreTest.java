/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mateus
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SobreTest {

    @Test
    public void testConstrutorEGetters() {
        // Dados de teste
        String sistema = "Biblioteca Digital";
        String versao = "1.5";
        String desenvolvedor = "Equipe Dev";
        String descricao = "Sistema de gerenciamento de biblioteca";

        // Cria objeto Sobre
        Sobre sobre = new Sobre(sistema, versao, desenvolvedor, descricao);

        // Verifica se os getters retornam os valores corretos
        assertEquals(sistema, sobre.getSistema(), "Nome do sistema incorreto");
        assertEquals(versao, sobre.getVersao(), "Versão do sistema incorreta");
        assertEquals(desenvolvedor, sobre.getDesenvolvedor(), "Desenvolvedor incorreto");
        assertEquals(descricao, sobre.getDescricao(), "Descrição incorreta");
    }

    @Test
    public void testConstrutorComValoresNulos() {
        // Testa comportamento com valores nulos (deve permitir, a menos que validado)
        Sobre sobre = new Sobre(null, null, null, null);

        assertNull(sobre.getSistema(), "Sistema deveria ser nulo");
        assertNull(sobre.getVersao(), "Versão deveria ser nulo");
        assertNull(sobre.getDesenvolvedor(), "Desenvolvedor deveria ser nulo");
        assertNull(sobre.getDescricao(), "Descrição deveria ser nulo");
    }

    @Test
    public void testConstrutorComValoresVazios() {
        // Testa comportamento com strings vazias
        Sobre sobre = new Sobre("", "", "", "");

        assertEquals("", sobre.getSistema(), "Sistema deveria ser vazio");
        assertEquals("", sobre.getVersao(), "Versão deveria ser vazia");
        assertEquals("", sobre.getDesenvolvedor(), "Desenvolvedor deveria ser vazio");
        assertEquals("", sobre.getDescricao(), "Descrição deveria ser vazia");
    }

    @Test
    public void testImutabilidade() {
        // Testa se a classe é realmente imutável (como sugerem os campos final)
        Sobre sobre = new Sobre("Teste", "1.0", "Dev", "Desc");

        // Se os campos não fossem final, poderíamos tentar modificá-los aqui
        // Como são final, apenas verificamos os valores iniciais
        assertEquals("Teste", sobre.getSistema());
    }
}

