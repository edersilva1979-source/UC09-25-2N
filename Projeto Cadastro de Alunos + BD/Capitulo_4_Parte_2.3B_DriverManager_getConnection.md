# 📘 Capítulo 4

# Parte 2.3B --- Entendendo `DriverManager.getConnection()`

## 🎯 Objetivos

Nesta etapa vou implementar a instrução responsável por solicitar ao
JDBC uma conexão com o PostgreSQL.

Ao final desta seção eu serei capaz de:

-   Entender o método `DriverManager.getConnection()`.
-   Compreender o papel da URL, usuário e senha.
-   Saber como o JDBC localiza o driver.
-   Visualizar o fluxo da criação da conexão.

------------------------------------------------------------------------

# 📖 A linha mais importante da classe

``` java
Connection conexao =
    DriverManager.getConnection(URL, USUARIO, SENHA);
```

Essa instrução solicita ao JDBC que abra uma conexão com o banco de
dados.

------------------------------------------------------------------------

# 🔍 Entendendo cada parte

## `DriverManager`

É a classe responsável por localizar um driver JDBC compatível com a URL
informada.

Podemos imaginá-lo como um intermediador entre a aplicação Java e o
banco de dados.

------------------------------------------------------------------------

## `getConnection()`

É o método que solicita uma nova conexão.

Ao ser executado, ele utiliza:

-   a URL do banco;
-   o usuário;
-   a senha.

------------------------------------------------------------------------

## `URL`

Exemplo:

``` text
jdbc:postgresql://localhost:5432/escola
```

Ela informa:

-   tecnologia JDBC;
-   banco PostgreSQL;
-   servidor (`localhost`);
-   porta (`5432`);
-   banco (`escola`).

------------------------------------------------------------------------

## `USUARIO`

Exemplo:

``` java
postgres
```

É a conta utilizada para autenticação.

------------------------------------------------------------------------

## `SENHA`

É a senha correspondente ao usuário informado.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Aplicação Java
      │
      ▼
DriverManager.getConnection()
      │
      ▼
Driver JDBC PostgreSQL
      │
      ▼
Servidor PostgreSQL
      │
      ▼
Connection criada
```

------------------------------------------------------------------------

# 🧠 Por baixo dos panos

Quando `getConnection()` é chamado:

1.  O DriverManager identifica o driver compatível.
2.  O driver interpreta a URL.
3.  Uma tentativa de conexão é realizada.
4.  O servidor valida usuário e senha.
5.  Se tudo estiver correto, um objeto `Connection` é criado e
    devolvido.

------------------------------------------------------------------------

# 🏛️ Diagrama

``` text
┌──────────────┐
│ Aplicação    │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│DriverManager │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Driver JDBC  │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ PostgreSQL   │
└──────────────┘
```

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em projetos modernos, normalmente não chamamos `DriverManager`
diretamente em toda a aplicação.

Essa chamada costuma ficar centralizada em uma classe de conexão ou em
um pool de conexões, permitindo reutilização e melhor desempenho.

------------------------------------------------------------------------

# 🧪 Laboratório

Experimente alterar o nome do banco:

``` text
escola
```

para

``` text
escola_teste
```

Quando executarmos a conexão, será gerada uma exceção indicando que o
banco não foi encontrado.

Depois retorne ao valor original.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   URL incorreta.
-   Porta errada.
-   Banco inexistente.
-   Usuário inválido.
-   Senha incorreta.
-   Driver JDBC não adicionado ao projeto.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre confira primeiro:

1.  URL;
2.  Nome do banco;
3.  Usuário;
4.  Senha;
5.  Driver JDBC.

Na maioria dos casos, o problema está em um desses itens.

------------------------------------------------------------------------

# 📝 Resumo

``` text
DriverManager
        │
        ▼
getConnection()
        │
        ▼
URL + Usuário + Senha
        │
        ▼
Connection
```

------------------------------------------------------------------------

# 🏆 Mini desafio

1.  Qual é a função do `DriverManager`?
2.  O que faz `getConnection()`?
3.  Quais informações são obrigatórias para abrir uma conexão?
4.  O que acontece se o banco não existir?

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o papel do DriverManager.
-   [ ] Explicar `getConnection()`.
-   [ ] Identificar URL, usuário e senha.
-   [ ] Interpretar o fluxo de criação da conexão.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na Parte **2.3C**, implementarei o bloco `try/catch` para tratar
possíveis erros de conexão utilizando `SQLException`.
