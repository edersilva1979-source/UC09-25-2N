# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.5 — Listando os Alunos do PostgreSQL na JTable

## 🎯 Objetivos da aula

Nesta etapa, vou buscar os alunos cadastrados no PostgreSQL e exibi-los na `JTable` da tela `TelaConsultaAluno`.

Ao final desta parte, eu serei capaz de:

- Criar ou revisar o método `listar()` na classe `AlunoDAO`;
- Executar um comando SQL `SELECT`;
- Utilizar `PreparedStatement`;
- Percorrer um `ResultSet`;
- Criar uma lista de objetos `Aluno`;
- Receber essa lista na interface gráfica;
- Limpar e preencher uma `JTable`;
- Utilizar `DefaultTableModel`;
- Atualizar os dados exibidos;
- Carregar a tabela automaticamente ao abrir a tela;
- Tratar erros durante a consulta.

---

# 🧭 O que será desenvolvido?

Na Parte 5.4, criei a tela `TelaConsultaAluno` com uma tabela contendo as colunas:

```text
ID
Nome
Turma
E-mail
```

Agora, os dados que estão armazenados no PostgreSQL serão carregados nessa tabela.

O fluxo será:

```text
TelaConsultaAluno
        │
        ▼
AlunoDAO.listar()
        │
        ▼
SELECT no PostgreSQL
        │
        ▼
ResultSet
        │
        ▼
Lista de objetos Aluno
        │
        ▼
DefaultTableModel
        │
        ▼
JTable
```

---

# 🏗️ Arquitetura da listagem

```text
Usuário abre a tela
        │
        ▼
TelaConsultaAluno
        │
        ▼
Método carregarTabela()
        │
        ▼
AlunoDAO.listar()
        │
        ▼
PostgreSQL
        │
        ▼
Dados retornados
        │
        ▼
JTable preenchida
```

---

# 📦 Imports necessários no AlunoDAO

Na classe `AlunoDAO`, verificarei se os seguintes imports estão disponíveis:

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

Os nomes dos pacotes podem variar conforme a organização do projeto.

---

# 📋 Criando o método listar no AlunoDAO

Na classe `AlunoDAO`, criarei o método:

```java
public List<Aluno> listar()
```

Esse método retornará uma lista contendo todos os alunos cadastrados.

---

# 💻 Código completo do método listar

```java
public List<Aluno> listar() {

    List<Aluno> lista = new ArrayList<>();

    String sql =
            "SELECT id, nome, turma, email "
            + "FROM alunos "
            + "ORDER BY id";

    try {

        Connection conexao = Conexao.conectar();

        if (conexao == null) {

            return lista;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

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
                "Erro ao listar alunos: "
                + erro.getMessage()
        );
    }

    return lista;
}
```

---

# 🔍 Explicando o método passo a passo

## 1. Criando a lista

```java
List<Aluno> lista = new ArrayList<>();
```

Crio uma lista vazia que armazenará objetos da classe `Aluno`.

Cada registro retornado pelo banco será transformado em um objeto.

---

## 2. Criando o comando SQL

```java
String sql =
        "SELECT id, nome, turma, email "
        + "FROM alunos "
        + "ORDER BY id";
```

Esse comando busca todos os alunos.

A cláusula:

```sql
ORDER BY id
```

organiza os registros pelo ID.

---

## 3. Abrindo a conexão

```java
Connection conexao = Conexao.conectar();
```

Utilizo a classe `Conexao` para abrir a comunicação com o PostgreSQL.

---

## 4. Verificando a conexão

```java
if (conexao == null) {

    return lista;
}
```

Se a conexão não for aberta, o método retorna a lista vazia.

Assim, evito tentar executar comandos utilizando uma conexão inexistente.

---

## 5. Preparando o SQL

```java
PreparedStatement stmt =
        conexao.prepareStatement(sql);
```

O `PreparedStatement` prepara o comando SQL para execução.

Mesmo sem parâmetros, ele continua sendo uma opção organizada e segura.

---

## 6. Executando o SELECT

```java
ResultSet resultado =
        stmt.executeQuery();
```

O método `executeQuery()` é utilizado em comandos que retornam dados.

Exemplos:

```sql
SELECT
```

