CREATE DATABASE sprint2;
USE sprint2;

CREATE TABLE Atleta(
idAtleta int primary key auto_increment,
nome varchar(40),
modalidade varchar(40),
qtdMedalha int
);

CREATE TABLE Pais(
idPais int primary key auto_increment,
nome varchar(30),
capital varchar(40)
);

insert into Atleta (nome, modalidade, qtdMedalha) values
	('Maria del Rosalho','Atletismo',1),
    ('Sergei Avarosa','Judo',0),
    ('Carina Doria','Judo',1),
    ('Domenico Montela','Atletismo',3),
    ('Julian Casablancas','Judo',5);
insert into Pais (nome,capital) values
	('Polonia','Varsóvia'),
    ('Brasil','Brasilia'),
    ('Turquia','Ancara'),
    ('Chile','Santiago'),
    ('Alaska','Juneau');

# Criar a chave estrangeira na tabela correspondente conforme modelagem;
alter table Atleta add column fkPais int;
alter table Atleta add constraint cfkPais foreign key (fkPais)
	references Pais (idPais);
    
select * from Atleta;
select * from Pais;

# Atualizar o país de todos os atletas;
update Atleta set fkPais = 4 where idAtleta = 1;
update Atleta set fkPais = 5 where idAtleta = 2;
update Atleta set fkPais = 2 where idAtleta = 3;
update Atleta set fkPais = 3 where idAtleta = 4;
update Atleta set fkPais = 1 where idAtleta = 5;

# Exibir os atletas e seu respectivo país;
select * from Atleta;

# Exibir apenas o nome do atleta e o nome do respectivo país;
Select Atleta.nome as "Atleta",
	Pais.nome as "Pais"
    from Atleta JOIN Pais
    on idPais = fkPais;

# Exibir os dados dos atletas, seus respectivos países, de uma determinada capital;
select * from Atleta join Pais
	on idPais = fkPais
    where capital = "Varsóvia";