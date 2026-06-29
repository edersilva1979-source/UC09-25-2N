# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 3 -- Construtores

## Parte 3 -- Sobrecarga de Construtores

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# 🎯 Objetivos

Ao final desta parte você será capaz de:

-   Entender o conceito de sobrecarga de construtores.
-   Criar vários construtores para a mesma classe.
-   Escolher o construtor adequado para cada situação.
-   Evoluir as classes do Projeto Integrador.

------------------------------------------------------------------------

# 📷 Figura 3.3 -- Uma classe, vários caminhos

``` text
                 +----------------------+
                 |      Cliente         |
                 +----------------------+
                    /       |        \
                   /        |         \
                  ▼         ▼          ▼
         Cliente()  Cliente(nome)  Cliente(nome,cpf)
```

**Legenda:** A mesma classe pode oferecer diferentes formas de criar um
objeto.

------------------------------------------------------------------------

# Por que utilizar sobrecarga?

Nem sempre possuímos todas as informações no momento da criação do
objeto.

Exemplo:

📖 Cadastro rápido de um cliente:

-   Nome

Mais tarde:

-   CPF
-   Telefone
-   E-mail

A sobrecarga permite atender essas diferentes necessidades.

------------------------------------------------------------------------

# O que é Sobrecarga?

Sobrecarga consiste em criar **vários construtores com o mesmo nome**,
mas com parâmetros diferentes.

Todos possuem o nome da classe.

O que muda é a quantidade ou o tipo dos parâmetros.

------------------------------------------------------------------------

# 📊 Diagrama UML

``` text
+------------------------------------------------+
|                  Cliente                        |
+------------------------------------------------+
| - nome : String                                |
| - cpf : String                                 |
| - telefone : String                            |
+------------------------------------------------+
| + Cliente()                                    |
| + Cliente(nome:String)                         |
| + Cliente(nome:String, cpf:String)             |
+------------------------------------------------+
```

------------------------------------------------------------------------

# Primeiro Construtor

``` java
public Cliente() {

}
```

Utilizado quando nenhum dado é informado.

------------------------------------------------------------------------

# Segundo Construtor

``` java
public Cliente(String nome) {

    this.nome = nome;

}
```

## Comentário

``` java
this.nome = nome;
```

Inicializa apenas o atributo nome.

------------------------------------------------------------------------

# Terceiro Construtor

``` java
public Cliente(String nome,
               String cpf) {

    this.nome = nome;
    this.cpf = cpf;

}
```

Agora o objeto nasce com duas informações obrigatórias.

------------------------------------------------------------------------

# 💬 Comparando os três construtores

``` java
Cliente cliente1 = new Cliente();
```

Objeto vazio.

------------------------------------------------------------------------

``` java
Cliente cliente2 =
    new Cliente("Maria");
```

Objeto com nome.

------------------------------------------------------------------------

``` java
Cliente cliente3 =
    new Cliente("Maria",
                "12345678900");
```

Objeto mais completo.

------------------------------------------------------------------------

# 📖 Estudo de Caso -- Hospital

Imagine um sistema hospitalar.

Em um atendimento de emergência, o paciente pode ser registrado
inicialmente apenas com:

-   nome;
-   data de nascimento.

Após estabilização, outros dados são incluídos.

A sobrecarga permite criar objetos em diferentes momentos do
atendimento.

------------------------------------------------------------------------

# 📖 Estudo de Caso -- Banco

Durante uma abertura de conta:

Primeira etapa:

-   nome

Segunda etapa:

-   CPF

Terceira etapa:

-   endereço

Cada fase pode utilizar um construtor diferente.

------------------------------------------------------------------------

# 📖 Estudo de Caso -- Comércio

No Sistema Comercial:

Produto recebido do fornecedor.

Primeiro:

-   descrição

Depois:

-   preço
-   estoque
-   categoria

A classe Produto pode possuir vários construtores.

------------------------------------------------------------------------

# 🧠 Mini Desafio

Uma classe **Funcionário** possui:

-   nome
-   cargo
-   salário
-   departamento

Quantos construtores diferentes fariam sentido para um sistema de RH?

Justifique sua resposta.

------------------------------------------------------------------------

# Evoluindo a Classe Produto

``` java
public class Produto {

    private String descricao;
    private double valor;
    private int estoque;

    public Produto() {
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Produto(String descricao,
                   double valor) {

        this.descricao = descricao;
        this.valor = valor;
    }

}
```

------------------------------------------------------------------------

# 📷 Fluxo Visual

``` text
                Produto

        +--------------------+

        | Produto()          |

        | Produto(desc)      |

        | Produto(desc,val)  |

        +--------------------+

                 │

                 ▼

         Objetos diferentes
```

------------------------------------------------------------------------

# 💡 DICA DO PROFESSOR

``` text
╔════════════════════════════════════════════╗
║ Crie apenas construtores que realmente     ║
║ façam sentido para o problema de negócio.  ║
║                                            ║
║ Muitos construtores desnecessários tornam  ║
║ a classe difícil de manter.                ║
╚════════════════════════════════════════════╝
```

------------------------------------------------------------------------

# ⚠ ATENÇÃO

``` text
╔════════════════════════════════════════════╗
║ Não é permitido criar dois construtores    ║
║ exatamente iguais.                         ║
║                                            ║
║ Os parâmetros devem ser diferentes.        ║
╚════════════════════════════════════════════╝
```

------------------------------------------------------------------------

# Projeto Integrador

``` text
SistemaComercial
│
├── Cliente
│      ✔ 3 construtores
│
├── Produto
│      ✔ 3 construtores
│
└── Programa
       ✔ testes
```

------------------------------------------------------------------------

# Exercício Guiado

Adicione à classe `Fornecedor`:

-   construtor vazio;
-   construtor com nome;
-   construtor com nome e cidade.

Teste todos na classe `Programa`.

------------------------------------------------------------------------

# 📋 Resumo Visual

``` text
Classe
   │
   ▼
Construtor 1
Construtor 2
Construtor 3
   │
   ▼
Objetos adaptados
ao contexto
```

------------------------------------------------------------------------

# Preparação para a Parte 4

Na próxima parte você desenvolverá um mini projeto utilizando
construtores, resolverá exercícios em três níveis de dificuldade e
concluirá o capítulo com um quiz, glossário e checklist.
