package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTeste {

    @Test
    void deveCriarPessoaCorretamente() {
        Pessoa pessoa = new Pessoa("Roberto", 30);
        assertEquals("Roberto", pessoa.getNome());
        assertEquals(30, pessoa.getIdade());
    }

    @Test
    void deveAlterarNomeCorretamente() {
        Pessoa pessoa = new Pessoa("Roberto", 30);
        pessoa.setNome("Yan");
        assertEquals("Yan", pessoa.getNome());
    }

    @Test
    void deveRetornarVerdadeiroSeMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Roberto", 20);
        assertTrue(pessoa.ehMaiorDeIdade());
    }

    @Test
    void deveRetornarFalsoSeMenorDeIdade() {
        Pessoa pessoa = new Pessoa("João", 15);
        assertFalse(pessoa.ehMaiorDeIdade());
    }
}
