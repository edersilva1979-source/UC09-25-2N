# 📘 Capítulo 5 — Interface Gráfica com Java Swing

# Parte 5.2 — Programando o Botão Limpar

## 🎯 Objetivos da aula

Nesta etapa, vou programar o botão **Limpar** da tela `TelaCadastroAluno`.

Esse botão será responsável por apagar os dados digitados nos campos do formulário, preparando a tela para um novo cadastro.

Ao final desta parte, eu serei capaz de:

- Criar o evento do botão `btnLimpar`;
- Apagar o conteúdo dos campos com `setText("")`;
- Reutilizar o método `limparCampos()`;
- Solicitar confirmação antes de apagar os dados;
- Trabalhar com opções do `JOptionPane`;
- Melhorar a experiência do usuário;
- Evitar repetição desnecessária de código.

---

# 🧭 O que o botão Limpar deve fazer?

Quando o usuário clicar no botão **Limpar**, a aplicação deverá:

1. Verificar se existem dados preenchidos;
2. Solicitar uma confirmação;
3. Apagar os campos;
4. Colocar o cursor no campo nome;
5. Manter a tela aberta para um novo cadastro.

O fluxo será:

```text
Usuário clica em Limpar
          │
          ▼
Verificar os campos
          │
          ▼
Solicitar confirmação
          │
    ┌─────┴─────┐
    │           │
   Sim         Não
    │           │
    ▼           ▼
Limpar       Manter dados
campos
```

---

# 🖱️ Criando o evento do botão Limpar

No NetBeans, seguirei estes passos:

1. Abrirei a tela `TelaCadastroAluno`;
2. Selecionarei a aba **Design**;
3. Darei dois cliques no botão **Limpar**;
4. O NetBeans criará automaticamente o método do evento.

O método poderá aparecer assim:

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

}
```

O código do botão será colocado dentro desse método.

---

# 💻 Primeira versão do botão Limpar

A forma mais simples de apagar os campos é utilizar o método `setText("")`.

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

}
```

Essa versão funciona, mas ainda pode ser melhorada.

---

# 🔍 Entendendo o método `setText("")`

Observe esta linha:

```java
txtNome.setText("");
```

O método `setText()` altera o conteúdo do campo.

Quando informo uma `String` vazia:

```java
""
```

o conteúdo do componente é apagado.

O mesmo princípio é utilizado para os demais campos:

```java
txtId.setText("");
txtNome.setText("");
txtTurma.setText("");
txtEmail.setText("");
```

---

# 💡 Colocando o cursor no campo nome

Depois de limpar os campos, posso posicionar o cursor no primeiro campo que deverá ser preenchido.

```java
txtNome.requestFocus();
```

O método completo ficará assim:

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    txtNome.requestFocus();
}
```

---

# ♻️ Evitando repetição de código

Na Parte 5.1, já criei o método:

```java
private void limparCampos() {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    txtNome.requestFocus();
}
```

Como essa lógica já existe, não preciso repetir todas as linhas dentro do botão.

Posso simplesmente chamar:

```java
limparCampos();
```

---

# ✅ Versão recomendada do botão Limpar

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    limparCampos();

}
```

Essa versão é menor, mais organizada e mais fácil de manter.

---

# 🧠 Por que reutilizar um método?

Imagine que o sistema tenha quatro botões diferentes que precisem limpar os campos.

Se eu repetir o mesmo código em quatro lugares, qualquer alteração precisará ser feita quatro vezes.

Com um método separado:

```java
limparCampos();
```

faço a alteração apenas uma vez.

Esse princípio é conhecido como:

```text
DRY — Don't Repeat Yourself
```

Em português:

```text
Não repita você mesmo
```

---

# ⚠️ Problema da limpeza imediata

Na versão atual, basta clicar no botão **Limpar** para apagar tudo.

Isso pode causar perda acidental de dados.

Por exemplo:

1. O usuário preenche nome, turma e e-mail;
2. Clica em **Limpar** sem querer;
3. Todos os dados desaparecem;
4. O usuário precisa digitar novamente.

Para evitar esse problema, adicionarei uma confirmação.

---

