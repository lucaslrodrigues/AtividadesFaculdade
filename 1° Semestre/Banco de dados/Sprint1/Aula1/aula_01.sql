-- criar banco de dados
CREATE DATABASE faculdade;
-- selecionando banco de dados
use faculdade;
-- ctr enter atalho para executar a linha
-- todos os comandos são em inglês, funciona como uma conversa
-- nunca doprar no sys

-- toda tabela deve ter chave primária
create table aluno(
ra char(8) primary key,-- a necessidade de caracteres é 8 caracteres, sendo o limite e quantidade minima
nome varchar(45),-- um texto que varia de 0 a 45 caracteres ("var" informa que o valor é variavel)
barro varchar(45)
);
-- primary key = regra de negócio (tipagem)

-- toda tabela deve ter uma chave primaria, um valor único que não se repete, em seguida a tipagem "char()" = quantidade de caracteres, estabelecendo uma regra de negocio (o contexto) *independente da quantidade de registros
-- char e varchar demonstra a quantidade de caracteres em formato de texto 
-- todo comando termina com ";"

-- PRIMEIRO SELECT
select * from aluno;
-- * = todos os campos

-- INSERIR DADOS
insert into aluno values
	('01222017', 'Lucas', 'Jaragua - SP'); -- texto em aspas simples ''
    
-- INSERINDO VÁRIOS ALUNOS NUM COMANDO
insert into aluno values
	('01222072','Sara','Consolação'),
	('01222063','Paulo','Guaianazes');
insert into aluno values
	('01222098','Rafael','Paraíso');