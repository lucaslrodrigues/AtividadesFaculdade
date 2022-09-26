use faculdade;
create table pessoa(
idPessoa int primary key auto_increment,
nome varchar(45) not null,
dtNasc date not null,
profissao varchar(40) not null
);

create table gasto(
idGasto int auto_increment,
dtGasto date,
fkPessoa int, constraint ctpessoa foreign key (fkPessoa) references pessoa(idPessoa),
primary key (idGasto, dtGasto),
valor decimal (10,2) not null,
descricao varchar(45) not null
);

insert into pessoa (nome, dtNasc, profissao) values
	('Jorge Barroso Lucas','2001-02-25','Desenvolvedor back-end'),
	('Marcos Fragoso Filho','2000-04-30','Desenvolvedor back-end'),
	('Regina Silva Maria','1995-11-17','Analista de sistemas'),
	('Gizele Nami Silva','1999-05-10','Analista de sistemas'),
	('Sinval Lima da Silva','1992-06-11','Desenvolvedor de softwere'),
	('Matheus Sepa e Paiva','1991-11-22','Desenvolvedor de softwere');
insert into gasto (dtGasto, valor, descricao, fkPessoa) values
	('2022-05-21',25.00,'Mesalidade do Porgrama de desenvolvimento', 1),
	('2022-03-25',300.00,'Mensalidade do cloud do site', 2),
	('2022-09-02',101.99,'Mesa nova', 3),
	('2022-01-29',249.99,'Cadeira nova', 4),
	('2022-07-03',650.00,'Mensalidade aws da api', 5),
	('2022-03-16',10.00,'Açucar para o café', 6);


# Exiba os dados de cada tabela individualmente.
select * from pessoa;
select * from gasto;

# Exiba somente os dados de cada tabela, mas filtrando por algum dado da tabela (por exemplo, as pessoas de alguma profissão, etc).
select p.*, g.* from pessoa as p join gasto as g on p.idPessoa = g.fkPessoa where p.profissao = 'Desenvolvedor back-end';

# Exiba os dados das pessoas e dos seus gastos correspondentes.
select p.*, g.* from pessoa as p join gasto as g on p.idPessoa = g.fkPessoa;

# Exiba os dados de uma determinada pessoa e dos seus gastos correspondentes.
select p.*, g.* from pessoa as p join gasto as g on p.idPessoa = g.fkPessoa where p.idPessoa = 1;

# Atualize valores já inseridos na tabela.
update gasto set valor = 30.99 where idGasto = 1;
update gasto set valor = 200.00 where idGasto = 2;
update gasto set valor = 150.00 where idGasto = 3;
update gasto set valor = 700.00 where idGasto = 4;
update gasto set valor = 658.57 where idGasto = 5;
update gasto set valor = 4.35 where idGasto = 6;

# Exclua um ou mais registros de alguma tabela.
delete from gasto where idGasto = 2;
delete from gasto where idGasto = 5;