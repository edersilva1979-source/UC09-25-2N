# Projeto FerragemGK

# Parte 7: Movimento de Compra, Entrada no Estoque e Geração de Contas a Pagar

Nesta etapa, nós vamos criar juntos o primeiro movimento comercial completo do FerragemGK.

Até agora nós trabalhamos principalmente com cadastros e CRUD. A partir desta parte, nós vamos integrar várias tabelas em uma única operação.

Uma compra envolverá:

```text
Fornecedor
Usuário conectado
Compra
Produtos da Compra
Produto
Estoque
Contas a Pagar
```

Quando a compra for à vista, nós vamos registrar a compra, os itens e aumentar o estoque.

Quando a compra for a prazo, nós vamos fazer tudo isso e também gerar automaticamente as parcelas na tabela `contas_pagar`.

Para garantir a integridade do banco, toda a finalização será executada dentro de uma transação utilizando:

```text
setAutoCommit(false)
commit()
rollback()
```

Se qualquer etapa apresentar erro, nós vamos desfazer toda a operação.

***

# 1. Fluxo completo da compra

```text
FrmPrincipal
    ↓
Movimentos
    ↓
Compras
    ↓
FrmCompra
    ↓
Selecionar fornecedor
    ↓
Adicionar produtos
    ↓
Informar quantidades e valores
    ↓
Calcular total
    ↓
Escolher forma de pagamento
    ↓
Finalizar Compra
    ↓
Gravar compra
    ↓
Gravar produtos_compra
    ↓
Aumentar estoque
    ↓
Pagamento a prazo?
    ↓
SIM
    ↓
Gerar contas_pagar
    ↓
commit
```

Se ocorrer um erro:

```text
Erro
    ↓
rollback
    ↓
Nenhuma parte da compra é confirmada
```

***

# 2. Tabelas utilizadas

Nós vamos trabalhar diretamente com:

```text
fornecedor
produto
compra
produtos_compra
contas_pagar
usuario
```

A tabela `compra` funciona como o cabeçalho da operação.

A tabela `produtos_compra` guarda os itens.

A tabela `contas_pagar` guarda as parcelas geradas quando a compra for a prazo.

***

# 3. Estrutura do projeto

Nesta etapa nós vamos acrescentar:

```text
model
    Compra.java
    ProdutoCompra.java
    ContaPagar.java

dao
    CompraDAO.java

view
    FrmCompra.java
```

Também vamos acrescentar pequenos métodos em:

```text
FornecedorDAO
ProdutoDAO
Fornecedor
Produto
```

***

# 4. Criando a classe Compra

No pacote `model`, nós vamos criar `Compra.java`.

```java
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private long idCompra;
    private long idFornecedor;
    private long idUsuario;
    private LocalDateTime dataCompra;
    private String formaPagamento;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private String status;

    private final List<ProdutoCompra> itens =
            new ArrayList<>();

    public Compra() {
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProdutoCompra> getItens() {
        return itens;
    }

    public void adicionarItem(
            ProdutoCompra item
    ) {

        itens.add(item);
    }
}
```

***

# 5. Criando ProdutoCompra

No pacote `model`, nós vamos criar `ProdutoCompra.java`.

```java
package model;

import java.math.BigDecimal;

public class ProdutoCompra {

    private long idProdutoCompra;
    private long idCompra;
    private Produto produto;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal subtotal;

    public ProdutoCompra() {
    }

    public long getIdProdutoCompra() {
        return idProdutoCompra;
    }

    public void setIdProdutoCompra(
            long idProdutoCompra
    ) {

        this.idProdutoCompra =
                idProdutoCompra;
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(
            long idCompra
    ) {

        this.idCompra = idCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(
            Produto produto
    ) {

        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(
            BigDecimal quantidade
    ) {

        this.quantidade = quantidade;

        calcularSubtotal();
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(
            BigDecimal valorUnitario
    ) {

        this.valorUnitario =
                valorUnitario;

        calcularSubtotal();
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    private void calcularSubtotal() {

        if (
                quantidade != null
                && valorUnitario != null
        ) {

            subtotal =
                    quantidade.multiply(
                            valorUnitario
                    );
        }
    }
}
```

Cada item da compra calcula:

```text
Quantidade × Valor Unitário = Subtotal
```

***

# 6. Criando ContaPagar

No pacote `model`, nós vamos criar `ContaPagar.java`.

```java
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPagar {

    private long idContaPagar;
    private long idCompra;
    private int numeroParcela;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private BigDecimal valorParcela;
    private BigDecimal valorPago;
    private LocalDate dataPagamento;
    private String status;

    public ContaPagar() {
    }

    public long getIdContaPagar() {
        return idContaPagar;
    }

    public void setIdContaPagar(
            long idContaPagar
    ) {

        this.idContaPagar =
                idContaPagar;
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(
            long idCompra
    ) {

        this.idCompra = idCompra;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(
            int numeroParcela
    ) {

        this.numeroParcela =
                numeroParcela;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(
            LocalDate dataEmissao
    ) {

        this.dataEmissao =
                dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(
            LocalDate dataVencimento
    ) {

        this.dataVencimento =
                dataVencimento;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(
            BigDecimal valorParcela
    ) {

        this.valorParcela =
                valorParcela;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(
            BigDecimal valorPago
    ) {

        this.valorPago =
                valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(
            LocalDate dataPagamento
    ) {

        this.dataPagamento =
                dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {

        this.status = status;
    }
}
```

