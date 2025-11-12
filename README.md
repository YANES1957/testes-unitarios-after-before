🔴 Projeto: AfterBeforeTestes

O projeto AfterBeforeTestes foi desenvolvido como um laboratório de aprendizado prático em Testes Unitários com JUnit 5, dentro da linguagem Java.

Ele faz parte da trilha de estudos para QA Automation, com o objetivo de entender como garantir que cada parte de um sistema funcione corretamente antes de integrá-lo com outras.

O foco está em aprender, testar e dominar os principais tipos de testes unitários e assertions (validações), além de compreender o ciclo de vida dos testes no JUnit 5.

🎯 Objetivo do projeto:

Garantir que os métodos e classes criadas (como Conta, Pessoa e BancoDeDados) funcionem corretamente e produzam os resultados esperados, utilizando testes automatizados com o JUnit 5.

Com isso, você aprende a:

Validar comportamentos do código;

Identificar erros e inconsistências;

Automatizar a verificação de resultados;

Criar uma base sólida para evoluir em testes de integração, API e UI (Selenium/RestAssured).

⚙️ Tecnologias Utilizadas:

☕ Java 17

🧩 JUnit 5

🧱 Maven

💻 IntelliJ IDEA

📂 Estrutura do Projeto
src/
├── main/
│   └── java/org/example/
│       ├── BancoDeDados.java
│       ├── Conta.java
│       ├── Pessoa.java
│       └── Main.java
└── test/
    └── java/org/example/
        ├── ContaTeste.java
        ├── PessoaTeste.java
        ├── ConsultaDadosDePessoaTeste.java
        └── AssertionPessoaTeste.java

🧠 Tipos de Testes Implementados

A seguir, estão explicados todos os tipos de testes realizados no projeto — com exemplos, finalidade e comportamento esperado.

1️⃣ Testes de Igualdade e Diferença (assertEquals, assertNotEquals)

📁 Classe: ContaTeste

Esses testes comparam resultados esperados com os obtidos durante a execução.
Servem para garantir que operações matemáticas ou retornos de método estão corretos.

@Test
void deveSomarCorretamente() {
    int resultado = 2 + 3;
    assertEquals(5, resultado);
}

@Test
void deveFalharSeResultadoErrado() {
    int resultado = 2 + 2;
    assertNotEquals(5, resultado);
}


🔴 Explicação:

assertEquals(esperado, atual) → o teste passa se os dois valores forem iguais.

assertNotEquals(inesperado, atual) → o teste passa se forem diferentes.

🧠 Objetivo: validar se os cálculos e retornos de métodos são precisos.

2️⃣ Testes de Condição Booleana (assertTrue, assertFalse)

📁 Classe: ContaTeste

Verificam se uma condição é verdadeira ou falsa, simulando regras de negócio simples.

@Test
void deveRetornarVerdadeiroSeSaldoPositivo() {
    double saldo = 100;
    assertTrue(saldo > 0);
}

@Test
void deveRetornarFalsoSeSaldoNegativo() {
    double saldo = -50;
    assertFalse(saldo > 0);
}


🔴 Explicação:

assertTrue(condição) → passa se a condição for verdadeira.

assertFalse(condição) → passa se a condição for falsa.

🧠 Objetivo: validar decisões lógicas (if/else) e regras simples do sistema.

3️⃣ Testes de Nulidade (assertNull, assertNotNull)

📁 Classe: PessoaTeste

Testam se um objeto foi corretamente instanciado ou não.

@Test
void deveRetornarNomeNaoNulo() {
    Pessoa pessoa = new Pessoa("Roberto", 35);
    assertNotNull(pessoa.getNome());
}

@Test
void deveRetornarTelefoneNulo() {
    Pessoa pessoa = new Pessoa("Roberto", 35);
    assertNull(pessoa.getTelefone());
}


🔴 Explicação:

assertNotNull(objeto) → passa se o objeto não for nulo.

