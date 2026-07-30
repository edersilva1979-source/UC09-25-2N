# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.4 — Programando o Botão Consulta e Criando a Tela de Gerenciamento de Alunos

## 🎯 Objetivos da aula

Nesta etapa, vou programar o botão **Consulta** da tela `TelaCadastroAluno`.

Também criarei uma nova tela chamada `TelaConsultaAluno`, responsável por concentrar as operações de:

- Listar alunos;
- Localizar um aluno;
- Alterar dados;
- Excluir registros;
- Atualizar a tabela;
- Retornar para a tela de cadastro.

Ao final desta parte, eu serei capaz de:

- Criar uma nova tela com `JFrame Form`;
- Navegar entre telas;
- Abrir uma nova janela pelo clique de um botão;
- Trabalhar com `setVisible(true)`;
- Utilizar `dispose()` corretamente;
- Adicionar uma `JTable`;
- Criar os botões da tela de consulta;
- Organizar a interface para futuras operações CRUD;
- Compreender o fluxo entre cadastro, consulta e banco de dados.

---

# 🧭 O que será desenvolvido?

Na tela `TelaCadastroAluno`, já possuo os botões:

```text
Cadastrar
Limpar
Consulta
Sair
```

Agora, o botão **Consulta** abrirá uma nova tela:

```text
TelaConsultaAluno
```

Essa tela exibirá os registros cadastrados no PostgreSQL e permitirá realizar outras operações.

---

# 🏗️ Arquitetura das telas

```text
TelaCadastroAluno
        │
        │ clique em Consulta
        ▼
TelaConsultaAluno
        │
        ├── Listar
        ├── Localizar
        ├── Alterar
        ├── Excluir
        └── Voltar
```

A nova tela será responsável por apresentar os dados, mas continuará utilizando a classe `AlunoDAO` para acessar o banco.

```text
TelaConsultaAluno
        │
        ▼
     AlunoDAO
        │
        ▼
      Conexao
        │
        ▼
    PostgreSQL
```

---

# 📁 Organização do projeto

A estrutura poderá ficar assim:

```text
src
├── dao
│   └── AlunoDAO.java
│
├── model
│   └── Aluno.java
│
├── util
│   └── Conexao.java
│
└── view
    ├── TelaCadastroAluno.java
    └── TelaConsultaAluno.java
```

---

# 🖼️ Criando a nova tela

No NetBeans:

1. Clique com o botão direito no pacote `view`;
2. Selecione **New**;
3. Escolha **JFrame Form**;
4. Informe o nome:

```text
TelaConsultaAluno
```

5. Clique em **Finish**.

O NetBeans criará uma nova classe semelhante a:

```java
public class TelaConsultaAluno
        extends javax.swing.JFrame {

    public TelaConsultaAluno() {

        initComponents();
    }
}
```

---

# 🪟 Configurando a tela

No construtor, posso centralizar a janela:

```java
public TelaConsultaAluno() {

    initComponents();

    setLocationRelativeTo(null);
}
```

Também posso definir um título:

```java
setTitle("Consulta de Alunos");
```

A versão completa será:

```java
public TelaConsultaAluno() {

    initComponents();

    setTitle("Consulta de Alunos");

    setLocationRelativeTo(null);
}
```

---

# 🎨 Componentes da tela de consulta

A tela poderá utilizar os seguintes componentes:

| Componente | Nome da variável | Função |
|---|---|---|
| `JLabel` | `lblTitulo` | Título da tela |
| `JLabel` | `lblPesquisa` | Identificar o campo de pesquisa |
| `JTextField` | `txtPesquisa` | Receber ID, nome ou e-mail |
| `JComboBox` | `cbTipoPesquisa` | Definir o tipo da pesquisa |
| `JButton` | `btnLocalizar` | Pesquisar aluno |
| `JButton` | `btnListar` | Listar todos os alunos |
| `JButton` | `btnAlterar` | Alterar o registro selecionado |
| `JButton` | `btnExcluir` | Excluir o registro selecionado |
| `JButton` | `btnAtualizar` | Atualizar a tabela |
| `JButton` | `btnVoltar` | Retornar à tela anterior |
| `JTable` | `tblAlunos` | Exibir os registros |
| `JScrollPane` | `jScrollPane1` | Permitir rolagem da tabela |

---

# 🖼️ Sugestão de layout

```text
+------------------------------------------------------------------+
|                    CONSULTA DE ALUNOS                             |
+------------------------------------------------------------------+

 Pesquisar por: [ID ▼]  [____________________________] [Localizar]

 [Listar Todos] [Atualizar] [Alterar] [Excluir] [Voltar]

+------------------------------------------------------------------+
| ID | Nome                | Turma       | E-mail                  |
|----|---------------------|-------------|-------------------------|
| 1  | Ana Souza           | DS-01       | ana@email.com           |
| 2  | Bruno Lima          | DS-02       | bruno@email.com         |
| 3  | Carla Mendes        | DS-01       | carla@email.com         |
+------------------------------------------------------------------+
```