***

# 7. Melhorando Fornecedor para o JComboBox

Na classe `Fornecedor`, nós vamos acrescentar:

```java
@Override
public String toString() {

    if (
            nomeFantasia != null
            && !nomeFantasia.isBlank()
    ) {

        return nomeFantasia;
    }

    return razaoSocial;
}
```

Assim o objeto poderá ser exibido diretamente no `JComboBox`.

***

# 8. Melhorando Produto para o JComboBox

Na classe `Produto`, acrescente:

```java
@Override
public String toString() {

    return descricao;
}
```

***

# 9. Listando fornecedores ativos

Na `FornecedorDAO`, acrescente:

```java
public List<Fornecedor> listarAtivos() {

    List<Fornecedor> fornecedores =
            new ArrayList<>();

    String sql =
            "SELECT * "
            + "FROM fornecedor "
            + "WHERE ativo = TRUE "
            + "ORDER BY razao_social";

    try (
            Connection conexao =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery()
    ) {

        while (rs.next()) {

            fornecedores.add(
                    montarFornecedor(rs)
            );
        }

    } catch (SQLException erro) {

        throw new RuntimeException(
                "Erro ao listar fornecedores ativos.",
                erro
        );
    }

    return fornecedores;
}
```

***

# 10. Listando produtos ativos

Na `ProdutoDAO`, acrescente:

```java
public List<Produto> listarAtivos() {

    List<Produto> produtos =
            new ArrayList<>();

    String sql =
            "SELECT * "
            + "FROM produto "
            + "WHERE ativo = TRUE "
            + "ORDER BY descricao";

    try (
            Connection conexao =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery()
    ) {

        while (rs.next()) {

            produtos.add(
                    montarProduto(rs)
            );
        }

    } catch (SQLException erro) {

        throw new RuntimeException(
                "Erro ao listar produtos ativos.",
                erro
        );
    }

    return produtos;
}
```


***

# 11. Criando CompraDAO

Agora nós vamos criar a classe responsável por finalizar toda a compra.

No pacote `dao`, crie `CompraDAO.java`.

Imports:

```java
package dao;

import conexao.Conexao;

import model.Compra;
import model.ContaPagar;
import model.ProdutoCompra;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
```

***

# 12. Finalizando uma compra com transação

```java
public long finalizarCompra(
        Compra compra,
        LocalDate primeiroVencimento
) {

    try (
            Connection conexao =
                    Conexao.conectar()
    ) {

        conexao.setAutoCommit(false);

        try {

            long idCompra =
                    inserirCompra(
                            conexao,
                            compra
                    );

            for (
                    ProdutoCompra item :
                    compra.getItens()
            ) {

                inserirItem(
                        conexao,
                        idCompra,
                        item
                );

                aumentarEstoque(
                        conexao,
                        item
                );
            }

            if (
                    compra
                    .getFormaPagamento()
                    .equals("PARCELADO")
            ) {

                List<ContaPagar> parcelas =
                        gerarParcelas(
                                idCompra,
                                compra.getValorTotal(),
                                compra.getQuantidadeParcelas(),
                                primeiroVencimento
                        );

                for (
                        ContaPagar conta :
                        parcelas
                ) {

                    inserirContaPagar(
                            conexao,
                            conta
                    );
                }
            }

            conexao.commit();

            return idCompra;

        } catch (Exception erro) {

            conexao.rollback();

            throw new RuntimeException(
                    "A compra foi cancelada porque ocorreu um erro.",
                    erro
            );
        }

    } catch (SQLException erro) {

        throw new RuntimeException(
                "Erro ao finalizar compra.",
                erro
        );
    }
}
```

Toda a operação usa a mesma conexão. Isso permite que a compra seja tratada como uma única transação.

***

# 13. Inserindo o cabeçalho da compra

```java
private long inserirCompra(
        Connection conexao,
        Compra compra
) throws SQLException {

    String sql =
            "INSERT INTO compra ("
            + "id_fornecedor, "
            + "id_usuario, "
            + "forma_pagamento, "
            + "quantidade_parcelas, "
            + "valor_total, "
            + "status"
            + ") VALUES ("
            + "?, ?, ?, ?, ?, ?"
            + ") "
            + "RETURNING id_compra";

    try (
            PreparedStatement stmt =
                    conexao.prepareStatement(sql)
    ) {

        stmt.setLong(
                1,
                compra.getIdFornecedor()
        );

        stmt.setLong(
                2,
                compra.getIdUsuario()
        );

        stmt.setString(
                3,
                compra.getFormaPagamento()
        );

        stmt.setInt(
                4,
                compra.getQuantidadeParcelas()
        );

        stmt.setBigDecimal(
                5,
                compra.getValorTotal()
        );

        stmt.setString(
                6,
                "FINALIZADA"
        );

        try (
                ResultSet rs =
                        stmt.executeQuery()
        ) {

            if (rs.next()) {

                return rs.getLong(
                        "id_compra"
                );
            }
        }
    }

    throw new SQLException(
            "Não foi possível gerar o código da compra."
    );
}
```

