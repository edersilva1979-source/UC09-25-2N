# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 2 -- Programação Orientada a Objetos

## Parte 3 -- Encapsulamento na Prática

> **Projeto Integrador:** Sistema Comercial

------------------------------------------------------------------------

# Objetivos

Ao concluir esta parte você será capaz de:

-   Entender o conceito de encapsulamento.
-   Utilizar atributos `private`.
-   Criar métodos `get` e `set`.
-   Compreender o uso da palavra reservada `this`.
-   Aplicar boas práticas na modelagem das classes.

------------------------------------------------------------------------

# O que é Encapsulamento?

Encapsular significa **proteger os dados de um objeto**, permitindo que
eles sejam acessados de maneira controlada.

Imagine um automóvel.

Você consegue acelerar, frear e ligar o carro, mas não precisa manipular
diretamente o motor para isso.

``` text
Motor
   ▲
   │ Protegido
   │
Painel e Pedais
```

Na programação fazemos exatamente a mesma coisa.

------------------------------------------------------------------------

# Problema dos Atributos Públicos

Considere a classe abaixo:

``` java
public class Cliente {

    public String nome;
    public String cpf;

}
```

Qualquer parte do programa pode alterar esses dados.

``` java
cliente.nome = "";
cliente.cpf = null;
```

Isso pode gerar informações inválidas.

⚠ Quanto maior o sistema, maior o risco de erros.

------------------------------------------------------------------------

# Utilizando private

Agora vamos proteger os atributos.

``` java
public class Cliente {

    private String nome;
    private String cpf;

}
```

Agora eles não podem mais ser alterados diretamente.

------------------------------------------------------------------------

# Como acessar os dados?

Utilizamos métodos públicos.

## Método set

Serve para alterar um valor.

``` java
public void setNome(String nome){

    this.nome = nome;

}
```

### Explicação

``` java
this.nome
```

Refere-se ao atributo da classe.

``` java
nome
```

É o parâmetro recebido pelo método.

------------------------------------------------------------------------

## Método get

Serve para obter um valor.

``` java
public String getNome(){

    return nome;

}
```

Agora qualquer outra classe pode consultar o nome do cliente sem acessar
diretamente o atributo.

------------------------------------------------------------------------

# O que significa this?

A palavra reservada `this` representa o próprio objeto.

Exemplo:

``` java
public void setDescricao(String descricao){

    this.descricao = descricao;

}
```

Visualmente:

``` text
Parâmetro recebido
        │
descricao
        │
        ▼
this.descricao
Atributo da classe
```

O `this` elimina ambiguidades quando o parâmetro possui o mesmo nome do
atributo.

------------------------------------------------------------------------

# Comparando os Dois Modelos

## Sem Encapsulamento

``` java
cliente.nome = "Maria";
```

## Com Encapsulamento

``` java
cliente.setNome("Maria");
```

Consultar:

``` java
System.out.println(cliente.getNome());
```

A segunda abordagem é mais segura e organizada.

------------------------------------------------------------------------

# Evoluindo a Classe Cliente

``` java
public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
```

O mesmo padrão será utilizado para todos os atributos.

------------------------------------------------------------------------

# Evoluindo a Classe Produto

``` java
public class Produto {

    private int codigo;
    private String descricao;
    private double valor;
    private int estoque;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
```

------------------------------------------------------------------------

# Testando no Programa Principal

``` java
public class Programa {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        cliente.setNome("João Silva");

        System.out.println(cliente.getNome());

    }

}
```

Resultado:

``` text
João Silva
```

------------------------------------------------------------------------

# Organização do Projeto

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

Cada classe possui uma única responsabilidade.

------------------------------------------------------------------------

# Boas Práticas

-   Utilize sempre atributos `private`.
-   Crie `get` e `set` apenas quando necessários.
-   Dê nomes claros aos métodos.
-   Evite alterar atributos diretamente.

------------------------------------------------------------------------

# Erros Mais Comuns

❌ Esquecer o `this`.

❌ Retornar o atributo errado no método `get`.

❌ Criar métodos `set` sem necessidade.

❌ Deixar atributos públicos.

------------------------------------------------------------------------

# Exercício Guiado

Atualize a classe `Funcionario`.

1.  Transforme todos os atributos em `private`.
2.  Crie os métodos `get` e `set`.
3.  Teste a classe utilizando a classe `Programa`.

------------------------------------------------------------------------

# Exercício Resolvido

Classe `Fornecedor`.

``` java
public class Fornecedor {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
```

Uso:

``` java
Fornecedor fornecedor = new Fornecedor();

fornecedor.setNome("ABC Tecnologia");

System.out.println(fornecedor.getNome());
```

------------------------------------------------------------------------

# Resumo Visual

``` text
Atributo private
        │
        ▼
Método set()
        │
        ▼
Objeto
        │
        ▼
Método get()
```

------------------------------------------------------------------------

# Preparação para a Parte 4

Na próxima parte você irá:

-   Consolidar os conceitos de POO.
-   Resolver exercícios em níveis de dificuldade.
-   Avançar no Projeto Integrador.
-   Responder ao quiz do capítulo.
-   Concluir o Capítulo 2 com um resumo geral.
