CREATE DATABASE estacionamento;
USE estacionamento;

CREATE TABLE empresa (
	idEmpresa int primary key auto_increment,
    login varchar(30) NOT NULL,
    senha varchar(15)NOT NULL,
    email varchar(50) NOT NULL,
    cnpj char(18) NOT NULL,
    razaoSocial varchar(30) NOT NULL,
    telefone char(10) NOT NULL);
    
DESC empresa;

CREATE TABLE vaga (
	idVaga char(3) primary key,
    andar int NOT NULL,
    blocoVaga char(1) NOT NULL);

DESC vaga;

INSERT INTO empresa (idEmpresa, login, senha, email, cnpj, razaoSocial, telefone) VALUES
    (null, 'carropark', 'car3923par', 'carropark@estacionamentos.com', '21.433.913/0001-71', 'Carro Park', '1134552317'),
    (null, 'stationcar', 's1t2c4', 'stationcar@estacionamentos.com', '27.569.103/0001-23', 'Station Car', '1163371828'),
    (null, 'commapark', '@33cccc6', 'commapark@estacionamentos.com', '63.992.149/0001-14', 'Comma Park', '1122145367');

UPDATE empresa SET razaoSocial = 'Comma Park Ltda.' WHERE idEmpresa = 3;

DELETE FROM empresa WHERE idEmpresa = 2;

SELECT * FROM empresa;

INSERT INTO vaga (idVaga, andar, blocoVaga) VALUES
    ('A1', 1, 'A'),
    ('A2', 1, 'A'),
    ('A3', 1, 'A'),
    ('A4', 1, 'A'),
    ('A5', 1, 'A'),
    ('B1', 1, 'B'),
    ('B2', 1, 'B'),
    ('B3', 1, 'B'),
    ('B4', 1, 'B'),
    ('B5', 1, 'B'),
    ('C1', 1, 'C'),
    ('C2', 1, 'C'),
    ('C3', 1, 'C'),
    ('C4', 1, 'C'),
    ('C5', 1, 'C');

SELECT idVaga, blocoVaga FROM vaga WHERE blocoVaga = 'A';