# 📘 Capítulo 4

# Parte 2.5 --- Revisão Geral e Encerramento da Etapa de Conexão

## 🎯 Objetivos

Nesta etapa farei uma revisão completa de tudo o que aprendi sobre a
conexão entre Java e PostgreSQL utilizando JDBC.

Ao final desta seção, eu serei capaz de:

-   Explicar o papel da classe `Conexao`.
-   Descrever o fluxo completo da conexão.
-   Identificar erros comuns.
-   Compreender como essa etapa será reutilizada durante todo o projeto.

------------------------------------------------------------------------

# 🧠 O caminho percorrido

Durante esta etapa construímos, passo a passo, a base da comunicação
entre a aplicação Java e o banco de dados.

Aprendi:

-   o que é JDBC;
-   como funcionam os imports do pacote `java.sql`;
-   como configurar URL, usuário e senha;
-   como criar o método `conectar()`;
-   como utilizar `DriverManager.getConnection()`;
-   como tratar exceções com `try`, `catch` e `SQLException`;
-   como retornar um objeto `Connection`;
-   como testar a conexão utilizando uma classe de teste.

------------------------------------------------------------------------

# 🏗️ Fluxo completo

``` text
Aplicação Java
      │
      ▼
Classe Conexao
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
Connection
      │
      ▼
Demais classes do sistema
```

------------------------------------------------------------------------

# 🏛️ Arquitetura final

``` text
Projeto

├── Conexao.java
├── TesteConexao.java
├── Aluno.java
├── TelaCadastro.java
└── TelaConsulta.java

Todas as classes utilizarão:

Conexao.conectar();
```

------------------------------------------------------------------------

# 💼 Boas práticas

-   Centralizar a conexão em uma única classe.
-   Evitar duplicação de código.
-   Tratar exceções adequadamente.
-   Validar se o retorno é diferente de `null`.
-   Fechar a conexão quando ela não for mais necessária.

------------------------------------------------------------------------

# ⚠️ Principais erros

-   Driver JDBC ausente.
-   URL incorreta.
-   Banco inexistente.
-   Usuário ou senha inválidos.
-   PostgreSQL desligado.
-   Esquecer de tratar exceções.

------------------------------------------------------------------------

# 🧪 Exercício de revisão

Responda:

1.  Qual é a responsabilidade da classe `Conexao`?
2.  Para que serve `DriverManager.getConnection()`?
3.  Qual é a função do bloco `try/catch`?
4.  O que significa retornar `null`?
5.  Por que devemos testar a conexão antes de criar as telas?

------------------------------------------------------------------------

# 🏆 Desafio Final

Crie uma nova classe de teste que:

-   abra a conexão;
-   informe se ela foi criada com sucesso;
-   exiba a data e hora do teste;
-   feche a conexão ao final;
-   trate possíveis exceções.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entendo o papel do JDBC.
-   [ ] Sei configurar a conexão.
-   [ ] Sei criar o método `conectar()`.
-   [ ] Sei testar a conexão.
-   [ ] Estou preparado para utilizar JDBC no restante do projeto.

------------------------------------------------------------------------

# 🎉 Conclusão

Parabéns!

Você concluiu uma das etapas mais importantes do desenvolvimento de
aplicações Java com banco de dados.

A partir deste ponto, toda operação de cadastro, consulta, alteração e
exclusão utilizará a classe `Conexao` criada neste capítulo.

Nos próximos capítulos, começaremos a construir as classes DAO e as
primeiras operações CRUD utilizando exatamente a infraestrutura
desenvolvida até aqui.
