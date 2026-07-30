# 📘 Capítulo 4
# Construindo um Sistema Completo de Cadastro e Consulta de Alunos
## Java Swing + PostgreSQL + JDBC

> 🎯 **Objetivo do Capítulo**
>
> Neste capítulo, eu vou construir com você um sistema completo utilizando **Java Desktop**, **Java Swing**, **JDBC** e **PostgreSQL**. Ao final, teremos uma aplicação capaz de cadastrar, consultar, localizar, alterar e excluir alunos utilizando uma interface gráfica profissional.

---

# 👨‍🏫 Bem-vindo!

Até aqui, nós aprendemos diversos conceitos importantes.

Já vimos como:

- ✅ Criar classes
- ✅ Criar objetos
- ✅ Utilizar métodos
- ✅ Trabalhar com encapsulamento
- ✅ Conectar o Java ao PostgreSQL utilizando JDBC
- ✅ Executar comandos SQL através do Java
- ✅ Inserir registros no banco de dados

Agora chegou o momento de juntar todo esse conhecimento em um único projeto.

A partir deste capítulo, eu vou deixar de trabalhar apenas com o console e começarei a desenvolver uma aplicação gráfica utilizando **Java Swing**.

Será um projeto muito parecido com aqueles encontrados em empresas, clínicas, escolas, lojas e diversos sistemas comerciais.

---

# 🚀 O que vamos construir?

Durante este capítulo, construiremos um sistema chamado:

# 🎓 Sistema Escola

Nosso sistema permitirá realizar o gerenciamento de alunos através de uma interface gráfica.

Ao final do capítulo, nossa aplicação será capaz de:

✅ Cadastrar alunos

✅ Consultar alunos

✅ Localizar um aluno pelo ID

✅ Alterar informações

✅ Excluir registros

✅ Visualizar todos os alunos em uma tabela

Tudo isso conectado diretamente ao PostgreSQL.

---

# 💻 Como ficará nossa aplicação?

Nosso sistema possuirá duas telas.

A primeira será responsável pelo cadastro.

```text
┌─────────────────────────────────────────────┐
│          CADASTRO DE ALUNOS                 │
├─────────────────────────────────────────────┤
│ Nome:      [__________________________]     │
│                                             │
│ Turma:     [__________________________]     │
│                                             │
│ Email:     [__________________________]     │
│                                             │
│                                             │
│ [Cadastrar] [Limpar] [Consulta] [Sair]      │
└─────────────────────────────────────────────┘
```

Já a segunda tela será utilizada para realizar consultas.

```text
┌──────────────────────────────────────────────────────────┐
│                 CONSULTA DE ALUNOS                       │
├──────────────────────────────────────────────────────────┤
│ ID: [_____] [Localizar]                                 │
│                                                          │
│ Nome:   [__________________________]                    │
│ Turma:  [__________________________]                    │
│ Email:  [__________________________]                    │
│                                                          │
│ [Editar] [Excluir] [Atualizar] [Limpar] [Fechar]        │
│                                                          │
│ ------------------------------------------------------   │
│ ID | Nome | Turma | Email                               │
│-------------------------------------------------------   │
│ 1  | Ana  | T01   | ana@email.com                       │
│ 2  | João | T02   | joao@email.com                      │
│ 3  | Maria| T03   | maria@email.com                     │
└──────────────────────────────────────────────────────────┘
```

Observe que a segunda tela possui uma **JTable**.

Essa tabela exibirá automaticamente todos os alunos cadastrados.

Essa é uma das funcionalidades mais utilizadas em sistemas Desktop.

---

# 🏢 Onde encontramos sistemas como este?

Talvez você esteja se perguntando:

> "Professor, eu realmente vou utilizar isso no mercado de trabalho?"

A resposta é:

**Sim!**

Grande parte dos sistemas corporativos utiliza exatamente essa lógica.

Veja alguns exemplos.

## 🏫 Escola

Cadastro de alunos

Cadastro de professores

Cadastro de turmas

Consulta de notas

Consulta de frequência

---

## 🏥 Hospital

Cadastro de pacientes

Cadastro de médicos

Consulta de exames

Agendamentos

Internações

---

## 🛒 Comércio

Cadastro de clientes

Cadastro de produtos

Cadastro de fornecedores

Controle de estoque

Vendas

---

## 🚗 Oficina

Cadastro de veículos

Cadastro de clientes

Ordens de serviço

Peças

Orçamentos

---

## 🏢 Empresas

Cadastro de funcionários

Departamentos

Folha de pagamento

Controle de acesso

Relatórios

---

Perceba que praticamente todos esses sistemas possuem algo em comum.

Primeiro existe uma tela para cadastrar informações.

Depois existe uma tela para consultar esses dados.

Nosso projeto seguirá exatamente essa mesma ideia.

---

# 🧠 O que eu vou aprender neste capítulo?

Ao concluir este capítulo, eu serei capaz de:

✅ Criar aplicações Desktop utilizando Java Swing.

✅ Construir telas utilizando JFrame Form.

✅ Trabalhar com vários botões.

✅ Utilizar JTextField.

✅ Utilizar JLabel.

✅ Utilizar JPanel.

✅ Trabalhar com JTable.

✅ Utilizar JScrollPane.

✅ Criar métodos reutilizáveis.

✅ Organizar melhor meu código.

✅ Integrar Java com PostgreSQL.

✅ Executar comandos INSERT.

✅ Executar comandos SELECT.

✅ Executar comandos UPDATE.

✅ Executar comandos DELETE.

✅ Trabalhar com PreparedStatement.

✅ Trabalhar com ResultSet.

✅ Atualizar informações em uma JTable.

---

# 🎯 Nosso objetivo

Ao final deste capítulo, eu quero que você consiga olhar para qualquer sistema Desktop simples e compreender como ele foi desenvolvido.

Mais do que copiar código, eu quero que você entenda **o motivo** de cada classe, cada método e cada botão existir.

Essa compreensão fará toda a diferença quando você começar a desenvolver seus próprios sistemas.

---

# 💡 Dica do Professor

> Não tenha pressa para terminar este capítulo.
>
> Em vez de copiar o código inteiro de uma vez, digite cada linha junto comigo.
>
> É durante a digitação que surgem dúvidas, erros e descobertas. Esses pequenos desafios fazem parte do aprendizado e ajudam a fixar o conteúdo.

---

# 📌 Curiosidade

Você perceberá que muitos sistemas comerciais desenvolvidos há mais de vinte anos ainda utilizam Java Swing.

Mesmo com o crescimento das aplicações Web, milhares de empresas continuam utilizando aplicações Desktop devido à sua estabilidade, desempenho e facilidade de manutenção.

Por isso, aprender Java Swing continua sendo uma habilidade muito valorizada em diversos ambientes corporativos.

---

# ✅ Conclusão da Parte 1A

Nesta primeira parte, conhecemos o projeto que iremos desenvolver e entendemos por que ele representa uma aplicação muito próxima da realidade do mercado.

Na próxima etapa, começaremos a detalhar o funcionamento do sistema, conheceremos todas as tecnologias utilizadas, veremos como as telas se comunicam entre si e entenderemos o fluxo completo da aplicação antes de escrever qualquer código.

# 📖 Parte 1B
# Resultado Final Esperado, Tecnologias Utilizadas e Fluxo Completo da Aplicação

---

# 🎯 Objetivos desta seção

Nesta parte, eu vou apresentar exatamente o que construiremos ao longo deste capítulo.

Antes mesmo de escrevermos uma única linha de código, quero que você compreenda como toda a aplicação funcionará.

Quando conhecemos o objetivo final, fica muito mais fácil entender o motivo de cada classe, método e botão existir.

Ao concluir esta seção, você será capaz de:

✅ Visualizar a arquitetura completa do projeto.

✅ Entender como as telas irão se comunicar.

✅ Conhecer todas as tecnologias utilizadas.

✅ Compreender o fluxo completo das informações.

✅ Identificar o papel de cada classe da aplicação.

---

# 🚀 O resultado final

Ao terminar este capítulo, teremos um sistema Desktop totalmente funcional.

Ele permitirá:

- cadastrar alunos;
- consultar alunos;
- localizar registros pelo ID;
- alterar informações;
- excluir registros;
- visualizar todos os alunos em uma tabela.

Tudo isso utilizando uma interface gráfica semelhante às encontradas em sistemas comerciais.

---

# 🖥️ Visão geral da aplicação

Nossa aplicação será composta por duas telas.

```text
                    SISTEMA ESCOLA

                ┌────────────────────┐
                │ Cadastro de Alunos │
                └─────────┬──────────┘
                          │
                Botão Consulta
                          │
                          ▼
              ┌────────────────────────┐
              │ Consulta de Alunos     │
              └────────────────────────┘
```

A tela de cadastro será responsável por inserir novos registros.

A tela de consulta permitirá localizar, visualizar, alterar e excluir os alunos cadastrados.

---

# 📊 Fluxo completo da aplicação

Antes de começar a programar, gosto sempre de desenhar o caminho que as informações percorrem.

Observe o fluxo abaixo.

```text
Usuário

   │

   ▼

Tela Cadastro

   │

   ▼

Botão Cadastrar

   │

   ▼

Classe Aluno

   │

   ▼

Classe Conexao

   │

   ▼

Banco PostgreSQL

   │

   ▼

Mensagem de Sucesso
```

Perceba que a tela **não conversa diretamente com o banco de dados**.

Ela conversa com a classe responsável pelos dados.

Essa classe utiliza a conexão para acessar o PostgreSQL.

Esse modelo deixa o sistema muito mais organizado.

---

# 🧠 Pensando como um desenvolvedor

Muitos iniciantes acreditam que a tela deve executar comandos SQL.

Isso funciona em pequenos exemplos, mas rapidamente se torna um problema.

Sempre que possível, eu procuro separar as responsabilidades.

Cada classe deve possuir apenas uma função.

Veja o exemplo.

```text
Tela Cadastro

↓

Responsável pela interface.

Não possui SQL.
```

```text
Classe Aluno

↓

Responsável pelos dados do aluno.

Executa INSERT

SELECT

UPDATE

DELETE
```

