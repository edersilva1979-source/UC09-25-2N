# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 1A • Introdução e História dos Bancos de Dados

> **Revisão:** Banco de Dados com PostgreSQL
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

* Introdução
* Objetivos da aula
* O que é um banco de dados?
* Onde os bancos de dados são utilizados?
* A história dos bancos de dados
* O nascimento do Modelo Relacional
* O surgimento da SQL
* Curiosidades
* Resumo
* Exercícios

---

# 🎯 Objetivos da Aula

Nesta primeira parte, vou revisar com você os conceitos fundamentais sobre bancos de dados.

Ao final desta aula você será capaz de:

* Entender o que é um banco de dados.
* Conhecer a história dos bancos de dados.
* Entender por que eles foram criados.
* Descobrir onde eles são utilizados.
* Conhecer a origem da linguagem SQL.

---

# 💬 Antes de Começarmos

Quero que você imagine uma situação.

Imagine uma escola com:

* 2.500 alunos
* 180 professores
* 75 funcionários
* milhares de notas
* centenas de turmas

Agora imagine guardar tudo isso em folhas de papel.

Seria praticamente impossível localizar rapidamente qualquer informação.

Foi exatamente para resolver esse problema que surgiram os bancos de dados.

---

# 📚 O que é um Banco de Dados?

Um **Banco de Dados** é um conjunto organizado de informações armazenadas de forma que possam ser consultadas rapidamente.

Essas informações podem ser:

* cadastradas;
* alteradas;
* removidas;
* pesquisadas.

Tudo acontece em poucos segundos.

---

## 🎯 Exemplo

Imagine uma biblioteca.

Ela possui milhares de livros.

Cada livro possui:

* título;
* autor;
* editora;
* categoria;
* código;
* ano.

Quando alguém procura um livro, o sistema encontra rapidamente sua localização.

O banco de dados funciona exatamente dessa maneira.

---

# 💡 Pense Assim

Imagine um enorme armário cheio de pastas.

Sem organização você levaria horas para encontrar um documento.

Com tudo organizado, basta pesquisar.

Um banco de dados faz exatamente isso.

---

# 🌎 Onde Utilizamos Bancos de Dados?

Você provavelmente utiliza dezenas deles todos os dias.

Alguns exemplos:

📱 WhatsApp

📸 Instagram

🎬 Netflix

🎵 Spotify

🏦 Aplicativos bancários

🏥 Hospitais

🏫 Escolas

🛒 Mercados

🚗 Uber

🍔 iFood

✈️ Companhias aéreas

🎮 Jogos online

Todos eles utilizam bancos de dados.

---

# 📌 Curiosidade

Sempre que você:

* faz login;
* envia uma mensagem;
* publica uma foto;
* realiza uma compra;
* assiste a um vídeo;
* cria uma playlist;

alguma informação está sendo gravada em um banco de dados.

---

# 🕰 História dos Bancos de Dados

Hoje tudo parece muito simples.

Mas nem sempre foi assim.

Vamos voltar algumas décadas.

---

# Década de 1960

Naquela época os computadores eram enormes.

Alguns ocupavam salas inteiras.

As informações eram armazenadas principalmente em:

* fitas magnéticas;
* cartões perfurados.

Não existiam tabelas.

Não existia SQL.

Tudo era muito mais complicado.

---

## Cartões Perfurados

Uma programação simples era armazenada em cartões semelhantes a estes:

```text
□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□

██ ███ ██ █ ███ ██ ██

██ ██ █ █████ ██ ██

□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□
```

Cada furo representava uma informação.

Se um cartão fosse perdido...

Parte do programa também era perdida.

---

> **Curiosidade**
>
> Programadores carregavam caixas com centenas de cartões perfurados.
>
> Se eles caíssem no chão...
>
> Era preciso reorganizar tudo novamente.

---

# Os Problemas da Época

As empresas enfrentavam diversos problemas.

❌ Dados duplicados.

❌ Muito desperdício de espaço.

❌ Consultas extremamente lentas.

❌ Atualizações difíceis.

❌ Muitos erros.

Era necessário encontrar uma solução melhor.

---

# A Grande Revolução

Em 1970 aconteceu uma das maiores mudanças da história da computação.

O pesquisador Edgar F. Codd apresentou um artigo chamado:

> **A Relational Model of Data for Large Shared Data Banks**

Nesse trabalho ele apresentou um conceito revolucionário.

