# 📘 Capítulo 4

# Parte 3.5 --- Testando a Consulta de Alunos

## 🎯 Objetivos

Agora vou testar o método `listar()` criado na classe `AlunoDAO`,
confirmando que os registros cadastrados no PostgreSQL podem ser
recuperados e exibidos corretamente.

Ao final desta aula, eu serei capaz de:

-   Criar uma classe de teste para consultas;
-   Executar o método `listar()`;
-   Validar os dados retornados pelo banco;
-   Interpretar o funcionamento do `ResultSet`;
-   Identificar possíveis problemas na consulta.

------------------------------------------------------------------------

# 📖 Por que testar antes da interface gráfica?

Antes de integrar o método às telas do Java Swing, preciso garantir que
a lógica funciona corretamente.

Assim, consigo separar problemas de programação dos problemas da
interface.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteConsultaAluno
```

------------------------------------------------------------------------

# 💻 Código completo

``` java
public class TesteConsultaAluno {

    public static void main(String[] args) {

        AlunoDAO dao = new AlunoDAO();

        dao.listar();

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Instanciando o DAO

``` java
AlunoDAO dao = new AlunoDAO();
```

Cria o objeto responsável pelas operações com a tabela `alunos`.

## Executando a consulta

``` java
dao.listar();
```

Esse método abre a conexão, executa o `SELECT`, percorre o `ResultSet` e
exibe todos os registros encontrados.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
main()
   │
   ▼
AlunoDAO.listar()
   │
   ▼
Conexao.conectar()
   │
   ▼
SELECT * FROM alunos
   │
   ▼
ResultSet
   │
   ▼
Console
```

------------------------------------------------------------------------

# 🧪 Resultado esperado

Após executar o programa, o console poderá exibir algo semelhante a:

``` text
------------------------
ID: 1
Nome: João da Silva
Turma: TDS-01
E-mail: joao@email.com

------------------------
ID: 2
Nome: Maria Souza
Turma: TDS-02
E-mail: maria@email.com
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

O método `listar()` percorre o `ResultSet` linha por linha.

A cada chamada de `rs.next()`, o cursor avança para o próximo registro
até chegar ao final da consulta.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Durante o desenvolvimento, é comum testar primeiro pelo console.

Depois que a lógica está validada, os dados passam a alimentar
componentes gráficos como `JTable`, relatórios ou APIs.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   A tabela está vazia e nenhum registro aparece.
-   O método `listar()` não foi implementado corretamente.
-   Os nomes das colunas diferem dos existentes no banco.
-   A conexão não foi aberta.

------------------------------------------------------------------------

# 💡 Dica do Professor

Se nada for exibido, execute primeiro:

``` sql
SELECT * FROM alunos;
```

no pgAdmin para verificar se realmente existem registros gravados.

------------------------------------------------------------------------

# 📝 Resumo

``` text
TesteConsultaAluno
        │
        ▼
AlunoDAO.listar()
        │
        ▼
SELECT
        │
        ▼
ResultSet
        │
        ▼
Console
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Cadastre pelo menos cinco alunos diferentes e confirme se todos são
exibidos corretamente pelo método `listar()`.

Depois, compare a saída do console com o resultado obtido no pgAdmin.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteConsultaAluno`.
-   [ ] Executar o método `listar()`.
-   [ ] Confirmar a exibição dos registros.
-   [ ] Comparar o resultado com o pgAdmin.
-   [ ] Validar que a consulta funciona corretamente.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 3.6**, implementarei a consulta de um aluno por **ID**,
utilizando parâmetros no `PreparedStatement` para aprender a realizar
pesquisas específicas no banco de dados.
