# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 1 -- Preparação do Ambiente e Primeiro Projeto

## Parte 3 -- Criando o Primeiro Projeto Java

> **Objetivo:** criar o primeiro projeto do curso, compreender sua
> estrutura e escrever o primeiro programa do Projeto Integrador.

------------------------------------------------------------------------

# Introdução

Agora que o ambiente está instalado, vamos criar nosso primeiro projeto
em Java.

Este será o início do **Sistema Comercial**, que evoluirá ao longo das
próximas aulas.

------------------------------------------------------------------------

# Criando um Projeto no NetBeans

No menu principal:

1.  **File**
2.  **New Project**
3.  **Java with Ant** (ou a categoria correspondente à versão instalada)
4.  **Java Application**
5.  Nome do projeto: `SistemaComercial`

Clique em **Finish**.

💡 **Dica:** utilize nomes claros e sem espaços.

------------------------------------------------------------------------

# Estrutura de um Projeto Java

Após a criação, observe a árvore de arquivos.

``` text
SistemaComercial
│
├── Source Packages
│   └── sistemacomercial
│       └── SistemaComercial.java
├── Libraries
└── Test Libraries
```

Cada elemento possui uma função específica.

  Item              Função
  ----------------- ------------------------
  Source Packages   Guarda o código-fonte
  Libraries         Bibliotecas utilizadas
  Test Libraries    Arquivos para testes

------------------------------------------------------------------------

# O que é uma Classe?

Em Java, todo programa é organizado em classes.

Nossa primeira classe será:

``` java
public class SistemaComercial {

}
```

Uma classe funciona como um contêiner para atributos e métodos.

------------------------------------------------------------------------

# O método main()

Todo programa Java inicia pelo método `main()`.

``` java
public static void main(String[] args) {

}
```

Sem esse método, o Java não sabe por onde começar a execução.

------------------------------------------------------------------------

# Primeiro Programa

Digite o código abaixo:

``` java
public class SistemaComercial {

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Sistema Comercial!");

    }

}
```

Execute pressionando **F6**.

Resultado esperado:

``` text
Bem-vindo ao Sistema Comercial!
```

------------------------------------------------------------------------

# Entendendo o Código Linha por Linha

## Linha 1

``` java
public class SistemaComercial {
```

Declara uma classe pública chamada `SistemaComercial`.

------------------------------------------------------------------------

## Linha 2

``` java
public static void main(String[] args) {
```

É o ponto de entrada da aplicação.

Explicação:

-   `public`: acessível pelo Java.
-   `static`: pode ser executado sem criar um objeto.
-   `void`: não retorna valor.
-   `main`: método principal.
-   `String[] args`: recebe parâmetros da linha de comando.

------------------------------------------------------------------------

## Linha 3

``` java
System.out.println("Bem-vindo ao Sistema Comercial!");
```

Exibe uma mensagem no console.

`System.out` representa a saída padrão do programa.

`println` imprime o texto e pula para a próxima linha.

------------------------------------------------------------------------

# Alterando o Programa

Experimente modificar o código.

``` java
System.out.println("Curso de Desenvolvimento de Sistemas");
System.out.println("Projeto Integrador");
System.out.println("Aluno: Seu Nome");
```

Resultado:

``` text
Curso de Desenvolvimento de Sistemas
Projeto Integrador
Aluno: Seu Nome
```

------------------------------------------------------------------------

# Comentários no Código

Comentários ajudam a documentar o programa.

Comentário de uma linha:

``` java
// Exibe uma mensagem
System.out.println("Olá");
```

Comentário de várias linhas:

``` java
/*
Primeiro programa
do curso.
*/
```

⚠ Evite comentários desnecessários. O código deve ser claro por si só.

------------------------------------------------------------------------

# Boas Práticas

-   Uma classe por arquivo.
-   Nome das classes iniciando com letra maiúscula.
-   Indente corretamente o código.
-   Salve o projeto frequentemente.
-   Execute o programa sempre após pequenas alterações.

------------------------------------------------------------------------

# Exercício Guiado

Altere o programa para exibir:

``` text
********************************
Sistema Comercial
Versão 1.0
Bem-vindo!
********************************
```

Utilize várias chamadas ao `System.out.println()`.

------------------------------------------------------------------------

# Exercício Progressivo

Crie um novo programa que apresente:

-   Nome
-   Cidade
-   Curso
-   Objetivo profissional

Exemplo:

``` text
Nome: Ana
Cidade: Porto Alegre
Curso: Desenvolvimento de Sistemas
Objetivo: Desenvolver aplicações Java.
```

------------------------------------------------------------------------

# Conectando ao Projeto Integrador

Nesta aula ainda não criaremos telas ou banco de dados.

Nosso objetivo foi iniciar o projeto que receberá novos módulos nas
próximas aulas.

Evolução:

``` text
Capítulo 1
✔ Projeto criado

Capítulo 2
⬜ Classe Cliente

Capítulo 3
⬜ Classe Produto

Capítulo 4
⬜ Construtores

...
```

------------------------------------------------------------------------

# Dicas do Professor

💡 Leia cada mensagem de erro com atenção.

Grande parte dos erros informa exatamente o problema e a linha onde ele
ocorreu.

------------------------------------------------------------------------

# Erros Mais Comuns

❌ Esquecer ponto e vírgula.

❌ Esquecer chaves.

❌ Digitar o nome da classe diferente do nome do arquivo.

❌ Alterar o método `main()` incorretamente.

------------------------------------------------------------------------

# Resumo da Parte 3

Nesta etapa você aprendeu:

-   Como criar um projeto Java.
-   Como é organizada sua estrutura.
-   O papel das classes.
-   O funcionamento do método `main()`.
-   Como escrever e executar o primeiro programa.

Na Parte 4 encerraremos o capítulo com exercícios resolvidos, desafios,
quiz, glossário, checklist e uma revisão geral.
