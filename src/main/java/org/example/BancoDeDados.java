package org.example;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private List<Pessoa> pessoas = new ArrayList<>();

    // Adiciona uma pessoa à lista
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Remove uma pessoa pelo nome
    public boolean removerPessoa(String nome) {
        return pessoas.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    // Busca uma pessoa pelo nome
    public Pessoa buscarPessoaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    // Retorna todas as pessoas cadastradas
    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

    // Retorna o número total de pessoas cadastradas
    public int contarPessoas() {
        return pessoas.size();
    }
}
