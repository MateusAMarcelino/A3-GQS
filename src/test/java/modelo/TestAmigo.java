package modelo;

import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.Utilitario;
import java.sql.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestAmigo {

    Amigo instancia = new Amigo();
    AmigoFake fake = new AmigoFake();
    Amigo amigo = new Amigo(fake);

    /**
     * Testa o construtor sem argumentos do Amigo.
     */
    @Test
    void testAmigo() {
        assertTrue((instancia.getIdAmigo() == 0) && "".equals(instancia.getNomeAmigo()) && "".equals(instancia.getTelefoneAmigo()) && "".equals(instancia.getEmailAmigo()));
    }

    /**
     * Testa os getters e setters do Amigo.
     */
    @Test
    void testIdAmigoInt() {
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
    void testListaAmigo() {
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
    void testDeleteAmigoBD() {

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
    void testRecuperaAmigoBD() {

        Amigo resultado = amigo.RecuperaAmigoDB(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdAmigo());
        assertEquals("Osmar", resultado.getNomeAmigo());
        assertEquals("123456", resultado.getTelefoneAmigo());
        assertEquals("Osmar@gmail.com", resultado.getEmailAmigo());
        assertEquals(1, fake.idRecebido);
    }

    /**
     * Testa o método procuraIndice do Amigo
     */
    @Test
    void testProcuraIndice_Encontrado() {
        Amigo amigo = new Amigo(1, "Osmar", "123456", "Osmar@gmail.com");
        ArrayList<Amigo> lista = new ArrayList<>();
        lista.add(amigo);
        AmigoDAO.ListaAmigo = lista;

        Amigo migo = new Amigo();
        int indiceEncontrado = migo.procuraIndice(1);
        int indiceNaoEncontrado = migo.procuraIndice(99);

        assertEquals(0, indiceEncontrado);
        assertEquals(-1, indiceNaoEncontrado);
    }

    /**
     * Testa o método maiorId
     */
    @Test
    void testMaiorID() {
        int maiorId = instancia.MaiorID();

        assertTrue(maiorId >= 0);
    }

    /**
     * Testa o método possuiEmprestimoAtivo inserindo um empréstimo ao banco de
     * dados e o deletando no final
     */
    @Test
    void testPossuiEmprestimoAtivo() {
        Amigo amigo = new Amigo(2, "Osmar", "123456", "Osmar@gmail.com");
        Emprestimo emp = new Emprestimo(1000, 2, 1, "21-01-2025", null);
        EmprestimoDAO dao = new EmprestimoDAO();

        //Insere o empréstimo criado ao banco de dados
        dao.insertEmprestimoBD(emp);

        boolean resultado = amigo.possuiEmprestimoAtivo(2);

        assertTrue(resultado);

    }

    @Test
    void testQuantidadeEmprestimo() {
        Emprestimo emp = new Emprestimo();
        emp.insertEmprestimoBD(1, 1, "05-05-2005");
        int quantidadeEsperada = 1;
        int quantidadeRecebida = amigo.quantidadeEmprestimo(1);
        assertEquals(quantidadeEsperada, quantidadeRecebida);
        emp.deleteEmprestimoBD(1);
    }

    @AfterEach
    void limpar() {
        EmprestimoDAO dao = new EmprestimoDAO();
        dao.deleteEmprestimoBD(1000);
        dao.deleteEmprestimoBD(1);
    }

}
