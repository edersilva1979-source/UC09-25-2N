# Projeto FerragemGK

# Parte 8: Movimento de Venda, Baixa de Estoque e Geração de Contas a Receber

Nesta etapa, nós vamos criar juntos o movimento de vendas do FerragemGK.

Nós já aprendemos a registrar compras, aumentar estoque e gerar contas a pagar. Agora nós vamos aplicar a mesma lógica profissional no sentido contrário.

Na venda nós vamos trabalhar com:

```text
Cliente
Usuário conectado
Venda
Produtos da Venda
Produto
Estoque
Contas a Receber
```

Quando a venda for à vista, nós vamos registrar a venda, os itens e diminuir o estoque.

Quando a venda for a prazo, além dessas operações, nós também vamos gerar automaticamente as parcelas na tabela `contas_receber`.

Toda a finalização será protegida por uma transação:

```text
setAutoCommit(false)
commit()
rollback()
```

Se qualquer etapa apresentar erro, todas as alterações daquela venda serão desfeitas.

***

# 1. Fluxo completo da venda

```text
FrmPrincipal
    ↓
Movimentos
    ↓
Vendas
    ↓
FrmVenda
    ↓
Selecionar cliente
    ↓
Adicionar produtos
    ↓
Verificar estoque
    ↓
Calcular total
    ↓
Escolher forma de pagamento
    ↓
Finalizar Venda
    ↓
Gravar venda
    ↓
Gravar produtos_venda
    ↓
Diminuir estoque
    ↓
Venda a prazo?
    ↓
SIM
    ↓
Gerar contas_receber
    ↓
commit
```

Se ocorrer algum erro:

```text
Erro
    ↓
rollback
    ↓
Nenhuma alteração é confirmada
```

***

# 2. Tabelas utilizadas

Nós vamos trabalhar com:

```text
cliente
produto
venda
produtos_venda
contas_receber
usuario
```

A tabela `venda` será o cabeçalho da operação.

A tabela `produtos_venda` guardará os itens vendidos.

A tabela `contas_receber` guardará as parcelas das vendas a prazo.

***

# 3. Estrutura do projeto

Nesta etapa nós vamos acrescentar:

```text
model
    Venda.java
    ProdutoVenda.java
    ContaReceber.java

dao
    VendaDAO.java

view
    FrmVenda.java
```

Também vamos acrescentar métodos em `ClienteDAO` e reutilizar os métodos já criados em `ProdutoDAO`.

***

# 4. Criando a classe Venda

No pacote `model`, nós vamos criar `Venda.java`.

```java
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private long idVenda;
    private long idCliente;
    private long idUsuario;
    private LocalDateTime dataVenda;
    private String formaPagamento;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private String status;

    private final List<ProdutoVenda> itens =
            new ArrayList<>();

    public Venda() {
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
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

    public List<ProdutoVenda> getItens() {
        return itens;
    }

    public void adicionarItem(ProdutoVenda item) {
        itens.add(item);
    }
}
```

***

# 5. Criando ProdutoVenda

