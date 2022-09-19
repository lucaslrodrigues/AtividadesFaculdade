create database faculdade;
use faculdade;

create table funcionario(
idFunc int primary key auto_increment,
nome varchar(45),
salario decimal(10,2), -- 10 numeros, 2 números após a virgula
fkSuper int,
constraint fkSupervisor foreign key (fkSuper) references funcionario(idFunc)
);

create table dependente(
idDep int,
fkFunc int, constraint fkFuncionario foreign key (fkFunc) references funcionario(idFunc),
primary key (idDep, fkFunc), -- chave primaria composta
nome varchar(45),
Parentesco varchar(45)
);

# inserir dados dos funcionarios
-- Inserindo supervisor, com fk null
insert into funcionario(nome, salario, fkSuper) values
	('Gerson', '5.99', null);
    
select * from funcionario;

-- inserindo funcionario com supervisor
insert into funcionario values
	(null, 'Vivian', 1.99, 1),
    (null, 'Rafael', 1.95, 1);
    
-- Inserir dependentes
insert into dependente values
	(1, 2, 'Paula', 'prima'),
	(2, 2, 'Paulo', 'primo'),
	(1, 3, 'Rafaela', 'irmã');
    
select * from dependente;

insert into dependente values
	(2, 3, 'Rafão', 'pai');
    
-- Relacionando as tabelas
select * from funcionario join dependente on idFunc = fkFunc;

select f.nome as NomeFunc, s.nome as NomeSuper from funcionario as f join funcionario as s on s.idFunc = f.fkSuper;

select nome from funcionario where fkSuper is not null; -- selecionando funcionarios onde fkSuper não é vazia

select f.nome as NomeFunc, s.nome as NomeSuper, d.nome as Nomedep from funcionario as f join funcionario as s on s.idFunc = f.fkSuper join dependente as d on f.idFunc = d.fkfunc;

-- Nome do funcionario nome do dependente e o nome do parentesco
select f.nome as NomeFunc, d.nome as NomeDep, d.parentesco as Parente from funcionario as f join dependente as d on f.idfunc = d.fkFunc;

select concat('O funcionário ', f.nome, ' tem como supervisor ', s.nome, ' e como dependente ', d.nome) as FraseDeImpacto from funcionario as f join funcionario as s on f.fkSuper = s.idFunc
	join dependente as d on f.idFunc = d.fkFunc;

-- para pensar
select f.nome as NomeFunc,
		s.nome as NomeSuper
		from funcionario as f
		left join funcionario as s
			on f.fkSuper = s.idFunc
				where f.fkSuper is null;