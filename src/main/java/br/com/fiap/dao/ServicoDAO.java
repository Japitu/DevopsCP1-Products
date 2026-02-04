package br.com.fiap.dao;

import br.com.fiap.enums.TipoArea;
import br.com.fiap.enums.TipoStatusServico;
import br.com.fiap.to.ProjetoTO;
import br.com.fiap.to.ServicoTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {

    public ArrayList<ServicoTO> findAll() {
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "select s.*, p.nm_projeto, u.nm_usuario from tb_servico s inner join tb_projeto p on s.id_projeto = p.id_projeto inner join tb_usuario u on s.id_usuario = u.id_usuario order by s.nm_servico ASC";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoTO servico = new ServicoTO();
                    ProjetoTO projeto = new ProjetoTO();
                    UsuarioTO usuario = new UsuarioTO();

                    servico.setId(rs.getLong("id_servico"));
                    servico.setNome(rs.getString("nm_servico"));
                    servico.setStatusServico(TipoStatusServico.valueOf(rs.getString("st_servico")));
                    servico.setArea(TipoArea.valueOf(rs.getString("ar_servico")));
                    servico.setHorasTotal(rs.getTime("hr_servico").toLocalTime());

                    projeto.setId(rs.getLong("id_projeto"));
                    projeto.setNome(rs.getString("nm_projeto"));
                    servico.setProjeto(projeto);

                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    servico.setUsuario(usuario);

                    servicos.add(servico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return servicos;
    }

    public ServicoTO findById(Long id) {
        ServicoTO servico = new ServicoTO();
        ProjetoTO projeto = new ProjetoTO();
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select s.*, p.nm_projeto, u.nm_usuario from tb_servico s inner join tb_projeto p on s.id_projeto = p.id_projeto inner join tb_usuario u on s.id_usuario = u.id_usuario where s.id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servico.setId(rs.getLong("id_servico"));
                servico.setNome(rs.getString("nm_servico"));
                servico.setStatusServico(TipoStatusServico.valueOf(rs.getString("st_servico")));
                servico.setArea(TipoArea.valueOf(rs.getString("ar_servico")));
                servico.setHorasTotal(rs.getTime("hr_servico").toLocalTime());

                projeto.setId(rs.getLong("id_projeto"));
                projeto.setNome(rs.getString("nm_projeto"));
                servico.setProjeto(projeto);

                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                servico.setUsuario(usuario);

            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return servico;
    }

    public ServicoTO save(ServicoTO servico) {
        String sql = "insert into tb_servico (nm_servico, id_projeto, st_servico, ar_servico, hr_servico, id_usuario) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getNome());
            ps.setLong(2, servico.getProjeto().getId());
            ps.setString(3, servico.getStatusServico().toString());
            ps.setString(4, servico.getArea().toString());
            ps.setString(5, servico.getHorasTotal().toString());
            ps.setLong(6, servico.getUsuario().getId());
            if (ps.executeUpdate() > 0) {
                return servico;
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

    public boolean delete(long id) {
        String sql = "delete from tb_servico where id_servico = ?";
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

    public ServicoTO update(ServicoTO servico) {
        String sql = "update tb_servico set nm_servico = ?, id_projeto = ?, st_servico = ?, ar_servico = ?, hr_servico = ?, id_usuario = ? where id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getNome());
            ps.setLong(2, servico.getProjeto().getId());
            ps.setString(3, servico.getStatusServico().toString());
            ps.setString(4, servico.getArea().toString());
            ps.setString(5, servico.getHorasTotal().toString());
            ps.setLong(6, servico.getUsuario().getId());
            ps.setLong(7, servico.getId());
            if (ps.executeUpdate() > 0) {
                return servico;
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