***

# 14. Gravando a tabela produtos_compra

```java
private void inserirItem(
        Connection conexao,
        long idCompra,
        ProdutoCompra item
) throws SQLException {

    String sql =
            "INSERT INTO produtos_compra ("
            + "id_compra, "
            + "id_produto, "
            + "quantidade, "
            + "valor_unitario, "
            + "subtotal"
            + ") VALUES (?, ?, ?, ?, ?)";

    try (
            PreparedStatement stmt =
                    conexao.prepareStatement(sql)
    ) {

        stmt.setLong(
                1,
                idCompra
        );

        stmt.setLong(
                2,
                item
                .getProduto()
                .getIdProduto()
        );

        stmt.setBigDecimal(
                3,
                item.getQuantidade()
        );

        stmt.setBigDecimal(
                4,
                item.getValorUnitario()
        );

        stmt.setBigDecimal(
                5,
                item.getSubtotal()
        );

        stmt.executeUpdate();
    }
}
```

Cada produto da tela será transformado em um registro na tabela `produtos_compra`.

***

# 15. Aumentando o estoque

```java
private void aumentarEstoque(
        Connection conexao,
        ProdutoCompra item
) throws SQLException {

    String sql =
            "UPDATE produto "
            + "SET estoque = estoque + ? "
            + "WHERE id_produto = ? "
            + "AND ativo = TRUE";

    try (
            PreparedStatement stmt =
                    conexao.prepareStatement(sql)
    ) {

        stmt.setBigDecimal(
                1,
                item.getQuantidade()
        );

        stmt.setLong(
                2,
                item
                .getProduto()
                .getIdProduto()
        );

        int linhas =
                stmt.executeUpdate();

        if (linhas == 0) {

            throw new SQLException(
                    "Produto não encontrado ou inativo: "
                    + item
                    .getProduto()
                    .getDescricao()
            );
        }
    }
}
```

Exemplo:

```text
Estoque anterior
10

Quantidade comprada
5

Novo estoque
15
```

***

# 16. Gerando parcelas sem perder centavos

Nós vamos calcular as parcelas utilizando `BigDecimal`.

```java
private List<ContaPagar> gerarParcelas(
        long idCompra,
        BigDecimal total,
        int quantidadeParcelas,
        LocalDate primeiroVencimento
) {

    List<ContaPagar> contas =
            new ArrayList<>();

    BigDecimal divisor =
            BigDecimal.valueOf(
                    quantidadeParcelas
            );

    BigDecimal valorBase =
            total.divide(
                    divisor,
                    2,
                    RoundingMode.DOWN
            );

    BigDecimal totalBase =
            valorBase.multiply(
                    divisor
            );

    BigDecimal diferenca =
            total.subtract(
                    totalBase
            );

    int ultimaParcela =
            quantidadeParcelas;

    for (
            int indice = 0;
            indice < quantidadeParcelas;
            indice++
    ) {

        BigDecimal valorParcela =
                valorBase;

        if (
                indice + 1
                == ultimaParcela
        ) {

            valorParcela =
                    valorParcela.add(
                            diferenca
                    );
        }

        ContaPagar conta =
                new ContaPagar();

        conta.setIdCompra(
                idCompra
        );

        conta.setNumeroParcela(
                indice + 1
        );

        conta.setDataEmissao(
                LocalDate.now()
        );

        conta.setDataVencimento(
                primeiroVencimento
                .plusMonths(indice)
        );

        conta.setValorParcela(
                valorParcela
        );

        conta.setValorPago(
                BigDecimal.ZERO
        );

        conta.setStatus(
                "ABERTA"
        );

        contas.add(
                conta
        );
    }

    return contas;
}
```

Exemplo:

```text
Total
1.000,00

Parcelas
3

Resultado
333,33
333,33
333,34
```

A última parcela recebe a diferença necessária para fechar exatamente o total da compra.

***

# 17. Inserindo contas a pagar

```java
private void inserirContaPagar(
        Connection conexao,
        ContaPagar conta
) throws SQLException {

    String sql =
            "INSERT INTO contas_pagar ("
            + "id_compra, "
            + "numero_parcela, "
            + "data_emissao, "
            + "data_vencimento, "
            + "valor_parcela, "
            + "valor_pago, "
            + "status"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (
            PreparedStatement stmt =
                    conexao.prepareStatement(sql)
    ) {

        stmt.setLong(
                1,
                conta.getIdCompra()
        );

        stmt.setInt(
                2,
                conta.getNumeroParcela()
        );

        stmt.setDate(
                3,
                Date.valueOf(
                        conta.getDataEmissao()
                )
        );

        stmt.setDate(
                4,
                Date.valueOf(
                        conta.getDataVencimento()
                )
        );

        stmt.setBigDecimal(
                5,
                conta.getValorParcela()
        );

        stmt.setBigDecimal(
                6,
                conta.getValorPago()
        );

        stmt.setString(
                7,
                conta.getStatus()
        );

        stmt.executeUpdate();
    }
}
```

