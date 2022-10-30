create database sprint3;
use sprint3;

create table grupo (
idGrupo int primary key auto_increment,
nome varchar(40),
descricao varchar(60));

create table aluno (
RA decimal(8) primary key,
nome varchar(45),
email varchar(45),
fkGrupo int, foreign key (fkGrupo) references grupo(idGrupo)
);
create table professor (
idProfessor int primary key auto_increment,
nome varchar(45),
disciplina varchar(45));

create table avaliacao (
fkProfessor int, foreign key (fkProfessor) references professor(idProfessor),
fkGrupo int, foreign key (fkGrupo) references grupo(idGrupo),
dtAvaliacao datetime,
nota decimal(3,1),
primary key (fkGrupo, fkProfessor)
);

insert into grupo values
	(null, 'Fish Solutions', 'Monitoramento de temperatura em aquarios de Tilápia'),
    (null, 'Systoyanka', 'Monitoramento de vagas de estacionamento'),
    (null, 'CofeeTech', 'Monitoramento de umidade em plantações de café');

insert into aluno values
	(01222001, 'Alan bathon', 'Alan.Bathon@sptech,school', 1),
	(01222201, 'Melissa Tozzi', 'Melissa@sptech,school', 1),
	(01222024, 'Eduarda Brito', 'Eduarda.Brito@sptech,school', 1),
	(01222124, 'Bruno Mendonça', 'Bruno.Mrodrigues@sptech,school', 1),
	(01222037, 'Domenico Montela', 'Domenico@sptech,school', 1),
	(01222370, 'Tarciso Paiva', 'Sonia.Abrão@sptech,school', 2),
	(01222401, 'Maria Eduarda', 'Maria.Eduarda@sptech,school', 2),
	(01222019, 'Monica Silva', 'Monica.Silva@sptech,school', 2),
	(01222084, 'Simone Dantas', 'Simone.Dantas@sptech,school', 2),
	(01222094, 'Thomas Benedito', 'Thomas.Benedito@sptech,school', 2),
	(01222070, 'Paulo Almeida', 'Paulo.Almeida@sptech,school', 3),
	(01222356, 'Paula Maria', 'Paula.Maria@sptech,school', 3),
	(01222794, 'Sara de Souza', 'Sara.souza@sptech,school', 3),
	(01222113, 'Leonardo borges', 'Leonardo.Borges@sptech,school', 3),
	(01222314, 'Bruna Kaori', 'Bruna.Kaori@sptech,school', 3);

insert into professor values
	(null, 'Fernando Brandão', 'Pesquisa e inovação'),
    (null, 'Fernanda Caramico', 'Pesquisa e inovação'),
    (null, 'Leonardo' , 'Socioemocional'),
    (null, 'Patricia', 'Socioemocional');
    
insert into avaliacao values
	(1, 1, '2022-10-10 11:33:05', 5.7),
	(3, 1, '2022-10-10 11:31:38', 6),
	(2, 2, '2022-10-10 09:47:52', 9),
	(4, 2, '2022-10-10 09:49:25', 8.5),
	(1, 3, '2022-10-17 13:43:31', 7.4),
	(2, 3, '2022-10-10 13:40:29', 8);
    
select * from grupo;
select * from aluno;
select * from professor;
select * from avaliacao;

# 5 Exibir os dados dos grupos e seus respectivos alunos
select grupo.*, aluno.* from grupo join aluno on idGrupo = fkGrupo;

# 6 Exibir os dados de um determinado grupo e seus respectivos alunos
select grupo.*, aluno.* from grupo join aluno on idGrupo = fkGrupo where idGrupo = 1;

# 7 Exibir a média das notas atribuídas aos grupos no geral
select avg(nota) 'Média' from avaliacao;

# 8 Exibir a nota mínima e a nota máxima que foi atribuída aos grupos, no geral
select max(nota)'Máxima', min(nota)'Mínima' from avaliacao;

# 9 Exibir a soma das notas dadas aos grupos, no geral
select sum(nota) from avaliacao;

# 10 Exibir os dados dos professores que avaliaram cada grupo, os dados dos grupos, a data e horário das avaliações
select p.*, g.*, a.dtAvaliacao 'Data e hora'
	from professor as p
		join avaliacao as a
			on p.idProfessor = a.fkProfessor
				join grupo as g
					on g.idGrupo = a.fkGrupo;

# 11 Exibir os dados dos professores que avaliaram determinado grupo, os dados do grupo, data e horário da avaliação
select p.*, g.*, a.dtAvaliacao 'Data e hora'
	from professor as p
		join avaliacao as a
			on p.idProfessor = a.fkProfessor
				join grupo as g
					on g.idGrupo = a.fkGrupo where g.idGrupo = 2;
                    
# 12 Exibir os nomes dos grupos que foram avaliados por determinado professor.
select g.nome 'Nome grupo'
	from grupo as g
		join avaliacao as a
			on g.idGrupo = a.fkGrupo
				join professor as p
					on p.idProfessor = a.fkProfessor
						where p.nome like 'Fernando%';
                    
# 13 Exibir os dados dos grupos, os dados dos alunos correspondentes, os dados dos professores que avaliaram, a data e horário da avaliação.
-- Não tenho certeza se está certo ou não, mas é o que faz sentido de acordo com o enunciado
select g.*, al.*, p.*, av.dtAvaliacao 'Data e Hora'
	from grupo as g
		join aluno as al
			on g.idGrupo = al.fkGrupo
				join avaliacao as av
					on g.idGrupo = av.fkgrupo
						join professor as p
							on p.idProfessor = av.fkProfessor;

select g.*, al.*, p.*, av.dtAvaliacao 'Data e Hora'
	from professor as p
		join avaliacao as av
			on p.idProfessor = av.fkProfessor
				join grupo as g
					on g.idGrupo = av.fkGrupo
						join aluno as al
							on al.fkGrupo = g.idGrupo;

# 14 Exibir a quantidade de notas distintas
select count(nota) 'Qtd notas' from avaliacao;

# 15 Exibir a identificação do professor (pode ser fk ou nome), a média das notas e a soma das notas atribuídas, agrupadas por professor
select p.nome, avg(nota) 'Média', sum(nota) 'Somatório'
	from professor as p
		join avaliacao as av
			on p.idProfessor = av.fkProfessor
				group by p.nome;

# 16 Exibir a identificação do grupo (pode ser fk ou nome), a média das notas e a soma das notas atribuídas, agrupadas por grupo
select g.nome, avg(nota) 'Média', sum(nota) 'Somatório'
	from grupo as g
		join avaliacao as av
			on g.idGrupo = av.fkGrupo
				group by g.nome;

# 17 Exibir a identificação do professor (pode ser fk ou nome), a menor nota e a maior nota atribuída, agrupada por professor.
select p.nome, min(nota) 'Menor nota', max(nota) 'Maior nota'
	from professor as p
		join avaliacao as av
			on p.idProfessor = av.fkProfessor
				group by p.nome;
                
			
# 18 Exibir a identificação do grupo (pode ser fk ou nome), a menor nota e a maior nota atribuída, agrupada por grupo.
select g.nome, min(nota) 'Menor nota', max(nota) 'Maior nota'
	from grupo as g
		join avaliacao as av
			on g.idGrupo = av.fkGrupo
				group by g.nome;