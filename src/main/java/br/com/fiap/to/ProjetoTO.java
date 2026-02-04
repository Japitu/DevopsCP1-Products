package br.com.fiap.to;

public class ProjetoTO { // nt_cp_projeto
    private long id; // id_projeto
    private String nome; // nm_projeto
    private String numeroProjeto; // nr_projeto
    private ClienteTO cliente;

    public ProjetoTO() {
    }

    public ProjetoTO(long id, String nome, String numeroProjeto, ClienteTO cliente) {
        this.id = id;
        this.nome = nome;
        this.numeroProjeto = numeroProjeto;
        this.cliente = cliente;
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

    public String getNumeroProjeto() {
        return numeroProjeto;
    }

    public void setNumeroProjeto(String numeroProjeto) {
        this.numeroProjeto = numeroProjeto;
    }

    public ClienteTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTO cliente) {
        this.cliente = cliente;
    }
}


