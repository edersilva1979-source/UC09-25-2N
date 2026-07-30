# 📘 Capítulo 5

# Parte 5 --- Criando a Tela de Cadastro de Aluno (Java Swing)

## 🎯 Objetivos

Nesta etapa vou criar a primeira interface gráfica do projeto utilizando
**Java Swing** no NetBeans.

Ao final desta aula, eu serei capaz de:

-   Criar um `JFrame Form`;
-   Adicionar componentes visuais;
-   Organizar a tela utilizando o editor visual do NetBeans;
-   Preparar a interface para integração com o PostgreSQL.

------------------------------------------------------------------------

# 📖 Por que utilizar o Java Swing?

Até agora toda a interação aconteceu pelo console.

Agora vou permitir que o usuário utilize uma interface gráfica com
botões, caixas de texto e mensagens, tornando o sistema mais
profissional.

------------------------------------------------------------------------

# 🏗️ Criando o projeto

1.  Abra o NetBeans.
2.  Clique em **File → New Project**.
3.  Escolha **Java with Ant → Java Application** (ou o modelo utilizado
    no curso).
4.  Utilize o projeto criado anteriormente.

------------------------------------------------------------------------

# 📁 Criando o formulário

No pacote **view**:

**New → JFrame Form**

Nome:

``` text
TelaCadastroAluno
```

------------------------------------------------------------------------

# 🖼️ Componentes da tela

  Componente   Nome (variable)   Função
  ------------ ----------------- ------------------------
  JLabel       lblTitulo         Título da tela
  JLabel       lblId             Identificação
  JLabel       lblNome           Nome
  JLabel       lblTurma          Turma
  JLabel       lblEmail          E-mail
  JTextField   txtId             ID
  JTextField   txtNome           Nome
  JTextField   txtTurma          Turma
  JTextField   txtEmail          E-mail
  JButton      btnCadastrar      Salvar aluno
  JButton      btnLimpar         Limpar campos
  JButton      btnConsulta       Abrir tela de consulta
  JButton      btnSair           Encerrar aplicação

------------------------------------------------------------------------

# 🎨 Sugestão de layout

``` text
+------------------------------------------------------+
|            CADASTRO DE ALUNOS                        |
+------------------------------------------------------+

 ID:      [____________]

 Nome:    [______________________________]

 Turma:   [______________________________]

 E-mail:  [______________________________]

 [Cadastrar] [Limpar] [Consulta] [Sair]

+------------------------------------------------------+
```

------------------------------------------------------------------------

# 🧩 Organização dos componentes

## Labels

Servem para identificar cada campo.

## JTextField

Recebem as informações digitadas pelo usuário.

## JButton

Executam ações quando clicados.

------------------------------------------------------------------------

# 🔄 Fluxo da tela

``` text
Usuário
   │
   ▼
Digita informações
   │
   ▼
Clica em Cadastrar
   │
   ▼
Evento do botão
   │
   ▼
AlunoDAO.cadastrar()
   │
   ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Ao utilizar um **JFrame Form**, o NetBeans gera automaticamente parte do
código responsável por criar e posicionar os componentes.

Esse código normalmente fica dentro do método `initComponents()` e não
deve ser alterado manualmente, pois o editor visual é responsável por
mantê-lo sincronizado.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Projetos profissionais costumam separar a aplicação em pacotes:

``` text
model
dao
view
util
```

Assim, a interface gráfica permanece organizada e desacoplada da lógica
de acesso ao banco de dados.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Alterar manualmente o método `initComponents()`.
-   Utilizar nomes genéricos como `jButton1`.
-   Misturar código SQL dentro da tela.
-   Não organizar os componentes visualmente.

------------------------------------------------------------------------

# 🧪 Laboratório

1.  Crie o formulário.
2.  Adicione todos os componentes.
3.  Renomeie as variáveis.
4.  Organize a interface.
5.  Execute a aplicação para verificar se a janela abre corretamente.

------------------------------------------------------------------------

# 💡 Dica do Professor

Utilize nomes significativos para todos os componentes (`txtNome`,
`btnCadastrar`, `lblEmail`). Isso facilita a leitura do código e a
manutenção do projeto.

------------------------------------------------------------------------

# 📝 Resumo

``` text
JFrame
   │
JLabels
   │
JTextFields
   │
JButtons
   │
Tela pronta para programação
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Personalize a tela:

-   Altere o título da janela;
-   Defina um ícone para o projeto (opcional);
-   Centralize a janela na tela;
-   Escolha uma fonte maior para o título.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Criar o JFrame Form.
-   [ ] Inserir Labels.
-   [ ] Inserir JTextFields.
-   [ ] Inserir JButtons.
-   [ ] Renomear os componentes.
-   [ ] Organizar o layout.
-   [ ] Executar a janela.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5.1**, programarei o botão **Cadastrar**, capturando os dados
digitados nos campos, criando um objeto `Aluno` e utilizando o método
`AlunoDAO.cadastrar()` para gravar as informações no PostgreSQL.
