package com.projeto_faculdade.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int id;
    private String nome;
    private String descricao;

    private List<Usuario> membros = new ArrayList<>();

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Equipe(int id, String nome, String descricao) {
        this(nome,descricao);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public String toString() {
        return "Equipe: " + nome + " (id=" + id + ")";
    }
}
