# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 3A • Filtrando Dados com WHERE

> **Curso:** Banco de Dados com PostgreSQL


---

# 📖 Índice

* Revisão
* O comando WHERE
* Operadores de comparação
* Igual (=)
* Diferente (<>)
* Maior (>)
* Menor (<)
* Maior ou igual (>=)
* Menor ou igual (<=)
* Exemplos práticos
* Exercícios
* Desafio

---

# 👋 Bem-vindo à Parte 3A

Até aqui aprendemos a:

✅ Criar bancos de dados.

✅ Criar tabelas.

✅ Inserir registros.

✅ Consultar informações utilizando o comando **SELECT**.

Agora vamos aprender algo extremamente importante.

## Como localizar apenas os registros que realmente queremos.

É exatamente para isso que utilizamos o comando **WHERE**.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Utilizar o comando **WHERE**.
* Filtrar registros específicos.
* Comparar números e textos.
* Utilizar operadores relacionais.
* Escrever consultas muito mais eficientes.

---

# 🤔 Por que usar WHERE?

Imagine uma tabela com **500 mil clientes**.

Você realmente quer visualizar todos eles?

Provavelmente não.

Na maioria das vezes queremos localizar apenas alguns registros.

Por exemplo:

* Apenas clientes de Porto Alegre.
* Apenas alunos maiores de 18 anos.
* Apenas produtos acima de R$ 500,00.
* Apenas funcionários ativos.

É justamente isso que o **WHERE** faz.

---

# 📚 Sintaxe

A estrutura é muito simples.

```sql
SELECT *

FROM tabela

WHERE condição;
```

Primeiro escolhemos a tabela.

Depois informamos a condição.

---

# Exemplo

Tabela:

Aluno

| ID | Nome | Idade |
|----|------------|------|
|1|Carlos|20|
|2|Fernanda|18|
|3|Lucas|22|
|4|Ana|17|

Agora imagine que queremos visualizar apenas:

Carlos.

---

## Consulta

```sql
SELECT *

FROM aluno

WHERE nome = 'Carlos';
```

Resultado:

| ID | Nome | Idade |
|----|------------|------|
|1|Carlos|20|

---

# O operador =

O sinal de igualdade significa:

"é igual a"

Exemplo:

```sql
WHERE nome = 'Carlos'
```

Ou

```sql
WHERE idade = 20
```

Muito utilizado para localizar registros específicos.

---

# Exemplo

Tabela Produto

| Produto | Preço |
|-----------|---------|
|Mouse|120|
|Teclado|350|
|Monitor|950|

Consulta:

```sql
SELECT *

FROM produto

WHERE preco = 350;
```

Resultado:

Teclado.

---

# Operador >

Maior que.

Exemplo:

```sql
WHERE idade > 18
```

Resultado:

Todos os alunos maiores que 18 anos.

---

## Exemplo

Tabela

| Nome | Idade |
|---------|------|
|Ana|17|
|Carlos|20|
|Lucas|22|

Consulta:

```sql
SELECT *

FROM aluno

WHERE idade > 18;
```

Resultado:

Carlos

Lucas

---

# Operador <

Menor que.

```sql
WHERE idade < 18
```

Resultado:

Ana.

---

# Operador >=

Maior ou igual.

Exemplo:

```sql
WHERE idade >= 18
```

Resultado:

18

19

20

21

22...

---

# Operador <=

Menor ou igual.

```sql
WHERE idade <=18
```

Resultado:

17

18

---

# Operador <>

Significa:

Diferente.

---

## Exemplo

```sql
SELECT *

FROM aluno

WHERE nome <> 'Carlos';
```

Resultado:

Todos os alunos, exceto Carlos.

---

# Tabela Resumo

| Operador | Significado |
|-----------|-------------|
| = | Igual |
| > | Maior |
| < | Menor |
| >= | Maior ou igual |
| <= | Menor ou igual |
| <> | Diferente |

---

# Exemplo Prático

Tabela Produto

| Produto | Valor |
|-----------|-------|
|Mouse|120|
|Teclado|350|
|Monitor|950|
|Notebook|4200|

Consulta:

```sql
SELECT *

FROM produto

WHERE valor > 500;
```

Resultado:

Monitor

Notebook

---

# Outro Exemplo

Tabela Funcionário

| Nome | Salário |
|---------|----------|
|Carlos|2500|
|Lucas|4500|
|Marina|7000|

Consulta:

```sql
SELECT *

FROM funcionario

WHERE salario >=4500;
```

Resultado:

Lucas

Marina

---

# Exemplo com Datas

Também podemos comparar datas.

```sql
SELECT *

FROM aluno

WHERE nascimento > '2005-01-01';
```

Muito utilizado em sistemas reais.

---

# Comparando Valores Booleanos

Tabela

```text
Aluno
```

Campo:

```text
Ativo
```

