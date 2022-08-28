-- CRIAR BANCO DE DADOS
CREATE DATABASE faculdade;
-- SELECIONAR O BANCO DE DADOS
USE faculdade;

-- TODA TABELA TEM QUE TER CHAVE PRIMÁRIA
CREATE TABLE aluno (
ra char(8) primary key,
nome varchar(45),
bairro varchar(45)
);

-- NOSSO PRIMEIRO SELECT
SELECT * FROM aluno;

-- INSERIR DADOS NA TABELA ALUNO
INSERT INTO aluno VALUES 
	('01222999','Vivian Silva', 'Paraíso');
    
-- INSERINDO VÁRIOS ALUNOS NUM COMANDO
INSERT INTO aluno VALUES 
	('01212072', 'Sara', 'Consolação'),
	('01222063', 'Paulo', 'Guaianazes'),
	('01222998', 'Rafael', 'Bom Retiro');
    insert into aluno values
		('01222001','Jonatas','freguesia do ó');
insert into aluno values
	('01222992','Matheus','Barra funda'),
    ('01222291','Matheus','Pirituba');
select * from aluno order by nome; -- ordenar pelo nome

select * from aluno order by nome desc; -- selecionando em ordem decrescente

select * from aluno order by nome, bairro; -- ordenar por nome, mas se o nome for igual, ordenar por bairro

select * from aluno where nome = 'matheus'; -- exibir apenas aluno com o nome matheus

# Exibir apenas alunos que começam com 'M'
SELECT * FROM aluno WHERE nome LIKE 'M%'; -- apenas os que começam com o M, aqueles que sejam parecidos com M, aquilo que vem depois não importa (%)

# Exibir apenas os alunos que contem a letra 'T'
select * from aluno where nome like '%T%'; -- Não importa se começa ou termina com 'T', o importante é ele estar em nome

select * from aluno where nome like '%t%' or nome like '%v%';  # duas condições

# exibir apenas os alunos que TERMINA com a letra N
select * from aluno where nome like '%n %';

# selecionar apenas o bairro do aluno que o segundo nome começa com S
select nome, bairro from aluno where nome like '% s%';

# todos os alunos que começam com S
select *from aluno where nome like '%o';

insert into aluno values
('01222017','Limao','Jaragua');

-- Excluir a professora vivian
select * from aluno;
delete from aluno where ra = '01222999'; # só é possivel excuir atravez da chave primaria
# não é possivel ecluir no work banch sem o were, mas no sistema de empresas eles existe
# ou seja, nunca fazer delete sem where, ele excuira a tabela toda

# atualizando um dado
# atualizar o nome matheus para matheus Jaguaré
update aluno set nome = 'matheus de Jaguaré'
where ra = '01222291'; # mundando o nome do matheus onde o RA é igual a "01222291
select * from aluno;

# delete é um comando DML

# Criando o campo email. Quando criamos uma nova coluna na tabela nós alteramos a estrutura dela
# ... isso é um comendo DDL, pois a esta redefinindo

alter table aluno add column email varchar(100);

desc aluno;
DESCRIBE aluno;

select * from aluno;

update aluno set email = 'lukasdojaragua9@gmail.com'
where ra = '01222017';

update aluno set email = 'sara123@sptech'
where ra = '01222072';

update aluno set ra = '01222071'
where ra = '01212072';

update aluno set email = 'jonatas@sptech'
where ra = '01222001';

update aluno set email = 'Saladamista123@sptech'
where ra = '01222063';

update aluno set email = 'matheusdejaguaré@sptech'
where ra = '01222291';

# modificar a tipagem da tabela (varchar)
alter table aluno modify nome varchar(100);
describe aluno;

-- alter table é um comando DDL, podemos alterar ou modificar um coluna
# Excluir uma coluna da tabeela
alter table aluno drop bairro; -- excluir permanentemente
-- para excluir uma chave primaria é necessário que ela deixe de ser primaria

-- update atualiza o dado, atertable define a estrutura da tabela
# Exibir RA maiores que 01222072]
-- maiores
select ra, nome from aluno where ra > '01222072';
-- menores
select ra, nome from aluno where ra < '01222072';

# Exibir os RA diferentes do RA 0122072

select * from aluno where ra <> '01222072';-- != funciona também

-- Exibir os RA entre 009 e 202
select * from aluno where ra between '01222009' and '01222202';

# mostrar RA especificos pré selecionados

select * from aluno where ra in ('01222072','01222063');
