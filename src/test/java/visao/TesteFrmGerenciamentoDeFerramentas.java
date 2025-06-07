package visao;

import dao.FerramentaDAO;
import modelo.Ferramenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteFrmGerenciamentoDeFerramentas {
 
    //Objeto amigo a ser inserido
    
    Ferramenta ferramentaTeste;
    //Formulário fake para inclusão dos dados
    FrmGerenciamentoDeFerramentasFake frmGerenciamentoDeFerramenta;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    void inicializa() {
        //Dados de teste de inclusão
        ferramentaTeste = new Ferramenta(1, "Martelo", "Stove", 15.0);
        //Instância o formulário fake
        frmGerenciamentoDeFerramenta = new FrmGerenciamentoDeFerramentasFake();
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
    void testModificarFerramenta() {
        ferramentaTeste.InsertFerramentaDB("Martelo", "Stove", 15.0);

        frmGerenciamentoDeFerramenta.inicializarListaFerramentas();

        frmGerenciamentoDeFerramenta.selecionarLinha(0);

        frmGerenciamentoDeFerramenta.getJTFNomeAlterar().setText(ferramentaTeste.getNomeFerramentas());
        frmGerenciamentoDeFerramenta.getJTFMarcaAlterar().setText(ferramentaTeste.getMarcaFerramentas());
        frmGerenciamentoDeFerramenta.getJTFCustoAlterar().setText(String.valueOf(ferramentaTeste.getCustoFerramentas()));

        frmGerenciamentoDeFerramenta.clicarBotaoAlterar();

        System.out.println("Mensagem exibida: " + frmGerenciamentoDeFerramenta.getMensagem());

        assertEquals("Ferramenta Alterada com sucesso!", frmGerenciamentoDeFerramenta.getMensagem());

    }

    @Test
    void testApagarAmigo() {

        ferramentaTeste.InsertFerramentaDB("Martelo", "Stove", 15.0);

        frmGerenciamentoDeFerramenta.inicializarListaFerramentas();

        frmGerenciamentoDeFerramenta.selecionarLinha(0);

        // Simula o clique no botão Apagar via método do fake
        frmGerenciamentoDeFerramenta.clicarBotaoApagar();

        // Verifica se a mensagem exibida é a de sucesso
        assertEquals("Ferramenta Apagada com sucesso!!", frmGerenciamentoDeFerramenta.getMensagem());
    }

    @AfterEach
    void finaliza() {
        FerramentaDAO amigodao = new FerramentaDAO();
        amigodao.DeleteFerramentaDB(1);
    }   

   
}