Consulta:

```sql
SELECT *

FROM aluno

WHERE ativo = TRUE;
```

Resultado:

Somente alunos ativos.

---

# Exemplo com Pokémon

Tabela:

Pokemon

| Nome | Nível |
|---------|------|
|Pikachu|15|
|Charmander|9|
|Bulbasaur|12|

Consulta:

```sql
SELECT *

FROM pokemon

WHERE nivel >=12;
```

Resultado:

Pikachu

Bulbasaur

---

# Exemplo Harry Potter

Tabela:

Aluno

| Nome | Casa |
|---------|-------------|
|Harry|Grifinória|
|Hermione|Grifinória|
|Draco|Sonserina|

Consulta:

```sql
SELECT *

FROM aluno

WHERE casa='Grifinória';
```

Resultado:

Harry

Hermione

---

# Exemplo Minecraft

Tabela:

Item

| Nome | Quantidade |
|---------|------------|
|Tocha|64|
|Espada|1|
|Picareta|2|

Consulta:

```sql
SELECT *

FROM item

WHERE quantidade >10;
```

Resultado:

Tocha.

---

# Fluxo Mental

Sempre pense assim.

```text
Tabela

↓

Quais registros desejo?

↓

Qual condição?

↓

WHERE
```

---

# Erros comuns

## Esquecer as aspas

Errado

```sql
WHERE nome = Carlos
```

Correto

```sql
WHERE nome = 'Carlos'
```

---

## Comparar texto com número

Errado

```sql
WHERE idade = '20'
```

Embora alguns bancos façam conversões automáticas, o ideal é manter a consistência dos tipos.

Correto

```sql
WHERE idade = 20
```

---

## Escrever o nome errado do campo

```sql
nomes
```

Quando o campo correto é:

```sql
nome
```

O PostgreSQL exibirá uma mensagem de erro.

---

# 💡 Dica

Escreva cada comando organizado.

Exemplo:

```sql
SELECT

nome,

idade

FROM aluno

WHERE idade >=18;
```

Além de facilitar a leitura, torna a manutenção do código muito mais simples.

---

# Projeto Prático

Utilizando a tabela:

Aluno

Cadastre:

* Carlos
* Fernanda
* Lucas
* Mariana
* Pedro
* Ana
* Júlia
* Ricardo

Depois execute:

```sql
SELECT *

FROM aluno

WHERE idade >=18;
```

---

Agora execute:

```sql
SELECT *

FROM aluno

WHERE idade <18;
```

---

Depois:

```sql
SELECT *

FROM aluno

WHERE nome='Carlos';
```

---

Depois:

```sql
SELECT *

FROM aluno

WHERE nome<>'Carlos';
```

Observe como apenas a condição muda.

---

# Exercícios

## Exercício 1

Mostre apenas alunos maiores de 20 anos.

---

## Exercício 2

Mostre apenas produtos com preço acima de R$ 500,00.

---

## Exercício 3

Mostre apenas funcionários com salário inferior a R$ 3.000,00.

---

## Exercício 4

Mostre apenas clientes ativos.

---

## Exercício 5

Mostre todos os produtos diferentes de "Mouse".

---

# 🚀 Desafio

Crie uma tabela chamada **Veículo**.

Campos:

* id
* modelo
* marca
* ano
* valor

Cadastre pelo menos 10 veículos.

Depois faça consultas utilizando:

* =
* >
* <
* >=
* <=
* <>

---

# 📌 Resumo

Nesta aula aprendemos:

✅ WHERE

✅ Igual

✅ Diferente

✅ Maior

✅ Menor

✅ Maior ou igual

✅ Menor ou igual

Agora já conseguimos localizar exatamente os registros que desejamos.

Esse é um dos comandos mais utilizados em SQL e será a base para praticamente todas as consultas que desenvolveremos daqui para frente.

---

# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 3B • Operadores Lógicos: AND, OR e NOT

---

# 📖 Índice

* Revisão da aula anterior
* O que são operadores lógicos?
* Operador AND
* Operador OR
* Operador NOT
* Ordem de execução
* Combinação de condições
* Boas práticas
* Projeto prático
* Exercícios
* Desafio

---

# 👋 Bem-vindo à Parte 3B

Na aula anterior aprendemos a utilizar o comando **WHERE** para localizar registros específicos.

Agora vamos dar um passo muito importante.

Imagine que você deseja encontrar:

* Alunos maiores de 18 anos **e** ativos.
* Produtos com preço acima de R$ 500,00 **e** estoque maior que zero.
* Funcionários do setor Financeiro **ou** RH.

Perceba que agora temos **duas ou mais condições**.

É exatamente para isso que utilizamos os operadores lógicos.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Combinar várias condições.
* Utilizar **AND**.
* Utilizar **OR**.
* Utilizar **NOT**.
* Escrever consultas mais inteligentes.
* Compreender a ordem de execução das condições.

