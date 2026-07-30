# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.8 — Excluindo Alunos Selecionados na JTable

## 🎯 Objetivos da aula

Nesta etapa, vou implementar a exclusão de um aluno selecionado na `JTable`.

Ao final desta parte, eu serei capaz de:

- Selecionar um registro na tabela;
- Capturar o ID do aluno selecionado;
- Validar se existe uma linha selecionada;
- Solicitar confirmação antes da exclusão;
- Criar o método `excluir()` na classe `AlunoDAO`;
- Executar um comando SQL `DELETE`;
- Utilizar `PreparedStatement`;
- Proteger a exclusão com `WHERE id = ?`;
- Interpretar o número de linhas excluídas;
- Atualizar automaticamente a `JTable`;
- Limpar os campos após a exclusão;
- Tratar erros relacionados ao banco de dados.

---

# 🧭 O que será desenvolvido?

Na tela `TelaConsultaAluno`, o usuário seguirá este fluxo:

```text
Selecionar um aluno na JTable
          │
          ▼
Clicar no botão Excluir
          │
          ▼
Confirmar a exclusão
          │
          ▼
Executar DELETE no PostgreSQL
          │
          ▼
Atualizar a JTable
```

---

# 🏗️ Arquitetura da exclusão

```text
TelaConsultaAluno
        │
        ▼
Aluno selecionado na JTable
        │
        ▼
Capturar ID
        │
        ▼
AlunoDAO.excluir(id)
        │
        ▼
DELETE no PostgreSQL
        │
        ▼
Atualizar tabela
```

---

# ⚠️ Exclusão é uma operação crítica

Diferente de uma alteração, a exclusão remove o registro do banco de dados.

Por isso, devo tomar alguns cuidados:

- Confirmar se o usuário realmente deseja excluir;
- Exibir claramente qual aluno será removido;
- Verificar se uma linha foi selecionada;
- Utilizar `WHERE` no comando SQL;
- Atualizar a tabela depois da exclusão;
- Tratar possíveis relacionamentos com outras tabelas.

---

# 🖱️ Selecionando um aluno na JTable

Utilizarei:

```java
int linhaSelecionada =
        tblAlunos.getSelectedRow();
```

Quando nenhuma linha estiver selecionada, o retorno será:

```text
-1
```

Então, preciso validar:

```java
if (linhaSelecionada == -1) {

    JOptionPane.showMessageDialog(
            this,
            "Selecione um aluno na tabela.",
            "Nenhum aluno selecionado",
            JOptionPane.WARNING_MESSAGE
    );

    return;
}
```

---

# 🔢 Capturando o ID do aluno

Considerando que a coluna zero contém o ID:

```java
int id =
        Integer.parseInt(
                tblAlunos
                        .getValueAt(
                                linhaSelecionada,
                                0
                        )
                        .toString()
        );
```

Também posso capturar o nome para exibir na confirmação:

```java
String nome =
        tblAlunos
                .getValueAt(
                        linhaSelecionada,
                        1
                )
                .toString();
```

---

# 💬 Criando uma confirmação clara

```java
int resposta =
        JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir o aluno "
                + nome
                + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
```

Depois:

```java
if (resposta != JOptionPane.YES_OPTION) {

    return;
}
```

---

# 📦 Criando o método excluir no AlunoDAO

Na classe `AlunoDAO`, criarei:

```java
public boolean excluir(int id)
```

O método retornará:

```text
true
```

quando o aluno for excluído.

Retornará:

```text
false
```

quando nenhum registro for removido ou ocorrer algum erro.

---

# 💻 Código completo do método excluir

```java
public boolean excluir(int id) {

    String sql =
            "DELETE FROM alunos "
            + "WHERE id = ?";

    try {

        Connection conexao =
                Conexao.conectar();

        if (conexao == null) {

            return false;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        int linhasExcluidas =
                stmt.executeUpdate();

        stmt.close();
        conexao.close();

        return linhasExcluidas > 0;

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao excluir aluno: "
                + erro.getMessage()
        );

        return false;
    }
}
```

---

# 🔍 Entendendo o SQL DELETE

```sql
DELETE FROM alunos
WHERE id = ?
```

O comando remove o registro cujo ID for informado.

---

# ⚠️ A importância do WHERE

Observe:

```sql
WHERE id = ?
```

Sem essa condição:

```sql
DELETE FROM alunos;
```

todos os registros da tabela seriam excluídos.

Por isso, o `WHERE` é obrigatório neste caso.

---

# 🧠 O que retorna executeUpdate?

```java
int linhasExcluidas =
        stmt.executeUpdate();
```

O método retorna quantos registros foram removidos.

Exemplos:

```text
1 = um aluno excluído
0 = nenhum aluno excluído
```

Então:

```java
return linhasExcluidas > 0;
```

---

# ⭐ Código completo do botão Excluir

```java
private void btnExcluirActionPerformed(
        java.awt.event.ActionEvent evt) {

    int linhaSelecionada =
            tblAlunos.getSelectedRow();

    if (linhaSelecionada == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um aluno na tabela.",
                "Nenhum aluno selecionado",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    int id =
            Integer.parseInt(
                    tblAlunos
                            .getValueAt(
                                    linhaSelecionada,
                                    0
                            )
                            .toString()
            );

    String nome =
            tblAlunos
                    .getValueAt(
                            linhaSelecionada,
                            1
                    )
                    .toString();

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir o aluno "
                    + nome
                    + "?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

    if (resposta != JOptionPane.YES_OPTION) {

        return;
    }

    AlunoDAO dao =
            new AlunoDAO();

    boolean excluido =
            dao.excluir(id);

    if (excluido) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno excluído com sucesso!",
                "Exclusão concluída",
                JOptionPane.INFORMATION_MESSAGE
        );

        limparCamposEdicao();

        carregarTabela();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível excluir o aluno.",
                "Erro na exclusão",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
```

---

# 🧹 Limpando os campos após a exclusão

Reutilizarei:

```java
private void limparCamposEdicao() {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    tblAlunos.clearSelection();

    txtPesquisa.requestFocus();
}
```

---

# 🔄 Atualizando a JTable

Depois da exclusão:

```java
carregarTabela();
```

Esse método buscará novamente os registros do PostgreSQL e reconstruirá a tabela.

---

# 🔒 Desabilitando o botão Excluir inicialmente

No construtor:

```java
btnExcluir.setEnabled(false);
```

Quando uma linha for selecionada:

```java
btnExcluir.setEnabled(true);
```

---

# 🖱️ Habilitando o botão ao clicar na tabela

No evento `mouseClicked`:

```java
private void tblAlunosMouseClicked(
        java.awt.event.MouseEvent evt) {

    int linhaSelecionada =
            tblAlunos.getSelectedRow();

    if (linhaSelecionada != -1) {

        btnExcluir.setEnabled(true);
    }
}
```

---

# 🧠 Melhorando a segurança da exclusão

Posso exibir mais informações na confirmação:

```java
String mensagem =
        "Deseja realmente excluir este aluno?\n\n"
        + "ID: "
        + id
        + "\n"
        + "Nome: "
        + nome;
```

Depois:

```java
int resposta =
        JOptionPane.showConfirmDialog(
                this,
                mensagem,
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
```

---

# 🛡️ Confirmação reforçada

Em sistemas mais críticos, posso solicitar uma confirmação adicional:

```java
int primeiraConfirmacao =
        JOptionPane.showConfirmDialog(
                this,
                "Deseja excluir o aluno "
                + nome
                + "?",
                "Primeira confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

if (primeiraConfirmacao !=
        JOptionPane.YES_OPTION) {

    return;
}

int segundaConfirmacao =
        JOptionPane.showConfirmDialog(
                this,
                "Esta ação não poderá ser desfeita.\n"
                + "Deseja continuar?",
                "Confirmação final",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
        );

if (segundaConfirmacao !=
        JOptionPane.YES_OPTION) {

    return;
}
```

---

# 📋 Excluindo com dados carregados nos campos

Se os dados já estiverem nos campos de edição, posso usar:

```java
int id =
        Integer.parseInt(
                txtId.getText()
        );
```

Porém, ainda assim devo verificar se o campo está preenchido:

```java
if (txtId.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Selecione um aluno antes de excluir.",
            "Nenhum aluno selecionado",
            JOptionPane.WARNING_MESSAGE
    );

    return;
}
```

---

# ⭐ Versão alternativa usando os campos

