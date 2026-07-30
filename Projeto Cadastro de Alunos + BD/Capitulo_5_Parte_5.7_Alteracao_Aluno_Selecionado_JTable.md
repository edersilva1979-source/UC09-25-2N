# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.7 — Alterando os Dados de um Aluno Selecionado na JTable

## 🎯 Objetivos da aula

Nesta etapa, vou implementar a alteração dos dados de um aluno selecionado na `JTable`.

Ao final desta parte, eu serei capaz de:

- Selecionar uma linha da tabela;
- Capturar os dados da linha selecionada;
- Preencher campos de edição;
- Validar os novos dados;
- Criar o método `alterar()` na classe `AlunoDAO`;
- Executar um comando SQL `UPDATE`;
- Utilizar `PreparedStatement` com parâmetros;
- Solicitar confirmação antes da alteração;
- Atualizar automaticamente a `JTable`;
- Informar mensagens de sucesso e erro;
- Impedir alterações sem seleção.

---

# 🧭 O que será desenvolvido?

Na tela `TelaConsultaAluno`, o usuário seguirá este fluxo:

```text
Selecionar um aluno na JTable
          │
          ▼
Clicar no botão Alterar
          │
          ▼
Carregar os dados nos campos
          │
          ▼
Editar as informações
          │
          ▼
Confirmar a alteração
          │
          ▼
Executar UPDATE no PostgreSQL
          │
          ▼
Atualizar a JTable
```

---

# 🏗️ Arquitetura da alteração

```text
TelaConsultaAluno
        │
        ▼
Aluno selecionado na JTable
        │
        ▼
Objeto Aluno atualizado
        │
        ▼
AlunoDAO.alterar(aluno)
        │
        ▼
UPDATE no PostgreSQL
        │
        ▼
Atualização da tabela
```

---

# 🖼️ Componentes necessários

Na tela `TelaConsultaAluno`, poderei utilizar os seguintes campos de edição:

| Componente | Nome da variável | Função |
|---|---|---|
| `JTextField` | `txtId` | Exibir o ID do aluno |
| `JTextField` | `txtNome` | Editar o nome |
| `JTextField` | `txtTurma` | Editar a turma |
| `JTextField` | `txtEmail` | Editar o e-mail |
| `JButton` | `btnAlterar` | Confirmar a alteração |
| `JButton` | `btnCancelarEdicao` | Cancelar a edição |

O campo ID deverá ficar desabilitado:

```java
txtId.setEnabled(false);
```

O ID não deve ser alterado, pois identifica o registro no banco.

---

# 🖼️ Sugestão de layout

```text
+------------------------------------------------------------------+
|                    CONSULTA DE ALUNOS                             |
+------------------------------------------------------------------+

 Pesquisar por: [Nome ▼] [____________________] [Localizar]

+------------------------------------------------------------------+
| ID | Nome                | Turma       | E-mail                  |
|----|---------------------|-------------|-------------------------|
| 1  | Ana Souza           | DS-01       | ana@email.com           |
| 2  | Bruno Lima          | DS-02       | bruno@email.com         |
+------------------------------------------------------------------+

 ID:     [ 1            ]
 Nome:   [ Ana Souza     ]
 Turma:  [ DS-01         ]
 E-mail: [ ana@email.com ]

 [Alterar] [Cancelar edição] [Excluir] [Voltar]
```

---

# 🖱️ Selecionando uma linha da JTable

A `JTable` possui o método:

```java
getSelectedRow()
```

Esse método retorna o número da linha selecionada.

Exemplo:

```java
int linhaSelecionada =
        tblAlunos.getSelectedRow();
```

---

# 🔢 Como funciona o índice da linha?

A contagem começa em zero.

```text
Primeira linha  = 0
Segunda linha   = 1
Terceira linha  = 2
```

Quando nenhuma linha estiver selecionada, o método retorna:

```text
-1
```

Por isso, preciso validar:

```java
if (linhaSelecionada == -1) {
```

---

# ✅ Validando a seleção

```java
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
```

---

# 📋 Capturando os dados da linha selecionada

Utilizarei:

```java
tblAlunos.getValueAt(linha, coluna)
```

Exemplo:

```java
Object valorId =
        tblAlunos.getValueAt(
                linhaSelecionada,
                0
        );
```

