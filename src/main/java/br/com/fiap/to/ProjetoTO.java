package br.com.fiap.to;


import br.com.fiap.enums.TipoStatusProjeto;

import java.time.LocalDate;

public class ProjetoTO { // nt_cp_projeto
    private long id; // id_projeto
    private String nome; // nm_projeto
    private String numeroProjeto; // nr_projeto
    private LocalDate dataCriacao; // dt_criacao
    private LocalDate dataFinalizado; // dt_final
    private TipoStatusProjeto status; // st_projeto
    private long idCliente; // id_cliente
    private String nomeCliente;
    private long idResponsavel; // id_usuario
    private String nomeResponsavel;

    public ProjetoTO() {}

    public ProjetoTO(long id, String nome, String numeroProjeto, LocalDate dataCriacao, LocalDate dataFinalizado, TipoStatusProjeto status, long idCliente, String nomeCliente, long idResponsavel, String nomeResponsavel) {
        this.id = id;
        this.nome = nome;
        this.numeroProjeto = numeroProjeto;
        this.dataCriacao = dataCriacao;
        this.dataFinalizado = dataFinalizado;
        this.status = status;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.idResponsavel = idResponsavel;
        this.nomeResponsavel = nomeResponsavel;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(LocalDate dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public TipoStatusProjeto getStatus() {
        return status;
    }

    public void setStatus(TipoStatusProjeto status) {
        this.status = status;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}

