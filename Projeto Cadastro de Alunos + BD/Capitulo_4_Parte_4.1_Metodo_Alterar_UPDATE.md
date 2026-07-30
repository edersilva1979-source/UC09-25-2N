# 📘 Capítulo 4

# Parte 4.1 --- Implementando o Método `alterar(Aluno aluno)`

## 🎯 Objetivos

Nesta etapa implementarei o método responsável por atualizar os dados de
um aluno já cadastrado no PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Criar o método `alterar(Aluno aluno)`;
-   Escrever um comando `UPDATE`;
-   Utilizar `PreparedStatement` com parâmetros;
-   Atualizar um registro utilizando o ID;
-   Fechar corretamente os recursos utilizados.

------------------------------------------------------------------------

# 📖 Estrutura do comando SQL

``` sql
UPDATE alunos
SET nome = ?, turma = ?, email = ?
WHERE id = ?;
```

Neste comando:

-   `SET` define quais colunas serão alteradas.
-   `WHERE id = ?` garante que apenas um aluno será atualizado.

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
public void alterar(Aluno aluno) {

    String sql =
        "UPDATE alunos SET nome = ?, turma = ?, email = ? WHERE id = ?";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getTurma());
        stmt.setString(3, aluno.getEmail());
        stmt.setInt(4, aluno.getId());

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Aluno atualizado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }

        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println("Erro ao atualizar: " + erro.getMessage());

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando cada etapa

## Definindo o SQL

``` java
String sql = "...";
```

Armazena o comando `UPDATE` que será enviado ao PostgreSQL.

## Preparando o comando

``` java
PreparedStatement stmt = conexao.prepareStatement(sql);
```

O JDBC prepara a instrução antes da execução.

## Preenchendo os parâmetros

``` java
stmt.setString(1, aluno.getNome());
stmt.setString(2, aluno.getTurma());
stmt.setString(3, aluno.getEmail());
stmt.setInt(4, aluno.getId());
```

Os três primeiros parâmetros correspondem às colunas que serão
alteradas.

O quarto parâmetro identifica qual registro será atualizado.

## Executando

``` java
int linhasAfetadas = stmt.executeUpdate();
```

O método retorna a quantidade de registros modificados.

Se o valor for maior que zero, a atualização foi realizada com sucesso.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Objeto Aluno
      │
      ▼
alterar()
      │
      ▼
PreparedStatement
      │
      ▼
UPDATE ... WHERE id = ?
      │
      ▼
executeUpdate()
      │
      ▼
Registro atualizado
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `executeUpdate()` é executado, o PostgreSQL procura o registro
informado no `WHERE`.

Se ele existir, apenas as colunas indicadas no `SET` serão modificadas.

Caso o ID não exista, nenhuma linha será alterada e o retorno será `0`.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em aplicações profissionais, é comum consultar o registro antes da
alteração para preencher uma tela de edição.

Após o usuário confirmar as mudanças, apenas os novos valores são
enviados ao banco.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Informar o ID errado.
-   Trocar a ordem dos parâmetros.
-   Esquecer o `WHERE`.
-   Não verificar o retorno de `executeUpdate()`.
-   Não fechar `PreparedStatement` e `Connection`.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Cadastre um aluno.
2.  Altere o nome e o e-mail do registro.
3.  Execute o método `alterar()`.
4.  Consulte novamente a tabela e confirme as alterações.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre utilize o ID como referência para atualizar registros. Ele é
único e evita modificar o aluno errado.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Aluno
  │
  ▼
UPDATE
  │
WHERE id = ?
  │
  ▼
Registro atualizado
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Adicione o campo **telefone** à entidade `Aluno` e adapte o método
`alterar()` para atualizar esse novo atributo também.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o método `alterar(Aluno aluno)`.
-   [ ] Utilizar `PreparedStatement`.
-   [ ] Preencher corretamente todos os parâmetros.
-   [ ] Executar `executeUpdate()`.
-   [ ] Validar a quantidade de linhas afetadas.
-   [ ] Fechar todos os recursos.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 4.2**, criarei uma classe de teste para validar a atualização
de registros e confirmar as alterações diretamente no PostgreSQL.
