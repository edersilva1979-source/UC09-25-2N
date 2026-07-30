# 📘 Capítulo 4

# Parte 3.7 --- Testando a Consulta de Aluno por ID

## 🎯 Objetivos

Nesta etapa vou testar o método `localizar(int id)` da classe
`AlunoDAO`, verificando se a consulta por ID funciona corretamente antes
de utilizá-la nas telas Java Swing.

Ao final desta seção, eu serei capaz de:

-   Criar uma classe de teste para pesquisa por ID;
-   Executar consultas utilizando diferentes IDs;
-   Interpretar os resultados retornados;
-   Identificar situações em que o registro não existe;
-   Validar o funcionamento da consulta parametrizada.

------------------------------------------------------------------------

# 📖 Por que testar?

Antes de integrar essa funcionalidade à interface gráfica, é importante
garantir que a lógica está correta.

Dessa forma, qualquer erro encontrado estará relacionado apenas à
consulta, tornando a depuração muito mais simples.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteLocalizarAluno
```

------------------------------------------------------------------------

# 💻 Código completo

``` java
public class TesteLocalizarAluno {

    public static void main(String[] args) {

        AlunoDAO dao = new AlunoDAO();

        dao.localizar(1);

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Criando o DAO

``` java
AlunoDAO dao = new AlunoDAO();
```

Cria o objeto responsável pelas operações da tabela `alunos`.

## Chamando a consulta

``` java
dao.localizar(1);
```

Solicita ao banco que procure o aluno cujo ID seja igual a **1**.

Se existir, seus dados serão exibidos.

Caso contrário, a mensagem **"Aluno não encontrado."** será apresentada.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
main()
   │
   ▼
AlunoDAO.localizar(1)
   │
   ▼
SELECT * FROM alunos
WHERE id = ?
   │
   ▼
ResultSet
   │
 ┌─┴─────────────┐
 │               │
Encontrou?      Não encontrou
 │               │
 ▼               ▼
Exibe dados   Exibe mensagem
```

------------------------------------------------------------------------

# 🧪 Testes sugeridos

Execute a aplicação utilizando diferentes IDs.

  ID informado   Resultado esperado
  -------------- -------------------------
  1              Exibe os dados do aluno
  2              Exibe os dados do aluno
  999            Aluno não encontrado

Depois compare os resultados com:

``` sql
SELECT * FROM alunos;
```

executado no pgAdmin.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o método `localizar()` é chamado:

1.  O `PreparedStatement` recebe o valor do ID.
2.  O JDBC substitui o parâmetro `?`.
3.  O PostgreSQL executa a consulta.
4.  O resultado é devolvido como um `ResultSet`.
5.  O método verifica se existe uma linha utilizando `rs.next()`.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

É comum utilizar consultas por ID antes de abrir telas de edição ou
exclusão.

Assim, a aplicação garante que o registro realmente existe antes de
permitir qualquer alteração.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Informar um ID inexistente esperando encontrar dados.
-   Esquecer de cadastrar registros antes do teste.
-   Não tratar o caso em que nenhum registro é localizado.
-   Alterar o SQL e esquecer de atualizar o código Java.

------------------------------------------------------------------------

# 💡 Dica do Professor

Faça vários testes alterando apenas o valor do ID.

Isso ajuda a compreender melhor o funcionamento das consultas
parametrizadas.

------------------------------------------------------------------------

# 📝 Resumo

``` text
TesteLocalizarAluno
        │
        ▼
AlunoDAO.localizar(id)
        │
        ▼
PreparedStatement
        │
        ▼
SELECT ... WHERE id = ?
        │
        ▼
ResultSet
        │
        ▼
Dados ou mensagem de ausência
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Modifique a classe de teste para realizar três pesquisas consecutivas:

``` java
dao.localizar(1);
dao.localizar(2);
dao.localizar(999);
```

Analise o resultado apresentado para cada consulta.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteLocalizarAluno`.
-   [ ] Executar a consulta por ID.
-   [ ] Testar IDs existentes e inexistentes.
-   [ ] Comparar o resultado com o pgAdmin.
-   [ ] Confirmar que a pesquisa funciona corretamente.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.8**, implementarei o método `alterar(Aluno aluno)`,
aprendendo a utilizar o comando **UPDATE** para modificar registros já
existentes no PostgreSQL.