O resultado da consulta fica armazenado em um objeto `ResultSet`.

---

## 7. Percorrendo o ResultSet

```java
while (resultado.next()) {
```

O método `next()` movimenta o cursor do `ResultSet` para o próximo registro.

Enquanto existirem registros, o bloco será executado.

---

## 8. Criando um objeto para cada registro

```java
Aluno aluno = new Aluno();
```

Para cada linha do banco, crio um novo objeto `Aluno`.

---

## 9. Capturando o ID

```java
aluno.setId(
        resultado.getInt("id")
);
```

O método `getInt("id")` captura o valor da coluna `id`.

---

## 10. Capturando o nome

```java
aluno.setNome(
        resultado.getString("nome")
);
```

O método `getString("nome")` captura o conteúdo da coluna `nome`.

---

## 11. Capturando turma e e-mail

```java
aluno.setTurma(
        resultado.getString("turma")
);

aluno.setEmail(
        resultado.getString("email")
);
```

Os dados são colocados no objeto utilizando os métodos `set`.

---

## 12. Adicionando o objeto à lista

```java
lista.add(aluno);
```

O objeto preenchido é adicionado à lista.

---

## 13. Fechando os recursos

```java
resultado.close();
stmt.close();
conexao.close();
```

Fecho:

- `ResultSet`;
- `PreparedStatement`;
- `Connection`.

Essa prática evita desperdício de recursos.

---

## 14. Retornando a lista

```java
return lista;
```

A lista é devolvida para a tela.

---

# 🧠 Como os dados são transformados?

```text
Linha do banco
      │
      ▼
Objeto Aluno
      │
      ▼
Lista de Aluno
      │
      ▼
Linha da JTable
```

Exemplo:

```text
Banco:
1 | Ana Souza | DS-01 | ana@email.com
```

Transformação:

```java
Aluno aluno = new Aluno();

aluno.setId(1);
aluno.setNome("Ana Souza");
aluno.setTurma("DS-01");
aluno.setEmail("ana@email.com");
```

---

# 📦 Imports necessários na TelaConsultaAluno

Na classe `TelaConsultaAluno`, adicionarei:

```java
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;
```

---

# 📊 Criando o método carregarTabela

Na tela `TelaConsultaAluno`, criarei:

```java
private void carregarTabela()
```

Esse método será responsável por:

1. Limpar a tabela;
2. Buscar os alunos;
3. Adicionar cada aluno como uma nova linha.

---

# 💻 Código completo do método carregarTabela

```java
private void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);

    AlunoDAO dao = new AlunoDAO();

    List<Aluno> lista =
            dao.listar();

    for (Aluno aluno : lista) {

        Object[] linha = {

            aluno.getId(),
            aluno.getNome(),
            aluno.getTurma(),
            aluno.getEmail()
        };

        modelo.addRow(linha);
    }
}
```

---

# 🔍 Explicando o método carregarTabela

## 1. Obtendo o modelo da tabela

```java
DefaultTableModel modelo =
        (DefaultTableModel)
                tblAlunos.getModel();
```

A `JTable` utiliza um modelo para controlar as linhas e colunas.

Estou convertendo o modelo atual para `DefaultTableModel`.

---

## 2. Limpando as linhas

```java
modelo.setRowCount(0);
```

Antes de carregar os dados, removo as linhas antigas.

Isso evita duplicação.

---

## 3. Criando o DAO

```java
AlunoDAO dao = new AlunoDAO();
```

Crio um objeto responsável por acessar o banco.

---

## 4. Recebendo a lista

```java
List<Aluno> lista =
        dao.listar();
```

O método `listar()` retorna uma lista de alunos.

---

## 5. Percorrendo a lista

```java
for (Aluno aluno : lista) {
```

Esse comando significa:

```text
Para cada aluno existente na lista
```

---

## 6. Criando uma linha

```java
Object[] linha = {

    aluno.getId(),
    aluno.getNome(),
    aluno.getTurma(),
    aluno.getEmail()
};
```

Crio um vetor de objetos.

Cada posição corresponde a uma coluna da tabela.

---

## 7. Adicionando a linha

```java
modelo.addRow(linha);
```

