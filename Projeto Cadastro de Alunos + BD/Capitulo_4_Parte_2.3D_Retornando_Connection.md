# 📘 Capítulo 4

# Parte 2.3D --- Retornando o Objeto `Connection`

## 🎯 Objetivos

Nesta etapa concluirei o método `conectar()`, entendendo como devolver
uma conexão pronta para uso pelas demais classes da aplicação.

Ao final desta seção eu serei capaz de:

-   Entender o comando `return`.
-   Compreender o que é um objeto `Connection`.
-   Finalizar o método `conectar()`.
-   Utilizar a conexão em outras classes.

------------------------------------------------------------------------

# 📖 O que significa `return`?

Quando um método possui um tipo de retorno, ele deve devolver um valor
compatível.

No nosso caso:

``` java
public static Connection conectar()
```

O método promete devolver um objeto do tipo `Connection`.

Isso é feito com:

``` java
return conexao;
```

------------------------------------------------------------------------

# 🧩 Implementando o método

``` java
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
```

------------------------------------------------------------------------

# 🔍 Entendendo cada retorno

## Sucesso

``` java
return conexao;
```

Quando a conexão é criada corretamente, ela é devolvida para quem chamou
o método.

------------------------------------------------------------------------

## Falha

``` java
return null;
```

Se ocorrer uma exceção, nenhum objeto `Connection` foi criado.

Nesse caso retornamos `null`, indicando que a conexão não foi
estabelecida.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Início
  │
  ▼
try
  │
  ▼
Conexão criada?
  │
 ├───────────────┐
 │               │
Sim             Não
 │               │
 ▼               ▼
return      catch(SQLException)
conexao          │
                 ▼
          return null
```

------------------------------------------------------------------------

# 🧠 O que é `null`?

`null` representa a ausência de um objeto.

Ou seja:

``` text
Connection

↓

Nenhum objeto criado
```

Por isso outras classes devem verificar se o retorno é diferente de
`null` antes de utilizar a conexão.

Exemplo:

``` java
Connection conexao = Conexao.conectar();

if (conexao != null) {

    System.out.println("Conexão realizada com sucesso.");

}
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o comando `return` é executado, a JVM encerra imediatamente o
método e entrega o objeto retornado para o ponto que realizou a chamada.

Nenhuma instrução abaixo do `return` será executada.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em aplicações modernas é comum lançar a exceção para uma camada superior
ou utilizar pools de conexão.

Mesmo assim, entender o retorno de um objeto `Connection` é essencial
para compreender o funcionamento do JDBC.

------------------------------------------------------------------------

# 🧪 Laboratório

Execute o método com:

-   URL correta;
-   URL incorreta.

Observe que:

-   na primeira situação o retorno será um objeto `Connection`;
-   na segunda situação o retorno será `null`.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer o `return`.
-   Tentar usar a conexão sem verificar se ela é `null`.
-   Colocar código após o `return`, acreditando que será executado.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre valide o retorno antes de utilizar a conexão.

Isso evita exceções como `NullPointerException`.

------------------------------------------------------------------------

# 📝 Resumo

``` text
DriverManager
      │
      ▼
Connection criada
      │
      ├── sucesso → return conexao
      │
      └── erro → return null
```

------------------------------------------------------------------------

# 🏆 Mini desafio

1.  O que faz o comando `return`?
2.  O que significa retornar `null`?
3.  Por que devemos verificar se a conexão é diferente de `null`?
4.  O que acontece após a execução de um `return`?

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o comando `return`.
-   [ ] Explicar o retorno de uma `Connection`.
-   [ ] Compreender o significado de `null`.
-   [ ] Validar a conexão antes de utilizá-la.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na Parte **2.3E**, reuniremos todo o conteúdo desenvolvido até aqui,
analisando a classe `Conexao` completa, comentando cada linha do código
e realizando os primeiros testes práticos de conexão com o PostgreSQL.
