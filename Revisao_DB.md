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



---

