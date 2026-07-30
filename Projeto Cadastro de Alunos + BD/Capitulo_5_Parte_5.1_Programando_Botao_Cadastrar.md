# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.1 — Programando o Botão Cadastrar

## 🎯 Objetivos da aula

Nesta etapa, vou programar o botão **Cadastrar** da tela `TelaCadastroAluno`.

Vou integrar os componentes da interface gráfica com as classes `Aluno` e `AlunoDAO`, permitindo que os dados digitados pelo usuário sejam enviados para o PostgreSQL.

Ao final desta parte, eu serei capaz de:

- Capturar os dados dos campos da tela;
- Validar campos obrigatórios;
- Criar um objeto da classe `Aluno`;
- Enviar o objeto para o método `cadastrar()` da classe `AlunoDAO`;
- Exibir mensagens utilizando `JOptionPane`;
- Limpar os campos após o cadastro;
- Compreender o fluxo completo entre a interface gráfica e o banco de dados.

---

# 🧭 O que vou desenvolver?

Na parte anterior, construí a tela de cadastro com os seguintes componentes:

| Componente | Nome da variável |
|---|---|
| Campo do ID | `txtId` |
| Campo do nome | `txtNome` |
| Campo da turma | `txtTurma` |
| Campo do e-mail | `txtEmail` |
| Botão Cadastrar | `btnCadastrar` |
| Botão Limpar | `btnLimpar` |
| Botão Consulta | `btnConsulta` |
| Botão Sair | `btnSair` |

Agora, o botão `btnCadastrar` será responsável por:

1. Ler os valores digitados;
2. Validar os dados;
3. Criar um objeto `Aluno`;
4. Chamar o método `cadastrar()` do `AlunoDAO`;
5. Exibir uma mensagem;
6. Limpar os campos.

---

# 🏗️ Arquitetura da operação

```text
TelaCadastroAluno
        │
        │ dados digitados
        ▼
     Objeto Aluno
        │
        ▼
AlunoDAO.cadastrar(aluno)
        │
        ▼
     Classe Conexao
        │
        ▼
      PostgreSQL
```

> 💡 **Dica do Professor:** A tela não deve possuir comandos SQL. A responsabilidade de executar o `INSERT` continua sendo da classe `AlunoDAO`.

---

# 📦 Imports necessários

Na parte superior da classe `TelaCadastroAluno`, verificarei se estes imports estão presentes:

```java
import javax.swing.JOptionPane;
import model.Aluno;
import dao.AlunoDAO;
```

Os nomes dos pacotes podem variar conforme a organização do projeto.

Por exemplo, se a classe `Aluno` estiver no pacote `model` e a classe `AlunoDAO` estiver no pacote `dao`, os imports serão:

```java
import model.Aluno;
import dao.AlunoDAO;
```

---

# 🖱️ Criando o evento do botão Cadastrar

No NetBeans, seguirei estes passos:

1. Abrirei o formulário `TelaCadastroAluno`;
2. Selecionarei a aba **Design**;
3. Darei dois cliques no botão **Cadastrar**;
4. O NetBeans criará automaticamente o método do evento.

O método poderá aparecer assim:

```java
private void btnCadastrarActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

Todo o código do cadastro será inserido dentro desse método.

---

# 💻 Primeira versão do botão Cadastrar

```java
private void btnCadastrarActionPerformed(
        java.awt.event.ActionEvent evt) {

    String nome = txtNome.getText();
    String turma = txtTurma.getText();
    String email = txtEmail.getText();

    Aluno aluno = new Aluno();

    aluno.setNome(nome);
    aluno.setTurma(turma);
    aluno.setEmail(email);

    AlunoDAO dao = new AlunoDAO();

    dao.cadastrar(aluno);

}
```

Essa primeira versão já demonstra o fluxo principal, mas ainda precisa de validação, mensagens e limpeza dos campos.

---

# 🔍 Explicando o código passo a passo

## 1. Capturando o nome

```java
String nome = txtNome.getText();
```

O método `getText()` captura o texto digitado no componente `txtNome`.

O valor é armazenado na variável `nome`.

---

## 2. Capturando a turma

```java
String turma = txtTurma.getText();
```

Capturo o conteúdo do campo `txtTurma` e guardo na variável `turma`.

---

## 3. Capturando o e-mail

```java
String email = txtEmail.getText();
```

Capturo o texto informado no campo de e-mail.

---

## 4. Criando o objeto Aluno

```java
Aluno aluno = new Aluno();
```

Crio um objeto da classe `Aluno`.

Esse objeto será utilizado para transportar os dados da tela até a classe `AlunoDAO`.

---

## 5. Preenchendo os atributos

```java
aluno.setNome(nome);
aluno.setTurma(turma);
aluno.setEmail(email);
```

Utilizo os métodos `set` para colocar os valores dentro do objeto.

Neste momento, o objeto possui os dados necessários para o cadastro.

---

## 6. Criando o objeto DAO

```java
AlunoDAO dao = new AlunoDAO();
```

Crio um objeto da classe `AlunoDAO`.

Essa classe contém o método que executa o comando SQL `INSERT`.

---

## 7. Executando o cadastro

```java
dao.cadastrar(aluno);
```

Envio o objeto `aluno` para o método `cadastrar()`.

O método realiza a conexão com o PostgreSQL e executa o cadastro.

---

# ⚠️ Não preciso preencher o campo ID

Se a coluna `id` da tabela estiver configurada como automática:

```sql
id SERIAL PRIMARY KEY
```

ou:

```sql
id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
```

não preciso informar o ID durante o cadastro.

O próprio PostgreSQL criará o próximo número disponível.

Por esse motivo, o campo `txtId` pode ficar:

- Desabilitado durante o cadastro;
- Somente para consulta;
- Disponível apenas nas operações de localizar, alterar e excluir.

Para desabilitá-lo pelo código:

```java
txtId.setEnabled(false);
```

Também posso definir essa propriedade diretamente no editor visual do NetBeans.

---

# ✅ Validando os campos obrigatórios

Não devo enviar dados vazios para o banco.

Antes de criar o objeto, verificarei se os campos foram preenchidos.

```java
if (txtNome.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Informe o nome do aluno."
    );

    txtNome.requestFocus();
    return;
}
```

---

# 🔍 Entendendo a validação

## `getText()`

```java
txtNome.getText()
```

Obtém o conteúdo do campo.

## `trim()`

```java
txtNome.getText().trim()
```

Remove espaços em branco no início e no final.

## `isEmpty()`

```java
txtNome.getText().trim().isEmpty()
```

Verifica se o texto ficou vazio.

## `return`

```java
return;
```

Interrompe o evento do botão.

Assim, o restante do cadastro não será executado.

## `requestFocus()`

```java
txtNome.requestFocus();
```

Coloca o cursor no campo que precisa ser corrigido.

---

# ✅ Validação completa

```java
if (txtNome.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Informe o nome do aluno.",
            "Campo obrigatório",
            JOptionPane.WARNING_MESSAGE
    );

    txtNome.requestFocus();
    return;
}

if (txtTurma.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Informe a turma do aluno.",
            "Campo obrigatório",
            JOptionPane.WARNING_MESSAGE
    );

    txtTurma.requestFocus();
    return;
}

