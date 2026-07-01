# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 2A • Criando o Primeiro Banco de Dados

> **Curso:** Banco de Dados com PostgreSQL
>
> **Professor:** Éder Silva
>
> **Nível:** Iniciante
>
> **Ferramentas utilizadas:**
>
> * PostgreSQL
> * PGAdmin 4

---

# 📖 Índice

* Revisão
* Conhecendo o PGAdmin 4
* Estrutura do PostgreSQL
* Criando o primeiro banco de dados
* Tipos de dados
* Exercícios
* Desafio

---

# 👋 Bem-vindo à Parte 2A

Até aqui entendemos a história dos bancos de dados e a diferença entre bancos relacionais e não relacionais.

Agora chegou o momento de começar a trabalhar com SQL de verdade.

Nesta aula criaremos nosso primeiro banco de dados utilizando PostgreSQL.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Abrir o PGAdmin 4.
* Conhecer a interface.
* Criar um banco de dados.
* Entender a estrutura de um servidor PostgreSQL.
* Conhecer os principais tipos de dados utilizados em SQL.

---

# 📌 Antes de começar

Quando instalamos o PostgreSQL, normalmente dois programas são instalados.

## PostgreSQL

É o servidor onde os dados ficam armazenados.

Ele trabalha em segundo plano.

Podemos imaginar que ele é o "motor" do banco de dados.

---

## PGAdmin 4

É a interface gráfica.

É através dela que criaremos:

* Bancos
* Tabelas
* Consultas
* Usuários
* Backups

Na maior parte do curso utilizaremos o PGAdmin.

---

# 💡 Analogia

Imagine um carro.

O motor faz todo o trabalho pesado.

O volante apenas permite controlar o carro.

Nesse exemplo:

```text
Motor

↓

PostgreSQL
```

```text
Volante

↓

PGAdmin 4
```

---

# 🚀 Abrindo o PGAdmin

Após instalar o PostgreSQL, abra o PGAdmin 4.

A tela inicial será semelhante a esta:

```text
Object Explorer

Servers

└── PostgreSQL

      Databases

      Login Roles

      Tablespaces
```

Essa árvore representa toda a estrutura do servidor.

---

# Conhecendo a Interface

Observe alguns componentes importantes.

```text
┌─────────────────────────────────────┐
│ Menu Superior                       │
├─────────────────────────────────────┤
│ Barra de Ferramentas                │
├───────────────┬─────────────────────┤
│ Object        │ Área de Trabalho    │
│ Explorer      │                     │
│               │                     │
└───────────────┴─────────────────────┘
```

Durante o curso utilizaremos principalmente:

* Object Explorer
* Query Tool

---

# O que é um Servidor?

Muitos iniciantes confundem servidor com banco de dados.

São coisas diferentes.

O servidor é o local onde ficam armazenados vários bancos de dados.

Exemplo:

```text
Servidor PostgreSQL

│

├── Escola

├── Loja

├── Hospital

├── Biblioteca

└── Empresa
```

Um único servidor pode possuir dezenas ou centenas de bancos.

---

# Estrutura Hierárquica

```text
Servidor

↓

Banco de Dados

↓

Schemas

↓

Tabelas

↓

Registros

↓

Campos
```

Durante esta aula criaremos apenas:

* Banco de Dados

Nas próximas aulas criaremos as tabelas.

---

# Criando nosso primeiro Banco

Existem duas maneiras.

## Método gráfico

No PGAdmin:

Databases

↓

Botão direito

↓

Create

↓

Database

Digite:

```text
escola
```

Depois clique em **Save**.

Pronto.

Seu banco foi criado.

---

# Método utilizando SQL

Também podemos criar utilizando comandos.

Abra:

Tools

↓

Query Tool

Digite:

```sql
CREATE DATABASE escola;
```

Depois clique em executar.

Pronto.

Você acabou de criar seu primeiro banco utilizando SQL.

🎉

---

# Como saber se funcionou?

No Object Explorer aparecerá:

```text
Databases

├── postgres

├── template0

├── template1

└── escola
```

Se o banco apareceu na lista, tudo ocorreu corretamente.

---

