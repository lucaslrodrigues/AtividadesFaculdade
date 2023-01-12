show databases;
create database estudos;
use estudos;

create table Atleta(
idAtleta int primary key auto_increment,
nome varchar (40) unique,
modalidade varchar(40),
qtdMedalha int);

alter table Atleta add constraint tipeModalidade check (modalidade in ('Atletismo', 'Salto com vara', 'Polo Aquatico'));

create table Pais(
idPais int primary key auto_increment,
nome varchar(40) unique,
capital varchar(40) unique);

insert into Atleta (nome, modalidade, qtdMedalha) values
	('Alisson dos Santos','Atletismo',1),
    ('Érika Sena','Atletismo',1),
    ('Jo Soares', 'Atletismo',3),
    ('Julian Casablancas','Salto com vara',6),
    ('Alex Turner','Polo Aquatico',0);

insert into Pais(nome, capital) Values
	('Brasil','Brasilia'),
    ('Colombia','Bogotá'),
    ('USA','Washington'),
    ('Russia','Moscou');
    
alter table Atleta add column fkAtleta int;
alter table Atleta add constraint chkAtleta foreign key (fkAtleta) references Pais(idPais);

select * from Atleta;
select * from Pais;

update Atleta set fkAtleta = 1 where idAtleta in (1,2);
update Atleta set fkAtleta = 2 where idAtleta = 3;
update Atleta set fkAtleta = 3 where idAtleta = 4;
update Atleta set fkAtleta = 4 where idAtleta = 5;

select * from Atleta join Pais on idPais = fkAtleta;

select a.nome as "Nome" , p.nome as "Pais" from Atleta as a join Pais as p on p.idPais = fkAtleta;

select a.*, p.nome as "Pais" from Atleta as a join Pais as p on p.idPais = fkAtleta where capital = "Brasilia";
select a.*, p.nome as "Pais" from Atleta as a join Pais as p on p.idPais = fkAtleta where a.nome = "Jo Soares";