# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.6 — Localizando Alunos por ID, Nome ou E-mail

## 🎯 Objetivos da aula

Nesta etapa, vou implementar a pesquisa de alunos na tela `TelaConsultaAluno`.

O usuário poderá escolher o tipo de pesquisa e localizar registros utilizando:

- ID;
- Nome;
- E-mail.

Ao final desta parte, eu serei capaz de:

- Utilizar um `JComboBox` para definir o tipo de pesquisa;
- Capturar o valor digitado no campo de pesquisa;
- Validar os dados informados;
- Criar métodos de consulta na classe `AlunoDAO`;
- Pesquisar por ID;
- Pesquisar por parte do nome;
- Pesquisar por parte do e-mail;
- Utilizar `PreparedStatement` com parâmetros;
- Trabalhar com o operador SQL `LIKE`;
- Exibir os resultados na `JTable`;
- Informar quando nenhum aluno for encontrado;
- Selecionar automaticamente um registro localizado.

---

# 🧭 O que será desenvolvido?

Na tela `TelaConsultaAluno`, já possuo:

```text
cbTipoPesquisa
txtPesquisa
btnLocalizar
tblAlunos
```

O usuário seguirá este fluxo:

```text
Escolher o tipo de pesquisa
          │
          ▼
Digitar o valor
          │
          ▼
Clicar em Localizar
          │
          ▼
Consultar o PostgreSQL
          │
          ▼
Exibir o resultado na JTable
```

---

# 🖼️ Exemplo da tela

```text
+------------------------------------------------------------------+
|                    CONSULTA DE ALUNOS                             |
+------------------------------------------------------------------+

 Pesquisar por: [Nome ▼] [________________________] [Localizar]

+------------------------------------------------------------------+
| ID | Nome                | Turma       | E-mail                  |
|----|---------------------|-------------|-------------------------|
| 3  | Carla Mendes        | DS-01       | carla@email.com         |
+------------------------------------------------------------------+
```

---

# 🧩 Opções do JComboBox

O componente:

```text
cbTipoPesquisa
```

poderá conter:

```text
ID
Nome
E-mail
```

No NetBeans, posso configurar a propriedade `model`:

```java
new javax.swing.DefaultComboBoxModel<>(
    new String[] {
        "ID",
        "Nome",
        "E-mail"
    }
)
```

---

# 🧠 Estratégia da pesquisa

Para deixar o código organizado, criarei três métodos na classe `AlunoDAO`:

```java
buscarPorId(int id)
buscarPorNome(String nome)
buscarPorEmail(String email)
```

Cada método terá uma responsabilidade específica.

---

# 🔎 Pesquisa por ID

O ID identifica apenas um registro.

Por isso, o método poderá retornar:

```java
Aluno
```

ou:

```java
null
```

---

# 💻 Método buscarPorId

```java
public Aluno buscarPorId(int id) {

    String sql =
            "SELECT id, nome, turma, email "
            + "FROM alunos "
            + "WHERE id = ?";

    try {

        Connection conexao =
                Conexao.conectar();

        if (conexao == null) {

            return null;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet resultado =
                stmt.executeQuery();

        if (resultado.next()) {

            Aluno aluno = new Aluno();

            aluno.setId(
                    resultado.getInt("id")
            );

            aluno.setNome(
                    resultado.getString("nome")
            );

            aluno.setTurma(
                    resultado.getString("turma")
            );

            aluno.setEmail(
                    resultado.getString("email")
            );

            resultado.close();
            stmt.close();
            conexao.close();

            return aluno;
        }

        resultado.close();
        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao buscar aluno por ID: "
                + erro.getMessage()
        );
    }

    return null;
}
```

---

# 🔍 Explicando a consulta por ID

## SQL utilizado

```sql
SELECT id, nome, turma, email
FROM alunos
WHERE id = ?
```

O símbolo:

```text
?
```

representa um parâmetro.

O valor será informado com:

```java
stmt.setInt(1, id);
```