# Atualizando a lista

Às vezes o banco não aparece imediatamente.

Basta clicar com o botão direito em:

```text
Databases
```

Depois:

```text
Refresh
```

O banco será exibido.

---

# 💡 Curiosidade

Os bancos:

```text
postgres

template0

template1
```

São criados automaticamente durante a instalação.

Eles fazem parte do funcionamento do PostgreSQL.

Não devemos excluí-los.

---

# O que existe dentro do banco?

Quando expandimos um banco veremos vários objetos.

Exemplo:

```text
escola

Schemas

Tables

Views

Functions

Procedures

Sequences
```

No início utilizaremos praticamente apenas:

Schemas

e

Tables.

---

# O que é um Schema?

O Schema funciona como uma pasta dentro do banco.

Ele organiza os objetos.

Imagine um armário.

Dentro dele existem várias gavetas.

Cada gaveta representa um Schema.

---

## Exemplo

Banco:

```text
Loja
```

Schemas

```text
Vendas

Financeiro

Estoque

RH
```

Cada setor possui suas próprias tabelas.

---

# O Schema Public

Todo banco já possui um Schema chamado:

```text
public
```

Durante este curso utilizaremos esse Schema.

Mais adiante aprenderemos a criar novos.

---

# Tipos de Dados

Antes de criar tabelas precisamos entender uma coisa muito importante.

Todo campo precisa possuir um tipo de dado.

Por exemplo.

O nome de uma pessoa não pode ser armazenado como número.

Da mesma forma, uma idade não deve ser armazenada como texto.

Por isso existem os tipos de dados.

---

# INTEGER

Armazena números inteiros.

Exemplo:

```text
10

20

150

999
```

Não aceita letras.

Nem casas decimais.

---

## Exemplo

```sql
idade INTEGER
```

---

# SERIAL

Muito utilizado para IDs.

Cada novo registro recebe automaticamente um número.

Exemplo:

```text
1

2

3

4

5
```

Não precisamos preencher manualmente.

---

## Exemplo

```sql
id SERIAL
```

---

# VARCHAR

Armazena textos pequenos.

Precisamos informar o tamanho máximo.

Exemplo:

```sql
nome VARCHAR(100)
```

Nesse caso o campo aceita até 100 caracteres.

---

# TEXT

Também armazena texto.

Mas não exige limite.

Muito utilizado para:

* observações;
* comentários;
* descrições.

---

## Exemplo

```sql
descricao TEXT
```

---

# DATE

Armazena datas.

Exemplo:

```text
2026-07-01
```

Formato:

Ano

Mês

Dia

---

## Exemplo

```sql
data_nascimento DATE
```

---

# BOOLEAN

Armazena apenas dois valores.

```text
TRUE

FALSE
```

Muito utilizado para:

* ativo;
* inativo;
* pago;
* cancelado.

---

## Exemplo

```sql
ativo BOOLEAN
```

---

# NUMERIC

Ideal para dinheiro.

Exemplo:

```sql
salario NUMERIC(10,2)
```

Pode armazenar:

```text
1250.90

34999.75

100.00
```

---

# Comparação

| Tipo | Utilização |
|-------|------------|
| SERIAL | Identificador automático |
| INTEGER | Número inteiro |
| VARCHAR | Texto curto |
| TEXT | Texto grande |
| DATE | Datas |
| BOOLEAN | Verdadeiro ou falso |
| NUMERIC | Valores monetários |

---

# Qual tipo escolher?

Imagine um cadastro de aluno.

| Campo | Tipo |
|---------|----------------|
| id | SERIAL |
| nome | VARCHAR(100) |
| idade | INTEGER |
| nascimento | DATE |
| observacoes | TEXT |
| ativo | BOOLEAN |

Cada informação utiliza o tipo mais adequado.

---

# Erros comuns

❌ Guardar idade em VARCHAR.

❌ Guardar telefone em INTEGER.

❌ Guardar salário em TEXT.

Escolher corretamente o tipo melhora o desempenho e evita diversos problemas.

---

# 💡 Dica

Sempre pense na natureza da informação.

É número?

É texto?

É data?

É dinheiro?

