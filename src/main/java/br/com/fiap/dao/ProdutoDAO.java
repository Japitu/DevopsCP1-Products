package br.com.fiap.dao;

import br.com.fiap.to.ProdutoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public ArrayList<ProdutoTO> findAll() {
        ArrayList<ProdutoTO> produtos = new ArrayList<ProdutoTO>();
        String sql = "select * from t_produto order by id_produto";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProdutoTO produto = new ProdutoTO();
                    produto.setId(rs.getLong("id_produto"));
                    produto.setNome(rs.getString("nm_produto"));
                    produto.setDescricao(rs.getString("dc_produto"));
                    produto.setPreco(rs.getDouble("prc_produto"));
                    produtos.add(produto);
                }
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return produtos;
    }

    public ProdutoTO findById(Long id) {
        ProdutoTO produto = new ProdutoTO();
        String sql = "select * from t_produto where id_produto = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                produto.setId(rs.getLong("id_produto"));
                produto.setNome(rs.getString("nm_produto"));
                produto.setDescricao(rs.getString("dc_produto"));
                produto.setPreco(rs.getDouble("prc_produto"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return produto;
    }

    public ProdutoTO save(ProdutoTO produto) {
        String sql = "insert into t_produto (nm_produto, dc_produto, prc_produto) values (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            if (ps.executeUpdate() > 0) {
                return produto;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_produto where id_produto = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ProdutoTO update(ProdutoTO produto) {
        String sql = "update t_produto set nm_produto = ?, dc_produto = ?, prc_produto = ? where id_produto = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setLong(4, produto.getId());
            if (ps.executeUpdate() > 0) {
                return produto;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
