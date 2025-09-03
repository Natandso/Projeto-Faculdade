package com.projeto_faculdade.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.projeto_faculdade.model.Projeto;
import com.projeto_faculdade.model.StatusProjeto;
import com.projeto_faculdade.model.Usuario;

public class ProjetoView {
    private Scanner sc = new Scanner(System.in);

    public Projeto lerDadosProjeto(Usuario gerente) {
        System.out.print("Nome do projeto: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Data de início (yyyy-MM-dd): ");
        LocalDate inicio = LocalDate.parse(sc.nextLine());
        System.out.print("Data de término prevista (yyyy-MM-dd): ");
        LocalDate fimPrevista = LocalDate.parse(sc.nextLine());
        System.out.print("Status (PLANEJADO, EM_ANDAMENTO, CONCLUIDO, CANCELADO): ");
        StatusProjeto status = StatusProjeto.valueOf(sc.nextLine().toUpperCase());

        return new Projeto(nome, descricao, inicio, fimPrevista, status, gerente);
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg + "\n");
    }
}