Depois escolha o tipo correspondente.

---

# Exercícios

## Exercício 1

Explique a diferença entre PostgreSQL e PGAdmin.

---

## Exercício 2

Qual comando cria um banco de dados?

---

## Exercício 3

Complete a tabela.

| Campo | Tipo |
|--------|------|
| Nome | |
| Idade | |
| Salário | |
| Data de Nascimento | |
| Observação | |
| Ativo | |

---

## Exercício 4

Pesquise outros três tipos de dados existentes no PostgreSQL.

---

## Exercício 5

Crie um banco chamado:

```text
biblioteca
```

Utilizando:

* Interface gráfica.

Depois:

* SQL.

---

# 🚀 Desafio

Imagine que você vai desenvolver um sistema para uma clínica veterinária.

Escolha o tipo de dado mais adequado para cada campo.

| Campo | Tipo |
|---------|----------------|
| id | |
| nome do animal | |
| espécie | |
| peso | |
| data de nascimento | |
| observações | |
| castrado | |

---

# 📚 Resumo

Nesta aula aprendemos:

✅ Diferença entre PostgreSQL e PGAdmin.

✅ Como criar um banco de dados.

✅ Estrutura de um servidor PostgreSQL.

✅ O que é um Schema.

✅ Os principais tipos de dados.

Agora estamos preparados para criar nossas primeiras tabelas.

---
# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 2B • Criando Tabelas e Entendendo a Chave Primária

> **Curso:** Banco de Dados com PostgreSQL
>
> **Professor:** Éder Silva
>
> **Nível:** Iniciante
>
> **Ferramentas utilizadas:**
>
> * PostgreSQL
> * PGAdmin 4

---

# 📖 Índice

* Revisão da Aula Anterior
* O que é uma tabela?
* Estrutura de uma tabela
* CREATE TABLE
* Campos
* Tipos de dados
* PRIMARY KEY
* NOT NULL
* DEFAULT
* Criando tabelas na prática
* Exercícios
* Desafio

---

# 👋 Bem-vindo à Parte 2B

Na aula anterior criamos nosso primeiro banco de dados e conhecemos os principais tipos de dados utilizados pelo PostgreSQL.

Agora vamos começar a construir nossas primeiras tabelas.

É neste momento que o banco de dados começa realmente a ganhar forma.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Criar tabelas utilizando SQL.
* Definir corretamente os campos.
* Escolher tipos de dados.
* Criar chaves primárias.
* Utilizar NOT NULL.
* Utilizar DEFAULT.
* Organizar melhor a estrutura do banco.

---

# 📌 Revisando

Até agora temos esta estrutura:

```text
Servidor

↓

Banco Escola

↓

Schema Public
```

Agora iremos adicionar:

```text
Servidor

↓

Banco Escola

↓

Schema Public

↓

Tabela Aluno
```

---

# 📚 O que é uma Tabela?

Uma tabela é o local onde armazenamos informações de um mesmo assunto.

Por exemplo.

Uma escola pode possuir:

* alunos;
* professores;
* cursos;
* disciplinas.

Cada um desses assuntos será representado por uma tabela.

---

# 🎓 Exemplo

Tabela:

```text
Aluno
```

Ela poderá armazenar:

| ID | Nome | Idade |
|----|----------------|------|
|1|Carlos|20|
|2|Fernanda|19|
|3|Lucas|22|

Observe que:

Cada linha representa um aluno.

Cada coluna representa uma informação sobre esse aluno.

---

# 💡 Linha ou Registro?

Esses dois nomes significam praticamente a mesma coisa.

```text
ID  Nome     Idade

1   Carlos   20
```

Toda essa linha é chamada de:

✅ Registro

ou

✅ Linha

---

# 💡 Coluna ou Campo?

Cada informação possui um nome.

```text
ID

Nome

Idade
```

Cada uma dessas colunas é chamada de:

Campo

ou

Atributo

---

# Analogia

Imagine uma planilha do Excel.

As colunas são os campos.

As linhas são os registros.

Quem já trabalhou com Excel normalmente aprende SQL com bastante facilidade.

---

# Primeiro Comando

