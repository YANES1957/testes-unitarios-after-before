package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== INICIANDO O SISTEMA =====");

        // Criar um banco de dados em memória
        BancoDeDados banco = new BancoDeDados();

        // Criar algumas pessoas
        Pessoa pessoa1 = new Pessoa("Roberto", 30);
        Pessoa pessoa2 = new Pessoa("Elizete", 25);
        Pessoa pessoa3 = new Pessoa("Lito", 5);

        // Adicionar pessoas ao banco
        banco.adicionarPessoa(pessoa1);
        banco.adicionarPessoa(pessoa2);
        banco.adicionarPessoa(pessoa3);

        // Listar pessoas
        System.out.println("\nPessoas cadastradas:");
        for (Pessoa p : banco.listarPessoas()) {
            System.out.println("- " + p.getNome() + " (" + p.getIdade() + " anos)");
        }

        // Buscar pessoa específica
        System.out.println("\nBuscando pessoa chamada 'Lito'...");
        Pessoa resultado = banco.buscarPessoaPorNome("Lito");
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado.getNome() + " (" + resultado.getIdade() + " anos)");
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Simular conta bancária
        System.out.println("\n===== SIMULAÇÃO DE CONTA =====");
        Conta conta = new Conta("Roberto", 500.0);

        System.out.println("Saldo inicial: R$" + conta.getSaldo());
        conta.depositar(200.0);
        System.out.println("Após depósito de 200: R$" + conta.getSaldo());
        conta.sacar(150.0);
        System.out.println("Após saque de 150: R$" + conta.getSaldo());

        // Remover pessoa
        System.out.println("\nRemovendo 'Manoel' do banco...");
        banco.removerPessoa("Manoel");

        System.out.println("\nLista final de pessoas:");
        for (Pessoa p : banco.listarPessoas()) {
            System.out.println("- " + p.getNome());
        }

        System.out.println("\n===== FIM DO PROGRAMA =====");
    }
}
