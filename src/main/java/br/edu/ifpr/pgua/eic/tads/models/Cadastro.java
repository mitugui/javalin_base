package br.edu.ifpr.pgua.eic.tads.models;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas;

    public Cadastro() {
        pessoas = new ArrayList<>();
    }

    public void add (Pessoa p) {
        this.pessoas.add(p);
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }
}
