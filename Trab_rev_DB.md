# 🏢 Trabalho Prático de Banco de Dados

# PostgreSQL + PGAdmin 4



---

# 🎯 Objetivo

Neste trabalho você colocará em prática todos os conhecimentos adquiridos durante as aulas.

Ao final da atividade você deverá ser capaz de:

✅ Criar um banco de dados.

✅ Criar tabelas.

✅ Definir corretamente os tipos de dados.

✅ Criar chaves primárias.

✅ Inserir registros.

✅ Realizar consultas utilizando os principais comandos SQL.

✅ Organizar um pequeno sistema semelhante aos encontrados em empresas reais.

---

# 📚 Cenário

Você foi contratado para desenvolver o banco de dados de uma empresa que comercializa diversos produtos.

O gerente deseja controlar:

👨‍💼 Funcionários

📦 Produtos

🛒 Pedidos

Seu trabalho será criar todo esse banco de dados utilizando **PostgreSQL**.

---

# 🛠 Etapa 1 • Criando o Banco de Dados

Crie um banco de dados chamado:

```sql
Empresa
```

---

# 🏗 Etapa 2 • Criando as Tabelas

Você deverá criar as seguintes tabelas.

## 👨‍💼 Funcionarios

Crie uma tabela contendo, no mínimo, os seguintes campos:

| Campo   | Tipo sugerido      |
| ------- | ------------------ |
| id      | SERIAL PRIMARY KEY |
| nome    | VARCHAR(100)       |
| cargo   | VARCHAR(80)        |
| salario | NUMERIC(10,2)      |
| idade   | INTEGER            |
| cidade  | VARCHAR(80)        |
| ativo   | BOOLEAN            |

---

## 📦 Produtos

Crie uma tabela contendo:

| Campo     | Tipo sugerido      |
| --------- | ------------------ |
| id        | SERIAL PRIMARY KEY |
| nome      | VARCHAR(100)       |
| categoria | VARCHAR(80)        |
| preco     | NUMERIC(10,2)      |
| estoque   | INTEGER            |

---

## 🛒 Pedidos

Crie uma tabela contendo:

| Campo       | Tipo sugerido      |
| ----------- | ------------------ |
| id          | SERIAL PRIMARY KEY |
| cliente     | VARCHAR(100)       |
| produto     | VARCHAR(100)       |
| quantidade  | INTEGER            |
| valor_total | NUMERIC(10,2)      |
| data_pedido | DATE               |

---

# 📝 Etapa 3 • Inserindo Dados

Cadastre no mínimo:

✅ **10 Funcionários**

✅ **10 Produtos**

✅ **10 Pedidos**

Os registros devem possuir informações diferentes entre si.

Evite repetir nomes, cidades e categorias.

---

# 🔍 Etapa 4 • Consultas SQL

Depois de cadastrar todos os registros, execute as consultas abaixo.

---

## 📄 Consulta 1

Mostrar todos os funcionários.

```sql
SELECT *
FROM funcionarios;
```

---

## 📄 Consulta 2

Mostrar todos os produtos.

---

## 📄 Consulta 3

Mostrar todos os pedidos.

---

## 📄 Consulta 4

Mostrar apenas os nomes dos funcionários.

---

## 📄 Consulta 5

Mostrar apenas:

* Nome
* Cargo

---

## 📄 Consulta 6

Funcionários com salário maior que R$ 3.000,00.

---

## 📄 Consulta 7

Funcionários com idade menor que 30 anos.

---

## 📄 Consulta 8

Funcionários ativos.

---

## 📄 Consulta 9

Funcionários inativos.

---

## 📄 Consulta 10

Produtos acima de R$ 500,00.

---

## 📄 Consulta 11

Produtos abaixo de R$ 100,00.

---

## 📄 Consulta 12

Produtos com estoque maior que 20 unidades.

---

## 📄 Consulta 13

Pedidos acima de R$ 500,00.

---

## 📄 Consulta 14

Pedidos entre R$ 200,00 e R$ 800,00.

---

## 📄 Consulta 15

Funcionários da cidade de Porto Alegre.

---

## 📄 Consulta 16

Funcionários das cidades:

* Porto Alegre
* Canoas

(utilizando **IN**)

---

## 📄 Consulta 17