As colunas serão:

```text
0 = ID
1 = Nome
2 = Turma
3 = E-mail
```

---

# 💻 Preenchendo os campos de edição

```java
private void carregarAlunoSelecionado() {

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

    txtId.setText(
            tblAlunos
                    .getValueAt(
                            linhaSelecionada,
                            0
                    )
                    .toString()
    );

    txtNome.setText(
            tblAlunos
                    .getValueAt(
                            linhaSelecionada,
                            1
                    )
                    .toString()
    );

    txtTurma.setText(
            tblAlunos
                    .getValueAt(
                            linhaSelecionada,
                            2
                    )
                    .toString()
    );

    txtEmail.setText(
            tblAlunos
                    .getValueAt(
                            linhaSelecionada,
                            3
                    )
                    .toString()
    );

    txtNome.requestFocus();
}
```

---

# 🧠 Por que usar `toString()`?

O método:

```java
getValueAt()
```

retorna um objeto do tipo:

```java
Object
```

Para colocar esse valor em um `JTextField`, transformo o conteúdo em texto:

```java
.toString()
```

---

# 🖱️ Carregando os dados com duplo clique

Posso carregar os dados quando o usuário der dois cliques em uma linha.

No evento `mouseClicked` da tabela:

```java
private void tblAlunosMouseClicked(
        java.awt.event.MouseEvent evt) {

    if (evt.getClickCount() == 2) {

        carregarAlunoSelecionado();
    }
}
```

---

# 🖱️ Carregando os dados ao clicar no botão Alterar

Outra opção é usar o botão **Alterar** primeiro para carregar os dados.

```java
private void btnAlterarActionPerformed(
        java.awt.event.ActionEvent evt) {

    carregarAlunoSelecionado();
}
```

Porém, ainda preciso de um segundo botão para salvar a alteração.

Para deixar o fluxo mais claro, posso utilizar:

```text
Editar
Salvar Alteração
Cancelar
```

Mas, neste projeto, utilizarei o próprio botão **Alterar** para confirmar a atualização depois que os campos estiverem preenchidos.

---

# 🧩 Estratégia utilizada nesta aula

Vou seguir esta organização:

1. O usuário seleciona uma linha;
2. Dá dois cliques ou clica em **Carregar dados**;
3. Os campos são preenchidos;
4. O usuário altera os valores;
5. Clica em **Alterar**;
6. O sistema atualiza o banco.

---

# 📦 Criando o método alterar no AlunoDAO

Na classe `AlunoDAO`, criarei:

```java
public boolean alterar(
        Aluno aluno)
```

O método retornará:

```text
true
```

quando a alteração for realizada.

Retornará:

```text
false
```

quando ocorrer algum erro ou nenhum registro for modificado.

---

# 💻 Código completo do método alterar

```java
public boolean alterar(
        Aluno aluno) {

    String sql =
            "UPDATE alunos "
            + "SET nome = ?, "
            + "turma = ?, "
            + "email = ? "
            + "WHERE id = ?";

    try {

        Connection conexao =
                Conexao.conectar();

        if (conexao == null) {

            return false;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(
                1,
                aluno.getNome()
        );

        stmt.setString(
                2,
                aluno.getTurma()
        );

        stmt.setString(
                3,
                aluno.getEmail()
        );

        stmt.setInt(
                4,
                aluno.getId()
        );

        int linhasAlteradas =
                stmt.executeUpdate();

        stmt.close();
        conexao.close();

        return linhasAlteradas > 0;

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao alterar aluno: "
                + erro.getMessage()
        );

        return false;
    }
}
```

---

# 🔍 Entendendo o SQL UPDATE

```sql
UPDATE alunos
SET nome = ?,
    turma = ?,
    email = ?
WHERE id = ?
```

O comando altera os dados do aluno cujo ID for informado.

---

# ⚠️ Importância do WHERE

Observe:

```sql
WHERE id = ?
```

Sem essa condição, todos os alunos seriam alterados.

Exemplo perigoso:

```sql
UPDATE alunos
SET turma = 'DS-01';
```

Esse comando modificaria a turma de todos os registros.

Por isso, sempre devo confirmar se o `WHERE` está presente.

---

# 🔢 Ordem dos parâmetros

A ordem deve seguir os sinais de interrogação:

```sql
SET nome = ?, turma = ?, email = ?
WHERE id = ?
```

Correspondência:

```text
1 = nome
2 = turma
3 = e-mail
4 = ID
```

Código:

```java
stmt.setString(1, aluno.getNome());
stmt.setString(2, aluno.getTurma());
stmt.setString(3, aluno.getEmail());
stmt.setInt(4, aluno.getId());
```

---

# 🧠 O que retorna executeUpdate?

```java
int linhasAlteradas =
        stmt.executeUpdate();
```

O método retorna a quantidade de registros modificados.

Exemplo:

```text
1 = um aluno alterado
0 = nenhum registro alterado
```

Por isso:

```java
return linhasAlteradas > 0;
```

---

# ✅ Validando os campos antes da alteração

Na tela, criarei:

```java
private boolean validarCamposEdicao()
```

---

# 💻 Método validarCamposEdicao

```java
private boolean validarCamposEdicao() {

    String nome =
            txtNome.getText().trim();

    String turma =
            txtTurma.getText().trim();

    String email =
            txtEmail.getText().trim();

    if (txtId.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um aluno na tabela.",
                "Nenhum aluno selecionado",
                JOptionPane.WARNING_MESSAGE
        );

        return false;
    }

    if (nome.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o nome do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtNome.requestFocus();

        return false;
    }

    if (turma.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe a turma do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtTurma.requestFocus();

        return false;
    }

    if (email.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o e-mail do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();

        return false;
    }

    if (!email.contains("@")) {

        JOptionPane.showMessageDialog(
                this,
                "Informe um e-mail válido.",
                "E-mail inválido",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();

        return false;
    }

    return true;
}
```

---

# 🧱 Criando o objeto Aluno atualizado

Depois de validar os campos:

```java
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
        txtTurma.getText().trim()
);

aluno.setEmail(
        txtEmail.getText().trim()
);
```

---

# 💬 Solicitando confirmação

Antes de executar o `UPDATE`, exibirei:

```java
int resposta =
        JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente alterar os dados deste aluno?",
                "Confirmar alteração",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
```

Depois:

```java
if (resposta != JOptionPane.YES_OPTION) {

    return;
}
```

---

# ⭐ Código completo do botão Alterar

```java
private void btnAlterarActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (!validarCamposEdicao()) {

        return;
    }

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente alterar os dados deste aluno?",
                    "Confirmar alteração",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

    if (resposta != JOptionPane.YES_OPTION) {

        return;
    }

    Aluno aluno =
            new Aluno();

    aluno.setId(
            Integer.parseInt(
                    txtId.getText()
            )
    );

    aluno.setNome(
            txtNome.getText().trim()
    );

    aluno.setTurma(
            txtTurma.getText().trim()
    );

    aluno.setEmail(
            txtEmail.getText().trim()
    );

    AlunoDAO dao =
            new AlunoDAO();

    boolean alterado =
            dao.alterar(aluno);

    if (alterado) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno alterado com sucesso!",
                "Alteração concluída",
                JOptionPane.INFORMATION_MESSAGE
        );

        limparCamposEdicao();

        carregarTabela();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível alterar o aluno.",
                "Erro na alteração",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
```

---

# 🧹 Criando o método limparCamposEdicao

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

# 🖱️ Programando o botão Cancelar edição

```java
private void btnCancelarEdicaoActionPerformed(
        java.awt.event.ActionEvent evt) {

    limparCamposEdicao();
}
```

---

# 🔒 Habilitando e desabilitando os campos

Posso iniciar os campos desabilitados:

```java
private void desabilitarCamposEdicao() {

    txtNome.setEnabled(false);
    txtTurma.setEnabled(false);
    txtEmail.setEnabled(false);

    btnAlterar.setEnabled(false);
    btnCancelarEdicao.setEnabled(false);
}
```

Quando carregar um aluno:

```java
private void habilitarCamposEdicao() {

    txtNome.setEnabled(true);
    txtTurma.setEnabled(true);
    txtEmail.setEnabled(true);

    btnAlterar.setEnabled(true);
    btnCancelarEdicao.setEnabled(true);

    txtNome.requestFocus();
}
```

---

# 🔄 Integrando com carregarAlunoSelecionado

No final do método:

