# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 2 -- Programação Orientada a Objetos

## Parte 1 -- Entendendo a Programação Orientada a Objetos

> **Carga horária:** 3 horas\
> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# Objetivos de Aprendizagem

Ao concluir esta parte você será capaz de:

-   Entender o que é Programação Orientada a Objetos (POO).
-   Compreender por que esse paradigma surgiu.
-   Identificar objetos do mundo real e relacioná-los ao desenvolvimento
    de software.
-   Preparar-se para criar as primeiras classes do Projeto Integrador.

------------------------------------------------------------------------

# Competências Desenvolvidas

-   Pensamento lógico.
-   Abstração de problemas.
-   Modelagem de sistemas.
-   Comunicação técnica.
-   Organização de soluções utilizando objetos.

------------------------------------------------------------------------

# Introdução

Até o capítulo anterior escrevemos nosso primeiro programa.

Agora começaremos a aprender a forma como praticamente todos os sistemas
corporativos modernos são desenvolvidos.

Durante o restante do curso construiremos um sistema completo utilizando
Programação Orientada a Objetos.

------------------------------------------------------------------------

# O que é Programação Orientada a Objetos?

Programação Orientada a Objetos é um paradigma que organiza um software
utilizando elementos que representam objetos do mundo real.

Em vez de pensar apenas em linhas de código, pensamos primeiro nas
coisas que existem.

Exemplos:

-   Cliente
-   Produto
-   Funcionário
-   Venda
-   Fornecedor

Cada um desses elementos possui características e comportamentos.

Esses dois conceitos são a base da POO.

------------------------------------------------------------------------

# Um exemplo simples

Imagine um carro.

## Características

-   Cor
-   Marca
-   Modelo
-   Ano
-   Velocidade

## Comportamentos

-   Ligar
-   Frear
-   Acelerar
-   Virar

Representação:

``` text
CARRO

Características
├── Cor
├── Marca
├── Modelo
└── Ano

Comportamentos
├── Ligar
├── Frear
├── Acelerar
└── Virar
```

Na Programação Orientada a Objetos:

-   Características → Atributos
-   Comportamentos → Métodos

------------------------------------------------------------------------

# Outro exemplo: Bicicleta

Características:

-   Cor
-   Marca
-   Quantidade de marchas

Comportamentos:

-   Pedalar
-   Frear
-   Virar

Perceba que objetos diferentes possuem características e ações
diferentes.

------------------------------------------------------------------------

# Analogia da Casa

Antes de construir uma casa existe uma planta.

A planta descreve:

-   quantidade de quartos
-   portas
-   janelas
-   garagem

A planta ainda não é uma casa.

Ela é apenas um projeto.

Da mesma forma, na POO primeiro criamos o modelo e depois os objetos.

------------------------------------------------------------------------

# Analogia da Forma de Bolo

``` text
Forma
   │
   ▼
Bolo 1

Forma
   │
   ▼
Bolo 2

Forma
   │
   ▼
Bolo 3
```

Uma única forma produz vários bolos.

Mais adiante veremos que uma única classe poderá produzir muitos
objetos.

------------------------------------------------------------------------

# Um pouco de História

Na década de 1960 surgiram linguagens que organizavam programas apenas
em funções.

À medida que os sistemas cresceram, ficou difícil manter milhares de
linhas de código.

A Programação Orientada a Objetos surgiu para tornar os sistemas:

-   mais organizados;
-   reutilizáveis;
-   fáceis de manter;
-   fáceis de expandir.

Hoje esse paradigma é utilizado por linguagens como:

-   Java
-   C#
-   Kotlin
-   Swift
-   Python (entre outras)

------------------------------------------------------------------------

# Paradigma Estruturado × Orientado a Objetos

  Estruturado                              Orientado a Objetos
  ---------------------------------------- ------------------------------
  Foco em funções                          Foco em objetos
  Código centralizado                      Código organizado em classes
  Difícil manutenção em projetos grandes   Fácil expansão e manutenção
  Menor reutilização                       Grande reutilização

------------------------------------------------------------------------

# Onde a POO é utilizada?

Praticamente em qualquer sistema moderno.

Exemplos:

-   Internet Banking
-   Sistemas hospitalares
-   Sistemas escolares
-   Aplicativos de transporte
-   Redes sociais
-   Sistemas de estoque

Nosso Sistema Comercial seguirá exatamente esse modelo.

------------------------------------------------------------------------

# Projeto Integrador

Nas próximas partes criaremos as primeiras entidades.

``` text
Sistema Comercial

⬜ Cliente
⬜ Produto
⬜ Fornecedor
⬜ Venda
⬜ Usuário
```

Cada entidade será modelada como um objeto.

------------------------------------------------------------------------

# Curiosidade

Você provavelmente utiliza dezenas de programas orientados a objetos
todos os dias sem perceber.

Ao abrir um aplicativo de banco, por exemplo, existem objetos como:

-   Conta
-   Cliente
-   Cartão
-   Pix
-   Extrato

------------------------------------------------------------------------

# Dica do Professor

💡 Antes de escrever qualquer código, faça a seguinte pergunta:

"Quais objetos existem nesse problema?"

Essa simples pergunta ajuda a construir sistemas mais organizados.

------------------------------------------------------------------------

# Atenção

⚠ Um dos erros mais comuns dos iniciantes é pensar apenas em telas.

Primeiro modelamos os objetos.

Depois criamos a interface.

------------------------------------------------------------------------

# Resumo Visual

``` text
Mundo Real
      │
      ▼
Objetos
      │
      ▼
Características
      │
      ▼
Comportamentos
      │
      ▼
Programação Orientada a Objetos
```

------------------------------------------------------------------------

# Glossário

  Termo       Significado
  ----------- -------------------------------------------------
  Paradigma   Forma de pensar e resolver problemas
  Objeto      Representação de algo do mundo real
  Atributo    Característica de um objeto
  Método      Ação realizada por um objeto
  Modelagem   Processo de representar um problema em software

------------------------------------------------------------------------

# Checklist

-   [ ] Entendi o conceito de POO.
-   [ ] Sei identificar objetos do mundo real.
-   [ ] Entendi a diferença entre características e comportamentos.
-   [ ] Compreendi por que utilizamos POO.

------------------------------------------------------------------------

# Preparação para a Parte 2

Na próxima parte começaremos a construir efetivamente o Sistema
Comercial.

Você aprenderá:

-   O que é uma Classe.
-   O que é um Objeto.
-   O que é uma Instância.
-   Como criar as classes Cliente e Produto.
-   Como transformar conceitos do mundo real em código Java.