```java
package model;

import java.math.BigDecimal;

public class ProdutoVenda {

    private long idProdutoVenda;
    private long idVenda;
    private Produto produto;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal subtotal;

    public ProdutoVenda() {
    }

    public long getIdProdutoVenda() {
        return idProdutoVenda;
    }

    public void setIdProdutoVenda(long idProdutoVenda) {
        this.idProdutoVenda = idProdutoVenda;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
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

***

# 6. Criando ContaReceber

```java
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaReceber {

    private long idContaReceber;
    private long idVenda;
    private int numeroParcela;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private BigDecimal valorParcela;
    private BigDecimal valorRecebido;
    private LocalDate dataRecebimento;
    private String status;

    public ContaReceber() {
    }

    public long getIdContaReceber() {
        return idContaReceber;
    }

    public void setIdContaReceber(long idContaReceber) {
        this.idContaReceber = idContaReceber;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
```

***

# 7. Exibindo Cliente no JComboBox

Na classe `Cliente`, acrescente:

```java
@Override
public String toString() {

    return nome;
}
```

***

# 8. Listando clientes ativos

Na `ClienteDAO`, acrescente:

```java
public List<Cliente> listarAtivos() {

    List<Cliente> clientes =
            new ArrayList<>();

    String sql =
            "SELECT * "
            + "FROM cliente "
            + "WHERE ativo = TRUE "
            + "ORDER BY nome";

    try (
            Connection conexao =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery()
    ) {

        while (rs.next()) {

            clientes.add(
                    montarCliente(rs)
            );
        }

    } catch (SQLException erro) {

        throw new RuntimeException(
                "Erro ao listar clientes ativos.",
                erro
        );
    }

    return clientes;
}
```

***

# 9. Criando VendaDAO

No pacote `dao`, nós vamos criar `VendaDAO.java`.

```java
package dao;

import conexao.Conexao;

import model.ContaReceber;
import model.ProdutoVenda;
import model.Venda;

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

public class VendaDAO {

    public long finalizarVenda(
            Venda venda,
            LocalDate primeiroVencimento
    ) {

        try (
                Connection conexao =
                        Conexao.conectar()
        ) {

            conexao.setAutoCommit(false);

            try {

                validarEstoque(
                        conexao,
                        venda
                );

                long idVenda =
                        inserirVenda(
                                conexao,
                                venda
                        );

                for (
                        ProdutoVenda item :
                        venda.getItens()
                ) {

                    inserirItem(
                            conexao,
                            idVenda,
                            item
                    );

                    baixarEstoque(
                            conexao,
                            item
                    );
                }

                if (
                        venda
                        .getFormaPagamento()
                        .equals("PARCELADO")
                ) {

                    List<ContaReceber> parcelas =
                            gerarParcelas(
                                    idVenda,
                                    venda.getValorTotal(),
                                    venda.getQuantidadeParcelas(),
                                    primeiroVencimento
                            );

                    for (
                            ContaReceber conta :
                            parcelas
                    ) {

                        inserirContaReceber(
                                conexao,
                                conta
                        );
                    }
                }

                conexao.commit();

                return idVenda;

            } catch (Exception erro) {

                conexao.rollback();

                throw new RuntimeException(
                        "A venda foi cancelada porque ocorreu um erro.",
                        erro
                );
            }

        } catch (SQLException erro) {

            throw new RuntimeException(
                    "Erro ao finalizar venda.",
                    erro
            );
        }
    }

    private void validarEstoque(
            Connection conexao,
            Venda venda
    ) throws SQLException {

        String sql =
                "SELECT descricao, estoque "
                + "FROM produto "
                + "WHERE id_produto = ? "
                + "AND ativo = TRUE "
                + "FOR UPDATE";

        for (
                ProdutoVenda item :
                venda.getItens()
        ) {

            try (
                    PreparedStatement stmt =
                            conexao.prepareStatement(sql)
            ) {

                stmt.setLong(
                        1,
                        item
                        .getProduto()
                        .getIdProduto()
                );

                try (
                        ResultSet rs =
                                stmt.executeQuery()
                ) {

                    if (!rs.next()) {

                        throw new SQLException(
                                "Produto não encontrado ou inativo."
                        );
                    }

                    BigDecimal estoqueAtual =
                            rs.getBigDecimal(
                                    "estoque"
                            );

                    if (
                            estoqueAtual.compareTo(
                                    item.getQuantidade()
                            ) < 0
                    ) {

                        throw new SQLException(
                                "Estoque insuficiente para o produto: "
                                + rs.getString(
                                        "descricao"
                                )
                        );
                    }
                }
            }
        }
    }

    private long inserirVenda(
            Connection conexao,
            Venda venda
    ) throws SQLException {

        String sql =
                "INSERT INTO venda ("
                + "id_cliente, "
                + "id_usuario, "
                + "forma_pagamento, "
                + "quantidade_parcelas, "
                + "valor_total, "
                + "status"
                + ") VALUES (?, ?, ?, ?, ?, ?) "
                + "RETURNING id_venda";

        try (
                PreparedStatement stmt =
                        conexao.prepareStatement(sql)
        ) {

            stmt.setLong(1, venda.getIdCliente());
            stmt.setLong(2, venda.getIdUsuario());
            stmt.setString(3, venda.getFormaPagamento());
            stmt.setInt(4, venda.getQuantidadeParcelas());
            stmt.setBigDecimal(5, venda.getValorTotal());
            stmt.setString(6, "FINALIZADA");

            try (
                    ResultSet rs =
                            stmt.executeQuery()
            ) {

                if (rs.next()) {

                    return rs.getLong(
                            "id_venda"
                    );
                }
            }
        }

        throw new SQLException(
                "Não foi possível gerar o código da venda."
        );
    }

    private void inserirItem(
            Connection conexao,
            long idVenda,
            ProdutoVenda item
    ) throws SQLException {

        String sql =
                "INSERT INTO produtos_venda ("
                + "id_venda, "
                + "id_produto, "
                + "quantidade, "
                + "valor_unitario, "
                + "subtotal"
                + ") VALUES (?, ?, ?, ?, ?)";

        try (
                PreparedStatement stmt =
                        conexao.prepareStatement(sql)
        ) {

            stmt.setLong(1, idVenda);
            stmt.setLong(
                    2,
                    item
                    .getProduto()
                    .getIdProduto()
            );
            stmt.setBigDecimal(3, item.getQuantidade());
            stmt.setBigDecimal(4, item.getValorUnitario());
            stmt.setBigDecimal(5, item.getSubtotal());

            stmt.executeUpdate();
        }
    }

    private void baixarEstoque(
            Connection conexao,
            ProdutoVenda item
    ) throws SQLException {

        String sql =
                "UPDATE produto "
                + "SET estoque = estoque - ? "
                + "WHERE id_produto = ? "
                + "AND ativo = TRUE "
                + "AND estoque >= ?";

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

            stmt.setBigDecimal(
                    3,
                    item.getQuantidade()
            );

            int linhas =
                    stmt.executeUpdate();

            if (linhas == 0) {

                throw new SQLException(
                        "Não foi possível baixar o estoque de "
                        + item
                        .getProduto()
                        .getDescricao()
                );
            }
        }
    }

    private List<ContaReceber> gerarParcelas(
            long idVenda,
            BigDecimal total,
            int quantidadeParcelas,
            LocalDate primeiroVencimento
    ) {

        List<ContaReceber> contas =
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

            ContaReceber conta =
                    new ContaReceber();

            conta.setIdVenda(idVenda);
            conta.setNumeroParcela(indice + 1);
            conta.setDataEmissao(LocalDate.now());

            conta.setDataVencimento(
                    primeiroVencimento
                    .plusMonths(indice)
            );

            conta.setValorParcela(valorParcela);
            conta.setValorRecebido(BigDecimal.ZERO);
            conta.setStatus("ABERTA");

            contas.add(conta);
        }

        return contas;
    }

    private void inserirContaReceber(
            Connection conexao,
            ContaReceber conta
    ) throws SQLException {

        String sql =
                "INSERT INTO contas_receber ("
                + "id_venda, "
                + "numero_parcela, "
                + "data_emissao, "
                + "data_vencimento, "
                + "valor_parcela, "
                + "valor_recebido, "
                + "status"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement stmt =
                        conexao.prepareStatement(sql)
        ) {

            stmt.setLong(1, conta.getIdVenda());
            stmt.setInt(2, conta.getNumeroParcela());

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

            stmt.setBigDecimal(5, conta.getValorParcela());
            stmt.setBigDecimal(6, conta.getValorRecebido());
            stmt.setString(7, conta.getStatus());

            stmt.executeUpdate();
        }
    }
}
```

A validação de estoque ocorre novamente no banco, dentro da transação. Isso protege a regra mesmo que o valor exibido na tela esteja desatualizado.

***

# 10. Criando a FrmVenda

No pacote `view`, nós vamos criar:

```text
FrmVenda
```

como `JInternalFrame Form`.

Configure:

```text
Title
Movimento de Venda

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