---

# 🧠 Por que retornar `null`?

Se nenhum aluno possuir o ID informado, o método retorna:

```java
null
```

Na tela, poderei verificar:

```java
if (aluno == null) {
```

e exibir uma mensagem.

---

# 🔎 Pesquisa por nome

A pesquisa por nome pode retornar vários registros.

Por exemplo, ao pesquisar:

```text
Ana
```

o banco poderá encontrar:

```text
Ana Souza
Ana Paula
Mariana Alves
```

Por isso, o método retornará:

```java
List<Aluno>
```

---

# 💻 Método buscarPorNome

```java
public List<Aluno> buscarPorNome(
        String nome) {

    List<Aluno> lista =
            new ArrayList<>();

    String sql =
            "SELECT id, nome, turma, email "
            + "FROM alunos "
            + "WHERE LOWER(nome) LIKE LOWER(?) "
            + "ORDER BY nome";

    try {

        Connection conexao =
                Conexao.conectar();

        if (conexao == null) {

            return lista;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(
                1,
                "%" + nome + "%"
        );

        ResultSet resultado =
                stmt.executeQuery();

        while (resultado.next()) {

            Aluno aluno = new Aluno();

            aluno.setId(
                    resultado.getInt("id")
            );

            aluno.setNome(
                    resultado.getString("nome")
            );

            aluno.setTurma(
                    resultado.getString("turma")
            );

            aluno.setEmail(
                    resultado.getString("email")
            );

            lista.add(aluno);
        }

        resultado.close();
        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao buscar aluno por nome: "
                + erro.getMessage()
        );
    }

    return lista;
}
```

---

# 🧠 Entendendo o LIKE

O operador:

```sql
LIKE
```

permite buscar partes de um texto.

Exemplo:

```sql
WHERE nome LIKE '%ana%'
```

O caractere:

```text
%
```

representa qualquer quantidade de caracteres.

---

# 🔍 Exemplos de LIKE

## Começa com Ana

```sql
WHERE nome LIKE 'Ana%'
```

## Termina com Silva

```sql
WHERE nome LIKE '%Silva'
```

## Contém Ana em qualquer posição

```sql
WHERE nome LIKE '%Ana%'
```

No projeto, utilizarei:

```java
"%" + nome + "%"
```

Assim, a pesquisa será mais flexível.

---

# 🔠 Ignorando maiúsculas e minúsculas

Utilizarei:

```sql
LOWER(nome) LIKE LOWER(?)
```

Isso permite localizar:

```text
ANA
Ana
ana
```

sem diferença.

---

# 🔎 Pesquisa por e-mail

A pesquisa por e-mail será semelhante à pesquisa por nome.

Ela também poderá retornar vários registros.

---

# 💻 Método buscarPorEmail

```java
public List<Aluno> buscarPorEmail(
        String email) {

    List<Aluno> lista =
            new ArrayList<>();

    String sql =
            "SELECT id, nome, turma, email "
            + "FROM alunos "
            + "WHERE LOWER(email) LIKE LOWER(?) "
            + "ORDER BY email";

    try {

        Connection conexao =
                Conexao.conectar();

        if (conexao == null) {

            return lista;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(
                1,
                "%" + email + "%"
        );

        ResultSet resultado =
                stmt.executeQuery();

        while (resultado.next()) {

            Aluno aluno = new Aluno();

            aluno.setId(
                    resultado.getInt("id")
            );

            aluno.setNome(
                    resultado.getString("nome")
            );

            aluno.setTurma(
                    resultado.getString("turma")
            );

            aluno.setEmail(
                    resultado.getString("email")
            );

            lista.add(aluno);
        }

        resultado.close();
        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao buscar aluno por e-mail: "
                + erro.getMessage()
        );
    }

    return lista;
}
```

---

# 📦 Imports necessários no AlunoDAO

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;
```

---

# 📊 Criando um método para exibir uma lista na JTable

Na tela `TelaConsultaAluno`, criarei:

```java
private void preencherTabela(
        List<Aluno> lista)