---

# 🤔 O que são Operadores Lógicos?

São palavras que unem duas ou mais condições.

Assim como na Matemática utilizamos:

* +
* −
* ×
* ÷

Na SQL utilizamos:

* AND
* OR
* NOT

Eles ajudam o banco de dados a entender exatamente o que queremos pesquisar.

---

# Imagine esta situação

Tabela:

Aluno

| Nome | Idade | Ativo |
|-------|------:|:------:|
|Carlos|20|TRUE|
|Ana|17|TRUE|
|Lucas|22|FALSE|
|Mariana|19|TRUE|

Quero visualizar apenas:

Alunos maiores de 18 anos **e** ativos.

Uma única condição não é suficiente.

Precisamos combinar duas condições.

---

# Operador AND

O operador **AND** significa:

## E

As duas condições precisam ser verdadeiras.

---

## Sintaxe

```sql
SELECT *

FROM tabela

WHERE condição1

AND condição2;
```

---

# Exemplo

```sql
SELECT *

FROM aluno

WHERE idade >=18

AND ativo = TRUE;
```

Resultado:

| Nome |
|-------|
|Carlos|
|Mariana|

Lucas ficou de fora porque não está ativo.

Ana ficou de fora porque é menor de idade.

---

# Como o AND funciona?

Imagine duas portas.

```text
Condição 1

↓

Verdadeiro

E

↓

Condição 2

↓

Verdadeiro

↓

Registro aparece
```

Se apenas uma condição for falsa...

O registro não será exibido.

---

# Outro Exemplo

Tabela Produto

| Produto | Preço | Estoque |
|----------|------:|---------:|
|Mouse|120|15|
|Notebook|4200|0|
|Monitor|950|8|

Consulta:

```sql
SELECT *

FROM produto

WHERE preco >500

AND estoque >0;
```

Resultado:

Monitor.

O Notebook não aparece porque o estoque é zero.

---

# Operador OR

O operador **OR** significa:

## OU

Basta que uma das condições seja verdadeira.

---

## Sintaxe

```sql
SELECT *

FROM tabela

WHERE condição1

OR condição2;
```

---

# Exemplo

```sql
SELECT *

FROM aluno

WHERE idade <18

OR ativo = FALSE;
```

Resultado:

Ana

Lucas

Ana atende à primeira condição.

Lucas atende à segunda.

---

# Como o OR funciona?

```text
Condição 1

↓

Verdadeiro

OU

↓

Condição 2

↓

Verdadeiro

↓

Registro aparece
```

Basta uma condição ser verdadeira.

---

# Exemplo Loja

```sql
SELECT *

FROM produto

WHERE preco >1000

OR estoque =0;
```

Resultado:

Notebook

Mesmo que apenas uma condição seja verdadeira, o registro será exibido.

---

# Operador NOT

O operador **NOT** significa:

## NÃO

Ele inverte uma condição.

---

# Exemplo

```sql
SELECT *

FROM aluno

WHERE NOT ativo = TRUE;
```

Resultado:

Todos os alunos inativos.

---

# Outro exemplo

```sql
SELECT *

FROM produto

WHERE NOT preco >500;
```

Resultado:

Produtos que custam até R$ 500,00.

---

# Tabela Resumo

| Operador | Significado |
|-----------|-------------|
| AND | E |
| OR | OU |
| NOT | NÃO |

---

# Combinando Operadores

Também podemos utilizar mais de um operador.

Exemplo:

```sql
SELECT *

FROM aluno

WHERE idade >=18

AND ativo = TRUE

OR nome='Carlos';
```

Mas atenção.

Nem sempre o resultado será o esperado.

---

# Ordem de Execução

Assim como na Matemática, existe uma ordem de prioridade.

O PostgreSQL executa primeiro as expressões entre parênteses.

---

# Exemplo

```sql
SELECT *

FROM aluno

WHERE

(idade >=18

AND ativo = TRUE)

OR nome='Ana';
```

Primeiro o banco resolve o que está entre parênteses.

Depois avalia o restante.

Essa prática torna a consulta muito mais clara.

---

# 💡 Boa Prática

Sempre utilize parênteses quando combinar muitas condições.

Além de facilitar a leitura, evita interpretações incorretas.

---

# Exemplo Hospital

Tabela Paciente

| Nome | Internado | Idade |
|-------|:---------:|------:|
|João|TRUE|70|
|Maria|TRUE|30|
|Carlos|FALSE|68|

Consulta:

```sql
SELECT *

FROM paciente

WHERE internado = TRUE

AND idade >=60;
```

Resultado:

João.

---

# Exemplo Escola

Tabela Aluno

```sql
SELECT *

FROM aluno

WHERE idade >=18

AND ativo = TRUE;
```

Resultado:

Somente alunos maiores de idade e ativos.