# 11. Componentes da FrmVenda

Nós vamos criar:

```text
Código da Venda
Cliente
Produto
Estoque Disponível
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
Nova Venda
Finalizar Venda
Cancelar
```

Nomes:

```text
txtCodigoVenda
cmbCliente
cmbProduto
lblEstoqueDisponivel
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
btnNovaVenda
btnFinalizarVenda
btnCancelar
grpPagamento
```

***

# 12. Estrutura visual sugerida

```text
============================================================

MOVIMENTO DE VENDA

Código: [          ]

Cliente:
[                                             ]

Produto:
[                                             ]

Estoque disponível: 0,000

Quantidade: [          ]
Valor Unitário: [          ]

[ Adicionar Produto ]

============================================================

Itens da Venda

Código | Produto | Quantidade | Valor | Subtotal

============================================================

[ Remover Produto ]

Total da Venda: R$ 0,00

Forma de Pagamento

( ) À Vista
( ) A Prazo

Parcelas: [ 2 ]

Primeiro Vencimento: [ 10/09/2026 ]

============================================================

[ Nova Venda ] [ Finalizar Venda ] [ Cancelar ]

============================================================
```


***

# 13. Imports da FrmVenda

```java
import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;

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

import model.Cliente;
import model.Produto;
import model.ProdutoVenda;
import model.Venda;

import util.SessaoUsuario;
```

