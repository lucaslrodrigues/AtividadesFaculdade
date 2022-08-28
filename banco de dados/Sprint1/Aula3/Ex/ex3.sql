use sprint1;

create table filme(
idfilme int primary key auto_increment,
titulo varchar(50),
genero varchar(40),
diretor varchar(40)
);

insert into filme (titulo, genero, diretor) values
	('Jogador N°1','ficção cientifica/ Ação','Steven Spielberg'),
    ('As Aventuras de Tintim','Aventura/Ação','Steven Spielberg'),
    ('Indiana Jones e o Reino da Caveira de Cristal','Ação/Aventura','Steven Spielberg'),
    ('O Labirinto do Fauno','Fantasia/Guerra','Guilhermo del Toro'),
    ('Hellboy','Ação/Fantasia','Guilhermo del Toro'),
    ('Gravidade','Ficção científica/Thriller','Alfonso Cuarón'),
    ('Harry Potter e o Prisioneiro de Azkaban','Fantasia/Aventura','Alfonso Cuarón');

select * from filme;

alter table filme add column protagonista varchar(50);

update filme set protagonista = 'Harry Potter' where idfilme = 7;
update filme set protagonista = 'Ryan Stone' where idfilme = 6;
update filme set protagonista = 'Hellboy' where idfilme = 5;
update filme set protagonista = 'Ophelia' where idfilme = 4;
update filme set protagonista = 'Indiana Jhones' where idfilme = 3;
update filme set protagonista = 'timtim' where idfilme = 2;
update filme set protagonista = 'Wade Watts' where idfilme = 1;