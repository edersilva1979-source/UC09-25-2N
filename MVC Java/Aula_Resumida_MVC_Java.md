# Aula Resumida de MVC em Java

## Objetivo da aula

Nesta aula, eu vou explicar de forma simples o que é o padrão MVC, por que ele é utilizado e como ele pode ajudar a organizar melhor os nossos projetos em Java.

A ideia aqui não é complicar o projeto. Pelo contrário. Eu quero mostrar como separar responsabilidades pode deixar o código mais fácil de entender, manter e evoluir.

Ao final desta aula, eu espero que você consiga:

- Entender o que significa MVC
- Identificar o papel de cada camada
- Organizar um projeto Java utilizando MVC
- Criar exemplos simples com Model, View e Controller
- Entender por que essa organização é útil em projetos maiores

---

## 1. O que é MVC?

MVC significa:

```text
Model
View
Controller
```

Em português, podemos entender como:

```text
Model = Modelo
View = Visão
Controller = Controlador
```

O MVC é um padrão de organização de código.

Eu gosto de explicar assim:

```text
Model
Cuida dos dados

View
Cuida da tela

Controller
Cuida da comunicação entre os dois
```

A ideia principal é simples:

Cada parte do sistema deve ter uma responsabilidade.

---

## 2. Por que usar MVC?

Quando começamos a programar, é comum colocar tudo em uma única classe.

Por exemplo:

```text
Tela
+
Botões
+
SQL
+
Validações
+
Regras
+
Conexão
```

Isso funciona no início.

O problema aparece quando o sistema cresce.

Uma classe muito grande fica:

- Mais difícil de entender
- Mais difícil de corrigir
- Mais difícil de testar
- Mais difícil de reutilizar
- Mais difícil de manter

Com MVC, nós dividimos essas responsabilidades.

---

## 3. Entendendo as três partes

### Model

O Model representa os dados da aplicação.

Exemplo:

```java
public class Aluno {

    private int id;
    private String nome;
    private String turma;
    private String email;

}
```

A classe `Aluno` representa um aluno dentro do sistema.

Ela guarda informações.

---

### View

A View representa aquilo que o usuário vê.

Em Java Swing, normalmente teremos:

```text
JFrame
JInternalFrame
JPanel
JButton
JTextField
JTable
JLabel
```

Exemplo:

```text
TelaCadastroAluno
```

Essa tela recebe os dados digitados pelo usuário.

---

### Controller

O Controller faz a comunicação entre a View e o Model.

Ele recebe uma ação da tela e decide o que deve acontecer.

Exemplo:

```text
Usuário clica em Cadastrar

↓

View envia os dados

↓

Controller recebe

↓

Controller cria o Aluno

↓

Controller chama a lógica necessária
```

---

## 4. Visualizando o MVC

Podemos representar assim:

```text
Usuário
   │
   ▼
 View
   │
   ▼
Controller
   │
   ▼
 Model
```

Em um projeto com banco de dados, podemos ter também:

```text
View
  │
  ▼
Controller
  │
  ▼
Model
  │
  ▼
DAO
  │
  ▼
Banco de Dados
```

---

## 5. Um exemplo simples

Vamos imaginar um sistema de cadastro de alunos.

Nós teremos:

```text
Aluno.java

TelaAluno.java

AlunoController.java
```

---

## 6. Criando o Model

Nós vamos criar a classe `Aluno`.

```java
public class Aluno {

    private int id;
    private String nome;
    private String turma;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

Essa classe representa os dados.

---

## 7. Criando o Controller

Agora nós vamos criar:

```text
AlunoController
```

Exemplo:

```java
public class AlunoController {

    public void cadastrar(
            String nome,
            String turma,
            String email) {

        Aluno aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setTurma(turma);
        aluno.setEmail(email);

        System.out.println(
                "Aluno cadastrado:"
        );

        System.out.println(
                aluno.getNome()
        );
    }
}
```

Observe que o Controller recebe os dados e cria o objeto.

---

## 8. Criando a View

Na tela, o botão Cadastrar poderia chamar o Controller.

```java
private void btnCadastrarActionPerformed(
        java.awt.event.ActionEvent evt) {

    String nome =
            txtNome.getText();

    String turma =
            txtTurma.getText();

    String email =
            txtEmail.getText();

    AlunoController controller =
            new AlunoController();

    controller.cadastrar(
            nome,
            turma,
            email
    );
}
```

A tela apenas captura os dados e chama o Controller.

---

## 9. O que melhorou?

Antes, poderíamos ter colocado toda a lógica dentro do botão.

Agora temos:

```text
View

Captura os dados
```

```text
Controller

Controla a ação
```

```text
Model

Representa os dados
```

Essa separação deixa o sistema mais organizado.

---

## 10. Estrutura de pastas

Uma estrutura simples pode ser:

```text
src

├── model
│   └── Aluno.java

├── view
│   └── TelaAluno.java

└── controller
    └── AlunoController.java
```

Se utilizarmos banco de dados:

```text
src