```

---

# 💻 Código do método preencherTabela

```java
private void preencherTabela(
        List<Aluno> lista) {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);

    for (Aluno aluno : lista) {

        modelo.addRow(
                new Object[] {

                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getTurma(),
                    aluno.getEmail()
                }
        );
    }

    lblQuantidade.setText(
            "Total de alunos: "
            + lista.size()
    );
}
```

---

# ♻️ Reaproveitando código

Na Parte 5.5, o método `carregarTabela()` já adicionava os registros à tabela.

Agora, posso reaproveitar a lógica:

```java
private void carregarTabela() {

    AlunoDAO dao =
            new AlunoDAO();

    List<Aluno> lista =
            dao.listar();

    preencherTabela(lista);
}
```

Essa organização evita repetição.

---

# 🖱️ Programando o botão Localizar

O evento será:

```java
private void btnLocalizarActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

Dentro dele:

1. Validarei o campo;
2. Descobrirei o tipo de pesquisa;
3. Chamarei o método correspondente;
4. Exibirei o resultado.

---

# ✅ Validando o campo de pesquisa

```java
String pesquisa =
        txtPesquisa.getText().trim();

if (pesquisa.isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Informe um valor para pesquisa.",
            "Campo obrigatório",
            JOptionPane.WARNING_MESSAGE
    );

    txtPesquisa.requestFocus();
    return;
}
```

---

# 🧩 Capturando a opção selecionada

```java
String tipoPesquisa =
        cbTipoPesquisa
                .getSelectedItem()
                .toString();
```

Se o usuário escolher:

```text
Nome
```

a variável conterá:

```java
"Nome"
```

---

# 💻 Estrutura inicial do botão

```java
private void btnLocalizarActionPerformed(
        java.awt.event.ActionEvent evt) {

    String pesquisa =
            txtPesquisa.getText().trim();

    if (pesquisa.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe um valor para pesquisa.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtPesquisa.requestFocus();
        return;
    }

    String tipoPesquisa =
            cbTipoPesquisa
                    .getSelectedItem()
                    .toString();

    AlunoDAO dao =
            new AlunoDAO();
}
```

---

# 🔎 Tratando a pesquisa por ID

Para transformar o texto em número:

```java
int id =
        Integer.parseInt(pesquisa);
```

Porém, se o usuário digitar letras, ocorrerá:

```text
NumberFormatException
```

Por isso, utilizarei `try-catch`.

---

# 💻 Código da pesquisa por ID

```java
if (tipoPesquisa.equals("ID")) {

    try {

        int id =
                Integer.parseInt(pesquisa);

        Aluno aluno =
                dao.buscarPorId(id);

        if (aluno == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum aluno encontrado.",
                    "Resultado da pesquisa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limparTabela();

            return;
        }

        List<Aluno> lista =
                new ArrayList<>();

        lista.add(aluno);

        preencherTabela(lista);

        tblAlunos.setRowSelectionInterval(
                0,
                0
        );

    } catch (NumberFormatException erro) {

        JOptionPane.showMessageDialog(
                this,
                "Para pesquisar por ID, digite apenas números.",
                "ID inválido",
                JOptionPane.WARNING_MESSAGE
        );

        txtPesquisa.requestFocus();
    }
}
```

---

# 🔍 Por que criar uma lista com um único aluno?

O método:

```java
preencherTabela()
```

recebe uma lista.

Como a pesquisa por ID retorna apenas um aluno, crio uma lista temporária:

```java
List<Aluno> lista =
        new ArrayList<>();

lista.add(aluno);
```

Assim, posso utilizar o mesmo método de preenchimento.

---

# 🔎 Tratando a pesquisa por nome

```java
if (tipoPesquisa.equals("Nome")) {

    List<Aluno> lista =
            dao.buscarPorNome(pesquisa);

    if (lista.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Nenhum aluno encontrado.",
                "Resultado da pesquisa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    preencherTabela(lista);
}
```