---

# Exemplo Pokémon

Tabela Pokemon

| Nome | Nível | Tipo |
|-------|------:|-------|
|Pikachu|15|Elétrico|
|Bulbasaur|10|Grama|
|Charmander|8|Fogo|

Consulta:

```sql
SELECT *

FROM pokemon

WHERE nivel >=10

AND tipo='Grama';
```

Resultado:

Bulbasaur.

---

# Exemplo Harry Potter

Tabela Aluno

```sql
SELECT *

FROM aluno

WHERE casa='Grifinória'

OR casa='Corvinal';
```

Resultado:

Todos os alunos pertencentes a uma dessas duas casas.

---

# Exemplo Minecraft

Tabela Item

```sql
SELECT *

FROM item

WHERE quantidade >10

AND nome='Tocha';
```

Resultado:

Apenas as tochas com quantidade superior a dez unidades.

---

# Projeto Prático

Utilizando a tabela Produto.

Cadastre:

* Mouse
* Monitor
* Notebook
* Impressora
* Webcam

Agora execute:

```sql
SELECT *

FROM produto

WHERE preco >500

AND estoque >0;
```

---

Depois:

```sql
SELECT *

FROM produto

WHERE preco <200

OR estoque =0;
```

---

Depois:

```sql
SELECT *

FROM produto

WHERE NOT estoque =0;
```

Analise cuidadosamente cada resultado.

---

# Erros Comuns

## Misturar condições sem organização

Evite escrever consultas muito longas em apenas uma linha.

Prefira:

```sql
SELECT *

FROM produto

WHERE preco >500

AND estoque >0;
```

---

## Esquecer os parênteses

Consultas complexas podem produzir resultados inesperados.

Sempre organize as condições.

---

## Utilizar AND quando deveria utilizar OR

Leia a frase em voz alta.

Exemplo:

Produtos acima de R$ 500,00 **E** com estoque.

Produtos acima de R$ 500,00 **OU** sem estoque.

A própria frase ajuda a escolher o operador correto.

---

# 💡 Dica

Antes de escrever a consulta, transforme o problema em uma frase.

Exemplo:

"Quero todos os clientes ativos e maiores de idade."

Depois transforme a frase em SQL.

---

# Exercícios

## Exercício 1

Mostre os alunos maiores de 18 anos e ativos.

---

## Exercício 2

Mostre produtos com preço superior a R$ 1.000,00 ou estoque igual a zero.

---

## Exercício 3

Mostre apenas funcionários do setor RH ou Financeiro.

---

## Exercício 4

Mostre clientes que **não** estão ativos.

---

## Exercício 5

Crie uma consulta utilizando AND e OR na mesma instrução.

---

# 🚀 Desafio

Crie uma tabela chamada **Veículo**.

Campos:

* modelo
* marca
* ano
* valor
* disponível

Cadastre pelo menos 10 veículos.

Depois faça consultas utilizando:

* AND
* OR
* NOT

Por exemplo:

* Veículos acima de R$ 80.000,00 e disponíveis.
* Veículos da marca Toyota ou Honda.
* Veículos que não estão disponíveis.

Explique por que cada consulta retornou aqueles resultados.

---

# 📌 Resumo

Nesta aula aprendemos:

✅ AND

✅ OR

✅ NOT

✅ Combinação de condições

✅ Ordem de execução

✅ Uso de parênteses

Agora conseguimos criar consultas muito mais específicas e úteis para sistemas reais.

---

# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 3C • Pesquisas Avançadas com LIKE, IN, BETWEEN e IS NULL

---

# 📖 Índice

* Revisão
* O operador LIKE
* Caracteres curingas
* %
* _
* IN
* BETWEEN
* IS NULL
* IS NOT NULL
* Projeto prático
* Exercícios
* Desafio Final

---

# 👋 Bem-vindo à Parte 3C

Até agora aprendemos a utilizar:

✅ WHERE

✅ Operadores relacionais

✅ AND

✅ OR

✅ NOT

Agora vamos conhecer alguns dos operadores mais utilizados pelos desenvolvedores no dia a dia.

Eles permitem fazer pesquisas inteligentes sem precisar conhecer exatamente o valor procurado.

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Pesquisar textos utilizando LIKE.
* Utilizar os curingas % e _.
* Pesquisar vários valores utilizando IN.
* Filtrar intervalos utilizando BETWEEN.
* Encontrar campos vazios utilizando IS NULL.

---

# 🤔 Quando utilizar essas consultas?

Imagine um sistema com milhares de clientes.

Você lembra apenas que o nome começa com:

"C"

Mas não lembra o restante.

Ou então deseja localizar:

Todos os alunos entre 18 e 25 anos.

Ou ainda:

Todos os produtos das categorias Notebook, Monitor e Mouse.

Essas situações acontecem diariamente em sistemas reais.

