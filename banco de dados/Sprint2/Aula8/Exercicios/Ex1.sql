create database faculdade;
use faculdade;
create table pet(
idPet int primary key auto_increment,
tipo varchar(45),
nome varchar(45),
raca varchar(30),
dtNasc date) auto_increment 101;

create table cliente(
idCliente int primary key auto_increment,
nome varchar(45),
telFixo decimal (10) unique,
telCel decimal (11) unique);

create table endereco(
idEnd int,
fkEnd int,
constraint ctEnd foreign key (fkEnd) references cliente(idCliente),
primary key (fkEnd, idEnd),
rua varchar(45),
cidade varchar(40),
estado varchar(30),
cep decimal (8));

insert into pet (tipo,nome, raca, dtNasc) values
	('Gato','Hanna Barbera','Persa','2015-04-11'),
    ('Gato','Leoleo','Maine Coon','2017-12-01'),
    ('Repitil','Paulinho','Iguana','2010-03-05'),
    ('Passaro','Prumadinho','Periquito','2021-07-09'),
    ('Arranha','Renegade','Tarantula','2021-10-23');

INSERT INTO cliente(nome, telFixo, telCel) VALUES
	('José Lucas Donario',1134567889,11912345678),
	('Marta Donario Veracruz',1134854896,11964587523),
	('Domenico montela',1134585647,11931563185),
	('Paulo arrentino de magalhães',1135456363,11914200344),
	('Ivon von voith',1136471568,11934664584);
    
ALTER TABLE pet ADD COLUMN fkCliente int;
ALTER TABLE pet ADD CONSTRAINT ctCiente FOREIGN KEY (fkCliente) REFERENCES cliente(idCliente);

UPDATE pet SET fkCliente = 1 WHERE idPet = 101;
UPDATE pet SET fkCliente = 2 WHERE idPet = 102;
UPDATE pet SET fkCliente = 2 WHERE idPet = 103;
UPDATE pet SET fkCliente = 3 WHERE idPet = 104;
UPDATE pet SET fkCliente = 3 WHERE idPet = 105;

INSERT INTO endereco (idEnd, fkEnd, rua, cidade, estado, cep) VALUES
	(1, 1,'Rua Dois','Parelheiros','São Paulo',04884035),
	(2, 2,'Rua Otacílio de Souza','Parque Maria Alice','São Paulo',04932260),
	(3, 3,'Rua Antônio da Silva Porto','Americanópolis','Espirito Santo',04337050),
	(4, 4,'Avenida Brigadeiro Faria Lima 1903','Jardim Avenida','Espirito Santo',05798090),
	(5, 5,'Rua Agrimensor Sugaya','Colônia','Tocantins',08260030);
    
select * from pet;
select * from cliente;
select * from endereco;

# Altere o tamanho da coluna nome do cliente
ALTER TABLE cliente MODIFY COLUMN nome varchar(50);
DESC cliente;

# Exibir os dados de todos os pets que são de um determinado tipo (por exemplo: cachorro).
SELECT * from pet WHERE tipo = 'Gato';

# Exibir apenas os nomes e as datas de nascimento dos pets
SELECT nome, dtNasc FROM pet;

# Exibir os dados dos pets ordenados em ordem crescente pelo nome
SELECT * FROM pet ORDER BY nome ASC;

# Exibir os dados dos clientes ordenados em ordem decrescente pelo bairro.
SELECT c.*, e.cidade FROM cliente AS c JOIN endereco AS e on fkEnd = idCliente;

# Exibir os dados dos pets cujo nome comece com uma determinada letra.
SELECT * FROM pet where nome LIKE 'P%';

# Exibir os dados dos clientes que têm o mesmo sobrenome.
SELECT * FROM cliente WHERE nome LIKE '%Donario%';

# Alterar o telefone de um determinado cliente
UPDATE cliente SET telFixo = 1139955476 WHERE idCliente = 3;

# Exibir os dados dos clientes para verificar se alterou.
SELECT * FROM cliente;

# Exibir os dados dos pets e dos seus respectivos donos.
SELECT p.*, c.* FROM pet AS p JOIN cliente AS c ON p.fkCliente = c.idCliente;

# Exibir os dados dos pets e dos seus respectivos donos, mas somente de um determinado cliente.
SELECT p.*, c.* FROM pet AS p JOIN cliente AS c ON p.fkCliente = c.idCliente WHERE c.idCliente = 1;

# Excluir algum pet.
DELETE FROM pet WHERE idPet = 103;

# Exibir os dados dos pets para verificar se excluiu
SELECT * FROM pet;

# Excluir as tabelas
DROP TABLE pet;
DROP TABLE endereco;
DROP TABLE cliente;