***

# 14. Variáveis da FrmVenda

```java
private final VendaDAO vendaDAO =
        new VendaDAO();

private final ClienteDAO clienteDAO =
        new ClienteDAO();

private final ProdutoDAO produtoDAO =
        new ProdutoDAO();

private final List<ProdutoVenda> itensVenda =
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

# 15. Construtor

```java
public FrmVenda() {

    initComponents();

    configurarTela();

    carregarClientes();

    carregarProdutos();

    novaVenda();
}
```

***

# 16. Método configurarTela

```java
private void configurarTela() {

    txtCodigoVenda.setEditable(
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

# 17. Modelo da JTable

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

# 18. Carregando clientes

```java
private void carregarClientes() {

    try {

        List<Cliente> clientes =
                clienteDAO.listarAtivos();

        DefaultComboBoxModel<Cliente> modelo =
                new DefaultComboBoxModel<>();

        for (
                Cliente cliente :
                clientes
        ) {

            modelo.addElement(
                    cliente
            );
        }

        cmbCliente.setModel(
                modelo
        );

        cmbCliente.setSelectedItem(
                null
        );

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar clientes.\n"
                + erro.getMessage()
        );
    }
}
```

***

# 19. Carregando produtos

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

# 20. Exibindo estoque e preço de venda

No evento do `cmbProduto`:

```java
private void cmbProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    Produto produto =
            (Produto)
            cmbProduto.getSelectedItem();

    if (produto != null) {

        lblEstoqueDisponivel.setText(
                formatoQuantidade.format(
                        produto.getEstoque()
                )
        );

        txtValorUnitario.setText(
                produto
                .getPrecoVenda()
                .toPlainString()
                .replace(".", ",")
        );

    } else {

        lblEstoqueDisponivel.setText(
                "0,000"
        );

        txtValorUnitario.setText(
                ""
        );
    }
}
```

***

# 21. Convertendo valores digitados

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

***

# 22. Quantidade já adicionada

```java
private BigDecimal quantidadeJaAdicionada(
        long idProduto
) {

    for (
            ProdutoVenda item :
            itensVenda
    ) {

        if (
                item
                .getProduto()
                .getIdProduto()
                == idProduto
        ) {

            return item.getQuantidade();
        }
    }

    return BigDecimal.ZERO;
}
```

***

# 23. Adicionando produto com validação de estoque

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

        BigDecimal quantidadeAtual =
                quantidadeJaAdicionada(
                        produto.getIdProduto()
                );

        BigDecimal quantidadeTotal =
                quantidadeAtual.add(
                        quantidade
                );

        if (
                quantidadeTotal.compareTo(
                        produto.getEstoque()
                ) > 0
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Estoque insuficiente.\n"
                    + "Disponível: "
                    + formatoQuantidade.format(
                            produto.getEstoque()
                    )
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

# 24. Evitando produto duplicado

```java
private void adicionarOuSomarItem(
        Produto produto,
        BigDecimal quantidade,
        BigDecimal valorUnitario
) {

    for (
            ProdutoVenda item :
            itensVenda
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

    ProdutoVenda novoItem =
            new ProdutoVenda();

    novoItem.setProduto(
            produto
    );

    novoItem.setQuantidade(
            quantidade
    );

    novoItem.setValorUnitario(
            valorUnitario
    );

    itensVenda.add(
            novoItem
    );
}
```

Evento:

```java
private void btnAdicionarProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    adicionarProduto();
}
```

***

# 25. Atualizando a tabela

```java
private void atualizarTabelaItens() {

    DefaultTableModel modelo =
            (DefaultTableModel)
            tblItens.getModel();

    modelo.setRowCount(0);

    for (
            ProdutoVenda item :
            itensVenda
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

# 26. Calculando o total

```java
private void calcularTotal() {

    valorTotal =
            BigDecimal.ZERO;

    for (
            ProdutoVenda item :
            itensVenda
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

# 27. Limpando o item

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

    lblEstoqueDisponivel.setText(
            "0,000"
    );
}
```

***

# 28. Removendo item

```java
private void btnRemoverProdutoActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int linha =
            tblItens.getSelectedRow();

    if (linha < 0) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione um produto da venda."
        );

        return;
    }

    itensVenda.remove(
            linha
    );

    atualizarTabelaItens();

    calcularTotal();
}
```

***

# 29. Pagamento à vista e a prazo

Na tela:

```text
À Vista
A Prazo
```

No banco:

```text
AVISTA
PARCELADO
```

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

# 30. Nova venda

```java
private void novaVenda() {

    txtCodigoVenda.setText(
            ""
    );

    cmbCliente.setSelectedItem(
            null
    );

    itensVenda.clear();

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

***

# 31. Validando a venda

```java
private boolean validarVenda() {

    if (
            cmbCliente.getSelectedItem()
            == null
    ) {

        JOptionPane.showMessageDialog(
                this,
                "Selecione o cliente."
        );

        return false;
    }

    if (
            itensVenda.isEmpty()
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
                "O total da venda deve ser maior que zero."
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

# 32. Criando o objeto Venda

```java
private Venda criarVenda() {

    Cliente cliente =
            (Cliente)
            cmbCliente.getSelectedItem();

    Venda venda =
            new Venda();

    venda.setIdCliente(
            cliente.getIdCliente()
    );

    venda.setIdUsuario(
            SessaoUsuario
            .getUsuarioLogado()
            .getIdUsuario()
    );

    if (
            rdbPrazo.isSelected()
    ) {

        venda.setFormaPagamento(
                "PARCELADO"
        );

        venda.setQuantidadeParcelas(
                (Integer)
                spnParcelas.getValue()
        );

    } else {

        venda.setFormaPagamento(
                "AVISTA"
        );

        venda.setQuantidadeParcelas(
                1
        );
    }

    venda.setValorTotal(
            valorTotal
    );

    venda.setStatus(
            "FINALIZADA"
    );

    for (
            ProdutoVenda item :
            itensVenda
    ) {

        venda.adicionarItem(
                item
        );
    }

    return venda;
}
```

***

# 33. Primeiro vencimento

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

# 34. Finalizando a venda

```java
private void btnFinalizarVendaActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!validarVenda()) {

        return;
    }

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja finalizar esta venda?",
                    "Finalizar Venda",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            != JOptionPane.YES_OPTION
    ) {

        return;
    }

    try {

        Venda venda =
                criarVenda();

        LocalDate primeiroVencimento =
                obterPrimeiroVencimento();

        long codigo =
                vendaDAO.finalizarVenda(
                        venda,
                        primeiroVencimento
                );

        JOptionPane.showMessageDialog(
                this,
                "Venda finalizada com sucesso.\n"
                + "Código: "
                + codigo
        );

        novaVenda();

        carregarProdutos();

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível finalizar a venda.\n"
                + erro.getMessage()
        );
    }
}
```

***

# 35. Botão Cancelar

```java
private void btnCancelarActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja cancelar os dados desta venda?",
                    "Cancelar",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            == JOptionPane.YES_OPTION
    ) {

        novaVenda();
    }
}
```

***

# 36. Ligando FrmVenda à FrmPrincipal

Na `FrmPrincipal`:

```java
private void mnuVendasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmVenda()
    );
}
```

***

# 37. Permissões

Tanto `MASTER` quanto `USER` poderão realizar vendas.

A venda finalizada não será excluída diretamente.

Se futuramente nós criarmos cancelamento, precisaremos estornar estoque e financeiro de maneira controlada.

***

# 38. Venda à vista

Ao finalizar uma venda à vista:

```text
venda
    recebe o cabeçalho

