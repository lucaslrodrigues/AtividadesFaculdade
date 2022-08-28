create database faculdade;
use faculdade;

drop table faculdade;

create table empresa (
id int primary key auto_increment,
nome varchar(45),
responsavel varchar(45),
dtinaugura datetime, # import de data
tipo varchar(20), constraint chktipo # criando uma restrição para que a empresa seja filial ou matriz (util para "feminino" ou "masculino")
	check (tipo in ('filial','matriz')) # forma de check mas atual, ela adiciona a restrição na tabela
);

desc empresa;

-- inserir dados na tabela empresa

insert into empresa (nome, responsavel, dtinaugura, tipo)
	values ('SPTech','Petry', '2016-01-01 08:00:00','matriz');
    
select * from empresa;

-- inserir dados na tabela empresa
insert into empresa (nome, responsavel, dtinaugura, tipo)
	values ('FLOTech',"Vivian","2022-08-01 08:00:00","matriz");
insert into empresa (nome, responsavel, dtinaugura, tipo)
	values ('C6Bank','Rosalho','2022-08-01 07:22:37','matriz'),
    ('Safra','Maria do bairro','2022-08-01 16:47:02','matriz'),
    ('Delloit','Jose sem dente','2022-08-02 08:14:51','matriz');

-- Exibir as empresas onde a penultima letra é release savepoint
select nome from empresa where nome like '%r_'; # o "_" é ultilizado para a penultima e segunda letra (ou mais dependendo da quantidade de _ que você colocar, ele conta a posição de acordo com a quantidade de _

-- Exibir as empresas onde a segunda letra é 6
select * from empresa where nome like '_6%';

alter table empresa drop constraint chktipo; # tirando a restrição

alter table empresa add constraint chktipo
	check (tipo in ('matriz', 'filial','loja')); # adicionando restrição
insert into empresa (nome, responsavel, dtinaugura, tipo)
	values ('sapatos e alegria',"Jorge","2022-08-01 08:00:00","loja");
    
insert into empresa
	values (null,'spar vida boa',"Maria pia","2022-08-01 08:00:00","loja");

-- Excluir registro
delete from empresa where id = 8; # excluindo o registro N°8, só sera adicionada uma nova informação a partir do 9°
# a informação N°8 ainda esta registrada na tabela

-- Limpar a tabela

truncate table empresa; # comando DDL, limpa apenas os dados da tabela

insert into empresa
	values (null,'spar vida boa',"Maria pia","2022-08-01 08:00:00","loja");
select * from empresa;

drop table empresa;

desc empresa;

-- RECOMEÇANDO TABELA

use faculdade;

# default é usado para criar um padrão

create table empresa (
id int primary key auto_increment,
nome varchar(45) not null, # não pode ser nulo
responsavel varchar(45) default 'alguém', # padrão caso não haja uma informação
dtinaugura datetime default current_timestamp, # import de data e hora do servidor
tipo varchar(20), constraint chktipo
	check (tipo in ('filial','matriz')) # forma de check mas atual, ela adiciona a restrição na tabela
)auto_increment = 200;

insert into empresa (nome,tipo) values
	('SPTech','Matriz');
    
select * from empresa;

insert into empresa (nome,tipo) values
	('Safra','Matriz'),
    ('C6Bank','Matriz'),
    ('accenture','Matriz'),
    ('Deloitte','Matriz');

select concat(nome, ' ', tipo) from empresa;
select concat(nome, ' ', tipo) as xablau from empresa;

-- EX: A empresa XPTO, tem o responsavel XPTO e é do tipo XPTO...
select concat('A empresa ',nome, ' tem o responsavel ', responsavel, ' e é do tipo ', tipo) as frase from empresa; # "as" é o titulo da tabela

select 7 * 5; # select manipula dados