# 💬 Solicitando confirmação com `JOptionPane`

Utilizarei o método:

```java
JOptionPane.showConfirmDialog()
```

Exemplo:

```java
int resposta = JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente limpar os campos?",
        "Confirmar limpeza",
        JOptionPane.YES_NO_OPTION
);
```

Esse método apresenta uma caixa de diálogo com as opções:

```text
Sim
Não
```

A escolha do usuário será armazenada na variável `resposta`.

---

# 🔍 Entendendo cada parâmetro

```java
JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente limpar os campos?",
        "Confirmar limpeza",
        JOptionPane.YES_NO_OPTION
);
```

## `this`

Representa a janela atual.

A mensagem ficará associada à tela `TelaCadastroAluno`.

## Mensagem

```java
"Deseja realmente limpar os campos?"
```

É o texto apresentado ao usuário.

## Título

```java
"Confirmar limpeza"
```

É o título da caixa de diálogo.

## Tipo de opção

```java
JOptionPane.YES_NO_OPTION
```

Define que a caixa exibirá os botões **Sim** e **Não**.

---

# ✅ Verificando a resposta

Depois que o usuário escolher uma opção, verificarei o resultado:

```java
if (resposta == JOptionPane.YES_OPTION) {

    limparCampos();
}
```

Se a opção escolhida for **Sim**, os campos serão apagados.

Se a resposta for **Não**, nada acontecerá.

---

# 💻 Botão Limpar com confirmação

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente limpar os campos?",
            "Confirmar limpeza",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        limparCampos();
    }
}
```

---

# ⭐ Versão mais completa

Posso adicionar um ícone de pergunta à caixa de diálogo.

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente apagar os dados digitados?",
            "Confirmar limpeza",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        limparCampos();
    }
}
```

---

# 🚫 Evitando uma confirmação desnecessária

Não faz sentido perguntar se o usuário deseja limpar quando todos os campos já estão vazios.

Posso verificar isso antes de abrir a caixa de diálogo.

```java
boolean camposVazios =
        txtNome.getText().trim().isEmpty()
        && txtTurma.getText().trim().isEmpty()
        && txtEmail.getText().trim().isEmpty();
```

Se todos os campos estiverem vazios, apenas posicionarei o cursor no campo nome.

---

# 💻 Versão completa e recomendada

```java
private void btnLimparActionPerformed(
        java.awt.event.ActionEvent evt) {

    boolean camposVazios =
            txtNome.getText().trim().isEmpty()
            && txtTurma.getText().trim().isEmpty()
            && txtEmail.getText().trim().isEmpty();

    if (camposVazios) {

        txtNome.requestFocus();
        return;
    }

    int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente apagar os dados digitados?",
            "Confirmar limpeza",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {

        limparCampos();
    }
}
```

---

# 🔍 Explicando a versão completa

## 1. Criando a variável `camposVazios`

```java
boolean camposVazios =
```

Essa variável armazenará `true` ou `false`.

---

## 2. Verificando o campo nome

```java
txtNome.getText().trim().isEmpty()
```

Verifica se o campo nome está vazio.

---

## 3. Utilizando o operador `&&`

```java
&&
```

O operador `&&` significa **E**.

Todas as condições precisam ser verdadeiras para que `camposVazios` seja `true`.

---

## 4. Interrompendo o evento

```java
if (camposVazios) {

    txtNome.requestFocus();
    return;
}
```

Se os campos já estiverem vazios:

- O foco será colocado no campo nome;
- O evento será encerrado;
- A caixa de confirmação não será exibida.

---

## 5. Solicitando confirmação

```java
int resposta = JOptionPane.showConfirmDialog(
```

A caixa de diálogo será exibida apenas quando existir algum dado preenchido.

---

## 6. Limpando apenas quando o usuário confirmar

```java
if (resposta == JOptionPane.YES_OPTION) {

    limparCampos();
}
```

O método `limparCampos()` somente será executado após a confirmação.

---

# 🧹 Método `limparCampos()` completo

O método pode permanecer dentro da classe `TelaCadastroAluno`, mas fora dos eventos dos botões.

```java
private void limparCampos() {

    txtId.setText("");
    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    txtNome.requestFocus();
}
```