---

# 🔎 Tratando a pesquisa por e-mail

```java
if (tipoPesquisa.equals("E-mail")) {

    List<Aluno> lista =
            dao.buscarPorEmail(pesquisa);

    if (lista.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Nenhum aluno encontrado.",
                "Resultado da pesquisa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    preencherTabela(lista);
}
```

---

# ⭐ Código completo do botão Localizar

```java
private void btnLocalizarActionPerformed(
        java.awt.event.ActionEvent evt) {

    String pesquisa =
            txtPesquisa.getText().trim();

    if (pesquisa.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe um valor para pesquisa.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtPesquisa.requestFocus();
        return;
    }

    String tipoPesquisa =
            cbTipoPesquisa
                    .getSelectedItem()
                    .toString();

    AlunoDAO dao =
            new AlunoDAO();

    if (tipoPesquisa.equals("ID")) {

        try {

            int id =
                    Integer.parseInt(pesquisa);

            Aluno aluno =
                    dao.buscarPorId(id);

            if (aluno == null) {

                limparTabela();

                lblQuantidade.setText(
                        "Total de alunos: 0"
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum aluno encontrado.",
                        "Resultado da pesquisa",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

            List<Aluno> lista =
                    new ArrayList<>();

            lista.add(aluno);

            preencherTabela(lista);

            tblAlunos.setRowSelectionInterval(
                    0,
                    0
            );

        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                    this,
                    "Para pesquisar por ID, digite apenas números.",
                    "ID inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            txtPesquisa.requestFocus();
        }

    } else if (tipoPesquisa.equals("Nome")) {

        List<Aluno> lista =
                dao.buscarPorNome(pesquisa);

        preencherTabela(lista);

        if (lista.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum aluno encontrado.",
                    "Resultado da pesquisa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    } else if (
            tipoPesquisa.equals("E-mail")) {

        List<Aluno> lista =
                dao.buscarPorEmail(pesquisa);

        preencherTabela(lista);

        if (lista.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum aluno encontrado.",
                    "Resultado da pesquisa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
```

---

# 📦 Imports necessários na tela

```java
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;
```

---

# 🧹 Método limparTabela

```java
private void limparTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);
}
```

---

# 🖱️ Pesquisando ao pressionar Enter

Também posso executar a pesquisa quando o usuário pressionar Enter no campo.

No evento `ActionPerformed` de `txtPesquisa`:

```java
private void txtPesquisaActionPerformed(
        java.awt.event.ActionEvent evt) {

    btnLocalizar.doClick();
}
```

O método:

```java
doClick()
```

simula um clique no botão.

---

# 🔄 Restaurando a listagem completa

O botão **Listar Todos** poderá:

1. Limpar o campo de pesquisa;
2. Carregar todos os alunos.

```java
private void btnListarActionPerformed(
        java.awt.event.ActionEvent evt) {

    txtPesquisa.setText("");

    carregarTabela();

    txtPesquisa.requestFocus();
}
```

---

# 🧠 Pesquisa exata ou parcial?

## Pesquisa por ID

É exata:

```sql
WHERE id = ?
```

## Pesquisa por nome

É parcial:

```sql
WHERE nome LIKE ?
```

## Pesquisa por e-mail

É parcial:

```sql
WHERE email LIKE ?
```

Essa diferença ocorre porque o ID identifica um único registro, enquanto nome e e-mail podem ser pesquisados por trechos.

---

# 🔐 Segurança com PreparedStatement

Nunca devo criar o SQL assim:

```java
String sql =
        "SELECT * FROM alunos "
        + "WHERE nome = '"
        + nome
        + "'";
```

Essa prática:

- Mistura dados com o SQL;
- Pode gerar erros;
- Facilita ataques de SQL Injection;
- Dificulta a manutenção.

A forma correta é:

```java
String sql =
        "SELECT * FROM alunos "
        + "WHERE nome LIKE ?";

PreparedStatement stmt =
        conexao.prepareStatement(sql);

stmt.setString(
        1,
        "%" + nome + "%"
);
```

---

# 🔄 Fluxograma completo da pesquisa

```text
Clique em Localizar
        │
        ▼
Campo está vazio?
        │
   ┌────┴────┐
   │         │
  Sim       Não
   │         │
   ▼         ▼
Exibir     Identificar
aviso      tipo de pesquisa
             │
      ┌──────┼──────┐
      │      │      │
     ID     Nome   E-mail
      │      │      │
      ▼      ▼      ▼
 buscar   buscar   buscar
 por ID   por nome por e-mail
      │      │      │
      └──────┼──────┘
             ▼
      Resultado encontrado?
             │
        ┌────┴────┐
        │         │
       Sim       Não
        │         │
        ▼         ▼
Preencher      Exibir
JTable         mensagem
```

---

# 🔬 Por baixo dos panos

Quando clico em **Localizar**:

1. O evento do botão é executado;
2. A tela captura o texto digitado;
3. O `JComboBox` informa o tipo da pesquisa;
4. O DAO prepara o SQL correspondente;
5. O valor é associado ao parâmetro;
6. O PostgreSQL executa a consulta;
7. O `ResultSet` recebe os registros;
8. Os registros viram objetos `Aluno`;
9. A lista é devolvida para a tela;
10. A tabela é limpa;
11. Os resultados são exibidos;
12. A quantidade de registros é atualizada.

---

# 💼 Como as empresas fazem?

Em sistemas profissionais, pesquisas costumam oferecer:

- Busca por vários campos;
- Paginação;
- Filtros combinados;
- Pesquisa enquanto o usuário digita;
- Ordenação;
- Histórico de filtros;
- Exportação dos resultados;
- Indicadores de carregamento;
- Mensagens de erro amigáveis.

Também é comum criar um único objeto de filtro:

```java
FiltroAluno
```

com atributos como:

```text
id
nome
turma
email
```

Neste projeto, utilizarei métodos separados para tornar o aprendizado mais simples.

---

# ⚠️ Erros comuns

## Erro 1 — Digitar letras ao pesquisar por ID

### Erro

```text
NumberFormatException
```

### Solução

Utilizar:

```java
try-catch
```

---

## Erro 2 — A tabela mantém os resultados anteriores

### Causa

A tabela não foi limpa.

### Solução

```java
modelo.setRowCount(0);
```

---

## Erro 3 — Pesquisa diferencia maiúsculas

### Solução

Utilizar:

```sql
LOWER(nome) LIKE LOWER(?)
```

---

## Erro 4 — Nome não encontrado mesmo existindo

### Causa

A consulta está usando igualdade:

```sql
WHERE nome = ?
```

### Solução

Utilizar:

```sql
WHERE nome LIKE ?
```

com:

```java
"%" + nome + "%"
```

---

## Erro 5 — NullPointerException no JComboBox

### Causa

Nenhuma opção está selecionada.

### Solução

Garantir que o `JComboBox` possua itens e uma opção selecionada.

---

## Erro 6 — Colunas em ordem incorreta

### Solução

Manter a mesma ordem:

```text
ID
Nome
Turma
E-mail
```

---

# 🧪 Laboratório prático

## Teste 1 — Pesquisa por ID

1. Escolha `ID`;
2. Digite um ID existente;
3. Clique em Localizar;
4. Confirme o resultado.

## Teste 2 — ID inexistente

1. Digite um ID que não existe;
2. Clique em Localizar;
3. Verifique a mensagem.

## Teste 3 — ID inválido

1. Escolha `ID`;
2. Digite letras;
3. Clique em Localizar;
4. Confirme a validação.

## Teste 4 — Pesquisa parcial por nome

1. Escolha `Nome`;
2. Digite parte de um nome;
3. Verifique todos os resultados.

## Teste 5 — Pesquisa por e-mail

