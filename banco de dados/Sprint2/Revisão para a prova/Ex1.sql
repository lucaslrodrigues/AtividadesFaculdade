create database pratica;
use pratica;

create table pet(
idPet int primary key auto_increment,
tipo varchar(30),
nome varchar(45),
raça varchar(45),
dtNasc date
) auto_increment 100;

create table cliente (
idCliente int primary key auto_increment,
nome varchar(45),
telefone decimal (8),
celular decimal (12),
cep decimal (8),
cidade varchar(45)
);

alter table pet add column fkCliente int;
alter table pet add constraint ctCliente foreign key (fkCliente) references cliente(idCliente);

insert into cliente (nome, telefone, celular, cep, cidade) values
	('Maria Rosalho',35426987, 11965324851, 25431222, 'São Paulo'),
	('Joana Dark',35426985, 11965423578, 24123000, 'São Paulo'),
	('Ketleyn Dark', 36528975, 11954213568, 24578001, 'ABC'),
	('Montresor Montresoles', 35426897, 11954675236, 45632001, 'ABC'),
	('Konami Playstation', 34568754, 11954234578, 42186021, 'São Paulo'),
	('Misure Rios', 34785642, 11965487456, 68547200, 'Campinas'),
    ('Monica Playstation', 34648745, 11965434574, 54785003, 'São José dos campos');

insert into pet (tipo, nome, raça, dtNasc, fkCliente) values
	('Reptiu','Betania','Camaleão', '2003-08-21',1 ),
	('Sapo','Maicon','Pedra', '2015-04-27', 2),
	('Arranha','Pica fumo','Arranha vermelha', '2017-04-27',2 ),
	('Arranha','Coração','Armadeira', '2020-03-22',2 ),
	('Roedor','Revu','Hamister', '2021-02-18', 3),
	('Roedor','Pestana','Hamister', '2020-12-30',3 ),
	('Passaro','Nina','Coruja', '2012-05-15', 4),
	('Passaro','Prumadinho','Periquito', '2020-12-21',5 ),
    ('Cachorro', 'Plank', 'Golden Retriever', '2016-11-16', 6);

select * from pet;
select * from cliente;

alter table cliente modify column nome varchar(50);

select * from pet where tipo = 'Roedor';

select (nome, dtNasc) from pet;

select * from pet order by nome asc;

select * from cliente order by cidade desc;

select * from pet where nome like 'P%';

select * from cliente where nome like '% Dark';

update cliente set nome = 'Regina Cavaliere' where idCliente = 1;

update cliente set telefone = 11965654758 where idCliente = 2;

select * from cliente;

select pet.*, c.* from pet as pet join cliente as c on pet.fkCliente = c.idCliente;

select pet.*, c.* from pet as pet join cliente as c on pet.fkCliente = c.idCliente where idCliente = 2;

delete from pet where idPet = 1;

select * from pet;

drop table cliente;

drop table pet;