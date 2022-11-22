create database sales;
drop database sales;
use sales;

create table client (
idClient int primary key auto_increment,
name varchar(45),
email varchar(60),
cep decimal(8),
number int,
recommendation int, foreign key (recommendation) references client(idClient)
);

create table sale(
idSale int auto_increment,
total decimal(10,2),
date date,
discount decimal(10,2),
fkClient int, foreign key (fkClient) references client(idClient),
primary key (idSale, fkClient)
);

create table product (
idProduct int primary key auto_increment,
name varchar(45),
description varchar(60),
price decimal (10,2));

create table cart (
fkSale int, foreign key (fkSale) references sale(idSale),
fkClient int, foreign key (fkClient) references client(idClient),
fkProduct int, foreign key (fkProduct) references product(idProduct),
mount int,
primary key (fkSale, fkClient, fkProduct)
);

select * from client;
select * from cart;
select * from sale;
select * from product;

insert into client values
	('Jorge','jorge@email', 08502145, 1254, null),
	('Mario','Mario@email', 54502145, 5484, null),
	('Melissa','Mel@email', 05451145, 856, null),
	('Amanda Sales','AmandaTeles@email', 78989451, 589, null),
	('Tremo','Creosinho@email', 89642145, 8787, null),
	('Camparino de Jesois','Amém@email', 16600547, 13, null),
	('Kathleyn','algumacoisacomK@email', 63247851, 63, null),
	('Roslyn','BonIver@email', 6452100, 2424, null);