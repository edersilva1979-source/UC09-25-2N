# Java Desktop Profissional com NetBeans e PostgreSQL

# Capítulo 1 -- Preparação do Ambiente e Primeiro Projeto

## Parte 2 -- Instalando e Configurando o Ambiente de Desenvolvimento

> **Objetivo desta parte:** preparar todo o ambiente necessário para
> desenvolver aplicações Java Desktop durante o curso.

------------------------------------------------------------------------

# Introdução

Antes de escrever qualquer linha de código, precisamos preparar nosso
ambiente de trabalho.

Assim como um carpinteiro organiza suas ferramentas antes de construir
um móvel, o desenvolvedor precisa instalar e configurar corretamente
seus programas.

Ao final desta etapa você terá um ambiente profissional pronto para
desenvolver o Projeto Integrador.

------------------------------------------------------------------------

# Ferramentas Utilizadas

  Ferramenta   Finalidade
  ------------ ------------------------------------
  JDK          Compilar e executar programas Java
  NetBeans     Escrever e organizar o código
  PostgreSQL   Armazenar os dados do sistema
  pgAdmin      Administrar o banco de dados

------------------------------------------------------------------------

# Como as Ferramentas Trabalham Juntas

``` text
Desenvolvedor
      │
      ▼
NetBeans
      │
      ▼
Código Java
      │
      ▼
JDK
      │
      ▼
Aplicação Desktop
      │
      ▼
PostgreSQL
      │
      ▼
Dados do Sistema
```

------------------------------------------------------------------------

# Instalando o JDK

## O que é o JDK?

O **Java Development Kit** é o conjunto de ferramentas utilizado para
desenvolver aplicações Java.

Sem ele não é possível compilar nem executar programas.

## O que ele contém?

-   Compilador (`javac`)
-   Máquina Virtual Java (JVM)
-   Bibliotecas padrão
-   Ferramentas de desenvolvimento

💡 **Dica:** instale sempre uma versão LTS ou a versão definida pelo
professor para evitar incompatibilidades.

------------------------------------------------------------------------

# Verificando a Instalação

Abra o Prompt de Comando e execute:

``` bash
java -version
```

Depois:

``` bash
javac -version
```

Se ambos retornarem uma versão instalada, o JDK está funcionando
corretamente.

⚠ **Erro comum:** instalar apenas o JRE. Para desenvolver aplicações é
necessário o **JDK**.

------------------------------------------------------------------------

# Instalando o NetBeans

O NetBeans será nossa IDE durante todo o curso.

Ele facilita tarefas como:

-   criação de projetos
-   organização dos arquivos
-   compilação
-   depuração
-   execução

## Conhecendo a Interface

``` text
┌──────────────────────────────┐
│ Barra de Menus               │
├───────────────┬──────────────┤
│ Projetos      │ Editor       │
│ Arquivos      │ de Código    │
│ Serviços      │              │
├───────────────┴──────────────┤
│ Console de Saída             │
└──────────────────────────────┘
```

------------------------------------------------------------------------

# Instalando o PostgreSQL

O PostgreSQL armazenará todas as informações do Sistema Comercial.

Durante a instalação observe:

-   Usuário padrão: `postgres`
-   Porta padrão: `5432`
-   Senha definida por você

⚠ Guarde a senha em local seguro. Ela será utilizada nas próximas aulas.

------------------------------------------------------------------------

# Conhecendo o pgAdmin

O pgAdmin é uma interface gráfica para administrar o PostgreSQL.

Com ele poderemos:

-   criar bancos
-   criar tabelas
-   executar comandos SQL
-   fazer backup

------------------------------------------------------------------------

# Verificando o PostgreSQL

Após abrir o pgAdmin, confirme se o servidor está disponível.

Estrutura esperada:

``` text
Servers
 └── PostgreSQL
      └── Databases
```

Se essa estrutura aparecer, o banco está pronto para uso.

------------------------------------------------------------------------

# Organização das Pastas

Crie uma pasta exclusiva para os projetos do curso.

Exemplo:

``` text
Cursos
└── JavaDesktop
    ├── Aula01
    ├── Aula02
    ├── Aula03
    └── ProjetoIntegrador
```

💡 Manter uma organização consistente facilita a manutenção dos
projetos.

------------------------------------------------------------------------

# Primeira Configuração do Projeto Integrador

No NetBeans:

1.  Novo Projeto.
2.  Java Application.
3.  Nome: **SistemaComercial**.
4.  Escolha a pasta `ProjetoIntegrador`.

Ainda não escreveremos código. Nosso objetivo é preparar a estrutura que
será utilizada durante todo o curso.

------------------------------------------------------------------------

# Dicas do Professor

-   Utilize nomes de projetos claros.
-   Evite espaços e caracteres especiais.
-   Faça backup dos projetos regularmente.
-   Mantenha uma única versão do JDK instalada durante o curso.

------------------------------------------------------------------------

# Erros Mais Comuns

❌ Instalar apenas o JRE.

❌ Esquecer a senha do PostgreSQL.

❌ Criar projetos em locais diferentes.

❌ Alterar manualmente a estrutura das pastas do projeto.

------------------------------------------------------------------------

# Exercício Guiado

1.  Verifique a versão do Java.
2.  Abra o NetBeans.
3.  Crie o projeto `SistemaComercial`.
4.  Abra o pgAdmin.
5.  Confirme que o servidor PostgreSQL está ativo.

Marque cada etapa concluída.

------------------------------------------------------------------------

# Resumo da Parte 2

Nesta etapa você:

-   instalou o JDK;
-   conheceu o NetBeans;
-   preparou o PostgreSQL;
-   verificou o pgAdmin;
-   criou a estrutura inicial do Projeto Integrador.

Na Parte 3 escreveremos o primeiro código do **Sistema Comercial**,
entenderemos a estrutura de um projeto Java e analisaremos cada linha do
programa.
