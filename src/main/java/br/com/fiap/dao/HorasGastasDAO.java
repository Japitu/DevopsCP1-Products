package br.com.fiap.dao;

import br.com.fiap.to.HorasGastasTO;
import br.com.fiap.to.ServicoTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HorasGastasDAO {

    public ArrayList<HorasGastasTO> findAll() {
        ArrayList<HorasGastasTO> horas = new ArrayList<HorasGastasTO>();
        String sql = "select h.*, u.nm_usuario from tb_horas h inner join tb_usuario u on h.id_usuario = u.id_usuario inner join tb_servico s on h.id_servico = s.id_servico order by h.id_horas ASC";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    HorasGastasTO horario = new HorasGastasTO();
                    UsuarioTO usuario = new UsuarioTO();
                    ServicoTO servico = new ServicoTO();

                    horario.setId(rs.getLong("id_horas"));
                    horario.setData(rs.getDate("dt_horas").toLocalDate());
                    horario.setHoraInicio(rs.getTime("hr_horas_inicio").toLocalTime());
                    horario.setHoraFim(rs.getTime("hr_horas_fim").toLocalTime());

                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    horario.setUsuario(usuario);

                    servico.setId(rs.getLong("id_servico"));
                    horario.setServico(servico);

                    horas.add(horario);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return horas;
    }

    public HorasGastasTO findById(Long id) {
        HorasGastasTO horario = new HorasGastasTO();
        UsuarioTO usuario = new UsuarioTO();
        ServicoTO servico = new ServicoTO();
        String sql = "select h.*, u.nm_usuario from tb_horas h inner join tb_usuario u on h.id_usuario = u.id_usuario inner join tb_servico s on h.id_servico = s.id_servico where h.id_horas = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                horario.setId(rs.getLong("id_horas"));
                horario.setData(rs.getDate("dt_horas").toLocalDate());
                horario.setHoraInicio(rs.getTime("hr_horas_inicio").toLocalTime());
                horario.setHoraFim(rs.getTime("hr_horas_fim").toLocalTime());

                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                horario.setUsuario(usuario);

                servico.setId(rs.getLong("id_servico"));
                horario.setServico(servico);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return horario;
    }

    public ArrayList<HorasGastasTO> findByServico(Long id) {
        ArrayList<HorasGastasTO> horas = new ArrayList<HorasGastasTO>();

        String sql = "select h.*, u.nm_usuario from tb_horas h inner join tb_usuario u on h.id_usuario = u.id_usuario inner join tb_servico s on h.id_servico = s.id_servico where h.id_servico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    HorasGastasTO horario = new HorasGastasTO();
                    UsuarioTO usuario = new UsuarioTO();
                    ServicoTO servico = new ServicoTO();

                    horario.setId(rs.getLong("id_horas"));
                    horario.setData(rs.getDate("dt_horas").toLocalDate());
                    horario.setHoraInicio(rs.getTime("hr_horas_inicio").toLocalTime());
                    horario.setHoraFim(rs.getTime("hr_horas_fim").toLocalTime());

                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    horario.setUsuario(usuario);

                    servico.setId(rs.getLong("id_servico"));
                    horario.setServico(servico);

                    horas.add(horario);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return horas;
    }

    public HorasGastasTO save(HorasGastasTO horario) {
        String sql = "insert into tb_horas (dt_horas, hr_horas_inicio, hr_horas_fim, id_usuario, id_servico) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, horario.getData().toString());
            ps.setString(2, horario.getHoraInicio().toString());
            ps.setString(3, horario.getHoraFim().toString());
            ps.setLong(4, horario.getUsuario().getId());
            ps.setLong(5, horario.getServico().getId());
            if (ps.executeUpdate() > 0) {
                return horario;
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

    public boolean delete(Long id) {
        String sql = "delete from tb_horas where id_horas";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public HorasGastasTO update(HorasGastasTO horario) {
        String sql = "update tb_horas set dt_horas = ?, hr_horas_inicio = ?, hr_horas_fim = ?, id_usuario = ?, id_servico = ? where id_horas = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, horario.getData().toString());
            ps.setString(2, horario.getHoraInicio().toString());
            ps.setString(3, horario.getHoraFim().toString());
            ps.setLong(4, horario.getUsuario().getId());
            ps.setLong(5, horario.getServico().getId());
            ps.setLong(6, horario.getId());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

}
