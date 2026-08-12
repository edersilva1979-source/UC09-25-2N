CREATE INDEX idx_cliente_nome ON cliente (nome);
CREATE INDEX idx_cliente_cpf ON cliente (cpf);
CREATE INDEX idx_fornecedor_razao_social ON fornecedor (razao_social);
CREATE INDEX idx_fornecedor_cnpj ON fornecedor (cnpj);
CREATE INDEX idx_produto_descricao ON produto (descricao);
CREATE INDEX idx_venda_cliente ON venda (id_cliente);
CREATE INDEX idx_venda_data ON venda (data_venda);
CREATE INDEX idx_compra_fornecedor ON compra (id_fornecedor);
CREATE INDEX idx_compra_data ON compra (data_compra);
CREATE INDEX idx_contas_pagar_vencimento ON contas_pagar (data_vencimento);
CREATE INDEX idx_contas_pagar_status ON contas_pagar (status);
CREATE INDEX idx_contas_receber_vencimento ON contas_receber (data_vencimento);
CREATE INDEX idx_contas_receber_status ON contas_receber (status);

INSERT INTO usuario (
    nome,
    login,
    senha,
    nivel,
    ativo
)
VALUES (
    'Administrador',
    'master',
    '1234',
    'MASTER',
    TRUE
);
