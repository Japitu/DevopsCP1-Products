package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public ArrayList<ClienteTO> findAll() {
        clienteDAO = new ClienteDAO();

        return clienteDAO.findAll();
    }

    public ClienteTO findById(long id) {
        clienteDAO = new ClienteDAO();

        return clienteDAO.findById(id);
    }

    public ClienteTO save(ClienteTO cliente){
        clienteDAO = new ClienteDAO();

        return clienteDAO.save(cliente);
    }

    public boolean delete(long id) {
        clienteDAO = new ClienteDAO();

        return clienteDAO.delete(id);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();

        return clienteDAO.update(cliente);
    }
}
