# Projeto Integrador FerragemGK

![Logo](Logo.png)

## Java Swing com PostgreSQL

Neste projeto, nós vamos desenvolver juntos uma aplicação completa para uma loja de ferragens utilizando Java, Java Swing, NetBeans e PostgreSQL.

A ideia é construir um sistema que vá muito além de um simples cadastro.

Nós vamos trabalhar com interface gráfica, banco de dados, autenticação, níveis de acesso, cadastros, consultas, compras, vendas, estoque, contas a pagar, contas a receber e baixa financeira.

Durante o desenvolvimento, nós vamos aprender a organizar uma aplicação em partes, separar responsabilidades e aplicar regras de negócio semelhantes às encontradas em sistemas comerciais reais.

O nosso sistema será chamado:

```text
FerragemGK
```

---

# 1. Objetivo do projeto

O nosso objetivo será construir uma aplicação Java Desktop completa para gerenciamento de uma loja de ferragens.

Nós vamos criar uma tela de login para controlar o acesso ao sistema.

Depois do login, nós vamos abrir uma tela principal com menus e um `JDesktopPane`.

Dentro desse desktop, nós vamos abrir diversas telas utilizando `JInternalFrame`.

As telas de cadastro serão organizadas com `JTabbedPane`.

Em cada cadastro, nós vamos utilizar duas abas principais.

```text
Cadastro
Consulta
```

Na aba Cadastro, nós vamos inserir e alterar os dados.

Na aba Consulta, nós vamos listar registros em uma `JTable`, localizar informações, aplicar filtros, selecionar registros, alterar dados e excluir quando o usuário possuir permissão.

Além dos cadastros, nós vamos desenvolver os movimentos de compra e venda.

As compras poderão gerar automaticamente contas a pagar.

As vendas poderão gerar automaticamente contas a receber.

Para finalizar, nós vamos desenvolver o processo de baixa das contas.

---

# 2. Tecnologias que nós vamos utilizar

Durante o projeto, nós vamos trabalhar principalmente com:

* Java
* Java Swing
* NetBeans
* PostgreSQL
* pgAdmin
* JDBC
* Programação Orientada a Objetos
* SQL
* PreparedStatement
* ResultSet
* Transações com commit e rollback

Na interface gráfica, nós vamos utilizar vários componentes do Swing.

Entre eles:

```text
JFrame
JDesktopPane
JInternalFrame
JTabbedPane
JTable
JComboBox
JTextField
JFormattedTextField
JPasswordField
JMenuBar
JMenu
JMenuItem
JButton
JLabel
JSpinner
JOptionPane
```

Durante o desenvolvimento, nós vamos aprender não apenas como utilizar cada componente, mas também quando ele deve ser utilizado.

---

# 3. Organização do projeto

Nós vamos organizar o projeto em pacotes.

Essa organização será importante para que o nosso código não fique concentrado dentro das telas.

A estrutura inicial será semelhante a esta:

```text
FerragemGK
│
├── conexao
│   └── Conexao.java
│
├── model
│   ├── Usuario.java
│   ├── Cliente.java
│   ├── Fornecedor.java
│   ├── Produto.java
│   ├── Venda.java
│   ├── ProdutoVenda.java
│   ├── Compra.java
│   ├── ProdutoCompra.java
│   ├── ContaPagar.java
│   └── ContaReceber.java
│
├── dao
│   ├── UsuarioDAO.java
│   ├── ClienteDAO.java
│   ├── FornecedorDAO.java
│   ├── ProdutoDAO.java
│   ├── VendaDAO.java
│   ├── CompraDAO.java
│   ├── ContaPagarDAO.java
│   └── ContaReceberDAO.java
│
├── service
│   ├── VendaService.java
│   ├── CompraService.java
│   └── FinanceiroService.java
│
├── view
│   ├── FrmLogin.java
│   ├── FrmPrincipal.java
│   ├── FrmUsuario.java
│   ├── FrmCliente.java
│   ├── FrmFornecedor.java
│   ├── FrmProduto.java
│   ├── FrmVenda.java
│   ├── FrmCompra.java
│   ├── FrmContasPagar.java
│   └── FrmContasReceber.java
│
└── util
    ├── SessaoUsuario.java
    ├── Permissao.java
    └── Validacao.java
```

