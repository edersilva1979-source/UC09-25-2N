# 📘 Capítulo 4

# Parte 3.2 --- Criando o Método `cadastrar()` (INSERT)

## 🎯 Objetivos

Nesta etapa implementarei o primeiro método da classe `AlunoDAO`: o
método `cadastrar()`. Ele será responsável por inserir um novo aluno na
tabela **alunos** utilizando JDBC e `PreparedStatement`.

Ao final desta seção, eu serei capaz de:

-   Criar o método `cadastrar(Aluno aluno)`;
-   Utilizar `PreparedStatement`;
-   Escrever um comando `INSERT`;
-   Executar a gravação no PostgreSQL;
-   Entender cada linha do código.

------------------------------------------------------------------------

# 📖 Por que usar `PreparedStatement`?

O `PreparedStatement` permite executar comandos SQL com parâmetros de
forma organizada e mais segura.

Em vez de concatenar valores diretamente na SQL, utilizamos o caractere
`?` como marcador de posição.

Exemplo:

``` sql
INSERT INTO alunos (nome, turma, email)
VALUES (?, ?, ?);
```

------------------------------------------------------------------------

# 📦 Imports necessários

``` java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
```

------------------------------------------------------------------------

# 🧩 Método completo

``` java
public void cadastrar(Aluno aluno) {

    String sql =
        "INSERT INTO alunos (nome, turma, email) VALUES (?, ?, ?)";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getTurma());
        stmt.setString(3, aluno.getEmail());

        stmt.executeUpdate();

        System.out.println("Aluno cadastrado com sucesso!");

        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println("Erro ao cadastrar: " + erro.getMessage());

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando cada etapa

## 1️⃣ SQL

``` java
String sql = "...";
```

Armazena o comando SQL que será enviado ao PostgreSQL.

## 2️⃣ Abrindo a conexão

``` java
Connection conexao = Conexao.conectar();
```

Solicita uma conexão pronta para uso.

## 3️⃣ Preparando o comando

``` java
PreparedStatement stmt =
        conexao.prepareStatement(sql);
```

O JDBC prepara o comando antes de executá-lo.

## 4️⃣ Preenchendo os parâmetros

``` java
stmt.setString(1, aluno.getNome());
```

Cada `?` recebe um valor correspondente.

## 5️⃣ Executando

``` java
stmt.executeUpdate();
```

Executa o `INSERT` no banco de dados.

## 6️⃣ Fechando recursos

``` java
stmt.close();
conexao.close();
```

Libera os recursos utilizados pela aplicação.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Tela Cadastro
      │
      ▼
Objeto Aluno
      │
      ▼
AlunoDAO.cadastrar()
      │
      ▼
PreparedStatement
      │
      ▼
INSERT
      │
      ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `executeUpdate()` é chamado, o driver JDBC envia o comando SQL ao
PostgreSQL.

Se a operação for concluída com sucesso, uma linha será adicionada à
tabela `alunos`.

------------------------------------------------------------------------

# 💼 Boas práticas

-   Utilize `PreparedStatement` em vez de concatenar SQL.
-   Feche `PreparedStatement` e `Connection`.
-   Trate exceções com `try/catch`.
-   Mantenha os comandos SQL centralizados no DAO.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer de preencher algum parâmetro.
-   Informar a ordem incorreta dos parâmetros.
-   Não fechar a conexão.
-   Esquecer de executar `executeUpdate()`.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Crie um objeto `Aluno`.
2.  Preencha nome, turma e e-mail.
3.  Chame `cadastrar(aluno)`.
4.  Consulte a tabela `alunos` no pgAdmin e confirme a inserção do
    registro.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre teste uma operação de cada vez. Primeiro confirme que o cadastro
funciona antes de avançar para consultas, alterações e exclusões.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Aluno
   │
AlunoDAO.cadastrar()
   │
PreparedStatement
   │
executeUpdate()
   │
Novo registro na tabela alunos
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Modifique a entidade `Aluno` para incluir o campo **telefone** e adapte
o comando `INSERT` para gravar essa nova informação.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o método `cadastrar()`.
-   [ ] Utilizar `PreparedStatement`.
-   [ ] Executar `INSERT`.
-   [ ] Fechar conexão e comando.
-   [ ] Confirmar a gravação no PostgreSQL.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.3**, criaremos uma classe de teste para cadastrar alunos e
validaremos os primeiros registros inseridos no banco de dados.
