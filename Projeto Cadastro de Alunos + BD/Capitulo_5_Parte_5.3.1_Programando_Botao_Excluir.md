# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.3.1 — Programando o Botão Excluir

## 🎯 Objetivos da aula

Nesta etapa, vou programar o botão **Excluir** da tela de cadastro e consulta de alunos.

Ao final desta parte, eu serei capaz de:

- Selecionar um aluno;
- Capturar o ID do registro;
- Validar se existe um aluno selecionado;
- Solicitar confirmação antes da exclusão;
- Criar o método `excluir()` na classe `AlunoDAO`;
- Executar o comando SQL `DELETE`;
- Utilizar `PreparedStatement`;
- Evitar a exclusão de todos os registros;
- Atualizar a tabela após a exclusão;
- Limpar os campos da tela;
- Tratar erros relacionados ao banco de dados.

---

# 🧭 O que o botão Excluir deverá fazer?

```text
Verificar se existe um aluno selecionado
                 │
                 ▼
Capturar o ID do aluno
                 │
                 ▼
Exibir uma mensagem de confirmação
                 │
                 ▼
Executar DELETE no PostgreSQL
                 │
                 ▼
Exibir uma mensagem de sucesso
                 │
                 ▼
Limpar os campos e atualizar a JTable
```

---

# ⚠️ Por que a exclusão exige cuidado?

A exclusão remove um registro do banco de dados. Antes de executar essa operação, eu devo:

- Confirmar qual aluno será excluído;
- Mostrar o nome e o ID do registro;
- Utilizar o ID correto;
- Usar obrigatoriamente a cláusula `WHERE`;
- Solicitar confirmação ao usuário;
- Atualizar a interface depois da operação.

---

# 🖱️ Identificando o botão

Na interface, utilizarei:

```text
btnExcluir
```

O evento criado pelo NetBeans será semelhante a:

```java
private void btnExcluirActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

---

# 📌 De onde virá o ID do aluno?

O ID poderá vir de duas formas:

```java
txtId.getText();
```

ou diretamente da linha selecionada na tabela:

```java
tblAlunos.getSelectedRow();
```

Nesta aula, trabalharei com as duas possibilidades.

---

# 🧩 Estratégia 1 — Excluir usando o campo ID

Antes de converter o ID, verificarei se o campo está vazio:

```java
if (txtId.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Selecione ou localize um aluno antes de excluir.",
            "Nenhum aluno selecionado",
            JOptionPane.WARNING_MESSAGE
    );

    return;
}
```

Depois, converto o conteúdo para número:

```java
int id = Integer.parseInt(txtId.getText());
```

---

# 🧱 Criando o método excluir no AlunoDAO

Na classe `AlunoDAO`, criarei:

```java
public boolean excluir(int id)
```

O método retornará `true` quando o registro for removido e `false` quando a operação falhar ou nenhum registro for encontrado.

## Código completo

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

# 🔍 Explicando o SQL

```sql
DELETE FROM alunos
WHERE id = ?;
```

Esse comando significa:

```text
Exclua da tabela alunos
somente o registro cujo ID
seja igual ao valor informado.
```

---

# 🚨 Nunca esquecer o WHERE

Correto:

```sql
DELETE FROM alunos
WHERE id = ?;
```

Perigoso:

```sql
DELETE FROM alunos;
```

Sem o `WHERE`, todos os alunos seriam excluídos.

---

# 🧠 Entendendo o parâmetro

O sinal de interrogação será preenchido por:

```java
stmt.setInt(1, id);
```

O número `1` representa o primeiro parâmetro do comando SQL.

---

# 🔄 Por que utilizar executeUpdate()?

Para os comandos:

```text
INSERT
UPDATE
DELETE
```

utilizo:

```java
executeUpdate();
```

Ele retorna a quantidade de linhas afetadas:

```text
1 = um registro excluído
0 = nenhum registro excluído
```

Por isso, o DAO pode retornar:

```java
return linhasExcluidas > 0;
```

---

# 💬 Solicitando confirmação

Antes de excluir, exibirei uma caixa de confirmação:

```java
int resposta =
        JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este aluno?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

if (resposta != JOptionPane.YES_OPTION) {
    return;
}
```

---

# ⭐ Código completo do botão usando os campos

```java
private void btnExcluirActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (txtId.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione ou localize um aluno antes de excluir.",
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

    String mensagem =
            "Deseja realmente excluir este aluno?\n\n"
            + "ID: " + id
            + "\nNome: " + nome;

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    mensagem,
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

    if (resposta != JOptionPane.YES_OPTION) {
        return;
    }

    AlunoDAO dao = new AlunoDAO();

    boolean excluido =
            dao.excluir(id);

    if (excluido) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno excluído com sucesso!",
                "Exclusão concluída",
                JOptionPane.INFORMATION_MESSAGE
        );

        limparCampos();
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