---

# 🔍 O operador LIKE

O operador **LIKE** é utilizado para pesquisar textos.

Ele procura padrões.

Sua estrutura é simples.

```sql
SELECT *

FROM tabela

WHERE campo LIKE 'texto';
```

---

# Exemplo

Tabela Cliente

| Nome |
|-------|
|Carlos|
|Carla|
|Camila|
|Pedro|

Consulta:

```sql
SELECT *

FROM cliente

WHERE nome LIKE 'Carlos';
```

Resultado:

Carlos.

Nesse caso o resultado é igual ao operador =.

O verdadeiro poder do LIKE aparece quando utilizamos curingas.

---

# O caractere %

O símbolo:

```text
%
```

Significa:

"Qualquer quantidade de caracteres."

É um dos operadores mais utilizados em SQL.

---

# Começa com...

```sql
SELECT *

FROM cliente

WHERE nome LIKE 'Car%';
```

Resultado:

Carlos

Carla

Carolina

Carine

Todo nome que começa com "Car".

---

# Termina com...

```sql
SELECT *

FROM cliente

WHERE nome LIKE '%son';
```

Resultado:

Jackson

Anderson

Emerson

Todos terminam com "son".

---

# Contém...

```sql
SELECT *

FROM cliente

WHERE nome LIKE '%ari%';
```

Resultado:

Mariana

Marina

Mário

Todos possuem "ari" em alguma posição.

---

# O caractere _

O sublinhado representa:

## Apenas um caractere.

---

# Exemplo

```sql
SELECT *

FROM cliente

WHERE nome LIKE '_ana';
```

Resultado:

Ana

Somente nomes com exatamente um caractere antes de "ana".

---

# Outro exemplo

```sql
SELECT *

FROM cliente

WHERE nome LIKE 'J___';
```

Resultado:

João

José

Joel

Todos possuem quatro letras e começam com J.

---

# Comparando

| Operador | Significado |
|-----------|-------------|
| % | Qualquer quantidade de caracteres |
| _ | Apenas um caractere |

---

# 💡 Dica

Sempre que você não souber exatamente o texto procurado, utilize LIKE.

É muito comum em sistemas de busca.

---

# O operador IN

Imagine que você deseja pesquisar:

Grifinória

ou

Sonserina

Você pode fazer assim:

```sql
WHERE casa='Grifinória'

OR casa='Sonserina'
```

Mas existe uma maneira muito melhor.

---

# Utilizando IN

```sql
SELECT *

FROM aluno

WHERE casa IN

('Grifinória','Sonserina');
```

Muito mais simples.

---

# Outro exemplo

```sql
SELECT *

FROM produto

WHERE categoria IN

('Notebook','Monitor','Mouse');
```

Resultado:

Todos os produtos dessas categorias.

---

# O operador BETWEEN

O operador **BETWEEN** significa:

Entre.

Muito utilizado para pesquisar intervalos.

---

# Exemplo

```sql
SELECT *

FROM aluno

WHERE idade BETWEEN 18 AND 25;
```

Resultado:

Todos os alunos entre 18 e 25 anos.

---

# Outro exemplo

```sql
SELECT *

FROM produto

WHERE preco BETWEEN 500 AND 1500;
```

Resultado:

Todos os produtos com preço dentro desse intervalo.

---

# BETWEEN com Datas

Também podemos pesquisar datas.

```sql
SELECT *

FROM pedido

WHERE data BETWEEN

'2026-01-01'

AND

'2026-12-31';
```

Muito utilizado em relatórios.

---

# O que é NULL?

NULL não significa:

Zero.

Nem texto vazio.

NULL significa:

Sem informação.

Ainda não foi preenchido.

---

# Exemplo

Tabela Funcionário

| Nome | Telefone |
|-------|-----------|
|Carlos|5199999999|
|Lucas|NULL|
|Ana|5198888888|

Lucas ainda não possui telefone cadastrado.

---

# IS NULL

```sql
SELECT *

FROM funcionario

WHERE telefone IS NULL;
```

Resultado:

Lucas.

---

# IS NOT NULL

Também podemos pesquisar o contrário.

```sql
SELECT *

FROM funcionario

WHERE telefone IS NOT NULL;
```

Resultado:

Todos os funcionários que possuem telefone.

---

# Resumo dos Operadores

| Operador | Utilização |
|-----------|------------|
| LIKE | Pesquisa texto |
| % | Vários caracteres |
| _ | Um caractere |
| IN | Lista de valores |
| BETWEEN | Intervalo |
| IS NULL | Sem informação |
| IS NOT NULL | Possui informação |

---

# Exemplo Pokémon

Tabela Pokemon

```sql
SELECT *

FROM pokemon

WHERE nome LIKE 'P%';
```

Resultado:

Pikachu

Pidgey

Psyduck

---

