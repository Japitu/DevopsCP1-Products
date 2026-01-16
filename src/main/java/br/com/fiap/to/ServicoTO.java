package br.com.fiap.to;

import br.com.fiap.enums.TipoArea;
import br.com.fiap.enums.TipoStatusServico;

import java.time.LocalTime;

public class ServicoTO {
    private long id;
    private String nome;
    private long projetoId;
    private String projetoNome;
    private String projetoNumero;
    private TipoArea area;
    private LocalTime horasTotal;
    private TipoStatusServico statusServico;

    public ServicoTO() {}

    public ServicoTO(long id, String nome, long projetoId, String projetoNome, String projetoNumero, TipoArea area, LocalTime horasTotal, TipoStatusServico statusServico) {
        this.id = id;
        this.nome = nome;
        this.projetoId = projetoId;
        this.projetoNome = projetoNome;
        this.projetoNumero = projetoNumero;
        this.area = area;
        this.horasTotal = horasTotal;
        this.statusServico = statusServico;
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

    public long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(long projetoId) {
        this.projetoId = projetoId;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public String getProjetoNumero() {
        return projetoNumero;
    }

    public void setProjetoNumero(String projetoNumero) {
        this.projetoNumero = projetoNumero;
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
}
