create database Sprint;
use Sprint;

create table empresa(
	id int primary key auto_increment,
    nome varchar(50),
    cnpj char(14),
    telefone char(10)
);

create table usuario(
	id int primary key auto_increment,
	email varchar(50),
	senha varchar(50)
);

insert into usuario values
	(null, 'mm@email.com', '1234');

CREATE USER 'tester'@'localhost' IDENTIFIED BY '1234';
GRANT SHOW DATABASES, INSERT, SELECT ON *.* TO 'tester'@'localhost';
FLUSH PRIVILEGES;

drop user 'tester'@'localhost';
drop database Sprint;