Nós vamos desenvolver essa estrutura aos poucos.

O objetivo não será criar todos os arquivos de uma única vez.

Nós vamos construir cada parte conforme a necessidade do sistema aparecer.

---

# 4. Banco de dados FerragemGK

Nós vamos criar um banco de dados chamado:

```text
FerragemGK
```

Dentro dele, nós vamos criar as seguintes tabelas:

```text
usuario
cliente
fornecedor
produto
venda
compra
produtos_venda
produtos_compra
contas_pagar
contas_receber
```

Essas tabelas estarão relacionadas entre si.

---

# 5. Relacionamentos principais

Nós vamos trabalhar com dois grandes fluxos.

O primeiro será o fluxo de vendas.

```text
CLIENTE
   │
   └── VENDA
          │
          ├── PRODUTOS_VENDA
          │        │
          │        └── PRODUTO
          │
          └── CONTAS_RECEBER
```

O segundo será o fluxo de compras.

```text
FORNECEDOR
   │
   └── COMPRA
          │
          ├── PRODUTOS_COMPRA
          │        │
          │        └── PRODUTO
          │
          └── CONTAS_PAGAR
```

Com isso, nós vamos trabalhar na prática com chave primária, chave estrangeira, relacionamento entre tabelas e integridade dos dados.

---

# 6. Tabela Usuario

Nós vamos criar uma tabela para armazenar os usuários que poderão entrar no sistema.

Ela poderá possuir os seguintes campos:

```text
id_usuario
nome
login
senha
nivel
ativo
```

Nós vamos trabalhar com dois níveis de acesso:

```text
MASTER
USER
```

O usuário MASTER terá acesso completo ao sistema.

O usuário USER terá algumas limitações.

---

# 7. Tabela Cliente

Nós vamos criar uma tabela para armazenar os clientes da loja.

Ela poderá possuir campos como:

```text
id_cliente
nome
cpf
telefone
email
endereco
cidade
uf
cep
ativo
```

Posteriormente, nós vamos utilizar essa tabela durante o processo de venda.

---

# 8. Tabela Fornecedor

Nós vamos criar uma tabela para armazenar os fornecedores.

Ela poderá possuir:

```text
id_fornecedor
razao_social
nome_fantasia
cnpj
telefone
email
endereco
cidade
uf
cep
ativo
```

Nós vamos utilizar os fornecedores principalmente durante o movimento de compra.

---

# 9. Tabela Produto

Nós vamos criar uma tabela responsável pelos produtos da ferragem.

Ela poderá possuir:

```text
id_produto
descricao
unidade
preco_custo
preco_venda
estoque
estoque_minimo
ativo
```

O campo `estoque` será atualizado automaticamente durante compras e vendas.

O campo `estoque_minimo` poderá ser utilizado para identificar produtos que precisam de reposição.

---

# 10. Tabela Venda

Nós vamos registrar cada venda realizada.

A tabela poderá possuir:

```text
id_venda
id_cliente
id_usuario
data_venda
forma_pagamento
quantidade_parcelas
valor_total
status
```

Cada venda estará relacionada a um cliente e ao usuário que realizou a operação.

---

# 11. Tabela Produtos Venda

Uma venda poderá possuir vários produtos.

Por isso, nós vamos criar uma tabela específica para os itens vendidos.

```text
id_produto_venda
id_venda
id_produto
quantidade
valor_unitario
subtotal
```

Essa tabela fará a ligação entre Venda e Produto.

---

# 12. Tabela Compra

Nós também vamos registrar as compras realizadas junto aos fornecedores.

Ela poderá possuir:

```text
id_compra
id_fornecedor
id_usuario
data_compra
forma_pagamento
quantidade_parcelas
valor_total
status
```

---

# 13. Tabela Produtos Compra

