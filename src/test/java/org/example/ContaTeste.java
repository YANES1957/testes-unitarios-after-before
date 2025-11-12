package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTeste {

    @Test
    void deveDepositarCorretamente() {
        Conta conta = new Conta("Roberto", 100.0);
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo(), "O saldo deve ser 150 após o depósito");
    }

    @Test
    void naoDevePermitirDepositoNegativo() {
        Conta conta = new Conta("Roberto", 100.0);
        conta.depositar(-20.0);
        assertEquals(100.0, conta.getSaldo(), "Depósito negativo não deve alterar o saldo");
    }

    @Test
    void deveSacarCorretamente() {
        Conta conta = new Conta("Roberto", 200.0);
        boolean resultado = conta.sacar(100.0);
        assertTrue(resultado, "O saque deve ser permitido");
        assertEquals(100.0, conta.getSaldo(), "O saldo deve ser 100 após o saque");
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        Conta conta = new Conta("Roberto", 50.0);
        boolean resultado = conta.sacar(100.0);
        assertFalse(resultado, "O saque não deve ser permitido");
        assertEquals(50.0, conta.getSaldo(), "O saldo deve permanecer inalterado");
    }

    @Test
    void deveRetornarNomeDoTitular() {
        Conta conta = new Conta("Roberto", 500.0);
        assertEquals("Roberto", conta.getTitular(), "O nome do titular deve ser Roberto");
    }
}




