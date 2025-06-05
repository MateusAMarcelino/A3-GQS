package modelo;

public class Sobre {

    private String nome;
    private String versao;
    private String autores;
    private String descricao;

    public Sobre(String nome, String versao, String autores, String descricao) {
        this.nome = nome;
        this.versao = versao;
        this.autores = autores;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getVersao() {
        return versao;
    }

    public String getAutores() {
        return autores;
    }

    public String getDescricao() {
        return descricao;
    }
}