# Exemplo Harry Potter

```sql
SELECT *

FROM aluno

WHERE casa IN

('Corvinal','Lufa-Lufa');
```

Resultado:

Todos os alunos dessas casas.

---

# Exemplo Minecraft

```sql
SELECT *

FROM item

WHERE quantidade BETWEEN 10 AND 64;
```

Resultado:

Todos os itens com quantidade dentro desse intervalo.

---

# Exemplo Loja

```sql
SELECT *

FROM produto

WHERE nome LIKE '%Mouse%';
```

Resultado:

Mouse Gamer

Mouse Sem Fio

Mouse RGB

---

# Projeto Prático

Utilizando a tabela Produto.

Cadastre pelo menos:

* Mouse Gamer
* Mouse Office
* Notebook Dell
* Notebook Lenovo
* Monitor Samsung
* Monitor LG
* Webcam Logitech
* Impressora Epson

Agora execute.

---

## Produtos que começam com Mouse

```sql
SELECT *

FROM produto

WHERE nome LIKE 'Mouse%';
```

---

## Produtos que possuem Samsung

```sql
SELECT *

FROM produto

WHERE nome LIKE '%Samsung%';
```

---

## Produtos Notebook ou Monitor

```sql
SELECT *

FROM produto

WHERE categoria IN

('Notebook','Monitor');
```

---

## Produtos entre R$ 500 e R$ 2.000

```sql
SELECT *

FROM produto

WHERE preco BETWEEN

500

AND

2000;
```

---

## Produtos sem descrição

```sql
SELECT *

FROM produto

WHERE descricao IS NULL;
```

---

# Erros Comuns

## Esquecer %

Errado

```sql
LIKE 'Car'
```

Quando o objetivo era localizar todos os nomes iniciados por Car.

Correto

```sql
LIKE 'Car%'
```

---

## Utilizar = em vez de LIKE

```sql
WHERE nome='Car%'
```

Não funciona.

O correto é:

```sql
WHERE nome LIKE 'Car%'
```

---

## Esquecer IS

Errado

```sql
telefone = NULL
```

Correto

```sql
telefone IS NULL
```

---

# 💡 Boa Prática

Sempre escolha o operador que melhor representa sua necessidade.

Nome incompleto?

LIKE.

Lista de opções?

IN.

Intervalo?

BETWEEN.

Campos vazios?

IS NULL.

Isso torna suas consultas mais simples e mais rápidas.

---

# Exercícios

## Exercício 1

Mostre todos os clientes cujo nome começa com A.

---

## Exercício 2

Mostre todos os clientes cujo nome termina com "son".

---

## Exercício 3

Mostre produtos das categorias:

* Mouse
* Notebook
* Impressora

Utilizando IN.

---

## Exercício 4

Mostre produtos entre R$ 200,00 e R$ 1.000,00.

---

## Exercício 5

Mostre todos os funcionários sem telefone.

---

## Exercício 6

Mostre todos os funcionários que possuem telefone cadastrado.

---

# 🚀 Desafio Final

Crie uma tabela chamada **Filme**.

Campos:

* título
* gênero
* ano
* duração
* diretor

Cadastre pelo menos 15 filmes.

Depois faça consultas utilizando:

* LIKE
* %
* _
* IN
* BETWEEN
* IS NULL
* IS NOT NULL

Explique o resultado obtido em cada consulta.

---

# 📌 Resumo

Nesta aula aprendemos:

✅ LIKE

✅ %

✅ _

✅ IN

✅ BETWEEN

✅ IS NULL

✅ IS NOT NULL

Agora você domina praticamente todos os filtros básicos utilizados diariamente por desenvolvedores SQL.

---

# 📚 Revisão de SQL com PostgreSQL e PGAdmin 4
# Parte 3D • Projeto Prático Integrador

---

# 📖 Índice

* Introdução
* Objetivos
* Cenário do Projeto
* Criando o Banco
* Criando as Tabelas
* Inserindo Dados
* Desafios de Consultas
* Projeto Escola
* Projeto Loja
* Projeto Hospital
* Projeto Biblioteca
* Projeto Final
* Resumo

---

# 👋 Bem-vindo ao Projeto Integrador

Parabéns!

Você concluiu todo o conteúdo introdutório de SQL.

Agora chegou o momento de colocar tudo em prática.

Nesta aula construiremos um pequeno sistema completo utilizando todos os comandos estudados até aqui.

Durante o desenvolvimento você utilizará:

✅ CREATE DATABASE

✅ CREATE TABLE

✅ PRIMARY KEY

✅ SERIAL

✅ INSERT

✅ SELECT

✅ WHERE

✅ ORDER BY

✅ LIMIT

✅ AND

✅ OR

✅ NOT

✅ LIKE

✅ IN

✅ BETWEEN

✅ IS NULL

---

# 🎯 Objetivos

