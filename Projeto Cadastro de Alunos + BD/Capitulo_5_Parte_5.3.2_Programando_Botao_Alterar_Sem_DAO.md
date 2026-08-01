# 📘 Capítulo 5 --- Parte 5.3.2

# Programando o Botão Alterar (sem classe `AlunoDAO`)

## Objetivo

Nesta versão vou manter toda a lógica de acesso ao banco dentro da
própria classe `Aluno`. Esta abordagem é útil para quem está começando,
pois reduz a quantidade de classes e facilita a compreensão do fluxo
completo.

------------------------------------------------------------------------

# Estrutura do projeto

``` text
src
│
├── Conexao.java
├── Aluno.java
├── TelaConsultaAluno.java
└── TelaCadastroAluno.java
```

------------------------------------------------------------------------

# A classe Aluno

Além dos atributos:

``` java
private int id;
private String nome;
private String turma;
private String email;
```

ela também possuirá o método:

``` java
public boolean alterar()
```

------------------------------------------------------------------------

# Imports necessários

``` java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
```

------------------------------------------------------------------------

# Método alterar() completo

``` java
public boolean alterar() {

    String sql =
        "UPDATE alunos "
      + "SET nome = ?, turma = ?, email = ? "
      + "WHERE id = ?";

    try {

        Connection conexao = Conexao.conectar();

        if (conexao == null) {
            return false;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(1, this.nome);
        stmt.setString(2, this.turma);
        stmt.setString(3, this.email);
        stmt.setInt(4, this.id);

        int linhas =
                stmt.executeUpdate();

        stmt.close();
        conexao.close();

        return linhas > 0;

    } catch (SQLException e) {

        System.out.println(
            "Erro ao alterar: "
            + e.getMessage()
        );

        return false;
    }
}
```

------------------------------------------------------------------------

# Entendendo o método

Cada `this` representa o valor armazenado no próprio objeto.

``` java
this.nome
```

é o nome digitado pelo usuário.

``` java
this.id
```

é o registro que será localizado no banco.

------------------------------------------------------------------------

# SQL executado

``` sql
UPDATE alunos
SET nome = ?,
    turma = ?,
    email = ?
WHERE id = ?;
```

O `WHERE` garante que apenas um aluno seja alterado.

------------------------------------------------------------------------

# Programando o botão Alterar

``` java
private void btnAlterarActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (txtId.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um aluno.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    Aluno aluno = new Aluno();

    aluno.setId(
        Integer.parseInt(
            txtId.getText()
        )
    );

    aluno.setNome(
        txtNome.getText().trim()
    );

    aluno.setTurma(
        txtTurma.getText()
                .trim()
                .toUpperCase()
    );

    aluno.setEmail(
        txtEmail.getText().trim()
    );

    int resposta =
        JOptionPane.showConfirmDialog(
            this,
            "Deseja alterar este aluno?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

    if (resposta != JOptionPane.YES_OPTION) {
        return;
    }

    if (aluno.alterar()) {

        JOptionPane.showMessageDialog(
            this,
            "Aluno alterado com sucesso!"
        );

        limparCampos();
        carregarTabela();

    } else {

        JOptionPane.showMessageDialog(
            this,
            "Erro ao alterar aluno."
        );
    }
}
```

------------------------------------------------------------------------

# Fluxo da alteração

``` text
Selecionar aluno
        │
        ▼
Editar campos
        │
        ▼
Criar objeto Aluno
        │
        ▼
aluno.alterar()
        │
        ▼
Classe Conexao
        │
        ▼
PostgreSQL
        │
        ▼
Atualizar JTable
```

------------------------------------------------------------------------

# Vantagens desta abordagem

-   Mais simples para iniciantes.
-   Menor quantidade de classes.
-   Facilita o entendimento do CRUD.
-   Ideal para os primeiros projetos.

------------------------------------------------------------------------

# Limitação

Quando o sistema crescer, o ideal será mover os comandos SQL para uma
classe `AlunoDAO`, seguindo boas práticas de arquitetura.

------------------------------------------------------------------------

# Laboratório

1.  Cadastre três alunos.
2.  Abra a tela de consulta.
3.  Selecione um registro.
4.  Altere nome e turma.
5.  Clique em **Alterar**.
6.  Confirme.
7.  Verifique o resultado na JTable.
8.  Execute:

``` sql
SELECT *
FROM alunos
ORDER BY id;
```

------------------------------------------------------------------------

# Checklist

-   [ ] Método `alterar()` criado na classe `Aluno`
-   [ ] Uso da classe `Conexao`
-   [ ] SQL `UPDATE`
-   [ ] `PreparedStatement`
-   [ ] `WHERE id = ?`
-   [ ] Botão Alterar programado
-   [ ] Atualização da JTable
-   [ ] Teste realizado no PostgreSQL

------------------------------------------------------------------------

# Resumo

Nesta versão, concentrei toda a lógica de alteração dentro da classe
`Aluno`. Embora essa arquitetura não seja a mais indicada para projetos
grandes, ela é excelente para introduzir JDBC, Swing e PostgreSQL de
forma simples e objetiva. Nos próximos capítulos, evoluirei esse código
para uma arquitetura utilizando `AlunoDAO`, mostrando como organizar
melhor as responsabilidades do sistema.
