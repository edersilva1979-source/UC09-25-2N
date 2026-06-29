# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 3 -- Construtores

## Parte 1 -- Construtores e sua Importância

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# 🎯 Objetivos

Ao final desta parte você será capaz de:

-   Entender o que é um construtor.
-   Compreender por que construtores existem.
-   Diferenciar construtores de métodos.
-   Identificar situações reais onde construtores são utilizados.

------------------------------------------------------------------------

# 🏆 Competências

-   Modelar objetos de forma correta.
-   Criar classes mais organizadas.
-   Aplicar boas práticas de Programação Orientada a Objetos.

------------------------------------------------------------------------

# 📷 Ilustração sugerida

**Figura 3.1 -- Planta e Casa**

              PROJETO
          ┌─────────────┐
          │   Planta    │
          └──────┬──────┘
                 │
                 ▼
          ┌─────────────┐
          │    Casa     │
          └─────────────┘

**Legenda:** O construtor é responsável por iniciar corretamente um
objeto, assim como uma planta orienta a construção de uma casa.

------------------------------------------------------------------------

# Introdução

Até agora aprendemos a criar classes, objetos, atributos e métodos.

Entretanto, existe um problema.

Sempre que criamos um objeto, precisamos preencher seus atributos
manualmente.

``` java
Cliente cliente = new Cliente();

cliente.setNome("Maria");
cliente.setCpf("12345678900");
```

Será que existe uma forma melhor?

Sim.

Utilizando **Construtores**.

------------------------------------------------------------------------

# 📖 História

Nas primeiras linguagens orientadas a objetos, muitos objetos eram
criados incompletos.

Era comum esquecer de preencher informações importantes.

O construtor surgiu para garantir que o objeto fosse criado já em um
estado válido.

Hoje praticamente todas as linguagens orientadas a objetos utilizam esse
conceito.

------------------------------------------------------------------------

# O que é um Construtor?

Um construtor é um bloco especial executado automaticamente quando um
objeto é criado.

Ele prepara o objeto para uso.

    Classe
       │
       ▼
    Construtor
       │
       ▼
    Objeto pronto

------------------------------------------------------------------------

# 📚 Curiosidade

╔════════════════════════════════════╗

📚 CURIOSIDADE

O construtor possui exatamente o mesmo nome da classe e **não possui
tipo de retorno**.

╚════════════════════════════════════╝

------------------------------------------------------------------------

# Método x Construtor

  Método                        Construtor
  ----------------------------- ---------------------------
  Pode ter qualquer nome        Deve ter o nome da classe
  Possui tipo de retorno        Não possui retorno
  É chamado quando necessário   Executa automaticamente

------------------------------------------------------------------------

# 📊 Diagrama UML

    +--------------------------------------+
    |              Cliente                 |
    +--------------------------------------+
    | - nome : String                      |
    | - cpf  : String                      |
    +--------------------------------------+
    | + Cliente()                          |
    | + Cliente(nome, cpf)                 |
    | + getNome() : String                 |
    | + setNome(nome) : void               |
    +--------------------------------------+

------------------------------------------------------------------------

# 💻 Primeiro Construtor

``` java
public class Cliente {

    public Cliente(){

        System.out.println("Cliente criado.");

    }

}
```

## Comentando linha por linha

``` java
public Cliente()
```

Declara um construtor.

O nome é **Cliente**, igual ao da classe.

Não existe `void`.

``` java
System.out.println(...)
```

Executa automaticamente quando o objeto é criado.

------------------------------------------------------------------------

# Exemplo de uso

``` java
Cliente cliente = new Cliente();
```

Fluxo:

    new Cliente()
          │
          ▼
    Construtor executado
          │
          ▼
    Objeto criado

------------------------------------------------------------------------

# 📖 Estudo de Caso 1 -- Banco

Quando um cliente abre uma conta, o sistema cria automaticamente:

-   número da conta
-   agência
-   data de abertura
-   saldo inicial

Tudo isso pode acontecer dentro do construtor.

------------------------------------------------------------------------

# 📖 Estudo de Caso 2 -- Hospital

Ao cadastrar um paciente:

-   nome
-   número do prontuário
-   data de internação
-   leito

Essas informações podem ser inicializadas no momento da criação do
objeto.

------------------------------------------------------------------------

# 📖 Estudo de Caso 3 -- Comércio

No Sistema Comercial deste curso, um produto poderá nascer já com:

-   estoque igual a zero
-   situação ativa
-   data de cadastro

O construtor automatiza essa inicialização.

------------------------------------------------------------------------

# 🧠 Mini Desafio

Uma classe **Livro** possui:

-   título
-   autor
-   páginas

Pergunta:

Quais informações deveriam obrigatoriamente ser recebidas no momento da
criação do objeto?

------------------------------------------------------------------------

# 💡 Dica do Professor

╔════════════════════════════════════╗

💡 DICA

Sempre pense: um objeto faz sentido vazio?

Se a resposta for "não", provavelmente ele precisa de um construtor
personalizado.

╚════════════════════════════════════╝

------------------------------------------------------------------------

# ⚠ Atenção

╔════════════════════════════════════╗

⚠ ATENÇÃO

Construtor não é método.

A diferença mais importante é que o construtor não possui tipo de
retorno e é executado automaticamente.

╚════════════════════════════════════╝

------------------------------------------------------------------------

# Projeto Integrador

Na próxima parte substituiremos a criação manual das classes **Cliente**
e **Produto** por construtores profissionais.

    Sistema Comercial

    ✔ Classes

    ✔ Objetos

    ✔ Encapsulamento

    ⬜ Construtores

------------------------------------------------------------------------

# Resumo

    Classe
       │
       ▼
    Construtor
       │
       ▼
    Objeto inicializado

# Preparação para a Parte 2

Na próxima parte criaremos:

-   construtor padrão;
-   construtor personalizado;
-   construtores para Cliente e Produto;
-   código comentado linha por linha.