---

# 📊 Criando a `JTable`

No editor visual do NetBeans:

1. Localize o componente **Table** na paleta;
2. Arraste-o para o formulário;
3. O NetBeans adicionará automaticamente uma `JTable` dentro de um `JScrollPane`;
4. Renomeie a variável para:

```text
tblAlunos
```

---

# 🧩 Configurando as colunas da tabela

Selecione a tabela e abra a propriedade **model**.

Crie quatro colunas:

```text
ID
Nome
Turma
E-mail
```

O modelo inicial poderá ser semelhante a:

```java
new javax.swing.table.DefaultTableModel(
    new Object [][] {

    },
    new String [] {
        "ID", "Nome", "Turma", "E-mail"
    }
)
```

---

# ⚠️ Tabela vazia inicialmente

A tabela poderá iniciar sem linhas:

```java
new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] {
        "ID", "Nome", "Turma", "E-mail"
    }
)
```

Os dados serão carregados posteriormente utilizando o `AlunoDAO`.

---

# 🔒 Impedindo edição direta na tabela

Por padrão, o usuário pode tentar editar as células.

Para evitar isso, posso utilizar um modelo personalizado:

```java
DefaultTableModel modelo =
        new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID",
                    "Nome",
                    "Turma",
                    "E-mail"
                }
        ) {

    @Override
    public boolean isCellEditable(
            int row,
            int column) {

        return false;
    }
};
```

Depois:

```java
tblAlunos.setModel(modelo);
```

---

# 📦 Import necessário

Para trabalhar com o modelo da tabela:

```java
import javax.swing.table.DefaultTableModel;
```

---

# 🖱️ Programando o botão Consulta

Na tela `TelaCadastroAluno`:

1. Abra a aba **Design**;
2. Dê dois cliques no botão **Consulta**;
3. O NetBeans criará o evento.

Exemplo:

```java
private void btnConsultaActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

---

# 💻 Primeira versão da navegação

```java
private void btnConsultaActionPerformed(
        java.awt.event.ActionEvent evt) {

    TelaConsultaAluno tela =
            new TelaConsultaAluno();

    tela.setVisible(true);
}
```

---

# 🔍 Explicando o código

## Criando a nova tela

```java
TelaConsultaAluno tela =
        new TelaConsultaAluno();
```

Crio um objeto da classe `TelaConsultaAluno`.

Esse objeto representa a nova janela.

## Exibindo a janela

```java
tela.setVisible(true);
```

O método `setVisible(true)` torna a janela visível.

Sem essa linha, o objeto será criado, mas a tela não aparecerá.

---

# 🪟 Manter ou fechar a tela de cadastro?

Existem duas possibilidades.

## Opção 1 — Manter as duas telas abertas

```java
private void btnConsultaActionPerformed(
        java.awt.event.ActionEvent evt) {

    TelaConsultaAluno tela =
            new TelaConsultaAluno();

    tela.setVisible(true);
}
```

Essa opção mantém a tela de cadastro aberta.

## Opção 2 — Fechar a tela de cadastro

```java
private void btnConsultaActionPerformed(
        java.awt.event.ActionEvent evt) {

    TelaConsultaAluno tela =
            new TelaConsultaAluno();

    tela.setVisible(true);

    dispose();
}
```

Essa opção abre a consulta e fecha a tela atual.

---

# ⭐ Qual opção utilizar?

Para este projeto, utilizarei:

```java
dispose();
```

Assim, evito várias janelas abertas ao mesmo tempo.

O código recomendado será:

```java
private void btnConsultaActionPerformed(
        java.awt.event.ActionEvent evt) {

    TelaConsultaAluno tela =
            new TelaConsultaAluno();

    tela.setVisible(true);

    dispose();
}
```

---

# 🔄 Fluxo da navegação

```text
Clique no botão Consulta
          │
          ▼
Criar TelaConsultaAluno
          │
          ▼
setVisible(true)
          │
          ▼
Fechar TelaCadastroAluno
          │
          ▼
Exibir TelaConsultaAluno
```

---

# ↩️ Criando o botão Voltar

Na tela `TelaConsultaAluno`, adicionarei o botão:

```text
Voltar
```

Nome da variável:

```text
btnVoltar
```

O evento será:

```java
private void btnVoltarActionPerformed(
        java.awt.event.ActionEvent evt) {

    TelaCadastroAluno tela =
            new TelaCadastroAluno();

    tela.setVisible(true);

    dispose();
}
```

---

# 🔄 Navegação entre as duas telas

```text
TelaCadastroAluno
       │
       │ Consulta
       ▼