Funcionários entre 20 e 40 anos.

(utilizando **BETWEEN**)

---

## 📄 Consulta 18

Produtos cujo nome começa com a letra **M**.

(utilizando **LIKE**)

---

## 📄 Consulta 19

Produtos cujo nome termina com a letra **A**.

(utilizando **LIKE**)

---

## 📄 Consulta 20

Produtos que contenham a palavra:

```text
Mouse
```

(utilizando **LIKE**)

---

## 📄 Consulta 21

Funcionários maiores de 25 anos **E** ativos.

(utilizando **AND**)

---

## 📄 Consulta 22

Funcionários da cidade de Canoas **OU** Novo Hamburgo.

(utilizando **OR**)

---

## 📄 Consulta 23

Funcionários que **NÃO** estão ativos.

(utilizando **NOT**)

---

## 📄 Consulta 24

Produtos em ordem crescente de preço.

(utilizando **ORDER BY**)

---

## 📄 Consulta 25

Produtos em ordem decrescente de preço.

---

## 📄 Consulta 26

Funcionários em ordem alfabética.

---

## 📄 Consulta 27

Mostrar apenas os cinco primeiros produtos.

(utilizando **LIMIT**)

---

## 📄 Consulta 28

Mostrar apenas os três primeiros funcionários.

---

## 📄 Consulta 29

Mostrar produtos das categorias:

* Informática
* Escritório

(utilizando **IN**)

---

## 📄 Consulta 30

Pedidos realizados entre duas datas.

(utilizando **BETWEEN**)

---

# ⭐ Desafio Extra

Crie **mais 10 consultas** diferentes das apresentadas acima.

Utilize sua criatividade.

Algumas sugestões:

* Produtos mais caros.
* Funcionários por cidade.
* Funcionários por cargo.
* Produtos por categoria.
* Pedidos por cliente.
* Produtos com estoque baixo.
* Produtos com estoque alto.
* Funcionários com salários entre determinados valores.
* Clientes cujo nome começa por determinada letra.
* Pedidos ordenados por data.

---

# 🏆 Desafio Master

Imagine que a empresa cresceu.

Agora ela deseja controlar também:

📂 Fornecedores

🚚 Entregas

🏬 Filiais

Crie essas três novas tabelas.

Cadastre pelo menos **5 registros** em cada uma.

Depois desenvolva consultas utilizando os mesmos operadores estudados em aula.

---

# 📦 O que deverá ser entregue?

O trabalho deverá conter:

✅ Banco de dados criado.

✅ Três tabelas criadas.

✅ Pelo menos 10 registros em cada tabela.

✅ Todas as consultas solicitadas funcionando.

✅ Código SQL organizado e identado.

---

# 💡 Boas Práticas

Durante o desenvolvimento:

✔ Utilize nomes claros para tabelas e campos.

✔ Organize o código.

✔ Escreva uma instrução SQL por vez durante os testes.

✔ Salve seu trabalho frequentemente.

✔ Teste cada comando antes de continuar.

✔ Comente seu código quando considerar necessário.

---

# 📋 Critérios de Avaliação

| Critério                    | Pontuação |
| --------------------------- | :-------: |
| Criação do banco            |    1,0    |
| Criação das tabelas         |    2,0    |
| Tipos de dados corretos     |    1,0    |
| Inserção dos registros      |    2,0    |
| Consultas obrigatórias      |    3,0    |
| Organização e boas práticas |    1,0    |

**Total: 10,0 pontos**

---

# 🚀 Missão Cumprida?

Antes de entregar, confira este checklist.

* [ ] Banco **Empresa** criado.
* [ ] Tabela **Funcionarios** criada.
* [ ] Tabela **Produtos** criada.
* [ ] Tabela **Pedidos** criada.
* [ ] 10 funcionários cadastrados.
* [ ] 10 produtos cadastrados.
* [ ] 10 pedidos cadastrados.
* [ ] Todas as consultas executadas com sucesso.
* [ ] Código revisado.
* [ ] Trabalho pronto para entrega.

---

# 🎉 Boa sorte!

Lembre-se: um bom desenvolvedor não é aquele que apenas faz o código funcionar.

Ele também organiza, documenta, testa e entende o motivo de cada comando que escreve.

**Bons estudos e divirta-se programando!** 🚀💻

