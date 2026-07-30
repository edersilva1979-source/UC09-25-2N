# 📘 Capítulo 4

# Parte 4.3 --- Boas Práticas para Atualização de Registros

## 🎯 Objetivos

Nesta etapa consolidarei o aprendizado sobre a operação **UPDATE**,
entendendo como evitar erros e aplicar boas práticas utilizadas em
sistemas profissionais.

Ao final desta seção, eu serei capaz de:

-   Validar dados antes da atualização;
-   Evitar alterações incorretas;
-   Compreender o fluxo seguro de atualização;
-   Preparar a aplicação para integração com o Java Swing.

------------------------------------------------------------------------

# 📖 O fluxo recomendado

Antes de atualizar um registro, o sistema deve seguir uma sequência
lógica.

``` text
Pesquisar aluno
      │
      ▼
Exibir dados atuais
      │
      ▼
Usuário realiza alterações
      │
      ▼
Validar informações
      │
      ▼
Executar UPDATE
      │
      ▼
Confirmar sucesso
```

------------------------------------------------------------------------

# ✅ O que devo validar?

Antes de executar o método `alterar()` verifique:

-   O ID foi informado?
-   O aluno realmente existe?
-   O nome não está vazio?
-   O e-mail possui um formato válido?
-   A turma foi preenchida?

Essas validações evitam registros inconsistentes.

------------------------------------------------------------------------

# 💻 Exemplo de validação simples

``` java
if (aluno.getNome().trim().isEmpty()) {
    System.out.println("O nome é obrigatório.");
    return;
}

if (aluno.getEmail().trim().isEmpty()) {
    System.out.println("O e-mail é obrigatório.");
    return;
}
```

------------------------------------------------------------------------

# 🏛️ Arquitetura recomendada

``` text
Tela Java Swing
        │
        ▼
Validação dos dados
        │
        ▼
AlunoDAO.alterar()
        │
        ▼
Conexao
        │
        ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Mesmo que o banco aceite a atualização, cabe à aplicação impedir que
informações inválidas sejam enviadas.

Quanto mais cedo um erro for identificado, mais fácil será corrigi-lo.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Aplicações profissionais costumam utilizar múltiplas camadas de
validação:

1.  Interface gráfica (campos obrigatórios).
2.  Regras de negócio.
3.  Banco de dados (restrições como `NOT NULL` e `UNIQUE`).

Assim, a qualidade dos dados é preservada.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Atualizar um registro sem pesquisar antes.
-   Permitir campos obrigatórios vazios.
-   Não informar mensagens claras ao usuário.
-   Ignorar o retorno de `executeUpdate()`.

------------------------------------------------------------------------

# 🧪 Laboratório

Realize os testes abaixo:

1.  Atualize um aluno com dados válidos.
2.  Tente atualizar um aluno sem informar o nome.
3.  Informe um ID inexistente.
4.  Observe o comportamento da aplicação em cada cenário.

------------------------------------------------------------------------

# 💡 Dica do Professor

Nunca confie apenas nos dados digitados pelo usuário. Sempre faça
validações antes de enviar qualquer informação ao banco de dados.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Pesquisar
    │
Validar
    │
UPDATE
    │
Confirmar
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Implemente uma validação que impeça a atualização quando o e-mail não
contiver o caractere `@`.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Validar os dados antes do UPDATE.
-   [ ] Confirmar que o registro existe.
-   [ ] Informar mensagens claras ao usuário.
-   [ ] Aplicar boas práticas de atualização.
-   [ ] Preparar a lógica para integração com o Java Swing.

------------------------------------------------------------------------

# 🚀 Próxima etapa

Na **Parte 5**, iniciarei a última operação do CRUD: **DELETE**,
aprendendo a remover registros com segurança utilizando
`PreparedStatement` e a cláusula `WHERE`.
