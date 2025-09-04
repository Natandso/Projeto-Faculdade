package com.projeto_faculdade.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.projeto_faculdade.model.Equipe;


public class EquipeView {
    private final Scanner sc = new Scanner(System.in);

    public Equipe lerDadosEquipe() {
        System.out.print("Nome da equipe");
        String nome = sc.nextLine();
        System.out.print("Descrição");
        String desc = sc.nextLine();
        return new Equipe(nome, desc);
    }

    public List<Integer> lerIdMembros() {
        System.out.print("Informe os IDs membros (separe-os por vírgula, agradeço): ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return List.of();
        return Arrays.stream(line.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    }

    public int lerIdEquipe() {
        System.out.print("ID da equipe ");
        return Integer.parseInt(sc.nextLine());
    }

    public int lerIdProjeto() {
        System.out.print("ID do projeto");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarMensagem(String msg) {
        System.out.print(msg);
    }
}