A criação de tabelas utiliza o comando:

```sql
CREATE TABLE
```

Sua estrutura básica é:

```sql
CREATE TABLE nome_da_tabela(

campo tipo,

campo tipo,

campo tipo

);
```

---

# Criando nossa primeira tabela

Vamos criar uma tabela para armazenar alunos.

```sql
CREATE TABLE aluno(

id SERIAL,

nome VARCHAR(100),

idade INTEGER

);
```

Agora já temos uma tabela.

---

# O que significa cada linha?

```sql
CREATE TABLE aluno(
```

Cria uma tabela chamada aluno.

---

```sql
id SERIAL,
```

Cria um campo chamado id.

O PostgreSQL preencherá esse valor automaticamente.

---

```sql
nome VARCHAR(100),
```

Campo destinado ao nome do aluno.

Aceita até 100 caracteres.

---

```sql
idade INTEGER
```

Campo destinado à idade.

Aceita apenas números inteiros.

---

```sql
);
```

Finaliza a criação da tabela.

---

# Executando o comando

Abra o:

**Query Tool**

Cole o código.

Clique em:

▶ Execute

Se tudo estiver correto aparecerá:

```text
Query returned successfully.
```

---

# Atualizando o PGAdmin

Depois da criação da tabela.

Clique com o botão direito em:

```text
Tables
```

Depois:

```text
Refresh
```

A tabela aparecerá na lista.

---

# Visualizando a estrutura

```text
Aluno

ID

Nome

Idade
```

Neste momento ainda não existem registros.

Criamos apenas a estrutura.

---

# O Problema

Imagine esta situação.

```text
Nome

Carlos

Carlos

Carlos
```

Qual deles é qual?

Como saber?

Precisamos de um identificador único.

---

# Chave Primária

A chave primária é o campo responsável por identificar cada registro.

Ela nunca poderá repetir.

---

# Exemplo

```text
ID

1

2

3

4

5
```

Nunca existirão dois registros com o mesmo ID.

---

# Atualizando nossa tabela

Agora vamos criar corretamente.

```sql
CREATE TABLE aluno(

id SERIAL PRIMARY KEY,

nome VARCHAR(100),

idade INTEGER

);
```

Agora o campo id tornou-se nossa chave primária.

---

# O que significa PRIMARY KEY?

PRIMARY

↓

Principal

KEY

↓

Chave

Ela é a principal identificação de cada registro.

---

# Regras da Chave Primária

Uma chave primária:

✅ Nunca se repete.

✅ Nunca pode ser nula.

✅ Identifica exclusivamente um registro.

---

# Exemplo

| ID | Nome |
|----|----------------|
|1|Carlos|
|2|Carlos|
|3|Carlos|

Os nomes podem repetir.

O ID nunca.

---

# Curiosidade

Quase todos os sistemas do mundo utilizam uma chave primária.

Mesmo que você nunca a veja.

Ela existe.

---

# SERIAL + PRIMARY KEY

É a combinação mais utilizada.

```sql
id SERIAL PRIMARY KEY
```

O PostgreSQL:

* cria o campo;
* gera números automaticamente;
* impede repetições.

---

# O que é NOT NULL?

Alguns campos são obrigatórios.

Exemplo.

Um aluno precisa possuir nome.

Não faz sentido cadastrar um aluno sem nome.

Para isso usamos:

```sql
NOT NULL
```

---

# Exemplo

```sql
CREATE TABLE aluno(

id SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

idade INTEGER

);
```

Agora o nome tornou-se obrigatório.

---

# O que acontece?

Tentando inserir:

```text
Nome vazio
```

O PostgreSQL exibirá um erro.

Isso evita informações incompletas.

---

# O que é DEFAULT?

Às vezes queremos que um campo receba automaticamente um valor.

Utilizamos:

```sql
DEFAULT
```

---

# Exemplo

```sql
ativo BOOLEAN DEFAULT TRUE
```

Sempre que um novo registro for criado.

O campo ativo receberá automaticamente:

```text
TRUE
```

---

# Exemplo Completo

```sql
CREATE TABLE aluno(

id SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

idade INTEGER,

ativo BOOLEAN DEFAULT TRUE

);
```

