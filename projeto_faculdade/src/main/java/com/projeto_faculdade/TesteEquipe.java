package com.projeto_faculdade;

import java.sql.Connection;
import java.sql.DriverManager;

import com.projeto_faculdade.DAO.EquipeDAO;
import com.projeto_faculdade.controller.EquipeController;
import com.projeto_faculdade.view.EquipeView;

public class TesteEquipe {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_app", "root", "root");

        EquipeDAO equipeDAO = new EquipeDAO(con);
        EquipeView view = new EquipeView();
        EquipeController controller = new EquipeController(equipeDAO, view);

        controller.cadastrarEquipe(); 
        System.out.println("\n--- Listando equipes ---");
        controller.listarEquipes();
        controller.vincularEquipeAProjeto();

        con.close();
    }
}
