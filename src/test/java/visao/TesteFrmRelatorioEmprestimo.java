package visao;

import dao.AmigoDAO;
import modelo.Amigo;
import dao.FerramentaDAO;
import modelo.Ferramenta;
import dao.EmprestimoDAO;
import modelo.Emprestimo;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TesteFrmRelatorioEmprestimo {
    //Objeto amigo a ser inserido

    Amigo TestAmigo;
    //Objeto ferramenta a ser inserido
    Ferramenta TestFerramenta;
    Emprestimo TestEmprestimo;
    //Formulário fake para inclusão dos dados
    FrmRelatorioEmprestimoFake frmRelatorioEmprestimo;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    void inicializa() {
        //Dados de teste de inclusão
        TestAmigo = new Amigo(1, "Joao", "12345678");
        TestFerramenta = new Ferramenta(1, "Tesoura", 17, "selos");
        TestEmprestimo = new Emprestimo(1, 1, 1, "21-05-2025", "");

        //Instância o formulário fake
        frmRelatorioEmprestimo = new FrmRelatorioEmprestimoFake();
        //Instância o controle do formulário
    }
}