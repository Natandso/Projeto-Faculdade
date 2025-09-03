package com.projeto_faculdade.controller;

import java.util.List;

import com.projeto_faculdade.DAO.UsuarioDAO;
import com.projeto_faculdade.model.Perfil;
import com.projeto_faculdade.model.Usuario;
import com.projeto_faculdade.view.UsuarioView;

public class UsuarioController {
    private UsuarioView view = new UsuarioView();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void cadastrarUsuario() {
        String nome = view.lerTexto("Digite o nome completo");
        String cpf = view.lerTexto("Digite o CPF");
        String email = view.lerTexto("Digite o e-mail");
        String cargo = view.lerTexto("Digite o cargo");
        String login = view.lerTexto("Digite o login");
        String senha = view.lerTexto("Digite a senha");
        Perfil perfil = view.escolherPerfil();

        Usuario usuario = new Usuario(nome, cpf, email, cargo, login, senha, perfil);
        
        usuarioDAO.salvar(usuario);

        view.mostrarMensagem("Usuário cadastrado com sucesso: " + usuario + "\n");
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar(); // agora retorna do banco
    }
}
