# Exercícios Práticos: Conectando Java ao PostgreSQL

## Objetivo

Nestes exercícios, vou praticar todo o processo de criação de uma
aplicação Java conectada ao PostgreSQL utilizando JDBC.

Ao final, serei capaz de:

-   Criar bancos de dados no PostgreSQL.
-   Criar tabelas.
-   Configurar o driver JDBC no NetBeans.
-   Criar uma classe de conexão.
-   Testar a conexão entre Java e PostgreSQL.

------------------------------------------------------------------------

# Exercício 1: Sistema Inicial de um Banco

## Objetivo

Criar uma aplicação Java conectada ao PostgreSQL para simular o início
de um sistema bancário.

## 1. Criando o banco de dados

``` sql
CREATE DATABASE banco_app;
```

Conecte-se ao banco `banco_app`.

## 2. Criando as tabelas

### Tabela cliente

``` sql
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome ......
    cpf ......
    telefone .....
    email .....
);

OBS.: CPF é Unico, e não pode ser vazio.
Email é Unico.
```

### Tabela conta

``` sql
CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    numero_conta ........
    agencia .........
    saldo ..........
    tipo_conta ........
);

OBS.: Numero_conta é único e não pode ser vazio
agencia não pode ser vazio
saldo não pode ser vazio
tipo_conta não pode ser vazio
```

## 3. Criando o projeto Java

Projeto:

``` text
exercicio_banco_jdbc
```

## 4. Adicionando o driver JDBC

No NetBeans:

``` text
Projeto
→ Properties
→ Libraries
→ Classpath
→ Add JAR/Folder
→ Selecione o driver PostgreSQL
```

## 5. Estrutura do projeto

``` text
src
│
├── conexao
│   └── Conexao.java
│
└── teste
    └── TesteConexao.java
```

## 6. Classe Conexao.java

``` java
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {

   .
   .
   .
   .
   .

}
```

## 7. Classe TesteConexao.java

``` java
package teste;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

.
.
.
.
.
.

}
```

## Desafio

Crie uma terceira tabela chamada **funcionario** contendo:

-   id
-   nome
-   cargo
-   salario
-   email

------------------------------------------------------------------------

# Exercício 2: Sistema Inicial de um Zoológico

## Objetivo

Criar uma aplicação Java conectada ao PostgreSQL para simular um sistema
de gerenciamento de um zoológico.

## 1. Criando o banco

``` sql
CREATE DATABASE zoologico_app;
```

## 2. Criando as tabelas

### Animal

``` sql
CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    nome ........
    especie .......
    idade .......
    peso .......
    
);
```

### Cuidador

``` sql
CREATE TABLE cuidador (
    id SERIAL PRIMARY KEY,
    nome ......,
    cpf .......
    telefone .........
    turno ......
);


OBS.: CPF é unico e não pode ser vazio
```

### Recinto

``` sql
CREATE TABLE recinto (
    id SERIAL PRIMARY KEY,
    nome .......
    tipo ......
    capacidade ......
    localizacao ........
);
```

## 3. Criando o projeto

``` text
exercicio_zoologico_jdbc
```

## 4. Adicionando o driver JDBC

``` text
Projeto
→ Properties
→ Libraries
→ Classpath
→ Add JAR/Folder
→ Driver PostgreSQL
```

## 5. Estrutura do projeto

``` text
src
│
├── conexao
│   └── Conexao.java
│
└── teste
    └── TesteConexao.java
```

## 6. Classe Conexao.java

``` java
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    .
    .
    .
    .
    .
}
```

## 7. Classe TesteConexao.java

``` java
package teste;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    .
    .
    .
    .
    .
    .

}
```

------------------------------------------------------------------------

# Checklist Final

Antes de executar o projeto, verifique:

-   PostgreSQL iniciado.
-   Banco criado corretamente.
-   Nome do banco igual ao utilizado na classe `Conexao`.
-   Usuário e senha corretos.
-   Driver JDBC adicionado ao projeto.

