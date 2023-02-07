use sprint2;
create table curso(
idCurso int primary key auto_increment,
nome varchar(50),
sigla char(3),
coordenador varchar(45)
);

insert into curso(nome, sigla, coordenador) values
	('Analise e desenvolvimento de sistemas','ADS','Fernando Brandão'),
	('Sistemas da informação','SIS','Alex Barreira'),
	('Ciência da computação','CCO','Marise Miranda');

create table semestres(
idSemestre int primary key auto_increment,
numSemestre int, constraint chkSemestre check (numSemestre in (4,8)));

insert into semestres(numSemestre) values
	(4),
    (8);

ALTER TABLE curso ADD COLUMN fkSem int;
ALTER TABLE curso ADD CONSTRAINT chSem FOREIGN KEY (fkSem) REFERENCES semestres(idSemestre);

update curso set fkSem = 1 where idCurso = 1;
update curso set fkSem = 2 where idCurso = 2;
update curso set fkSem = 2 where idCurso = 3;

select * from curso;
select * from semestres;

# Faça um JOIN entre as duas tabelas;
select curso.*, semestres.numSemestre as 'Semestres' from curso join semestres on fkSem = idSemestre;

# Faça um JOIN com WHERE entre as duas tabelas
SELECT 
    curso.nome AS 'Nome do curso', curso.sigla, curso.coordenador, semestres.numSemestre AS 'Semestre'
	FROM curso JOIN semestres
    ON fkSem = idSemestre
	WHERE coordenador LIKE '%a';

# Crie um campo com a restrição (constraint) de CHECK
ALTER TABLE curso ADD COLUMN estagioSem int;
ALTER TABLE curso ADD CONSTRAINT chkEst check (estagioSem in (2,4));