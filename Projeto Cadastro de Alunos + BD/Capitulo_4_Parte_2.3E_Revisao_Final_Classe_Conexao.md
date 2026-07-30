# 📘 Capítulo 4

# Parte 2.3E --- Revisão Final da Classe `Conexao`

## 🎯 Objetivos

Nesta etapa reunirei tudo o que foi aprendido sobre a classe `Conexao`,
analisando o código completo e compreendendo como cada parte trabalha em
conjunto para estabelecer uma conexão com o PostgreSQL.

Ao final desta seção, eu serei capaz de:

-   Interpretar toda a classe `Conexao`.
-   Explicar cada linha do código.
-   Entender o fluxo completo da conexão.
-   Identificar boas práticas e erros comuns.

------------------------------------------------------------------------

# 📄 Classe completa

``` java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
        "jdbc:postgresql://localhost:5432/escola";

    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";

    public static Connection conectar() {

        try {

            Connection conexao =
                DriverManager.getConnection(URL, USUARIO, SENHA);

            return conexao;

        } catch (SQLException erro) {

            System.out.println("Erro ao conectar: " + erro.getMessage());

            return null;
        }
    }
}
```

------------------------------------------------------------------------

# 🔍 Explicando o código

## Imports

Disponibilizam as classes necessárias para trabalhar com JDBC.

## Constantes

Armazenam a URL, o usuário e a senha da conexão.

## Método `conectar()`

Centraliza toda a responsabilidade de criar uma conexão.

## `try`

Executa a tentativa de conexão.

## `DriverManager.getConnection()`

Solicita ao driver JDBC a abertura da conexão.

## `return conexao`

Entrega um objeto `Connection` pronto para uso.

## `catch`

Captura possíveis erros relacionados ao banco.

## `return null`

Indica que não foi possível estabelecer a conexão.

------------------------------------------------------------------------

# 🔄 Fluxograma completo

``` text
Início
   │
   ▼
Carrega classe Conexao
   │
   ▼
Executa conectar()
   │
   ▼
DriverManager.getConnection()
   │
   ├───────────────┐
   │               │
Sucesso         Erro
   │               │
   ▼               ▼
return        catch(SQLException)
Connection         │
   │               ▼
   │          return null
   └───────────────► Fim
```

------------------------------------------------------------------------

# 🏛️ UML final

``` text
┌─────────────────────────────────────────────┐
│                 Conexao                     │
├─────────────────────────────────────────────┤
│ - URL : String                             │
│ - USUARIO : String                         │
│ - SENHA : String                           │
├─────────────────────────────────────────────┤
│ + conectar() : Connection                  │
└─────────────────────────────────────────────┘
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando outra classe executa:

``` java
Connection conexao = Conexao.conectar();
```

a JVM:

1.  Entra no método `conectar()`;
2.  Solicita uma conexão ao Driver JDBC;
3.  Aguarda a resposta do PostgreSQL;
4.  Retorna um objeto `Connection` ou `null` em caso de falha.

------------------------------------------------------------------------

# 💼 Boas práticas

-   Centralize a criação de conexões em uma única classe.
-   Nunca repita o código de conexão em várias telas.
-   Valide se a conexão retornada é diferente de `null`.
-   Utilize mensagens claras durante o desenvolvimento.
-   Em aplicações maiores, considere utilizar pools de conexão.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Repetir o código de conexão em diferentes classes.
-   Esquecer de tratar exceções.
-   Não verificar o retorno da conexão.
-   Informar URL, usuário ou senha incorretos.

------------------------------------------------------------------------

# 🧪 Laboratório

Teste os seguintes cenários:

1.  URL correta.
2.  Banco inexistente.
3.  Usuário incorreto.
4.  Senha incorreta.
5.  PostgreSQL desligado.

Anote a mensagem apresentada em cada situação e identifique a causa do
problema.

------------------------------------------------------------------------

# 📝 Resumo visual

``` text
Classe Conexao
      │
      ▼
Método conectar()
      │
      ▼
DriverManager.getConnection()
      │
      ├── Sucesso → Connection
      └── Falha   → null
```

------------------------------------------------------------------------

# 🏆 Desafio

Crie uma classe chamada `TesteConexao` que:

-   chame `Conexao.conectar();`
-   verifique se o retorno é diferente de `null`;
-   exiba:

``` text
✅ Conexão realizada com sucesso!
```

ou

``` text
❌ Não foi possível conectar ao banco.
```

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Explicar toda a classe `Conexao`.
-   [ ] Entender o fluxo completo da conexão.
-   [ ] Interpretar o método `conectar()`.
-   [ ] Identificar boas práticas.
-   [ ] Criar uma classe de teste.

------------------------------------------------------------------------

# 🎉 Conclusão

Parabéns!

Agora eu já sei criar uma classe responsável por conectar uma aplicação
Java ao PostgreSQL utilizando JDBC.

Nos próximos tópicos utilizarei essa classe para cadastrar, consultar,
alterar e excluir informações do banco de dados sem precisar repetir o
código de conexão.

A classe `Conexao` será a base de todo o restante do projeto.