produtos_venda
    recebe os itens

produto
    recebe a baixa de estoque
```

Nenhuma parcela será criada em `contas_receber`.

***

# 39. Venda a prazo

Ao finalizar uma venda a prazo:

```text
venda
    recebe o cabeçalho

produtos_venda
    recebe os itens

produto
    recebe a baixa de estoque

contas_receber
    recebe as parcelas
```

***

# 40. Consultando a venda

```sql
SELECT *
FROM venda
ORDER BY id_venda DESC;
```

***

# 41. Consultando produtos_venda

```sql
SELECT *
FROM produtos_venda
ORDER BY id_produto_venda DESC;
```

***

# 42. Conferindo o estoque

```sql
SELECT
    id_produto,
    descricao,
    estoque
FROM produto
ORDER BY descricao;
```

***

# 43. Conferindo contas a receber

```sql
SELECT *
FROM contas_receber
ORDER BY
    id_venda DESC,
    numero_parcela;
```

***

# 44. Consulta com cliente

```sql
SELECT
    v.id_venda,
    v.data_venda,
    c.nome AS cliente,
    v.valor_total,
    v.forma_pagamento,
    v.quantidade_parcelas,
    v.status
FROM venda v
INNER JOIN cliente c
    ON c.id_cliente =
       v.id_cliente