```text
Classe Conexao

↓

Responsável por abrir e fechar conexões.
```

Essa organização torna o código muito mais fácil de entender e manter.

---

# ⚙️ Tecnologias utilizadas

Durante este projeto utilizaremos diversas ferramentas.

Vamos conhecer rapidamente cada uma delas.

---

## ☕ Java

O Java será nossa linguagem principal.

Será responsável por:

- executar toda a lógica;
- controlar as telas;
- acessar o banco de dados;
- validar informações.

É o coração da aplicação.

---

## 🖼️ Java Swing

O Swing será utilizado para construir a interface gráfica.

Ele fornece componentes prontos como:

- JFrame
- JPanel
- JLabel
- JTextField
- JButton
- JTable
- JScrollPane
- JOptionPane

Sem o Swing, nossa aplicação funcionaria apenas pelo terminal.

---

## 🐘 PostgreSQL

O PostgreSQL armazenará todas as informações.

Ele será responsável por guardar:

- alunos;
- professores;
- disciplinas;
- turmas;
- qualquer outra informação necessária.

O Java apenas envia comandos.

Quem realmente grava os dados é o PostgreSQL.

---

## 🔌 JDBC

JDBC significa:

**Java Database Connectivity**

Ele é a ponte entre o Java e o banco de dados.

Sem JDBC, o Java não conseguiria conversar com o PostgreSQL.

Visualmente podemos imaginar assim.

```text
Java

↓

JDBC

↓

PostgreSQL
```

---

## 💻 NetBeans

O NetBeans será nosso ambiente de desenvolvimento.

Ele facilitará:

- criação das telas;
- organização das classes;
- compilação;
- execução;
- depuração.

Além disso, possui um editor visual extremamente útil para aplicações Swing.

---

# 📦 Estrutura do projeto

Ao final desta aula, nosso projeto terá aproximadamente esta estrutura.

```text
EscolaGrafica

│

├── Conexao.java

├── Aluno.java

├── TelaCadastroAluno.java

├── TelaConsultaAluno.java
```

Mais adiante aprenderemos a organizar essas classes em pacotes.

Neste primeiro momento, manteremos tudo simples para facilitar o aprendizado.

---

# 💡 Dica do Professor

Muitos alunos querem começar digitando código imediatamente.

Eu prefiro fazer exatamente o contrário.

Primeiro eu entendo o projeto.

Depois desenho sua estrutura.

Somente então começo a programar.

Essa pequena mudança reduz muitos erros durante o desenvolvimento.

---

# 📚 Boas práticas

Antes de escrever qualquer sistema, pergunte a si mesmo:

✔️ Quantas telas existirão?

✔️ Quais informações serão cadastradas?

✔️ Como essas telas irão se comunicar?

✔️ Quais classes serão necessárias?

✔️ Onde cada responsabilidade ficará?

Responder essas perguntas economiza muitas horas de retrabalho.

---

# ⚠️ Atenção

Neste capítulo utilizaremos apenas quatro classes.

Isso foi uma decisão didática.

Em sistemas reais, normalmente encontramos:

- pacotes;
- DAO;
- Services;
- Controllers;
- Models;
- Utilitários;
- Interfaces.

Aprenderemos essas organizações mais adiante.

Primeiro quero que você compreenda toda a lógica de funcionamento.

Depois refinaremos a arquitetura.

---

# 🏆 Mini desafio

Sem olhar novamente para o diagrama acima, tente responder:

1. Qual classe conversa com o PostgreSQL?

2. Qual classe abre a conexão?

3. Qual tela será aberta quando clicarmos no botão **Consulta**?

4. Em qual tela ficará a JTable?

Se você conseguiu responder às quatro perguntas, significa que já compreendeu a arquitetura geral da aplicação.

---

# 📝 Resumo da Parte 1B

Nesta seção eu conheci:

✅ O resultado final esperado.

✅ O fluxo completo da aplicação.

✅ O papel de cada classe.

✅ As tecnologias utilizadas.

✅ Como as informações percorrem todo o sistema.

Na próxima parte começaremos a construir o banco de dados que dará suporte à nossa aplicação e entenderemos detalhadamente a função de cada campo da tabela **aluno**.

# 📖 Parte 1C
# Preparando o Banco de Dados e Conhecendo a Estrutura da Aplicação

---

# 🎯 Objetivos desta seção

Agora que já conheço o projeto que iremos desenvolver, chegou o momento de preparar a base de toda a aplicação.

Nesta etapa eu vou:

✅ Criar o banco de dados.

✅ Criar a tabela de alunos.

✅ Entender o papel de cada campo.

✅ Conhecer como o PostgreSQL armazenará as informações.

✅ Visualizar a arquitetura completa da comunicação entre Java e Banco de Dados.

---

# 🏛️ O banco de dados é o coração da aplicação

Quando desenvolvemos um sistema Desktop, normalmente existem dois mundos trabalhando juntos.

De um lado temos a aplicação.

Do outro lado temos o banco de dados.

Eles trabalham juntos o tempo todo.

Observe a arquitetura.

```text
                 SISTEMA ESCOLA

        ┌─────────────────────────────┐
        │     Tela Cadastro           │
        └─────────────┬───────────────┘
                      │
                      ▼
        ┌─────────────────────────────┐
        │         Classe Aluno        │
        └─────────────┬───────────────┘
                      │
                      ▼
        ┌─────────────────────────────┐
        │        Classe Conexao       │
        └─────────────┬───────────────┘
                      │ JDBC
                      ▼
        ┌─────────────────────────────┐
        │        PostgreSQL           │
        └─────────────────────────────┘
```

💡 **Dica do Professor**

> Sempre imagine que a tela nunca conversa diretamente com o banco de dados. Ela conversa com as classes da aplicação, que utilizam a conexão JDBC para enviar comandos ao PostgreSQL.

---

# 🐘 Conhecendo o PostgreSQL


::contentReference[oaicite:0]{index=0}


O PostgreSQL será responsável por armazenar todas as informações do nosso sistema.

É nele que ficarão gravados:

- alunos;
- professores;
- disciplinas;
- turmas;
- notas;
- qualquer outra informação da aplicação.

Mesmo que eu feche o programa Java, os dados continuarão armazenados no banco.

---

# 💻 Abrindo o pgAdmin

Depois de instalar o PostgreSQL, eu abro o **pgAdmin 4**.

Dentro dele consigo visualizar:

- Servidores;
- Bancos de Dados;
- Schemas;
- Tabelas;
- Views;
- Funções.

É por meio dele que criaremos nossa estrutura de dados.

---

# 🧠 Curiosidade

O pgAdmin é apenas uma ferramenta gráfica.

Quem realmente armazena as informações é o PostgreSQL.

Podemos comparar assim:

```text
pgAdmin

↓

Controle Remoto

↓

PostgreSQL

↓

Banco de Dados
```

---

# 🗄️ Criando o banco de dados

Agora vou criar um banco chamado:

```text
escola
```

No pgAdmin:

```text
Servers

↓

PostgreSQL

↓

Databases

↓

Botão direito

↓

Create

↓

Database
```

Nome:

```text
escola
```

Depois clico em:

```text
Save
```

Pronto.

Meu banco está criado.

---

# 🏗️ Criando a tabela aluno

Agora vou abrir o **Query Tool**.

Nele executarei o seguinte script.

```sql
CREATE TABLE aluno (

    id SERIAL PRIMARY KEY,

    nome VARCHAR(100) NOT NULL,

    turma VARCHAR(50) NOT NULL,

    email VARCHAR(100) UNIQUE

);
```

Depois pressiono:

```text
Execute ▶
```

---

# 🔍 Entendendo cada campo

Vamos analisar a tabela linha por linha.

---

## Campo ID

```sql
id SERIAL PRIMARY KEY
```

Esse será o identificador do aluno.

Sempre que um novo cadastro for realizado, o PostgreSQL criará automaticamente um número.

Exemplo:

```text
1

2

3

4

5
```

Eu não preciso preencher esse campo na tela.

O próprio banco fará isso.

---

## Campo Nome

```sql
nome VARCHAR(100)
```

Aqui ficará armazenado o nome completo do aluno.

Exemplo:

```text
Carlos Silva

Maria Souza

Ana Oliveira
```

---

## Campo Turma

```sql
turma VARCHAR(50)
```

Armazenará a turma do aluno.

Exemplo:

```text
Turma A

Turma B

ADS 2026

Informática 01
```

---

## Campo Email

```sql
email VARCHAR(100) UNIQUE
```

O email identifica cada aluno.

Perceba que existe a palavra:

```text
UNIQUE
```

Isso significa:

Não poderão existir dois alunos com o mesmo email.

---

# ⚠️ Atenção

Se eu tentar cadastrar:

```text
joao@email.com
```

duas vezes,

o PostgreSQL impedirá a gravação.

Esse tipo de validação aumenta a segurança dos dados.

---

# 📊 Estrutura da tabela

```text
┌─────────────────────────────────────────────┐
│                 aluno                       │
├──────────┬──────────────────────────────────┤
│ id       │ SERIAL                           │
│ nome     │ VARCHAR(100)                     │
│ turma    │ VARCHAR(50)                      │
│ email    │ VARCHAR(100) UNIQUE              │
└──────────┴──────────────────────────────────┘
```

---

# 🔎 Conferindo a tabela

Depois da criação, posso executar:

```sql
SELECT * FROM aluno;
```

Como ainda não existe nenhum cadastro, o resultado será:

```text
0 linhas
```

Isso é completamente normal.

Nossa tabela está pronta.

Ainda não inserimos nenhum registro.

---

# ☕ Preparando o NetBeans


::contentReference[oaicite:1]{index=1}


Agora chegou o momento de preparar nosso projeto Java.

Dentro do NetBeans criarei uma nova aplicação.

Ela será responsável por conversar com o PostgreSQL.

Mais adiante construiremos toda a interface gráfica utilizando o editor visual do Swing.

---

# 🏗️ Estrutura inicial do projeto

