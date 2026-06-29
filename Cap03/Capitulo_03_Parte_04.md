# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 3 -- Construtores

## Parte 4 -- Mini Projeto, Exercícios e Consolidação

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# 🎯 Objetivos

Ao concluir esta parte você será capaz de:

-   Aplicar construtores em um projeto real.
-   Escolher o construtor adequado para cada situação.
-   Consolidar o uso da sobrecarga.
-   Evoluir o Sistema Comercial.

------------------------------------------------------------------------

# 📷 Figura 3.4 -- Evolução do Projeto Integrador

``` text
                 SISTEMA COMERCIAL

     ┌────────────────────────────────────┐
     │ Cliente        ✔ Construtores       │
     │ Produto        ✔ Construtores       │
     │ Fornecedor     ✔ Construtores       │
     │ Programa       ✔ Testes             │
     └────────────────────────────────────┘
                    │
                    ▼
          Próximo capítulo: ArrayList
```

------------------------------------------------------------------------

# 🧩 Mini Projeto

## Cenário

Uma loja deseja iniciar o cadastro de clientes e produtos.

Todo cliente deverá ser criado já contendo:

-   Nome
-   CPF

Todo produto deverá ser criado já contendo:

-   Descrição
-   Valor

------------------------------------------------------------------------

# 📊 Diagrama de Classes

``` text
+-------------------------+
|        Cliente          |
+-------------------------+
| nome : String           |
| cpf : String            |
+-------------------------+
| Cliente(nome, cpf)      |
+-------------------------+

           1..*

+-------------------------+
|        Produto          |
+-------------------------+
| descricao : String      |
| valor : double          |
+-------------------------+
| Produto(desc, valor)    |
+-------------------------+
```

------------------------------------------------------------------------

# 💻 Implementação

``` java
public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
```

## Comentário linha por linha

``` java
private String nome;
```

Armazena o nome do cliente.

``` java
public Cliente(String nome, String cpf)
```

Garante que o objeto seja criado com as informações essenciais.

``` java
this.nome = nome;
```

Atribui o valor recebido ao atributo da classe.

------------------------------------------------------------------------

# Classe Produto

``` java
public class Produto {

    private String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
```

------------------------------------------------------------------------

# Classe Programa

``` java
public class Programa {

    public static void main(String[] args) {

        Cliente cliente =
            new Cliente("Maria Souza","12345678900");

        Produto notebook =
            new Produto("Notebook",4599.90);

        System.out.println(cliente.getNome());
        System.out.println(notebook.getDescricao());
        System.out.println(notebook.getValor());

    }
}
```

------------------------------------------------------------------------

# 📖 Estudo de Caso

## Sistema Hospitalar

Ao registrar um paciente:

``` text
Paciente
 ├── Nome
 ├── Prontuário
 ├── Data de internação
 └── Leito
```

Essas informações são obrigatórias e podem ser inicializadas pelo
construtor, reduzindo a chance de registros incompletos.

------------------------------------------------------------------------

# 🧠 Mini Desafio

Você criaria um construtor para uma classe **Venda** sem receber um
cliente?

Explique sua resposta antes de escrever qualquer código.

------------------------------------------------------------------------

# 💡 DICA DO PROFESSOR

``` text
╔══════════════════════════════════════════╗
║ Pergunte sempre:                         ║
║ "Quais informações são obrigatórias?"    ║
║                                          ║
║ Essas informações normalmente pertencem  ║
║ ao construtor.                           ║
╚══════════════════════════════════════════╝
```

------------------------------------------------------------------------

# ⚠️ ATENÇÃO

``` text
╔══════════════════════════════════════════╗
║ Evite criar construtores enormes com     ║
║ muitos parâmetros.                       ║
║                                          ║
║ Isso costuma indicar que a classe está   ║
║ assumindo responsabilidades em excesso.  ║
╚══════════════════════════════════════════╝
```

------------------------------------------------------------------------

# 📝 Exercícios

## ⭐ Básico

Crie uma classe `Categoria` com um construtor que receba a descrição.

## ⭐⭐ Intermediário

Crie uma classe `Fornecedor` com:

-   construtor vazio;
-   construtor com nome;
-   construtor com nome e cidade.

## ⭐⭐⭐ Avançado

Modele uma classe `Funcionario` com sobrecarga de construtores e teste
cada versão na classe `Programa`.

------------------------------------------------------------------------

# 🚀 Desafio Final

Evolua o Sistema Comercial adicionando:

-   Cliente
-   Produto
-   Fornecedor
-   Categoria

Todos utilizando construtores apropriados.

------------------------------------------------------------------------

# ❓ Quiz

1.  O que é um construtor?
2.  Quando ele é executado?
3.  Qual palavra cria um objeto?
4.  Um construtor possui retorno?
5.  O que é sobrecarga?
6.  Dois construtores podem ter a mesma assinatura?
7.  Para que serve `this`?
8.  Quando usar um construtor personalizado?
9.  Por que encapsulamento e construtores trabalham juntos?
10. Qual vantagem de iniciar um objeto já preenchido?

> **Gabarito resumido:** 1. Inicializa objetos. 2. Na criação. 3. `new`.
> 4. Não. 5. Múltiplos construtores com parâmetros diferentes. 6. Não.
> 7. Referenciar o objeto atual. 8. Quando há dados obrigatórios. 9.
> Segurança e consistência. 10. Evita objetos inválidos.

------------------------------------------------------------------------

# 📚 Glossário

  Termo           Definição
  --------------- --------------------------------------
  Construtor      Bloco executado na criação do objeto
  Sobrecarga      Várias versões do mesmo construtor
  Assinatura      Nome e lista de parâmetros
  Instância       Objeto criado a partir de uma classe
  Inicialização   Preparação do objeto para uso

------------------------------------------------------------------------

# 📋 Resumo Visual

``` text
Classe
   │
   ▼
Construtor
   │
   ▼
Objeto consistente
   │
   ▼
Métodos
   │
   ▼
Sistema Comercial
```

------------------------------------------------------------------------

# ✅ Checklist

-   [ ] Sei criar construtores.
-   [ ] Sei criar sobrecarga.
-   [ ] Entendi a diferença entre método e construtor.
-   [ ] Sei utilizar `this`.
-   [ ] Resolvi os exercícios.
-   [ ] Concluí o mini projeto.

------------------------------------------------------------------------

# 🏁 Encerramento

Você concluiu o estudo de construtores, um dos pilares da Programação
Orientada a Objetos.

No próximo capítulo iniciaremos o uso de **ArrayList**, permitindo
armazenar vários objetos em memória e dando os primeiros passos para
construir um CRUD completo do Sistema Comercial.