```java
private void btnExcluirActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (txtId.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um aluno antes de excluir.",
                "Nenhum aluno selecionado",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    int id =
            Integer.parseInt(
                    txtId.getText()
            );

    String nome =
            txtNome.getText().trim();

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir o aluno "
                    + nome
                    + "?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

    if (resposta != JOptionPane.YES_OPTION) {

        return;
    }

    AlunoDAO dao =
            new AlunoDAO();

    boolean excluido =
            dao.excluir(id);

    if (excluido) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno excluído com sucesso!"
        );

        limparCamposEdicao();

        carregarTabela();
    }
}
```

---

# 🔗 E se o aluno estiver relacionado a outra tabela?

Imagine que exista uma tabela:

```text
matriculas
```

com uma chave estrangeira apontando para:

```text
alunos.id
```

Nesse caso, o PostgreSQL poderá impedir a exclusão.

A mensagem poderá indicar uma violação de chave estrangeira.

Exemplo conceitual:

```text
Não é possível excluir o aluno porque existem matrículas vinculadas.
```

---

# 🧩 Tratando erro de chave estrangeira

No `catch`, posso identificar a mensagem:

```java
catch (SQLException erro) {

    if ("23503".equals(
            erro.getSQLState())) {

        System.out.println(
                "O aluno possui registros vinculados."
        );

    } else {

        System.out.println(
                "Erro ao excluir aluno: "
                + erro.getMessage()
        );
    }

    return false;
}
```

No PostgreSQL, o código:

```text
23503
```

representa violação de chave estrangeira.

---

# 💡 Melhorando o retorno do DAO

O retorno `boolean` é simples, mas não informa o motivo da falha.

Em sistemas maiores, poderia utilizar:

- Exceções personalizadas;
- Objeto de resultado;
- Enumeração de status;
- Camada de serviço.

Exemplo conceitual:

```java
ResultadoExclusao resultado =
        dao.excluir(id);
```

Mas, para este projeto, o `boolean` é suficiente.

---

# 🔄 Fluxograma completo da exclusão

```text
Selecionar aluno
      │
      ▼
Clicar em Excluir
      │
      ▼
Existe linha selecionada?
      │
 ┌────┴────┐
 │         │
Não       Sim
 │         │
 ▼         ▼
Avisar   Capturar ID e nome
            │
            ▼
      Solicitar confirmação
            │
       ┌────┴────┐
       │         │
      Não       Sim
       │         │
       ▼         ▼
    Cancelar   DAO.excluir(id)
                  │
             ┌────┴────┐
             │         │
          Sucesso     Erro
             │         │
             ▼         ▼
        Atualizar     Exibir
        tabela        mensagem
```

---

# 🔬 Por baixo dos panos

Quando clico em **Excluir**:

1. A tela verifica a seleção;
2. O ID é capturado;
3. O nome é usado na confirmação;
4. O usuário decide se deseja continuar;
5. O DAO prepara o `DELETE`;
6. O ID é colocado no parâmetro;
7. O PostgreSQL executa a exclusão;
8. O número de linhas afetadas é retornado;
9. O DAO devolve `true` ou `false`;
10. A tela exibe a mensagem;
11. Os campos são limpos;
12. A tabela é recarregada.

---

# 💼 Como as empresas fazem?

Em sistemas profissionais, a exclusão física nem sempre é a melhor escolha.

Muitas aplicações utilizam exclusão lógica.

Em vez de apagar o registro, alteram um campo:

```text
ativo = false
```

Exemplo:

```sql
UPDATE alunos
SET ativo = false
WHERE id = ?
```

Assim, o registro continua no banco para:

- Auditoria;
- Histórico;
- Relatórios;
- Recuperação;
- Segurança.

---

# 🧠 Exclusão física e exclusão lógica

| Tipo | Comportamento |
|---|---|
| Exclusão física | Remove o registro com `DELETE` |
| Exclusão lógica | Mantém o registro, mas marca como inativo |

Para fins didáticos, utilizarei a exclusão física.

---

# ⚠️ Erros comuns

## Erro 1 — Excluir sem seleção

### Solução

```java
if (tblAlunos.getSelectedRow() == -1)
```

---

## Erro 2 — Esquecer o WHERE

### Problema

Todos os registros podem ser excluídos.

### Solução

```sql
WHERE id = ?
```

---

## Erro 3 — Usar executeQuery

### Solução

Para `DELETE`, utilize:

```java
executeUpdate();
```

---

## Erro 4 — Tabela não atualiza

### Solução

