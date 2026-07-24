# Trabalho de Fixação

## Sistema de Cadastro e Consulta de Professores

## 1. Objetivo do trabalho

Neste trabalho, cada aluno deverá desenvolver uma aplicação gráfica em Java utilizando NetBeans, Java Swing, PostgreSQL e JDBC.

A aplicação deverá permitir o cadastro de professores em um banco de dados e também apresentar uma tela de consulta com uma tabela contendo todos os professores cadastrados.

O objetivo principal é praticar os conteúdos estudados sobre:

1. Conexão entre Java e PostgreSQL
2. Uso do driver JDBC
3. Criação de telas com JFrame Form
4. Uso de campos de texto
5. Uso de botões
6. Uso de JTable
7. Uso de PreparedStatement
8. Uso de ResultSet
9. Cadastro de dados no banco
10. Consulta de registros por ID
11. Organização de uma aplicação com mais de uma tela

## 2. Nome sugerido para o projeto

```text
CadastroProfessores
```

## 3. Banco de dados

O banco de dados deverá ser criado no PostgreSQL.

Nome do banco:

```text
escolaGrafica
```

Caso o banco já exista, ele poderá ser reutilizado.

## 4. Tabela professor

A tabela deverá ser criada com o seguinte comando:

```sql
CREATE TABLE professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    disciplina VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20)
);
```

## 5. Estrutura mínima do projeto

O projeto deverá possuir, no mínimo, as seguintes classes:

```text
Conexao.java

Professor.java

TelaCadastroProfessor.java

TelaConsultaProfessor.java
```

A organização em pacotes será opcional nesta etapa.

## 6. Classe Conexao

A classe `Conexao` deverá possuir um método responsável por abrir a conexão com o banco PostgreSQL.

Exemplo de assinatura:

```java
public static Connection conectar()
```

A classe deverá conter:

1. Endereço do banco
2. Porta do PostgreSQL
3. Nome do banco
4. Usuário
5. Senha
6. Tratamento de erro com try e catch
7. Retorno de um objeto do tipo Connection

A conexão deverá utilizar o banco:

```text
escola
```

## 7. Classe Professor

A classe `Professor` deverá representar os dados do professor e também possuir os métodos necessários para esta atividade.

A classe deverá possuir os atributos:

```text
id

nome

disciplina

email

telefone
```

Também deverá possuir:

1. Construtor vazio
2. Construtor completo
3. Métodos get
4. Métodos set
5. Método cadastrar
6. Método listar
7. Método localizarPorId

Os métodos alterar e excluir poderão ser criados, mas não precisam ser programados nesta etapa.

## 8. Tela de cadastro

A tela de cadastro deverá ser criada com JFrame Form.

Nome sugerido:

```text
TelaCadastroProfessor
```

A tela deverá possuir os seguintes campos:

```text
Nome

Disciplina

Email

Telefone
```

Os nomes sugeridos para os componentes são:

```text
txtNome

txtDisciplina

txtEmail

txtTelefone
```

## 9. Botões da tela de cadastro

### 9.1 Botão Cadastrar

Nome sugerido:

```text
btnCadastrar
```

Esse botão deverá:

1. Ler os dados digitados
2. Validar se os campos obrigatórios estão preenchidos
3. Criar um objeto da classe Professor
4. Executar o cadastro no PostgreSQL
5. Mostrar uma mensagem de sucesso ou erro
6. Limpar os campos após o cadastro

### 9.2 Botão Limpar Campos

Nome sugerido:

```text
btnLimpar
```

Esse botão deverá apagar o conteúdo dos campos Nome, Disciplina, Email e Telefone.

Depois de limpar, o cursor deverá voltar para o campo Nome.

### 9.3 Botão Consulta

Nome sugerido:

```text
btnConsulta
```

Esse botão deverá abrir a tela:

```text
TelaConsultaProfessor
```

### 9.4 Botão Sair

Nome sugerido:

```text
btnSair
```

Esse botão deverá fechar a tela de cadastro.

A aplicação poderá pedir confirmação antes de sair.

## 10. Organização visual sugerida para o cadastro

```text
CADASTRO DE PROFESSORES

Nome:        [____________________________]

Disciplina:  [____________________________]

Email:       [____________________________]

Telefone:    [____________________________]

[Cadastrar] [Limpar Campos] [Consulta] [Sair]
```

## 11. Tela de consulta

A segunda tela deverá ser criada com JFrame Form.

Nome sugerido:

```text
TelaConsultaProfessor
```

Essa tela deverá permitir a consulta de professores e exibir todos os registros em uma JTable.

## 12. Componentes da tela de consulta

A tela deverá possuir os seguintes campos:

```text
ID

Nome

Disciplina

Email

Telefone
```

Nomes sugeridos:

```text
txtId

txtNome

txtDisciplina

txtEmail

txtTelefone
```

Também deverá possuir uma JTable.

Nome sugerido:

```text
tabelaProfessores
```

## 13. Carregamento automático da tabela

Ao abrir a tela de consulta, todos os professores cadastrados deverão ser carregados automaticamente na JTable.

A tabela deverá possuir as colunas:

```text
ID

Nome

Disciplina

Email

Telefone
```

O carregamento deverá acontecer no construtor da tela, depois de:

```java
initComponents();
```

Exemplo de chamada:

```java
carregarTabela();
```

O método `carregarTabela()` deverá:

1. Criar um DefaultTableModel
2. Criar as colunas
3. Buscar todos os professores no banco
4. Percorrer os resultados
5. Adicionar cada professor em uma linha
6. Enviar o modelo para a JTable

