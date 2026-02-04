package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public ArrayList<ClienteTO> findAll() {
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "select * from tb_cliente order by nm_cliente ASC";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClienteTO cliente = new ClienteTO();

                    cliente.setId(rs.getLong("id_cliente"));
                    cliente.setNome(rs.getString("nm_cliente"));

                    clientes.add(cliente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return clientes;
    }

    public ClienteTO findById(Long id) {
        ClienteTO cliente = new ClienteTO();
        String sql = "select * where id_cliente = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nm_cliente"));

            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return cliente;
    }

    public ClienteTO save(ClienteTO cliente) {
        String sql = "insert into tb_cliente (nm_cliente) values (?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
                return null;
            }

        }  catch (SQLException e) {
        System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(long id) {
        String sql = "delete from tb_cliente where id_cliente = w";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente) {
        String sql = "update tb_cliente set nm_cliente = ? where id_cliente = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setLong(2, cliente.getId());
            if (ps.executeUpdate() > 0) {
                return cliente;
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
