# Projeto Gráfico Simples com Java Swing e PostgreSQL

## Objetivo da aula

Nesta aula vou evoluir nosso projeto para uma versão gráfica utilizando
Java, NetBeans, JFrame Form, PostgreSQL e JDBC. Utilizaremos o banco de
dados **escola** para desenvolver uma tela simples de cadastro de
alunos.

## Fluxo

``` text
Usuário preenche Nome, Turma e Email
        ↓
Clica em Cadastrar
        ↓
Java envia os dados ao PostgreSQL
        ↓
Aluno é salvo no banco
        ↓
Mensagem de sucesso
```

## Banco de dados

``` sql
CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    turma VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);
```

## Projeto

Crie um projeto Java chamado **EscolaGrafica**.

Adicione o driver JDBC do PostgreSQL em:

``` text
Properties
→ Libraries
→ Classpath
→ Add JAR/Folder
```

## Estrutura

``` text
Source Packages

Conexao.java
Aluno.java
TelaCadastroAluno.java
```

## Classe Conexao

Configure a URL, usuário, senha e o método `conectar()` para o banco
**escola**.

## Classe Aluno

Implemente o método:

``` java
public boolean cadastrar(String nome,
                         String turma,
                         String email)
```

Utilize `PreparedStatement` para executar o `INSERT`.

## Criando o JFrame

Crie um JFrame Form chamado:

``` text
TelaCadastroAluno
```

Adicione:

-   JPanel
-   JLabel: Nome, Turma, Email
-   JTextField: txtNome, txtTurma, txtEmail
-   JButton: btnCadastrar, btnLimpar e btnSair

## Layout

``` text
CADASTRO DE ALUNOS

Nome:   [__________________]

Turma:  [__________________]

Email:  [__________________]

[Cadastrar] [Limpar] [Sair]
```

## Construtor

``` java
setLocationRelativeTo(null);
setTitle("Cadastro de Alunos");
setResizable(false);
```

## Método limparCampos

``` java
private void limparCampos(){

    txtNome.setText("");
    txtTurma.setText("");
    txtEmail.setText("");

    txtNome.requestFocus();

}
```

## Botão Cadastrar

1.  Ler os dados dos campos.
2.  Validar campos vazios.
3.  Criar um objeto Aluno.
4.  Chamar `cadastrar()`.
5.  Mostrar mensagem de sucesso ou erro.

## Botão Limpar

``` java
limparCampos();
```

## Botão Sair

``` java
dispose();
```

## Teste

Digite:

``` text
Nome: Carlos Silva
Turma: Turma A
Email: carlos@email.com
```

Clique em **Cadastrar**.

## Conferindo no PostgreSQL

``` sql
SELECT * FROM aluno ORDER BY id;
```

## Fluxo da aplicação

``` text
Tela Swing
    ↓
Botão Cadastrar
    ↓
Classe Aluno
    ↓
Classe Conexao
    ↓
PreparedStatement
    ↓
PostgreSQL
```

## O que aprendi

-   Criar um JFrame Form.
-   Utilizar JLabel, JTextField e JButton.
-   Conectar Java ao PostgreSQL.
-   Utilizar PreparedStatement.
-   Exibir mensagens com JOptionPane.
-   Integrar Java Swing com PostgreSQL.

## Próxima aula

Adicionar uma JTable para listar os alunos cadastrados e realizar
consultas diretamente pela interface gráfica.