Ao final desta aula você será capaz de:

* Criar um banco de dados completo.
* Criar várias tabelas.
* Inserir registros.
* Executar consultas reais.
* Resolver desafios semelhantes aos encontrados em empresas.

---

# 📚 Cenário

Imagine que você foi contratado para desenvolver o banco de dados de uma escola.

O diretor deseja armazenar informações sobre:

* alunos;
* professores;
* cursos.

Vamos começar.

---

# Criando o Banco

```sql
CREATE DATABASE escola;
```

---

# Criando a Tabela Aluno

```sql
CREATE TABLE aluno(

id SERIAL PRIMARY KEY,

nome VARCHAR(100) NOT NULL,

idade INTEGER,

cidade VARCHAR(80),

ativo BOOLEAN DEFAULT TRUE

);
```

---

# Criando a Tabela Professor

```sql
CREATE TABLE professor(

id SERIAL PRIMARY KEY,

nome VARCHAR(100),

disciplina VARCHAR(80),

salario NUMERIC(10,2)

);
```

---

# Criando a Tabela Curso

```sql
CREATE TABLE curso(

id SERIAL PRIMARY KEY,

nome VARCHAR(100),

carga_horaria INTEGER

);
```

---

# Inserindo Alunos

```sql
INSERT INTO aluno

(nome,idade,cidade)

VALUES

('Carlos',20,'Porto Alegre'),

('Fernanda',19,'Novo Hamburgo'),

('Lucas',22,'São Leopoldo'),

('Mariana',18,'Canoas'),

('Pedro',25,'Gravataí'),

('Ana',17,'Porto Alegre'),

('Julia',21,'Sapucaia'),

('Ricardo',23,'Esteio');
```

---

# Inserindo Professores

```sql
INSERT INTO professor

(nome,disciplina,salario)

VALUES

('Roberto','Matemática',5200),

('Paula','Português',4800),

('Marcos','História',4500),

('Sandra','Biologia',6100);
```

---

# Inserindo Cursos

```sql
INSERT INTO curso

(nome,carga_horaria)

VALUES

('Informática',1200),

('Administração',1000),

('Enfermagem',1800),

('Contabilidade',1400);
```

---

# Primeira Consulta

```sql
SELECT *

FROM aluno;
```

---

# Apenas Nomes

```sql
SELECT nome

FROM aluno;
```

---

# Maiores de Idade

```sql
SELECT *

FROM aluno

WHERE idade>=18;
```

---

# Alunos de Porto Alegre

```sql
SELECT *

FROM aluno

WHERE cidade='Porto Alegre';
```

---

# Ordem Alfabética

```sql
SELECT *

FROM aluno

ORDER BY nome;
```

---

# Ordem Decrescente

```sql
SELECT *

FROM aluno

ORDER BY idade DESC;
```

---

# Apenas Cinco Registros

```sql
SELECT *

FROM aluno

LIMIT 5;
```

---

# Utilizando AND

```sql
SELECT *

FROM aluno

WHERE idade>=18

AND cidade='Porto Alegre';
```

---

# Utilizando OR

```sql
SELECT *

FROM aluno

WHERE cidade='Porto Alegre'

OR cidade='Canoas';
```

---

# Utilizando NOT

```sql
SELECT *

FROM aluno

WHERE NOT cidade='Porto Alegre';
```

---

# Utilizando LIKE

```sql
SELECT *

FROM aluno

WHERE nome LIKE 'C%';
```

---

# Utilizando IN

```sql
SELECT *

FROM aluno

WHERE cidade IN

('Porto Alegre','Canoas');
```

---

# Utilizando BETWEEN

```sql
SELECT *

FROM aluno

WHERE idade BETWEEN 18 AND 21;
```

---

# Projeto Loja

Agora imagine um sistema comercial.

Tabela:

Produto

```sql
CREATE TABLE produto(

id SERIAL PRIMARY KEY,

nome VARCHAR(100),

categoria VARCHAR(60),

preco NUMERIC(10,2),

estoque INTEGER

);
```

---

# Inserindo Produtos

```sql
INSERT INTO produto

(nome,categoria,preco,estoque)

VALUES

('Mouse Gamer','Periférico',180,20),

('Monitor LG','Monitor',1100,8),

('Notebook Dell','Notebook',4200,5),

('Webcam Logitech','Periférico',320,15),

('Teclado Mecânico','Periférico',450,10),

('SSD 1TB','Armazenamento',650,12);
```

---

# Consultas

Produtos acima de R$ 500,00.

```sql
SELECT *

FROM produto

WHERE preco>500;
```

---

Produtos entre R$ 200 e R$ 1000.

```sql
SELECT *

FROM produto

WHERE preco BETWEEN

200

AND

1000;
```

---

Produtos iniciados por M.

```sql
SELECT *

FROM produto

WHERE nome LIKE 'M%';
```