Cada compra poderá possuir vários produtos.

Nós vamos criar:

```text
id_produto_compra
id_compra
id_produto
quantidade
valor_unitario
subtotal
```

Essa tabela fará a ligação entre Compra e Produto.

---

# 14. Tabela Contas a Pagar

Quando uma compra for parcelada, nós vamos gerar automaticamente registros no contas a pagar.

A tabela poderá possuir:

```text
id_conta_pagar
id_compra
numero_parcela
data_emissao
data_vencimento
valor_parcela
valor_pago
data_pagamento
status
```

---

# 15. Tabela Contas a Receber

Quando uma venda for parcelada, nós vamos gerar automaticamente registros no contas a receber.

A tabela poderá possuir:

```text
id_conta_receber
id_venda
numero_parcela
data_emissao
data_vencimento
valor_parcela
valor_pago
data_recebimento
status
```

---

# 16. Status financeiros

Nós vamos utilizar situações para identificar o estado de cada conta.

Poderemos trabalhar com:

```text
ABERTA
PAGA
RECEBIDA
CANCELADA
VENCIDA
```

Assim, nós vamos saber rapidamente se uma conta ainda precisa ser paga ou recebida.

---

# 17. Tela de Login

A primeira tela do sistema será:

```text
FrmLogin
```

Nós vamos criar campos para:

```text
Usuário
Senha
```

E botões como:

```text
Entrar
Sair
```

Quando clicarmos em Entrar, nós vamos consultar o PostgreSQL para verificar se o usuário existe, se a senha está correta e se o usuário está ativo.

Conceitualmente, nós teremos algo semelhante a:

```java
Usuario usuario = usuarioDAO.autenticar(login, senha);
```

Se o usuário for encontrado, nós vamos armazenar suas informações em uma sessão.

```java
SessaoUsuario.setUsuario(usuario);
```

Depois disso, nós vamos abrir a tela principal.

```text
FrmPrincipal
```

---

# 18. Sessão do usuário

Nós vamos criar uma classe para guardar temporariamente as informações do usuário conectado.

Essa classe será importante porque várias telas precisarão saber:

```text
Quem está conectado
Qual é o nível do usuário
Se ele possui determinada permissão
```

Assim, nós não precisaremos consultar novamente o banco a cada botão pressionado.

---

# 19. Nível MASTER

O usuário MASTER poderá realizar praticamente todas as operações.

Nós vamos permitir:

```text
Cadastrar
Consultar
Alterar
Excluir
Comprar
Vender
Acessar contas a pagar
Acessar contas a receber
Dar baixa em contas
Cadastrar usuários
```

O MASTER será o usuário administrativo do sistema.

---

# 20. Nível USER

O usuário USER poderá utilizar normalmente os principais recursos operacionais.

Ele poderá:

```text
Cadastrar clientes
Cadastrar fornecedores
Cadastrar produtos
Consultar registros
Alterar registros permitidos
Realizar compras
Realizar vendas
Consultar contas a receber quando permitido
```

Entretanto, o USER não poderá excluir cadastros.

Ele também não poderá acessar diretamente o módulo de contas a pagar.

Uma compra realizada por um USER ainda poderá gerar contas a pagar automaticamente.

Nesse caso, o próprio sistema fará a geração.

O que o USER não poderá fazer será administrar diretamente essas contas posteriormente.

---

# 21. Controle das permissões

Nós vamos aprender que não basta esconder ou desabilitar um botão.

Nós vamos aplicar a permissão em mais de um ponto do sistema.

Na interface, poderemos desabilitar um botão.

```java
btnExcluir.setEnabled(false);
```

Também vamos validar a permissão antes de executar a operação.

```java
if (!SessaoUsuario.isMaster()) {

    JOptionPane.showMessageDialog(
        null,
        "Você não possui permissão para excluir registros."
    );

    return;
}
```

Dessa forma, nós vamos separar melhor a aparência da tela da regra de negócio.

---

# 22. Tela Principal

Depois do login, nós vamos abrir a:

```text
FrmPrincipal
```

