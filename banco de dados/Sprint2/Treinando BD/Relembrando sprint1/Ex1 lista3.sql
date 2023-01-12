CREATE DATABASE estudos;
USE estudos;

CREATE TABLE atleta(
id int primary key auto_increment,
nome varchar(40) unique,
modalidade varchar (40),
qtdMedalha int,
brasileiro varchar(3), constraint nascionalidade check (brasileiro in ('sim','não'))
);

INSERT INTO atleta(nome, modalidade, qtdMedalha, brasileiro) VALUES
	('Sonia Barroso','Atletismo',1,'sim'),
    ('Marisa Monte','Atletismo',5,'sim'),
    ('Thiago Mathias','Salto com vara',5,'sim'),
    ('Sergei Avarosa','Salto com vara',2,'não'),
    ('Mickael Noves','Arco e flexa',3,'não'),
    ('Enzo Noa','Arco e flexa',0,'não'),
    ('Alexander Fleming','Atletismo',7,'não');

select * from atleta;
update atleta set brasileiro = "não" where id = 7;

update atleta set qtdMedalha = 2 where id = 1;
update atleta set qtdMedalha = 0 where id in (2,3);

UPDATE atleta set nome = "Haruko Matsui" where id = 4;

ALTER TABLE atleta ADD COLUMN dtNasc DATE; 
UPDATE atleta SET dtNasc = "1992-04-05" where id = 1;
UPDATE atleta SET dtNasc = "1997-12-15" where id = 2;
UPDATE atleta SET dtNasc = "1990-03-22" where id = 3;
UPDATE atleta SET dtNasc = "2000-08-09" where id = 4;
UPDATE atleta SET dtNasc = "1992-02-21" where id = 5;
UPDATE atleta SET dtNasc = "1994-04-03" where id = 6;
UPDATE atleta SET dtNasc = "1992-11-13" where id = 7;

DELETE FROM atleta WHERE id = 5;
SELECT * FROM atleta WHERE modalidade <> "Atletismo";

SELECT * FROM atleta WHERE qtdMedalha >= 3;

ALTER TABLE atleta MODIFY COLUMN modalidade varchar(60);
desc atleta;

truncate table atleta;