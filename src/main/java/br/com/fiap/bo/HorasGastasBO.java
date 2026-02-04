package br.com.fiap.bo;

import br.com.fiap.dao.HorasGastasDAO;
import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.HorasGastasTO;
import br.com.fiap.to.ServicoTO;
import br.com.fiap.to.UsuarioTO;

import java.util.ArrayList;

public class HorasGastasBO {
    private HorasGastasDAO horasDAO;
    private UsuarioDAO usuarioDAO;
    private ServicoDAO servicoDAO;

    public ArrayList<HorasGastasTO> findAll() {
        horasDAO = new HorasGastasDAO();

        return horasDAO.findAll();
    }

    public HorasGastasTO findById(long id) {
        horasDAO = new HorasGastasDAO();

        return horasDAO.findById(id);
    }

    public ArrayList<HorasGastasTO> findByServico(long id) {
        horasDAO = new HorasGastasDAO();

        return horasDAO.findByServico(id);
    }

    public HorasGastasTO save(HorasGastasTO horario) throws Exception {
        horasDAO = new HorasGastasDAO();
        usuarioDAO = new UsuarioDAO();
        servicoDAO = new ServicoDAO();

        UsuarioTO horasUsuario = usuarioDAO.findById(horario.getUsuario().getId());
        if (horasUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        ServicoTO horasServico = servicoDAO.findById(horario.getServico().getId());
        if (horasServico == null) {
            throw new Exception("Não existe um servico com o id informado");
        }

        horario.setUsuario(horasUsuario);
        horario.setServico(horasServico);

        return horasDAO.save(horario);
    }

    public boolean delete(long id) {
        horasDAO = new HorasGastasDAO();

        return horasDAO.delete(id);
    }

    public HorasGastasTO update(HorasGastasTO horario) throws Exception {
        horasDAO = new HorasGastasDAO();
        usuarioDAO = new UsuarioDAO();
        servicoDAO = new ServicoDAO();

        UsuarioTO horasUsuario = usuarioDAO.findById(horario.getUsuario().getId());
        if (horasUsuario == null) {
            throw new Exception("Não existe um usuario com o id informado");
        }

        ServicoTO horasServico = servicoDAO.findById(horario.getServico().getId());
        if (horasServico == null) {
            throw new Exception("Não existe um servico com o id informado");
        }

        horario.setUsuario(horasUsuario);
        horario.setServico(horasServico);

        return horasDAO.save(horario);
    }
}
