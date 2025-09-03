package com.projeto_faculdade.view;

import java.util.Scanner;

import com.projeto_faculdade.model.Perfil;

public class UsuarioView {
    private Scanner scanner = new Scanner(System.in);

    public String lerTexto(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    public Perfil escolherPerfil() {
        System.out.println("Escolha o perfil:");
        System.out.println("1 - ADMINISTRADOR");
        System.out.println("2 - GERENTE");
        System.out.println("3 - COLABORADOR");
        int opcao = Integer.parseInt(scanner.nextLine());
        return switch (opcao) {
            case 1 -> Perfil.ADMINISTRADOR;
            case 2 -> Perfil.GERENTE;
            default -> Perfil.COLABORADOR;
        };
}

public void mostrarMensagem(String mensagem) {
    System.out.print(mensagem);
}
}
