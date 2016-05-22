-- CRIAR BANCO DE DADOS
CREATE DATABASE SURNF;


-- USAR O BANCO DE DADOS
USE SURNF;


-- CRIAR TABELA ENDERECO
CREATE TABLE endereco(
	endereco_id INT UNSIGNED AUTO_INCREMENT,
    tipo_logradouro_sn NVARCHAR(20),
    logradouro_ln NVARCHAR(50),
    numero INT UNSIGNED,
    complemento_ln NVARCHAR(50),
    bairro_ln NVARCHAR(50),
    cidade_ln NVARCHAR(50),
    cep_sn VARCHAR(8),
    estado_sn VARCHAR(2),
    pais_sn NVARCHAR(20),
    PRIMARY KEY(endereco_id)
);


-- INSERT EM ENDERECO
INSERT INTO endereco(
	   tipo_logradouro_sn, logradouro_ln, numero, complemento_ln, bairro_ln, cidade_ln, cep_sn,     estado_sn, pais_sn) 
values ( "Rua",            "A",           1,     "Complemento",   "Bairro",  "Cidade",  "00000000", "ES",      "Brasil");

-- SELECT EM ENDERECO / substitua @id
SELECT * FROM endereco WHERE endereco_id = @id;
SELECT * FROM endereco;


-- APAGAR TABELA ENDERECO
DROP TABLE endereco;


-- DELETES EM ENDERECO
DELETE FROM endereco WHERE endereco_id = 2;


-- resetar auto increment
ALTER TABLE endereco AUTO_INCREMENT=1;

