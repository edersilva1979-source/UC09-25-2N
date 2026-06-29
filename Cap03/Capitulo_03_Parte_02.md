# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 3 -- Construtores

## Parte 2 -- Criando Construtores em Java

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# 🎯 Objetivos

Ao final desta parte você será capaz de:

-   Criar construtores padrão e personalizados.
-   Entender o papel da palavra reservada `new`.
-   Inicializar objetos corretamente.
-   Evoluir as classes `Cliente` e `Produto` do Projeto Integrador.

------------------------------------------------------------------------

# 📷 Figura 3.2 -- Fluxo de criação de um objeto

``` text
          Classe Cliente
                 │
                 ▼
          new Cliente(...)
                 │
                 ▼
     Construtor é executado
                 │
                 ▼
      Objeto pronto para uso
```

**Legenda:** Sempre que utilizamos `new`, o construtor é chamado
automaticamente.

------------------------------------------------------------------------

# Construtor Padrão

Quando nenhum construtor é criado, o Java fornece um construtor padrão.

``` java
public class Cliente {

}
```

Na prática, o Java cria um construtor semelhante a:

``` java
public Cliente(){

}
```

⚠ Esse construtor não inicializa atributos.

------------------------------------------------------------------------

# Construtor Personalizado

Agora vamos definir quais informações um cliente deve possuir desde sua
criação.

``` java
public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){

        this.nome = nome;
        this.cpf = cpf;

    }

}
```

------------------------------------------------------------------------

# 💬 Código Comentado Linha por Linha

``` java
public Cliente(String nome, String cpf)
```

Declara um construtor da classe `Cliente`.

O nome **deve** ser igual ao da classe.

Não existe `void`, `int` ou qualquer outro tipo de retorno.

------------------------------------------------------------------------

``` java
String nome
```

Primeiro parâmetro recebido.

Representa o nome informado pelo usuário.

------------------------------------------------------------------------

``` java
this.nome = nome;
```

À esquerda temos o atributo da classe.

À direita temos o parâmetro recebido.

O `this` elimina a ambiguidade entre os dois.

------------------------------------------------------------------------

# 📊 Diagrama UML

``` text
+-----------------------------------------+
|               Cliente                   |
+-----------------------------------------+
| - nome : String                         |
| - cpf  : String                         |
+-----------------------------------------+
| + Cliente(nome:String, cpf:String)      |
| + getNome() : String                    |
| + setNome(nome:String) : void           |
+-----------------------------------------+
```

------------------------------------------------------------------------

# Criando Objetos

``` java
Cliente cliente =
    new Cliente("Maria Souza",
                "12345678900");
```

Fluxo:

``` text
new
 │
 ▼
Cliente(...)
 │
 ▼
Construtor
 │
 ▼
Objeto inicializado
```

------------------------------------------------------------------------

# Evoluindo a Classe Produto

``` java
public class Produto {

    private String descricao;
    private double valor;

    public Produto(String descricao,
                   double valor){

        this.descricao = descricao;
        this.valor = valor;

    }

}
```

Agora todo produto nasce já contendo uma descrição e um valor.

------------------------------------------------------------------------

# 📖 Estudo de Caso -- Comércio

Imagine um supermercado.

Quando um novo produto é cadastrado, ele não pode existir sem:

-   descrição;
-   preço;
-   código.

Um construtor personalizado garante que esses dados sejam informados no
momento da criação.

------------------------------------------------------------------------

# 🧠 Mini Desafio

Observe a classe abaixo:

``` java
public class Livro{

    private String titulo;
    private String autor;

}
```

**Pergunta:** Quais parâmetros deveriam existir em seu construtor para
impedir que um livro seja criado sem informações básicas?

------------------------------------------------------------------------

# 💡 DICA DO PROFESSOR

``` text
╔══════════════════════════════════════╗
║ Sempre inicialize os dados essenciais║
║ dentro do construtor.                ║
║                                      ║
║ Isso reduz erros e deixa o código    ║
║ mais confiável.                      ║
╚══════════════════════════════════════╝
```

------------------------------------------------------------------------

# ⚠ ATENÇÃO

``` text
╔══════════════════════════════════════╗
║ Um construtor não pode possuir tipo  ║
║ de retorno.                          ║
║                                      ║
║ Errado: public void Cliente()        ║
║ Correto: public Cliente()            ║
╚══════════════════════════════════════╝
```

------------------------------------------------------------------------

# Projeto Integrador

Estrutura atual:

``` text
SistemaComercial
│
├── model
│   ├── Cliente.java
│   └── Produto.java
│
└── principal
    └── Programa.java
```

Classe principal:

``` java
public class Programa {

    public static void main(String[] args) {

        Cliente cliente =
            new Cliente("Maria Souza","12345678900");

        Produto produto =
            new Produto("Notebook",4599.90);

        System.out.println(cliente.getNome());
        System.out.println(produto.getDescricao());

    }

}
```

------------------------------------------------------------------------

# 📋 Resumo Visual

``` text
Classe
   │
   ▼
Construtor Personalizado
   │
   ▼
new
   │
   ▼
Objeto Inicializado
```

------------------------------------------------------------------------

# Preparação para a Parte 3

Na próxima parte aprenderemos a **sobrecarga de construtores**,
permitindo criar objetos de diferentes maneiras, conforme a necessidade
do sistema.