Ela será um `JFrame`.

Dentro dela, nós vamos inserir um:

```text
JDesktopPane
```

Esse componente funcionará como uma área de trabalho.

Dentro dele, nós vamos abrir os diversos `JInternalFrame`.

---

# 23. Menu principal

Nós vamos criar uma barra de menus com uma estrutura semelhante a esta:

```text
Sistema

Cadastros
    Clientes
    Fornecedores
    Produtos
    Usuários

Movimentos
    Compras
    Vendas

Financeiro
    Contas a pagar
    Contas a receber

Consultas

Ajuda

Sair
```

O menu Usuários poderá ficar disponível apenas para o MASTER.

O menu Contas a pagar também será controlado de acordo com o nível do usuário.

---

# 24. Uso do JDesktopPane

Nós vamos utilizar o `JDesktopPane` como área principal da aplicação.

Quando clicarmos em Clientes, por exemplo, nós vamos abrir:

```text
FrmCliente
```

dentro do desktop.

A organização será semelhante a:

```text
FrmPrincipal
       │
       └── JDesktopPane
               │
               ├── FrmCliente
               ├── FrmFornecedor
               ├── FrmProduto
               ├── FrmVenda
               └── FrmCompra
```

Nós também vamos programar o sistema para evitar que a mesma tela seja aberta várias vezes ao mesmo tempo.

---

# 25. Uso do JInternalFrame

As telas internas serão criadas utilizando `JInternalFrame`.

Isso permitirá trabalhar com várias janelas dentro da mesma tela principal.

Nós vamos aprender a:

```text
Abrir
Fechar
Maximizar
Minimizar
Selecionar
Centralizar
Evitar telas duplicadas
```

---

# 26. Padrão das telas de cadastro

Nós vamos criar um padrão para que todas as telas tenham um funcionamento semelhante.

Os principais cadastros utilizarão:

```text
JTabbedPane
```

Nós vamos criar duas abas.

```text
Cadastro
Consulta
```

Essa estrutura será utilizada principalmente em:

```text
Cliente
Fornecedor
Produto
Usuário
```

---

# 27. Aba Cadastro

Na aba Cadastro, nós vamos inserir e editar os dados.

No cadastro de Cliente, por exemplo, poderemos ter:

```text
Código
Nome
CPF
Telefone
Email
Endereço
Cidade
UF
CEP
```

Também vamos criar botões como:

```text
Novo
Salvar
Alterar
Excluir
Cancelar
```

---

# 28. Aba Consulta

Na aba Consulta, nós vamos exibir uma `JTable`.

Também vamos criar:

```text
Filtro
Pesquisa
Localizar
Listar todos
```

O filtro poderá ser escolhido utilizando um `JComboBox`.

No cadastro de clientes, poderemos oferecer opções como:

```text
ID
NOME
CPF
EMAIL
```

---

# 29. Pesquisa por parte do texto

Nós vamos permitir que o usuário pesquise apenas parte do nome.

Por exemplo:

```text
Filtro
NOME

Pesquisa
MARIA
```

A consulta poderá utilizar:

```sql
SELECT *
FROM cliente
WHERE UPPER(nome) LIKE UPPER(?)
ORDER BY nome
```

No Java, nós vamos enviar o texto utilizando `PreparedStatement`.

```java
stmt.setString(1, "%" + pesquisa + "%");
```

Assim, a pesquisa poderá localizar um nome mesmo quando o usuário digitar apenas uma parte dele.

---

# 30. Seleção de registros na JTable

Nós vamos aprender a selecionar um registro diretamente na `JTable`.

Quando o usuário selecionar uma linha e clicar em Alterar, nós vamos pegar os valores da tabela e carregar os campos da aba Cadastro.

Depois disso, nós vamos selecionar automaticamente a aba correta.

```java
tabbedPane.setSelectedIndex(0);
```

Assim, o usuário poderá alterar o registro selecionado.

---

# 31. Exclusão de registros

Nós vamos criar um processo de exclusão com confirmação.

Antes de apagar um registro, nós vamos exibir uma pergunta utilizando `JOptionPane`.

