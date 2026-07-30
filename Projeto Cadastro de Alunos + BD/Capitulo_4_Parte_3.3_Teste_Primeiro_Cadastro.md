# 📘 Capítulo 4

# Parte 3.3 --- Testando o Primeiro Cadastro de Alunos

## 🎯 Objetivos

Nesta etapa colocarei em prática tudo o que foi desenvolvido até agora,
realizando o primeiro cadastro de um aluno no PostgreSQL por meio da
classe `AlunoDAO`.

Ao final desta seção, eu serei capaz de:

-   Criar uma classe de teste para o cadastro.
-   Instanciar um objeto `Aluno`.
-   Preencher seus atributos.
-   Chamar o método `cadastrar()`.
-   Confirmar o registro no banco de dados.

------------------------------------------------------------------------

# 📖 Por que criar uma classe de teste?

Antes de integrar o cadastro às telas gráficas do Swing, é importante
validar a lógica utilizando uma aplicação simples.

Assim, consigo identificar problemas com mais facilidade.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteAlunoDAO
```

------------------------------------------------------------------------

# 💻 Código completo

``` java
public class TesteAlunoDAO {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();

        aluno.setNome("João da Silva");
        aluno.setTurma("TDS-01");
        aluno.setEmail("joao@email.com");

        AlunoDAO dao = new AlunoDAO();

        dao.cadastrar(aluno);

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Criando o objeto

``` java
Aluno aluno = new Aluno();
```

Cria um novo objeto que representará um aluno.

## Preenchendo os dados

``` java
aluno.setNome(...);
```

Os métodos `set...()` atribuem valores aos atributos da entidade.

## Criando o DAO

``` java
AlunoDAO dao = new AlunoDAO();
```

Instancia a classe responsável pelas operações de banco de dados.

## Executando o cadastro

``` java
dao.cadastrar(aluno);
```

Envia o objeto para o método `cadastrar()`, que executará o comando
`INSERT`.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
main()
   │
   ▼
Criar Aluno
   │
   ▼
Preencher atributos
   │
   ▼
AlunoDAO.cadastrar()
   │
   ▼
PreparedStatement
   │
   ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🧪 Conferindo no pgAdmin

Após executar a aplicação:

1.  Abra o **pgAdmin**.
2.  Localize a tabela `alunos`.
3.  Execute:

``` sql
SELECT * FROM alunos;
```

Se tudo ocorreu corretamente, o novo registro será exibido.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Ao chamar `dao.cadastrar(aluno)`:

1.  O objeto `Aluno` é recebido pelo DAO.
2.  O método extrai os dados usando os getters.
3.  O `PreparedStatement` substitui os parâmetros (`?`).
4.  O PostgreSQL grava o registro.
5.  O JDBC informa se a operação foi concluída.

------------------------------------------------------------------------

# 💼 Boas práticas

-   Teste cada funcionalidade antes de criar a interface gráfica.
-   Utilize dados diferentes em cada execução.
-   Verifique o resultado diretamente no banco.
-   Feche corretamente a conexão após o cadastro.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Não preencher os atributos do objeto.
-   Executar o programa sem criar a tabela.
-   Esquecer de adicionar o driver JDBC.
-   Não consultar a tabela para validar o resultado.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre confirme o resultado no banco de dados. A mensagem "Cadastro
realizado" é importante, mas a confirmação definitiva é visualizar o
registro gravado.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Objeto Aluno
      │
      ▼
AlunoDAO
      │
      ▼
INSERT
      │
      ▼
Tabela alunos
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Cadastre três alunos diferentes utilizando a classe de teste e confirme,
no pgAdmin, que todos foram inseridos corretamente.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteAlunoDAO`.
-   [ ] Instanciar um objeto `Aluno`.
-   [ ] Preencher os atributos.
-   [ ] Executar `dao.cadastrar(aluno)`.
-   [ ] Validar o cadastro no PostgreSQL.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.4**, aprenderemos a consultar os registros utilizando o
comando `SELECT`, `ResultSet` e a listar todos os alunos cadastrados.