if (txtEmail.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Informe o e-mail do aluno.",
            "Campo obrigatório",
            JOptionPane.WARNING_MESSAGE
    );

    txtEmail.requestFocus();
    return;
}
```

---

# 📧 Validação simples do e-mail

Posso verificar se o e-mail contém o caractere `@`.

```java
if (!txtEmail.getText().contains("@")) {

    JOptionPane.showMessageDialog(
            this,
            "Informe um e-mail válido.",
            "E-mail inválido",
            JOptionPane.WARNING_MESSAGE
    );

    txtEmail.requestFocus();
    return;
}
```

Essa é uma validação simples e adequada para este momento do curso.

---

# 🧹 Criando o método `limparCampos()`

Para não repetir código, criarei um método separado:

```java
private void limparCampos() {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    txtNome.requestFocus();
}
```

Esse método:

- Apaga o ID;
- Apaga o nome;
- Apaga a turma;
- Apaga o e-mail;
- Coloca o cursor novamente no campo nome.

---

# 💻 Versão completa do botão Cadastrar

```java
private void btnCadastrarActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (txtNome.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o nome do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtNome.requestFocus();
        return;
    }

    if (txtTurma.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe a turma do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtTurma.requestFocus();
        return;
    }

    if (txtEmail.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o e-mail do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();
        return;
    }

    if (!txtEmail.getText().contains("@")) {

        JOptionPane.showMessageDialog(
                this,
                "Informe um e-mail válido.",
                "E-mail inválido",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();
        return;
    }

    String nome = txtNome.getText().trim();
    String turma = txtTurma.getText().trim();
    String email = txtEmail.getText().trim();

    Aluno aluno = new Aluno();

    aluno.setNome(nome);
    aluno.setTurma(turma);
    aluno.setEmail(email);

    AlunoDAO dao = new AlunoDAO();

    dao.cadastrar(aluno);

    JOptionPane.showMessageDialog(
            this,
            "Aluno cadastrado com sucesso!",
            "Cadastro realizado",
            JOptionPane.INFORMATION_MESSAGE
    );

    limparCampos();
}
```

---

# ⚠️ Um cuidado importante com a mensagem de sucesso

Na versão anterior, a tela sempre mostra:

```text
Aluno cadastrado com sucesso!
```

Isso acontece mesmo que o método `cadastrar()` encontre algum erro e apenas exiba uma mensagem no console.

Para tornar o projeto mais confiável, o método `cadastrar()` deve retornar um valor informando se o cadastro funcionou.

---

# 🔧 Melhorando o método `cadastrar()`

Na classe `AlunoDAO`, alterarei o retorno de `void` para `boolean`.

## Antes

```java
public void cadastrar(Aluno aluno) {
```

## Depois

```java
public boolean cadastrar(Aluno aluno) {
```

---

# 💻 Método `cadastrar()` retornando `boolean`

```java
public boolean cadastrar(Aluno aluno) {

    String sql =
        "INSERT INTO alunos (nome, turma, email) VALUES (?, ?, ?)";

    try {

        Connection conexao = Conexao.conectar();

        if (conexao == null) {
            return false;
        }

        PreparedStatement stmt =
                conexao.prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getTurma());
        stmt.setString(3, aluno.getEmail());

        int linhasAfetadas = stmt.executeUpdate();

        stmt.close();
        conexao.close();

        return linhasAfetadas > 0;

    } catch (SQLException erro) {

        System.out.println(
                "Erro ao cadastrar aluno: "
                + erro.getMessage()
        );

        return false;
    }
}
```

---

# 🧠 O que significa `boolean`?

Um valor do tipo `boolean` possui apenas duas possibilidades:

```text
true
false
```

No nosso método:

- `true` significa que o aluno foi cadastrado;
- `false` significa que o cadastro não foi concluído.

---

# ✅ Botão Cadastrar utilizando o retorno do DAO

```java
private void btnCadastrarActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (txtNome.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o nome do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtNome.requestFocus();
        return;
    }

    if (txtTurma.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe a turma do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtTurma.requestFocus();
        return;
    }

    if (txtEmail.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o e-mail do aluno.",
                "Campo obrigatório",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();
        return;
    }

    if (!txtEmail.getText().contains("@")) {

        JOptionPane.showMessageDialog(
                this,
                "Informe um e-mail válido.",
                "E-mail inválido",
                JOptionPane.WARNING_MESSAGE
        );

        txtEmail.requestFocus();
        return;
    }

    Aluno aluno = new Aluno();

    aluno.setNome(txtNome.getText().trim());
    aluno.setTurma(txtTurma.getText().trim());
    aluno.setEmail(txtEmail.getText().trim());

    AlunoDAO dao = new AlunoDAO();

    boolean cadastrou = dao.cadastrar(aluno);

    if (cadastrou) {

        JOptionPane.showMessageDialog(
                this,
                "Aluno cadastrado com sucesso!",
                "Cadastro realizado",
                JOptionPane.INFORMATION_MESSAGE
        );

        limparCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível cadastrar o aluno.",
                "Erro no cadastro",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
```

---

# ⭐ Versão recomendada

A versão que utiliza retorno `boolean` é mais adequada porque a tela somente apresenta a mensagem de sucesso quando o banco confirma que o cadastro ocorreu.

```text
AlunoDAO retorna true
        │
        ▼
Mensagem de sucesso
        │
        ▼
Limpar campos
```

ou:

```text
AlunoDAO retorna false
        │
        ▼
Mensagem de erro
        │
        ▼
Manter os dados na tela
```

Manter os dados na tela em caso de erro é importante para que o usuário não precise digitá-los novamente.

---

# 🔄 Fluxograma completo do botão

```text
Usuário clica em Cadastrar
            │
            ▼
     Validar os campos
            │
     ┌──────┴──────┐
     │             │
Campo vazio?      Dados válidos
     │             │
     ▼             ▼
Exibir aviso   Criar objeto Aluno
     │             │
     ▼             ▼
Interromper    Chamar AlunoDAO
                   │
                   ▼
              Executar INSERT
                   │
          ┌────────┴────────┐
          │                 │
        Sucesso            Erro
          │                 │
          ▼                 ▼
 Mostrar mensagem     Mostrar mensagem
 Limpar campos        Manter os dados
```

---

# 🔬 Por baixo dos panos

Quando clico no botão **Cadastrar**, acontece o seguinte:

1. O Swing detecta o clique;
2. O método `btnCadastrarActionPerformed()` é executado;
3. Os campos são validados;
4. Um objeto `Aluno` é criado;
5. Os dados são armazenados no objeto;
6. O objeto é enviado ao `AlunoDAO`;
7. O DAO abre a conexão;
8. O `PreparedStatement` prepara o `INSERT`;
9. O PostgreSQL grava o registro;
10. O banco informa quantas linhas foram afetadas;
11. O DAO retorna `true` ou `false`;
12. A tela apresenta a mensagem correspondente.

---

# 🧩 Separação de responsabilidades

## Tela

A tela é responsável por:

- Capturar dados;
- Validar campos;
- Exibir mensagens;
- Chamar o DAO.

## Classe `Aluno`

A classe `Aluno` é responsável por:

- Representar os dados do aluno;
- Armazenar nome, turma, e-mail e ID.

## Classe `AlunoDAO`

A classe `AlunoDAO` é responsável por:

- Criar o comando SQL;
- Abrir a conexão;
- Executar o `INSERT`;
- Informar se o cadastro funcionou.

## Classe `Conexao`

A classe `Conexao` é responsável por:

- Estabelecer a comunicação com o PostgreSQL.

---

# 💼 Como as empresas fazem?

Em aplicações maiores, é comum existir uma camada de serviço entre a tela e o DAO:

```text
Tela
  │
  ▼
AlunoService
  │
  ▼
AlunoDAO
  │
  ▼
PostgreSQL
```

A camada de serviço concentra regras de negócio, enquanto a tela cuida apenas da interação com o usuário.

Neste projeto inicial, utilizarei diretamente a comunicação entre a tela e o DAO para facilitar o aprendizado.

---

# 🧪 Laboratório prático

## Etapa 1 — Testar campos vazios

1. Abra a tela;
2. Clique em **Cadastrar** sem preencher os campos;
3. Observe a mensagem;
4. Confirme se o cursor foi direcionado ao campo correto.

## Etapa 2 — Testar e-mail inválido

1. Informe nome e turma;
2. Digite um e-mail sem `@`;
3. Clique em **Cadastrar**;
4. Verifique a mensagem.

## Etapa 3 — Testar cadastro válido

1. Informe todos os dados;
2. Clique em **Cadastrar**;
3. Verifique a mensagem de sucesso;
4. Confirme se os campos foram limpos.

## Etapa 4 — Conferir no PostgreSQL

No pgAdmin, execute:

```sql
SELECT * FROM alunos
ORDER BY id;
```

Confirme se o novo aluno aparece na tabela.

---

# 🐞 Erros comuns e soluções

## Erro: `Aluno cannot be resolved to a type`

### Causa

A classe `Aluno` não foi importada.

### Solução

```java
import model.Aluno;
```

---

## Erro: `AlunoDAO cannot be resolved to a type`

### Causa

A classe DAO não foi importada.

### Solução

```java
import dao.AlunoDAO;
```

---

## Erro: `cannot find symbol txtNome`

### Causa

O campo possui outro nome de variável.

### Solução

Confirme o nome na propriedade **Variable Name** do NetBeans.

---

## Erro: cadastro duplicado

### Causa

O evento pode estar chamando o método `cadastrar()` mais de uma vez.

### Solução

Verifique se existe apenas esta chamada:

```java
dao.cadastrar(aluno);
```

---

## Erro: mensagem de sucesso, mas nada foi salvo

### Causa

O DAO pode estar usando `void`, e a tela não sabe se ocorreu erro.

### Solução

Utilize a versão que retorna `boolean`.

---

## Erro: conexão nula

### Causa

O método `Conexao.conectar()` não conseguiu abrir a conexão.

### Solução

Verifique:

- PostgreSQL iniciado;
- Nome do banco;
- Porta;
- Usuário;
- Senha;
- Driver JDBC;
- URL de conexão.

---

# 💡 Dicas do Professor

> 💡 Não coloque comandos SQL diretamente dentro do botão.

> 💡 Sempre utilize `trim()` para remover espaços desnecessários.

> 💡 Mostre uma mensagem clara para cada situação.

> 💡 Limpe os campos apenas quando o cadastro for realizado com sucesso.

> 💡 Em caso de erro, mantenha os dados digitados para que o usuário possa tentar novamente.

---

# 🧠 Curiosidade

O método `ActionPerformed` faz parte do sistema de eventos do Java.

A aplicação fica aguardando ações do usuário, como:

- Cliques;
- Digitação;
- Seleção de itens;
- Fechamento da janela.

Quando uma ação acontece, o Java executa o método correspondente.

Esse modelo é chamado de:

```text
Programação orientada a eventos
```

---

# 🏆 Mini desafio 1

Adicione uma validação para impedir nomes com menos de três caracteres.

Exemplo:

```java
if (txtNome.getText().trim().length() < 3) {

    JOptionPane.showMessageDialog(
            this,
            "O nome deve possuir pelo menos 3 caracteres."
    );

    txtNome.requestFocus();
    return;
}
```

---

# 🏆 Mini desafio 2

Converta o conteúdo da turma para letras maiúsculas antes de cadastrar:

```java
aluno.setTurma(
        txtTurma.getText().trim().toUpperCase()
);
```

---

# 🏆 Desafio adicional

Crie uma validação para impedir que o usuário cadastre um e-mail sem ponto após o caractere `@`.

Exemplo inválido:

```text
aluno@email
```

Exemplo válido:

```text
aluno@email.com
```

---

# ✅ Checklist de implementação

- [ ] Criar o evento do botão `btnCadastrar`;
- [ ] Importar `Aluno`, `AlunoDAO` e `JOptionPane`;
- [ ] Validar o campo nome;
- [ ] Validar o campo turma;
- [ ] Validar o campo e-mail;
- [ ] Criar um objeto `Aluno`;
- [ ] Preencher o objeto com os dados da tela;
- [ ] Criar um objeto `AlunoDAO`;
- [ ] Executar `dao.cadastrar(aluno)`;
- [ ] Verificar o retorno do DAO;
- [ ] Exibir mensagem de sucesso ou erro;
- [ ] Criar o método `limparCampos()`;
- [ ] Conferir o cadastro no PostgreSQL.

---

# 📝 Resumo da aula

Nesta etapa, programei o botão **Cadastrar** da interface gráfica.

Aprendi a:

- Capturar os dados com `getText()`;
- Validar campos;
- Criar objetos;
- Integrar a tela com o DAO;
- Executar o cadastro no PostgreSQL;
- Utilizar `JOptionPane`;
- Limpar os campos;
- Trabalhar com retorno `boolean`.

Agora a tela deixou de ser apenas um desenho e passou a executar uma operação real no banco de dados.

---

# 🚀 Próxima etapa

Na **Parte 5.2**, programarei o botão **Limpar**, criarei uma confirmação para evitar a perda acidental dos dados digitados e melhorarei a experiência do usuário na tela de cadastro.