ORDER BY v.id_venda DESC;
```

***

# 45. Consulta dos itens vendidos

```sql
SELECT
    v.id_venda,
    p.descricao,
    pv.quantidade,
    pv.valor_unitario,
    pv.subtotal
FROM produtos_venda pv
INNER JOIN venda v
    ON v.id_venda =
       pv.id_venda
INNER JOIN produto p
    ON p.id_produto =
       pv.id_produto
ORDER BY
    v.id_venda DESC,
    p.descricao;
```

***

# 46. Consulta com usuário responsável

```sql
SELECT
    v.id_venda,
    v.data_venda,
    c.nome AS cliente,
    u.nome AS usuario,
    v.valor_total,
    v.forma_pagamento,
    v.status
FROM venda v
INNER JOIN cliente c
    ON c.id_cliente =
       v.id_cliente
INNER JOIN usuario u
    ON u.id_usuario =
       v.id_usuario
ORDER BY v.id_venda DESC;
```

***

# 47. Testando estoque insuficiente

Considere:

```text
Produto
Furadeira

Estoque disponível
3
```

Tente vender:

```text
Quantidade
5
```

A tela deverá impedir a inclusão.

Mesmo assim, a `VendaDAO` fará uma segunda validação antes de confirmar a operação.

***

# 48. Por que validar duas vezes

A tela melhora a experiência do usuário.

A DAO protege a regra de negócio.

Entre a seleção do produto e a finalização da venda, outra operação pode alterar o estoque.

Por isso nós consultamos novamente o banco dentro da transação.

***

# 49. Testando rollback

Provoque temporariamente um erro em `inserirContaReceber`.

Depois tente finalizar uma venda a prazo.

O sistema deverá desfazer:

```text
Cabeçalho da venda
Itens da venda
Baixa de estoque
Contas a receber
```

Nenhuma etapa deve permanecer parcialmente gravada.

***

# 50. Não vamos excluir vendas finalizadas

Uma venda altera:

```text
Estoque
Financeiro
Histórico do cliente
Produtos vendidos
```

Por isso nós não vamos criar um simples DELETE para uma venda finalizada.

***

# 51. Futuro cancelamento de venda

Se nós criarmos cancelamento, o sistema deverá:

```text
Verificar o status da venda

