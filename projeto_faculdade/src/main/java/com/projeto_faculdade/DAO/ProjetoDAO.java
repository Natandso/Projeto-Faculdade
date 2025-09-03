package com.projeto_faculdade.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto_faculdade.model.Projeto;
import com.projeto_faculdade.model.StatusProjeto;
import com.projeto_faculdade.model.Usuario;

public class ProjetoDAO {
    private Connection con;

    public ProjetoDAO(Connection con) {
        this.con = con;
    }

    public void salvar(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO projetos (nome, descricao, data_inicio, data_fim_prevista, status, gerente_id) " +
         "VALUES (?, ?, ?, ?, ?, ?)";

         try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, Date.valueOf(projeto.getDataFimPrevista()));
            stmt.setString(5, projeto.getStatus().toString());
            stmt.setInt(6, projeto.getGerente().getId());
            stmt.executeUpdate();
         } 
    }


    public List<Projeto> listar() throws SQLException {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM projetos";
        try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Projeto projeto = new Projeto(
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDate("data_inicio").toLocalDate(),
                    rs.getDate("data_fim_prevista").toLocalDate(),
                    StatusProjeto.valueOf(rs.getString("status")),
                    new Usuario(rs.getInt("gerente_id"))

                );
                projetos.add(projeto);
            }
        }

        return projetos;
    }


}
