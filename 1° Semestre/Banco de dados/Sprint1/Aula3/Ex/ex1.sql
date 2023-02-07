create database sprint1;
use sprint1;

create table atleta (
idatleta int primary key auto_increment,
nome varchar(45),
modalidade varchar(45),
qtdmedalha int
);

insert into atleta (nome, modalidade, qtdmedalha) values
	('Lucas Vilasboas','Atletismo', 2),
    ('Tereza venerdie','Atletismo', 3),
    ('Marta Juvenense','Natação', 1),
    ('Nathan martins','Natação', 0),
    ('Maria melissa','Natação', 3),
    ('Marcel Keed', 'Corrida', 0),
    ('Tom oddel','Corrida', 4);

# Exibir todos os dados da tabela.
select * from atleta;

# Atualizar a quantidade de medalhas do atleta com id=1;
update atleta set qtdmedalha = 5
where idatleta = 1;

# Atualizar a quantidade de medalhas do atleta com id=2 e com o id=3

update atleta set qtdmedalha = 1
where idatleta in (2,3);

# Atualizar o nome do atleta com o id=4
update atleta set nome = 'João Jorge'
where idatleta = 4;

# Adicionar o campo dtNasc na tabela, com a data de nascimento dos atletas, tipo date
alter table atleta add column dtnasc datetime;

update atleta set dtnasc = '1995-01-07' where idatleta = 1;
update atleta set dtnasc = '1997-11-08' where idatleta = 2;
update atleta set dtnasc = '2003-09-05' where idatleta = 3;
update atleta set dtnasc = '1991-01-22' where idatleta = 4;
update atleta set dtnasc = '1999-12-25' where idatleta = 5;
update atleta set dtnasc = '2000-07-16' where idatleta = 6;
update atleta set dtnasc = '1992-08-02' where idatleta = 7;

# Excluir o atleta com o id=5
delete from atleta where idatleta = 5;

# Exibir os atletas onde a modalidade é diferente de natação
select * from atleta where modalidade <> 'Natação';

# Exibir os dados dos atletas que tem a quantidade de medalhas maior ou igual a 3
select * from atleta where qtdmedalha >= 3;

# Modificar o campo modalidade do tamanho 40 para o tamanho 60
alter table atleta modify modalidade varchar(60);

# Descrever os campos da tabela mostrando a atualização do campo modalidade
select concat('O atleta ' ,idatleta,' ',nome,' da modalidade de ', modalidade ,' tem ',qtdmedalha, ' medalhas') as frase from atleta;

# Limpar os dados da tabela
truncate table atleta;