assertNull(objeto) → passa se o objeto for nulo.

🧠 Objetivo: verificar se as instâncias da aplicação estão sendo criadas corretamente e evitando NullPointerException.

4️⃣ Testes de Exceção (assertThrows)

📁 Classe: ConsultaDadosDePessoaTeste

Testam se um método lança uma exceção esperada — o que é muito importante em QA, pois o sistema precisa reagir corretamente a erros.

@Test
void deveLancarExcecaoSePessoaNaoExistir() {
    assertThrows(IllegalArgumentException.class, () -> {
        BancoDeDados.consultarPessoaPorId(999);
    });
}


🔴 Explicação:

O teste passa se o método realmente lançar a exceção informada (IllegalArgumentException).

🧠 Objetivo: garantir que o código trata erros de forma controlada e previsível.

5️⃣ Testes Agrupados (assertAll)

📁 Classe: AssertionPessoaTeste

Executa várias verificações em um único teste, sem parar na primeira falha.

@Test
void deveValidarPessoaCompleta() {
    Pessoa p = new Pessoa("Roberto", 35);
    assertAll("Validação completa da pessoa",
        () -> assertNotNull(p.getNome()),
        () -> assertTrue(p.getIdade() > 0),
        () -> assertEquals("Roberto", p.getNome())
    );
}


🔴 Explicação:

Mesmo se uma asserção falhar, as demais continuam sendo executadas.

Ideal para validar objetos complexos com vários atributos.

🧠 Objetivo: validar múltiplas propriedades de um mesmo objeto em conjunto.

6️⃣ Testes de Ciclo de Vida (@BeforeAll, @AfterAll, @BeforeEach, @AfterEach)

📁 Classe: ContaTeste (ou qualquer outra de teste)

Essas anotações controlam a execução antes e depois dos testes.

@BeforeAll
static void iniciarConexao() {
    System.out.println("Conexão iniciada antes de todos os testes.");
}

@AfterAll
static void encerrarConexao() {
    System.out.println("Conexão encerrada após todos os testes.");
}

@BeforeEach
void preparar() {
    System.out.println("Preparando ambiente para teste...");
}

@AfterEach
void finalizar() {
    System.out.println("Finalizando teste atual...");
}


🧩 Explicação:

@BeforeAll → roda uma única vez antes de todos os testes.

@AfterAll → roda uma única vez depois de todos os testes.

@BeforeEach → roda antes de cada teste.

@AfterEach → roda depois de cada teste.

🧠 Objetivo: simular inicializações e limpezas automáticas, como conexões de banco, mocks e resets de variáveis.

🔴 Resumo das Assertions
Assertion	Função
assertEquals	Compara dois valores e passa se forem iguais
assertNotEquals	Passa se os valores forem diferentes
assertTrue	Passa se a condição for verdadeira
assertFalse	Passa se a condição for falsa
assertNull	Passa se o objeto for nulo
assertNotNull	Passa se o objeto não for nulo
assertThrows	Passa se o método lançar uma exceção esperada
assertAll	Executa várias verificações em conjunto
🔁 Ciclo de Vida dos Testes (JUnit 5)

O JUnit executa cada teste dentro de um ciclo:

@BeforeAll → executa antes de todos os testes (configuração global)

@BeforeEach → executa antes de cada teste (preparação individual)

@Test → execução do teste

@AfterEach → executa após cada teste (limpeza individual)

@AfterAll → executa depois de todos os testes (finalização global)

📊 Resultado

✅ Todos os testes foram executados com sucesso.
🚫 Testes com falhas intencionais (como assertNotEquals) foram usados para demonstrar comportamentos de erro.
🔍 Cada classe de teste simula um cenário real de QA, testando desde cálculos simples até tratamento de exceções.

👨‍💻 Autor do projeto:
Roberto Cesar Yanes.

🔴 Evoluindo na área de Testes Unitários e QA Automation.