***

# 18. Criando a FrmCompra

No pacote `view`, crie um `JInternalFrame Form` chamado:

```text
FrmCompra
```

Configure:

```text
Title
Movimento de Compra

Closable
true

Iconifiable
true

Maximizable
true

Resizable
true
```

***

# 19. Componentes da FrmCompra

Nós vamos criar:

```text
Código da Compra
Fornecedor
Produto
Quantidade
Valor Unitário
Adicionar Produto
Remover Produto
Tabela de Itens
Valor Total
À Vista
A Prazo
Quantidade de Parcelas
Primeiro Vencimento
Nova Compra
Finalizar Compra
Cancelar
```

Nomes:

```text
txtCodigoCompra
cmbFornecedor
cmbProduto
txtQuantidade
txtValorUnitario
btnAdicionarProduto
btnRemoverProduto
tblItens
lblValorTotal
rdbAvista
rdbPrazo
spnParcelas
txtPrimeiroVencimento
btnNovaCompra
btnFinalizarCompra
btnCancelar
grpPagamento
```

***

# 20. Estrutura visual sugerida

```text
============================================================

MOVIMENTO DE COMPRA

Código: [          ]

Fornecedor:
[                                             ]

Produto:
[                                             ]

Quantidade: [          ]
Valor Unitário: [          ]

[ Adicionar Produto ]

============================================================

Itens da Compra

Código | Produto | Quantidade | Valor | Subtotal

============================================================

[ Remover Produto ]

Total da Compra: R$ 0,00

Forma de Pagamento

( ) À Vista
( ) A Prazo

Parcelas: [ 2 ]

Primeiro Vencimento: [ 10/09/2026 ]

============================================================

[ Nova Compra ] [ Finalizar Compra ] [ Cancelar ]

============================================================
```

***

# 21. Imports da FrmCompra

```java
import dao.CompraDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;

import java.math.BigDecimal;

import java.text.DecimalFormat;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import model.Compra;
import model.Fornecedor;
import model.Produto;
import model.ProdutoCompra;

import util.SessaoUsuario;
```

***

# 22. Variáveis da FrmCompra

```java
private final CompraDAO compraDAO =
        new CompraDAO();

private final FornecedorDAO fornecedorDAO =
        new FornecedorDAO();

private final ProdutoDAO produtoDAO =
        new ProdutoDAO();

private final List<ProdutoCompra> itensCompra =
        new ArrayList<>();

private final DecimalFormat formatoValor =
        new DecimalFormat("#,##0.00");

private final DecimalFormat formatoQuantidade =
        new DecimalFormat("#,##0.000");

private final DateTimeFormatter formatoData =
        DateTimeFormatter.ofPattern(
                "dd/MM/yyyy"
        );

private BigDecimal valorTotal =
        BigDecimal.ZERO;
```

***

# 23. Construtor

```java
public FrmCompra() {

    initComponents();

    configurarTela();

    carregarFornecedores();

    carregarProdutos();

    novaCompra();
}
```

***

# 24. Método configurarTela

```java
private void configurarTela() {

    txtCodigoCompra.setEditable(
            false
    );

    tblItens.setModel(
            criarModeloTabela()
    );

    tblItens.setSelectionMode(
            javax.swing.ListSelectionModel
                    .SINGLE_SELECTION
    );

    spnParcelas.setModel(
            new SpinnerNumberModel(
                    2,
                    2,
                    24,
                    1
            )
    );

    rdbAvista.setSelected(
            true
    );

    atualizarCamposPagamento();
}
```

***

# 25. Modelo da JTable

```java
private DefaultTableModel criarModeloTabela() {

    return new DefaultTableModel(
            new Object[]{
                "Código",
                "Produto",
                "Quantidade",
                "Valor Unitário",
                "Subtotal"
            },
            0
    ) {

        @Override
        public boolean isCellEditable(
                int row,
                int column
        ) {

            return false;
        }
    };
}
```


***

# 26. Carregando fornecedores

```java
private void carregarFornecedores() {

    try {

        List<Fornecedor> fornecedores =
                fornecedorDAO.listarAtivos();

        DefaultComboBoxModel<Fornecedor> modelo =
                new DefaultComboBoxModel<>();

        for (
                Fornecedor fornecedor :
                fornecedores
        ) {

            modelo.addElement(
                    fornecedor
            );
        }

        cmbFornecedor.setModel(
                modelo
        );

        cmbFornecedor.setSelectedItem(
                null
        );

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar fornecedores.\n"
                + erro.getMessage()
        );
    }
}
```

***

# 27. Carregando produtos

```java
private void carregarProdutos() {

    try {

        List<Produto> produtos =
                produtoDAO.listarAtivos();

        DefaultComboBoxModel<Produto> modelo =
                new DefaultComboBoxModel<>();

        for (
                Produto produto :
                produtos
        ) {

            modelo.addElement(
                    produto
            );
        }

        cmbProduto.setModel(
                modelo
        );

        cmbProduto.setSelectedItem(
                null
        );

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar produtos.\n"
                + erro.getMessage()
        );
    }
}
```

***

# 28. Preenchendo o preço de custo automaticamente

No evento do `cmbProduto`:

```java
private void cmbProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    Produto produto =
            (Produto)
            cmbProduto.getSelectedItem();

    if (produto != null) {

        txtValorUnitario.setText(
                produto
                .getPrecoCusto()
                .toPlainString()
                .replace(".", ",")
        );
    }
}
```

O preço de custo cadastrado será apenas o valor inicial.

Nós ainda permitiremos alterar o preço quando a compra tiver outro valor negociado.

***

# 29. Convertendo valores digitados

```java
private BigDecimal converterDecimal(
        String texto
) {

    String valor =
            texto.trim();

    if (
            valor.contains(",")
    ) {

        valor =
                valor
                .replace(".", "")
                .replace(",", ".");
    }

    return new BigDecimal(
            valor
    );
}
```

Esse método permite trabalhar com valores digitados no formato brasileiro.

***

# 30. Adicionando produtos

```java
private void adicionarProduto() {

    Produto produto =
            (Produto)
            cmbProduto.getSelectedItem();

    if (produto == null) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um produto."
        );

        return;
    }

    try {

        BigDecimal quantidade =
                converterDecimal(
                        txtQuantidade.getText()
                );

        BigDecimal valorUnitario =
                converterDecimal(
                        txtValorUnitario.getText()
                );

        if (
                quantidade.compareTo(
                        BigDecimal.ZERO
                ) <= 0
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "A quantidade deve ser maior que zero."
            );

            return;
        }

        if (
                valorUnitario.compareTo(
                        BigDecimal.ZERO
                ) < 0
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "O valor unitário não pode ser negativo."
            );

            return;
        }

        adicionarOuSomarItem(
                produto,
                quantidade,
                valorUnitario
        );

        atualizarTabelaItens();

        calcularTotal();

        limparItem();

    } catch (
            NumberFormatException erro
    ) {

        JOptionPane.showMessageDialog(
                this,
                "Informe quantidade e valor válidos."
        );
    }
}
```

***

# 31. Evitando produto duplicado

Como a tabela `produtos_compra` não deve repetir o mesmo produto dentro da mesma compra, nós vamos somar a quantidade quando o item já existir.

```java
private void adicionarOuSomarItem(
        Produto produto,
        BigDecimal quantidade,
        BigDecimal valorUnitario
) {

    for (
            ProdutoCompra item :
            itensCompra
    ) {

        if (
                item
                .getProduto()
                .getIdProduto()
                == produto.getIdProduto()
        ) {

            BigDecimal novaQuantidade =
                    item
                    .getQuantidade()
                    .add(
                            quantidade
                    );

            item.setQuantidade(
                    novaQuantidade
            );

            item.setValorUnitario(
                    valorUnitario
            );

            return;
        }
    }

    ProdutoCompra novoItem =
            new ProdutoCompra();

    novoItem.setProduto(
            produto
    );

    novoItem.setQuantidade(
            quantidade
    );

    novoItem.setValorUnitario(
            valorUnitario
    );

    itensCompra.add(
            novoItem
    );
}
```

***

# 32. Evento Adicionar Produto

```java
private void btnAdicionarProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    adicionarProduto();
}
```

***

# 33. Atualizando a JTable

```java
private void atualizarTabelaItens() {

    DefaultTableModel modelo =
            (DefaultTableModel)
            tblItens.getModel();

    modelo.setRowCount(0);

    for (
            ProdutoCompra item :
            itensCompra
    ) {

        modelo.addRow(
                new Object[]{
                    item
                    .getProduto()
                    .getIdProduto(),

                    item
                    .getProduto()
                    .getDescricao(),

                    formatoQuantidade.format(
                            item.getQuantidade()
                    ),

                    formatoValor.format(
                            item.getValorUnitario()
                    ),

                    formatoValor.format(
                            item.getSubtotal()
                    )
                }
        );
    }
}
```

***

# 34. Calculando o total da compra

```java
private void calcularTotal() {

    valorTotal =
            BigDecimal.ZERO;

    for (
            ProdutoCompra item :
            itensCompra
    ) {

        valorTotal =
                valorTotal.add(
                        item.getSubtotal()
                );
    }

    lblValorTotal.setText(
            "R$ "
            + formatoValor.format(
                    valorTotal
            )
    );
}
```

***

# 35. Limpando o item atual

```java
private void limparItem() {

    cmbProduto.setSelectedItem(
            null
    );

    txtQuantidade.setText(
            "1,000"
    );

    txtValorUnitario.setText(
            ""
    );
}
```

***

# 36. Removendo um produto

```java
private void btnRemoverProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int linha =
            tblItens.getSelectedRow();

    if (linha < 0) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um produto da compra."
        );

        return;
    }

    itensCompra.remove(
            linha
    );

    atualizarTabelaItens();

    calcularTotal();
}
```

***

# 37. Pagamento à vista e a prazo

Na interface nós vamos mostrar:

```text
À Vista
A Prazo
```

No banco, os valores serão:

```text
AVISTA
PARCELADO
```

***

# 38. Habilitando os campos de parcelamento

