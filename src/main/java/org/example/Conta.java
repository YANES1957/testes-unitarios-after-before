
package org.example;

public class Conta {

    private String titular;
    private double saldo;

    // Construtor
    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    // Método para sacar
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    // Getter do saldo
    public double getSaldo() {
        return saldo;
    }

    // Getter do titular
    public String getTitular() {
        return titular;
    }
}