O método `addRow()` adiciona uma nova linha à tabela.

---

# 📐 Ordem das colunas

A ordem dos valores precisa ser igual à ordem das colunas.

Tabela:

```text
ID | Nome | Turma | E-mail
```

Código:

```java
Object[] linha = {

    aluno.getId(),
    aluno.getNome(),
    aluno.getTurma(),
    aluno.getEmail()
};
```

Se a ordem for diferente, os dados aparecerão nas colunas erradas.

---

# ⭐ Versão resumida

Também posso adicionar a linha diretamente:

```java
modelo.addRow(
        new Object[] {

            aluno.getId(),
            aluno.getNome(),
            aluno.getTurma(),
            aluno.getEmail()
        }
);
```

Código completo:

```java
private void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);

    AlunoDAO dao = new AlunoDAO();

    List<Aluno> lista =
            dao.listar();

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
}
```

---

# 🖱️ Programando o botão Listar Todos

No evento do botão `btnListar`, chamarei:

```java
private void btnListarActionPerformed(
        java.awt.event.ActionEvent evt) {

    carregarTabela();
}
```

Assim, toda a lógica permanece no método `carregarTabela()`.

---

# 🔄 Programando o botão Atualizar

O botão `btnAtualizar` pode utilizar o mesmo método:

```java
private void btnAtualizarActionPerformed(
        java.awt.event.ActionEvent evt) {

    carregarTabela();
}
```

Isso permite atualizar a tabela depois de:

- Inserir um novo aluno;
- Alterar um aluno;
- Excluir um aluno;
- Modificar dados diretamente no banco.

---

# 🚀 Carregando automaticamente ao abrir a tela

Posso chamar `carregarTabela()` no construtor da tela.

```java
public TelaConsultaAluno() {

    initComponents();

    setTitle("Consulta de Alunos");

    setLocationRelativeTo(null);

    carregarTabela();
}
```

Agora, quando a tela abrir, os dados aparecerão automaticamente.

---

# ⚠️ Ordem correta no construtor

O método deve ser chamado depois de:

```java
initComponents();
```

Correto:

```java
public TelaConsultaAluno() {

    initComponents();

    carregarTabela();
}
```

Incorreto:

```java
public TelaConsultaAluno() {

    carregarTabela();

    initComponents();
}
```

Antes de `initComponents()`, a tabela ainda não foi criada.

---

# 🔢 Exibindo a quantidade de alunos

Se a tela possuir:

```text
lblQuantidade
```

posso atualizar o total:

```java
lblQuantidade.setText(
        "Total de alunos: "
        + lista.size()
);
```

Versão completa:

```java
private void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);

    AlunoDAO dao = new AlunoDAO();

    List<Aluno> lista =
            dao.listar();

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

# 🛡️ Tratando uma lista vazia

Se não existirem alunos cadastrados, a lista estará vazia.

Posso informar isso ao usuário:

```java
if (lista.isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Nenhum aluno cadastrado.",
            "Lista vazia",
            JOptionPane.INFORMATION_MESSAGE
    );

    lblQuantidade.setText(
            "Total de alunos: 0"
    );

    return;
}
```

---

# 💻 Versão completa com lista vazia

```java
private void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel)
                    tblAlunos.getModel();

    modelo.setRowCount(0);

    AlunoDAO dao = new AlunoDAO();

    List<Aluno> lista =
            dao.listar();

    if (lista.isEmpty()) {

        lblQuantidade.setText(
                "Total de alunos: 0"
        );

        return;
    }

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

# 💬 Devo mostrar mensagem sempre que a lista estiver vazia?

Nem sempre.

Se a tela abrir automaticamente e não houver registros, uma mensagem pode ser útil.

Porém, se o método for chamado várias vezes, mostrar a mensagem repetidamente pode incomodar o usuário.

Uma alternativa é apenas exibir:

```text
Total de alunos: 0
```

Essa abordagem é mais discreta.

---

# 🔒 Impedindo a edição direta das células

Para que o usuário não altere os dados diretamente na tabela:

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

# 🧱 Código inicial completo da TelaConsultaAluno