```java
private void atualizarCamposPagamento() {

    boolean parcelado =
            rdbPrazo.isSelected();

    spnParcelas.setEnabled(
            parcelado
    );

    txtPrimeiroVencimento.setEnabled(
            parcelado
    );

    if (!parcelado) {

        txtPrimeiroVencimento.setText(
                ""
        );
    }
}
```

Eventos:

```java
private void rdbAvistaActionPerformed(
        java.awt.event.ActionEvent evt
) {

    atualizarCamposPagamento();
}
```

```java
private void rdbPrazoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    atualizarCamposPagamento();
}
```

***

# 39. Criando uma nova compra

```java
private void novaCompra() {

    txtCodigoCompra.setText(
            ""
    );

    cmbFornecedor.setSelectedItem(
            null
    );

    itensCompra.clear();

    atualizarTabelaItens();

    valorTotal =
            BigDecimal.ZERO;

    calcularTotal();

    limparItem();

    rdbAvista.setSelected(
            true
    );

    spnParcelas.setValue(
            2
    );

    txtPrimeiroVencimento.setText(
            ""
    );

    atualizarCamposPagamento();
}
```

Evento:

```java
private void btnNovaCompraActionPerformed(
        java.awt.event.ActionEvent evt
) {

    novaCompra();
}
```

***

# 40. Validando a compra

```java
private boolean validarCompra() {

    if (
            cmbFornecedor.getSelectedItem()
            == null
    ) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione o fornecedor."
        );

        return false;
    }

    if (
            itensCompra.isEmpty()
    ) {

        JOptionPane.showMessageDialog(
                this,
                "Adicione pelo menos um produto."
        );

        return false;
    }

    if (
            valorTotal.compareTo(
                    BigDecimal.ZERO
            ) <= 0
    ) {

        JOptionPane.showMessageDialog(
                this,
                "O total da compra deve ser maior que zero."
        );

        return false;
    }

    if (
            rdbPrazo.isSelected()
    ) {

        if (
                txtPrimeiroVencimento
                .getText()
                .trim()
                .isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe o primeiro vencimento."
            );

            return false;
        }

        try {

            LocalDate.parse(
                    txtPrimeiroVencimento
                    .getText()
                    .trim(),
                    formatoData
            );

        } catch (
                DateTimeParseException erro
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe o vencimento no formato dd/MM/yyyy."
            );

            return false;
        }
    }

    return true;
}
```

***

# 41. Montando o objeto Compra

```java
private Compra criarCompra() {

    Fornecedor fornecedor =
            (Fornecedor)
            cmbFornecedor.getSelectedItem();

    Compra compra =
            new Compra();

    compra.setIdFornecedor(
            fornecedor.getIdFornecedor()
    );

    compra.setIdUsuario(
            SessaoUsuario
            .getUsuarioLogado()
            .getIdUsuario()
    );

    if (
            rdbPrazo.isSelected()
    ) {

        compra.setFormaPagamento(
                "PARCELADO"
        );

        compra.setQuantidadeParcelas(
                (Integer)
                spnParcelas.getValue()
        );

    } else {

        compra.setFormaPagamento(
                "AVISTA"
        );

        compra.setQuantidadeParcelas(
                1
        );
    }

    compra.setValorTotal(
            valorTotal
    );

    compra.setStatus(
            "FINALIZADA"
    );

    for (
            ProdutoCompra item :
            itensCompra
    ) {

        compra.adicionarItem(
                item
        );
    }

    return compra;
}
```

***

# 42. Obtendo o primeiro vencimento

```java
private LocalDate obterPrimeiroVencimento() {

    if (
            !rdbPrazo.isSelected()
    ) {

        return null;
    }

    return LocalDate.parse(
            txtPrimeiroVencimento
            .getText()
            .trim(),
            formatoData
    );
}
```

***

# 43. Finalizando a compra

```java
private void btnFinalizarCompraActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!validarCompra()) {

        return;
    }

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja finalizar esta compra?",
                    "Finalizar Compra",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            != JOptionPane.YES_OPTION
    ) {

        return;
    }

    try {

        Compra compra =
                criarCompra();

        LocalDate primeiroVencimento =
                obterPrimeiroVencimento();

        long codigo =
                compraDAO.finalizarCompra(
                        compra,
                        primeiroVencimento
                );

        JOptionPane.showMessageDialog(
                this,
                "Compra finalizada com sucesso.\n"
                + "Código: "
                + codigo
        );

        novaCompra();

        carregarProdutos();

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível finalizar a compra.\n"
                + erro.getMessage()
        );
    }
}
```

***

# 44. Botão Cancelar

```java
private void btnCancelarActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja cancelar os dados desta compra?",
                    "Cancelar",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            == JOptionPane.YES_OPTION
    ) {

        novaCompra();
    }
}
```

***

# 45. Ligando FrmCompra à FrmPrincipal

Na `FrmPrincipal`:

```java
private void mnuComprasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmCompra()
    );
}
```

***

# 46. Permissões de MASTER e USER

Tanto o `MASTER` quanto o `USER` poderão registrar compras.

A compra é uma operação operacional.

Entretanto, o `USER` continua sem acesso direto ao módulo:

```text
Contas a Pagar
```

Se o `USER` fizer uma compra a prazo, o sistema criará as parcelas automaticamente.

