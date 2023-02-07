create database murdercity;
use murdercity;

create table criminoso(
idCriminoso int primary key auto_increment,
hobby varchar(45))
auto_increment = 10;
alter table criminoso add column fkCrime int;
alter table criminoso add constraint foreign key (fkCrime) references crime (idCrime);

create table crime(
idCrime int primary key auto_increment,
dtHora datetime,
tipo varchar(45));

create table cenario(
idCenario int primary key auto_increment,
nome varchar(45))
auto_increment = 10;

create table vitima(
idVitima int auto_increment,
fkCrime int,
fkCenario int,
genero varchar(45),
foreign key (fkcrime) references crime (idCrime),
foreign key (fkCenario) references cenario (idCenario),
primary key (idVitima, fkCrime, fkCenario))
auto_increment = 100;

create table arma(
idArma int auto_increment,
nome varchar(45),
tipo varchar(45),
fkCrime int,
foreign key (fkCrime) references crime (idCrime),
primary key (idArma, fkCrime));

create table detetive(
idDetetive int auto_increment,
fkCrime int,
amuletoSorte varchar(45),
foreign key (fkCrime) references crime (idCrime),
primary key (idDetetive, fkCrime))
auto_increment = 10;

create table suspeito(
idSuspeito int auto_increment,
fkDetetive int,
fkCrime int,
fkCriminoso int,
caracteristica varchar(45),
foreign key (fkDetetive) references detetive (idDetetive),
foreign key (fkCrime) references crime (idCrime),
foreign key (fkCriminoso) references criminoso (idCriminoso),
primary key (idSuspeito))
auto_increment = 100;

create table pessoa(
idPessoa int primary key auto_increment,
nome varchar(45),
dtNasc date,
Naturalidade varchar(45),
fkDetetive int,
fkVitima int,
fkCriminoso int,
fkSuspeito int,
foreign key (fkDetetive) references detetive (idDetetive),
foreign key (fkVitima) references vitima (idVitima),
foreign key (fkCriminoso) references criminoso (idCriminoso),
foreign key (fkSuspeito) references suspeito (idSuspeito));



-- Insert dos cenarios
insert into cenario (nome) values
	('Hospital'),
	('Ponto de Ônibus'),
	('Praça'),
	('Posto de Gasolina'),
	('Parque'),
	('Cemitério'),
	('Estação de Trem');

-- insert dos crimes
insert into crime (dthora, tipo) values
	('1999-07-20', 'Esfaqueamento'),
    ('2015-03-17', 'Estrangulamento'),
    ('2006-10-24', 'Baleamento'),
    ('2001-09-11', 'Envenenamento'),
    ('2022-01-09', 'Esfaqueamento'),
    ('1980-11-15', 'Desmembramento'),
    ('1997-07-19', 'Estrangulamento'),
    ('2002-02-27', 'Envenenamento'),
    ('2019-12-30', 'Baleamento'),
    ('2017-04-06', 'Espancamento'),
    ('2012-05-10', 'Esfaqueamento'),
    ('2000-06-03', 'Esfaqueamento');

-- insert das vitimas
insert into vitima (fkcrime, fkcenario, genero) values
(1, 10,'Masculino'),
(2, 11,'Feminino'),
(3, 12,'Masculino'),
(4, 13,'Feminino'),
(5, 14,'Masculino'),
(6, 15,'Feminino'),
(7, 16,'Masculino'),
(8, 10,'Feminino'),
(9, 11,'Masculino'),
(10, 12,'Feminino'),
(11, 13,'Masculino'),
(12, 14,'Feminino');

-- insert dos criminosos
insert into criminoso (hobby, fkCrime) values
	('Pescador',1),
	('Meditação',2),
	('Pintura',3),
	('Pescador',4),
	('Academia',5),
	('Yoga',6),
	('Corrida',7),
	('Pintura',8),
	('Meditação',9),
	('Corrida',10),
	('Yoga',11),
	('Academia',12);

-- insert das armas
insert into arma (nome, tipo, fkcrime) values
	('Faca de Serra','Cortante',1),
	('Corda de Alpinista','Corda',2),
	('Pistola Policial','Arma de Fogo',3),
	('Brownie Envenenado','Veneno',4),
	('Faca de Churrasco','Cortante',5),
	('Facão do Açougueiro','Cortante',6),
	('Corda de Pular Infantil','Corda',7),
	('Pão na Chapa Envenenado','Veneno',8),
	('Carabina Especial','Arma de Fogo',9),
	('Soco Inglês Antigo','Soco Inglês',10),
	('Faca de Serra','Cortante',11),
	('Faca de Churrasco','Cortante',12);
    
