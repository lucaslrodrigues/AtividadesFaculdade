create database relacaonn;
use relacaonn;

create table pessoa(
idPessoa int primary key auto_increment,
nome varchar(45),
salario decimal (10,2)
);

create table endereco(
idEnd int primary key auto_increment,
cep char (9),
bairro varchar(45),
cidade varchar(45)
) auto_increment = 100;

# Tabela associada
create table enderecoCompleto(
fkPessoa int,
foreign key (fkPessoa) references pessoa(idPessoa),
fkEnd int,
foreign key (fkEnd) references endereco(idEnd),
primary key (fkPessoa, fkEnd),
numero int,
complemento varchar(45)
);

desc pessoa;

insert into pessoa values 
	(null, 'Vivian', 1.99),
	(null, 'Rafael', 1.99),
	(null, 'Paulo', 1.98);
    
desc endereco;

insert into endereco values
	(null, '01414-905', 'Cerqueira César', 'São Paulo'),
	(null, '04253-000', 'Sacomã', 'São Paulo'),
	(null, '01414-000', 'Paraiso', 'São Paulo');
    
select * from pessoa;
select * from endereco;

insert into enderecoCompleto values
	(1, 101, 1500, 'apto 101'),
	(2, 100, 595, '10 andar'),
	(3, 100, 595, '10 andar');


insert into pessoa values (null, 'Johnatan', 0.09);
    
select * from pessoa 
	join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	join endereco on idEnd = fkEnd;

-- Endereços sem pessoas
select * from pessoa 
	right join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	right join endereco on idEnd = fkEnd;

-- Pessoas sem endereço    
select * from pessoa 
	left join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	left join endereco on idEnd = fkEnd;

-- selecionando todas as pessoas sem endereço e endereço sem pessoas(full alter join)
select * from pessoa 
	right join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	right join endereco on idEnd = fkEnd
	union
    select * from pessoa 
	left join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	left join endereco on idEnd = fkEnd;

-- apenas onde há null
select * from pessoa 
	right join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	right join endereco on idEnd = fkEnd
    where fkEnd is null
	union
    select * from pessoa 
	left join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	left join endereco on idEnd = fkEnd
    where fkPessoa is null;
    
select endereco.bairro, pessoa.nome from pessoa
	right join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	right join endereco on idEnd = fkEnd
    where fkEnd is null
	union
    select * from pessoa 
	left join enderecoCompleto on idPessoa = fkPessoa -- assosiativa no meio
	left join endereco on idEnd = fkEnd
    where fkPessoa is null;
    
-- Funções aritimeticas
-- count()
select count(*) from pessoa;

insert into pessoa values (null, 'Raull' , null);
select * from pessoa;
select count(salario) from pessoa;

-- Max e Min
select max(salario) 'Maior salario', min(salario) 'Menor salario' from pessoa;

-- SUM e AVG
select sum(salario) 'soma salarios',
	avg(salario) 'Média dos sálarios'
    from pessoa;
    
-- Round - arredondar (o que vêm depos do numero de casas informadas interfere no resultado final)
select round(avg(salario), 2) 'Arredondado',
avg(salario) 'Média dos sálarios'
from pessoa;

-- Truncate (não importa o que vêm depois)
select truncate(avg(salario), 2) 'Truncado',
round(avg(salario), 2) 'Arredondado',
avg(salario) 'Média dos sálarios'
from pessoa;

insert into pessoa values (null, 'Lucas', 0.19);

-- Limit (limita a quantidade de linhas que apareceram)
-- 'TOP' em sqlServer
select * from pessoa limit 1;

-- A partir do 2 eu quero 3 registros
select * from pessoa limit 2, 3;

-- Grup by
-- agrupa para um determinado campo
-- No caso, ele pegara a média de salário de pessoas que moram em determinado bairro
select avg(salario) 'Média dos salários', bairro
	from pessoa
    join enderecoCompleto on idPessoa = fkPessoa
    join endereco on idEnd = fkEnd
    group by bairro;
    
-- Subquery - Select dentro de select
-- salario de pessoas que recebem (acima =, abaixo <, acima >, maior ou igual >=, menor ou igual <=) da media(avg) de salarios
select salario from pessoa 
	where salario >= (select avg(salario) from pessoa);
    