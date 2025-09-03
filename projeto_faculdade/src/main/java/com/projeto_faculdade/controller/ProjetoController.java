package com.projeto_faculdade.controller;

import java.sql.Connection;
import java.util.List;

import com.projeto_faculdade.DAO.ProjetoDAO;
import com.projeto_faculdade.model.Projeto;
import com.projeto_faculdade.model.Usuario;
import com.projeto_faculdade.view.ProjetoView;

public class ProjetoController {
    private ProjetoDAO projetoDAO;
    private ProjetoView view;

    public ProjetoController(Connection con) {
        this.projetoDAO = new ProjetoDAO(con);
        this.view = new ProjetoView();
    }

    public void cadastrarProjeto(Usuario gerente) {
        Projeto projeto = view.lerDadosProjeto(gerente);
        try {
            projetoDAO.salvar(projeto);
            view.mostrarMensagem("Projeto cadastrado com sucesso!\n" + projeto);
        } catch (Exception e) {
            view.mostrarMensagem("Erro ao salvar projeto: " + e.getMessage());
        }
    }

    public void listarProjetos() {
        try {
            List<Projeto> projetos = projetoDAO.listar();
            projetos.forEach(System.out::println);
        } catch (Exception e) {
            view.mostrarMensagem("Erro ao listar projetos: " + e.getMessage());
        }
    }
}