Observe que nossa tabela já está muito mais completa.

---

# Exemplo com Pokémon

```sql
CREATE TABLE pokemon(

id SERIAL PRIMARY KEY,

nome VARCHAR(50) NOT NULL,

tipo VARCHAR(30),

nivel INTEGER DEFAULT 1

);
```

Todo novo Pokémon começará no nível 1.

---

# Exemplo com Harry Potter

```sql
CREATE TABLE casa(

id SERIAL PRIMARY KEY,

nome VARCHAR(50) NOT NULL

);
```

Tabela simples.

Muito comum em bancos relacionais.

---

# Exemplo com Minecraft

```sql
CREATE TABLE item(

id SERIAL PRIMARY KEY,

nome VARCHAR(80),

quantidade INTEGER DEFAULT 1

);
```

Todo novo item terá quantidade inicial igual a 1.

---

# Exemplo Loja

```sql
CREATE TABLE produto(

id SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

preco NUMERIC(10,2),

estoque INTEGER DEFAULT 0

);
```

Observe como a estrutura começa a se parecer com um sistema real.

---

# Organização

Uma boa tabela possui:

✔ Nome claro.

✔ Campos organizados.

✔ Tipos corretos.

✔ Chave primária.

✔ Campos obrigatórios quando necessário.

Isso facilita muito a manutenção do sistema.

---

# Dica

Evite nomes como:

```text
Tabela1

TabelaNova

Teste

Dados
```

Prefira nomes significativos.

```text
Aluno

Produto

Cliente

Funcionario

Pedido
```

---

# Exercícios

## Exercício 1

Crie uma tabela chamada:

```text
Professor
```

Campos:

* id
* nome
* salário

---

## Exercício 2

Crie uma tabela chamada:

```text
Curso
```

Campos:

* id
* nome
* duração

---

## Exercício 3

Crie uma tabela chamada:

```text
Livro
```

Campos:

* id
* título
* autor
* ano

---

## Exercício 4

Adicione:

```text
DEFAULT
```

em pelo menos um campo.

---

## Exercício 5

Adicione:

```text
NOT NULL
```

nos campos obrigatórios.

---

# 🚀 Desafio

Crie a estrutura de um sistema para uma clínica veterinária.

Tabela:

```text
Animal
```

Campos:

* id
* nome
* espécie
* raça
* peso
* nascimento
* ativo

Escolha corretamente o tipo de dado de cada campo.

Depois responda:

Quais campos deveriam possuir:

* PRIMARY KEY
* NOT NULL
* DEFAULT

Explique o motivo de cada escolha.

---

# 📌 Resumo

Nesta aula aprendemos:

✅ CREATE TABLE

✅ Estrutura de tabelas

✅ Campos

✅ Tipos de dados

✅ PRIMARY KEY

✅ SERIAL

✅ NOT NULL

✅ DEFAULT

Agora nosso banco já possui tabelas organizadas e prontas para receber informações.

---
# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 2C • Inserindo Dados e Realizando as Primeiras Consultas

> **Curso:** Banco de Dados com PostgreSQL
>
> **Professor:** Éder Silva
>
> **Nível:** Iniciante
>
> **Ferramentas utilizadas:**
>
> * PostgreSQL
> * PGAdmin 4

---

# 📖 Índice

* Revisão
* INSERT INTO
* VALUES
* Inserindo vários registros
* SELECT
* ORDER BY
* LIMIT
* Projeto Prático
* Exercícios
* Desafio Final

---

# 👋 Bem-vindo à Parte 2C

Nas aulas anteriores construímos nosso banco de dados e criamos nossas primeiras tabelas.

Agora chegou uma das partes mais interessantes do curso.

Vamos começar a cadastrar informações e aprender como consultá-las utilizando SQL.

É neste momento que o banco de dados realmente começa a ganhar vida.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Inserir registros.
* Consultar informações.
* Ordenar resultados.
* Limitar consultas.
* Entender como os dados ficam armazenados.
* Criar um pequeno banco funcional.

---

# 📌 Revisando

Até aqui criamos a tabela:

```sql
CREATE TABLE aluno(

id SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

idade INTEGER,

ativo BOOLEAN DEFAULT TRUE

);
```

Agora ela está vazia.

Precisamos colocar informações nela.

---

# 📥 O comando INSERT INTO

Para cadastrar registros utilizamos:

```sql
INSERT INTO
```

Sua estrutura é simples.

```sql
INSERT INTO nome_da_tabela

(campo1, campo2)

VALUES

(valor1, valor2);
```

---

# Primeiro Cadastro

Vamos inserir nosso primeiro aluno.

```sql
INSERT INTO aluno

(nome, idade)

VALUES

('Carlos',20);
```

Observe que não informamos o ID.

O PostgreSQL fará isso automaticamente porque utilizamos:

```sql
SERIAL
```

---

# O que aconteceu?

O PostgreSQL armazenou:

| ID | Nome | Idade |
|----|----------------|------|
|1|Carlos|20|

O ID foi criado automaticamente.

---

# Inserindo novos registros

Vamos adicionar mais alunos.

```sql
INSERT INTO aluno

(nome, idade)

VALUES

('Fernanda',19);
```

```sql
INSERT INTO aluno

(nome, idade)

VALUES

('Lucas',22);
```

```sql
INSERT INTO aluno

(nome, idade)

VALUES

('Mariana',18);
```

---

# Resultado

Nossa tabela agora possui:

| ID | Nome | Idade |
|----|----------------|------|
|1|Carlos|20|
|2|Fernanda|19|
|3|Lucas|22|
|4|Mariana|18|

---

# Inserindo vários registros de uma vez

Também podemos cadastrar vários registros utilizando um único comando.

```sql
INSERT INTO aluno

(nome, idade)

VALUES

('Ana',18),

('Pedro',21),

('João',23),

('Julia',20);
```

Muito mais rápido.

---

# Curiosidade

Em sistemas reais é comum inserir milhares de registros de uma única vez.

Importações de planilhas utilizam exatamente esse conceito.

---

# Como visualizar os dados?

Utilizamos o comando:

```sql
SELECT
```

Ele significa:

Selecionar.

---

# Primeiro SELECT

```sql
SELECT *

FROM aluno;
```

O símbolo:

```text
*
```

significa:

Todos os campos.

---

# Resultado

| ID | Nome | Idade | Ativo |
|----|----------------|------|--------|
|1|Carlos|20|true|
|2|Fernanda|19|true|
|3|Lucas|22|true|
|4|Mariana|18|true|

---

# Consultando apenas um campo

Nem sempre precisamos visualizar tudo.

Exemplo:

```sql
SELECT nome

FROM aluno;
```

Resultado:

```text
Carlos

Fernanda

Lucas

Mariana
```

---

# Dois campos

```sql
SELECT nome, idade

FROM aluno;
```

Resultado:

| Nome | Idade |
|--------|------|
|Carlos|20|
|Fernanda|19|
|Lucas|22|
|Mariana|18|

---

# ORDER BY

Às vezes queremos ordenar os registros.

Para isso utilizamos:

```sql
ORDER BY
```

---

# Ordem crescente

```sql
SELECT *

FROM aluno

ORDER BY nome;
```

Resultado:

Ana

Carlos

Fernanda

Julia

Lucas

Pedro

---

# Ordem decrescente

```sql
SELECT *

FROM aluno

ORDER BY nome DESC;
```

Agora a lista será exibida de Z para A.

---

# Ordenando pela idade

```sql
SELECT *

FROM aluno

ORDER BY idade;
```

Agora o PostgreSQL organizará do menor para o maior.

---

# LIMIT

Imagine uma tabela com milhares de registros.

Nem sempre queremos visualizar tudo.

Utilizamos:

```sql
LIMIT
```

---

# Exemplo

```sql
SELECT *

FROM aluno

LIMIT 5;
```

Apenas cinco registros serão exibidos.

---

# Outro exemplo

```sql
SELECT nome

FROM aluno

LIMIT 3;
```

Resultado:

Carlos

Fernanda

Lucas

---

# Exemplo com Pokémon

Tabela:

```text
Pokemon
```

