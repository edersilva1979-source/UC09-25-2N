# 📘 Capítulo 4

# Parte 2.3A --- Criando o Método `conectar()`

## 🎯 Objetivos desta seção

Até este momento, nossa classe **Conexao** apenas armazenava informações
importantes, como a URL do banco, o usuário e a senha.

Agora ela começará a ganhar vida.

Nesta seção, criaremos a estrutura do método **`conectar()`**,
entenderemos cada palavra de sua declaração e aprenderemos como um
método funciona em Java.

Ao final desta aula, eu serei capaz de:

-   Criar um método em Java.
-   Compreender o significado de `public static`.
-   Entender por que o método retorna um objeto `Connection`.
-   Visualizar como a chamada do método acontece dentro da aplicação.
-   Preparar a implementação da conexão com o PostgreSQL.

------------------------------------------------------------------------

## 📖 Antes de começar...

Até agora, nossa classe parecia uma caixa contendo apenas informações.

``` text
┌────────────────────────────┐
│         Conexao            │
├────────────────────────────┤
│ URL                        │
│ USUARIO                    │
│ SENHA                      │
└────────────────────────────┘
```

Ela sabia **como** chegar ao banco de dados, mas ainda **não fazia
nada**.

Agora vamos ensinar essa classe a executar uma ação.

Essa ação será representada por um método.

------------------------------------------------------------------------

## 🧠 O que é um método?

Um método é um bloco de código criado para executar uma tarefa
específica.

Cada método possui uma responsabilidade.

Nosso método terá apenas uma missão:

> **Abrir uma conexão com o banco de dados.**

------------------------------------------------------------------------

## 🏢 Como isso acontece nas empresas?

Exemplos de nomes:

-   `conectar()`
-   `abrirConexao()`
-   `getConnection()`
-   `obterConexao()`

Neste curso utilizaremos:

``` java
conectar()
```

------------------------------------------------------------------------

## ✍️ Criando a assinatura do método

``` java
public static Connection conectar() {

}
```

------------------------------------------------------------------------

## 🔍 Entendendo cada palavra

### `public`

Permite que o método seja chamado por qualquer outra classe.

### `static`

Pertence à classe e não ao objeto.

``` java
Conexao.conectar();
```

### `Connection`

É o tipo de retorno do método.

### `conectar`

Representa a ação que o método executará.

### `()`

Indicam que é um método e, neste caso, ele não recebe parâmetros.

### `{ }`

Delimitam o bloco de código.

------------------------------------------------------------------------

## 🏛️ UML

``` text
┌─────────────────────────────────────────────┐
│                 Conexao                     │
├─────────────────────────────────────────────┤
│ - URL : String                             │
│ - USUARIO : String                         │
│ - SENHA : String                           │
├─────────────────────────────────────────────┤
│ + conectar() : Connection                  │
└─────────────────────────────────────────────┘
```

------------------------------------------------------------------------

## 🔄 Fluxograma

``` text
Tela Cadastro
      │
      ▼
Conexao.conectar()
      │
      ▼
Método conectar()
      │
      ▼
Objeto Connection
```

------------------------------------------------------------------------

## 🔬 Por baixo dos panos

A JVM registra o método como parte da classe, mas como ele ainda está
vazio, nenhuma ação é executada.

------------------------------------------------------------------------

## 💼 Como as empresas fazem?

Esse método normalmente:

1.  Lê as configurações.
2.  Solicita a conexão ao driver JDBC.
3.  Retorna um objeto `Connection`.

------------------------------------------------------------------------

## 🧪 Laboratório

Crie o método vazio e observe que o compilador reclama da ausência de
`return`.

------------------------------------------------------------------------

## ⚠️ Erros comuns

``` java
public static conectar() {}
```

ou

``` java
public static void conectar() {}
```

------------------------------------------------------------------------

## 💡 Dica do Professor

Pergunte sempre:

> O que este método deve devolver?

------------------------------------------------------------------------

## 🏆 Mini desafio

1.  Qual a responsabilidade do método?
2.  Por que ele é `static`?
3.  O que representa `Connection`?
4.  O que aconteceria se fosse `void`?

------------------------------------------------------------------------

## ✔️ Checklist

-   [ ] Criar a assinatura do método.
-   [ ] Explicar `public`.
-   [ ] Explicar `static`.
-   [ ] Entender `Connection`.

------------------------------------------------------------------------

## 🚀 Próxima etapa

Implementaremos:

``` java
DriverManager.getConnection(URL, USUARIO, SENHA);
```
