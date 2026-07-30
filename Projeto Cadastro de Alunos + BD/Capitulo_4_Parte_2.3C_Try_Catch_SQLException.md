# 📘 Capítulo 4

# Parte 2.3C --- Tratando Erros com `try`, `catch` e `SQLException`

## 🎯 Objetivos

Nesta etapa vou aprender a tratar possíveis erros durante a tentativa de
conexão com o banco de dados.

Ao final desta seção, eu serei capaz de:

-   Compreender a função do `try`.
-   Entender quando o `catch` é executado.
-   Identificar uma `SQLException`.
-   Criar aplicações mais seguras e amigáveis.

------------------------------------------------------------------------

# 📖 Por que tratar erros?

Nem sempre uma conexão será criada com sucesso.

Alguns exemplos:

-   O PostgreSQL está desligado.
-   A senha está incorreta.
-   O banco não existe.
-   O cabo de rede foi desconectado.

Se esses problemas não forem tratados, a aplicação poderá ser encerrada
inesperadamente.

------------------------------------------------------------------------

# 🧩 Estrutura básica

``` java
try {

    // código que pode gerar erro

} catch (SQLException erro) {

    // tratamento do erro

}
```

------------------------------------------------------------------------

# 🔍 Entendendo o `try`

O bloco `try` contém as instruções que podem lançar uma exceção.

No nosso projeto será aqui que ficará a chamada:

``` java
DriverManager.getConnection(URL, USUARIO, SENHA);
```

------------------------------------------------------------------------

# 🔍 Entendendo o `catch`

Caso ocorra algum problema durante a execução do bloco `try`, a JVM
interrompe a execução daquele trecho e transfere o controle para o bloco
`catch`.

``` java
catch (SQLException erro) {

    System.out.println("Erro ao conectar: " + erro.getMessage());

}
```

------------------------------------------------------------------------

# 🔌 O que é uma `SQLException`?

É uma exceção específica para operações de banco de dados.

Ela pode representar:

-   senha inválida;
-   banco inexistente;
-   servidor indisponível;
-   tabela não encontrada;
-   falhas de comunicação.

------------------------------------------------------------------------

# 🔄 Fluxograma

``` text
Início
   │
   ▼
Executa try
   │
   ├───────────────┐
   │               │
Sem erro       Ocorreu erro
   │               │
   ▼               ▼
Continua       catch(SQLException)
   │               │
   └───────► Mensagem ao usuário
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando `DriverManager.getConnection()` encontra um problema, ele cria um
objeto `SQLException` contendo informações detalhadas sobre a falha.

Esse objeto é entregue ao bloco `catch`, permitindo que a aplicação
trate o problema de forma controlada.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Aplicações profissionais evitam mostrar mensagens técnicas diretamente
ao usuário.

Enquanto o usuário recebe uma mensagem simples, o erro completo costuma
ser registrado em arquivos de log para análise da equipe de
desenvolvimento.

------------------------------------------------------------------------

# 🧪 Laboratório

Altere temporariamente a senha da conexão para um valor incorreto.

Ao executar a aplicação, observe que o bloco `catch` será executado e
exibirá a mensagem retornada por:

``` java
erro.getMessage()
```

Depois retorne a senha correta.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Esquecer o bloco `catch`.
-   Capturar uma exceção genérica quando é possível tratar
    `SQLException`.
-   Ignorar a mensagem de erro.

------------------------------------------------------------------------

# 💡 Dica do Professor

Durante o desenvolvimento, utilize `erro.getMessage()` para entender
exatamente o motivo da falha.

Isso acelera muito a identificação de problemas.

------------------------------------------------------------------------

# 📝 Resumo

``` text
try
 │
 ▼
Executa código
 │
 ├── Sem erro → continua
 │
 └── Com erro → catch(SQLException)
                 │
                 ▼
         Trata a exceção
```

------------------------------------------------------------------------

# 🏆 Mini desafio

1.  Qual é a função do bloco `try`?
2.  Quando o `catch` é executado?
3.  O que representa uma `SQLException`?
4.  Qual método retorna a mensagem da exceção?

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o bloco `try`.
-   [ ] Explicar o bloco `catch`.
-   [ ] Saber o que é uma `SQLException`.
-   [ ] Ler a mensagem retornada por `getMessage()`.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na Parte **2.3D**, aprenderemos como devolver o objeto `Connection`
utilizando `return`, finalizando a implementação do método `conectar()`.
