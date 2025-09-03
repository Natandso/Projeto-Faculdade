package com.projeto_faculdade;

import com.projeto_faculdade.controller.UsuarioController;

public class App {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();

        usuarioController.cadastrarUsuario();

        System.out.println("\nUsuários cadastrados abaixo");
        usuarioController.listarUsuarios().forEach(System.out::println);
    }
}
