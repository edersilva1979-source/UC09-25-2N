# 📘 Capítulo 4

# Parte 5.1 --- Implementando o Método `excluir(int id)`

## 🎯 Objetivos

Nesta etapa implementarei o método responsável por remover um aluno do
banco de dados utilizando JDBC e PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Criar o método `excluir(int id)`;
-   Utilizar o comando SQL `DELETE`;
-   Empregar `PreparedStatement` para evitar SQL Injection;
-   Interpretar o retorno de `executeUpdate()`;
-   Fechar corretamente os recursos utilizados.

------------------------------------------------------------------------

# 📖 O comando SQL

``` sql
DELETE FROM alunos
WHERE id = ?;
```

A cláusula `WHERE` garante que apenas o registro correspondente ao ID
informado será removido.

------------------------------------------------------------------------

# 📦 Imports necessários

``` java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
```

------------------------------------------------------------------------

# 💻 Método completo

``` java
public void excluir(int id) {

    String sql = "DELETE FROM alunos WHERE id = ?";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }

        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println("Erro ao excluir: " + erro.getMessage());

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando linha por linha

## Criando o SQL

``` java
String sql = "DELETE FROM alunos WHERE id = ?";
```

Define o comando que será enviado ao PostgreSQL.

## Preparando a instrução

``` java
PreparedStatement stmt = conexao.prepareStatement(sql);
```

O JDBC prepara o comando e protege a aplicação contra SQL Injection.

## Informando o parâmetro

``` java
stmt.setInt(1, id);
```

Substitui o caractere `?` pelo ID informado.

## Executando

``` java
int linhasAfetadas = stmt.executeUpdate();
```

Retorna a quantidade de registros removidos.

-   Valor maior que zero: exclusão realizada.
-   Valor igual a zero: nenhum registro encontrado.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
ID informado
     │
     ▼
AlunoDAO.excluir(id)
     │
     ▼
PreparedStatement
     │
     ▼
DELETE FROM alunos
WHERE id = ?
     │
     ▼
executeUpdate()
     │
     ▼
Registro removido
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `executeUpdate()` é chamado:

1.  O PostgreSQL procura o registro pelo ID.
2.  Caso exista, remove a linha da tabela.
3.  Retorna a quantidade de registros excluídos.
4.  O JDBC entrega esse valor para a aplicação.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Antes de excluir um registro, aplicações profissionais normalmente:

-   exibem os dados do cadastro;
-   pedem confirmação ao usuário;
-   registram a ação em logs (quando necessário);
-   atualizam automaticamente a listagem da tela.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer a cláusula `WHERE`.
-   Informar um ID incorreto.
-   Não verificar `linhasAfetadas`.
-   Não fechar `PreparedStatement` e `Connection`.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Cadastre dois alunos.
2.  Exclua apenas um deles.
3.  Execute:

``` sql
SELECT * FROM alunos;
```

Verifique se apenas o registro escolhido foi removido.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre utilize a chave primária (`ID`) para excluir registros. Nunca
utilize o nome como referência, pois podem existir alunos com nomes
iguais.

------------------------------------------------------------------------

# 📝 Resumo

``` text
ID
 │
 ▼
DELETE
 │
WHERE id = ?
 │
 ▼
Registro removido
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Modifique o método para exibir a mensagem:

``` text
Deseja realmente excluir este aluno?
```

antes de executar a exclusão (a confirmação será implementada
futuramente na interface gráfica).

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o método `excluir(int id)`.
-   [ ] Utilizar `PreparedStatement`.
-   [ ] Informar corretamente o ID.
-   [ ] Executar `executeUpdate()`.
-   [ ] Validar o retorno da exclusão.
-   [ ] Fechar todos os recursos.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5.2**, criarei uma classe de teste para validar a exclusão de
registros e confirmar o resultado diretamente no PostgreSQL.