O **Modelo Relacional**.

---

# O que mudou?

Antes:

```text
Arquivos separados

↓

Pouca organização

↓

Difícil encontrar informações
```

Depois:

```text
Tabelas

↓

Relacionamentos

↓

Consultas rápidas

↓

Maior segurança
```

Esse conceito continua sendo utilizado até hoje.

---

# 📖 O Modelo Relacional

A ideia era simples.

Organizar informações em tabelas.

Cada tabela representa uma entidade.

Por exemplo:

```text
Cliente

Produto

Funcionário

Pedido

Fornecedor
```

Depois essas tabelas podem se relacionar entre si.

Isso tornou os sistemas muito mais eficientes.

---

# Exemplo

Imagine uma escola.

Em vez de colocar tudo em uma única tabela enorme...

Criamos várias tabelas.

```text
Aluno

Professor

Curso

Turma

Disciplina
```

Cada uma guarda apenas as informações que realmente pertencem a ela.

---

# O Surgimento da SQL

Alguns anos depois surgiu uma linguagem capaz de conversar com praticamente qualquer banco de dados.

Essa linguagem recebeu o nome de:

# SQL

**Structured Query Language**

Ou simplesmente:

**Linguagem de Consulta Estruturada.**

Ela rapidamente tornou-se um padrão mundial.

---

# O que posso fazer com SQL?

Utilizando SQL conseguimos:

* criar bancos;
* criar tabelas;
* inserir informações;
* alterar registros;
* excluir registros;
* consultar dados;
* criar relacionamentos.

Tudo utilizando comandos relativamente simples.

---

# Curiosidade

Mesmo depois de mais de quarenta anos, a SQL continua sendo uma das linguagens mais utilizadas do mundo.

Milhões de sistemas utilizam SQL todos os dias.

---

# Grandes Bancos de Dados

Hoje existem diversos bancos relacionais.

Os mais conhecidos são:

| Banco | Gratuito |
| ------- | :------: |
| PostgreSQL | ✅ |
| MySQL | ✅ |
| MariaDB | ✅ |
| SQL Server | Parcial |
| Oracle Database | ❌ |

Todos possuem comandos muito parecidos.

Aprender PostgreSQL facilita aprender qualquer outro banco relacional.

---

# 🧠 Curiosidade

É muito comum um desenvolvedor conhecer vários bancos de dados.

Depois que você aprende SQL, mudar de PostgreSQL para MySQL ou SQL Server costuma ser muito mais fácil.

A lógica permanece praticamente a mesma.

---

# 💬 Analogia

Imagine uma cidade.

Uma cidade possui:

```text
Casas

↓

Moradores

↓

Documentos

↓

Informações
```

Um banco de dados funciona de forma semelhante.

```text
Servidor

↓

Banco de Dados

↓

Tabelas

↓

Registros

↓

Campos
```

Nas próximas aulas vamos construir toda essa estrutura passo a passo.

---

# 📝 Resumo

Nesta primeira parte aprendemos:

✅ O que é um banco de dados.

✅ Onde ele é utilizado.

✅ Como surgiram os primeiros bancos de dados.

✅ Os problemas enfrentados antes do Modelo Relacional.

✅ Quem criou o Modelo Relacional.

✅ Como surgiu a SQL.

---

# 💻 Exercícios

## Exercício 1

Explique com suas palavras:

> O que é um banco de dados?

---

## Exercício 2

Cite cinco sistemas que utilizam bancos de dados.

---

## Exercício 3

Quais eram os principais problemas antes do Modelo Relacional?

---

## Exercício 4

Quem foi Edgar F. Codd?

Qual foi sua principal contribuição para a computação?

---

## Exercício 5

Pesquise:

O que significa a sigla SQL?

---

## 🚀 Desafio

Escolha um aplicativo que você utiliza diariamente.

Faça uma lista de pelo menos dez informações que provavelmente estão armazenadas no banco de dados desse aplicativo.

Exemplo:

* Nome
* Email
* Senha
* Foto
* Telefone
* Histórico
* Localização
* Amigos
* Mensagens
* Preferências

---

# 📚 Próxima Aula

Na **Parte 1B** vou mostrar:

* Banco de Dados Relacional
* Banco de Dados Não Relacional
* Diferenças entre eles
* PostgreSQL
* PGAdmin 4
* Estrutura completa de um banco de dados
* Primeiros conceitos que utilizaremos durante todo o curso.

---

