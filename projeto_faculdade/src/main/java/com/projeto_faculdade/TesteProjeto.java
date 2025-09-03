package com.projeto_faculdade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import com.projeto_faculdade.DAO.ProjetoDAO;
import com.projeto_faculdade.model.Projeto;
import com.projeto_faculdade.model.StatusProjeto;
import com.projeto_faculdade.model.Usuario;

public class TesteProjeto {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_app", "root", "root");
        ProjetoDAO projetoDAO = new ProjetoDAO(con);

        Usuario gerente = new Usuario(1);

        Projeto projeto = new Projeto(
                "Sistema ERP",
                "Projeto para gestão empresarial",
                LocalDate.of(2025, 9, 1),
                LocalDate.of(2026, 2, 28),
                StatusProjeto.PLANEJADO,
                gerente
        );

        projetoDAO.salvar(projeto);
        System.out.println("Projeto cadastrado com sucesso!");

        projetoDAO.listar().forEach(System.out::println);

        con.close();
    }
}
