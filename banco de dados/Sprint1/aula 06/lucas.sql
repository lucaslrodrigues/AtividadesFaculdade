CREATE DATABASE estudando;
USE estudando;

CREATE TABLE Musica(
id int primary key auto_increment,
titulo varchar(40),
artista varchar(40),
genero varchar(40), constraint gen check (genero in("Rock", "MPB"))

);

INSERT INTO Musica(titulo, artista, genero) values ('Surreal','Scalene','Rock'),
	('Furta cor','Scalene','Rock'),
    ('New york city cops','The strokes','Rock'),
    ('Hourglass','Catfish and the botlemen','Rock'),
    ('Carolina bela','Jorge e toquinho','MPB'),
    ('Onde anda você','Vinicius de moraes','MPB');