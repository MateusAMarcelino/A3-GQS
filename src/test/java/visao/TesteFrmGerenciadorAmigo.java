package visao;

import dao.AmigoDAO;
import modelo.Amigo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class TesteFrmGerenciadorAmigo {

    //Objeto amigo a ser inserido
    Amigo amigoTeste;
    //Formulário fake para inclusão dos dados
    FrmGerenciadorAmigoFake frmGerenciadorAmigo;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    void inicializa() {
        //Dados de teste de inclusão
        amigoTeste = new Amigo(1, "Joao", "123456798", "testeemail@gmail.com");
        //Instância o formulário fake
        frmGerenciadorAmigo = new FrmGerenciadorAmigoFake();
        //Instância o controle do formulário
    }

    @Test
    void testCancelarFechaJanela() {
        FrmGerenciadorAmigo janela = new FrmGerenciadorAmigo();

        assertTrue(janela.isDisplayable());

        janela.simularCliqueCancelar();

        assertFalse(janela.isDisplayable());
    }

    @Test
    void testModificarAmigo() {
        amigoTeste.insertAmigoBD("Joao", "123456789", "testeemail@gmail.com");  // 9 dígitos

        frmGerenciadorAmigo.inicializarLista();

        frmGerenciadorAmigo.selecionarLinha(0);

        frmGerenciadorAmigo.getJTFNome().setText(amigoTeste.getNomeAmigo());
        frmGerenciadorAmigo.getJTFTelefone().setText(amigoTeste.getTelefoneAmigo());
        frmGerenciadorAmigo.getJTFEmail().setText(amigoTeste.getEmailAmigo());

        frmGerenciadorAmigo.clicarBotaoEditar();

        System.out.println("Mensagem exibida: " + frmGerenciadorAmigo.getMensagem());

        assertEquals("Amigo alterado com sucesso!", frmGerenciadorAmigo.getMensagem());

    }

    @Test
    void testApagarAmigo() {

        amigoTeste.insertAmigoBD("Joao", "12345678", "testeemail@gmail.com");

        frmGerenciadorAmigo.inicializarLista();

        frmGerenciadorAmigo.selecionarLinha(0);

        // Simula o clique no botão Apagar via método do fake
        frmGerenciadorAmigo.clicarBotaoApagar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("Amigo apagado com sucesso!", frmGerenciadorAmigo.getMensagem());
    }

    @AfterEach
    void finaliza() {
        AmigoDAO amigodao = new AmigoDAO();
        amigodao.deleteAmigoBD(1);
    }
}
