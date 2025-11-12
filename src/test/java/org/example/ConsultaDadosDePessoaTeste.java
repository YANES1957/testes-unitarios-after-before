package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaDadosDePessoaTeste {

    @Test
    void deveAdicionarPessoaNoBancoDeDados() {
        BancoDeDados banco = new BancoDeDados();
        Pessoa pessoa = new Pessoa("Roberto", 30);

        banco.adicionarPessoa(pessoa);

        assertEquals(1, banco.contarPessoas(), "Deve existir 1 pessoa cadastrada");
        assertEquals("Roberto", banco.listarPessoas().get(0).getNome());
    }

    @Test
    void deveRemoverPessoaPorNome() {
        BancoDeDados banco = new BancoDeDados();
        banco.adicionarPessoa(new Pessoa("Roberto", 30));
        banco.adicionarPessoa(new Pessoa("Yan", 25));

        boolean removido = banco.removerPessoa("Yan");

        assertTrue(removido, "A pessoa deve ser removida");
        assertEquals(1, banco.contarPessoas(), "Deve restar apenas 1 pessoa");
        assertNull(banco.buscarPessoaPorNome("Yan"), "Yan não deve mais estar cadastrado");
    }

    @Test
    void deveBuscarPessoaExistente() {
        BancoDeDados banco = new BancoDeDados();
        banco.adicionarPessoa(new Pessoa("Lito", 5));

        Pessoa resultado = banco.buscarPessoaPorNome("Lito");

        assertNotNull(resultado, "A pessoa deve ser encontrada");
        assertEquals("Lito", resultado.getNome());
    }

    @Test
    void deveRetornarNullSePessoaNaoExistir() {
        BancoDeDados banco = new BancoDeDados();

        Pessoa resultado = banco.buscarPessoaPorNome("Desconhecido");

        assertNull(resultado, "Deve retornar null se a pessoa não existir");
    }
}