## 14. Botões da tela de consulta

### 14.1 Botão Localizar por ID

Nome sugerido:

```text
btnLocalizar
```

Esse botão deverá:

1. Ler o ID digitado
2. Buscar o professor no banco
3. Preencher os campos com os dados encontrados
4. Mostrar uma mensagem caso o ID não exista
5. Validar se o ID informado é numérico

### 14.2 Botão Alterar

Nome sugerido:

```text
btnAlterar
```

O botão deverá estar presente na tela.

Nesta etapa, ele ainda não precisa alterar os dados no banco.

Ao clicar, poderá mostrar uma mensagem como:

```text
Função de alteração será desenvolvida na próxima etapa.
```

### 14.3 Botão Excluir

Nome sugerido:

```text
btnExcluir
```

O botão deverá estar presente na tela.

Nesta etapa, ele ainda não precisa excluir dados do banco.

Ao clicar, poderá mostrar uma mensagem como:

```text
Função de exclusão será desenvolvida na próxima etapa.
```

### 14.4 Botão Limpar Campos

Nome sugerido:

```text
btnLimpar
```

Esse botão deverá limpar ID, Nome, Disciplina, Email e Telefone.

Depois de limpar, o cursor deverá voltar ao campo ID.

### 14.5 Botão Fechar

Nome sugerido:

```text
btnFechar
```

Esse botão deverá fechar a tela de consulta e retornar para a tela de cadastro.

## 15. Organização visual sugerida para a consulta

```text
CONSULTA DE PROFESSORES

ID:           [__________] [Localizar]

Nome:         [____________________________]

Disciplina:   [____________________________]

Email:        [____________________________]

Telefone:     [____________________________]

[Alterar] [Excluir] [Limpar Campos] [Fechar]

____________________________________________________________

| ID | Nome | Disciplina | Email | Telefone |
```

## 16. Regras obrigatórias

O trabalho deverá atender aos seguintes requisitos:

1. Usar Java
2. Usar NetBeans
3. Usar Java Swing
4. Usar JFrame Form
5. Usar PostgreSQL
6. Usar JDBC
7. Usar PreparedStatement
8. Usar ResultSet
9. Usar JTable
10. Possuir duas telas
11. Possuir conexão com o banco
12. Cadastrar professores
13. Localizar professor por ID
14. Listar todos os professores na JTable
15. Abrir a consulta pelo botão da tela de cadastro
16. Validar campos vazios
17. Mostrar mensagens com JOptionPane
18. Fechar corretamente as conexões
19. Manter o código organizado
20. Não programar ainda as funções de alteração e exclusão

## 17. Resultado esperado

Ao executar a aplicação, o sistema deverá permitir:

1. Abrir a tela de cadastro
2. Digitar os dados de um professor
3. Cadastrar o professor no PostgreSQL
4. Limpar os campos
5. Abrir a tela de consulta
6. Mostrar automaticamente todos os professores na JTable
7. Localizar um professor por ID
8. Limpar os campos da consulta
9. Fechar a tela de consulta
10. Fechar a aplicação

## 18. Testes obrigatórios

### Teste 1

Cadastrar um professor com todos os campos preenchidos.

### Teste 2

Tentar cadastrar com algum campo obrigatório vazio.

### Teste 3

Tentar cadastrar um email repetido.

### Teste 4

Abrir a tela de consulta.

### Teste 5

Confirmar se todos os professores aparecem na JTable.

### Teste 6

Localizar um professor com ID existente.

### Teste 7

Buscar um ID inexistente.

### Teste 8

Digitar uma letra no campo ID e verificar a validação.

### Teste 9

Usar o botão Limpar Campos.

### Teste 10

Usar os botões Fechar e Sair.

## 19. Entrega

O trabalho deverá ser entregue com:

1. Projeto completo do NetBeans
2. Script SQL do banco
3. Arquivos Java
4. Imagem da tela de cadastro
5. Imagem da tela de consulta
6. Imagem da tabela professor no PostgreSQL
7. Arquivo README.md com uma breve descrição do projeto

## 20. Critérios de avaliação

| Critério | Pontuação |
|---|---:|
| Conexão com o PostgreSQL | 1,0 |
| Criação correta da tabela | 1,0 |
| Tela de cadastro | 1,5 |
| Cadastro funcionando | 1,5 |
| Tela de consulta | 1,5 |
| JTable carregando todos os professores | 1,5 |
| Localização por ID | 1,0 |
| Organização e validações | 0,5 |
| Entrega completa | 0,5 |
| Total | 10,0 |

## 21. Checklist final

Antes de entregar, verifique:

1. O PostgreSQL está funcionando
2. O banco escola existe
3. A tabela professor existe
4. O driver JDBC foi adicionado
5. A classe Conexao está funcionando
6. A tela de cadastro abre corretamente
7. O cadastro grava no banco
8. O botão Limpar Campos funciona
9. O botão Consulta abre a nova tela
10. A JTable carrega automaticamente
11. O botão Localizar encontra o professor
12. O sistema trata ID inválido
13. O botão Limpar funciona na consulta
14. O botão Fechar funciona
15. Os botões Alterar e Excluir estão visíveis
16. Alterar e Excluir ainda não modificam o banco
17. O código está organizado
18. O projeto foi testado antes da entrega

## 22. Desafio opcional

Como atividade extra, o aluno poderá permitir que, ao clicar em uma linha da JTable, os dados do professor sejam enviados automaticamente para os campos da tela.

Nesta etapa, os dados serão apenas exibidos.

A alteração e a exclusão serão programadas em uma próxima atividade.
