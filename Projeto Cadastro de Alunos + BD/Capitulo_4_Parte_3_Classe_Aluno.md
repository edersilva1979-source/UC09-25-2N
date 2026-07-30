# 📘 Capítulo 4

# Parte 3 --- Criando a Classe `Aluno`

## 🎯 Objetivos

Nesta etapa iniciarei a criação da primeira classe de domínio do
projeto: **Aluno**.

Ao final desta seção eu serei capaz de:

-   Entender o papel da classe `Aluno`.
-   Criar atributos que representam um aluno.
-   Construir construtores.
-   Criar métodos getters e setters.
-   Aplicar o encapsulamento.
-   Preparar a classe para trabalhar com o banco de dados.

------------------------------------------------------------------------

# 📖 O que é uma classe de domínio?

Uma classe de domínio representa uma entidade do mundo real.

Neste projeto, cada objeto da classe `Aluno` representará um aluno
cadastrado no sistema.

``` text
Aluno
 │
 ├── ID
 ├── Nome
 ├── Turma
 └── E-mail
```

------------------------------------------------------------------------

# 🏛️ UML da Classe

``` text
┌──────────────────────────────┐
│            Aluno             │
├──────────────────────────────┤
│ - id : int                   │
│ - nome : String              │
│ - turma : String             │
│ - email : String             │
├──────────────────────────────┤
│ + Aluno()                    │
│ + Aluno(...)                 │
│ + getters()                  │
│ + setters()                  │
└──────────────────────────────┘
```

------------------------------------------------------------------------

# 📄 Código completo

``` java
public class Aluno {

    private int id;
    private String nome;
    private String turma;
    private String email;

    public Aluno() {

    }

    public Aluno(int id, String nome, String turma, String email) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.email = email;
    }

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

------------------------------------------------------------------------

# 🔍 Explicando os atributos

## `id`

Identificador único do aluno no banco de dados.

## `nome`

Nome completo do aluno.

## `turma`

Turma em que o aluno está matriculado.

## `email`

Endereço eletrônico do aluno.

------------------------------------------------------------------------

# 🧠 Encapsulamento

Os atributos foram declarados como `private`.

Isso impede alterações diretas por outras classes.

O acesso será realizado pelos métodos:

-   `get...()`
-   `set...()`

------------------------------------------------------------------------

# 🔄 Fluxo de utilização

``` text
Tela Cadastro
      │
      ▼
Cria objeto Aluno
      │
      ▼
Define atributos
      │
      ▼
Envia para AlunoDAO
      │
      ▼
Banco de Dados
```

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em aplicações profissionais, classes como `Aluno` normalmente não
possuem regras de acesso ao banco.

Sua responsabilidade é apenas representar os dados da entidade.

As operações de cadastro, consulta, alteração e exclusão ficam
concentradas nas classes DAO ou Repository.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Declarar atributos como `public`.
-   Não criar construtores.
-   Esquecer getters e setters.
-   Misturar código SQL dentro da classe de domínio.

------------------------------------------------------------------------

# 🧪 Laboratório

Crie um objeto utilizando o construtor vazio.

Depois utilize os métodos `set...()` para preencher todos os atributos.

Em seguida, utilize os métodos `get...()` para exibir os dados no
console.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre mantenha a responsabilidade da classe bem definida.

A classe `Aluno` representa um aluno.

Ela não deve abrir conexões nem executar comandos SQL.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Classe Aluno

↓

Representa dados

↓

Encapsulamento

↓

Getters

↓

Setters

↓

Pronta para DAO
```

------------------------------------------------------------------------

# 🏆 Desafio

Adicione os atributos:

-   telefone
-   dataNascimento

Atualize:

-   construtores;
-   getters;
-   setters;
-   diagrama UML.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `Aluno`.
-   [ ] Declarar atributos privados.
-   [ ] Criar construtores.
-   [ ] Criar getters e setters.
-   [ ] Compreender o encapsulamento.
-   [ ] Preparar a entidade para uso com JDBC.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na Parte **3.1**, criaremos a classe **AlunoDAO**, responsável por
cadastrar alunos no PostgreSQL utilizando a classe `Conexao`
desenvolvida anteriormente.
