# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 2 -- Programação Orientada a Objetos

## Parte 4 -- Projeto Prático, Exercícios e Revisão

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# Objetivos

Ao concluir esta parte você será capaz de:

-   Aplicar os conceitos de Classe, Objeto e Encapsulamento.
-   Modelar entidades simples.
-   Resolver exercícios utilizando POO.
-   Consolidar os conhecimentos do capítulo.

------------------------------------------------------------------------

# Projeto Prático

Agora vamos reunir tudo o que aprendemos.

Estrutura do projeto:

``` text
SistemaComercial
│
├── model
│     Cliente.java
│     Produto.java
│
└── principal
      Programa.java
```

Classe principal:

``` java
public class Programa {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Produto produto = new Produto();

        cliente.setNome("Maria Souza");

        produto.setDescricao("Notebook");
        produto.setValor(4599.90);

        System.out.println(cliente.getNome());
        System.out.println(produto.getDescricao());
        System.out.println(produto.getValor());

    }

}
```

------------------------------------------------------------------------

# Exercício Resolvido

Crie a classe `Categoria`.

``` java
public class Categoria {

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
```

Programa:

``` java
Categoria categoria = new Categoria();

categoria.setDescricao("Informática");

System.out.println(categoria.getDescricao());
```

------------------------------------------------------------------------

# Exercícios de Fixação

## Nível Básico

Crie a classe:

``` text
Cidade
```

Campos:

-   nome
-   estado

Utilize encapsulamento.

------------------------------------------------------------------------

## Nível Intermediário

Crie a classe:

``` text
Fornecedor
```

Campos:

-   nome
-   cidade
-   telefone

Crie dois objetos.

------------------------------------------------------------------------

## Nível Avançado

Crie as classes:

-   Cliente
-   Produto
-   Venda

Instancie objetos e exiba seus dados utilizando `get()`.

------------------------------------------------------------------------

# Desafio

Imagine que você foi contratado para iniciar o Sistema Comercial.

Modele as seguintes classes.

``` text
Cliente

Produto

Fornecedor

Funcionário
```

Cada classe deverá possuir pelo menos quatro atributos privados e
métodos `get` e `set`.

------------------------------------------------------------------------

# Evolução do Projeto Integrador

``` text
Sistema Comercial

✔ Ambiente configurado

✔ Projeto criado

✔ Classe Cliente

✔ Classe Produto

✔ Objetos

✔ Encapsulamento

⬜ Construtores

⬜ Relacionamentos

⬜ Banco de Dados

⬜ Interface Gráfica
```

------------------------------------------------------------------------

# Dicas do Professor

💡 Sempre pense primeiro no modelo do problema.

Depois escreva o código.

💡 Dê nomes significativos às classes.

💡 Organize cada classe em um arquivo diferente.

------------------------------------------------------------------------

# Erros Mais Comuns

❌ Criar todos os atributos como públicos.

❌ Esquecer os métodos `get` e `set`.

❌ Utilizar nomes genéricos como `teste` ou `obj1`.

❌ Misturar várias responsabilidades em uma única classe.

------------------------------------------------------------------------

# Quiz

## 1

Uma Classe representa:

A)  Um objeto pronto.

B)  Um modelo para criar objetos.

C)  Um método.

D)  Um atributo.

**Resposta:** B

------------------------------------------------------------------------

## 2

Um Objeto é:

A)  Um método.

B)  Uma variável.

C)  Uma instância de uma classe.

D)  Um pacote.

**Resposta:** C

------------------------------------------------------------------------

## 3

Qual palavra reservada cria um objeto?

A)  create

B)  class

C)  new

D)  make

**Resposta:** C

------------------------------------------------------------------------

## 4

Qual modificador protege os atributos?

A)  public

B)  static

C)  private

D)  final

**Resposta:** C

------------------------------------------------------------------------

## 5

Para que serve um método `get()`?

Resposta:

Retornar o valor de um atributo.

------------------------------------------------------------------------

## 6

Para que serve um método `set()`?

Resposta:

Alterar o valor de um atributo.

------------------------------------------------------------------------

## 7

O que representa `this`?

Resposta:

O próprio objeto da classe.

------------------------------------------------------------------------

## 8

Qual é a vantagem do encapsulamento?

Resposta:

Proteger os dados e controlar o acesso.

------------------------------------------------------------------------

## 9

Cada classe deve possuir:

Resposta:

Uma responsabilidade principal.

------------------------------------------------------------------------

## 10

Qual foi o primeiro módulo criado do Projeto Integrador?

Resposta:

As classes Cliente e Produto.

------------------------------------------------------------------------

# Glossário

  Termo            Definição
  ---------------- --------------------------------------
  Classe           Modelo para criar objetos
  Objeto           Instância da classe
  Instância        Objeto criado a partir de uma classe
  Atributo         Característica
  Método           Comportamento
  Encapsulamento   Proteção dos dados
  private          Restringe acesso ao atributo
  public           Permite acesso ao método
  this             Referência ao próprio objeto

------------------------------------------------------------------------

# Resumo Visual

``` text
Classe
    │
    ▼
Objeto
    │
    ▼
Atributos private
    │
    ▼
Métodos get/set
    │
    ▼
Objeto Seguro
```

------------------------------------------------------------------------

# Checklist

Marque os itens concluídos.

-   [ ] Sei explicar o que é POO.
-   [ ] Sei criar Classes.
-   [ ] Sei criar Objetos.
-   [ ] Sei utilizar `new`.
-   [ ] Sei criar Atributos.
-   [ ] Sei criar Métodos.
-   [ ] Entendi o Encapsulamento.
-   [ ] Sei utilizar `private`.
-   [ ] Sei criar `get` e `set`.
-   [ ] Concluí todos os exercícios.

------------------------------------------------------------------------

# Encerramento

Parabéns!

Você concluiu um dos capítulos mais importantes do curso.

A partir deste momento você já possui os conhecimentos necessários para
começar a desenvolver aplicações utilizando Programação Orientada a
Objetos.

No próximo capítulo estudaremos **Construtores**, tornando nossas
classes mais organizadas e profissionais.