Somente usuários com permissão poderão concluir a exclusão.

O usuário USER terá essa operação bloqueada.

---

# 32. Movimento de Compra

Depois dos cadastros, nós vamos começar a trabalhar com movimentos.

O primeiro será a Compra.

Ela envolverá várias partes do sistema.

```text
COMPRA
     │
     ├── FORNECEDOR
     │
     ├── PRODUTOS_COMPRA
     │
     ├── PRODUTO
     │
     └── CONTAS_PAGAR
```

---

# 33. Tela de Compra

Nós vamos criar uma tela para registrar as compras realizadas pela loja.

Nela teremos informações como:

```text
Fornecedor

Produto
Quantidade
Valor unitário

Adicionar produto

Lista de produtos

Valor total

Forma de pagamento

Quantidade de parcelas

Finalizar compra
```

Os produtos adicionados serão exibidos em uma `JTable`.

---

# 34. Inclusão de produtos na compra

Nós vamos permitir que vários produtos sejam adicionados à mesma compra.

Cada item terá:

```text
Produto
Quantidade
Valor unitário
Subtotal
```

O subtotal será calculado com base na quantidade e no valor unitário.

Ao final, nós vamos somar todos os subtotais para obter o valor total da compra.

---

# 35. Finalização da Compra

Quando clicarmos em Finalizar Compra, nós vamos executar várias operações.

Nós vamos:

1. Cadastrar a compra.

2. Cadastrar os produtos da compra.

3. Atualizar o estoque.

4. Verificar a forma de pagamento.

5. Gerar contas a pagar quando necessário.

6. Confirmar a transação.

Tudo isso precisa acontecer de maneira organizada.

---

# 36. Atualização do estoque na compra

Quando uma compra for finalizada, nós vamos aumentar o estoque do produto.

Por exemplo:

```text
Estoque atual
15

Quantidade comprada
10

Novo estoque
25
```

Esse processo acontecerá automaticamente.

---

# 37. Compra parcelada

Se a compra for parcelada, nós vamos criar automaticamente as parcelas em contas a pagar.

Por exemplo:

```text
Valor da compra
R$ 3.000,00

Quantidade de parcelas
3
```

Nós poderemos gerar:

```text
Parcela 1
R$ 1.000,00

Parcela 2
R$ 1.000,00

Parcela 3
R$ 1.000,00
```

Cada parcela será armazenada separadamente.

---

# 38. Transação da Compra

A finalização de uma compra envolve várias operações no banco.

Por isso, nós vamos trabalhar com transações.

Conceitualmente:

```java
conexao.setAutoCommit(false);

try {

    cadastrarCompra();

    cadastrarProdutosCompra();

    atualizarEstoque();

    gerarContasPagar();

    conexao.commit();

} catch (Exception erro) {

    conexao.rollback();

}
```

Se tudo funcionar, nós vamos confirmar utilizando `commit`.

Se ocorrer algum erro, nós vamos desfazer a operação utilizando `rollback`.

Isso ajuda a impedir que o banco fique com dados incompletos.

---

# 39. Exemplo de problema sem transação

Imagine que nós estamos cadastrando uma compra com cinco produtos.

Os quatro primeiros são gravados corretamente.

Durante o quinto produto acontece um erro.

Sem transação, nós poderíamos terminar com uma compra incompleta no banco.

Com `rollback`, nós conseguimos cancelar as alterações daquele processo.

Essa será uma das partes mais importantes do projeto.

---

# 40. Movimento de Venda

Depois da compra, nós vamos desenvolver o movimento de Venda.

Ele terá uma estrutura semelhante:

```text
VENDA
     │
     ├── CLIENTE
     │
     ├── PRODUTOS_VENDA
     │
     ├── PRODUTO
     │
     └── CONTAS_RECEBER
```

---

# 41. Tela de Venda

Nós vamos criar uma tela com:

```text
Cliente

Produto
Quantidade
Valor unitário

Adicionar produto

Produtos da venda

Valor total

Forma de pagamento

Quantidade de parcelas

Finalizar venda
```