---

# 📍 Onde colocar o método?

O método pode ser colocado depois do construtor da classe:

```java
public class TelaCadastroAluno extends javax.swing.JFrame {

    public TelaCadastroAluno() {

        initComponents();

        setLocationRelativeTo(null);
    }

    private void limparCampos() {

        txtId.setText("");
        txtNome.setText("");
        txtTurma.setText("");
        txtEmail.setText("");

        txtNome.requestFocus();
    }

    // Eventos dos botões
}
```

> ⚠️ **Atenção:** Não coloque o método `limparCampos()` dentro do método `initComponents()`.

---

# 🎯 Melhorando o construtor da tela

Posso aproveitar o construtor para centralizar a janela e posicionar o cursor no campo nome.

```java
public TelaCadastroAluno() {

    initComponents();

    setLocationRelativeTo(null);

    txtNome.requestFocus();
}
```

---

# 🪟 Centralizando a janela

```java
setLocationRelativeTo(null);
```

Essa instrução posiciona a janela no centro da tela.

Ela deve ser executada depois de:

```java
initComponents();
```

---

# 🔄 Fluxograma completo do botão Limpar

```text
Clique no botão Limpar
          │
          ▼
Verificar se os campos estão vazios
          │
     ┌────┴────┐
     │         │
    Sim       Não
     │         │
     ▼         ▼
Focar nome   Mostrar confirmação
     │             │
     ▼        ┌────┴────┐
 Encerrar     │         │
             Sim       Não
              │         │
              ▼         ▼
         Limpar campos  Manter dados
              │
              ▼
         Focar no nome
```

---

# 🔬 Por baixo dos panos

Quando clico no botão **Limpar**, o Swing executa o evento:

```java
btnLimparActionPerformed()
```

Dentro desse evento:

1. A aplicação lê o conteúdo dos campos;
2. Verifica se existe algum dado;
3. Exibe uma caixa de confirmação;
4. Aguarda a resposta do usuário;
5. Compara a resposta com `YES_OPTION`;
6. Executa o método `limparCampos()`;
7. Atualiza os componentes na tela.

Tudo isso acontece durante a execução da interface gráfica.

---

# 💼 Como as empresas fazem?

Em sistemas profissionais, botões de limpeza ou cancelamento normalmente seguem algumas regras:

- Não apagam dados sem confirmação;
- Não limpam campos vazios;
- Mantêm mensagens objetivas;
- Posicionam o cursor no primeiro campo;
- Reutilizam métodos;
- Diferenciam **Limpar**, **Cancelar** e **Novo**.

## Limpar

Apaga os dados digitados no formulário.

## Cancelar

Interrompe uma edição ou operação em andamento.

## Novo

Prepara a tela para um novo cadastro.

Em alguns sistemas, esses três comportamentos podem ser combinados em um único botão, dependendo da regra de negócio.

---

# ⚠️ Erros comuns

## Erro 1 — Repetir o mesmo código

```java
txtId.setText("");
txtNome.setText("");
txtTurma.setText("");
txtEmail.setText("");
```

em vários botões.

### Solução

Criar e reutilizar:

```java
limparCampos();
```

---

## Erro 2 — Limpar sem confirmação

Isso pode causar perda acidental dos dados digitados.

### Solução

Utilizar:

```java
JOptionPane.showConfirmDialog()
```

---

## Erro 3 — Comparar a resposta incorretamente

Exemplo incorreto:

```java
if (resposta == 1) {
```

### Solução

Utilizar a constante correta:

```java
if (resposta == JOptionPane.YES_OPTION) {
```

---

## Erro 4 — Colocar o método dentro do evento

Um método não deve ser declarado dentro de outro método.

### Solução

Criar `limparCampos()` diretamente dentro da classe.

---

## Erro 5 — Alterar o `initComponents()`

O NetBeans gerencia esse método automaticamente.

### Solução

Criar métodos próprios fora da área protegida pelo editor visual.

---

# 🧪 Laboratório prático

## Teste 1 — Campos vazios