TelaConsultaAluno
       │
       │ Voltar
       ▼
TelaCadastroAluno
```

---

# ⚠️ Evitando criar várias janelas

Se eu clicar várias vezes em **Consulta**, posso criar várias instâncias da mesma tela.

Como estou utilizando:

```java
dispose();
```

a tela anterior será fechada, evitando esse problema.

Em sistemas maiores, a navegação costuma ser controlada por:

- Tela principal;
- Menu;
- `JDesktopPane`;
- `JInternalFrame`;
- Controladores;
- Padrão MVC.

---

# 🔎 Criando o campo de pesquisa

Na tela `TelaConsultaAluno`, adicionarei:

```text
txtPesquisa
```

Esse campo poderá receber:

- ID;
- Nome;
- E-mail.

Também adicionarei um `JComboBox` chamado:

```text
cbTipoPesquisa
```

Opções:

```text
ID
Nome
E-mail
```

---

# 💻 Criando as opções do `JComboBox`

No NetBeans, selecione o componente e altere a propriedade **model**.

Exemplo:

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

# 🧩 Criando os botões de operação

A tela terá os botões:

```text
Localizar
Listar Todos
Atualizar
Alterar
Excluir
Voltar
```

Sugestão de variáveis:

```java
btnLocalizar
btnListar
btnAtualizar
btnAlterar
btnExcluir
btnVoltar
```

---

# 📊 Preparando o modelo da tabela

Criarei um método:

```java
private DefaultTableModel obterModeloTabela() {

    return (DefaultTableModel)
            tblAlunos.getModel();
}
```

Assim, quando precisar manipular a tabela, poderei utilizar:

```java
DefaultTableModel modelo =
        obterModeloTabela();
```

---

# 🧹 Limpando a tabela

Antes de carregar novos dados, preciso remover as linhas antigas:

```java
private void limparTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);
}
```

---

# 🔍 Explicando `setRowCount(0)`

```java
modelo.setRowCount(0);
```

Essa instrução remove todas as linhas da tabela.

As colunas continuam existindo.

É importante executar essa limpeza antes de uma nova listagem, para evitar registros duplicados.

---

# 🧱 Estrutura inicial da classe

```java
package view;

import javax.swing.table.DefaultTableModel;

public class TelaConsultaAluno
        extends javax.swing.JFrame {

    public TelaConsultaAluno() {

        initComponents();

        setTitle("Consulta de Alunos");

        setLocationRelativeTo(null);
    }

    private void limparTabela() {

        DefaultTableModel modelo =
                (DefaultTableModel)
                        tblAlunos.getModel();

        modelo.setRowCount(0);
    }

    private DefaultTableModel
            obterModeloTabela() {

        return (DefaultTableModel)
                tblAlunos.getModel();
    }
}
```

---

# 🧭 Preparando as próximas operações

Nesta etapa, a nova tela ficará preparada para receber os métodos:

```java
listarAlunos()
localizarAluno()
alterarAluno()
excluirAluno()
atualizarTabela()
```

Esses métodos serão implementados nas próximas partes.

---

# 🔬 Por baixo dos panos

Quando clico no botão **Consulta**:

1. O Swing identifica o clique;
2. O método `btnConsultaActionPerformed()` é executado;
3. Um objeto `TelaConsultaAluno` é criado;
4. O construtor da nova tela executa `initComponents()`;
5. Os componentes são carregados;
6. `setVisible(true)` exibe a tela;
7. `dispose()` fecha a tela anterior;
8. A aplicação continua em execução.

---

# 💼 Como as empresas fazem?

Aplicações desktop profissionais geralmente evitam colocar toda a lógica dentro dos botões.

Uma organização comum será:

```text
TelaConsultaAluno
        │
        ▼
AlunoController
        │
        ▼
AlunoDAO
        │
        ▼
PostgreSQL
```

Neste projeto inicial, utilizarei diretamente:

```text
Tela → DAO → Banco
```

Essa escolha facilita o aprendizado antes de avançar para uma arquitetura mais completa.

---

# ⚠️ Erros comuns

## Erro 1 — Criar a tela e não exibir

```java
TelaConsultaAluno tela =
        new TelaConsultaAluno();
