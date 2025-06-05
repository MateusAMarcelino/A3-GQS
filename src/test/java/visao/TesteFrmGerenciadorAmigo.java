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
        amigoteste = new Amigo();
        amigoteste.insertAmigoBD("Osmar", "123456789", "Osmar@gmail.com");
        
        frmGerenciarAmigo = new FrmGerenciadorAmigoFake();
        frmGerenciarAmigo.inicializar();

    }
    
    @Test
    void EditarAmigo(){
        frmGerenciarAmigo.getJTableAmigos().setRowSelectionInterval(0, 0);
        
        frmGerenciarAmigo.getJTFNome().setText("Osmarzinho");
        frmGerenciarAmigo.getJTFTelefone().setText("987654321");
        frmGerenciarAmigo.getJTFEmail().setText("Osmarzinho@gmail.com");
        frmGerenciarAmigo.clicarBotaoJBEditar();
        
        assertEquals("Amigo alterado com sucesso.", frmGerenciarAmigo.getMensagem());
    }
    
    @Test
    void apagarAmigo(){
        frmGerenciarAmigo.getJTableAmigos().setRowSelectionInterval(0, 0);

        
        frmGerenciarAmigo.clicarBotaoJBApagar();
        
        assertEquals("Amigo apagado com sucesso!", frmGerenciarAmigo.getMensagem());
    }
    @AfterEach
    public void tearDown() {
        for (Amigo a : amigoteste.ListaAmigo()) {
            amigoteste.deleteAmigoBD(a.getIdAmigo());
        }
    }
}
