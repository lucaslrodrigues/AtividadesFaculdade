use sprint2;
CREATE TABLE Musica(
idMusica int primary key auto_increment,
titulo varchar(40),
artista varchar(40),
genero varchar(40)
);

CREATE TABLE Album(
idAlbum int primary key auto_increment,
nome varchar(40),
tipo varchar(8), constraint ckTipo check(tipo in ('digital','físico')),
dtLancamento date
);

insert into Musica(titulo, artista, genero) values
	('Barely legal','The Strokes','Rock'),
    ('Modern age','The Strokes','Rock'),
    ('Hourglass','Catfish and the bottleman','Rock'),
    ('Soundcheck','Catfish and the bottleman','Rock'),
    ('Twice','Catfish and the bottleman','Rock'),
    ('Forever dumb','Surf curse','Rock'),
    ('Beach whatever','Surf curse','Rock');

insert into Album(nome, tipo, dtLancamento) values
	('Is this it','físico','2001-10-03'),
    ('The balcony','digital','2014-08-15'),
    ('Sad Boys EP','digital','2013-10-30');

# Exibir todos os dados das tabelas separadamente;
select * from Musica;
select * from Album;

# Criar a chave estrangeira na tabela de acordo com a regra de negócio;
alter table Musica add column fkAlbum int;
alter table Musica add constraint cfkAlbum foreign key (fkAlbum)references Album(idAlbum);

# Atualizar os álbuns de cada música;
update Musica set fkAlbum = 1 where idMusica in (1,2);
update Musica set fkAlbum = 2 where idMusica between 3 and 5;
update Musica set fkAlbum = 3 where idMusica in (6,7);

# Exibir as músicas e seus respectivos álbuns;
select * from musica;

# Exibir somente o título da música e o nome do seu respectivo álbum;
select musica.titulo as 'titulo', album.nome as 'album'
	from Musica as musica join Album as album
    on idAlbum = fkAlbum;

# Exibir os dados das músicas e seu respectivo álbum, de um determinado tipo.
select musica.*, album.nome
	from Musica join Album
    on fkAlbum = idAlbum
    where tipo = 'digital';
    
drop table Musica;
drop table Album;