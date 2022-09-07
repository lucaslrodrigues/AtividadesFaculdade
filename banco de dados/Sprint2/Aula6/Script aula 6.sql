CREATE DATABASE sprint2;
USE sprint2;

CREATE TABLE aluno(
ra char(8) primary key,
nome varchar (45),
email varchar (45)
# fkEmpresa int, constraint fkEmpresa foreign key (fkEmpresa) references Empresa(idEmpresa) 
);

CREATE TABLE empresa(
idEmpresa int primary key auto_increment,
nome varchar(45),
responsavel varchar(45)
);

insert into aluno values
('01222999','Vivian','vivian@sptech.school'),
('01222998','Rafael','rafa@sptech.school'),
('01222017','Lucas', 'lucas.lrodrigues@sptech.school');

insert into empresa (nome,responsavel) values
	('sptech','Petry'),
	('Accenture','Ana');
    
select * from empresa;
select * from aluno;

alter table aluno add column fkEmpresa int;
alter table aluno add constraint ctFkEmpresa foreign key (fkEmpresa)
	references empresa(idEmpresa);
    
desc aluno;

update aluno set fkEmpresa = 1 where ra in ('01222999','01222998');
update aluno set fkEmpresa = 2 where ra = '01222017';

-- nosso primeiro join (exibição conjunta)
SELECT * FROM aluno join empresan -- todo join tem on
	on idEmpresa = fkEmpresa;
    
-- Melhorar a exibição
select aluno.*,
	empresa.nome
	FROM aluno JOIN empresa
    ON idEmpresa = fkEmpresa;

-- melhorando mais um cadinho
select alunio.nome as 'nome do aluno',
	empresa.nome as 'nome da empresa'
    from aluno join empresa
    ON idEmpresa = fkEmpresa;
    
select a.nome as 'Aluno',
	e.nome as 'Empresa',
    a.email as 'email do Aluno'
    from aluno as a join empresa as e on e.idEmpresa = fkEmpresa;
    
select concat(' O aluno ', alunico.nome, ' está interessado ', empresica.nome, '!') as "Frase de impact"
from aluno as alunico join empresa as empresica
on idEmpresa = fkEmpresa;

select * from aluno join empresa
	on idEmpresa = fkEmpresa
    where aluno.nome like 'v%';