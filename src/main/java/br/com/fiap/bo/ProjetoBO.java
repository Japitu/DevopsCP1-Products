package br.com.fiap.bo;

import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.to.ProjetoTO;

import java.util.ArrayList;

public class ProjetoBO {
    private ProjetoDAO projetoDAO;

    public ArrayList<ProjetoTO> findAll() {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.findAll();
    }

    public ProjetoTO findById(Long id) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.findById(id);
    }

    public ProjetoTO save (ProjetoTO projeto) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.save(projeto);
    }

    public boolean delete (Long id) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.delete(id);
    }

    public ProjetoTO update(ProjetoTO projeto) {
        projetoDAO = new ProjetoDAO();

        return projetoDAO.update(projeto);
    }
}
