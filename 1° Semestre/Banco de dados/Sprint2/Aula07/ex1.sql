-- Exercicio disciplinas professor
create database sprint2;
use sprint2;

create table professor(
idProfessor int primary key auto_increment,
nome varchar(50),
sobrenome varchar(30),
especialidade1 varchar(40),
especialidade2 varchar(40)
);

create table disciplina(
idDisc int primary key auto_increment,
nomeDisc varchar(45)
);

insert into disciplina(nomeDisc) values
	('Logica e Algoritimos'),
    ('Banco de dados'),
    ('Pesquisa e inovação');


insert into professor(nome, sobrenome, especialidade1, especialidade2) values
	('Claudio','Frezzanini','Matemática','Gerencia de projetos'),
    ('Vivian','Cruz','Data science','Análise e desenvolvimento de sistemas'),
    ('Rafael','Fumagali','Data science','Monitoramento de dados'),
    ('Fernando','Brandão','Gerencia e gestão de projetos','Matemática analitica'),
    ('Fernanda','Caramico','Gerencia e gestão de projetos','Cordenação educacional'),
    ('Rafael','Petry','Gerencia administrativa cooperativa', 'Gestão empresarial');
    
# Configurar a chave estrangeira na tabela conforme sua modelagem (Pode fazer no comando CREATE TABLE);
ALTER TABLE disciplina ADD COLUMN fkDisc int;
ALTER TABLE disciplina ADD constraint ctDisc foreign key (fkDisc) references professor(idProfessor);

select * from professor;
select * from disciplina;

update disciplina set fkDisc = 1 where idDisc = 1;
update disciplina set fkDisc = 2 where idDisc = 2;
update disciplina set fkDisc = 2 where idDisc = 3;

# Exibir os professores e suas respectivas disciplinas;
select p.* , d.nomeDisc from professor as p join disciplina as d on p.idProfessor = fkDisc;

# Exibir apenas o nome da disciplina e o nome do respectivo professor;
select p.nome, d.nomeDisc from professor as p join disciplina as d on p.idProfessor = fkDisc;

# Exibir os dados dos professores, suas respectivas disciplinas de um determinado sobrenome;
select p.*, d.nomeDisc from professor as p join disciplina as d on p.idProfessor = fkDisc where p.sobrenome = 'caramico';

# Exibir apenas a especialidade1 e o nome da disciplina, de um determinado professor, ordenado de forma crescente pela especialidade1;
select p.especialidade1, d.nomeDisc from professor as p join disciplina as d on p.idProfessor = fkDisc where idProfessor = 1 order by especialidade1;