-- insert dos detetives
insert into detetive (fkcrime, amuletoSorte) values
	(1, 'Pé de Coelho'),
	(2, 'Moeda da Sorte'),
	(3, 'Trevo de Quatro'),
	(4, 'Olho Grego'),
	(5, 'Talismã'),
	(6, 'Pingente da Lua'),
	(7, 'Símbolo do Yin-Yang'),
	(8, 'Ying-Tang'),
	(9, 'Mandala'),
	(10, 'Pingente de Pássaro'),
	(11, 'Pedra do Sol'),
	(12, 'Topázio');
    
-- insert dos suspeito
insert into suspeito (fkDetetive, fkCrime, fkCriminoso, caracteristica) values
	(10, 1, 10, 'Nariz Grande'),
	(11, 2, 11, 'Orelha Pontuda'),
	(12, 3, null, 'Cabeça Grande'),
	(13, 4, 13, 'Olhos Claros'),
	(14, 5, 14, 'Cabeludo'),
	(15, 6, 15, 'Careca'),
	(16, 7, 16, 'Sardas'),
	(17, 8, null, 'Alto'),
	(18, 9, 18, 'Baixinho'),
	(19, 10, 19, 'Nariz Grande'),
	(20, 11, null, 'Olhos Claros'),
	(21, 12, 21, 'Careca'),
    (15, 8, 17 ,'Olhos Claros'),
	(10, 3, 12 ,'Alto'),
	(14, 11, 20 ,'Nariz Grande');


-- insert das pessoas detetives
insert into pessoa (nome, dtNasc, naturalidade, fkDetetive, fkVitima, fkCriminoso, fkSuspeito) values
	('Carlos', '2003-04-24','São Paulo', 10 , null, null, null),
	('José', '2000-01-1','Manaus', 11 , null, null, null),
	('Caique', '1998-02-10','Espirito Santo', 12 , null, null, null),
	('Kevin', '1990-03-30','São Paulo', 13 , null, null, null),
	('Jorge', '1970-05-2','Alagoas', 14 , null, null, null),
	('Leonardo', '1965-06-20','Mato Grosso', 15 , null, null, null),
	('João', '1994-07-29','Acre', 16 , null, null, null),
	('Aroldo', '1993-08-3','Ceará', 17 , null, null, null),
	('Giorges', '1980-09-14','Belo Horizonte', 18 , null, null, null),
	('Reinaldo', '1949-10-16','Manaus', 19 , null, null, null),
	('Gonzalez', '1997-11-17','Espiro Santo', 20 , null, null, null),
	('Ferdinando', '1940-12-19','Rio de Janeiro', 21 , null, null, null),
	('Gustavo', '2003-04-24','São Paulo', null , 100, null, null),
	('Fernanda', '2000-01-1','Belo Horizonte', null , 101, null, null),
	('Abner', '1998-02-10','Rio de Janeiro', null , 102, null, null),
	('Beatriz', '1990-03-30','Acre', null, 103, null, null),
	('Felipe', '1970-05-2','Mato Grosso', null, 104, null, null),
	('Ana', '1965-06-20','Rio Grande do Sul', null, 105, null, null),
	('Luiz', '1994-07-29','Rio Grande do Norte', null, 106, null, null),
	('Carla', '1993-08-3','São Paulo', null, 107, null, null),
	('Nicolas', '1980-09-14','Acre', null, 108, null, null),
	('Rafaela', '1949-10-16','Mato Grosso do Sul', null, 109, null, null),
	('Andreia', '1997-11-17','São Paulo', null, 110, null, null),
	('Junior', '1940-12-19','Alagoas', null, 111, null, null),
    ('Gustavo', '2003-04-24','São Paulo', null , null, 10, 100),
	('Fernanda', '2000-01-1','Belo Horizonte', null , null, 11, 101),
    ('Felipe', '2000-04-24','Rio de Janeiro', null , null, null, 102),
	('Jair', '1998-02-10','Rio de Janeiro', null , null, 13, 103),
	('Messia', '1990-03-30','Acre', null, null, 14, 104),
	('Inacio', '1970-05-2','Mato Grosso', null, null, 15, 105),
	('Ana', '1965-06-20','Rio Grande do Sul', null, null, 16, 106),
	('Gabriel', '1990-01-1','Maranhão', null , null, null, 107),
	('Luiz', '1994-07-29','Rio Grande do Norte', null, null, 18, 108),
	('Carla', '1993-08-3','São Paulo', null, null, 19, 109),
    ('Marcela', '1955-02-10','Recife', null , null, null, 110),
	('Nicolas', '1980-09-14','Acre', null, null, 21, 111),
	('Roberval', '1949-10-16','Mato Grosso do Sul', null, null, 17, 112),
	('Ramonda', '1997-11-17','São Paulo', null, null, 12, 113),
	('Maxwell', '1940-12-19','Alagoas', null, null, 20, 114);
    
    
    