```text
EscolaGrafica

│

├── Conexao.java

├── Aluno.java

├── TelaCadastroAluno.java

└── TelaConsultaAluno.java
```

Neste primeiro momento manteremos todas as classes na mesma pasta.

Mais adiante aprenderemos a organizar o projeto utilizando pacotes.

---

# 💡 Dica do Professor

Muitos iniciantes acreditam que programar começa escrevendo código.

Na prática, eu começo preparando o ambiente.

Quando o banco de dados está pronto e a estrutura do projeto está organizada, escrever o código se torna muito mais simples.

---

# 🏆 Mini desafio

Antes de continuar, tente responder:

1. Qual campo será preenchido automaticamente pelo PostgreSQL?

2. O que significa a restrição `UNIQUE`?

3. O Java conversa diretamente com o PostgreSQL?

4. Qual será a função da classe `Conexao`?

Se você respondeu corretamente, já compreendeu toda a base sobre a qual construiremos o restante do sistema.

---

# 📝 Resumo da Parte 1C

Nesta etapa eu:

✅ Criei o banco de dados.

✅ Criei a tabela `aluno`.

✅ Entendi a função de cada campo.

✅ Conheci melhor o PostgreSQL e o pgAdmin.

✅ Visualizei a arquitetura de comunicação entre Java e Banco de Dados.

Na próxima parte prepararei o projeto no NetBeans, adicionarei o driver JDBC e organizarei toda a estrutura inicial da aplicação antes de começar a escrever as primeiras classes.

# 📖 Parte 1D.1
# Criando o Projeto no NetBeans

---

# 🎯 Objetivos desta seção

Agora que nosso banco de dados está preparado, chegou o momento de iniciar a construção da nossa aplicação.

Nesta etapa eu vou:

✅ Criar um novo projeto Java no NetBeans.

✅ Conhecer melhor a interface da IDE.

✅ Entender como um projeto Java é organizado.

✅ Criar a estrutura inicial da aplicação.

✅ Criar as primeiras classes do projeto.

Ao final desta etapa, meu ambiente estará completamente preparado para começar a desenvolver o sistema.

---

# 💻 O que é uma IDE?

Antes de começar a programar, preciso entender onde meu código será escrito.

Uma **IDE** (*Integrated Development Environment*), ou Ambiente Integrado de Desenvolvimento, é um programa criado para facilitar a vida do desenvolvedor.

Ela reúne diversas ferramentas em um único lugar.

No nosso curso, utilizaremos o **Apache NetBeans**.

---

## 🖼️ Conhecendo o Apache NetBeans


::contentReference[oaicite:0]{index=0}


Ao abrir o NetBeans pela primeira vez, você verá uma tela semelhante à apresentada acima.

Mesmo que a aparência varie um pouco conforme a versão instalada, a organização da IDE continua praticamente a mesma.

---

# 🧠 Por que utilizaremos o NetBeans?

Existem diversas IDEs para Java.

Algumas das mais conhecidas são:

- Eclipse
- IntelliJ IDEA
- VS Code
- Apache NetBeans

Neste curso escolhi o NetBeans porque ele possui um excelente editor visual para Java Swing.

Isso significa que conseguiremos construir telas utilizando o mouse, tornando o aprendizado muito mais simples.

---

# 📌 Conhecendo a interface do NetBeans

Observe os principais elementos da IDE.

```text
┌────────────────────────────────────────────────────────────┐
│ Barra de Menus                                             │
├────────────────────────────────────────────────────────────┤
│ Barra de Ferramentas                                       │
├───────────────┬────────────────────────────────────────────┤
│               │                                            │
│               │                                            │
│   Projects    │              Editor de Código              │
│               │                                            │
│               │                                            │
├───────────────┴────────────────────────────────────────────┤
│                       Output                               │
└────────────────────────────────────────────────────────────┘
```

Cada uma dessas áreas possui uma função específica.

---

# 📂 Janela Projects

A janela **Projects** será uma das mais utilizadas durante todo o curso.

Ela exibe todos os arquivos do projeto.

Exemplo:

```text
EscolaGrafica

Source Packages

Libraries

Test Packages
```

Sempre que eu precisar criar uma nova classe, será nessa janela que clicarei com o botão direito.

---

# 📝 Editor de Código

No centro da tela encontramos o editor.

É nele que escreveremos todas as classes Java.

Sempre que eu abrir um arquivo, ele aparecerá nessa região.

Exemplo:

```java
public class Aluno {

}
```

---

# 📋 Janela Output

Na parte inferior encontramos o **Output**.

Sempre que executarmos o projeto, todas as mensagens aparecerão ali.

Exemplo:

```text
Conexão realizada com sucesso!
```

ou

```text
Erro ao conectar ao banco.
```

Essa janela será muito importante para identificar possíveis erros.

---

# 🚀 Criando um novo projeto

Agora vou criar nossa aplicação.

No menu superior clico em:

```text
File

↓

New Project
```

---

## Selecionando o tipo do projeto

Na janela aberta, seleciono:

```text
Java

↓

Java Application
```

Depois clico em:

```text
Next
```

---

# 🖼️ Assistente de criação de projeto


::contentReference[oaicite:1]{index=1}


Essa janela será utilizada para definir o nome e o local onde o projeto será salvo.

---

# 📝 Nome do projeto

No campo **Project Name**, digitarei:

```text
EscolaGrafica
```

Esse será o nome utilizado durante todo o capítulo.

---

# 📁 Escolhendo o local do projeto

No campo **Project Location**, escolho a pasta onde desejo salvar meus projetos.

Uma sugestão é criar uma pasta chamada:

```text
C:\ProjetosJava
```

ou

```text
Documentos\ProjetosJava
```

Assim todos os projetos ficarão organizados no mesmo local.

---

# ⚠️ Atenção

Evite salvar projetos em locais temporários, como a Área de Trabalho ou a pasta Downloads.

Com o tempo você desenvolverá muitos projetos, e manter tudo organizado facilitará bastante seu trabalho.

---

# ☑️ Classe Main

Durante a criação do projeto, o NetBeans perguntará se desejo criar uma classe principal.

Neste momento, posso deixar essa opção marcada.

Mais adiante criaremos nossas próprias telas e definiremos qual será a primeira janela da aplicação.

---

# 🎉 Projeto criado

Após clicar em **Finish**, o NetBeans criará automaticamente toda a estrutura inicial do projeto.

No painel **Projects**, veremos algo semelhante a isto:

```text
EscolaGrafica

├── Source Packages
│
├── Libraries
│
└── Test Packages
```

Perceba que o NetBeans já organizou tudo para nós.

---

# 🧠 Como um projeto Java é organizado?

Todo projeto Java possui uma estrutura semelhante.

```text
Projeto

│

├── Código-fonte

├── Bibliotecas

├── Arquivos de configuração

└── Testes
```

Nosso trabalho acontecerá principalmente dentro da pasta **Source Packages**.

É nela que criaremos todas as classes.

---

# 📦 O que é Source Packages?

A pasta **Source Packages** armazena todos os arquivos `.java` da aplicação.

Exemplo:

```text
Source Packages

↓

Conexao.java

Aluno.java

TelaCadastroAluno.java

TelaConsultaAluno.java
```

Cada classe terá uma responsabilidade específica.

---

# 💡 Dica do Professor

Sempre que iniciar um projeto novo, gosto de criar toda a estrutura antes de escrever qualquer código.

Isso me ajuda a visualizar o projeto completo e evita esquecer alguma classe importante.

---

# 🏗️ Criando as primeiras classes

Agora criarei as quatro classes principais do sistema.

Para isso, clico com o botão direito em:

```text
Source Packages
```

Depois seleciono:

```text
New

↓

Java Class
```

Repito esse processo para criar:

```text
Conexao

Aluno

TelaCadastroAluno

TelaConsultaAluno
```

---

# 🖼️ Criando uma nova classe


::contentReference[oaicite:2]{index=2}


Ao criar uma nova classe, basta informar seu nome e confirmar.

O NetBeans gerará automaticamente a estrutura básica do arquivo.

---

# 📊 Estrutura inicial do projeto

Ao final desta etapa, meu projeto estará organizado da seguinte forma:

```text
EscolaGrafica

│

├── Source Packages

│      ├── Conexao.java

│      ├── Aluno.java

│      ├── TelaCadastroAluno.java

│      └── TelaConsultaAluno.java

│

├── Libraries

│

└── Test Packages
```

Essa será a base para todo o restante do sistema.

---

# 🧠 Curiosidade

Em projetos profissionais é comum encontrarmos dezenas ou até centenas de classes.

Neste capítulo utilizaremos apenas quatro classes para que toda a atenção fique voltada ao aprendizado dos conceitos fundamentais.

Mais adiante aprenderemos a separar essas classes em pacotes como:

- `model`
- `dao`
- `view`
- `controller`
- `util`

Assim nosso projeto ficará ainda mais organizado.

---

# 📝 Resumo da Parte 1D.1

Nesta etapa eu:

✅ Conheci a interface do NetBeans.

✅ Entendi a função de cada área da IDE.

✅ Criei um novo projeto Java.

✅ Organizei a estrutura inicial da aplicação.

✅ Criei as quatro primeiras classes do sistema.

Na próxima etapa adicionarei o driver JDBC do PostgreSQL, organizarei as bibliotecas do projeto e deixarei tudo pronto para iniciar a programação da classe **Conexao**.

# 📖 Capítulo 4 – Parte 1D.2
# Configurando o Driver JDBC e Organizando o Projeto

---

# 🎯 Objetivos desta seção

Nesta etapa vou concluir toda a preparação do ambiente de desenvolvimento.

Ao final desta aula eu terei:

✅ O driver JDBC instalado.

✅ O projeto preparado para conversar com o PostgreSQL.

✅ Uma estrutura organizada.

✅ Conhecimento sobre bibliotecas Java.

✅ Um projeto pronto para iniciar a programação.

---

# 🚀 Antes de começar...

Até aqui nós já realizamos um grande trabalho.

✔ Criamos o banco de dados.

✔ Criamos a tabela.

✔ Instalamos o NetBeans.

