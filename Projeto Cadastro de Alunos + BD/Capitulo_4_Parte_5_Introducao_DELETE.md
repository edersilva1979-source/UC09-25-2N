# 📘 Capítulo 4

# Parte 5 --- Introdução à Exclusão de Registros com `DELETE`

## 🎯 Objetivos

Nesta etapa iniciarei a última operação do CRUD: **Delete**.

Vou aprender como remover registros do banco de dados com segurança
utilizando JDBC e PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Entender o comando `DELETE`;
-   Compreender quando utilizar uma exclusão;
-   Conhecer os riscos de remover dados;
-   Preparar a implementação do método `excluir()`.

------------------------------------------------------------------------

# 📖 O que é o comando `DELETE`?

O comando `DELETE` remove registros existentes de uma tabela.

Exemplo:

``` sql
DELETE FROM alunos
WHERE id = 1;
```

Nesse exemplo, apenas o aluno de ID **1** será removido.

------------------------------------------------------------------------

# 📚 Relembrando o CRUD

  Operação   SQL      Situação
  ---------- -------- --------------
  Create     INSERT   ✅ Concluído
  Read       SELECT   ✅ Concluído
  Update     UPDATE   ✅ Concluído
  Delete     DELETE   🚧 Iniciando

------------------------------------------------------------------------

# ⚠️ A importância do `WHERE`

O comando abaixo remove **apenas um registro**:

``` sql
DELETE FROM alunos
WHERE id = 5;
```

Já este comando:

``` sql
DELETE FROM alunos;
```

remove **todos os registros da tabela**.

> **Atenção:** Nunca execute um `DELETE` sem `WHERE` em aplicações
> reais, a menos que essa seja realmente a intenção.

------------------------------------------------------------------------

# 🏗️ Fluxo da exclusão

``` text
Usuário seleciona um aluno
         │
         ▼
Confirma exclusão
         │
         ▼
AlunoDAO.excluir(id)
         │
         ▼
DELETE ... WHERE id = ?
         │
         ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🏛️ Como ficará o método?

``` java
public void excluir(int id) {

    // abrir conexão

    // preparar DELETE

    // preencher parâmetro

    // executar

    // fechar recursos

}
```

Nesta parte vou compreender a estrutura geral. A implementação completa
será feita nas próximas seções.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o PostgreSQL recebe um comando `DELETE`, ele localiza o registro
indicado pela cláusula `WHERE` e o remove da tabela.

Se nenhum registro corresponder ao ID informado, nenhuma linha será
afetada.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em sistemas profissionais, a exclusão normalmente segue estas etapas:

1.  Localizar o registro.
2.  Exibir os dados ao usuário.
3.  Solicitar confirmação.
4.  Executar a exclusão.
5.  Atualizar a tela.

Em alguns sistemas, utiliza-se **exclusão lógica**, marcando o registro
como inativo em vez de apagá-lo fisicamente.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Executar `DELETE` sem `WHERE`.
-   Excluir o registro errado.
-   Não solicitar confirmação ao usuário.
-   Não verificar o retorno de `executeUpdate()`.

------------------------------------------------------------------------

# 🧪 Laboratório

Analise o comando:

``` sql
DELETE FROM alunos
WHERE id = 8;
```

Responda:

-   Qual registro será removido?
-   O que acontece se o ID 8 não existir?
-   Por que o `WHERE` é essencial?

------------------------------------------------------------------------

# 💡 Dica do Professor

Antes de excluir qualquer registro, consulte-o e confirme a operação com
o usuário. Essa prática evita perdas acidentais de dados.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Selecionar registro
        │
        ▼
Confirmar exclusão
        │
        ▼
DELETE
        │
WHERE id = ?
        │
        ▼
Registro removido
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Escreva um comando SQL para excluir apenas o aluno de ID **15**.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o comando `DELETE`.
-   [ ] Compreender a importância do `WHERE`.
-   [ ] Conhecer os riscos da exclusão.
-   [ ] Entender o fluxo seguro para remover registros.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5.1**, implementarei o método `excluir(int id)` na classe
`AlunoDAO`, utilizando `PreparedStatement` e `executeUpdate()` para
remover registros com segurança.
