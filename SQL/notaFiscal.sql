
-- BANCO DE DADOS
USE SURNF;

-- CRIAR TABELA NOTA FISCAL
CREATE TABLE nota_fiscal(
	nota_fiscal_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    tomador_id INT UNSIGNED,
    tomador_estrangeiro_bl BOOL,
    informacoes_adicionais_tx TEXT,
    atividade_tx TEXT,
    valor_fl FLOAT,
    valor_ir_fl FLOAT,
    valor_inss_fl FLOAT,
    valor_cofins_fl FLOAT,
    valor_pis_pasep_fl FLOAT,
    csll_fl FLOAT,
    valor_outros_impostos_fl FLOAT,
    substituicao_tributaria_bl BOOL,
    notificar_tomador_por_email_bl BOOL,
    endereco_prestacao_servico_tx TEXT,
    cidade_prestacao_servico_sn VARCHAR(20),
    cep_prestacao_servico_sn VARCHAR(8),
    estado_prestacao_servico_sn VARCHAR(2),
    
    PRIMARY KEY (nota_fiscal_id),
    FOREIGN KEY (tomador_id) REFERENCES tomador(tomador_id)
);

-- DELETAR A TABELA NOTA FISCAL
DROP TABLE nota_fiscal;

-- CONSULTAR A TABELA NOTA FISCAL
SELECT * FROM nota_fiscal;
SELECT * FROM nota_fiscal WHERE nota_fiscal_id = @id;

-- INSERIR DADOS NA TABELA
INSERT INTO nota_fiscal(
	tomador_id,  tomador_estrangeiro_bl, informacoes_adicionais_tx, atividade_tx,
    valor_fl, valor_ir_fl, valor_inss_fl, valor_cofins_fl, valor_pis_pasep_fl, csll_fl,
    valor_outros_impostos_fl, substituicao_tributaria_bl, notificar_tomador_por_email_bl,
    cidade_prestacao_servico_sn, endereco_prestacao_servico_tx, cep_prestacao_servico_sn,
    estado_prestacao_servico_sn
) VALUES (1, false, "inf adc", "atv", 1000.00, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, false, false, "cidade prest serv",
			"end prest serv", "00000000", "ES");
            

-- DELETAR DADOS DA TABELA NOTA FISCAL

DELETE FROM nota_fiscal WHERE nota_fiscal_id = 1;

-- RESETAR AUTO INCREMENT
ALTER TABLE nota_fiscal AUTO_INCREMENT=1;