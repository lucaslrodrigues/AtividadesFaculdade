create database sprint1;
use sprint1;

create table musica(
idmusica int primary key,
titulo varchar(40),
artista varchar(40),
genero varchar(40));

insert into musica values
	(001,'Hard to explain','The strokes','Rock'),
    (002,'Last night','The strokes','Rock'),
    (003,'Meet me in the bathroom','Rock'),
    (004,'Carolina bela','Jorge ben','MPB'),