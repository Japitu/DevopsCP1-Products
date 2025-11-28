package br.com.fiap.to;

public class UsuarioTO { // t_mw_usuario
    private long id; // id_usuario
    private String nome; // nm_usuario

    public UsuarioTO () {}

    public UsuarioTO(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