✔ Criamos nosso projeto.

✔ Criamos as primeiras classes.

Agora falta apenas uma etapa para que Java consiga conversar com o PostgreSQL.

Essa etapa chama-se:

# 🔌 Driver JDBC

---

# ☕ O que é JDBC?

JDBC significa:

**Java Database Connectivity**

É uma API criada pela própria plataforma Java para permitir que programas Java conversem com bancos de dados.

Sem ela...

```text
Java

❌

PostgreSQL
```

Com ela...

```text
Java

↓

JDBC

↓

PostgreSQL
```

É exatamente essa "ponte" que fará nosso sistema funcionar.

---

# 🧠 Uma comparação simples

Imagine a seguinte situação.

Você fala apenas português.

Seu amigo fala apenas japonês.

Como vocês conversariam?

Precisariam de um tradutor.

O JDBC funciona exatamente assim.

```text
Java

↓

Tradutor (JDBC)

↓

PostgreSQL
```

O Java envia comandos.

O JDBC traduz.

O PostgreSQL entende.

---

# 🖼️ Biblioteca JDBC


::contentReference[oaicite:0]{index=0}


A biblioteca JDBC é distribuída em um arquivo chamado:

```text
postgresql-xx.x.x.jar
```

A versão pode variar conforme a atualização do PostgreSQL.

Isso é completamente normal.

---

# 📥 Obtendo o Driver JDBC

O driver oficial pode ser baixado diretamente no site do PostgreSQL.

Após o download teremos um arquivo semelhante a este:

```text
postgresql-42.7.x.jar
```

Esse arquivo será adicionado ao projeto.

---

# 📁 O que é um arquivo JAR?

JAR significa:

**Java Archive**

É um pacote contendo diversas classes Java prontas para uso.

Podemos imaginar assim:

```text
Biblioteca

↓

Livro

↓

Capítulos

↓

Classes Java
```

Quando adicionamos um arquivo JAR ao projeto, ganhamos acesso às classes existentes nele.

---

# 🏗️ Adicionando a biblioteca ao projeto

No painel **Projects** clico com o botão direito sobre o projeto.

```text
EscolaGrafica

↓

Botão Direito

↓

Properties
```

Depois seleciono:

```text
Libraries
```

Em seguida clico em:

```text
Add JAR/Folder
```

Seleciono:

```text
postgresql-42.x.x.jar
```

Por fim clico em:

```text
Open
```

---

# 🖼️ Adicionando o Driver ao NetBeans


::contentReference[oaicite:1]{index=1}


Após adicionar a biblioteca, ela aparecerá automaticamente dentro da pasta **Libraries**.

---

# 📂 O que existe dentro de Libraries?

Observe a estrutura.

```text
EscolaGrafica

│

├── Source Packages

├── Libraries

│      ├── JDK

│      └── PostgreSQL JDBC Driver

└── Test Packages
```

Sempre que adicionarmos bibliotecas externas, elas aparecerão nessa pasta.

---

# ⚠️ Atenção

Se o driver JDBC não estiver instalado corretamente, poderão surgir erros como:

```text
No suitable driver found
```

ou

```text
ClassNotFoundException
```

Esses erros normalmente indicam que o arquivo JAR não foi adicionado ao projeto.

---

# 📦 Organizando nosso projeto

Embora nosso projeto seja pequeno, já podemos começar a pensar como desenvolvedores profissionais.

Observe nossa estrutura atual.

```text
EscolaGrafica

│

├── Conexao.java

├── Aluno.java

├── TelaCadastroAluno.java

└── TelaConsultaAluno.java
```

Ela é suficiente para aprendermos os primeiros conceitos.

---

# 🏢 Como seria um projeto profissional?

Em empresas normalmente encontramos uma organização semelhante a esta.

```text
EscolaGrafica

│

├── model

│      └── Aluno.java

│

├── dao

│      └── AlunoDAO.java

│

├── util

│      └── Conexao.java

│

├── view

│      ├── TelaCadastroAluno.java

│      └── TelaConsultaAluno.java

│

└── controller
```

Observe que cada pasta possui uma responsabilidade.

Isso facilita muito a manutenção do sistema.

---

# 🧠 Curiosidade

Projetos grandes podem possuir centenas de classes.

Imagine procurar um arquivo chamado:

```text
AlunoDAO.java
```

em uma pasta contendo 500 arquivos.

Seria muito difícil.

Por isso utilizamos pacotes.

Eles funcionam como gavetas dentro de um armário.

---

# 📊 Arquitetura do nosso sistema

```text
                 Usuário

                    │

                    ▼

         TelaCadastroAluno

                    │

                    ▼

                Aluno.java

                    │

                    ▼

              Conexao.java

                    │

              JDBC Driver

                    │

                    ▼

              PostgreSQL
```

Perceba que cada componente possui apenas uma responsabilidade.

Esse é um dos princípios mais importantes da programação orientada a objetos.

---

# 💡 Dica do Professor

Antes de começar qualquer projeto, sempre faça uma pequena organização.

Pergunte a si mesmo:

- Quantas telas existirão?
- Quais classes serão necessárias?
- Quais dados serão armazenados?
- Como o banco será estruturado?

Responder essas perguntas antes de programar economiza muitas horas de trabalho.

---

# 📚 Boas práticas

Durante todo este curso seguiremos algumas regras.

✅ Classes com nomes claros.

✅ Um arquivo por classe.

✅ Código organizado.

✅ Métodos pequenos.

✅ Comentários apenas quando realmente necessários.

✅ Responsabilidades bem definidas.

Esses hábitos fazem enorme diferença em projetos maiores.

---

# ❌ Erros comuns dos iniciantes

Evite estes erros:

🚫 Colocar todo o código em uma única classe.

🚫 Misturar SQL com componentes gráficos.

🚫 Criar variáveis com nomes pouco descritivos.

🚫 Não fechar conexões com o banco.

🚫 Copiar código sem entender seu funcionamento.

---

# 🏆 Mini desafio

Antes de continuar, tente responder.

1️⃣ Qual é a função do JDBC?

2️⃣ O que significa um arquivo JAR?

3️⃣ Em qual pasta aparecem as bibliotecas adicionadas ao projeto?

4️⃣ Por que projetos profissionais utilizam pacotes?

Se conseguiu responder todas as perguntas, significa que você já está preparado para iniciar a programação.

---

# 📋 Checklist do Projeto

Antes de iniciar o próximo capítulo, confira se tudo está pronto.

| Item                         | Status |
| ---------------------------- | :----: |
| PostgreSQL instalado         |   ✅    |
| pgAdmin funcionando          |   ✅    |
| Banco criado                 |   ✅    |
| Tabela aluno criada          |   ✅    |
| NetBeans instalado           |   ✅    |
| Projeto EscolaGrafica criado |   ✅    |
| Classes iniciais criadas     |   ✅    |
| Driver JDBC adicionado       |   ✅    |

Se todos os itens estiverem concluídos, podemos seguir para a programação.

---

# 🎓 Encerramento da Parte 1

Parabéns!

Nesta primeira parte construímos toda a fundação do projeto.

Agora possuímos:

- um banco de dados pronto;
- uma tabela estruturada;
- um projeto Java organizado;
- o NetBeans configurado;
- o driver JDBC instalado;
- a arquitetura definida.

A partir do próximo capítulo começaremos a escrever código de verdade.

Nossa primeira classe será a **Conexao**, responsável por estabelecer a comunicação entre o Java e o PostgreSQL.

Será a partir dela que toda a aplicação passará a armazenar e recuperar informações do banco de dados.

---

# 📝 Resumo Geral da Parte 1

Ao concluir toda a Parte 1, eu aprendi a:

✅ Planejar um projeto Java Desktop.

✅ Criar um banco de dados PostgreSQL.

✅ Criar tabelas utilizando SQL.

✅ Organizar um projeto no NetBeans.

✅ Entender o papel do JDBC.

✅ Adicionar bibliotecas externas.

✅ Organizar as primeiras classes.

✅ Preparar toda a estrutura necessária para iniciar o desenvolvimento.

---

# 🚀 O que vem a seguir?

No próximo capítulo iniciaremos a implementação da classe **Conexao.java**.

Será nela que aprenderemos:

- como importar as bibliotecas JDBC;
- como criar uma conexão com o PostgreSQL;
- como tratar exceções;
- como fechar conexões corretamente;
- como testar a comunicação entre Java e Banco de Dados.

A partir desse momento, nosso sistema começará a ganhar vida.

# 📘 Capítulo 4
# Parte 2.1 — Entendendo o JDBC e a Arquitetura da Conexão

---

# 🎯 Objetivos desta seção

Agora chegou o momento de fazer algo muito importante.

Até aqui nós:

✅ Criamos o banco de dados.

✅ Criamos a tabela **aluno**.

✅ Instalamos o NetBeans.

✅ Criamos nosso projeto Java.

Mas...

Ainda existe um problema.

Nosso programa Java **não sabe onde está o banco de dados**.

E mesmo que soubesse...

Ele **não sabe como conversar com ele**.

É exatamente isso que aprenderemos agora.

Ao final desta aula eu serei capaz de:

- compreender o papel do JDBC;
- entender como o Java conversa com o PostgreSQL;
- visualizar toda a arquitetura da aplicação;
- compreender por que precisamos da classe `Conexao`;
- interpretar o fluxo completo de uma conexão.

---

# 🧠 Antes de escrever código...

Uma das maiores dificuldades dos iniciantes é querer começar digitando código imediatamente.

Eu gosto de fazer exatamente o contrário.

Primeiro eu entendo **como as peças do sistema trabalham juntas**.

Depois começo a programar.

Quando faço isso, praticamente todas as classes passam a fazer sentido.

---

# 🏛️ A arquitetura do nosso sistema

Antes de conhecer o JDBC, observe o desenho abaixo.