Verificar parcelas já recebidas

Devolver produtos ao estoque

Cancelar contas a receber abertas

Preservar o histórico

Alterar a venda para CANCELADA
```

***

# 52. Diferença entre Compra e Venda

Na Compra:

```text
Fornecedor
Preço de custo
Entrada no estoque
Contas a pagar
```

Na Venda:

```text
Cliente
Preço de venda
Saída do estoque
Contas a receber
```

***

# 53. Métodos principais da FrmVenda

```text
configurarTela

criarModeloTabela

carregarClientes

carregarProdutos

converterDecimal

quantidadeJaAdicionada

adicionarProduto

adicionarOuSomarItem

atualizarTabelaItens

calcularTotal

limparItem

atualizarCamposPagamento

novaVenda

validarVenda

criarVenda

obterPrimeiroVencimento
```

***

# 54. Métodos principais da VendaDAO

```text
finalizarVenda

validarEstoque

inserirVenda

inserirItem

baixarEstoque

gerarParcelas

inserirContaReceber
```

***

# 55. Recursos utilizados

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

Controle de estoque

FOR UPDATE

Transações

commit

rollback

Parcelamento

Contas a receber

Regras de negócio
```

***

# 56. Arquitetura da venda

```text
FrmVenda
    ↓
Venda
    ↓
ProdutoVenda
    ↓
VendaDAO
    ↓
Connection
    ↓
PostgreSQL
```

Dentro da mesma transação:

```text
venda

produtos_venda

produto

contas_receber
```

***

# 57. Resultado desta etapa

Ao concluir esta parte, nosso FerragemGK já conseguirá:

```text
Selecionar cliente

Selecionar produtos ativos

Mostrar estoque disponível

Adicionar vários produtos

Impedir venda acima do estoque

Evitar produto duplicado

Somar quantidades

Usar preço de venda

Calcular subtotal

Calcular total

Registrar usuário responsável

Registrar venda à vista

Registrar venda a prazo

Preencher produtos_venda

Baixar estoque

Gerar parcelas

Criar contas a receber

Executar commit

Executar rollback
```

***

# 58. Próxima etapa

Depois da Compra e da Venda, nós já teremos o núcleo comercial funcionando.

A próxima etapa será criar os módulos financeiros:

```text
FrmContasPagar

FrmContasReceber
```

Neles nós vamos trabalhar com:

```text
Consultas

Filtros

Contas abertas

Contas pagas

Contas recebidas

Contas vencidas

Data de vencimento

Baixa financeira

Valor pago

Valor recebido

Data de pagamento

Data de recebimento

Controle de permissão

MASTER

Atualização de status
```

Assim nós vamos completar o ciclo comercial do FerragemGK, desde a entrada do produto até o pagamento e o recebimento das operações.