```java
habilitarCamposEdicao();
```

Exemplo:

```java
private void carregarAlunoSelecionado() {

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

    txtId.setText(
            tblAlunos.getValueAt(
                    linhaSelecionada,
                    0
            ).toString()
    );

    txtNome.setText(
            tblAlunos.getValueAt(
                    linhaSelecionada,
                    1
            ).toString()
    );

    txtTurma.setText(
            tblAlunos.getValueAt(
                    linhaSelecionada,
                    2
            ).toString()
    );

    txtEmail.setText(
            tblAlunos.getValueAt(
                    linhaSelecionada,
                    3
            ).toString()
    );

    habilitarCamposEdicao();
}
```

---

# 🧱 Configuração recomendada no construtor

```java
public TelaConsultaAluno() {

    initComponents();

    setTitle(
            "Consulta de Alunos"
    );

    setLocationRelativeTo(null);

    txtId.setEnabled(false);

    desabilitarCamposEdicao();

    carregarTabela();
}
```

---

# 📌 Seleção única na tabela

Para evitar selecionar várias linhas:

```java
tblAlunos.setSelectionMode(
        javax.swing.ListSelectionModel
                .SINGLE_SELECTION
);
```

Essa configuração pode ser colocada em:

```java
private void configurarTabela()
```

---

# 💻 Método configurarTabela

```java
private void configurarTabela() {

    tblAlunos.setSelectionMode(
            javax.swing.ListSelectionModel
                    .SINGLE_SELECTION
    );

    tblAlunos.getTableHeader()
            .setReorderingAllowed(false);
}
```

No construtor:

```java
configurarTabela();
```

---

# 🔄 Fluxograma completo da alteração

```text
Selecionar aluno na JTable
          │
          ▼
Carregar dados nos campos
          │
          ▼
Editar informações
          │
          ▼
Clicar em Alterar
          │
          ▼
Validar campos
          │
     ┌────┴────┐
     │         │
 Inválidos   Válidos
     │         │
     ▼         ▼
Mostrar     Solicitar
mensagem    confirmação
               │
          ┌────┴────┐
          │         │
         Não       Sim
          │         │
          ▼         ▼
       Cancelar   Criar objeto
                     │
                     ▼
             AlunoDAO.alterar()
                     │
               ┌─────┴─────┐
               │           │
            Sucesso       Erro
               │           │
               ▼           ▼
          Atualizar      Mostrar
          tabela         mensagem
```

---

# 🔬 Por baixo dos panos

Quando clico em **Alterar**:

1. A tela verifica se existe um aluno selecionado;
2. Os campos são validados;
3. O sistema solicita confirmação;
4. Um objeto `Aluno` é criado;
5. O ID identifica o registro;
6. O DAO monta o `PreparedStatement`;
7. O PostgreSQL executa o `UPDATE`;
8. O número de linhas alteradas é verificado;
9. O DAO retorna `true` ou `false`;
10. A tela exibe a mensagem;
11. Os campos são limpos;
12. A tabela é carregada novamente.

---

# 💼 Como as empresas fazem?

Em aplicações profissionais, a alteração pode envolver:

- Validação de regras de negócio;
- Verificação de dados duplicados;
- Registro de auditoria;
- Histórico de alterações;
- Controle de usuário;
- Data e hora da modificação;
- Confirmação de permissões;
- Controle de concorrência.

Também é comum separar:

```text
Tela
Controller
Service
DAO
Banco
```

A camada `Service` valida regras antes de chamar o DAO.

---

# ⚠️ Erros comuns

## Erro 1 — Alterar sem selecionar uma linha

### Solução

```java
if (tblAlunos.getSelectedRow() == -1)
```

---

## Erro 2 — Esquecer o WHERE

### Problema

Todos os registros podem ser alterados.

### Solução

```sql
WHERE id = ?
```

---

## Erro 3 — Alterar o ID

### Problema

O ID é a chave do registro.

### Solução

```java
txtId.setEnabled(false);
```

---

## Erro 4 — Ordem incorreta dos parâmetros

### Solução

Conferir a ordem do SQL e dos métodos `set`.

---

## Erro 5 — Tabela não atualiza

### Solução

Depois da alteração:

```java
carregarTabela();
```

---

## Erro 6 — Campos permanecem preenchidos