```text
                SISTEMA ESCOLA

              ┌────────────────────┐
              │      Usuário       │
              └─────────┬──────────┘
                        │
                        ▼
          ┌─────────────────────────────┐
          │ TelaCadastroAluno (Swing)   │
          └──────────────┬──────────────┘
                         │
                         ▼
              ┌──────────────────────┐
              │     Aluno.java       │
              └──────────┬───────────┘
                         │
                         ▼
             ┌────────────────────────┐
             │    Conexao.java        │
             └──────────┬─────────────┘
                        │ JDBC
                        ▼
              ┌──────────────────────┐
              │     PostgreSQL       │
              └──────────────────────┘
```

Observe que existem várias etapas até chegar ao banco.

Cada uma delas possui uma responsabilidade.

Esse conceito é conhecido como **separação de responsabilidades**.

---

# 💡 Dica do Professor

> Um bom sistema não é aquele que possui muito código.
>
> Um bom sistema é aquele em que cada classe faz apenas uma coisa.

---

# ☕ O que é JDBC?

JDBC significa:

**Java Database Connectivity**

Em português:

**Conectividade entre Java e Banco de Dados.**

É uma tecnologia criada pela própria plataforma Java para permitir que programas conversem com bancos de dados relacionais.

Sem o JDBC...

```text
Java

❌

Banco de Dados
```

Com o JDBC...

```text
Java

↓

JDBC

↓

Banco de Dados
```

Ele funciona como uma ponte entre os dois mundos.

---

# 🌉 Imagine uma ponte

Imagine duas cidades.

```text
Cidade Java

~~~~~~~~~~~~~~ Rio ~~~~~~~~~~~~~~

Cidade PostgreSQL
```

Sem uma ponte, ninguém consegue atravessar.

Agora observe.

```text
Cidade Java

======= Ponte (JDBC) =======

Cidade PostgreSQL
```

Agora existe comunicação.

É exatamente isso que acontece dentro da aplicação.

---

# 🖼️ O JDBC na prática


::contentReference[oaicite:0]{index=0}


Essas imagens ilustram os principais componentes envolvidos na comunicação entre uma aplicação Java e um banco de dados PostgreSQL.

---

# 🏢 Como isso funciona nas empresas?

Imagine um sistema de uma escola.

Um funcionário preenche os dados de um novo aluno.

```text
Nome

Turma

Email
```

Ao clicar em **Cadastrar**, ocorre o seguinte processo.

```text
Usuário

↓

Tela Swing

↓

Classe Aluno

↓

Classe Conexao

↓

Driver JDBC

↓

Servidor PostgreSQL

↓

Banco de Dados
```

Tudo isso acontece em poucos milissegundos.

---

# 📊 Fluxograma da conexão

```text
                 Início

                    │

                    ▼

          Usuário clica em Cadastrar

                    │

                    ▼

          Tela recebe as informações

                    │

                    ▼

          Classe Conexao é chamada

                    │

                    ▼

          JDBC abre uma conexão

                    │

                    ▼

          PostgreSQL recebe o comando

                    │

                    ▼

          Registro gravado

                    │

                    ▼

          Mensagem de sucesso
```

Esse fluxo será repetido praticamente em todas as operações do sistema.

---

# 🧩 Quem faz o quê?

Uma dúvida muito comum é:

> Professor, por que existem tantas classes?

Vamos responder.

| Classe              | Responsabilidade                     |
| ------------------- | ------------------------------------ |
| `TelaCadastroAluno` | Mostrar a interface ao usuário       |
| `TelaConsultaAluno` | Exibir e consultar registros         |
| `Aluno`             | Representar os dados do aluno        |
| `Conexao`           | Abrir e fechar a conexão com o banco |
| PostgreSQL          | Armazenar os dados                   |

Perceba que nenhuma classe faz o trabalho da outra.

Essa organização deixa o sistema muito mais fácil de manter.

---

# ⚠️ Erro muito comum

Um dos maiores erros dos iniciantes é escrever comandos SQL diretamente dentro dos botões.

Exemplo (não recomendado):

```java
private void btnCadastrarActionPerformed(...) {

    String sql = "INSERT INTO aluno ...";

}
```

Esse código funciona.

Mas imagine um sistema com:

- 40 telas;
- 300 botões;
- milhares de linhas de código.

Manter isso seria um pesadelo.

Por isso vamos separar responsabilidades desde o início.

---

# 🧠 Curiosidade

O JDBC não funciona apenas com PostgreSQL.

Ele também pode conversar com diversos outros bancos de dados.

Por exemplo:

- MySQL
- MariaDB
- Oracle Database
- Microsoft SQL Server
- SQLite
- IBM Db2

Cada banco possui seu próprio driver JDBC.

A lógica da programação permanece praticamente a mesma.

---

# 🏗️ Onde entra a classe `Conexao`?

A classe `Conexao` será responsável por uma única tarefa:

```text
Abrir uma conexão com o banco de dados.
```

Ela não terá botões.

Não terá telas.

Não terá campos de texto.

Ela fará apenas isto:

```text
Java

↓

Abrir conexão

↓

Retornar Connection

↓

Encerrar conexão
```

Essa simplicidade é justamente o que torna o código organizado.

---

# 📐 Arquitetura completa

```text
                   USUÁRIO

                      │

                      ▼

          TelaCadastroAluno (Swing)

                      │

                      ▼

             Objeto Aluno

                      │

                      ▼

             Classe Conexao

                      │

             Driver JDBC

                      │

                      ▼

            PostgreSQL Server

                      │

                      ▼

              Banco escola

                      │

                      ▼

              Tabela aluno
```

Esse será o caminho percorrido pelos dados durante todo o desenvolvimento deste projeto.

---

# 💬 Estudo de caso

Imagine que uma escola possua **15 mil alunos**.

Quando um novo estudante é matriculado, o atendente apenas preenche um formulário.

Ao clicar em **Cadastrar**, todo o restante acontece automaticamente.

O funcionário não precisa saber SQL.

Não precisa conhecer JDBC.

Não precisa entender como funciona o PostgreSQL.

Ele apenas utiliza o sistema.

É exatamente esse tipo de aplicação que estamos aprendendo a construir.

---

# 🐞 Erros comuns

Evite estes erros.

❌ Achar que o Java grava os dados diretamente no disco.

❌ Pensar que o JDBC é um banco de dados.

❌ Colocar SQL dentro das telas.

❌ Misturar lógica de negócio com interface gráfica.

❌ Criar uma conexão diferente para cada botão sem organização.

---

# 💡 Dica do Professor

Sempre que eu tiver dificuldade para entender um projeto, faço uma pergunta muito simples:

> **"Por onde os dados estão caminhando?"**

Se eu consigo responder essa pergunta, consigo entender praticamente toda a arquitetura da aplicação.

---

# 📝 Resumo visual

```text
Usuário

↓

Swing

↓

Aluno

↓

Conexao

↓

JDBC

↓

PostgreSQL

↓

Tabela aluno
```

Essa sequência deve ficar gravada na sua memória.

Ela aparecerá durante praticamente todo o restante do curso.

---

# 🏆 Mini desafio

Sem consultar o material, responda:

1. O que significa JDBC?

2. Qual é a função da classe `Conexao`?

3. O Swing conversa diretamente com o PostgreSQL?

4. Quem realmente grava os dados?

5. Qual componente funciona como ponte entre Java e o banco?

---

# ✔️ Checklist de aprendizagem

Ao concluir esta seção eu consigo:

- [ ] Explicar o que é JDBC.
- [ ] Desenhar a arquitetura da aplicação.
- [ ] Identificar a função da classe `Conexao`.
- [ ] Explicar o caminho percorrido pelos dados.
- [ ] Diferenciar Java, JDBC e PostgreSQL.

---

# 🚀 Próxima etapa

Na Parte **2.2**, finalmente começaremos a programar a classe **`Conexao.java`**.

Vamos construir cada linha do código juntos, entendendo o motivo de cada importação, cada variável e cada instrução, para que você não apenas copie o código, mas compreenda exatamente como a conexão entre Java e PostgreSQL é estabelecida.

# 📘 Capítulo 4
# Parte 2.2A — Criando a Classe Conexao

---

# 🎯 Objetivos desta seção

Agora chegou o momento de criar a primeira classe realmente importante do nosso sistema.

Até aqui, tudo o que fizemos foi preparar o ambiente.

A partir desta etapa, começaremos a desenvolver a base da comunicação entre o Java e o PostgreSQL.

Ao concluir esta seção, eu serei capaz de:

✅ Criar uma classe Java.

✅ Compreender a responsabilidade da classe **Conexao**.

✅ Entender por que ela será utilizada por todo o sistema.

✅ Conhecer sua estrutura.

✅ Compreender como um projeto profissional organiza esse tipo de classe.

---

# 🧠 Antes de programar...

Sempre faço uma pergunta aos meus alunos.

> **"Se dez telas diferentes precisarem acessar o banco de dados, onde ficará o código da conexão?"**

Muitos respondem:

> "Professor... dentro de cada tela."

Essa parece uma boa ideia no começo.

Mas imagine um sistema com:

- 80 telas
- 350 classes
- milhares de linhas de código

Se cada tela possuir seu próprio código de conexão, qualquer alteração exigirá modificar dezenas de arquivos.

Isso aumenta o risco de erros e torna a manutenção muito difícil.

Por isso, criaremos uma única classe responsável pela conexão.

---

# 🏢 Como as empresas fazem?

Em projetos profissionais, normalmente existe uma classe dedicada exclusivamente para abrir conexões com o banco de dados.

Ela pode receber nomes como:

- `Conexao`
- `ConnectionFactory`
- `DatabaseConnection`
- `ConnectionManager`

Neste curso utilizaremos o nome:

```text
Conexao
```

Porque ele é simples, intuitivo e facilita o aprendizado.

---

# 💡 Dica do Professor

> Uma boa classe deve possuir apenas uma responsabilidade.

A classe **Conexao** fará apenas uma coisa:

**Abrir e fornecer conexões com o banco de dados.**

Ela não terá:

❌ Botões

❌ JTable

❌ JTextField

❌ SQL de cadastro

❌ Interface gráfica

Sua única missão será estabelecer a comunicação entre Java e PostgreSQL.

---

# 🏗️ Criando a classe

No NetBeans, localizo a pasta:

```text
Source Packages
```

Depois clico com o botão direito.

```text
New

↓

Java Class
```

---

## 🖼️ Criando uma nova classe


::contentReference[oaicite:0]{index=0}


Na janela exibida, informo:

```text
Class Name

↓

Conexao
```

Depois clico em:

```text
Finish
```

O NetBeans criará automaticamente a estrutura básica da classe.

---

# 📂 Estrutura inicial

Nossa classe ficará assim.

```java
public class Conexao {

}
```

Embora pareça extremamente simples, essa classe será utilizada por praticamente todo o sistema.

---

# 📌 O que significa "class"?

Observe novamente.

```java
public class Conexao {

}
```

Vamos entender cada palavra.

---

## public

```java
public
```

Significa que a classe poderá ser utilizada por qualquer outra classe do projeto.

Imagine uma biblioteca pública.

Qualquer pessoa pode entrar.

É exatamente essa ideia.

---

## class

```java
class
```

A palavra **class** informa ao Java que estamos criando um novo tipo de objeto.

Podemos imaginar assim.

```text
Projeto

↓

Classe

↓

Objeto

↓

Informações
```

Tudo em Java gira em torno de classes.

---

## Conexao

```java
Conexao
```

É simplesmente o nome da nossa classe.

Escolhemos esse nome porque ele descreve exatamente sua responsabilidade.

Uma boa prática é utilizar nomes que expliquem claramente o que a classe faz.

---

# 🧩 Diagrama UML da classe

Antes mesmo de escrever métodos, gosto de desenhar a estrutura da classe.

```text
┌───────────────────────────────┐
│           Conexao             │
├───────────────────────────────┤
│ - URL                         │
│ - USUARIO                     │
│ - SENHA                       │
├───────────────────────────────┤
│ + conectar()                  │
└───────────────────────────────┘
```

Neste momento, ainda não implementamos nada.

Estamos apenas planejando a estrutura.

---

# 🏛️ Arquitetura da aplicação

Observe onde essa classe ficará.

```text
                 Usuário

                    │

                    ▼

         TelaCadastroAluno

                    │

                    ▼

               Aluno.java

                    │

                    ▼

              Conexao.java

                    │

                    ▼

              PostgreSQL
```

Todas as telas passarão obrigatoriamente pela classe **Conexao**.

Isso evita repetição de código.

---

# 📦 Organização do projeto

Depois da criação, nosso projeto ficará semelhante a isto.

```text
EscolaGrafica

│

├── Source Packages

│      ├── Conexao.java

│      ├── Aluno.java

│      ├── TelaCadastroAluno.java

│      └── TelaConsultaAluno.java

│

├── Libraries

└── Test Packages
```

Ainda não criamos nenhum método.

Estamos apenas organizando a aplicação.

---

# 🧠 Curiosidade

Em sistemas corporativos, essa classe costuma ser utilizada milhares de vezes durante o funcionamento do programa.

Cada vez que um usuário:

- cadastra um cliente;
- consulta um produto;
- altera um pedido;
- exclui um funcionário;

o sistema precisa abrir uma conexão com o banco.

Por isso essa classe é considerada uma das mais importantes do projeto.

---

# ⚠️ Erro comum

Um erro muito frequente entre iniciantes é criar várias classes chamadas:

```text
Conexao1

ConexaoBanco

Conectar

Banco

ConexaoNova

ConexaoFinal
```

Isso dificulta a manutenção.

Prefira nomes simples e objetivos.

Neste projeto utilizaremos apenas:

```text
Conexao
```

---

# 💼 Como isso funciona nas empresas?

Em aplicações maiores, a classe de conexão normalmente não fica na raiz do projeto.

Ela costuma ser organizada dentro de um pacote específico.

Por exemplo:

```text
util

↓

Conexao.java
```

ou

```text
database

↓

Conexao.java
```

Como nosso objetivo é aprender os conceitos, manteremos tudo em uma estrutura mais simples neste primeiro momento.

Nos próximos capítulos aprenderemos a organizar projetos em pacotes seguindo o padrão MVC.

---

# 📋 O que construiremos nesta classe?

Ao longo das próximas seções, adicionaremos:

```text
Imports JDBC

↓

Constantes

↓

URL

↓

Usuário

↓

Senha

↓

Método conectar()

↓

Tratamento de exceções

↓

Retorno da Connection
```

Tudo será desenvolvido passo a passo.

---

# 💡 Dica do Professor

Sempre que criar uma nova classe, pergunte:

> **"Qual é a única responsabilidade desta classe?"**

Se a resposta possuir várias funções diferentes, provavelmente ela está fazendo mais do que deveria.

---

# 📝 Resumo visual

```text
Conexao.java

↓

Responsável apenas por

↓

Abrir conexão

↓

Retornar Connection

↓

Encerrar conexão
```

Essa simplicidade será uma grande vantagem durante todo o desenvolvimento.

---

# 🏆 Mini desafio

Antes de continuar, tente responder:

1. Qual é a responsabilidade da classe `Conexao`?

2. Por que não colocaremos o código da conexão dentro das telas?

3. O que significa a palavra-chave `public`?

4. O que representa a palavra `class`?

5. Quantas classes de conexão teremos neste projeto?

---

# ✔️ Checklist de aprendizagem

Ao concluir esta seção, eu consigo:

- [ ] Criar uma nova classe Java.
- [ ] Explicar a responsabilidade da classe `Conexao`.
- [ ] Interpretar seu diagrama UML.
- [ ] Localizar essa classe dentro da arquitetura do sistema.
- [ ] Compreender por que centralizar a conexão facilita a manutenção.

---

# 🚀 Próxima etapa

Na **Parte 2.2B**, começaremos a importar as bibliotecas necessárias para que o Java possa utilizar o JDBC.

Cada `import` será explicado detalhadamente, com exemplos práticos e analogias simples, para que você compreenda exatamente o papel de cada classe utilizada na conexão com o PostgreSQL.

# 📘 Capítulo 4
# Parte 2.2B – Entendendo os Imports da Classe Conexao

---

# 🎯 Objetivos desta seção

Agora chegou o momento de escrever as primeiras linhas da nossa classe.

Embora elas pareçam extremamente simples, são responsáveis por disponibilizar todas as ferramentas que utilizaremos para criar a conexão com o PostgreSQL.

Ao concluir esta parte eu serei capaz de:

✅ Entender o que é um import.

✅ Saber por que ele existe.

✅ Conhecer cada biblioteca utilizada.

✅ Compreender como a JVM encontra essas classes.

✅ Entender o papel do DriverManager.

---

# 🧠 Antes de escrever...

Muitos iniciantes acreditam que um **import copia código para dentro da aplicação**.

Na realidade isso não acontece.

O import apenas informa ao compilador onde determinada classe está localizada.

Podemos imaginar assim:

```text
Sem import

Professor...

Onde está a classe Connection?

🤷
```

Com import:

```text
Professor...

A classe está aqui.

↓

java.sql.Connection
```

O compilador passa a saber onde encontrá-la.

---

# 📚 Os imports da nossa classe

Nossa classe começará assim:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
```

Pode parecer pouca coisa.

Mas essas três linhas representam toda a comunicação entre Java e PostgreSQL.

---

# 🖼️ O pacote java.sql


::contentReference[oaicite:0]{index=0}


Todas essas classes pertencem ao pacote **java.sql**, fornecido pela própria plataforma Java.

Isso significa que elas já fazem parte da JDK.

Não precisamos instalá-las separadamente.

---

# 📦 O que é um pacote?

Imagine um armário cheio de gavetas.

```text
Armário

│

├── Gaveta Matemática

├── Gaveta Datas

├── Gaveta Arquivos

└── Gaveta Banco de Dados
```

Em Java chamamos essas "gavetas" de **pacotes**.

O pacote responsável pelas classes de banco de dados é:

```text
java.sql
```

---

# 🏗️ Como a JVM encontra uma classe?

Observe este desenho.

```text
Meu Código

↓

import java.sql.Connection

↓

Compilador

↓

JDK

↓

Pacote java.sql

↓

Classe Connection
```

O import informa exatamente onde essa classe está localizada.

Sem ele, o compilador não conseguiria encontrá-la.

---

# ☕ Primeiro import

```java
import java.sql.Connection;
```

Vamos analisar cuidadosamente.

---

## O que é Connection?

A classe **Connection** representa uma conexão aberta com o banco de dados.

Podemos imaginar assim.

```text
Java

──────────────

PostgreSQL
```

Ainda não existe comunicação.

Depois que criamos uma Connection...

```text
Java

══════════════

PostgreSQL
```

Agora existe um canal de comunicação.

---

# 🏢 Exemplo prático

Imagine um telefone.

Enquanto ninguém atende...

```text
Ligando...

📞
```

Quando a ligação é aceita...

```text
📞════════📞
```

Agora duas pessoas conseguem conversar.

Connection representa exatamente isso.

---

# 🔬 Por baixo dos panos

Quando o método `DriverManager.getConnection()` for executado, ele criará um objeto do tipo **Connection**.

Esse objeto armazenará diversas informações importantes.

Por exemplo:

- servidor conectado;
- porta utilizada;
- usuário autenticado;
- banco selecionado;
- estado da conexão.

Tudo isso ficará encapsulado dentro desse objeto.

---

# ☕ Segundo import

```java
import java.sql.DriverManager;
```

Essa classe possui uma função muito importante.

Ela localiza o driver JDBC adequado e cria a conexão.

---

# 📊 Como funciona?

```text
Java

↓

DriverManager

↓

Driver JDBC PostgreSQL

↓

