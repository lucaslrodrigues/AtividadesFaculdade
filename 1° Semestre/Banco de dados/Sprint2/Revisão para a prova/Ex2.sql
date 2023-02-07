# Ex2
use pratica;

create table pessoa (
idPessoa int primary key auto_increment,
nome varchar(45),
dtNasc date,
profissao varchar(30)
);

create table gasto (
idGasto int auto_increment,
dtGasto date,
valor decimal (10,2),
descricao varchar(50),
fkPessoa int,
primary key (idGasto, fkPessoa));

insert into pessoa(nome, dtNasc, profissao) values
	('Joana Saladino','1995-02-26','Eletricista'),
	('Celso Saladino','1986-03-01','Operador de Bitorneira'),
	('Domenico Montela','2000-12-04','Markssista de Esquerda'),
    ('Melissa Fersoza','1999-12-04', 'Moradora da casa do pai');
    
insert into gasto(dtGasto, valor, descricao, fkPessoa) values
	('2022-01-03', 22.99,'Salsinha e quentro', 1),
	('2022-04-02', 200.50,'Nova mesa de jantar', 1),
	('2022-02-22', 9.99,'Café pilão', 2),
	('2022-06-16', 85.75,'Balança de vidro temperado Britania', 2),
	('2022-07-12', 30.00,'Caderno novo', 2),
	('2022-08-07', 362.00,'Fone JBL', 3),
	('2022-09-27', 110.00,'Calça nova', 3);
    
select * from gastos;
select * from pessoa;

select p.*, g.* from pessoas as p join gastos as a on g.fkPessoa = p.idPessoa where p.nome = '% Saladino';
 
select p.*, g.* from pessoas as p join gastos as a on g.fkPessoa = p.idPessoa;

select p.*, g.* from pessoas as p left join gastos as a on g.fkPessoa = p.idPessoa;

select p.*, g.* from pessoas as p join gastos as a on g.fkPessoa = p.idPessoa where idPessoa = 3;

update pessoa set descricao = 'Bolsa nova' where idGasto = 4;

delete from gasto where idGasto = 7;