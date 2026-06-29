# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 2 -- Programação Orientada a Objetos

## Parte 2 -- Classes, Objetos, Atributos e Métodos

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# Objetivos

Ao concluir esta parte você será capaz de:

-   Diferenciar classe e objeto.
-   Compreender o conceito de instância.
-   Criar atributos e métodos.
-   Desenvolver as primeiras classes do Projeto Integrador.

------------------------------------------------------------------------

# Relembrando

Na Parte 1 aprendemos que a POO representa objetos do mundo real.

Agora vamos transformar essa ideia em código Java.

------------------------------------------------------------------------

# O que é uma Classe?

Uma **classe** é um modelo ou molde utilizado para criar objetos.

Imagine uma fábrica de carros.

Antes de fabricar milhares de carros, existe um projeto.

Na programação acontece o mesmo.

``` text
Projeto
   │
   ▼
Classe
   │
   ▼
Objetos
```

------------------------------------------------------------------------

# Exemplo

Classe:

``` text
Cliente
```

Ela informa que todo cliente possui:

-   Nome
-   CPF
-   Telefone
-   Email

Ainda não existe nenhum cliente.

Existe apenas o modelo.

------------------------------------------------------------------------

# O que é um Objeto?

Um objeto é uma instância de uma classe.

Exemplo:

Classe:

``` text
Cliente
```

Objetos:

``` text
João
Maria
Carlos
Fernanda
```

Todos possuem a mesma estrutura, mas armazenam informações diferentes.

------------------------------------------------------------------------

# O que é uma Instância?

Instanciar significa criar um objeto a partir de uma classe.

``` text
Classe Cliente
      │
      ▼
new Cliente()
      │
      ▼
Objeto Cliente
```

Em Java utilizamos a palavra reservada `new`.

------------------------------------------------------------------------

# Primeira Classe do Projeto

Crie a classe `Cliente`.

``` java
public class Cliente {

}
```

Neste momento criamos apenas o molde.

------------------------------------------------------------------------

# Atributos

Atributos representam as características do objeto.

``` java
public class Cliente {

    String nome;
    String cpf;
    String telefone;
    String email;

}
```

Cada atributo armazenará uma informação.

------------------------------------------------------------------------

# Segunda Classe

Agora crie a classe `Produto`.

``` java
public class Produto {

    int codigo;
    String descricao;
    double valor;
    int estoque;

}
```

------------------------------------------------------------------------

# Métodos

Métodos representam ações.

Exemplo:

Um produto pode:

-   aumentar estoque;
-   diminuir estoque;
-   exibir informações.

``` java
public class Produto {

    String descricao;

    public void exibirProduto() {
        System.out.println(descricao);
    }

}
```

------------------------------------------------------------------------

# Código Comentado

``` java
public void exibirProduto() {
```

Declara um método público.

``` java
System.out.println(descricao);
```

Mostra a descrição do produto no console.

------------------------------------------------------------------------

# Criando Objetos

Classe principal:

``` java
public class Programa {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();

        cliente1.nome = "João";
        cliente1.cpf = "12345678900";
        cliente1.telefone = "(51)99999-9999";
        cliente1.email = "joao@email.com";

        System.out.println(cliente1.nome);

    }

}
```

------------------------------------------------------------------------

# Explicação Linha por Linha

``` java
Cliente cliente1
```

Tipo e nome da variável.

``` java
new Cliente()
```

Cria um objeto.

``` java
cliente1.nome = "João";
```

Atribui um valor ao atributo.

------------------------------------------------------------------------

# Criando Dois Objetos

``` java
Cliente cliente1 = new Cliente();
Cliente cliente2 = new Cliente();

cliente1.nome = "João";
cliente2.nome = "Maria";

System.out.println(cliente1.nome);
System.out.println(cliente2.nome);
```

Resultado:

``` text
João
Maria
```

Observe que ambos utilizam a mesma classe.

------------------------------------------------------------------------

# Projeto Integrador

Nossa estrutura agora começa a crescer.

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

------------------------------------------------------------------------

# Boas Práticas

-   Uma classe por arquivo.
-   Nome da classe iniciando com letra maiúscula.
-   Atributos com nomes significativos.
-   Organização em pacotes.

------------------------------------------------------------------------

# Erros Mais Comuns

❌ Criar vários objetos na mesma classe.

❌ Esquecer `new`.

❌ Escrever nomes sem significado.

❌ Misturar classes diferentes no mesmo arquivo.

------------------------------------------------------------------------

# Exercício Guiado

Crie a classe `Funcionario`.

Campos:

-   nome
-   cargo
-   salario
-   departamento

Depois crie um objeto e exiba seus dados.

------------------------------------------------------------------------

# Exercício Resolvido

Crie a classe `Fornecedor`.

``` java
public class Fornecedor {

    String nome;
    String cidade;

}
```

Programa:

``` java
Fornecedor fornecedor = new Fornecedor();

fornecedor.nome = "Tech Solutions";
fornecedor.cidade = "Porto Alegre";

System.out.println(fornecedor.nome);
System.out.println(fornecedor.cidade);
```

------------------------------------------------------------------------

# Resumo

``` text
Classe
   │
   ▼
Objeto
   │
   ▼
Atributos
   │
   ▼
Métodos
```

------------------------------------------------------------------------

# Preparação para a Parte 3

Na próxima parte aprenderemos:

-   Encapsulamento.
-   private.
-   public.
-   get.
-   set.
-   this.
-   Organização profissional das classes.