Servidor PostgreSQL
```

Sem DriverManager precisaríamos criar toda essa comunicação manualmente.

---

# 💡 Analogia simples

Imagine um estacionamento.

O motorista chega.

Quem indica a vaga?

O manobrista.

O DriverManager funciona exatamente assim.

Ele recebe a solicitação e encaminha para o driver correto.

---

# 🔬 Por baixo dos panos

Internamente o DriverManager procura um driver compatível com a URL informada.

Exemplo:

```text
jdbc:postgresql://...
```

Ao encontrar um driver PostgreSQL carregado na aplicação, ele delega a criação da conexão para esse driver.

Esse processo acontece automaticamente.

---

# ☕ Terceiro import

```java
import java.sql.SQLException;
```

Essa classe representa possíveis erros relacionados ao banco de dados.

Sempre que algo der errado, será uma SQLException que descreverá o problema.

---

# 📌 Exemplos de SQLException

```text
Senha incorreta.
```

```text
Banco inexistente.
```

```text
Servidor desligado.
```

```text
Tabela não encontrada.
```

```text
Usuário sem permissão.
```

Todos esses problemas geram uma SQLException.

---

# 🏢 Estudo de caso

Imagine uma escola.

O servidor onde está o PostgreSQL fica desligado para manutenção.

O usuário tenta cadastrar um aluno.

O DriverManager tenta abrir a conexão.

O servidor não responde.

Resultado:

```text
SQLException
```

Graças a essa exceção, conseguimos informar ao usuário que houve um problema, em vez de deixar a aplicação simplesmente encerrar.

---

# ⚠️ Erro comum

Um dos erros mais frequentes entre iniciantes é importar classes erradas.

Exemplo:

```java
import java.awt.Connection;
```

Essa classe sequer existe.

Outro erro comum é confiar apenas na digitação manual.

Sempre utilize o recurso de autocompletar do NetBeans (`Ctrl + Espaço`) para reduzir erros de importação.

---

# 💼 Como as empresas trabalham?

Em projetos grandes é comum utilizar ferramentas como **Maven** ou **Gradle**.

Essas ferramentas gerenciam automaticamente as bibliotecas externas.

Mesmo assim, os imports continuam sendo necessários.

Ou seja:

- Maven baixa as bibliotecas.
- O import informa ao compilador quais classes serão utilizadas.

São responsabilidades diferentes.

---

# 🏛️ Arquitetura até aqui

```text
Conexao.java

│

├── import Connection

├── import DriverManager

└── import SQLException
```

Ainda não escrevemos nenhum método.

Estamos apenas preparando todas as ferramentas que utilizaremos nas próximas etapas.

---

# 🧠 Curiosidade

A plataforma Java possui milhares de classes organizadas em centenas de pacotes.

Alguns exemplos muito utilizados:

| Pacote        | Finalidade                    |
| ------------- | ----------------------------- |
| `java.lang`   | Linguagem básica              |
| `java.util`   | Coleções, datas e utilitários |
| `java.io`     | Arquivos                      |
| `java.time`   | Datas modernas                |
| `java.sql`    | Banco de dados                |
| `javax.swing` | Interface gráfica             |

Essa organização evita conflitos entre classes com o mesmo nome.

---

# 💡 Dica do Professor

Sempre que você encontrar um import desconhecido, pergunte:

> **"Que ferramenta esta classe está disponibilizando para mim?"**

Essa pergunta ajuda muito a entender bibliotecas novas.

---

# 📝 Resumo visual

```text
Connection

↓

Representa uma conexão aberta.

----------------------------

DriverManager

↓

Localiza o driver e cria a conexão.

----------------------------

SQLException

↓

Representa erros relacionados ao banco.
```

---

# 🏆 Mini desafio

Sem consultar o texto, responda:

1. O que faz a classe `Connection`?

2. Qual é a função do `DriverManager`?

3. O que representa uma `SQLException`?

4. O import copia código para o projeto?

5. Em qual pacote estão essas três classes?

---

# ✔️ Checklist de aprendizagem

Ao concluir esta seção eu consigo:

- [ ] Explicar o que é um import.
- [ ] Identificar o papel de cada classe importada.
- [ ] Diferenciar `Connection`, `DriverManager` e `SQLException`.
- [ ] Entender como a JVM localiza uma classe.
- [ ] Explicar o caminho até a criação de uma conexão JDBC.

---

# 🚀 Próxima etapa

Na Parte **2.2C**, começaremos a declarar os atributos da classe `Conexao`, entendendo detalhadamente a URL JDBC, o endereço do servidor, a porta, o nome do banco, o usuário, a senha e o significado de `private static final`, analisando cada palavra da declaração.

# 📘 Capítulo 4
# Parte 2.2C — Declarando os Atributos da Classe Conexao

---

# 🎯 Objetivos desta seção

Agora que já conheço os imports necessários, chegou o momento de configurar as informações que permitirão ao Java localizar e acessar o banco de dados.

Ao concluir esta seção, eu serei capaz de:

✅ Declarar os atributos da classe `Conexao`.

✅ Compreender o significado de `private`, `static` e `final`.

✅ Entender o formato da URL JDBC.

✅ Configurar corretamente o usuário e a senha.

✅ Conhecer boas práticas para armazenar informações de conexão.

---

# 🧠 Antes de começar...

Imagine que você deseja visitar um amigo.

Para chegar até a casa dele, você precisa saber:

- 📍 O endereço.
- 🚪 O número.
- 🏙️ A cidade.
- 🔑 A chave (ou alguém para abrir a porta).

Conectar-se a um banco de dados é muito parecido.

Precisamos informar ao Java:

- onde está o banco;
- qual banco acessar;
- quem está tentando entrar;
- qual é a senha.

Essas informações serão armazenadas em atributos da classe.

---

# 📦 Estrutura inicial

Nossa classe começará a ganhar forma.

```java
public class Conexao {

    private static final String URL = "...";

    private static final String USUARIO = "...";

    private static final String SENHA = "...";

}
```

À primeira vista parece complicado.

Mas veremos que cada palavra possui uma função muito clara.

---

# 🏛️ Diagrama UML atualizado

```text
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

Perceba que ainda não implementamos o método `conectar()`.

Estamos apenas definindo as informações necessárias para que ele funcione.

---

# 🔒 O modificador `private`

Vamos analisar a primeira palavra.

```java
private
```

Ela significa que o atributo só poderá ser acessado pela própria classe.

Imagine um cofre.

```text
┌───────────────┐
│     Cofre     │
│               │
│  Senha        │
└───────────────┘
```

Nem todas as pessoas podem abrir esse cofre.

Da mesma forma, outras classes não devem alterar diretamente os dados de conexão.

---

# 💡 Dica do Professor

Informações como usuário e senha do banco não devem ficar expostas para qualquer classe.

O modificador `private` ajuda a proteger esses dados.

---

# ⚙️ O modificador `static`

Agora observe a próxima palavra.

```java
static
```

Ela indica que o atributo pertence à **classe**, e não aos objetos criados a partir dela.

Imagine uma escola.

Existe apenas um endereço oficial.

Todos os alunos utilizam o mesmo endereço.

Não faria sentido que cada aluno tivesse uma cópia diferente desse endereço.

Da mesma forma, nossa aplicação utilizará uma única URL de conexão.

---

# 🧠 Por baixo dos panos

Quando um atributo é `static`, ele é carregado pela JVM quando a classe é carregada na memória.

Isso significa que existe apenas uma cópia desse atributo durante toda a execução da aplicação.

```text
Classe Conexao

↓

URL

↓

USUARIO

↓

SENHA
```

Independentemente de quantas vezes a classe seja utilizada, esses valores permanecem os mesmos.

---

# 🛡️ O modificador `final`

Agora chegamos à terceira palavra.

```java
final
```

Ela indica que o valor não poderá ser alterado depois de inicializado.

Por exemplo:

```java
private static final String URL = "...";
```

Depois que a aplicação iniciar, ninguém poderá modificar essa URL.

Isso evita alterações acidentais durante a execução.

---

# 📚 Juntando tudo

Observe novamente.

```java
private static final
```

Essa combinação significa:

- 🔒 `private` → somente a classe acessa.
- ⚙️ `static` → existe apenas uma cópia.
- 🛡️ `final` → o valor não pode ser alterado.

Essa é uma combinação muito utilizada para definir constantes em Java.

---

# 🌐 Declarando a URL

Agora vamos conhecer a primeira constante.

```java
private static final String URL =
    "jdbc:postgresql://localhost:5432/escola";
```

Essa linha informa ao Java onde está o banco de dados.

---

# 🧩 Anatomia da URL JDBC

Vamos dividir a URL em partes.

```text
jdbc:postgresql://localhost:5432/escola
```

Cada trecho possui um significado.

```text
jdbc:
```

Indica que utilizaremos a tecnologia JDBC.

---

```text
postgresql
```

Informa qual banco de dados será utilizado.

---

```text
localhost
```

É o endereço do servidor.

Quando utilizamos `localhost`, significa que o banco está instalado na mesma máquina onde a aplicação está sendo executada.

---

```text
5432
```

É a porta padrão utilizada pelo PostgreSQL.

Podemos imaginar a porta como o número de um apartamento em um prédio.

Mesmo conhecendo o endereço do prédio, ainda precisamos saber em qual apartamento entrar.

---

```text
escola
```

É o nome do banco de dados que criamos na Parte 1.

---

# 🗺️ Visualizando a URL

```text
jdbc

↓

postgresql

↓

localhost

↓

5432

↓

escola
```

Cada parte é indispensável para que a conexão seja estabelecida corretamente.

---

# 👤 Declarando o usuário

Agora adicionamos o usuário.

```java
private static final String USUARIO = "postgres";
```

Esse será o usuário utilizado para autenticar a conexão.

Na maioria das instalações do PostgreSQL, o usuário padrão é:

```text
postgres
```

Caso você tenha criado outro usuário, basta substituir esse valor.

---

# 🔑 Declarando a senha

Em seguida declaramos a senha.

```java
private static final String SENHA = "123456";
```

⚠️ **Importante**

Esse valor é apenas um exemplo.

Utilize a senha definida durante a instalação do PostgreSQL em seu computador.

---

# 🖼️ Configurando os atributos


::contentReference[oaicite:0]{index=0}


Essas referências ilustram onde normalmente encontramos as informações de conexão durante o desenvolvimento.

---

# 💼 Como isso é feito nas empresas?

Em aplicações profissionais, é incomum deixar usuário e senha escritos diretamente no código.

Normalmente essas informações ficam em arquivos de configuração, como:

- `application.properties`
- `application.yml`
- `.env`

Ou ainda são armazenadas em serviços especializados de gerenciamento de segredos.

Neste curso utilizaremos constantes na própria classe para simplificar o aprendizado.

Mais adiante conheceremos formas mais seguras de configuração.

---

# 🧪 Laboratório

Vamos fazer um pequeno experimento.

Altere temporariamente a porta da URL.

De:

```text
5432
```

Para:

```text
9999
```

Depois tente executar a aplicação.

O que acontecerá?

O Java tentará abrir a conexão, mas não encontrará um servidor escutando nessa porta.

Esse tipo de teste ajuda a compreender a importância de cada parte da URL.

Após o experimento, volte a porta para `5432`.

---

# ⚠️ Erros comuns

Alguns erros aparecem com frequência.

❌ Esquecer `jdbc:` no início da URL.

❌ Escrever `postgres` em vez de `postgresql`.

❌ Informar o nome errado do banco.

❌ Utilizar uma porta incorreta.

❌ Escrever usuário ou senha incorretos.

Todos esses erros impedirão a conexão com o banco.

---

# 🧠 Curiosidade

Embora o PostgreSQL utilize a porta **5432** por padrão, é possível alterar essa configuração durante a instalação ou posteriormente.

Se a porta do seu servidor for diferente, basta ajustar a URL da conexão.

---

# 📝 Resumo visual

```text
private

↓

Apenas a classe acessa.

--------------------------

static

↓

Uma única cópia.

--------------------------

final

↓

Valor constante.

--------------------------

URL

↓

Endereço do banco.

--------------------------

USUARIO

↓

Quem está acessando.

--------------------------

SENHA

↓

Autenticação.
```

---

# 🏆 Mini desafio

Sem consultar o texto, responda:

1. O que significa `private`?

2. Qual é a função do `static`?

3. O que impede a alteração do valor da URL?

4. O que representa `localhost`?

5. Qual é a porta padrão do PostgreSQL?

6. O que representa o trecho final da URL (`escola`)?

---

# ✔️ Checklist de aprendizagem

Ao concluir esta seção eu consigo:

- [ ] Explicar o significado de `private`.
- [ ] Explicar o significado de `static`.
- [ ] Explicar o significado de `final`.
- [ ] Montar corretamente uma URL JDBC.
- [ ] Configurar usuário e senha da conexão.
- [ ] Identificar os principais erros relacionados à configuração da conexão.

---

# 🚀 Próxima etapa

Na Parte **2.2D**, reuniremos tudo o que construímos até agora, visualizando a estrutura completa da classe `Conexao` antes de implementar o método `conectar()`.

Também analisaremos o código completo até esse ponto, interpretando cada linha e entendendo como todas as peças se encaixam para preparar a comunicação entre Java e PostgreSQL.

# 📘 Capítulo 4
# Parte 2.2D – Estrutura Final da Classe Conexao

---

# 🎯 Objetivos desta seção

Chegamos ao encerramento da construção estrutural da classe **Conexao**.

Até este momento, ainda não criamos nenhum método.

Nosso objetivo foi entender cada elemento da classe antes de escrever qualquer lógica de programação.

Ao concluir esta seção, eu serei capaz de:

- compreender toda a estrutura da classe;
- entender o papel de cada atributo;
- interpretar um diagrama UML completo;
- visualizar o ciclo de vida da classe dentro da JVM;
- preparar a implementação do método `conectar()`.

---

# 📚 O que construímos até agora?

Nossa classe possui apenas informações de configuração.

Observe novamente.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/escola";

    private static final String USUARIO = "postgres";

    private static final String SENHA = "123456";

}
```

Pode parecer pouco.

Mas toda a comunicação futura com o PostgreSQL dependerá exatamente dessa estrutura.

---

# 🔍 Interpretando o código linha por linha

Vamos analisar novamente.

```java
import java.sql.Connection;
```

Disponibiliza a classe responsável por representar uma conexão aberta.

---

```java
import java.sql.DriverManager;
```

Disponibiliza a classe que localizará o driver JDBC.

---

```java
import java.sql.SQLException;
```

Disponibiliza a classe responsável pelo tratamento de erros relacionados ao banco.

---

```java
public class Conexao
```

Define uma nova classe chamada **Conexao**.

---

```java
private static final String URL
```

Armazena o endereço do banco.

---

```java
private static final String USUARIO
```

Armazena o usuário de acesso.

---

```java
private static final String SENHA
```

Armazena a senha utilizada para autenticação.

---

# 📊 Diagrama UML completo

Neste momento nossa classe pode ser representada assim.

```text
┌─────────────────────────────────────────────┐
│                 Conexao                     │
├─────────────────────────────────────────────┤
│ - URL : String                             │
│ - USUARIO : String                         │
│ - SENHA : String                           │
├─────────────────────────────────────────────┤
│                                             │
│      (nenhum método implementado)          │
│                                             │
└─────────────────────────────────────────────┘
```

Observe que ainda não existe nenhum comportamento.

Ela apenas armazena informações.

---

# 🧠 O ciclo de vida da classe

Quando o programa iniciar, algo semelhante acontecerá.

```text
Programa iniciado

↓

JVM localiza Conexao.class

↓

Classe carregada

↓

Atributos static criados

↓

URL disponível

↓

USUARIO disponível

↓

SENHA disponível

↓

Classe pronta para uso
```

Perceba que nenhuma conexão foi aberta.

Apenas carregamos informações na memória.

---

# 🔬 Por baixo dos panos

Quando a JVM encontra uma classe que possui atributos `static`, ela executa um processo chamado **inicialização da classe**.

Nesse momento:

- reserva espaço para os atributos;
- inicializa seus valores;
- deixa tudo disponível para utilização.

Isso acontece apenas uma vez durante a execução da aplicação.

---

# 🖥️ Visualizando na memória

Podemos imaginar a memória assim.

```text
Memória da JVM

┌────────────────────────────┐
│ Classe Conexao             │
│                            │
│ URL                        │
│ USUARIO                    │
│ SENHA                      │
└────────────────────────────┘
```

Essas informações permanecerão disponíveis enquanto a aplicação estiver em execução.

---

# 🏛️ Arquitetura atual

Nosso projeto agora possui a seguinte estrutura.

```text
                Usuário

                    │

                    ▼

        TelaCadastroAluno

                    │

                    ▼

             Classe Aluno

                    │

                    ▼

             Classe Conexao

             ┌───────────────┐
             │ URL           │
             │ USUARIO       │
             │ SENHA         │
             └───────────────┘

                    │

            (Ainda sem conexão)

                    │

                    ▼

             PostgreSQL
```

Observe que ainda não existe comunicação.

Ela acontecerá apenas quando implementarmos o método `conectar()`.

---

# 💼 Como isso acontece nas empresas?

Em projetos profissionais, é comum separar as informações sensíveis da classe.

Por exemplo.

```text
application.properties

↓

URL

USUARIO

SENHA
```

A classe apenas lê essas informações.

Essa abordagem aumenta bastante a segurança.

Neste curso manteremos tudo dentro da classe para facilitar o aprendizado.

---

# ⚠️ Erro muito comum

Muitos alunos acreditam que apenas declarar:

```java
private static final String URL
```

já cria uma conexão.

Isso não acontece.

Essa linha apenas armazena um texto.

Nenhum contato com o PostgreSQL foi realizado até aqui.

---

# 💡 Dica do Professor

Sempre faça esta pergunta:

> "Meu programa já abriu uma conexão ou apenas armazenou as informações necessárias?"

Até este momento, apenas armazenamos informações.

---

# 🧠 Curiosidade

Em aplicações corporativas, uma mesma classe de conexão pode ser utilizada milhares de vezes por minuto.

Por isso ela costuma ser extremamente simples.

Quanto menos código existir nela, menores serão as chances de erros.

---

# 🧪 Laboratório

Experimente alterar temporariamente a URL.

```java
private static final String URL =
    "jdbc:postgresql://localhost:5432/teste";
```

Observe que:

- o projeto continua compilando normalmente;
- nenhum erro aparece imediatamente.

Isso acontece porque ainda não tentamos abrir a conexão.

Somente quando chamarmos o método `conectar()` o Java verificará se esse banco realmente existe.

Depois do teste, retorne o valor original.

---

# 📋 Estado atual da classe

```text
✔ Imports

✔ URL

✔ USUARIO

✔ SENHA

❌ Método conectar()

❌ Tratamento de exceções

❌ Abertura da conexão

❌ Retorno da Connection
```

Nossa estrutura está pronta.

Agora falta apenas ensinar a classe a abrir uma conexão.

---

# 📝 Resumo visual

```text
Conexao.java

↓

Imports

↓

Constantes

↓

Classe carregada

↓

Atributos disponíveis

↓

Aguardando chamada

↓

conectar()
```

---

# 🏆 Mini desafio

Sem consultar o texto, responda.

1. A conexão já foi aberta?

2. O que acontece quando a JVM carrega a classe?

3. Os atributos `static` são criados quantas vezes?

4. Alterar a URL gera erro imediatamente?

5. Qual será o próximo passo da implementação?

---

# ✔️ Checklist

Ao concluir esta seção eu consigo:

- [ ] Interpretar toda a estrutura da classe.
- [ ] Explicar o papel de cada atributo.
- [ ] Descrever o ciclo de vida da classe.
- [ ] Diferenciar configuração de conexão.
- [ ] Entender que ainda não existe comunicação com o banco.

---

# 🚀 Preparação para a Parte 2.3

Agora que nossa classe está completamente estruturada, finalmente começaremos a implementar seu comportamento.

Na próxima parte construiremos o método:

```java
public static Connection conectar()
```

Aprenderemos:

- como o DriverManager localiza o driver JDBC;
- como abrir uma conexão com o PostgreSQL;
- como utilizar `try` e `catch`;
- como tratar `SQLException`;
- como retornar um objeto `Connection`;
- como testar se a comunicação com o banco foi estabelecida com sucesso.

É nesse momento que nosso sistema fará sua primeira conexão real com o banco de dados.