```java
carregarTabela();
```

---

## Erro 5 — Campos continuam preenchidos

### Solução

```java
limparCamposEdicao();
```

---

## Erro 6 — Registro possui vínculos

### Solução

Tratar a restrição de chave estrangeira e informar o usuário.

---

## Erro 7 — Excluir o aluno errado

### Solução

Exibir ID e nome na confirmação.

---

# 🧪 Laboratório prático

## Teste 1 — Exclusão normal

1. Selecione um aluno;
2. Clique em Excluir;
3. Confirme;
4. Verifique a tabela;
5. Consulte o PostgreSQL.

## Teste 2 — Cancelar exclusão

1. Selecione um aluno;
2. Clique em Excluir;
3. Escolha Não;
4. Confirme que o registro permanece.

## Teste 3 — Nenhuma linha selecionada

1. Limpe a seleção;
2. Clique em Excluir;
3. Verifique a mensagem.

## Teste 4 — Conferência no PostgreSQL

Execute:

```sql
SELECT *
FROM alunos
ORDER BY id;
```

## Teste 5 — Registro inexistente

Tente excluir um ID que não existe diretamente pelo DAO e observe o retorno:

```text
false
```

## Teste 6 — Chave estrangeira

Caso exista outra tabela relacionada, tente excluir um aluno vinculado e observe o comportamento do banco.

---

# 💡 Dicas do Professor

> 💡 Sempre confirme antes de excluir.

> 💡 Exiba o nome do aluno na mensagem.

> 💡 Nunca use `DELETE` sem `WHERE`.

> 💡 Utilize `executeUpdate()`.

> 💡 Atualize a tabela após a exclusão.

> 💡 Trate vínculos com outras tabelas.

> 💡 Em sistemas reais, considere exclusão lógica.

---

# 🧠 Curiosidade

O PostgreSQL pode proteger registros automaticamente por meio de chaves estrangeiras.

Essa proteção evita que um registro importante seja removido enquanto ainda existem dados dependentes dele.

---

# 🏆 Mini desafio 1

Exiba também a turma na confirmação:

```text
Aluno: Ana Souza
Turma: DS-01
```

---

# 🏆 Mini desafio 2

Desabilite o botão **Excluir** após a operação:

```java
btnExcluir.setEnabled(false);
```

---

# 🏆 Mini desafio 3

Crie uma mensagem diferente quando o aluno não puder ser excluído por possuir vínculos.

---

# 🏆 Desafio adicional

Implemente exclusão lógica.

Adicione a coluna:

```sql
ativo BOOLEAN DEFAULT TRUE
```

Depois, altere a exclusão para:

```sql
UPDATE alunos
SET ativo = false
WHERE id = ?
```

E modifique a listagem para:

```sql
SELECT *
FROM alunos
WHERE ativo = true
ORDER BY id;
```

---

# ✅ Checklist de implementação

- [ ] Validar a seleção;
- [ ] Capturar ID e nome;
- [ ] Solicitar confirmação;
- [ ] Criar `AlunoDAO.excluir()`;
- [ ] Executar `DELETE`;
- [ ] Utilizar `WHERE id = ?`;
- [ ] Utilizar `PreparedStatement`;
- [ ] Executar `executeUpdate()`;
- [ ] Interpretar linhas excluídas;
- [ ] Exibir mensagem de sucesso;
- [ ] Exibir mensagem de erro;
- [ ] Limpar os campos;
- [ ] Atualizar a tabela;
- [ ] Testar no PostgreSQL;
- [ ] Avaliar vínculos com outras tabelas.

---

# 📝 Resumo da aula

Nesta etapa, implementei a exclusão de alunos selecionados na `JTable`.

Aprendi a:

- Validar uma seleção;
- Capturar o ID;
- Solicitar confirmação;
- Executar `DELETE`;
- Utilizar `WHERE`;
- Trabalhar com retorno booleano;
- Atualizar a interface;
- Tratar possíveis vínculos;
- Entender exclusão física e lógica.

Agora a tela permite:

```text
Listar
Localizar
Selecionar
Alterar
Excluir
```

---

# 🚀 Próxima etapa

Na **Parte 5.9**, realizarei a integração final da tela de consulta, organizando todos os métodos, melhorando a usabilidade, habilitando e desabilitando botões, tratando eventos da tabela e revisando o CRUD completo com PostgreSQL.
