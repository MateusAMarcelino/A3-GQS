package visao;

import modelo.Amigo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import modelo.AmigoFake;

public class TesteFrmGerenciadorAmigo {
    
    AmigoFake fake = new AmigoFake();;
    Amigo amigoteste = new Amigo(fake);
    FrmGerenciadorAmigoFake frmGerenciarAmigo;
    
    @BeforeEach
    public void setUp() {
        amigoteste = new Amigo(1, "Osmar", "123456789", "Osmar@gmail.com");
        
        frmGerenciarAmigo = new FrmGerenciadorAmigoFake();
    }
    
    @Test
    void EditarAmigo(){
        amigoteste.insertAmigoBD("Osmar", "123456789", "Osmar@gmail.com");
        
        frmGerenciarAmigo.inicializar();
        
        Amigo novo = new Amigo(1, "Osmarzinho", "987654321", "Osmarzinho@gmail.com");
        Boolean amigonovo = fake.updateAmigoBD(novo);
        frmGerenciarAmigo.getJTFNome().setText(amigoteste.getNomeAmigo());
        frmGerenciarAmigo.getJTFTelefone().setText(amigoteste.getTelefoneAmigo());
        frmGerenciarAmigo.getJTFEmail().setText(amigoteste.getEmailAmigo());
        frmGerenciarAmigo.clicarBotaoJBEditar();
        
        assertTrue(amigonovo);
        assertEquals("Osmarzinho", fake.ultimoAmigoAtualizado.getNomeAmigo());
        assertEquals("987654321", fake.ultimoAmigoAtualizado.getTelefoneAmigo());
        assertEquals("Osmarzinho@gmail.com", fake.ultimoAmigoAtualizado.getEmailAmigo());
        assertEquals(1, fake.ultimoAmigoAtualizado.getIdAmigo());
    }
    
    @AfterEach
    public void tearDown() {
    }
}
