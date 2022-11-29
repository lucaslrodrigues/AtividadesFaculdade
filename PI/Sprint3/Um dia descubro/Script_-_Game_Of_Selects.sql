drop database if exists  gameOfSelects ;
create database gameOfSelects;

use gameOfSelects;

CREATE TABLE alianca(
id INT PRIMARY KEY auto_increment,
nome VARCHAR(45),
sigla VARCHAR(45),
fundacao DATE
);

insert into alianca values
	(null, 'North Order', 'NO', '2496-05-23'),
	(null, 'Southeast Management', 'SM', '2456-02-17'),
	(null, 'South Skypiea', 'SS', '2432-11-18');
 -- -----------------------------------------------------------------------------------------------------------
 
CREATE TABLE pais(
id INT PRIMARY KEY auto_increment,
nome VARCHAR(45),
governo VARCHAR(45),
idioma VARCHAR(45),
classificacao VARCHAR(45),
PIB DECIMAL(10,2),
rendaPercapta DECIMAL(10,2),
fkAlianca INT,
FOREIGN KEY (fkAlianca) REFERENCES alianca (id)
  );
  
insert into pais values
(null, 'fagir', 'republica', 'setentrionais', 'emergente', 0.9, 100,1),
(null, 'iojunhein', 'republica', 'setentrionais', 'desenvolvido', 1.9,100,1),
(null, 'findse', 'republica', 'aegyptologus', 'desenvolvido', 2.3, 200,2),
(null, 'zeish', 'republica', 'aegyptologus', 'desenvolvido', 2.5, 250,2),
(null, 'lorzha', 'monarquia', 'adâmica', 'desenvolvido', 3.2, 3000, null),
(null, 'nueisi', 'republica', 'catarévussa', 'desenvolvido', 0.9, 100, 3),
(null, 'osdeth', 'monarquia', 'catarévussa', 'emergente', 1.3, 170, 3),
(null, 'valhala ', 'republica', ' setentrionais', 'emergente', 0.6, 60, 1);
    
 -- -----------------------------------------------------------------------------------------------------------
 
CREATE TABLE populacao(
id INT,
qtdHabitantes INT,
taxaDesemprego INT,
idadeMediaPopulacional INT,
fkPais INT,
FOREIGN KEY (fkPais) REFERENCES pais (id),
PRIMARY KEY (id, fkPais)
);

    insert into populacao values
    (1, 4000000, 400000, 27, 1),
    (2, 200000000, 200000, 23, 2),
    (3, 1000000, 600000, 40, 8),
    (4, 8000000, 10000, 25, 3),
    (5, 3000000, 30000, 22, 4),
    (6, 3000000, 30000, 22, 5),
    (7, 700000, 100000, 22, 7),
    (8, 800000000, 60000, 20, 6);
    
 -- -----------------------------------------------------------------------------------------------------------
    
CREATE TABLE conflito (
id INT PRIMARY KEY auto_increment,
ano int,
mortos int
);

     insert into conflito values
    (null, 2025, 30000000),
    (null, 2100, 67400000),
    (null, 2134, 23500000),
    (null, 2290, 45000000),
    (null, 2050, 56700000),
    (null, 2025, 74800000),
    (null, 2099, 21000000),
    (null, 2111, 57000000);
 -- -----------------------------------------------------------------------------------------------------------

CREATE TABLE impacto (
fkPais INT,
fkConflito INT,
pesoImpacto VARCHAR(45),
perdaMonetaria DECIMAL(10,2),
FOREIGN KEY (fkPais) REFERENCES pais (id),
FOREIGN KEY (fkConflito) REFERENCES conflito (id),
PRIMARY KEY (fkPais, fkConflito)
);

insert into impacto values
(1, 4, '5', 60000000),
(5, 4, '3', 10000000),

(2, 3, '2', 7000000),
(3, 3, '3', 10000000),

(8, 7, '2', 80000000),
(7, 7, '5', 30000000),

(4, 8, '3', 9000000),
(6, 8, '5', 90000000);


 -- -----------------------------------------------------------------------------------------------------------

CREATE TABLE religiao (
id INT PRIMARY KEY auto_increment,
nome VARCHAR(45),
descricao VARCHAR(45) 
);

	insert into religiao values
    (null, 'budismo', 'é uma doutrina filosófica e espiritual'),
    (null, 'cristianismo', 'baseada na vida de Jesus Cristo '),
    (null, 'islamismo', ' advoga a crença unicamente em Allah.'),
    (null, 'candomblé', 'existência da alma e na vida após a morte');
    
 -- -----------------------------------------------------------------------------------------------------------

CREATE TABLE poderMilitar (
id INT,
ativos INT,
reserva INT ,
poderBelico DECIMAL(10,2),
fkPais INT,
FOREIGN KEY (fkPais) REFERENCES pais (id),
PRIMARY KEY (id, fkPais)
);

   insert into poderMilitar values
    (1, 1000000, 1000000, 7.1, 1),
    (2, 200000000, 200000, 7.9, 2),
    (3, 600000, 200000, 4.0, 8),
    (4, 5000000, 200000, 8.4, 3),
    (5, 2000000, 1000000, 6.2, 4),
    (6, 1000000, 2000000, 5.0, 5),
    (7, 500000, 100000, 5.4, 7),
    (8, 600000000, 100000000, 9.7, 6);

 -- -----------------------------------------------------------------------------------------------------------


CREATE TABLE culturaReligiosa (
fkpais INT,
fkreligiao INT,
FOREIGN KEY (fkpais) REFERENCES pais(id),
FOREIGN KEY (fkreligiao) REFERENCES religiao (id),
PRIMARY KEY (fkpais, fkreligiao)
);

insert into culturaReligiosa values
    (2, 1),
    (5, 2),
    (4, 3),
	(3, 3),
    (7, 4),
    (6, 2),
    (1, 4);
    
 -- -----------------------------------------------------------------------------------------------------------


