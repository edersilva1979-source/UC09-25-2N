# 📘 Capítulo 4

# Parte 4 --- Atualizando Registros com `UPDATE`

## 🎯 Objetivos

Nesta etapa iniciarei a terceira operação do CRUD: **Update**.

Aprenderei como alterar informações de um aluno já cadastrado utilizando
JDBC e PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Entender o comando `UPDATE`;
-   Compreender quando utilizar uma atualização;
-   Preparar a classe `AlunoDAO` para modificar registros;
-   Entender o fluxo completo da alteração de dados.

------------------------------------------------------------------------

# 📖 O que é o comando `UPDATE`?

O comando `UPDATE` é utilizado para modificar registros já existentes no
banco de dados.

Exemplo:

``` sql
UPDATE alunos
SET nome = 'João Pedro'
WHERE id = 1;
```

Nesse exemplo, apenas o aluno com **ID 1** terá o nome alterado.

------------------------------------------------------------------------

# 📚 CRUD completo

Até agora aprendemos:

  Operação   SQL      Situação
  ---------- -------- ------------------
  Create     INSERT   ✅ Concluído
  Read       SELECT   ✅ Concluído
  Update     UPDATE   🚧 Iniciando
  Delete     DELETE   ⏳ Próxima etapa

------------------------------------------------------------------------

# 🏗️ Fluxo da atualização

``` text
Tela de Cadastro
        │
        ▼
Objeto Aluno
        │
        ▼
AlunoDAO.alterar()
        │
        ▼
PreparedStatement
        │
        ▼
UPDATE
        │
        ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🏛️ Como ficará o método?

Ao final das próximas partes teremos um método semelhante a este:

``` java
public void alterar(Aluno aluno) {

    // abrir conexão

    // preparar UPDATE

    // preencher parâmetros

    // executar UPDATE

    // fechar recursos

}
```

Nesta etapa ainda não implementaremos cada linha. Primeiro
compreenderemos toda a estrutura.

------------------------------------------------------------------------

# 🧠 Quando utilizar UPDATE?

O comando `UPDATE` é utilizado sempre que um registro já existe e
precisa ser modificado.

Exemplos:

-   corrigir um nome;
-   alterar uma turma;
-   atualizar um e-mail;
-   modificar um telefone;
-   atualizar qualquer informação cadastrada.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando executamos um `UPDATE`, o PostgreSQL procura o registro indicado
na cláusula `WHERE`.

Se o registro existir, apenas as colunas informadas serão modificadas.

Os demais dados permanecem inalterados.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Antes de executar um `UPDATE`, normalmente a aplicação:

1.  pesquisa o registro por ID;
2.  apresenta os dados na tela;
3.  permite a edição;
4.  envia apenas as alterações para o banco.

Essa abordagem reduz erros e melhora a experiência do usuário.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer a cláusula `WHERE`.
-   Atualizar o ID por engano.
-   Informar um ID inexistente.
-   Não validar os dados antes da alteração.

> **Atenção:** Um `UPDATE` sem `WHERE` pode alterar **todos os
> registros** da tabela.

------------------------------------------------------------------------

# 🧪 Laboratório

Analise o comando abaixo:

``` sql
UPDATE alunos
SET turma = 'TDS-03'
WHERE id = 5;
```

Responda:

-   Qual registro será alterado?
-   Qual coluna será modificada?
-   O que acontece se o ID 5 não existir?

------------------------------------------------------------------------

# 💡 Dica do Professor

Antes de alterar um registro, consulte-o primeiro.

Assim você confirma que está modificando exatamente o aluno desejado.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Registro existente
        │
        ▼
UPDATE
        │
        ▼
Registro atualizado
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Escreva, em SQL, um comando para alterar apenas o e-mail do aluno cujo
ID é **10**.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o comando `UPDATE`.
-   [ ] Saber quando utilizá-lo.
-   [ ] Compreender a importância da cláusula `WHERE`.
-   [ ] Conhecer o fluxo da atualização.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 4.1**, implementarei o método `alterar(Aluno aluno)` dentro
da classe `AlunoDAO`, construindo o comando SQL `UPDATE` e preparando os
parâmetros com `PreparedStatement`.
