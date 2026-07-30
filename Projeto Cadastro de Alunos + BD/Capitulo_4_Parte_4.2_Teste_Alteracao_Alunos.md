# 📘 Capítulo 4

# Parte 4.2 --- Testando a Atualização de Alunos

## 🎯 Objetivos

Agora vou validar o método `alterar(Aluno aluno)` criado na classe
`AlunoDAO`, garantindo que os registros sejam atualizados corretamente
no PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Criar uma classe de teste para atualização;
-   Alterar os dados de um aluno existente;
-   Confirmar as alterações no banco de dados;
-   Interpretar o retorno do método `executeUpdate()`.

------------------------------------------------------------------------

# 📖 Por que testar?

Antes de utilizar o método nas telas Java Swing, preciso confirmar que
toda a lógica funciona corretamente.

Isso facilita a identificação de problemas e aumenta a confiança no
código desenvolvido.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteAlterarAluno
```

------------------------------------------------------------------------

# 💻 Código completo

``` java
public class TesteAlterarAluno {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();

        aluno.setId(1);
        aluno.setNome("João Pedro da Silva");
        aluno.setTurma("TDS-02");
        aluno.setEmail("joaopedro@email.com");

        AlunoDAO dao = new AlunoDAO();

        dao.alterar(aluno);

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Criando o objeto

``` java
Aluno aluno = new Aluno();
```

Representa o aluno que será atualizado.

## Informando o ID

``` java
aluno.setId(1);
```

O ID identifica exatamente qual registro será alterado.

## Alterando os dados

``` java
aluno.setNome(...);
aluno.setTurma(...);
aluno.setEmail(...);
```

Esses valores substituirão os existentes no banco.

## Executando

``` java
dao.alterar(aluno);
```

O DAO executa o comando `UPDATE`.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
main()
   │
   ▼
Criar objeto Aluno
   │
   ▼
Informar ID
   │
   ▼
Novos dados
   │
   ▼
AlunoDAO.alterar()
   │
   ▼
UPDATE
   │
   ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🧪 Validando no pgAdmin

Após executar a aplicação:

``` sql
SELECT * FROM alunos WHERE id = 1;
```

Compare os valores exibidos com aqueles informados no código Java.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `executeUpdate()` é executado:

1.  O PostgreSQL localiza o registro pelo ID.
2.  Atualiza apenas as colunas informadas.
3.  Retorna a quantidade de linhas modificadas.
4.  O JDBC entrega esse valor para a aplicação.

Se nenhuma linha for alterada, normalmente o ID informado não existe.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em aplicações reais, a atualização normalmente ocorre após o usuário
editar um formulário.

Antes de salvar, o sistema costuma validar:

-   campos obrigatórios;
-   formato do e-mail;
-   existência do registro;
-   regras de negócio.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Alterar um ID inexistente.
-   Esquecer de preencher o ID.
-   Não conferir o resultado no banco.
-   Alterar a ordem dos parâmetros do `PreparedStatement`.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre consulte o registro antes e depois da atualização. Assim você
consegue visualizar exatamente o que foi modificado.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Aluno atualizado
      │
      ▼
AlunoDAO.alterar()
      │
      ▼
UPDATE
      │
      ▼
Registro modificado
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Atualize três alunos diferentes e confirme as alterações utilizando:

``` sql
SELECT * FROM alunos;
```

Observe se apenas os registros desejados foram modificados.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteAlterarAluno`.
-   [ ] Informar um ID válido.
-   [ ] Alterar os dados do aluno.
-   [ ] Executar `dao.alterar(aluno)`.
-   [ ] Confirmar as alterações no PostgreSQL.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5**, iniciarei a última operação do CRUD: **DELETE**,
aprendendo a remover registros com segurança utilizando o comando
`DELETE` e a cláusula `WHERE`.
