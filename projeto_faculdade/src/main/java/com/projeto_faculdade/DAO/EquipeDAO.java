package com.projeto_faculdade.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto_faculdade.model.Equipe;
import com.projeto_faculdade.model.Usuario;

public class EquipeDAO {
    private final Connection con;

    public EquipeDAO(Connection con) {
        this.con = con;
    }

    public void salvar(Equipe equipe) throws SQLException {
        String sql = "INSERT INTO equipes (nome, descricao) VALUES (?, ?)";
        try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, equipe.getNome());
            ps.setString(2, equipe.getDescricao());
            ps.executeUpdate();

            try(ResultSet keys =ps.getGeneratedKeys()) {
                if (keys.next()) equipe.setId(keys.getInt(1));
            }
        }
    }

     public List<Equipe> listar() throws SQLException {
        List<Equipe> list = new ArrayList<>();
        String sql = "SELECT id, nome, descricao FROM equipes ORDER BY id DESC";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Equipe(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao")
                ));
            }
        }
        return list;
    }

    public void adicionarMembro(int equipeId, int usuarioId) throws SQLException {
        String sql = "INSERT IGNORE INTO equipe_membros (equipe_id, usuario_id) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipeId);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();
        }
    }

    public void removerMembro(int equipeId, int usuarioId) throws SQLException {
        String sql = "DELETE FROM equipe_membros WHERE equipe_id = ? AND usuario_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipeId);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();
        }
    }

    public List<Usuario> listarMembros(int equipeId) throws SQLException {
        List<Usuario> membros = new ArrayList<>();
        String sql = "SELECT usuario_id FROM equipe_membros WHERE equipe_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    membros.add(new Usuario(rs.getInt("usuario_id")));
                }
            }
        }
        return membros;
    }

    public void vincularProjeto(int equipeId, int projetoId) throws SQLException {
        String sql = "INSERT IGNORE INTO equipe_projeto (equipe_id, projeto_id) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipeId);
            ps.setInt(2, projetoId);
            ps.executeUpdate();
        }
    }

    public List<Equipe> listarEquipesDoProjeto(int projetoId) throws SQLException {
        List<Equipe> list = new ArrayList<>();
        String sql = """
            SELECT e.id, e.nome, e.descricao
            FROM equipe_projeto ep
            JOIN equipes e ON e.id = ep.equipe_id
            WHERE ep.projeto_id = ?
            """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, projetoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Equipe(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                    ));
                }
            }
        }
        return list;
    }

    public List<Integer> listarProjetosDaEquipe(int equipeId) throws SQLException {
        List<Integer> projetos = new ArrayList<>();
        String sql = "SELECT projeto_id FROM equipe_projeto WHERE equipe_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) projetos.add(rs.getInt("projeto_id"));
            }
        }
        return projetos;
    }
}
