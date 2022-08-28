use sprint1;

create table musica(
idmusica int primary key auto_increment,
titulo varchar(40),
artista varchar(40),
genero varchar(40)
);
desc musica;

insert into musica (titulo, artista, genero) values
	('When the sun hits','Slowdive','Shoegaze'),
    ('Sleep','Slowdive','Shoegaze'),
    ('Outside','Catfish and the bottleman','Rock'),
    ('Twice','Catfish and the bottleman','Rock'),
    ('Staring','Tipling rock','Rock'),
    ('Names or faces','Tipling rock','Rock'),
    ('Forever dumb','Surf curse','Rock');

# Exibir todos os dados da tabela
select * from musica;

# Adicionar o campo curtidas do tipo int na tabela
alter table musica add column curtidas int;

# Atualizar o campo curtidas de todas as músicas inseridas
update musica set curtidas = 1201223 where idmusica = 1;
update musica set curtidas = 19 where idmusica = 2;
update musica set curtidas = 124343 where idmusica = 3;
update musica set curtidas = 5327647 where idmusica = 4;
update musica set curtidas = 87004 where idmusica = 5;
update musica set curtidas = 21333 where idmusica = 6;
update musica set curtidas = 12334 where idmusica = 7;

# Modificar o campo artista do tamanho 40 para o tamanho 80
alter table musica modify artista varchar(80);

# Atualizar a quantidade de curtidas da música com id=1
update musica set curtidas = 3043254 where idmusica = 1;

# Atualizar a quantidade de curtidas das músicas com id=2 e com o id=3
update musica set curtidas = 19000 where idmusica in (2,3);

# Atualizar o nome da música com o id=5
update musica set titulo = 'a side/b side' where idmusica = 5;

# Excluir a música com o id=4
delete from musica where idmusica = 4;

# Exibir as músicas onde o gênero é diferente de funk
select * from musica where genero <> 'funk';
select * from musica where genero <> 'rock';

# Exibir os dados das músicas que tem curtidas maior ou igual a 20
select * from musica where curtidas >= 20;

# Descrever os campos da tabela mostrando a atualização do campo artista
select concat('A música ',titulo,' do artista/banda ',artista,' do gênero ',genero,' têm ',curtidas,' curtidas') as frase from musica;

# Limpar os dados da tabela
truncate table musica;