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
select * from pet;
select * from cliente;
select * from endereco;
insert into cliente(nome, telFixo, telCel) values
	('Lucas',1134567889,11912345678)
	('',,)
	('',,)
	('',,)
	('',,);