package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionPessoaTeste {

    @Test
    void deveConferirNomeCorreto() {
        Pessoa pessoa = new Pessoa("Roberto", 30);

        // O que eu espero (expected) e o que obtive (actual)
        assertEquals("Roberto", pessoa.getNome());
    }

    @Test
    void deveFalharSeIdadeIncorreta() {
        Pessoa pessoa = new Pessoa("Yan", 25);

        // Aqui o esperado é 30, mas a idade real é 25 → falha proposital
        assertNotEquals(30, pessoa.getIdade());
    }

    @Test
    void deveVerificarSePessoaNaoEhNula() {
        Pessoa pessoa = new Pessoa("Lito", 5);

        // Verifica se o objeto foi criado corretamente
        assertNotNull(pessoa);
    }

    @Test
    void deveVerificarSeIdadeEhPositiva() {
        Pessoa pessoa = new Pessoa("Lito", 5);

        assertTrue(pessoa.getIdade() > 0);
    }
}
