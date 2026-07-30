# 📘 Capítulo 4

# Parte 5.2 --- Testando a Exclusão de Alunos

## 🎯 Objetivos

Nesta etapa vou testar o método `excluir(int id)` da classe `AlunoDAO`,
verificando se a remoção de registros funciona corretamente antes de
integrá-la à interface gráfica em Java Swing.

Ao final desta seção, eu serei capaz de:

-   Criar uma classe de teste para exclusão;
-   Excluir um aluno utilizando seu ID;
-   Confirmar a remoção no PostgreSQL;
-   Interpretar o retorno do método `executeUpdate()`.

------------------------------------------------------------------------

# 📖 Por que testar?

Antes de utilizar qualquer operação em uma aplicação gráfica, é
importante validar toda a lógica no console.

Assim, consigo identificar problemas com mais facilidade e garantir que
o método está funcionando corretamente.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteExcluirAluno
```

------------------------------------------------------------------------

# 💻 Código completo

``` java
public class TesteExcluirAluno {

    public static void main(String[] args) {

        int id = 1;

        AlunoDAO dao = new AlunoDAO();

        dao.excluir(id);

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Definindo o ID

``` java
int id = 1;
```

Representa o aluno que será removido do banco.

## Criando o DAO

``` java
AlunoDAO dao = new AlunoDAO();
```

Cria o objeto responsável pelas operações da tabela `alunos`.

## Executando a exclusão

``` java
dao.excluir(id);
```

Executa o comando `DELETE` utilizando o ID informado.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
main()
   │
   ▼
Informar ID
   │
   ▼
AlunoDAO.excluir(id)
   │
   ▼
DELETE FROM alunos
WHERE id = ?
   │
   ▼
executeUpdate()
   │
   ▼
Registro removido
```

------------------------------------------------------------------------

# 🧪 Validando no PostgreSQL

Após executar a aplicação, utilize a consulta abaixo no pgAdmin:

``` sql
SELECT * FROM alunos;
```

Confirme se o aluno removido não aparece mais na tabela.

Também experimente excluir um ID inexistente e observe a mensagem
retornada pela aplicação.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o método `excluir()` é chamado:

1.  O JDBC envia o comando `DELETE`.
2.  O PostgreSQL procura o registro correspondente ao ID.
3.  Se o registro existir, ele é removido.
4.  O banco informa quantas linhas foram afetadas.
5.  O JDBC devolve esse resultado ao Java.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em aplicações profissionais, normalmente existe uma janela de
confirmação antes da exclusão.

Após a remoção, a tabela da interface é atualizada automaticamente para
refletir a alteração.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Informar um ID inexistente.
-   Excluir o registro errado.
-   Não verificar o resultado da operação.
-   Não conferir a tabela após a exclusão.

------------------------------------------------------------------------

# 🧪 Laboratório

Realize os seguintes testes:

1.  Exclua um aluno existente.
2.  Consulte a tabela.
3.  Tente excluir o mesmo ID novamente.
4.  Observe a mensagem apresentada.
5.  Cadastre um novo aluno e repita o processo.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre confira o conteúdo da tabela antes e depois da exclusão. Esse
hábito facilita muito a identificação de erros durante o
desenvolvimento.

------------------------------------------------------------------------

# 📝 Resumo

``` text
ID
 │
 ▼
AlunoDAO.excluir()
 │
 ▼
DELETE
 │
 ▼
Registro removido
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Altere a classe de teste para solicitar o ID ao usuário utilizando
`Scanner` antes de executar a exclusão.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteExcluirAluno`.
-   [ ] Informar um ID válido.
-   [ ] Executar `dao.excluir(id)`.
-   [ ] Confirmar a remoção no PostgreSQL.
-   [ ] Testar um ID inexistente.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5.3**, revisarei toda a operação **DELETE**, apresentando
boas práticas, cuidados e recomendações para construir aplicações Java
profissionais e seguras.
