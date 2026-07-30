# 📘 Capítulo 4

# Parte 6 --- Revisão Geral do CRUD com Java, JDBC e PostgreSQL

## 🎯 Objetivos

Nesta etapa vou revisar tudo o que aprendi durante este capítulo,
conectando todos os conceitos em um único fluxo de trabalho.

Ao final desta revisão, eu serei capaz de:

-   Entender o funcionamento completo do CRUD;
-   Reconhecer a responsabilidade de cada classe do projeto;
-   Compreender o fluxo entre Java e PostgreSQL;
-   Identificar boas práticas para projetos profissionais;
-   Estar preparado para desenvolver uma interface gráfica com Java
    Swing.

------------------------------------------------------------------------

# 🧩 A arquitetura completa do projeto

``` text
                Usuário
                   │
                   ▼
        Classe de Teste / Java Swing
                   │
                   ▼
              Classe Aluno
                   │
                   ▼
              Classe AlunoDAO
                   │
                   ▼
             Classe Conexao
                   │
                   ▼
              PostgreSQL
```

Cada classe possui uma responsabilidade específica:

  Classe            Responsabilidade
  ----------------- -------------------------------------------
  `Aluno`           Representar os dados do aluno
  `AlunoDAO`        Executar operações no banco de dados
  `Conexao`         Abrir e fechar a conexão com o PostgreSQL
  Classe de Teste   Validar o funcionamento das operações

------------------------------------------------------------------------

# 📚 Revisando o CRUD

## ✅ CREATE

``` text
INSERT INTO alunos (...)
```

Cadastra um novo aluno.

------------------------------------------------------------------------

## ✅ READ

``` text
SELECT * FROM alunos
```

Consulta registros existentes.

Também aprendi a pesquisar por ID utilizando:

``` sql
SELECT * FROM alunos
WHERE id = ?;
```

------------------------------------------------------------------------

## ✅ UPDATE

``` text
UPDATE alunos
SET ...
WHERE id = ?;
```

Atualiza apenas o registro selecionado.

------------------------------------------------------------------------

## ✅ DELETE

``` text
DELETE FROM alunos
WHERE id = ?;
```

Remove apenas o registro informado.

------------------------------------------------------------------------

# 🔄 Fluxo completo de uma operação

``` text
Usuário
   │
   ▼
Objeto Aluno
   │
   ▼
AlunoDAO
   │
   ▼
Conexao
   │
   ▼
PreparedStatement
   │
   ▼
PostgreSQL
   │
   ▼
Resultado
   │
   ▼
Usuário
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Sempre que uma operação é executada:

1.  O Java cria ou utiliza um objeto.
2.  O DAO monta o comando SQL.
3.  O JDBC envia a instrução ao PostgreSQL.
4.  O banco executa a operação.
5.  O resultado retorna para a aplicação.
6.  O usuário recebe uma mensagem de sucesso ou erro.

------------------------------------------------------------------------

# 💼 Como as empresas organizam projetos?

Projetos profissionais normalmente utilizam uma arquitetura em camadas:

``` text
Interface (Swing)
      │
      ▼
Regras de Negócio
      │
      ▼
DAO
      │
      ▼
Banco de Dados
```

Essa organização facilita manutenção, testes e evolução do sistema.

------------------------------------------------------------------------

# ⚠️ Principais erros cometidos por iniciantes

-   Misturar SQL com código da interface gráfica.
-   Não fechar conexões.
-   Esquecer de utilizar `PreparedStatement`.
-   Não tratar exceções.
-   Executar `UPDATE` ou `DELETE` sem `WHERE`.
-   Não validar os dados antes de gravar.

------------------------------------------------------------------------

# 🧪 Laboratório Final

Execute todas as operações na sequência:

1.  Cadastre dois alunos.
2.  Liste todos os alunos.
3.  Localize um aluno pelo ID.
4.  Atualize os dados desse aluno.
5.  Liste novamente os registros.
6.  Exclua um aluno.
7.  Consulte a tabela para confirmar o resultado.

------------------------------------------------------------------------

# 💡 Dica do Professor

Sempre teste cada operação separadamente antes de integrá-la à interface
gráfica. Essa prática facilita a depuração e torna o desenvolvimento
muito mais organizado.

------------------------------------------------------------------------

# 📝 Resumo Geral

``` text
CREATE  → INSERT
READ    → SELECT
UPDATE  → UPDATE
DELETE  → DELETE
```

Essas quatro operações formam a base da maioria dos sistemas utilizados
no mercado.

------------------------------------------------------------------------

# 🏆 Desafio Final

Desenvolva um pequeno sistema em modo console que permita ao usuário:

-   Cadastrar alunos;
-   Listar todos os alunos;
-   Localizar um aluno por ID;
-   Alterar um cadastro;
-   Excluir um cadastro;
-   Encerrar o programa.

Utilize um menu simples e reaproveite todas as classes criadas neste
capítulo.

------------------------------------------------------------------------

# ✔️ Checklist Final

-   [ ] Criar conexão com PostgreSQL.
-   [ ] Implementar INSERT.
-   [ ] Implementar SELECT.
-   [ ] Implementar UPDATE.
-   [ ] Implementar DELETE.
-   [ ] Testar todas as operações.
-   [ ] Aplicar boas práticas de JDBC.
-   [ ] Organizar o projeto em classes.

------------------------------------------------------------------------

# 🎉 Conclusão do Capítulo

Parabéns! 🚀

Neste capítulo eu construí um sistema completo de persistência de dados
utilizando **Java**, **JDBC** e **PostgreSQL**. Aprendi a criar
conexões, implementar o CRUD completo, testar cada operação e aplicar
boas práticas utilizadas no mercado.

No próximo capítulo, darei um grande passo: transformarei esse projeto
em uma aplicação **Java Swing**, criando telas profissionais com botões,
formulários, tabelas (`JTable`) e integração completa com o banco de
dados.
