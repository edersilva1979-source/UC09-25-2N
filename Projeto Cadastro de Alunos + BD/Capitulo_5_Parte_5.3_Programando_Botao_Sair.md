# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.3 — Programando o Botão Sair

## 🎯 Objetivos da aula

Nesta etapa, vou programar o botão **Sair** da tela `TelaCadastroAluno`.

Esse botão será responsável por encerrar a janela ou finalizar completamente a aplicação, sempre solicitando uma confirmação ao usuário para evitar o fechamento acidental.

Ao final desta parte, eu serei capaz de:

- Criar o evento do botão `btnSair`;
- Utilizar `JOptionPane.showConfirmDialog()`;
- Interpretar a resposta do usuário;
- Fechar uma janela com `dispose()`;
- Encerrar toda a aplicação com `System.exit(0)`;
- Entender a diferença entre fechar uma janela e finalizar o sistema;
- Configurar corretamente a operação de fechamento do `JFrame`;
- Melhorar a segurança e a experiência do usuário.

---

# 🧭 O que o botão Sair deve fazer?

Quando o usuário clicar no botão **Sair**, a aplicação deverá:

1. Exibir uma mensagem de confirmação;
2. Aguardar a resposta do usuário;
3. Fechar a janela ou encerrar o sistema;
4. Manter a aplicação aberta quando a resposta for **Não**.

O fluxo será:

```text
Usuário clica em Sair
          │
          ▼
Exibir confirmação
          │
    ┌─────┴─────┐
    │           │
   Sim         Não
    │           │
    ▼           ▼
Fechar       Continuar
aplicação    usando a tela
```

---

# 🖱️ Criando o evento do botão Sair

No NetBeans, seguirei estes passos:

1. Abrirei a classe `TelaCadastroAluno`;
2. Selecionarei a aba **Design**;
3. Darei dois cliques no botão **Sair**;
4. O NetBeans criará automaticamente o evento.

O método poderá aparecer assim:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

Todo o código do botão será escrito dentro desse método.

---

# 💻 Primeira versão do botão Sair

A maneira mais simples de fechar a janela é utilizar:

```java
dispose();
```

Exemplo:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    dispose();
}
```

Essa versão fecha imediatamente a janela atual.

---

# 🔍 Entendendo o método `dispose()`

```java
dispose();
```

O método `dispose()` fecha e libera os recursos da janela atual.

Se a aplicação possuir outras janelas abertas, elas continuarão funcionando.

Por isso, `dispose()` é muito utilizado quando o sistema possui:

- Tela inicial;
- Tela de cadastro;
- Tela de consulta;
- Menu principal;
- Diferentes formulários.

---

# ⚠️ Problema do fechamento imediato

Na versão anterior, basta um clique para fechar a tela.

Isso pode causar problemas, principalmente quando o usuário:

- Preencheu dados e ainda não salvou;
- Clicou no botão sem querer;
- Está no meio de uma operação;
- Confundiu o botão Sair com outro botão.

Para evitar isso, adicionarei uma confirmação.

---

# 💬 Solicitando confirmação

Utilizarei:

```java
JOptionPane.showConfirmDialog()
```

Exemplo:

```java
int resposta = JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente sair?",
        "Confirmar saída",
        JOptionPane.YES_NO_OPTION
);
```

A caixa de diálogo apresentará as opções:

```text
Sim
Não
```

A escolha será armazenada na variável `resposta`.

---

# ✅ Verificando a resposta

Depois da escolha do usuário, verificarei o retorno:

```java
if (resposta == JOptionPane.YES_OPTION) {

    dispose();
}
```

Se o usuário escolher **Sim**, a janela será fechada.

Se escolher **Não**, nada acontecerá.

---

# 💻 Botão Sair com confirmação

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        dispose();
    }
}
```

---

# ⭐ Versão mais completa

