# 📘 Capítulo 4

# Parte 5.3 --- Boas Práticas para Exclusão de Registros

## 🎯 Objetivos

Nesta etapa vou consolidar tudo o que aprendi sobre a operação
**DELETE**, entendendo como remover registros de forma segura,
organizada e profissional.

Ao final desta seção, eu serei capaz de:

-   Aplicar boas práticas durante exclusões;
-   Evitar perda acidental de dados;
-   Preparar minhas aplicações para integração com Java Swing;
-   Compreender como sistemas reais tratam exclusões.

------------------------------------------------------------------------

# 📖 O fluxo recomendado

Antes de excluir um registro, uma aplicação profissional normalmente
segue esta sequência:

``` text
Pesquisar registro
       │
       ▼
Exibir informações
       │
       ▼
Solicitar confirmação
       │
       ▼
Executar DELETE
       │
       ▼
Atualizar a tela
```

Essa abordagem reduz erros e melhora a experiência do usuário.

------------------------------------------------------------------------

# ✅ O que devo verificar antes da exclusão?

Antes de chamar o método `excluir(int id)`, confirme:

-   O ID informado é válido?
-   O registro realmente existe?
-   O usuário confirmou a exclusão?
-   Existem regras de negócio que impedem a remoção?

Quanto mais validações forem feitas, menor será a chance de excluir um
registro incorretamente.

------------------------------------------------------------------------

# 💻 Exemplo de confirmação simples

``` java
System.out.println("Deseja realmente excluir este aluno?");

boolean confirmar = true;

if (!confirmar) {
    return;
}

dao.excluir(id);
```

> Nas próximas aulas, essa confirmação será feita por meio de uma caixa
> de diálogo do Java Swing.

------------------------------------------------------------------------

# 🏛️ Arquitetura recomendada

``` text
Tela Java Swing
        │
        ▼
Pesquisar aluno
        │
        ▼
Confirmar exclusão
        │
        ▼
AlunoDAO.excluir(id)
        │
        ▼
Conexao
        │
        ▼
PostgreSQL
```

------------------------------------------------------------------------

# 🔬 Por baixo dos panos

Quando o comando `DELETE` é executado:

1.  O JDBC envia a instrução ao PostgreSQL.
2.  O banco procura o registro informado.
3.  Se o registro existir, ele é removido.
4.  O banco devolve a quantidade de linhas afetadas.
5.  O Java informa ao usuário se a operação foi realizada com sucesso.

------------------------------------------------------------------------

# 💼 Como as empresas fazem?

Em sistemas corporativos, é comum encontrar duas estratégias:

## Exclusão física

O registro é realmente removido da tabela.

## Exclusão lógica

O registro permanece armazenado, mas recebe um status como:

``` text
ATIVO = FALSE
```

ou

``` text
STATUS = INATIVO
```

Essa abordagem facilita auditorias e recuperação de informações.

------------------------------------------------------------------------

# ⚠️ Erros comuns

-   Excluir sem confirmar com o usuário.
-   Não verificar se o registro existe.
-   Executar `DELETE` sem a cláusula `WHERE`.
-   Não atualizar a tabela após a exclusão.
-   Não registrar a operação em sistemas que exigem auditoria.

------------------------------------------------------------------------

# 🧪 Laboratório

Realize os testes abaixo:

1.  Exclua um aluno existente.
2.  Consulte a tabela.
3.  Tente excluir novamente o mesmo ID.
4.  Analise a mensagem exibida.
5.  Discuta quando seria melhor utilizar exclusão lógica.

------------------------------------------------------------------------

# 💡 Dica do Professor

Em aplicações reais, excluir um registro é uma operação delicada. Sempre
confirme a ação e registre o que foi feito quando o sistema exigir
rastreabilidade.

------------------------------------------------------------------------

# 📝 Resumo

``` text
Pesquisar
    │
Confirmar
    │
DELETE
    │
Atualizar tela
```

------------------------------------------------------------------------

# 🏆 Mini desafio

Pesquise a diferença entre **exclusão física** e **exclusão lógica** e
escreva um pequeno texto explicando em quais situações cada uma delas é
mais indicada.

------------------------------------------------------------------------

# ✔️ Checklist

-   [ ] Entender o fluxo seguro de exclusão.
-   [ ] Validar o registro antes de remover.
-   [ ] Solicitar confirmação ao usuário.
-   [ ] Conhecer exclusão física e lógica.
-   [ ] Preparar a aplicação para o Java Swing.

------------------------------------------------------------------------

# 🎉 Encerramento da etapa CRUD

Parabéns!

Agora eu já sei implementar as quatro operações fundamentais de um
sistema utilizando **Java, JDBC e PostgreSQL**:

-   ✅ INSERT
-   ✅ SELECT
-   ✅ UPDATE
-   ✅ DELETE

Com essa base, estou preparado para evoluir o projeto para uma interface
gráfica em **Java Swing**, criando um sistema completo de cadastro com
telas, botões, tabelas e integração com banco de dados.