### Solução

```java
limparCamposEdicao();
```

---

## Erro 7 — `NumberFormatException` no ID

### Causa

O campo ID contém valor inválido.

### Solução

Como o ID vem da tabela e fica desabilitado, esse erro é evitado.

---

# 🧪 Laboratório prático

## Teste 1 — Alteração normal

1. Selecione um aluno;
2. Carregue os dados;
3. Altere o nome;
4. Clique em Alterar;
5. Confirme;
6. Verifique a tabela.

## Teste 2 — Cancelar confirmação

1. Altere um campo;
2. Clique em Alterar;
3. Escolha Não;
4. Confirme que o banco não foi alterado.

## Teste 3 — Campo vazio

1. Apague o nome;
2. Clique em Alterar;
3. Verifique a validação.

## Teste 4 — E-mail inválido

1. Remova o `@`;
2. Clique em Alterar;
3. Confirme a mensagem.

## Teste 5 — Nenhuma linha selecionada

1. Limpe a seleção;
2. Clique para carregar ou alterar;
3. Verifique o aviso.

## Teste 6 — Conferência no PostgreSQL

Execute:

```sql
SELECT *
FROM alunos
ORDER BY id;
```

Confirme os dados alterados.

---

# 💡 Dicas do Professor

> 💡 Nunca permita alteração sem um ID válido.

> 💡 Sempre utilize `WHERE` no `UPDATE`.

> 💡 Solicite confirmação antes de modificar dados.

> 💡 Atualize a tabela depois da alteração.

> 💡 Desabilite o campo ID.

> 💡 Mantenha apenas uma linha selecionada.

> 💡 Centralize a limpeza dos campos em um método.

---

# 🧠 Curiosidade

O comando SQL:

```sql
UPDATE
```

não retorna registros.

Ele retorna a quantidade de linhas afetadas.

Por isso, utilizo:

```java
executeUpdate()
```

e não:

```java
executeQuery()
```

---

# 🏆 Mini desafio 1

Altere a cor do botão **Alterar** quando os campos estiverem habilitados.

---

# 🏆 Mini desafio 2

Exiba no título da tela:

```text
Editando aluno ID 5
```

quando um aluno for carregado.

---

# 🏆 Mini desafio 3

Impeça a alteração quando nenhum campo tiver sido modificado.

Para isso, armazene os valores originais e compare antes do `UPDATE`.

---

# 🏆 Desafio adicional

Adicione uma coluna no banco:

```sql
data_atualizacao TIMESTAMP
```

No `UPDATE`, utilize:

```sql
data_atualizacao = CURRENT_TIMESTAMP
```

Depois, exiba essa informação em uma nova coluna da `JTable`.

---

# ✅ Checklist de implementação

- [ ] Criar campos de edição;
- [ ] Desabilitar o campo ID;
- [ ] Selecionar apenas uma linha;
- [ ] Criar `carregarAlunoSelecionado()`;
- [ ] Capturar os valores da tabela;
- [ ] Criar `validarCamposEdicao()`;
- [ ] Criar `AlunoDAO.alterar()`;
- [ ] Executar `UPDATE`;
- [ ] Utilizar `WHERE id = ?`;
- [ ] Solicitar confirmação;
- [ ] Criar o objeto `Aluno`;
- [ ] Verificar o retorno booleano;
- [ ] Limpar os campos;
- [ ] Atualizar a tabela;
- [ ] Testar a alteração no PostgreSQL.

---

# 📝 Resumo da aula

Nesta etapa, implementei a alteração dos dados de um aluno selecionado na `JTable`.

Aprendi a:

- Selecionar uma linha;
- Capturar valores da tabela;
- Preencher campos de edição;
- Validar dados;
- Executar `UPDATE`;
- Utilizar parâmetros;
- Confirmar uma alteração;
- Atualizar a interface;
- Trabalhar com retorno booleano;
- Manter o ID protegido.

Agora a tela já permite:

```text
Listar
Localizar
Selecionar
Alterar
```

---

# 🚀 Próxima etapa

Na **Parte 5.8**, implementarei a exclusão de um aluno selecionado na `JTable`, utilizando confirmação, o método `excluir()` no `AlunoDAO`, o comando SQL `DELETE` e a atualização automática da tabela.
