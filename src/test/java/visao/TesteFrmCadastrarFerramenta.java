package visao;

import dao.FerramentaDAO;
import java.awt.Window;
import javax.swing.JDialog;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteFrmCadastrarFerramenta {

    Ferramenta testeferramenta;
    Ferramenta testeferramentafake;

    FrmCadastrarFerramentaFake frmcadastrarferramenta;

    @BeforeEach
    void inicializar() {

        testeferramenta = new Ferramenta(1, "Martelo", "Keoma", 20.5);
        testeferramentafake = new Ferramenta(1, "M", "K", 0.0);

        frmcadastrarferramenta = new FrmCadastrarFerramentaFake();

    }

    @Test
    void testarCadastro() {

        frmcadastrarferramenta.getJTFNomeF().setText(testeferramenta.getNomeFerramentas());
        frmcadastrarferramenta.getJTFCustoF().setText(String.valueOf(testeferramenta.getCustoFerramentas()));
        frmcadastrarferramenta.getJTFMarcaF().setText(testeferramenta.getMarcaFerramentas());

        frmcadastrarferramenta.clicarBotaoCadastrar();

        assertEquals("Ferramenta Cadastrado com Sucesso!", frmcadastrarferramenta.getMensagem());

    }

    @AfterEach
    void finaliza() {
        FerramentaDAO ferramentadao = new FerramentaDAO();
        ferramentadao.DeleteFerramentaDB(1);
    }

    @Test
    void testNomeFInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastrarferramenta.getJTFNomeF().setText(testeferramentafake.getNomeFerramentas());
        frmcadastrarferramenta.getJTFCustoF().setText(String.valueOf(testeferramenta.getCustoFerramentas()));
        frmcadastrarferramenta.getJTFMarcaF().setText(testeferramenta.getMarcaFerramentas());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastrarferramenta.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("Nome deve conter ao menos dois caracteres.", frmcadastrarferramenta.getMensagem());
    }
    
    @Test
    void testCustoFInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastrarferramenta.getJTFNomeF().setText(testeferramenta.getNomeFerramentas());
        frmcadastrarferramenta.getJTFCustoF().setText(String.valueOf(testeferramentafake.getCustoFerramentas()));
        frmcadastrarferramenta.getJTFMarcaF().setText(testeferramenta.getMarcaFerramentas());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastrarferramenta.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("Custo deve ser maior que zero.", frmcadastrarferramenta.getMensagem());
    }
    
    @Test
    void testMarcaFInvalido() {
        // Preenche os campos do formulário via getters do fake
        frmcadastrarferramenta.getJTFNomeF().setText(testeferramenta.getNomeFerramentas());
        frmcadastrarferramenta.getJTFCustoF().setText(String.valueOf(testeferramenta.getCustoFerramentas()));
        frmcadastrarferramenta.getJTFMarcaF().setText(testeferramentafake.getMarcaFerramentas());

        // Fecha a tela
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();

        // Simula o clique no botão cadastrar via método do fake
        frmcadastrarferramenta.clicarBotaoCadastrar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("Marca deve conter dois caracteres.", frmcadastrarferramenta.getMensagem());
    }
    
    @Test
    void testLimparCadastro() {
        // Preenche os campos do formulário via getters do fake
        frmcadastrarferramenta.getJTFNomeF().setText(testeferramenta.getNomeFerramentas());
        frmcadastrarferramenta.getJTFCustoF().setText(String.valueOf(testeferramenta.getCustoFerramentas()));
        frmcadastrarferramenta.getJTFMarcaF().setText(testeferramentafake.getMarcaFerramentas());

        // Simula o clique no botão Limpar via método do fake
        frmcadastrarferramenta.clicarBotaoCancelar();

        // Verifica se foi limpo os campos do formulário
        assertEquals("", frmcadastrarferramenta.getJTFNomeF().getText());
        assertEquals("", frmcadastrarferramenta.getJTFCustoF().getText());
        assertEquals("", frmcadastrarferramenta.getJTFMarcaF().getText());

    }
}