```java
package view;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;

public class TelaConsultaAluno
        extends javax.swing.JFrame {

    public TelaConsultaAluno() {

        initComponents();

        setTitle("Consulta de Alunos");

        setLocationRelativeTo(null);

        carregarTabela();
    }

    private void carregarTabela() {

        DefaultTableModel modelo =
                (DefaultTableModel)
                        tblAlunos.getModel();

        modelo.setRowCount(0);

        AlunoDAO dao =
                new AlunoDAO();

        List<Aluno> lista =
                dao.listar();

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

    private void btnListarActionPerformed(
            java.awt.event.ActionEvent evt) {

        carregarTabela();
    }

    private void btnAtualizarActionPerformed(
            java.awt.event.ActionEvent evt) {

        carregarTabela();
    }
}
```

---

# 🔄 Fluxograma completo da listagem

```text
Abrir TelaConsultaAluno
          │
          ▼
Executar carregarTabela()
          │
          ▼
Limpar linhas antigas
          │
          ▼
Executar AlunoDAO.listar()
          │
          ▼
Executar SELECT
          │
          ▼
Ler ResultSet
          │
          ▼
Criar objetos Aluno
          │
          ▼
Adicionar objetos à lista
          │
          ▼
Percorrer a lista
          │
          ▼
Adicionar linhas na JTable
          │
          ▼
Exibir quantidade
```

---

# 🔬 Por baixo dos panos

Quando a tela é aberta:

1. O construtor é executado;
2. O `initComponents()` cria a interface;
3. O método `carregarTabela()` é chamado;
4. A tabela é limpa;
5. O DAO abre a conexão;
6. O PostgreSQL executa o `SELECT`;
7. O `ResultSet` recebe os dados;
8. Cada registro vira um objeto `Aluno`;
9. Os objetos são adicionados a uma lista;
10. A tela percorre essa lista;
11. Cada objeto vira uma linha da `JTable`;
12. A interface é atualizada.

---

# 💼 Como as empresas fazem?

Em aplicações profissionais, a tela normalmente não acessa o banco diretamente.

O fluxo pode ser:

```text
Tela
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
DAO
  │
  ▼
Banco de dados
```

A tela recebe objetos prontos e apenas apresenta os dados.

Também é comum utilizar:

- Paginação;
- Filtros;
- Ordenação;
- Carregamento assíncrono;
- Modelos de tabela personalizados;
- Bibliotecas ORM;
- Camadas de serviço.

Neste projeto, utilizarei `DefaultTableModel` por ser mais simples para quem está começando.

---

# ⚠️ Erros comuns

## Erro 1 — A tabela fica duplicada

### Causa

O código adiciona novas linhas sem remover as anteriores.

### Solução

```java
modelo.setRowCount(0);
```

---

## Erro 2 — A tabela fica vazia

### Possíveis causas

- Banco sem registros;
- Conexão incorreta;
- Nome da tabela diferente;
- Colunas com nomes diferentes;
- Método `listar()` não foi chamado;
- `carregarTabela()` não foi executado.

---

## Erro 3 — Dados aparecem nas colunas erradas

### Causa

A ordem do vetor é diferente da ordem das colunas.

### Solução

Manter:

```java
ID
Nome
Turma
E-mail
```

na mesma ordem.

---

## Erro 4 — `NullPointerException` na tabela

### Causa

`carregarTabela()` foi chamado antes de `initComponents()`.

### Solução

```java
initComponents();

carregarTabela();
```

---

## Erro 5 — `listar()` retorna `null`

### Problema

A tela não consegue percorrer uma lista nula.

### Solução

No DAO, sempre retorne uma lista:

```java
List<Aluno> lista =
        new ArrayList<>();
```

Mesmo que esteja vazia.

---

## Erro 6 — `executeUpdate()` usado no SELECT

### Solução

Para `SELECT`, utilize:

```java
executeQuery();
```

---

## Erro 7 — Coluna não encontrada

Mensagem semelhante:

```text
The column name turma was not found
```

### Solução

Confirme os nomes reais no PostgreSQL:

```sql
SELECT * FROM alunos;
```

---

# 🧪 Laboratório prático

## Etapa 1 — Conferir registros

No pgAdmin:

```sql
SELECT * FROM alunos
ORDER BY id;
```

Confirme que existem dados.