Os produtos adicionados também serão exibidos em uma `JTable`.

---

# 42. Verificação do estoque

Antes de adicionar um produto à venda, nós vamos verificar se existe estoque suficiente.

Por exemplo:

```text
Produto
Furadeira

Estoque disponível
5

Quantidade solicitada
7
```

Nesse caso, nós não vamos permitir a venda de sete unidades.

O sistema deverá informar que não existe quantidade suficiente em estoque.

---

# 43. Finalização da Venda

Quando a venda for finalizada, nós vamos executar:

1. Cadastro da venda.

2. Cadastro dos produtos vendidos.

3. Atualização do estoque.

4. Geração das contas a receber quando a venda for parcelada.

5. Confirmação da transação.

Conceitualmente:

```java
conexao.setAutoCommit(false);

try {

    cadastrarVenda();

    cadastrarProdutosVenda();

    baixarEstoque();

    gerarContasReceber();

    conexao.commit();

} catch (Exception erro) {

    conexao.rollback();

}
```

---

# 44. Atualização do estoque na venda

Durante a venda, nós vamos diminuir a quantidade disponível no estoque.

Por exemplo:

```text
Estoque anterior
20

Quantidade vendida
3

Estoque atual
17
```

Esse processo será feito automaticamente ao concluir a venda.

---

# 45. Venda parcelada

Quando uma venda for parcelada, nós vamos gerar registros no contas a receber.

Por exemplo:

```text
Valor da venda
R$ 1.200,00

Quantidade de parcelas
3
```

O sistema poderá gerar:

```text
Parcela 1
R$ 400,00

Parcela 2
R$ 400,00

Parcela 3
R$ 400,00
```

Cada parcela terá seu próprio vencimento.

---

# 46. Contas a Pagar

Nós vamos criar uma tela específica para acompanhar as contas que a empresa precisa pagar.

Ela poderá possuir filtros como:

```text
Todas
Abertas
Pagas
Vencidas
Fornecedor
Número da compra
Data de vencimento
```

A `JTable` poderá exibir:

```text
Código
Compra
Fornecedor
Parcela
Vencimento
Valor
Situação
```

---

# 47. Baixa de Conta a Pagar

Quando uma conta for selecionada, nós vamos disponibilizar a opção:

```text
Dar Baixa
```

Essa operação será permitida apenas para o MASTER.

Nós poderemos solicitar informações como:

```text
Data do pagamento
Valor pago
```

Depois da confirmação, nós vamos atualizar os dados da conta.

Conceitualmente:

```text
status recebe PAGA
data_pagamento recebe a data informada
valor_pago recebe o valor informado
```

---

# 48. Contas a Receber

Nós também vamos criar um módulo para acompanhar os valores que os clientes ainda precisam pagar.

Os filtros poderão ser:

```text
Todas
Abertas
Recebidas
Vencidas
Cliente
Número da venda
Data de vencimento
```

Nós também teremos uma `JTable` com os registros.

---

# 49. Baixa de Conta a Receber

Quando o cliente realizar o pagamento, nós vamos selecionar a conta e clicar em:

```text
Receber
```

Depois, nós vamos registrar:

```text
Data do recebimento
Valor recebido
```

A situação será atualizada.

Conceitualmente:

```text
status recebe RECEBIDA
data_recebimento recebe a data informada
valor_pago recebe o valor recebido
```

---

# 50. Controle de estoque mínimo

Nós vamos utilizar o campo:

```text
estoque_minimo
```

para identificar produtos com quantidade baixa.

Posteriormente, nós poderemos criar uma consulta que mostre somente os produtos que precisam de reposição.

Esse recurso poderá ser utilizado também em relatórios.

---

# 51. Regras de negócio

Ao longo do projeto, nós vamos criar várias regras.

Nós poderemos validar:

```text
CPF
CNPJ
Campos obrigatórios
Valores positivos
Estoque disponível
Usuário ativo
Cliente ativo
Fornecedor ativo
Produto ativo
Quantidade de parcelas
Datas de vencimento
```

