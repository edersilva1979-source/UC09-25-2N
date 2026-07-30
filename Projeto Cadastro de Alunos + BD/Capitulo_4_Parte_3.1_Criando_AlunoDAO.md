# 📘 Capítulo 4

# Parte 3.1 --- Criando a Classe `AlunoDAO`

## 🎯 Objetivos

Nesta etapa construirei a primeira classe **DAO (Data Access Object)**
do projeto. Ela será responsável por concentrar toda a comunicação entre
a aplicação Java e a tabela **alunos** do PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Entender o que é um DAO.
-   Criar a classe `AlunoDAO`.
-   Organizar corretamente o projeto.
-   Compreender a separação de responsabilidades.
-   Preparar a estrutura para implementar o CRUD.

------------------------------------------------------------------------

# 📖 O que é um DAO?

DAO significa **Data Access Object**.

É um padrão de projeto utilizado para separar as operações de acesso ao
banco de dados das demais classes da aplicação.

Em vez de escrever comandos SQL na tela ou na classe `Aluno`,
centralizarei tudo dentro da classe `AlunoDAO`.

------------------------------------------------------------------------

# 🎯 Responsabilidade da classe

A classe `AlunoDAO` será responsável por:

-   Inserir alunos;
-   Consultar alunos;
-   Alterar alunos;
-   Excluir alunos.

Ela **não representa um aluno**. Ela representa as **operações**
realizadas sobre os alunos.

------------------------------------------------------------------------

# 🏗️ Organização do projeto

``` text
src
│
├── Conexao.java
├── Aluno.java
├── AlunoDAO.java
├── TesteConexao.java
├── TelaCadastro.java
└── TelaConsulta.java
```

------------------------------------------------------------------------

# 🏛️ UML

``` text
┌──────────────────────────────┐
│          AlunoDAO            │
├──────────────────────────────┤
│                              │
├──────────────────────────────┤
│ + cadastrar(Aluno)           │
│ + listar()                   │
│ + localizar(id)              │
│ + alterar(Aluno)             │
│ + excluir(id)                │
└──────────────────────────────┘
```

------------------------------------------------------------------------

# 💻 Criando a classe

Crie uma nova classe chamada:

``` text
AlunoDAO
```

Inicialmente ela ficará assim:

``` java
public class AlunoDAO {

}
```

Neste momento ela ainda não possui atributos nem métodos. Vamos
adicioná-los gradualmente ao longo das próximas partes.

------------------------------------------------------------------------

# 🔄 Como será o fluxo?

``` text
Tela Cadastro
      │
      ▼
Objeto Aluno
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

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Sempre que uma operação de banco for necessária, a aplicação chamará um
método da classe `AlunoDAO`.

Esse método utilizará a classe `Conexao` para abrir uma conexão,
executará o comando SQL correspondente e devolverá o resultado para a
aplicação.

Essa organização facilita a manutenção e evita duplicação de código.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Projetos profissionais costumam possuir um DAO (ou Repository) para cada
entidade do sistema.

Exemplos:

-   `AlunoDAO`
-   `ProfessorDAO`
-   `CursoDAO`
-   `ProdutoDAO`
-   `ClienteDAO`

Cada classe conhece apenas a tabela correspondente.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Escrever SQL dentro da classe `Aluno`.
-   Colocar código SQL nas telas.
-   Misturar regras de negócio com acesso ao banco.
-   Duplicar comandos SQL em várias classes.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Crie a classe `AlunoDAO`.
2.  Confirme que ela compila sem erros.
3.  Compare sua responsabilidade com a classe `Aluno`.
4.  Observe como cada classe possui uma função diferente.

------------------------------------------------------------------------

# 💡 Dica do Professor

Uma boa aplicação é formada por classes pequenas, organizadas e com uma
única responsabilidade.

Quanto melhor essa organização, mais fácil será evoluir o sistema.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Aluno
    │
Representa dados

AlunoDAO
    │
Manipula dados

Conexao
    │
Abre conexão

PostgreSQL
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Explique com suas palavras:

1.  Qual é a diferença entre `Aluno` e `AlunoDAO`?
2.  Por que não devemos colocar comandos SQL dentro da classe `Aluno`?

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `AlunoDAO`.
-   [ ] Entender o padrão DAO.
-   [ ] Organizar corretamente o projeto.
-   [ ] Compreender a separação de responsabilidades.
-   [ ] Preparar a estrutura para implementar o CRUD.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.2**, adicionaremos os primeiros imports (`Connection`,
`PreparedStatement` e `SQLException`) e criaremos o método
`cadastrar()`, responsável por inserir o primeiro aluno no banco de
dados.
