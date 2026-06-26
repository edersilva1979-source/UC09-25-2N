# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 1 -- Preparação do Ambiente e Primeiro Projeto

## Parte 4 -- Exercícios, Desafios e Revisão Geral

------------------------------------------------------------------------

# Objetivos desta Parte

Ao finalizar esta etapa você deverá ser capaz de:

-   Criar e executar um projeto Java.
-   Explicar a função do método `main()`.
-   Interpretar a estrutura de um projeto Java.
-   Preparar-se para iniciar a Programação Orientada a Objetos.

------------------------------------------------------------------------

# Exercício Resolvido 1

## Objetivo

Criar um programa que apresente uma mensagem de boas-vindas.

``` java
public class SistemaComercial {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" SISTEMA COMERCIAL ");
        System.out.println(" Bem-vindo ao curso de Java!");
        System.out.println("================================");

    }

}
```

### Explicação

Cada chamada de `System.out.println()` escreve uma linha no console.

O método `main()` é executado automaticamente quando iniciamos a
aplicação.

------------------------------------------------------------------------

# Exercício Resolvido 2

## Apresentação do Desenvolvedor

``` java
public class Desenvolvedor {

    public static void main(String[] args) {

        System.out.println("Nome: João");
        System.out.println("Cidade: Novo Hamburgo");
        System.out.println("Curso: Desenvolvimento de Sistemas");
        System.out.println("Objetivo: Tornar-me Desenvolvedor Java.");

    }

}
```

Resultado esperado:

``` text
Nome: João
Cidade: Novo Hamburgo
Curso: Desenvolvimento de Sistemas
Objetivo: Tornar-me Desenvolvedor Java.
```

------------------------------------------------------------------------

# Exercícios de Fixação

## Nível 1

Crie um programa exibindo:

-   Nome
-   Idade
-   Cidade

------------------------------------------------------------------------

## Nível 2

Monte uma tela semelhante a:

``` text
*********************************
      SISTEMA COMERCIAL
*********************************

Versão: 1.0

Bem-vindo!

*********************************
```

------------------------------------------------------------------------

## Nível 3

Crie um programa que apresente:

-   Nome
-   Curso
-   Linguagem favorita
-   Objetivo profissional

Utilize pelo menos seis chamadas ao `System.out.println()`.

------------------------------------------------------------------------

# Desafio da Aula

Você foi contratado para iniciar o desenvolvimento do Sistema Comercial.

Nesta primeira versão o cliente deseja apenas uma tela de abertura.

Crie um programa que apresente:

``` text
====================================
      SISTEMA COMERCIAL
====================================

Empresa: ACME Comércio

Versão: 1.0

Desenvolvido por:
Seu Nome

====================================
```

------------------------------------------------------------------------

# Projeto Integrador

Situação atual:

``` text
Sistema Comercial

✔ Ambiente instalado

✔ Projeto criado

✔ Primeiro programa executado

⬜ Classe Cliente

⬜ Classe Produto

⬜ Cadastro de Clientes

⬜ Banco de Dados

⬜ Interface Gráfica

⬜ Relatórios
```

A partir do próximo capítulo começaremos a modelar as primeiras
entidades do sistema.

------------------------------------------------------------------------

# Erros Frequentes

## Erro 1

Esquecer o ponto e vírgula.

``` java
System.out.println("Olá")
```

Correto:

``` java
System.out.println("Olá");
```

------------------------------------------------------------------------

## Erro 2

Nome do arquivo diferente do nome da classe.

Arquivo:

``` text
Principal.java
```

Classe:

``` java
public class Programa
```

Esses nomes devem ser iguais.

------------------------------------------------------------------------

## Erro 3

Apagar o método `main()`.

Sem ele o Java não sabe por onde iniciar a aplicação.

------------------------------------------------------------------------

# Dicas do Professor

💡 Execute o programa sempre após pequenas alterações.

💡 Organize seus projetos em pastas.

💡 Leia cuidadosamente as mensagens de erro.

💡 Não tenha receio de experimentar novas mensagens no console.

------------------------------------------------------------------------

# Quiz

## 1

Qual ferramenta compila programas Java?

A)  PostgreSQL

B)  JDK

C)  pgAdmin

D)  NetBeans

Resposta: **B**

------------------------------------------------------------------------

## 2

Qual método inicia uma aplicação Java?

A)  iniciar()

B)  start()

C)  main()

D)  executar()

Resposta: **C**

------------------------------------------------------------------------

## 3

Qual ferramenta administra o PostgreSQL?

A)  MySQL

B)  Oracle

C)  pgAdmin

D)  Eclipse

Resposta: **C**

------------------------------------------------------------------------

## 4

Onde normalmente ficam os arquivos Java?

Resposta:

**Source Packages**

------------------------------------------------------------------------

## 5

O que faz o `System.out.println()`?

Resposta:

Exibe informações na saída padrão do programa.

------------------------------------------------------------------------

# Glossário

  Termo     Significado
  --------- ---------------------------------------
  Java      Linguagem de programação
  JDK       Kit de desenvolvimento Java
  JVM       Máquina Virtual Java
  IDE       Ambiente Integrado de Desenvolvimento
  Classe    Estrutura que contém código
  Método    Bloco de instruções
  main()    Ponto de entrada da aplicação
  Console   Área onde o programa exibe mensagens

------------------------------------------------------------------------

# Resumo Visual

``` text
Instalar Ambiente
        │
        ▼
Criar Projeto
        │
        ▼
Criar Classe
        │
        ▼
Criar main()
        │
        ▼
Escrever Código
        │
        ▼
Executar Programa
```

------------------------------------------------------------------------

# Checklist

Marque os itens concluídos.

-   [ ] Instalei o JDK.
-   [ ] Instalei o NetBeans.
-   [ ] Instalei o PostgreSQL.
-   [ ] Instalei o pgAdmin.
-   [ ] Criei o projeto SistemaComercial.
-   [ ] Executei meu primeiro programa.
-   [ ] Entendi a função do método `main()`.
-   [ ] Resolvi os exercícios.
-   [ ] Concluí o desafio.

------------------------------------------------------------------------

# Conclusão

Parabéns!

Você concluiu o primeiro capítulo do curso.

Agora seu ambiente está preparado e o Projeto Integrador foi iniciado.

No próximo capítulo estudaremos Programação Orientada a Objetos e
criaremos as primeiras classes do Sistema Comercial: **Cliente** e
**Produto**.
