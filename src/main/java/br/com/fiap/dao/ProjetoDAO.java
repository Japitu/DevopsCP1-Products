package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.ProjetoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO {

    public ArrayList<ProjetoTO> findAll() {
        ArrayList<ProjetoTO> projetos = new ArrayList<ProjetoTO>();
        String sql = "select p.*, c.nm_cliente from tb_projeto p inner join tb_cliente c on p.id_cliente = c.id_cliente order by p.nm_projeto ASC";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProjetoTO projeto = new ProjetoTO();
                    ClienteTO cliente = new ClienteTO();

                    projeto.setId(rs.getLong("id_projeto"));
                    projeto.setNome(rs.getString("nm_projeto"));
                    projeto.setNumeroProjeto(rs.getString("nr_projeto"));

                    cliente.setId(rs.getLong("id_cliente"));
                    cliente.setNome(rs.getString("nm_cliente"));
                    projeto.setCliente(cliente);

                    projetos.add(projeto);
                }
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return projetos;
    }

    public ProjetoTO findById(Long id) {
        ProjetoTO projeto = new ProjetoTO();
        ClienteTO cliente = new ClienteTO();
        String sql = "select p.*, c.nm_cliente from tb_projeto p inner join tb_cliente c on p.id_cliente = c.id_cliente where p.id_projeto = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                projeto.setId(rs.getLong("id_projeto"));
                projeto.setNome(rs.getString("nm_projeto"));
                projeto.setNumeroProjeto(rs.getString("nr_projeto"));

                cliente.setId(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nm_cliente"));
                projeto.setCliente(cliente);
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return projeto;
    }

    public ProjetoTO save(ProjetoTO projeto) {
        String sql = "insert into tb_projeto (nm_projeto, nr_projeto, id_cliente) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getNumeroProjeto());
            ps.setLong(3, projeto.getCliente().getId());
            if (ps.executeUpdate() > 0) {
                return projeto;
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
        String sql = "delete from tb_projeto where id_projeto = ?";
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

    public ProjetoTO update(ProjetoTO projeto) {
        String sql = "update tb_projeto set nm_projeto = ?, nr_projeto = ?, id_cliente = ? where id_projeto = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getNumeroProjeto());
            ps.setLong(3, projeto.getCliente().getId());
            ps.setLong(4, projeto.getId());
            if (ps.executeUpdate() > 0) {
                return projeto;
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
