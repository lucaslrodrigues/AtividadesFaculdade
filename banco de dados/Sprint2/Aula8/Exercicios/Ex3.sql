create database PraticaFuncionario;
use PraticaFuncionario;

create table setor (
idSetor int primary key auto_increment,
nome varchar(20),
andar decimal(12)
);

create table funcionario (
idFunc int primary key auto_increment,
nome varchar(45),
telefone decimal(12) unique,
salario decimal(10,2),
fkSetor int, constraint ctSetor foreign key (fkSetor) references setor(idSetor)
);
select * from acompanhante;
create table acompanhante (
idAcomp int,
fkAcomp int, constraint ctAcomp foreign key (fkAcomp) references funcionario(idFunc),
primary key (idAcomp, fkAcomp),
nome varchar(40),
relacao varchar(20),
dtNasc date
);

# Inserir dados nas tabelas, de forma que exista mais de um funcionário em cada setor cadastrado.
insert into setor(nome, andar) values
	('Qualidade',1),
	('Produção',3),
	('Pos produção',5);
    
insert into funcionario(nome, telefone, salario, fkSetor) values
	('Mario Aiala Vergueiro',11965234785,1.99, 1),
    ('Geovana Silva Possoni',11932652234,3.99, 2),
    ('Jessica Pereira Lima',11987457745,2.99, 2),
    ('Mariana Rios Grizoni',11933245678,4.99, 3),
    ('Leonardo de Cezar Filho',11956556823,2.99, 3);

insert into acompanhante (nome, relacao, dtNasc, fkAcomp, idAcomp) values
    ('Marcos Coelho de Oliveira','Amigo','1982-01-14', 1, 1),
    ('Zander Ramalho Schedrick','Esposa','1990-07-23', 2, 2),
    ('Zidelma Silva de Oliveira','Mãe','1960-04-25', 3, 3),
    ('Domenico de Alcantra Junior','Esposo','1987-12-01', 4, 4),
    ('Juliana Maria Queiroz','Esposa','1992-07-18', 5, 5);

# Exibir todos os dados de cada tabela criada, separadamente
select * from setor;
select * from funcionario;
select * from acompanhante;

# Fazer os acertos da chave estrangeira, caso não tenha feito no momento da criação.
# Exibir os dados dos setores e dos seus respectivos funcionários
select s.*, f.* from setor as s join funcionario as f on f.fkFunc = s.idSetor;

# Exibir os dados de um determinado setor (informar o nome do setor na consulta) e dos seus respectivos funcionários.
select s.nome as 'Setor', f.* from setor as s join funcionario as f on f.fkSetor = s.idSetor;

# Exibir os dados dos funcionários e de seus acompanhantes.
select f.*, a.* from funcionario as f join acompanhante as a on f.idFunc = a.fkAcomp;

# Exibir os dados de apenas um funcionário (informar o nome do funcionário) e os dados de seus acompanhantes
select f.nome as 'Nome', a.* from funcionario as f join acompanhante as a on f.idFunc = a.fkAcomp;

#  Exibir os dados dos funcionários, dos setores em que trabalham e dos seus acompanhantes.
select f.*, s.*, a.* from funcionario as f join setor as s on fkSetor = idSetor join acompanhante as a on idFunc = fkAcomp;