├── model
│   └── Aluno.java

├── view
│   └── TelaAluno.java

├── controller
│   └── AlunoController.java

├── dao
│   └── AlunoDAO.java

└── util
    └── Conexao.java
```

---

## 11. MVC com banco de dados

Em um sistema maior, o fluxo poderá ficar assim:

```text
Tela

↓

Controller

↓

Model

↓

DAO

↓

PostgreSQL
```

Por exemplo:

```text
TelaCadastroAluno

↓

AlunoController

↓

Aluno

↓

AlunoDAO

↓

PostgreSQL
```

---

## 12. Exemplo com DAO

Nós podemos ter:

```java
public class AlunoDAO {

    public boolean cadastrar(
            Aluno aluno) {

        System.out.println(
                "Salvando aluno no banco..."
        );

        return true;
    }
}
```

Depois, no Controller:

```java
public class AlunoController {

    public boolean cadastrar(
            String nome,
            String turma,
            String email) {

        Aluno aluno =
                new Aluno();

        aluno.setNome(nome);
        aluno.setTurma(turma);
        aluno.setEmail(email);

        AlunoDAO dao =
                new AlunoDAO();

        return dao.cadastrar(aluno);
    }
}
```

E na tela:

```java
AlunoController controller =
        new AlunoController();

boolean cadastrou =
        controller.cadastrar(
                txtNome.getText(),
                txtTurma.getText(),
                txtEmail.getText()
        );
```

---

## 13. Exemplo do fluxo completo

```text
Usuário digita os dados

↓

View captura

↓

Controller recebe

↓

Model armazena

↓

DAO envia ao banco

↓

Banco grava

↓

Controller recebe o resultado

↓

View mostra a mensagem
```

---

## 14. O que cada camada não deve fazer?

### Model não deve

- Criar telas
- Exibir mensagens
- Controlar botões

### View não deve

- Executar SQL
- Abrir conexão com banco
- Concentrar regras de negócio

### Controller não deve

- Criar componentes Swing
- Ter código visual
- Armazenar dados permanentemente

---

## 15. Quando vale a pena usar MVC?

Eu recomendo MVC quando o projeto começa a ter:

- Várias telas
- Muitos cadastros
- Banco de dados
- Regras de negócio
- Consultas
- Alterações
- Exclusões
- Relatórios

Quanto maior o sistema, mais útil fica a separação.

---

## 16. MVC é obrigatório?

Não.

MVC é uma forma de organizar o projeto.

Em aplicações muito pequenas, ele pode parecer desnecessário.

Mas quando o sistema cresce, essa separação ajuda muito.

---

## 17. Exemplo simples do dia a dia

Eu gosto de comparar MVC com um restaurante.

```text
View
Garçom

Controller
Cozinha organiza o pedido

Model
Pedido e informações dos pratos
```

O cliente fala com o garçom.

O garçom não prepara a comida.

Ele leva a solicitação para quem deve processá-la.

Essa é a ideia da separação de responsabilidades.

---

## 18. Resumo

```text
Model

Representa os dados
```

```text
View

Representa a interface
```

```text
Controller

Controla a comunicação
```

Em um projeto com banco:

```text
View

↓

Controller

↓

Model

↓

DAO

↓

Banco
```

---

## 19. Exercício rápido

Nós vamos criar uma pequena aplicação de cadastro de produtos.

### Model

Criar:

```text
Produto.java
```

Com:

```text
id
descricao
valor
```

### View

Criar:

```text
TelaProduto.java
```

Com:

```text
txtDescricao
txtValor
btnCadastrar
```

### Controller

Criar:

```text
ProdutoController.java
```

Com o método:

```java
public void cadastrar(
        String descricao,
        double valor)
```

---

## 20. Desafio

Nós vamos evoluir o exercício anterior adicionando:

```text
ProdutoDAO
```

Depois, o fluxo ficará:

```text
TelaProduto

↓

ProdutoController

↓

Produto

↓

ProdutoDAO

↓

PostgreSQL
```

---

## ✅ Checklist

- [ ] Entendi o significado de MVC
- [ ] Sei o que é Model
- [ ] Sei o que é View
- [ ] Sei o que é Controller
- [ ] Entendi por que separar responsabilidades
- [ ] Sei organizar os pacotes
- [ ] Consigo identificar onde cada código deve ficar
- [ ] Entendi como MVC pode trabalhar com DAO
- [ ] Consigo visualizar o fluxo entre tela e banco

---

## Conclusão

Nesta aula, eu apresentei o MVC como uma forma de organizar melhor nossas aplicações Java.

O mais importante neste momento não é decorar nomes.

O importante é entender a ideia:

```text
Cada classe deve ter uma responsabilidade bem definida.
```

Quando nós separamos interface, dados e controle, nosso projeto fica mais fácil de entender e manter.

A partir daqui, nós podemos evoluir nossos projetos Java Swing para uma estrutura mais organizada, preparando o código para sistemas maiores e mais completos.
