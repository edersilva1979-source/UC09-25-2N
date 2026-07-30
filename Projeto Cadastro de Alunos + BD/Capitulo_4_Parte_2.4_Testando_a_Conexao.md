# 📘 Capítulo 4

# Parte 2.4 --- Testando a Primeira Conexão com o PostgreSQL

## 🎯 Objetivos

Agora chegou um momento muito esperado: verificar se toda a configuração
realizada até aqui está funcionando corretamente.

Ao final desta seção, eu serei capaz de:

-   Criar uma classe de teste.
-   Chamar o método `Conexao.conectar()`.
-   Verificar se a conexão foi aberta com sucesso.
-   Interpretar mensagens de erro.
-   Corrigir problemas comuns de conexão.

------------------------------------------------------------------------

# 📖 Por que criar uma classe de teste?

Antes de desenvolver telas, cadastros e consultas, preciso ter certeza
de que a comunicação entre o Java e o PostgreSQL está funcionando.

Por isso criarei uma classe simples apenas para realizar esse teste.

------------------------------------------------------------------------

# 📁 Criando a classe

Crie uma nova classe chamada:

``` text
TesteConexao
```

Ela ficará em **Source Packages**, junto com as demais classes do
projeto.

------------------------------------------------------------------------

# 💻 Código completo

``` java
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        Connection conexao = Conexao.conectar();

        if (conexao != null) {
            System.out.println("✅ Conexão realizada com sucesso!");
        } else {
            System.out.println("❌ Não foi possível conectar ao banco.");
        }

    }

}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Import

``` java
import java.sql.Connection;
```

Disponibiliza o tipo `Connection`.

## Chamada da conexão

``` java
Connection conexao = Conexao.conectar();
```

Solicita que a classe `Conexao` tente abrir uma conexão com o
PostgreSQL.

## Verificação

``` java
if (conexao != null)
```

Confirma se um objeto foi realmente retornado.

Se a conexão falhar, o retorno será `null`.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Executar main()
      │
      ▼
Conexao.conectar()
      │
      ├───────────────┐
      │               │
Connection         null
      │               │
      ▼               ▼
Mensagem       Mensagem
de sucesso     de erro
```

------------------------------------------------------------------------

# 🧪 Laboratório

Realize os testes abaixo e anote o resultado.

  Situação                  Resultado esperado
  ------------------------- -------------------------------
  Banco ligado              Conexão realizada com sucesso
  Banco desligado           Mensagem de erro
  Senha incorreta           Mensagem de erro
  Usuário incorreto         Mensagem de erro
  Nome do banco incorreto   Mensagem de erro

------------------------------------------------------------------------

# 💡 Dica do Professor

Teste apenas uma alteração por vez.

Se você modificar usuário, senha e URL simultaneamente, ficará mais
difícil descobrir qual é a causa do problema.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   PostgreSQL não iniciado.
-   Driver JDBC não adicionado ao projeto.
-   Porta incorreta.
-   Nome do banco diferente do criado.
-   Usuário ou senha inválidos.

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o método `main()` é executado:

1.  A JVM inicia a aplicação.
2.  O método `Conexao.conectar()` é chamado.
3.  O Driver JDBC tenta abrir a conexão.
4.  Um objeto `Connection` ou `null` é retornado.
5.  O `if` decide qual mensagem será exibida.

------------------------------------------------------------------------

# 🏛️ Arquitetura do teste

``` text
TesteConexao
      │
      ▼
Conexao
      │
      ▼
DriverManager
      │
      ▼
Driver JDBC
      │
      ▼
PostgreSQL
```

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

É comum existir uma pequena aplicação ou testes automatizados para
validar a conexão antes de iniciar o desenvolvimento das
funcionalidades.

Isso evita perder tempo procurando erros em telas quando o problema está
apenas na configuração do banco.

------------------------------------------------------------------------

# 📝 Resumo

``` text
main()
   │
   ▼
Conexao.conectar()
   │
   ├── Connection → sucesso
   └── null       → falha
```

------------------------------------------------------------------------

# 🏆 Desafio

Melhore a classe `TesteConexao` para:

-   Exibir a data e hora do teste.
-   Informar quanto tempo a conexão levou para ser criada.
-   Fechar a conexão após o teste utilizando `conexao.close()` (tratando
    possíveis exceções).

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar a classe `TesteConexao`.
-   [ ] Executar o método `main()`.
-   [ ] Verificar o retorno de `Conexao.conectar()`.
-   [ ] Identificar problemas de conexão.
-   [ ] Confirmar que o ambiente está pronto para o desenvolvimento.

------------------------------------------------------------------------

# 🎉 Conclusão

Parabéns!

Agora eu confirmei que minha aplicação consegue se comunicar com o
PostgreSQL utilizando JDBC.

A partir deste ponto, posso começar a desenvolver as funcionalidades de
cadastro, consulta, alteração e exclusão de dados utilizando uma base
sólida e testada.
