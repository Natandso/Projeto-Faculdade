package com.projeto_faculdade;

import java.sql.Connection;
import java.sql.DriverManager;

import com.projeto_faculdade.DAO.EquipeDAO;
import com.projeto_faculdade.controller.EquipeController;
import com.projeto_faculdade.view.EquipeView;

public class TesteEquipeProjeto {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/teste_app", "root", "root"
        );

        EquipeDAO dao = new EquipeDAO(con);
        EquipeView view = new EquipeView();
        EquipeController controller = new EquipeController(dao, view);

        System.out.println("--- Vinculando Equipe a Projeto ---");
        controller.vincularEquipeAProjeto();

        con.close();
    }
}