---

Produtos das categorias Notebook ou Monitor.

```sql
SELECT *

FROM produto

WHERE categoria IN

('Notebook','Monitor');
```

---

Produtos em ordem crescente.

```sql
SELECT *

FROM produto

ORDER BY preco;
```

---

# Projeto Hospital

Tabela:

Paciente

```sql
CREATE TABLE paciente(

id SERIAL PRIMARY KEY,

nome VARCHAR(100),

idade INTEGER,

setor VARCHAR(60),

internado BOOLEAN

);
```

---

Inserindo dados.

```sql
INSERT INTO paciente

(nome,idade,setor,internado)

VALUES

('João',65,'UTI',TRUE),

('Maria',40,'Clínica',TRUE),

('Carlos',72,'UTI',TRUE),

('Fernanda',30,'Emergência',FALSE),

('Ana',55,'Clínica',TRUE);
```

---

Consultas

Pacientes internados.

```sql
SELECT *

FROM paciente

WHERE internado=TRUE;
```

---

Pacientes acima de 60 anos.

```sql
SELECT *

FROM paciente

WHERE idade>60;
```

---

Pacientes da UTI.

```sql
SELECT *

FROM paciente

WHERE setor='UTI';
```

---

# Projeto Biblioteca

Tabela:

Livro

```sql
CREATE TABLE livro(

id SERIAL PRIMARY KEY,

titulo VARCHAR(100),

autor VARCHAR(100),

ano INTEGER

);
```

---

Inserindo livros.

```sql
INSERT INTO livro

(titulo,autor,ano)

VALUES

('Dom Casmurro','Machado de Assis',1899),

('O Hobbit','J.R.R. Tolkien',1937),

('1984','George Orwell',1949),

('O Pequeno Príncipe','Antoine de Saint Exupéry',1943),

('Capitães da Areia','Jorge Amado',1937);
```

---

Consultas

Livros publicados após 1940.

```sql
SELECT *

FROM livro

WHERE ano>1940;
```

---

Livros iniciados por O.

```sql
SELECT *

FROM livro

WHERE titulo LIKE 'O%';
```

---

Livros entre 1900 e 2000.

```sql
SELECT *

FROM livro

WHERE ano BETWEEN

1900

AND

2000;
```

---

# Desafio 1

Crie um banco para uma oficina mecânica.

Tabelas:

* Cliente
* Veículo
* Serviço

Cadastre pelo menos:

* 10 clientes
* 15 veículos
* 20 serviços

Depois faça consultas utilizando todos os operadores aprendidos.

---

# Desafio 2

Crie um banco para uma clínica veterinária.

Tabelas:

* Tutor
* Animal
* Consulta

Cadastre vários registros.

Depois responda:

* Animais maiores de 5 anos.
* Consultas entre janeiro e março.
* Tutores cujo nome começa com M.
* Animais das espécies cão ou gato.

---

# Desafio 3

Crie um banco para um cinema.

Tabelas:

* Filme
* Sala
* Sessão

Cadastre diversos filmes.

Depois faça consultas utilizando:

* ORDER BY
* LIKE
* IN
* BETWEEN
* LIMIT

---

# Desafio Final

Desenvolva sozinho um pequeno banco de dados para um tema de sua escolha.

Pode ser:

🏥 Hospital

🏫 Escola

🚗 Oficina

🎮 Loja de Games

📚 Biblioteca

🍕 Pizzaria

🏨 Hotel

✈️ Agência de Viagens

O projeto deverá conter:

* mínimo de 4 tabelas;
* pelo menos 40 registros;
* diversas consultas utilizando todos os comandos aprendidos até aqui.

---

# 💡 Boas Práticas

Sempre utilize:

✅ nomes claros;

✅ tabelas organizadas;

✅ tipos corretos;

✅ identação;

✅ letras minúsculas para comandos ou siga um padrão consistente;

✅ comentários quando necessário.

Um código organizado facilita muito a manutenção do sistema.

---

# 🧠 Curiosidade

Grandes empresas possuem bancos com milhões de registros.

Mesmo assim, os comandos utilizados pelos desenvolvedores continuam sendo praticamente os mesmos que você aprendeu neste capítulo.

A diferença está na complexidade das consultas e no volume de dados.

---

# 📌 Resumo Geral do Capítulo

Você aprendeu:

✅ Criar bancos.

✅ Criar tabelas.

✅ Tipos de dados.

✅ PRIMARY KEY.

✅ INSERT.

✅ SELECT.

✅ WHERE.

✅ ORDER BY.

✅ LIMIT.

✅ AND.

✅ OR.

✅ NOT.

✅ LIKE.

✅ IN.

✅ BETWEEN.

✅ IS NULL.

Agora você possui uma base sólida em SQL e já consegue construir pequenos sistemas utilizando PostgreSQL.

---


