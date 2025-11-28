package br.com.fiap.dao;

import br.com.fiap.enums.TipoStatusProjeto;
import br.com.fiap.to.ProjetoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO {

    public ArrayList<ProjetoTO> findAll() {
        ArrayList<ProjetoTO> projetos = new ArrayList<ProjetoTO>();
        String sql = "select * from t_mw_projeto order by id_projeto";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProjetoTO projeto = new ProjetoTO();
                    projeto.setId(rs.getLong("id_projeto"));
                    projeto.setNome(rs.getString("nm_projeto"));
                    projeto.setDescricao(rs.getString("dc_projeto"));
                    projeto.setStatus(TipoStatusProjeto.valueOf(rs.getString("st_projeto")));

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
        String sql = "select * from t_mw_projeto where id_projeto";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                projeto.setId(rs.getLong("id_projeto"));
                projeto.setNome(rs.getString("nm_projeto"));
                projeto.setDescricao(rs.getString("dc_projeto"));
                projeto.setStatus(TipoStatusProjeto.valueOf(rs.getString("st_projeto")));
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
        String sql = "insert into t_mw_projeto (nm_projeto, dc_projeto, st_projeto) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getStatus().name());
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
        String sql = "delete from t_mw_projeto where id_projeto = ?";
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
        String sql = "update t_mw_projeto set nm_projeto = ?, dc_projeto = ?, st_projeto = ? where id_projeto = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, projeto.getNome());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getStatus().name());
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
