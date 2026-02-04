package br.com.fiap.to;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorasGastasTO {

    private long id; // id_horas
    private LocalDate data; // dt_horas
    private LocalTime horaInicio; // hr_horas_inicio
    private LocalTime horaFim; // hr_horas_fim
    private UsuarioTO usuario; // id -> id_usuario
    private ServicoTO servico; // id -> id_servico

    public HorasGastasTO() {}

    public HorasGastasTO(long id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, UsuarioTO usuario, ServicoTO servico) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.usuario = usuario;
        this.servico = servico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public ServicoTO getServico() {
        return servico;
    }

    public void setServico(ServicoTO servico) {
        this.servico = servico;
    }


}
