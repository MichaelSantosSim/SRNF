
USE SURNF;

-- CRIAR TABELA TOMADOR
CREATE TABLE tomador(
	tomador_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cnpj_sn VARCHAR(14),
    cpf_sn VARCHAR(11),
    inscricao_municipal_sn NVARCHAR(6),
    nome_ln NVARCHAR(50),
    endereco_id INT UNSIGNED,
    DDD int UNSIGNED,
    telefone VARCHAR(9),
    
    PRIMARY KEY (tomador_id),
    FOREIGN KEY  (endereco_id) REFERENCES endereco(endereco_id)
);

-- DELETAR A TABELA TOMADOR
DROP TABLE tomador;

-- CONSULTAR A TABELA TOMADOR
SELECT * FROM tomador;
SELECT * FROM tomador WHERE tomador_id = @id;

-- INSERIR DADOS NA TABELA TOMADOR

SET @cnpj = "12345678912345", @cpf = "13245678944", @inscricao_municipal = "123456", @nome="Jose da Silva", @endereco_id = 1, @ddd = 11, @telefone = "555555555";

INSERT INTO tomador( cnpj_sn, cpf_sn, inscricao_municipal_sn, nome_ln, endereco_id, DDD,  telefone)
			 VALUES(@cnpj,   @cpf,   @inscricao_municipal,   @nome,  @endereco_id, @ddd, @telefone);
				 
-- DELETAR DADOS DA TABELA TOMADOR

DELETE FROM tomador WHERE tomador_id = @id;

-- RESETAR AUTO INCREMENT

ALTER TABLE tomador AUTO_INCREMENT=1;