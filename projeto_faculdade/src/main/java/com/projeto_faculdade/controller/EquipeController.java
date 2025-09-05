package com.projeto_faculdade.controller;

import java.sql.SQLException;
import java.util.List;

import com.projeto_faculdade.DAO.EquipeDAO;
import com.projeto_faculdade.model.Equipe;
import com.projeto_faculdade.view.EquipeView;

public class EquipeController {

    private final EquipeDAO dao;
    private final EquipeView view;

    public EquipeController(EquipeDAO dao, EquipeView view) {
        this.dao = dao;
        this.view = view;
    }

    public void cadastrarEquipe() {
        try {
            Equipe equipe = view.lerDadosEquipe();
            dao.salvar(equipe);

            List<Integer> membros = view.lerIdMembros();
            for (Integer usuarioId : membros) {
                dao.adicionarMembro(equipe.getId(), usuarioId);
            }
            view.mostrarMensagem("Equipe cadastrada com sucesso: " + equipe);

        } catch (SQLException e) {
            view.mostrarMensagem("Erro ao cadastrar equipe " + e.getMessage());
        }
    }

    public void listarEquipes() {
        try {
            var equipes = dao.listar();
            if (equipes.isEmpty()) {
                view.mostrarMensagem("Nenhum equipe cadastrada. ");
            } else {
                for (Equipe e : equipes) {
                    view.mostrarMensagem(e.toString());
                }
            }

        } catch (SQLException e) {
            view.mostrarMensagem("Erro ao listrar equipes: " + e.getMessage());
        }
    }

    public void vincularEquipeAProjeto() {
        try {
            int equipeId = view.lerIdEquipe();
            int projetoId = view.lerIdProjeto();
            dao.vincularProjeto(equipeId, projetoId);
            view.mostrarMensagem("Equipe vinculada ao projeto com sucesso!");
        } catch (SQLException e) {
            view.mostrarMensagem("Erro ao listar as equipes: " + e.getMessage());;
        }
    }

}
