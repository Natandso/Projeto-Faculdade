package com.projeto_faculdade.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projeto_faculdade.model.Perfil;
import com.projeto_faculdade.model.Usuario;

public class UsuarioDAO {
    private String url = "jdbc:mysql://localhost:3306/teste_app";
    private String usuarioDB = "root";
    private String senhaDB = "root";

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome_completo, cpf, email, cargo, login, senha, perfil) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, usuarioDB, senhaDB);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeCompletoString());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCargo());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getPerfil().toString().toUpperCase());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection con = DriverManager.getConnection(url, usuarioDB, senhaDB);
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getString("nome_completo"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    Perfil.valueOf(rs.getString("perfil"))
                );
                usuarios.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }

        return usuarios;
    }
}
