package modelo;

public class Sobre {
    private final String sistema;
    private final String versao;
    private final String desenvolvedor;
    private final String descricao;

    public Sobre(String sistema, String versao, String desenvolvedor, String descricao) {
        this.sistema = sistema;
        this.versao = versao;
        this.desenvolvedor = desenvolvedor;
        this.descricao = descricao;
    }

    // Getters
    public String getSistema() {
        return sistema;
    }

    public String getVersao() {
        return versao;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public String getDescricao() {
        return descricao;
}
}