## Etapa 2 — Criar o método listar

Na classe `AlunoDAO`:

```java
public List<Aluno> listar()
```

## Etapa 3 — Criar carregarTabela

Na tela:

```java
private void carregarTabela()
```

## Etapa 4 — Programar os botões

```java
carregarTabela();
```

nos botões Listar e Atualizar.

## Etapa 5 — Abrir a tela

Confirme se os registros aparecem.

## Etapa 6 — Testar atualização

1. Cadastre um novo aluno;
2. Abra a tela de consulta;
3. Clique em Atualizar;
4. Verifique se o registro aparece.

---

# 💡 Dicas do Professor

> 💡 Sempre limpe a tabela antes de preenchê-la novamente.

> 💡 Não retorne `null` no método `listar()`.

> 💡 Mantenha a ordem das colunas igual à ordem dos dados.

> 💡 Use `executeQuery()` para comandos `SELECT`.

> 💡 Feche `ResultSet`, `PreparedStatement` e `Connection`.

> 💡 Chame `carregarTabela()` depois de `initComponents()`.

---

# 🧠 Curiosidade

A `JTable` não conhece a classe `Aluno`.

Ela apenas recebe valores organizados em linhas e colunas.

Quem transforma os objetos em linhas é o método:

```java
carregarTabela()
```

Por isso, ele funciona como uma ponte entre:

```text
Objetos Java
```

e:

```text
Tabela visual
```

---

# 🏆 Mini desafio 1

Ordene os alunos pelo nome:

```sql
ORDER BY nome
```

Compare o resultado com:

```sql
ORDER BY id
```

---

# 🏆 Mini desafio 2

Ajuste a largura das colunas:

```java
tblAlunos.getColumnModel()
        .getColumn(0)
        .setPreferredWidth(50);

tblAlunos.getColumnModel()
        .getColumn(1)
        .setPreferredWidth(200);

tblAlunos.getColumnModel()
        .getColumn(2)
        .setPreferredWidth(100);

tblAlunos.getColumnModel()
        .getColumn(3)
        .setPreferredWidth(220);
```

---

# 🏆 Mini desafio 3

Permita a seleção de apenas uma linha:

```java
tblAlunos.setSelectionMode(
        javax.swing.ListSelectionModel
                .SINGLE_SELECTION
);
```

---

# 🏆 Desafio adicional

Crie um método:

```java
private void configurarTabela()
```

Esse método deverá:

- Impedir edição;
- Definir seleção única;
- Ajustar largura das colunas;
- Desabilitar a reorganização das colunas.

Exemplo:

```java
tblAlunos.getTableHeader()
        .setReorderingAllowed(false);
```

---

# ✅ Checklist de implementação

- [ ] Importar `List` e `ArrayList`;
- [ ] Criar o método `listar()` no DAO;
- [ ] Executar o `SELECT`;
- [ ] Percorrer o `ResultSet`;
- [ ] Criar objetos `Aluno`;
- [ ] Adicionar os objetos à lista;
- [ ] Retornar a lista;
- [ ] Criar `carregarTabela()`;
- [ ] Limpar a tabela;
- [ ] Percorrer a lista;
- [ ] Adicionar linhas;
- [ ] Programar Listar Todos;
- [ ] Programar Atualizar;
- [ ] Carregar automaticamente;
- [ ] Exibir a quantidade de alunos;
- [ ] Testar no PostgreSQL.

---

# 📝 Resumo da aula

Nesta etapa, listei os alunos cadastrados no PostgreSQL dentro da `JTable`.

Aprendi a:

- Executar um `SELECT`;
- Utilizar `ResultSet`;
- Criar uma lista de objetos;
- Retornar dados pelo DAO;
- Preencher uma tabela;
- Utilizar `DefaultTableModel`;
- Evitar duplicação de linhas;
- Atualizar os registros;
- Exibir a quantidade de alunos.

Agora a tela de consulta já apresenta os dados reais do banco.

---

# 🚀 Próxima etapa

Na **Parte 5.6**, implementarei a localização de alunos por ID, nome ou e-mail, utilizando o campo de pesquisa, o `JComboBox`, consultas com parâmetros e a seleção automática do registro encontrado na `JTable`.
