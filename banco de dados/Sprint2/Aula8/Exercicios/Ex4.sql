create database treinador;
use treinador;
create table nadador(
idNadador int primary key auto_increment,
nome varchar(45) not null,
estado varchar(30) not null,
dtNasc date not null
) auto_increment 100;

create table treinador(
idTreinador int primary key auto_increment,
nome varchar(45) not null,
telefone decimal(12) not null,
email varchar(50) not null
) auto_increment 10;

insert into treinador (nome, telefone, email) values
	('Mario Campos',11954631247, 'Mario.campos@sptech.school'),
    ('Lucas Rezende',11987546235,'Lucas.R@sptech.school'),
    ('Filipa Cruzeiro',11965552438,'Filipa.cruzeiro@sptech.school'),
    ('Rafaela Balerini',11933246588,'Rafaela.bale@sptech.school');

insert into nadador (nome, estado, dtNasc) values
	('Mario Ayala', 'São Paulo', '2001-02-15'),
    ('Bruno Mendonça', 'São Paulo', '1995-06-02'),
    ('Silvia Martines', 'Goias', '1997-12-02'),
    ('Sergio Alcantra', 'Goias', '1996-11-30'),
    ('Bruna Bergantin', 'São Paulo', '1992-09-15');

alter table nadador add column fkTreinador int;
alter table nadador add constraint ctTreinador foreign key (fkTreinador) references treinador(idTreinador);

update nadador set fkTreinador = 10 where idNadador = 100;
update nadador set fkTreinador = 11 where idNadador = 101;
update nadador set fkTreinador = 11 where idNadador = 102;
update nadador set fkTreinador = 13 where idNadador = 103;
update nadador set fkTreinador = 12 where idNadador = 104;

alter table treinador add column fkOrientador int;
alter table treinador add constraint ctOreintador foreign key (fkOrientador) references treinador(idTreinador);

update treinador set fkOrientador = 10 where idTreinador = 11; 
update treinador set fkOrientador = 13 where idTreinador = 12;
    
select * from nadador;
select * from treinador;

#  Exibir os dados dos treinadores e os dados de seus respectivos nadadores
select * from treinador join nadador on idTreinador = fkTreinador;

# Exibir os dados de um determinado treinador (informar o nome do treinador na consulta) e os dados de seus respectivos nadadores
select t.*, n.* from treinador as t join nadador as n on t.idTreinador = n.fkTreinador where t.nome = 'Lucas rezende';

# Exibir os dados dos treinadores e os dados dos respectivos treinadores orientadores.
select t.*, o.* from treinador as t join treinador as o on o.idTreinador = t.fkOrientador;

#  Exibir os dados dos treinadores e os dados dos respectivos treinadores orientadores, porém somente de um determinado treinador orientador (informar o nome do treinador na consulta)
select t.*, o.* from treinador as t join treinador as o on o.idTreinador = t.fkOrientador where o.nome = 'Mario Campos';

#  Exibir os dados dos treinadores, os dados dos respectivos nadadores e os dados dos respectivos treinadores orientadores.

-- !! o Script parece certo, mas ele não seleciona onde há campos null na foreign key orientador da tabela treinador


                
select t.*, n.*, o.*
	from treinador as t join nadador as n
		on t.idTreinador = n.fkTreinador
			join treinador as o
				on o.idTreinador = t.fkOrientador;

#  Exibir os dados de um treinador (informar o seu nome na consulta), os dados dos respectivos nadadores e os dados do seu treinador orientador.
 select t.idTreinador as "Id Treinador", t.nome as Treinador, t.telefone as Telefone, t.email as "E-mail",
	n.idNadador as "id Nadador", n.Nome as Nadador, n.estado as Estado, n.dtNasc as "Data nasc.",
		o.idTreinador as "id Orientador", o.Nome as Orientador, o.telefone as Telefone, t.email as "E-mail"
			from treinador as t join nadador as n on t.idTreinador = n.fkTreinador
				join treinador as o on o.idTreinador = t.fkOrientador where t.nome = 'Filipa Cruzeiro';