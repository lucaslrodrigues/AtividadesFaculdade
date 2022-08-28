create database sprint1;
use sprint1;

create table atleta(
idatleta int primary key,
nome varchar(40),
modalidade varchar(40),
qtdmedalhas int);
-- int transforma em inteiro

insert into atleta values
	(001,'Matheus Terças','Natação',0),
    (002,'Maria Pia','Judo',2),
    (003,'Cosmo Daminhão','Salto com vara',1),
    (004,'Julian Casablancas','Corrida',3),
    (005,'Luiz viton','Salto com vara',0);

# Exibir todos os dados da tabela.
select * from atleta;

# Exibir apenas os nomes e quantidade de medalhas dos atletas.
select nome, modalidade from atleta;

# Exibir apenas os dados dos atletas de uma determinada modalidade.
select * from atleta where modalidade = 'Salto com vara';

# Exibir os dados da tabela ordenados pela modalidade.
select * from atleta order by modalidade;

# Exibir os dados da tabela, ordenados pela quantidade de medalhas, em ordem decrescente.
select * from atleta order by qtdmedalhas desc;

# Exibir os dados da tabela, dos atletas cujo nome contenha a letra s
select * from atleta where nome like '%s%';

# Exibir os dados da tabela, dos atletas cujo nome comece com uma determinada letra.
select * from atleta where nome like 'M%';

# Exibir os dados da tabela, dos atletas cujo nome termine com a letra o.
select * from atleta where nome like '%o';

# Exibir os dados da tabela, dos atletas cujo nome tenha a penúltima letra r.
-- Professora disse que não precisava fazer essa por que vamos ver na próxima aula

# Eliminar a tabela.
drop table atleta;
