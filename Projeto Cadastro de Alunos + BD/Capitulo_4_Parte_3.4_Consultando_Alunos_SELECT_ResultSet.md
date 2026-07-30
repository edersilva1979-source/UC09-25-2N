# 📘 Capítulo 4

# Parte 3.4 --- Consultando Alunos com `SELECT` e `ResultSet`

## 🎯 Objetivos

Nesta etapa criarei o primeiro método de consulta da classe `AlunoDAO`,
utilizando o comando **SELECT** e a classe **ResultSet** para recuperar
dados armazenados no PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Entender o funcionamento do comando `SELECT`;
-   Utilizar `PreparedStatement` em consultas;
-   Trabalhar com `ResultSet`;
-   Percorrer os registros retornados;
-   Exibir os dados no console.

------------------------------------------------------------------------

# 📖 O que é `ResultSet`?

O `ResultSet` representa o conjunto de registros retornado por uma
consulta SQL.

Quando executamos:

``` sql
SELECT * FROM alunos;
```

o PostgreSQL devolve uma tabela de resultados. No Java, essa tabela é
representada por um objeto `ResultSet`.

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
public void listar() {

    String sql = "SELECT * FROM alunos";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            System.out.println("------------------------");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Turma: " + rs.getString("turma"));
            System.out.println("E-mail: " + rs.getString("email"));

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

## SQL

``` java
String sql = "SELECT * FROM alunos";
```

Seleciona todos os registros da tabela.

## Executando a consulta

``` java
ResultSet rs = stmt.executeQuery();
```

`executeQuery()` é utilizado para comandos que retornam dados.

## Percorrendo os registros

``` java
while (rs.next())
```

Cada chamada de `next()` avança para o próximo registro. Enquanto
existirem linhas, o laço continuará executando.

## Obtendo os valores

``` java
rs.getInt("id");
rs.getString("nome");
```

Os métodos `get...()` recuperam os valores de cada coluna.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
listar()
    │
    ▼
SELECT * FROM alunos
    │
    ▼
executeQuery()
    │
    ▼
ResultSet
    │
    ▼
while(rs.next())
    │
    ▼
Exibir registros
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

O JDBC envia o comando SQL ao PostgreSQL.

O banco retorna uma tabela com os resultados.

O driver JDBC converte essa tabela em um objeto `ResultSet`, permitindo
que a aplicação percorra cada linha individualmente.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

É comum que o DAO transforme cada linha do `ResultSet` em um objeto
Java.

Em aplicações maiores, o método `listar()` normalmente retorna uma lista
de objetos (`List<Aluno>`) em vez de imprimir os dados diretamente no
console.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Utilizar `executeUpdate()` em um `SELECT`.
-   Esquecer de chamar `rs.next()`.
-   Informar nomes de colunas incorretos.
-   Não fechar `ResultSet`, `PreparedStatement` e `Connection`.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Cadastre alguns alunos.
2.  Execute o método `listar()`.
3.  Confira se todos os registros aparecem no console.
4.  Compare o resultado com a consulta realizada no pgAdmin.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre utilize exatamente os mesmos nomes das colunas existentes no
banco de dados ao chamar `getString()` ou `getInt()`.

------------------------------------------------------------------------

# 📝 Resumo

``` text
SELECT
   │
executeQuery()
   │
ResultSet
   │
while(rs.next())
   │
Leitura dos registros
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Altere o método para ordenar os alunos pelo nome utilizando:

``` sql
SELECT * FROM alunos ORDER BY nome;
```

Observe a diferença na ordem dos resultados.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o método `listar()`.
-   [ ] Utilizar `SELECT`.
-   [ ] Executar `executeQuery()`.
-   [ ] Percorrer o `ResultSet`.
-   [ ] Fechar todos os recursos.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.5**, criarei uma classe de teste para executar o método
`listar()` e validar a recuperação dos registros antes de avançarmos
para consultas por ID e demais operações do CRUD.