Isso não dá ao usuário comum permissão para alterar, excluir ou dar baixa nessas contas.

A administração direta de Contas a Pagar continuará exclusiva do `MASTER`.


***

# 47. Compra à vista

Exemplo:

```text
Fornecedor
Ferragens Central

Produto
Furadeira de Impacto 650W

Quantidade
5

Valor Unitário
180,00

Forma de Pagamento
À Vista
```

Ao finalizar, nós teremos:

```text
compra
    recebe o cabeçalho

produtos_compra
    recebe os itens

produto
    recebe a entrada no estoque
```

Nenhuma parcela será criada em `contas_pagar`.

***

# 48. Compra a prazo

Exemplo:

```text
Fornecedor
Ferragens Central

Valor Total
1.000,00

Forma de Pagamento
A Prazo

Parcelas
3

Primeiro Vencimento
10/09/2026
```

Ao finalizar:

```text
compra
    recebe o cabeçalho

produtos_compra
    recebe os itens

produto
    recebe a entrada no estoque

contas_pagar
    recebe as parcelas
```

***

# 49. Conferindo a compra no PostgreSQL

Depois de finalizar, execute:

```sql
SELECT *
FROM compra
ORDER BY id_compra DESC;
```

Nós devemos encontrar o cabeçalho da compra.

***

# 50. Conferindo os produtos da compra

```sql
SELECT *
FROM produtos_compra
ORDER BY id_produto_compra DESC;
```

Cada item adicionado na `JTable` deverá possuir um registro nessa tabela.

***

# 51. Conferindo o estoque

```sql
SELECT
    id_produto,
    descricao,
    estoque
FROM produto
ORDER BY descricao;
```

O estoque dos produtos comprados deverá ter aumentado.

***

# 52. Conferindo as contas a pagar

Depois de uma compra a prazo:

```sql
SELECT *
FROM contas_pagar
ORDER BY
    id_compra DESC,
    numero_parcela;
```

Nós devemos encontrar uma linha para cada parcela.

***

# 53. Consultando compra e fornecedor com JOIN

```sql
SELECT
    c.id_compra,
    c.data_compra,
    f.razao_social,
    c.valor_total,
    c.forma_pagamento,
    c.quantidade_parcelas,
    c.status
FROM compra c
INNER JOIN fornecedor f
    ON f.id_fornecedor =
       c.id_fornecedor
ORDER BY c.id_compra DESC;
```

Esse `JOIN` nos permite visualizar os dados da compra junto com o fornecedor.

***

# 54. Consultando os produtos da compra

```sql
SELECT
    c.id_compra,
    p.descricao,
    pc.quantidade,
    pc.valor_unitario,
    pc.subtotal
FROM produtos_compra pc
INNER JOIN compra c
    ON c.id_compra =
       pc.id_compra
INNER JOIN produto p
    ON p.id_produto =
       pc.id_produto
ORDER BY
    c.id_compra DESC,
    p.descricao;
```

***

# 55. Consultando as parcelas

```sql
SELECT
    cp.id_conta_pagar,
    cp.id_compra,
    cp.numero_parcela,
    cp.data_emissao,
    cp.data_vencimento,
    cp.valor_parcela,
    cp.valor_pago,
    cp.status
FROM contas_pagar cp
ORDER BY
    cp.id_compra DESC,
    cp.numero_parcela;
```

***

# 56. Testando uma compra à vista

Nós podemos utilizar:

```text
Fornecedor
Ferragens Central

Produto
Furadeira de Impacto 650W

Quantidade
5,000

Valor Unitário
180,00

Pagamento
À Vista
```

Depois de finalizar, confira:

```text
Compra registrada
Produto registrado em produtos_compra
Estoque aumentado
Nenhuma conta a pagar criada
```

***

# 57. Testando uma compra a prazo

Agora faça:

```text
Fornecedor
Ferragens Central

Produto
Parafuso Sextavado 8mm

Quantidade
100,000

Valor Unitário
0,35

Pagamento
A Prazo

Parcelas
3

Primeiro Vencimento
10/09/2026
```

Confira:

```text
Compra registrada
Itens registrados
Estoque aumentado
Três contas a pagar criadas
```

***

# 58. Testando vários produtos na mesma compra

Adicione:

```text
Furadeira
Parafusos
Brocas
Martelo
```

Todos deverão aparecer na mesma `JTable`.

Ao finalizar, todos os produtos deverão receber o mesmo:

```text
id_compra
```

na tabela `produtos_compra`.

***

# 59. Testando o mesmo produto duas vezes

Adicione:

```text
Furadeira
Quantidade 2
```

Depois adicione novamente:

```text
Furadeira
Quantidade 3
```

Nossa tela deverá manter apenas um item para esse produto, com:

```text
Quantidade total
5
```

Isso respeita a restrição de unicidade existente em `produtos_compra`.

***

# 60. Testando rollback

Este é um dos testes mais importantes da aula.

Nós podemos provocar temporariamente um erro dentro de uma etapa da `CompraDAO`.

Por exemplo, durante o teste, podemos escrever propositalmente um nome incorreto de coluna no SQL de `inserirContaPagar`.

