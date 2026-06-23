-- ============================================================
-- NutriTrack - Aplicativo de Rastreamento Nutricional
-- e Planejamento Dietetico (Foco em Bulking/Macros)
-- Script de criacao do banco de dados (PostgreSQL)
-- ============================================================

-- Caso deseje criar o banco antes de rodar o restante do script,
-- execute a linha abaixo separadamente (fora de uma transacao/psql -d):
-- CREATE DATABASE bulking_db;

-- Conecte-se ao banco "bulking_db" antes de continuar.

DROP TABLE IF EXISTS ItemRefeicao;
DROP TABLE IF EXISTS Refeicao;
DROP TABLE IF EXISTS RegistroPeso;
DROP TABLE IF EXISTS Alimento;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    peso_atual DECIMAL(5,2),
    altura DECIMAL(4,2),
    meta_calorica INT,
    meta_proteina INT,
    objetivo VARCHAR(20) -- 'bulking', 'cutting', 'manutencao'
);

CREATE TABLE Categoria (
    id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE Alimento (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    calorias_100g DECIMAL(6,2) NOT NULL,
    proteina_100g DECIMAL(5,2) NOT NULL,
    carboidrato_100g DECIMAL(5,2) NOT NULL,
    gordura_100g DECIMAL(5,2) NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
);

CREATE TABLE Refeicao (
    id INT PRIMARY KEY,
    usuario_id INT NOT NULL,
    nome VARCHAR(50) NOT NULL, -- 'Cafe da manha', 'Almoco', etc.
    data DATE NOT NULL,
    hora TIME,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE ItemRefeicao (
    id INT PRIMARY KEY,
    refeicao_id INT NOT NULL,
    alimento_id INT NOT NULL,
    quantidade_gramas DECIMAL(6,2) NOT NULL,
    FOREIGN KEY (refeicao_id) REFERENCES Refeicao(id) ON DELETE CASCADE,
    FOREIGN KEY (alimento_id) REFERENCES Alimento(id)
);

CREATE TABLE RegistroPeso (
    id INT PRIMARY KEY,
    usuario_id INT NOT NULL,
    data DATE NOT NULL,
    peso_kg DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);