Também não vamos permitir concluir uma venda sem produtos.

Da mesma forma, não vamos permitir concluir uma compra sem fornecedor ou sem produtos.

---

# 52. Status de Compra e Venda

Nós poderemos trabalhar com situações como:

```text
ABERTA
FINALIZADA
CANCELADA
```

Quando uma venda estiver finalizada, nós não vamos simplesmente apagar o registro.

Nós vamos aprender que sistemas comerciais precisam manter histórico das operações.

Em muitos casos, cancelar corretamente uma operação é melhor do que apagar completamente suas informações.

O mesmo raciocínio poderá ser aplicado às compras.

---

# 53. Fluxo completo do sistema

O fluxo geral que nós vamos construir será:

```text
LOGIN
   ↓
MENU PRINCIPAL
   ↓
CADASTROS
   ↓
Cliente
Fornecedor
Produto
Usuário
   ↓
MOVIMENTOS
   ↓
Compra
   ↓
Entrada no estoque
   ↓
Contas a pagar

Venda
   ↓
Saída do estoque
   ↓
Contas a receber
   ↓
FINANCEIRO
   ↓
Baixa de contas
```

---

# 54. Sequência de desenvolvimento

Nós vamos construir o projeto em uma sequência progressiva.

## Etapa 1

Planejamento do sistema.

Nós vamos estudar o problema, identificar as tabelas e compreender os relacionamentos.

## Etapa 2

Criação do banco FerragemGK.

Nós vamos criar tabelas, chaves primárias, chaves estrangeiras e relacionamentos.

## Etapa 3

Criação do projeto no NetBeans.

Nós vamos organizar os pacotes e preparar a aplicação.

## Etapa 4

Configuração do JDBC.

Nós vamos adicionar o Driver PostgreSQL ao projeto.

## Etapa 5

Criação da classe Conexao.

Nós vamos aprender a conectar o Java ao PostgreSQL.

## Etapa 6

Criação das classes de modelo.

Nós vamos criar objetos como Cliente, Produto, Fornecedor e Usuario.

## Etapa 7

Criação da tela de Login.

Nós vamos desenvolver a primeira interface do sistema.

## Etapa 8

Autenticação.

Nós vamos consultar o banco e validar usuário e senha.

## Etapa 9

Sessão do usuário.

Nós vamos guardar as informações do usuário conectado.

## Etapa 10

Níveis MASTER e USER.

Nós vamos controlar o que cada usuário pode fazer.

## Etapa 11

Tela Principal.

Nós vamos criar o menu e o `JDesktopPane`.

## Etapa 12

JInternalFrame.

Nós vamos aprender a abrir as telas internas.

## Etapa 13

Cadastro de Clientes.

Nós vamos criar o primeiro CRUD completo.

## Etapa 14

JTabbedPane.

Nós vamos separar Cadastro e Consulta.

## Etapa 15

Consulta utilizando JTable.

Nós vamos listar os dados do PostgreSQL.

## Etapa 16

Filtros e localização.

Nós vamos pesquisar por diferentes campos.

## Etapa 17

Alteração.

Nós vamos selecionar dados da `JTable` e editar o cadastro.

## Etapa 18

Exclusão.

Nós vamos excluir registros respeitando as permissões.

## Etapa 19

Cadastro de Fornecedores.

Nós vamos repetir e aprimorar o padrão aprendido.

## Etapa 20

Cadastro de Produtos.

Nós vamos incluir estoque, preços e estoque mínimo.

## Etapa 21

Cadastro de Usuários.

Nós vamos administrar logins e níveis de acesso.

## Etapa 22

Movimento de Compra.

Nós vamos trabalhar com cabeçalho e itens da compra.

## Etapa 23

Produtos da Compra.

Nós vamos adicionar vários produtos em uma mesma operação.

## Etapa 24

Entrada automática no estoque.

Nós vamos atualizar o estoque durante a compra.

## Etapa 25

Pagamento da Compra.

Nós vamos trabalhar com pagamento à vista e parcelado.

