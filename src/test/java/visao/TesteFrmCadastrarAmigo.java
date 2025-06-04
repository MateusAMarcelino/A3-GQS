package visao;

import dao.AmigoDAO;
import java.awt.Window;
import javax.swing.JDialog;
import modelo.Amigo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author guiho
 */
class TesteFrmCadastrarAmigo {

    Amigo testeamigo;
    Amigo testeamigofake;

    FrmCadastrarAmigoFake frmcadastraramigo;

    @BeforeEach
    void inicializar() {

        testeamigo = new Amigo(1, "Marlon", "123456789", "testeemail@gmail.com");
        testeamigofake = new Amigo(1, "M", "1289", "testeemai");

        frmcadastraramigo = new FrmCadastrarAmigoFake();
    }

    @Test
    void testarCadastro() {

        frmcadastraramigo.getJTFNome().setText(testeamigo.getNomeAmigo());
        frmcadastraramigo.getJTFTelefone().setText(testeamigo.getTelefoneAmigo());
        frmcadastraramigo.getJTFEmail().setText(testeamigo.getEmailAmigo());

        frmcadastraramigo.clicarBotaoCadastrar();

        assertEquals("Amigo inserido com sucesso!", frmcadastraramigo.getMensagem());
    }

    @Test
    void testCadastroAmigoInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastraramigo.getJTFNome().setText(testeamigofake.getNomeAmigo());
        frmcadastraramigo.getJTFTelefone().setText(testeamigo.getTelefoneAmigo());
        frmcadastraramigo.getJTFEmail().setText(testeamigo.getEmailAmigo());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastraramigo.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("O nome deve possuir ao menos 2 caracteres", frmcadastraramigo.getMensagem());
    }

    @Test
    void testCadastroTefoneInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastraramigo.getJTFNome().setText(testeamigo.getNomeAmigo());
        frmcadastraramigo.getJTFTelefone().setText(testeamigofake.getTelefoneAmigo());
        frmcadastraramigo.getJTFEmail().setText(testeamigo.getEmailAmigo());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastraramigo.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("O número de telefone deve possuir exatamente 9 digitos", frmcadastraramigo.getMensagem());

    }

    @Test
    void testCadastroEmailInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastraramigo.getJTFNome().setText(testeamigo.getNomeAmigo());
        frmcadastraramigo.getJTFTelefone().setText(testeamigo.getTelefoneAmigo());
        frmcadastraramigo.getJTFEmail().setText(testeamigofake.getEmailAmigo());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastraramigo.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("O email deve conter no mínimo 11 dígitos, como: X@gmail.com", frmcadastraramigo.getMensagem());

    }

    @Test
    void testLimparCadastro() {
        // Preenche os campos do formulário via getters do fake
        frmcadastraramigo.getJTFNome().setText(testeamigo.getNomeAmigo());
        frmcadastraramigo.getJTFTelefone().setText(testeamigo.getTelefoneAmigo());
        frmcadastraramigo.getJTFEmail().setText(testeamigo.getEmailAmigo());

        // Simula o clique no botão Limpar via método do fake
        frmcadastraramigo.clicarBotaoCancelar();

        // Verifica se foi limpo os campos do formulário
        assertEquals("", frmcadastraramigo.getJTFNome().getText());
        assertEquals("", frmcadastraramigo.getJTFTelefone().getText());
        assertEquals("", frmcadastraramigo.getJTFEmail().getText());

    }

    @AfterEach
    void finaliza() {
        AmigoDAO amigodao = new AmigoDAO();
        amigodao.deleteAmigoBD(1);
    }
}
