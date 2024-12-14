package br.edu.ifpr.pgua.eic.tads.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas;

    public Cadastro() {
        pessoas = new ArrayList<>();
    }

    public void add (Pessoa p) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://wagnerweinert.com:3306/tads24_cristian", "tads24_cristian", "tads24_cristian");

            String sql = "INSERT INTO oo_contatos(nome, telefone, email) VALUES (?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getTelefone());
            pstm.setString(3, p.getEmail());

            int res = pstm.executeUpdate();
            if (res == 1) {
                System.out.println("Inserido!");
            } else {
                System.out.println("Deu ruim!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Pessoa> getPessoas() {
        this.pessoas.clear();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://wagnerweinert.com:3306/tads24_cristian", "tads24_cristian", "tads24_cristian");

            String sql = "SELECT * FROM oo_contatos";

            PreparedStatement psmt = con.prepareStatement(sql); 
            
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");

                Pessoa p = new Pessoa(nome, email, telefone);
                pessoas.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return this.pessoas;
    }
}