1. Escolha `E-mail`;
2. Digite parte do domínio;
3. Exemplo:

```text
gmail
```

4. Verifique os resultados.

## Teste 6 — Enter no campo

1. Digite o valor;
2. Pressione Enter;
3. Confirme se a pesquisa é executada.

---

# 💡 Dicas do Professor

> 💡 Utilize `LIKE` para pesquisas parciais.

> 💡 Utilize `=` para pesquisas exatas por ID.

> 💡 Sempre valide o campo antes de consultar.

> 💡 Trate `NumberFormatException`.

> 💡 Reutilize `preencherTabela()`.

> 💡 Use `PreparedStatement` em todas as consultas.

> 💡 Mostre mensagens claras quando nenhum registro for encontrado.

---

# 🧠 Curiosidade

No PostgreSQL, também existe o operador:

```sql
ILIKE
```

Ele realiza pesquisas sem diferenciar maiúsculas e minúsculas.

Exemplo:

```sql
WHERE nome ILIKE ?
```

Assim, o método poderia utilizar:

```java
String sql =
        "SELECT * FROM alunos "
        + "WHERE nome ILIKE ?";
```

O `ILIKE` é específico do PostgreSQL.

A versão com:

```sql
LOWER(nome) LIKE LOWER(?)
```

é mais fácil de adaptar para outros bancos de dados.

---

# 🏆 Mini desafio 1

Adicione a opção:

```text
Turma
```

ao `JComboBox`.

Crie:

```java
buscarPorTurma(String turma)
```

---

# 🏆 Mini desafio 2

Depois de uma pesquisa com apenas um resultado, selecione automaticamente a primeira linha:

```java
if (lista.size() == 1) {

    tblAlunos.setRowSelectionInterval(
            0,
            0
    );
}
```

---

# 🏆 Mini desafio 3

Altere a cor de fundo do campo quando a pesquisa estiver vazia e restaure a cor após a correção.

---

# 🏆 Desafio adicional

Crie um único método no DAO:

```java
public List<Aluno> pesquisar(
        String tipo,
        String valor)
```

O método deverá decidir qual SQL utilizar.

Depois, compare essa solução com os métodos separados:

```java
buscarPorId()
buscarPorNome()
buscarPorEmail()
```

Analise qual versão é mais fácil de entender e manter.

---

# ✅ Checklist de implementação

- [ ] Configurar o `JComboBox`;
- [ ] Criar `buscarPorId()`;
- [ ] Criar `buscarPorNome()`;
- [ ] Criar `buscarPorEmail()`;
- [ ] Utilizar `PreparedStatement`;
- [ ] Utilizar `LIKE`;
- [ ] Utilizar parâmetros;
- [ ] Validar o campo de pesquisa;
- [ ] Tratar ID inválido;
- [ ] Criar `preencherTabela()`;
- [ ] Exibir resultados;
- [ ] Exibir mensagem quando não encontrar;
- [ ] Atualizar a quantidade;
- [ ] Pesquisar com Enter;
- [ ] Restaurar a lista completa;
- [ ] Testar todos os tipos de pesquisa.

---

# 📝 Resumo da aula

Nesta etapa, implementei a localização de alunos por:

```text
ID
Nome
E-mail
```

Aprendi a:

- Capturar a opção do `JComboBox`;
- Validar o valor digitado;
- Pesquisar por ID;
- Pesquisar textos com `LIKE`;
- Ignorar diferenças entre maiúsculas e minúsculas;
- Trabalhar com listas de resultados;
- Preencher a `JTable`;
- Tratar pesquisas sem resultado;
- Utilizar `PreparedStatement`;
- Evitar SQL Injection.

Agora a tela de consulta já permite listar e localizar registros específicos no PostgreSQL.

---

# 🚀 Próxima etapa

Na **Parte 5.7**, implementarei a seleção de um aluno na `JTable` e a alteração dos seus dados no PostgreSQL, utilizando o botão **Alterar**, campos de edição, confirmação e atualização automática da tabela.