Posso adicionar um ícone de pergunta:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair do sistema?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        dispose();
    }
}
```

---

# 🧠 `dispose()` ou `System.exit(0)`?

Essa é uma dúvida muito comum.

## `dispose()`

```java
dispose();
```

Fecha apenas a janela atual.

Utilize quando:

- Existem outras janelas abertas;
- A tela é apenas uma parte do sistema;
- O usuário deve voltar para uma tela anterior;
- O sistema possui uma janela principal.

## `System.exit(0)`

```java
System.exit(0);
```

Encerra completamente a aplicação Java.

Utilize quando:

- A tela atual é a janela principal;
- Não existem outras telas que devam continuar abertas;
- O usuário realmente deseja finalizar o programa inteiro.

---

# 📊 Comparação

| Comando | Comportamento |
|---|---|
| `dispose()` | Fecha apenas a janela atual |
| `System.exit(0)` | Encerra toda a aplicação |
| `setVisible(false)` | Oculta a janela sem destruí-la |

---

# 💻 Encerrando toda a aplicação

Se `TelaCadastroAluno` for a tela principal do sistema, posso utilizar:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente encerrar o sistema?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

---

# 🔢 O que significa o número `0`?

```java
System.exit(0);
```

O número `0` indica que o programa foi encerrado normalmente.

Em geral:

```text
0 = encerramento normal
outro valor = encerramento com algum tipo de erro
```

Para este projeto, utilizarei:

```java
System.exit(0);
```

---

# ✅ Versão recomendada para este projeto

Se a tela de cadastro for a única tela aberta no momento, posso utilizar:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair do sistema?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

Se o sistema possuir uma tela principal ou menu anterior, utilizarei:

```java
dispose();
```

---

# 🪟 Configurando o fechamento pelo botão X

Além do botão **Sair**, o usuário também pode clicar no botão **X** da janela.

No NetBeans, a propriedade padrão do `JFrame` pode ser:

```java
setDefaultCloseOperation(
        javax.swing.WindowConstants.EXIT_ON_CLOSE
);
```

Nesse caso, clicar no **X** encerrará a aplicação imediatamente.

Isso ignora a confirmação criada no botão Sair.

---

# ⚠️ Alterando a operação padrão

Para impedir o fechamento automático, utilizarei:

```java
setDefaultCloseOperation(
        javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
);
```

Assim, clicar no **X** não fechará automaticamente a janela.

Depois, criarei um evento para tratar o fechamento.

---

# 🧩 Criando um método de confirmação reutilizável

Para evitar repetir a mesma lógica, criarei:

```java
private void confirmarSaida() {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair do sistema?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

Agora, no botão Sair, utilizarei:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    confirmarSaida();
}
```

---

# ♻️ Vantagem do método `confirmarSaida()`

O mesmo método poderá ser utilizado em:

- Botão Sair;
- Botão Fechar;
- Menu Arquivo → Sair;
- Clique no X da janela;
- Atalho de teclado.

Essa reutilização melhora a organização do código.

---

# 🪟 Tratando o fechamento pelo X

No NetBeans, posso adicionar um evento de janela.

## Passo a passo

1. Selecione o `JFrame`;
2. Abra a aba **Events**;
3. Localize a categoria **Window**;
4. Escolha o evento `windowClosing`;
5. O NetBeans criará o método.

Exemplo:

```java
private void formWindowClosing(
        java.awt.event.WindowEvent evt) {

    confirmarSaida();
}
```

---

# 🧱 Configuração completa no construtor

```java
public TelaCadastroAluno() {

    initComponents();

    setLocationRelativeTo(null);

    setDefaultCloseOperation(
            javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
    );

    txtNome.requestFocus();
}
```

---

# 💻 Código completo recomendado

## Método de confirmação

```java
private void confirmarSaida() {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair do sistema?",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

## Evento do botão Sair

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt) {

    confirmarSaida();
}
```

## Evento do botão X

```java
private void formWindowClosing(
        java.awt.event.WindowEvent evt) {

    confirmarSaida();
}
```

---

# 🛡️ Verificando dados não salvos

Posso melhorar o sistema verificando se existem dados preenchidos antes de sair.

```java
private boolean existemDadosPreenchidos() {

    return !txtNome.getText().trim().isEmpty()
            || !txtTurma.getText().trim().isEmpty()
            || !txtEmail.getText().trim().isEmpty();
}
```

---

# 💻 Confirmação com aviso de dados não salvos

```java
private void confirmarSaida() {

    String mensagem;

    if (existemDadosPreenchidos()) {

        mensagem =
            "Existem dados não salvos.\n"
            + "Deseja realmente sair?";

    } else {

        mensagem =
            "Deseja realmente sair do sistema?";
    }

    int resposta = JOptionPane.showConfirmDialog(
            this,
            mensagem,
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

---

# 🔍 Explicando o uso de `\n`

Observe:

```java
"Existem dados não salvos.\n"
```

O código:

```java
\n
```

cria uma quebra de linha na mensagem.

O resultado será:

```text
Existem dados não salvos.
Deseja realmente sair?
```

---

# 🔄 Fluxograma completo

```text
Usuário clica em Sair ou no X
               │
               ▼
      Verificar dados preenchidos
               │
               ▼
       Exibir confirmação
               │
        ┌──────┴──────┐
        │             │
       Sim           Não
        │             │
        ▼             ▼
 Encerrar sistema   Manter tela
```

---

# 🔬 Por baixo dos panos

Quando clico no botão **Sair**, o Swing executa o evento:

```java
btnSairActionPerformed()
```

Dentro desse evento:

1. O método `confirmarSaida()` é chamado;
2. O `JOptionPane` exibe a mensagem;
3. A execução aguarda a escolha do usuário;
4. O valor escolhido é armazenado;
5. A aplicação compara a resposta;
6. Se for **Sim**, executa `dispose()` ou `System.exit(0)`;
7. Se for **Não**, a tela permanece aberta.

---

# 💼 Como as empresas fazem?

Aplicações profissionais normalmente:

- Solicitam confirmação antes de fechar;
- Avisam sobre dados não salvos;
- Centralizam a lógica de saída em um único método;
- Tratam tanto o botão quanto o X da janela;
- Evitam usar `System.exit(0)` em telas secundárias;
- Registram o encerramento da sessão quando necessário.

Em sistemas maiores, a saída também pode envolver:

- Fechamento de conexões;
- Encerramento de sessão;
- Salvamento de preferências;
- Registro de logs;
- Limpeza de arquivos temporários.

---

# ⚠️ Erros comuns

## Erro 1 — Encerrar sem confirmação

```java
System.exit(0);
```

diretamente no botão.

### Problema

Um clique acidental encerra toda a aplicação.

### Solução

Utilizar `showConfirmDialog()`.

---

## Erro 2 — Usar `System.exit(0)` em uma tela secundária

### Problema

Todo o sistema é encerrado, mesmo que outras janelas estejam abertas.

### Solução

Utilizar:

```java
dispose();
```

---

## Erro 3 — Configurar `EXIT_ON_CLOSE` e criar confirmação apenas no botão

### Problema

O botão X fecha a aplicação sem confirmação.

### Solução

Utilizar:

```java
DO_NOTHING_ON_CLOSE
```

e tratar o evento `windowClosing`.

---

## Erro 4 — Comparar com número fixo

Exemplo:

```java
if (resposta == 0) {
```

### Solução

Utilizar:

```java
if (resposta == JOptionPane.YES_OPTION) {
```

---

## Erro 5 — Repetir a confirmação em vários lugares

### Solução

Criar:

```java
confirmarSaida();
```

---

# 🧪 Laboratório prático

## Teste 1 — Escolher Não

1. Abra a tela;
2. Clique em **Sair**;
3. Escolha **Não**;
4. Verifique se a aplicação permanece aberta.

## Teste 2 — Escolher Sim

1. Clique em **Sair**;
2. Escolha **Sim**;
3. Verifique se a janela ou aplicação foi encerrada.

## Teste 3 — Fechar pelo X

1. Configure `DO_NOTHING_ON_CLOSE`;
2. Adicione o evento `windowClosing`;
3. Clique no X;
4. Verifique se a mesma confirmação aparece.

## Teste 4 — Dados não salvos

1. Preencha um campo;
2. Clique em **Sair**;
3. Verifique se a mensagem informa que existem dados não salvos.

---

# 💡 Dicas do Professor

> 💡 Utilize `dispose()` em telas secundárias.

> 💡 Utilize `System.exit(0)` apenas quando quiser finalizar todo o sistema.

> 💡 Trate também o botão X da janela.

> 💡 Centralize a confirmação em um método próprio.

> 💡 Avise o usuário quando existirem dados não salvos.

---

# 🧠 Curiosidade

Interfaces gráficas trabalham com vários tipos de eventos.

O botão **Sair** utiliza um evento de ação:

```java
ActionEvent
```

O fechamento da janela utiliza:

```java
WindowEvent
```

Cada componente pode disparar diferentes eventos, e o Java permite programar uma resposta para cada um deles.

---

# 🏆 Mini desafio 1

Altere a confirmação para apresentar três opções:

```java
JOptionPane.YES_NO_CANCEL_OPTION
```

Depois, analise os retornos:

```java
JOptionPane.YES_OPTION
JOptionPane.NO_OPTION
JOptionPane.CANCEL_OPTION
```

---

# 🏆 Mini desafio 2

Crie um item de menu:

```text
Arquivo → Sair
```

Faça esse item chamar o mesmo método:

```java
confirmarSaida();
```

---

# 🏆 Desafio adicional

Crie um método:

```java
private void fecharTela()
```

Esse método deverá decidir entre:

```java
dispose();
```

e:

```java
System.exit(0);
```

de acordo com o tipo da tela.

Explique por que essa decisão é importante em aplicações com várias janelas.

---

# ✅ Checklist de implementação

- [ ] Criar o evento `btnSairActionPerformed`;
- [ ] Exibir confirmação com `showConfirmDialog()`;
- [ ] Comparar a resposta com `YES_OPTION`;
- [ ] Decidir entre `dispose()` e `System.exit(0)`;
- [ ] Criar o método `confirmarSaida()`;
- [ ] Configurar `DO_NOTHING_ON_CLOSE`;
- [ ] Criar o evento `windowClosing`;
- [ ] Testar o botão Sair;
- [ ] Testar o botão X;
- [ ] Avisar sobre dados não salvos;
- [ ] Evitar repetição de código.

---

# 📝 Resumo da aula

Nesta etapa, programei o botão **Sair** da tela de cadastro.

Aprendi a:

- Solicitar confirmação;
- Interpretar respostas do `JOptionPane`;
- Fechar uma janela com `dispose()`;
- Encerrar o sistema com `System.exit(0)`;
- Configurar o comportamento do botão X;
- Trabalhar com `WindowEvent`;
- Reutilizar o método `confirmarSaida()`;
- Proteger dados ainda não salvos.

Agora a tela possui três funcionalidades principais:

```text
Cadastrar aluno
Limpar formulário
Sair do sistema
```

---

# 🚀 Próxima etapa

Na **Parte 5.4**, programarei o botão **Consulta**, criando a navegação entre a tela de cadastro e uma nova tela responsável por listar, localizar, alterar e excluir alunos cadastrados no PostgreSQL.
