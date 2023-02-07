# Tipos de atributos aula7
create database sprint2;
use sprint2;

create table funcionario(
idFunc int primary key auto_increment,
nome varchar(45), -- + sobrenome = COMPOSTO
sobrenome varchar(50),
telFixo char(11), -- + telCel = MULTIVALORADO
telCel char(12),
CEP char(9), -- + nume + cidade = COMPOSTO (em endereço sempre deve ser dividido em atributos simples) (padrão do correios com cep)
numEnd int,
cidade varchar(45)
);

insert into funcionario(nome, sobrenome, telCel, CEP) values
	('Chefe da Paula','Silva', '11-967723454', '05989-000'),
    ('Chefe do Rafa','Figueiredo','11-953599302','01111-000');

insert into funcionario(nome, telFixo, cidade) values
	('Chefe do Caliu','11-34536758','São Paulo'),
    ('Chefe do Jonatas','11-34597898','São Paulo');
select * from funcionario;

-- Funcionario
insert into funcionario values
	(null,'Chefe da Sala', 'Cabral', '11-33453344', '11-940902345', '09898-000', 145, 'São Paulo');
    
select telFixo from funcionario where telFixo like '%7899';

select concat('O funcionario', nome, ' ', ifnull(sobrenome, 'Não cadastrados')) as Func from funcionario;

select concat('O funcionario ', nome, 'tem o telefone ', ifnull(telFixo, 'Sem um'), ' e o telefone celular', ifnull(telCel, 'Sem um')) as Func from funcionario;