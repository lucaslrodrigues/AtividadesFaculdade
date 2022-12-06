create database systoyanka;
use systoyanka;

create table shopping (
    id int primary key auto_increment,
    nome varchar(45),
    cnpj char(14) unique,
    telefone char (10)
);


Create table endereco (
    id int primary key auto_increment,
    cidade varchar(45),
    bairro varchar (45),
    cep varchar (9),
    fkShopping int,
        foreign key (fkShopping) references shopping(id) 
);


create table sensor (
    id int primary key auto_increment,
    andar char(2),
    bloco varchar (4),
    fkShopping int,
        foreign key(fkShopping) references shopping(id)
);

create table leitura (
    id int auto_increment,
    dt_hora DATETIME default current_timestamp, 
    statusRetorno int,
    fkSensor int, 
        foreign key(fkSensor) references sensor(id),
    primary key (id, fkSensor)
);



create table usuario (
    id int auto_increment,
    nome varchar(45),
    login varchar(45),
    senha varchar(45),
    tipo varchar(45), 
        constraint chkTipo check (tipo in ('admin','user')),
    fkShopping int, 
        foreign key (fkShopping) references shopping (id),
    primary key (id, fkShopping)
);

insert into shopping (nome, cnpj, telefone) values
    ('Shopping Praça da moça', '52678945301254', '1185461247'),
    ('Shopping Aricanduva', '24355214544132', '1140674545'),
    ('Shopping JK Iguatemi', '64589092093425', '1140664066');

insert into endereco (cidade, bairro, cep, fkShopping) values
    ('Diadema', 'Praça Da Moça','09910-720', 1),
    ('São Paulo', 'aricanduva','03527-900', 2),
    ('São Paulo', 'Vila Olímpia','04543-011', 3);

insert into sensor (andar, bloco, fkShopping) values
    (01,'A',1),
    (01,'A',1),
    (01,'A',1),
    (01,'B',1),
    (01,'B',1),
    (01,'B',1),
    (01,'C',1),
    (01,'C',1),
    (01,'C',1),
    (01,'D',1),
    (01,'D',1),
    (01,'D',1),
    (02,'A',1),
    (02,'A',1),
    (02,'A',1),
    (02,'B',1),
    (02,'B',1),
    (02,'B',1),
    (02,'C',1),
    (02,'C',1),
    (02,'C',1),
    (02,'D',1),
    (02,'D',1),
    (02,'D',1),
    (03,'A',1),
    (03,'A',1),
    (03,'A',1),
    (03,'B',1),
    (03,'B',1),
    (03,'B',1),
    (03,'C',1),
    (03,'C',1),
    (03,'C',1),
    (03,'D',1),
    (03,'D',1),
    (03,'D',1);

insert into leitura (dt_hora, statusRetorno, fkSensor) values
    ('2022-10-23 19:50:00', 1, 1),
    ('2022-10-22 18:43:00', 1, 2),
    ('2022-10-20 14:15:00', 0, 3),
    ('2022-10-05 17:10:00', 1, 4),
    ('2022-10-30 16:15:00', 1, 5);

insert into leitura (dt_hora, statusRetorno, fkSensor) values
	    (default, 1, 6),
	    (default, 0, 7),
	    (default, 0, 8),
	    (default, 0, 9),
	    (default, 0, 10),
	    (default, 0, 11),
	    (default, 1, 12),
	    (default, 1, 13),
	    (default, 1, 14),
	    (default, 1, 15),
	    (default, 0, 16),
	    (default, 0, 17),
	    (default, 0, 18),
	    (default, 1, 19),
	    (default, 0, 20),
	    (default, 0, 21),
	    (default, 0, 22),
	    (default, 0, 23),
	    (default, 0, 24),
	    (default, 1, 25),
	    (default, 0, 26),
	    (default, 0, 27),
	    (default, 1, 28),
	    (default, 0, 29),
	    (default, 1, 30),
	    (default, 1, 31),
	    (default, 0, 32),
	    (default, 1, 33),
	    (default, 1, 34),
	    (default, 1, 35);


select * from endereco;
select * from shopping;
select * from sensor;
select * from leitura;
select * from usuario;

select s.andar 'andares',
       sum(l.statusRetorno) 'status',
       count(l.statusRetorno) 'contagem',
	   DATE_FORMAT(dt_hora,'%H:%i:%s') as momento_grafico
       from sensor as s
            join leitura as l 
                on s.id = l.fkSensor
            group by s.andar;
            
select s.andar 'andares',
       sum(l.statusRetorno) 'status',
       count(l.statusRetorno) 'contagem'
       from sensor as s
            join leitura as l 
                on s.id = l.fkSensor
				where s.andar = 2 
					order by l.id desc limit 12;
                    
select s.andar 'andares',
	   s.bloco,
       sum(l.statusRetorno) 'status',
       count(l.statusRetorno) 'contagem',
	   DATE_FORMAT(dt_hora,'%H:%i:%s') as momento_grafico
       from sensor as s
            join leitura as l 
                on s.id = l.fkSensor
					where s.andar = 1
						group by s.bloco;
            
drop database systoyanka;