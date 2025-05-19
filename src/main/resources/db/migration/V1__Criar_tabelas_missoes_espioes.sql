-- V1__Criar_tabelas_missoes_espioes.sql
CREATE TABLE missoes (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    dificuldade CHAR(1) NOT NULL,
    descricao VARCHAR(250)
);

CREATE TABLE espioes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    rank VARCHAR(20) NOT NULL,
    missao_id BIGINT REFERENCES missoes(id)
);