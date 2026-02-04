package br.com.fiap.to;

import br.com.fiap.enums.TipoArea;
import br.com.fiap.enums.TipoStatusServico;

import java.time.LocalTime;

public class ServicoTO {
    private long id;
    private String nome;
    private ProjetoTO projeto;
    private TipoArea area;
    private LocalTime horasTotal;
    private TipoStatusServico statusServico;
    private UsuarioTO usuario;


    public ServicoTO() {}

    public ServicoTO(long id, String nome, ProjetoTO projeto, TipoArea area, LocalTime horasTotal, TipoStatusServico statusServico, UsuarioTO usuario) {
        this.id = id;
        this.nome = nome;
        this.projeto = projeto;
        this.area = area;
        this.horasTotal = horasTotal;
        this.statusServico = statusServico;
        this.usuario = usuario;
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

    public ProjetoTO getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoTO projeto) {
        this.projeto = projeto;
    }

    public TipoArea getArea() {
        return area;
    }

    public void setArea(TipoArea area) {
        this.area = area;
    }

    public LocalTime getHorasTotal() {
        return horasTotal;
    }

    public void setHorasTotal(LocalTime horasTotal) {
        this.horasTotal = horasTotal;
    }

    public TipoStatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(TipoStatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }
}
