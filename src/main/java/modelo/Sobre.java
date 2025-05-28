package modelo;

/**
 * A classe Sobre representa informações relacionadas ao sistema,
 * como seu nome, versão, desenvolvedores e uma breve descrição.
 */
public class Sobre {

    // Nome do sistema
    private final String sistema;

    // Versão atual do sistema
    private final String versao;

    // Nome(s) do(s) desenvolvedor(es)
    private final String desenvolvedor;

    // Descrição geral do sistema
    private final String descricao;

    /**
     * Construtor da classe Sobre.
     * Inicializa os atributos com os valores fornecidos.
     *
     * @param sistema Nome do sistema
     * @param versao Versão do sistema
     * @param desenvolvedor Nome(s) do(s) desenvolvedor(es)
     * @param descricao Descrição do sistema
     */
    public Sobre(String sistema, String versao, String desenvolvedor, String descricao) {
        this.sistema = sistema;
        this.versao = versao;
        this.desenvolvedor = desenvolvedor;
        this.descricao = descricao;
    }

    // Métodos de acesso (getters)

    /**
     * Retorna o nome do sistema.
     * @return Nome do sistema
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * Retorna a versão do sistema.
     * @return Versão do sistema
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Retorna o(s) nome(s) do(s) desenvolvedor(es).
     * @return Nome(s) do(s) desenvolvedor(es)
     */
    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    /**
     * Retorna a descrição do sistema.
     * @return Descrição do sistema
     */
    public String getDescricao() {
        return descricao;
    }
}