Inserindo:

```sql
INSERT INTO pokemon

(nome,tipo,nivel)

VALUES

('Pikachu','Elétrico',12),

('Bulbasaur','Grama',10),

('Charmander','Fogo',8);
```

Consultando:

```sql
SELECT *

FROM pokemon;
```

---

# Exemplo com Harry Potter

Tabela:

```text
Casa
```

```sql
INSERT INTO casa

(nome)

VALUES

('Grifinória'),

('Sonserina'),

('Corvinal'),

('Lufa-Lufa');
```

Consulta:

```sql
SELECT *

FROM casa;
```

---

# Exemplo com Minecraft

```sql
INSERT INTO item

(nome, quantidade)

VALUES

('Espada de Ferro',1),

('Tocha',64),

('Picareta de Diamante',1);
```

Consulta:

```sql
SELECT *

FROM item;
```

---

# Exemplo Loja

Tabela Produto

```sql
INSERT INTO produto

(nome, preco, estoque)

VALUES

('Mouse Gamer',199.90,15),

('Teclado Mecânico',350.00,10),

('Monitor 24"',899.90,8);
```

Consulta:

```sql
SELECT *

FROM produto;
```

---

# Projeto Guiado

Agora vamos montar um pequeno sistema.

Tabela:

Aluno

Cadastre:

```text
Carlos

Fernanda

Lucas

Mariana

João

Pedro

Ana

Julia
```

Depois execute:

```sql
SELECT *

FROM aluno;
```

---

Agora execute:

```sql
SELECT nome

FROM aluno;
```

Depois:

```sql
SELECT nome, idade

FROM aluno;
```

Depois:

```sql
SELECT *

FROM aluno

ORDER BY nome;
```

Depois:

```sql
SELECT *

FROM aluno

ORDER BY idade;
```

Depois:

```sql
SELECT *

FROM aluno

LIMIT 5;
```

Observe como o resultado muda em cada consulta.

---

# Erros comuns

❌ Esquecer as aspas.

```sql
Carlos
```

Correto:

```sql
'Carlos'
```

---

❌ Esquecer ponto e vírgula.

```sql
;
```

---

❌ Informar quantidade diferente de campos.

Exemplo errado:

```sql
(nome,idade)

VALUES

('Carlos');
```

O número de valores deve ser igual ao número de campos.

---

# Dica

Sempre escreva seus comandos organizados.

Exemplo:

```sql
SELECT

nome,

idade

FROM aluno

ORDER BY nome;
```

Um código organizado facilita muito a leitura.

---

# Exercícios

## Exercício 1

Cadastre cinco professores.

---

## Exercício 2

Cadastre cinco cursos.

---

## Exercício 3

Cadastre cinco livros.

---

## Exercício 4

Faça consultas utilizando:

```sql
SELECT *
```

---

## Exercício 5

Faça consultas utilizando:

```sql
ORDER BY
```

---

## Exercício 6

Mostre apenas três registros utilizando:

```sql
LIMIT
```

---

# 🚀 Desafio Final

Crie um pequeno banco para uma loja de informática.

Tabela:

```text
Produto
```

Cadastre pelo menos:

* 10 produtos.

Depois execute:

```sql
SELECT *
```

Depois:

```sql
SELECT nome, preco
```

Depois:

```sql
ORDER BY preco;
```

Depois:

```sql
ORDER BY nome DESC;
```

Depois:

```sql
LIMIT 5;
```

Analise o resultado de cada consulta.

---

# 💡 Desafio Extra

Pesquise dois novos comandos SQL que ainda não estudamos.

Descubra:

* Para que servem.
* Como são utilizados.
* Escreva um exemplo simples de cada um.

---

# 📌 Resumo

Nesta aula aprendemos:

✅ INSERT INTO

✅ VALUES

✅ Inserção múltipla

✅ SELECT

✅ ORDER BY

✅ LIMIT

✅ Organização das consultas

Agora já conseguimos criar bancos, criar tabelas, inserir informações e realizar consultas simples.

Você já domina os primeiros passos necessários para começar a desenvolver sistemas utilizando PostgreSQL.

---

