# 📘 Capítulo 4

# Parte 3.6 --- Consultando um Aluno por ID com `PreparedStatement`

## 🎯 Objetivos

Nesta etapa vou implementar uma consulta específica por **ID**,
permitindo localizar apenas um aluno utilizando um parâmetro informado
pelo usuário.

Ao final desta seção, eu serei capaz de:

-   Criar o método `localizar(int id)`;
-   Utilizar parâmetros em consultas SQL;
-   Trabalhar com `PreparedStatement` e `ResultSet`;
-   Verificar se um registro foi encontrado;
-   Exibir os dados do aluno localizado.

------------------------------------------------------------------------

# 📖 Por que pesquisar por ID?

O ID identifica um registro de forma única.

Enquanto o comando:

``` sql
SELECT * FROM alunos;
```

retorna todos os registros, a consulta abaixo retorna apenas um aluno.

``` sql
SELECT * FROM alunos WHERE id = ?;
```

O caractere `?` será substituído pelo ID informado.

------------------------------------------------------------------------

# 📦 Imports necessários

``` java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
```

------------------------------------------------------------------------

# 💻 Método completo

``` java
public void localizar(int id) {

    String sql = "SELECT * FROM alunos WHERE id = ?";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Turma: " + rs.getString("turma"));
            System.out.println("E-mail: " + rs.getString("email"));

        } else {

            System.out.println("Aluno não encontrado.");

        }

        rs.close();
        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println("Erro na consulta: " + erro.getMessage());

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando cada etapa

## SQL parametrizada

``` java
SELECT * FROM alunos WHERE id = ?
```

O símbolo `?` funciona como um espaço reservado.

------------------------------------------------------------------------

## Preenchendo o parâmetro

``` java
stmt.setInt(1, id);
```

O primeiro parâmetro (`1`) recebe o valor da variável `id`.

------------------------------------------------------------------------

## Executando a consulta

``` java
ResultSet rs = stmt.executeQuery();
```

O banco retorna um conjunto de resultados.

------------------------------------------------------------------------

## Verificando se encontrou

``` java
if (rs.next())
```

Se existir um registro, o cursor avança para a primeira linha e os dados
podem ser lidos.

Caso contrário, nenhuma linha foi encontrada.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Receber ID
    │
    ▼
PreparedStatement
    │
    ▼
SELECT ... WHERE id = ?
    │
    ▼
executeQuery()
    │
    ▼
ResultSet
    │
 ┌──┴──────────────┐
 │                 │
Encontrou?       Não encontrou
 │                 │
 ▼                 ▼
Exibe dados   Mensagem ao usuário
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `setInt()` é chamado, o JDBC substitui o `?` pelo valor informado
antes de enviar o comando ao PostgreSQL.

Esse mecanismo torna o código mais organizado e ajuda a evitar ataques
de **SQL Injection**, pois os valores são tratados separadamente do
comando SQL.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Consultas por ID são extremamente comuns em sistemas corporativos.

Normalmente elas são utilizadas antes de alterar ou excluir um registro,
garantindo que o dado realmente exista.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer de chamar `setInt()`.
-   Utilizar um índice incorreto no parâmetro.
-   Tentar ler o `ResultSet` sem executar `rs.next()`.
-   Não tratar o caso em que nenhum registro é encontrado.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Cadastre alguns alunos.
2.  Execute `localizar(1);`.
3.  Execute `localizar(999);`.
4.  Compare os resultados obtidos.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre informe ao usuário quando nenhum registro for encontrado. Isso
torna a aplicação mais clara e facilita a identificação de problemas.

------------------------------------------------------------------------

# 📝 Resumo

``` text
ID informado
      │
      ▼
PreparedStatement
      │
      ▼
SELECT ... WHERE id = ?
      │
      ▼
ResultSet
      │
      ▼
Registro encontrado ou mensagem de ausência
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Crie um método semelhante para localizar um aluno pelo **e-mail**,
utilizando:

``` sql
SELECT * FROM alunos WHERE email = ?;
```

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o método `localizar(int id)`.
-   [ ] Utilizar `PreparedStatement` com parâmetros.
-   [ ] Executar `executeQuery()`.
-   [ ] Verificar `rs.next()`.
-   [ ] Exibir o registro encontrado.
-   [ ] Tratar o caso em que o aluno não existe.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.7**, criarei uma classe de teste para executar o método
`localizar(int id)` e validar pesquisas específicas antes de implementar
as operações de alteração (`UPDATE`) e exclusão (`DELETE`).
