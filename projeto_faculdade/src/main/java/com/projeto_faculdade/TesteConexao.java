package com.projeto_faculdade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teste_app";
        String usuario = "root";
        String senha = "root";

        try (Connection con = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {

            System.out.println("Usuários cadastrados:");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Nome: " + rs.getString("nome_completo") +
                    ", CPF: " + rs.getString("cpf") +
                    ", Email: " + rs.getString("email") +
                    ", Cargo: " + rs.getString("cargo") +
                    ", Login: " + rs.getString("login") +
                    ", Perfil: " + rs.getString("perfil")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