```

### Problema

A tela foi criada, mas não aparece.

### Solução

```java
tela.setVisible(true);
```

---

## Erro 2 — Usar `System.exit(0)`

### Problema

A aplicação inteira será encerrada.

### Solução

Utilizar:

```java
dispose();
```

---

## Erro 3 — Nome da classe incorreto

Exemplo:

```java
new TelaConsultarAluno();
```

quando a classe se chama:

```java
TelaConsultaAluno
```

### Solução

Confirmar o nome exato da classe.

---

## Erro 4 — Classe em outro pacote

### Solução

Adicionar o import:

```java
import view.TelaConsultaAluno;
```

Se as duas telas estiverem no mesmo pacote, o import não será necessário.

---

## Erro 5 — Editar diretamente o `initComponents()`

### Problema

O editor visual pode sobrescrever o código.

### Solução

Criar métodos próprios fora da área protegida.

---

## Erro 6 — Duplicar registros na tabela

### Causa

A tabela não foi limpa antes de listar novamente.

### Solução

```java
modelo.setRowCount(0);
```

---

# 🧪 Laboratório prático

## Etapa 1 — Criar a nova tela

1. Crie `TelaConsultaAluno`;
2. Defina o título;
3. Centralize a janela;
4. Execute para testar.

## Etapa 2 — Criar os componentes

Adicione:

- Campo de pesquisa;
- ComboBox;
- Botão Localizar;
- Botão Listar;
- Botão Atualizar;
- Botão Alterar;
- Botão Excluir;
- Botão Voltar;
- JTable.

## Etapa 3 — Programar Consulta

Na tela de cadastro:

```java
TelaConsultaAluno tela =
        new TelaConsultaAluno();

tela.setVisible(true);

dispose();
```

## Etapa 4 — Programar Voltar

Na tela de consulta:

```java
TelaCadastroAluno tela =
        new TelaCadastroAluno();

tela.setVisible(true);

dispose();
```

## Etapa 5 — Testar navegação

1. Abra a tela de cadastro;
2. Clique em **Consulta**;
3. Verifique se a nova tela aparece;
4. Clique em **Voltar**;
5. Confirme o retorno.

---

# 💡 Dicas do Professor

> 💡 Utilize nomes claros para todos os componentes.

> 💡 Não use `System.exit(0)` para trocar de tela.

> 💡 Centralize as janelas com `setLocationRelativeTo(null)`.

> 💡 Limpe a tabela antes de preencher novamente.

> 💡 Não coloque SQL diretamente na tela.

> 💡 Utilize `JScrollPane` junto com a `JTable`.

---

# 🧠 Curiosidade

Uma `JTable` não armazena os dados diretamente.

Ela utiliza um modelo:

```java
TableModel
```

No projeto, utilizarei:

```java
DefaultTableModel
```

Esse modelo controla:

- Linhas;
- Colunas;
- Valores;
- Inclusão de dados;
- Remoção de dados;
- Atualização visual.

---

# 🏆 Mini desafio 1

Altere o título da janela para:

```text
Sistema Escolar — Consulta de Alunos
```

---

# 🏆 Mini desafio 2

Faça a tela abrir maximizada:

```java
setExtendedState(
        javax.swing.JFrame.MAXIMIZED_BOTH
);
```

Depois, compare a experiência com a tela centralizada em tamanho fixo.

---

# 🏆 Mini desafio 3

Desabilite os botões **Alterar** e **Excluir** inicialmente:

```java
btnAlterar.setEnabled(false);
btnExcluir.setEnabled(false);
```

Eles serão habilitados apenas quando o usuário selecionar uma linha da tabela.

---

# 🏆 Desafio adicional

Crie um rótulo chamado:

```text
lblQuantidade
```

Esse rótulo deverá futuramente exibir:

```text
Total de alunos: 10
```

Por enquanto, deixe o texto:

```text
Total de alunos: 0
```

---

# ✅ Checklist de implementação

- [ ] Criar `TelaConsultaAluno`;
- [ ] Colocar a tela no pacote `view`;
- [ ] Adicionar `JTable`;
- [ ] Criar as colunas da tabela;
- [ ] Adicionar campo de pesquisa;
- [ ] Adicionar `JComboBox`;
- [ ] Criar os botões de operação;
- [ ] Programar o botão Consulta;
- [ ] Programar o botão Voltar;
- [ ] Utilizar `setVisible(true)`;
- [ ] Utilizar `dispose()`;
- [ ] Criar o método `limparTabela()`;
- [ ] Testar a navegação entre telas.

---

# 📝 Resumo da aula

Nesta etapa, programei o botão **Consulta** e criei a tela `TelaConsultaAluno`.

Aprendi a:

- Criar uma nova janela;
- Navegar entre telas;
- Utilizar `setVisible(true)`;
- Fechar a janela atual com `dispose()`;
- Criar uma `JTable`;
- Configurar colunas;
- Preparar campos de pesquisa;
- Criar botões de CRUD;
- Organizar a nova tela para futuras operações.

Agora o sistema possui duas telas principais:

```text
TelaCadastroAluno
TelaConsultaAluno
```

---

# 🚀 Próxima etapa

Na **Parte 5.5**, implementarei a listagem dos alunos na `JTable`, utilizando o método `listar()` da classe `AlunoDAO`, o `DefaultTableModel` e os dados armazenados no PostgreSQL.