Depois tentamos finalizar uma compra a prazo.

Como haverá erro, o sistema deverá executar:

```text
rollback
```

Depois consultamos o banco.

Nós devemos confirmar:

```text
A compra não foi gravada
Os itens não foram gravados
O estoque não foi alterado
As contas não foram gravadas
```

Depois do teste, nós restauramos o SQL correto.

***

# 61. Por que rollback é necessário

Imagine a seguinte situação:

```text
Compra gravada
Itens gravados
Estoque aumentado
Erro ao gerar parcelas
```

Sem transação, o banco ficaria inconsistente.

Com `rollback`, nós voltamos ao estado anterior.

Isso significa que a finalização da compra é tratada como uma única operação lógica.

***

# 62. Não vamos excluir compras finalizadas

Uma compra finalizada modifica várias informações.

Ela pode:

```text
Aumentar estoque
Gerar itens
Gerar contas a pagar
Alterar valores financeiros
```

Por isso nós não vamos tratar uma compra como um CRUD comum.

Nós não vamos criar simplesmente:

```text
DELETE FROM compra
```

para uma operação finalizada.

***

# 63. Futuro cancelamento de compra

Se nós quisermos criar um cancelamento, ele deverá possuir uma regra própria.

O sistema precisará:

```text
Verificar se a compra pode ser cancelada

Verificar contas já pagas

Estornar o estoque

Cancelar contas abertas

Preservar o histórico

Alterar o status da compra para CANCELADA
```

Cancelar uma compra é muito diferente de apagar uma linha do banco.

***

# 64. Usuário responsável pela compra

Nós estamos armazenando:

```java
SessaoUsuario
        .getUsuarioLogado()
        .getIdUsuario()
```

dentro da compra.

Isso permite saber quem realizou cada operação.

Mais adiante poderemos consultar:

```text
Compra
Fornecedor
Usuário responsável
Data
Valor
```

***

# 65. Consulta com o usuário responsável

```sql
SELECT
    c.id_compra,
    c.data_compra,
    f.razao_social,
    u.nome AS usuario,
    c.valor_total,
    c.forma_pagamento,
    c.status
FROM compra c
INNER JOIN fornecedor f
    ON f.id_fornecedor =
       c.id_fornecedor
INNER JOIN usuario u
    ON u.id_usuario =
       c.id_usuario
ORDER BY c.id_compra DESC;
```

***

# 66. Recursos utilizados nesta etapa

Nós reunimos vários conteúdos já estudados:

```text
Programação Orientada a Objetos

Model

DAO

Java Swing

JInternalFrame

JComboBox

JTable

DefaultTableModel

JSpinner

JRadioButton

ButtonGroup

JOptionPane

ArrayList

BigDecimal

LocalDate

PreparedStatement

ResultSet

INSERT

UPDATE

SELECT

JOIN

Chaves estrangeiras

Sessão do usuário

MASTER

USER

Transações

commit

rollback

Regras de negócio

Controle de estoque

Parcelamento
```

***

# 67. Métodos principais da FrmCompra

Nossa tela possui:

```text
configurarTela

criarModeloTabela

carregarFornecedores

carregarProdutos

converterDecimal

adicionarProduto

adicionarOuSomarItem

atualizarTabelaItens

calcularTotal

limparItem

atualizarCamposPagamento

novaCompra

validarCompra

criarCompra

obterPrimeiroVencimento
```

***

# 68. Métodos principais da CompraDAO

Nossa DAO possui:

```text
finalizarCompra

inserirCompra

inserirItem

aumentarEstoque

gerarParcelas

inserirContaPagar
```

***

# 69. Arquitetura da movimentação

```text
FrmCompra
    ↓
Compra
    ↓
ProdutoCompra
    ↓
CompraDAO
    ↓
Connection
    ↓
PostgreSQL
```

Dentro da mesma transação:

```text
compra

produtos_compra

produto

contas_pagar
```

***

# 70. Resultado desta etapa

Ao concluir esta parte, nosso FerragemGK já conseguirá:

```text
Selecionar um fornecedor

Selecionar produtos ativos

Adicionar vários produtos

Evitar itens duplicados

Somar quantidades

Informar valor de custo

Calcular subtotais

Calcular o total da compra

Registrar o usuário responsável

Registrar compra à vista

Registrar compra a prazo

Preencher produtos_compra

Aumentar o estoque

Gerar parcelas automaticamente

Distribuir corretamente diferenças de centavos

Criar contas a pagar

Executar commit

Executar rollback
```

***

# 71. Próxima etapa

Depois de concluir o movimento de Compra, nós estaremos preparados para criar:

```text
FrmVenda
```

A Venda seguirá uma arquitetura semelhante, mas terá diferenças fundamentais.

Nós vamos trabalhar com:

```text
Cliente

Produtos da Venda

Preço de venda

Estoque disponível

Validação da quantidade

Saída automática do estoque

Venda à vista

Venda a prazo

Contas a receber

Transação

commit

rollback
```

Na compra nós aumentamos o estoque.

Na venda nós vamos diminuir o estoque e impedir que uma quantidade maior que a disponível seja vendida.

Essa será a próxima grande evolução do FerragemGK.
