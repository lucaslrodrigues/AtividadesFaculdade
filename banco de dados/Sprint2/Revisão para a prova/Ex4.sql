# Ex4
create database Treinador;
use Treinador;

create table nadador(
idNadador int primary key auto_increment,
nome varchar(45),
estado varchar(17),
dtNasc date,
fkTreinador int, constraint ctTreinador foreign key (fkTreinador) references treinador(idTreinador)
);

