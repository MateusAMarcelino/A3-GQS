package dao;

import modelo.Sobre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SobreDAOTest {

    @Test
    public void testGetInformacoesSobre() {
        SobreDAO dao = new SobreDAO();

        Sobre info = dao.getInformacoesSobre();

        assertNotNull(info);
        assertEquals("Sistema de Empréstimos", info.getNome());
        assertEquals("2.0", info.getVersao());
        assertEquals("Desenvolvido por Matheus, Guilherme, Pedro e Lorenzo", info.getAutores());
        assertEquals("Sistema desenvolvido para gerenciar cadastros e empréstimos de ferramentas.", info.getDescricao());
    }
}
