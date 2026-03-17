package br.com.fiap.bo;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

import java.util.ArrayList;

public class ProdutoBO {

    private ProdutoDAO produtoDAO;

    public ArrayList<ProdutoTO> findAll() {
        produtoDAO = new ProdutoDAO();

        return produtoDAO.findAll();
    }

    public ProdutoTO findById(Long id) {
        produtoDAO = new ProdutoDAO();

        return produtoDAO.findById(id);
    }

    public ProdutoTO save(ProdutoTO produto) {
        produtoDAO = new ProdutoDAO();

        return produtoDAO.save(produto);
    }

    public boolean delete(Long id) {
        produtoDAO = new ProdutoDAO();

        return produtoDAO.delete(id);
    }

    public ProdutoTO update(ProdutoTO produto) {
        produtoDAO = new ProdutoDAO();

        return produtoDAO.update(produto);
    }
}