## Etapa 26

Contas a Pagar.

Nós vamos gerar parcelas automaticamente.

## Etapa 27

Movimento de Venda.

Nós vamos criar o processo completo de venda.

## Etapa 28

Produtos da Venda.

Nós vamos adicionar vários produtos em uma mesma venda.

## Etapa 29

Validação de estoque.

Nós vamos impedir vendas superiores ao estoque disponível.

## Etapa 30

Saída automática do estoque.

Nós vamos atualizar o estoque depois da venda.

## Etapa 31

Pagamento da Venda.

Nós vamos trabalhar com vendas à vista e parceladas.

## Etapa 32

Contas a Receber.

Nós vamos gerar parcelas automaticamente.

## Etapa 33

Consulta de Contas a Pagar.

Nós vamos filtrar e localizar compromissos financeiros.

## Etapa 34

Baixa de Contas a Pagar.

Nós vamos registrar pagamentos realizados.

## Etapa 35

Consulta de Contas a Receber.

Nós vamos acompanhar os valores que os clientes devem pagar.

## Etapa 36

Baixa de Contas a Receber.

Nós vamos registrar os valores recebidos.

## Etapa 37

Commit e rollback.

Nós vamos proteger operações que envolvem várias tabelas.

## Etapa 38

Validações.

Nós vamos melhorar a segurança dos dados digitados.

## Etapa 39

Controle completo das permissões.

Nós vamos revisar todos os acessos do MASTER e do USER.

## Etapa 40

Integração final.

Nós vamos testar o sistema completo, revisar erros e preparar a apresentação final.

---

# 55. O que nós vamos aprender com este projeto

Ao finalizar o FerragemGK, nós teremos trabalhado com boa parte dos principais conceitos necessários para desenvolver uma aplicação Java Desktop conectada a banco de dados.

Nós vamos aprender:

```text
Programação Orientada a Objetos
Java Swing
JFrame
JDesktopPane
JInternalFrame
JTabbedPane
JTable
Eventos
Menus
JDBC
PostgreSQL
SQL
PreparedStatement
ResultSet
CRUD
Relacionamentos
Chaves estrangeiras
Filtros
Consultas
Autenticação
Permissões
Sessão de usuário
Compras
Vendas
Estoque
Contas a pagar
Contas a receber
Transações
Commit
Rollback
Regras de negócio
```

---

# 56. Resultado esperado

Ao final do curso, nós vamos ter construído juntos um sistema comercial completo.

O FerragemGK terá:

```text
Login
Controle de usuários
Níveis de acesso
Tela principal
Menus
Desktop
JInternalFrame
Cadastros
Consultas
Filtros
Alterações
Exclusões
Compras
Vendas
Controle de estoque
Contas a pagar
Contas a receber
Baixa financeira
Controle de permissões
Integração com PostgreSQL
```

Mais importante do que terminar o sistema será compreender como cada parte foi construída.

Nós vamos fazer juntos cada etapa, entender os erros, testar as soluções e evoluir a aplicação aos poucos.

A proposta deste projeto é mostrar que uma aplicação completa não nasce pronta.

Nós vamos construí la por partes.

Primeiro vamos compreender o problema.

Depois vamos criar o banco.

Em seguida vamos conectar o Java.

Depois vamos desenvolver as telas.

Por fim, vamos integrar as regras de negócio até que todos os módulos funcionem juntos.

Ao término do projeto, nós teremos uma aplicação que reúne interface gráfica, banco de dados, programação orientada a objetos e regras comerciais em um único sistema.

---

# Próxima etapa

Na próxima etapa, nós vamos começar pela base de toda a aplicação.

Nós vamos criar o banco de dados `FerragemGK`.

Nós vamos definir:

```text
Tabelas
Campos
Tipos de dados
Chaves primárias
Chaves estrangeiras
Relacionamentos
Restrições
Valores padrão
Usuário MASTER inicial
```

Depois disso, nós vamos executar o script no PostgreSQL e verificar se toda a estrutura foi criada corretamente.
