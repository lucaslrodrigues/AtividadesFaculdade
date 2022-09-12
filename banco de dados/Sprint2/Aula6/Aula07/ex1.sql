-- Exercicio disciplinas professor
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

insert into disciplina(nome) values
	('Logica e Algoritimos'),
    ('Banco de dados'),
    ('Pesquisa e inovação')


insert into professor(nome, sobrenome, especialidade1, especialidade2) values
	('Claudio','Frezzanini','Matemática','Gerencia de projetos'),
    ('Vivian','Cruz','Data science','Análise e desenvolvimento de sistemas'),
    ('Rafael','Fumagali','Data science','Monitoramento de dados'),
    ('Fernando','Brandão','Gerencia e gestão de projetos','Matemática analitica'),
    ('Fernanda','Caramico','Gerencia e gestão de projetos','Cordenação educacional'),