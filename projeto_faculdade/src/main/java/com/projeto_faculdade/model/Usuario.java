package com.projeto_faculdade.model;

public class Usuario {
    private int id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String login;
    private String cargo;
    private String senha;
    private Perfil perfil;

    public Usuario(String nomeCompleto, String cpf, String email, String cargo,
                   String login, String senha, Perfil perfil) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Usuario(int id, String nomeCompleto, String cpf, String email, String cargo,
                   String login, String senha, Perfil perfil) {
        this(nomeCompleto, cpf, email, cargo, login, senha, perfil);
        this.id = id;
    }

    public Usuario(int id) {
    this.id = id;
}


    public String getNomeCompletoString() {
        return nomeCompleto;
    }

    public void setNomeCompletoString(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return "Usuário: " + nomeCompleto + "(" + perfil + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }


}