1. Abra a tela;
2. Não preencha nada;
3. Clique em **Limpar**;
4. Verifique se nenhuma confirmação desnecessária aparece;
5. Confirme se o cursor permanece no campo nome.

## Teste 2 — Cancelar a limpeza

1. Preencha os campos;
2. Clique em **Limpar**;
3. Escolha **Não**;
4. Verifique se os dados foram mantidos.

## Teste 3 — Confirmar a limpeza

1. Preencha os campos;
2. Clique em **Limpar**;
3. Escolha **Sim**;
4. Verifique se todos os campos foram apagados.

## Teste 4 — Foco do teclado

1. Confirme a limpeza;
2. Comece a digitar;
3. Verifique se o texto aparece diretamente no campo nome.

---

# 💡 Dicas do Professor

> 💡 Sempre reutilize o método `limparCampos()`.

> 💡 Evite perguntas desnecessárias quando os campos já estiverem vazios.

> 💡 Use mensagens curtas e fáceis de entender.

> 💡 O botão Limpar não deve fechar a aplicação.

> 💡 Mantenha o foco no primeiro campo após a limpeza.

---

# 🧠 Curiosidade

O método `showConfirmDialog()` retorna um número inteiro.

As constantes do `JOptionPane` tornam esse retorno mais fácil de entender:

```java
JOptionPane.YES_OPTION
JOptionPane.NO_OPTION
JOptionPane.CANCEL_OPTION
JOptionPane.CLOSED_OPTION
```

Em vez de trabalhar diretamente com números, utilizo essas constantes para deixar o código mais legível.

---

# 🏆 Mini desafio 1

Depois de limpar os campos, exiba uma mensagem:

```java
JOptionPane.showMessageDialog(
        this,
        "Campos limpos com sucesso."
);
```

Depois, avalie se essa mensagem realmente melhora a experiência do usuário ou se apenas adiciona um clique desnecessário.

---

# 🏆 Mini desafio 2

Altere o texto do botão de:

```text
Limpar
```

para:

```text
Novo
```

Depois, faça o botão:

1. Limpar os campos;
2. Habilitar o campo nome;
3. Habilitar o campo turma;
4. Habilitar o campo e-mail;
5. Colocar o foco no nome.

---

# 🏆 Desafio adicional

Crie um método chamado:

```java
private boolean existemDadosPreenchidos()
```

Esse método deverá retornar `true` quando existir algum campo preenchido.

Exemplo:

```java
private boolean existemDadosPreenchidos() {

    return !txtNome.getText().trim().isEmpty()
            || !txtTurma.getText().trim().isEmpty()
            || !txtEmail.getText().trim().isEmpty();
}
```

Depois, utilize esse método no botão:

```java
if (!existemDadosPreenchidos()) {

    txtNome.requestFocus();
    return;
}
```

---

# ✅ Checklist de implementação

- [ ] Criar o evento do botão `btnLimpar`;
- [ ] Reutilizar o método `limparCampos()`;
- [ ] Apagar os campos com `setText("")`;
- [ ] Colocar o foco no campo nome;
- [ ] Verificar se os campos já estão vazios;
- [ ] Solicitar confirmação com `showConfirmDialog()`;
- [ ] Comparar a resposta com `YES_OPTION`;
- [ ] Manter os dados quando o usuário escolher **Não**;
- [ ] Testar diferentes cenários;
- [ ] Não alterar o método `initComponents()`.

---

# 📝 Resumo da aula

Nesta etapa, programei o botão **Limpar** da tela de cadastro.

Aprendi a:

- Apagar o conteúdo de componentes;
- Trabalhar com `setText("")`;
- Posicionar o cursor com `requestFocus()`;
- Reutilizar métodos;
- Evitar repetição de código;
- Solicitar confirmação;
- Interpretar a resposta do `JOptionPane`;
- Melhorar a usabilidade da aplicação.

Agora a tela possui duas funcionalidades importantes:

```text
Cadastrar aluno
Limpar formulário
```

---

# 🚀 Próxima etapa

Na **Parte 5.3**, programarei o botão **Sair**, utilizando uma caixa de confirmação para evitar o fechamento acidental da aplicação e aprendendo a diferença entre `dispose()` e `System.exit(0)`.