# 🧹 Criando o método limparCampos

```java
private void limparCampos() {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    tblAlunos.clearSelection();

    btnExcluir.setEnabled(false);

    txtNome.requestFocus();
}
```

---

# 🔄 Atualizando a JTable

Depois da exclusão, chamarei:

```java
carregarTabela();
```

Esse método consultará novamente o PostgreSQL e reconstruirá as linhas da tabela.

---

# 🧩 Estratégia 2 — Excluir diretamente pela JTable

Primeiro, capturo a linha selecionada:

```java
int linhaSelecionada =
        tblAlunos.getSelectedRow();
```

Quando nenhuma linha está selecionada, o retorno é `-1`.

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

## Capturando ID e nome

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

String nome =
        tblAlunos
                .getValueAt(
                        linhaSelecionada,
                        1
                )
                .toString();
```

---

# ⭐ Código completo usando a JTable

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
                    + nome + "?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

    if (resposta != JOptionPane.YES_OPTION) {
        return;
    }

    AlunoDAO dao = new AlunoDAO();

    boolean excluido =
            dao.excluir(id);

    if (excluido) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno excluído com sucesso!",
                "Exclusão concluída",
                JOptionPane.INFORMATION_MESSAGE
        );

        limparCampos();
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

# 🔐 Desabilitando o botão inicialmente

No construtor da tela:

```java
btnExcluir.setEnabled(false);
```

Ao selecionar uma linha:

```java
private void tblAlunosMouseClicked(
        java.awt.event.MouseEvent evt) {

    if (tblAlunos.getSelectedRow() != -1) {
        btnExcluir.setEnabled(true);
    }
}
```

Depois da exclusão:

```java
btnExcluir.setEnabled(false);
```

---

# 🛡️ Confirmação dupla

Em um sistema mais crítico, posso utilizar duas confirmações:

```java
int primeiraResposta =
        JOptionPane.showConfirmDialog(
                this,
                "Deseja excluir o aluno "
                + nome + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

if (primeiraResposta != JOptionPane.YES_OPTION) {
    return;
}

int segundaResposta =
        JOptionPane.showConfirmDialog(
                this,
                "Esta ação não poderá ser desfeita.\n"
                + "Deseja continuar?",
                "Confirmação final",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
        );

if (segundaResposta != JOptionPane.YES_OPTION) {
    return;
}
```

---

# 🔗 E se o aluno possuir registros vinculados?

Imagine que exista uma tabela `matriculas` relacionada ao aluno:

```text
alunos
  │
  └── matriculas
```

Nesse caso, o PostgreSQL poderá impedir a exclusão por causa de uma chave estrangeira.

O código SQLState do PostgreSQL para violação de chave estrangeira é:

```text
23503
```

## Tratamento básico no DAO

```java
catch (SQLException erro) {

    if ("23503".equals(erro.getSQLState())) {

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

---

# 🧠 Exclusão física e exclusão lógica

## Exclusão física

Remove o registro definitivamente:

```sql
DELETE FROM alunos
WHERE id = ?;
```

## Exclusão lógica

Mantém o registro e apenas o desativa:

```sql
UPDATE alunos
SET ativo = false
WHERE id = ?;
```

Em sistemas profissionais, a exclusão lógica costuma ser utilizada quando é necessário preservar histórico e auditoria.

---

# 💼 Como as empresas fazem?

Em aplicações reais, a exclusão pode envolver:

- Permissão de usuário;
- Registro de auditoria;
- Histórico de operações;
- Confirmação reforçada;
- Verificação de vínculos;
- Exclusão lógica;
- Registro de data e hora;
- Identificação de quem realizou a operação.

Neste projeto, utilizarei a exclusão física para compreender o funcionamento completo do CRUD.

---

# 🔄 Fluxograma do botão Excluir

```text
Clicar em Excluir
        │
        ▼
Existe aluno selecionado?
        │
   ┌────┴────┐
   │         │
  Não       Sim
   │         │
   ▼         ▼
Exibir     Capturar
mensagem   ID e nome
              │
              ▼
      Solicitar confirmação
              │
         ┌────┴────┐
         │         │
        Não       Sim
         │         │
         ▼         ▼
      Cancelar   DAO.excluir()
                     │
                ┌────┴────┐
                │         │
             Sucesso     Erro
                │         │
                ▼         ▼
           Limpar e      Exibir
           atualizar     mensagem
```

---

# 🔬 Por baixo dos panos

Quando clico em **Excluir**:

1. O evento do botão é executado;
2. A tela verifica o aluno selecionado;
3. O ID é capturado;
4. O nome aparece na confirmação;
5. O usuário decide se deseja continuar;
6. O DAO recebe o ID;
7. O `PreparedStatement` prepara o comando;
8. O PostgreSQL executa o `DELETE`;
9. O banco informa quantas linhas foram afetadas;
10. O DAO retorna `true` ou `false`;
11. A tela exibe a mensagem;
12. Os campos são limpos;
13. A tabela é atualizada.

---

# ⚠️ Erros comuns

## Erro 1 — O botão não executa

Verifique se o evento `ActionPerformed` está associado ao botão.

## Erro 2 — Todos os registros foram excluídos

O SQL foi executado sem `WHERE`.

## Erro 3 — Uso de executeQuery()

Para `DELETE`, utilize:

```java
executeUpdate();
```

## Erro 4 — Exclusão sem seleção

Valide o campo ID ou `getSelectedRow()`.

## Erro 5 — A tabela não atualiza

Depois da operação, utilize:

```java
carregarTabela();
```

## Erro 6 — Os campos continuam preenchidos

Chame:

```java
limparCampos();
```

## Erro 7 — O aluno possui registros vinculados

Trate a restrição de chave estrangeira e informe o usuário.

---

# 🧪 Laboratório prático

## Etapa 1 — Conferir os registros

```sql
SELECT *
FROM alunos
ORDER BY id;
```

## Etapa 2 — Criar o método no DAO

```java
public boolean excluir(int id)
```

## Etapa 3 — Programar o botão

Crie o evento `btnExcluirActionPerformed`.

## Etapa 4 — Testar sem seleção

Clique em Excluir sem selecionar um aluno.

## Etapa 5 — Testar o cancelamento

Selecione um aluno e escolha **Não** na confirmação.

## Etapa 6 — Testar a exclusão

Confirme a operação e verifique a atualização da tabela.

## Etapa 7 — Conferir no PostgreSQL

```sql
SELECT *
FROM alunos
ORDER BY id;
```

---

# 💡 Dicas do Professor

> 💡 Sempre utilize `WHERE` no `DELETE`.

> 💡 Mostre o nome do aluno antes de excluir.

> 💡 Não permita a operação sem seleção.

> 💡 Atualize a tabela depois da exclusão.

> 💡 Utilize `PreparedStatement`.

> 💡 Em sistemas reais, avalie a exclusão lógica.

---

# 🧠 Curiosidade

O PostgreSQL não sabe que existe um botão chamado **Excluir**. Ele recebe apenas o comando SQL enviado pelo Java.

Por isso, as validações e confirmações precisam acontecer na aplicação antes da execução do `DELETE`.

---

# 🏆 Mini desafio 1

Mostre também a turma na confirmação:

```text
Aluno: Ana Souza
Turma: DS-01
```

---

# 🏆 Mini desafio 2

Desabilite o botão após a exclusão:

```java
btnExcluir.setEnabled(false);
```

---

# 🏆 Mini desafio 3

Adicione um ícone ao botão **Excluir** e um texto de ajuda com `setToolTipText()`.

---

# 🏆 Desafio adicional

Implemente a exclusão lógica.

No PostgreSQL:

```sql
ALTER TABLE alunos
ADD COLUMN ativo BOOLEAN DEFAULT TRUE;
```

No DAO:

```sql
UPDATE alunos
SET ativo = false
WHERE id = ?;
```

Na listagem:

```sql
SELECT *
FROM alunos
WHERE ativo = true
ORDER BY id;
```

---

# ✅ Checklist de implementação

- [ ] Criar o botão Excluir;
- [ ] Criar o evento `ActionPerformed`;
- [ ] Validar o aluno selecionado;
- [ ] Capturar o ID;
- [ ] Capturar o nome;
- [ ] Solicitar confirmação;
- [ ] Criar `AlunoDAO.excluir()`;
- [ ] Utilizar `DELETE`;
- [ ] Utilizar `WHERE id = ?`;
- [ ] Utilizar `PreparedStatement`;
- [ ] Executar `executeUpdate()`;
- [ ] Verificar as linhas excluídas;
- [ ] Exibir mensagem de sucesso;
- [ ] Exibir mensagem de erro;
- [ ] Limpar os campos;
- [ ] Atualizar a `JTable`;
- [ ] Testar no PostgreSQL.

---

# 📝 Resumo da aula

Nesta etapa, programei o botão **Excluir**.

Aprendi a:

- Validar um aluno selecionado;
- Capturar o ID;
- Solicitar confirmação;
- Criar o método `excluir()`;
- Executar o comando `DELETE`;
- Utilizar `WHERE`;
- Interpretar o retorno do banco;
- Atualizar a interface;
- Tratar possíveis erros e vínculos.

Agora o sistema consegue remover alunos cadastrados no PostgreSQL de forma controlada e segura.

---

# 🚀 Próxima etapa

Na próxima parte, poderei revisar os demais botões e integrar o funcionamento completo do cadastro, consulta, alteração e exclusão de alunos.
