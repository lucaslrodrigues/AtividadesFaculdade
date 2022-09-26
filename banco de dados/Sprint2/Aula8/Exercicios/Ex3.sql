create database PraticaFuncionario;
use PraticaFuncionario;

create table setor (
idSetor int primary key auto_increment,
nome varchar(20) not null,
andar decimal(12) not null
);

create table funcionario (
idFunc int primary key auto_increment,
nome varchar(45) not null,
telefone decimal(12) unique not null,
salario decimal(10,2) not null,
fkSetor int, constraint ctSetor foreign key (fkSetor) references setor(idSetor)
);

create table acompanhante (
idAcomp int,
fkFuncionario int not null, constraint ctAcomp foreign key (fkFuncionario) references funcionario(idFunc),
primary key (idAcomp, fkFuncionario),
nome varchar(40) not null,
relacao varchar(20) not null,
dtNasc date not null
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

insert into acompanhante (nome, relacao, dtNasc, fkfuncionario, idAcomp) values
    ('Marcos Coelho de Oliveira','Amigo','1982-01-14', 1, 1),
    ('Zander Ramalho Schedrick','Esposa','1990-07-23', 1, 2),
    ('Zidelma Silva de Oliveira','Mãe','1960-04-25', 3, 3),
    ('Domenico de Alcantra Junior','Esposo','1987-12-01', 4, 4),
    ('Juliana Maria Queiroz','Esposa','1992-07-18', 5, 5);

# Exibir todos os dados de cada tabela criada, separadamente
select * from setor;
select * from funcionario;
select * from acompanhante;

# Fazer os acertos da chave estrangeira, caso não tenha feito no momento da criação.
# Exibir os dados dos setores e dos seus respectivos funcionários
select s.*, f.* from setor as s join funcionario as f on f.fkSetor = s.idSetor;

# Exibir os dados de um determinado setor (informar o nome do setor na consulta) e dos seus respectivos funcionários.
select s.*, f.* from setor as s join funcionario as f on f.fkSetor = s.idSetor where s.nome = 'Producao';

# Exibir os dados dos funcionários e de seus acompanhantes.
select f.*, a.* from funcionario as f join acompanhante as a on f.idFunc = a.fkFuncionario;

# Exibir os dados de apenas um funcionário (informar o nome do funcionário) e os dados de seus acompanhantes
select f.*, a.* from funcionario as f join acompanhante as a on f.idFunc = a.fkFuncionario where f.nome = 'Mario Aiala Vergueiro';

#  Exibir os dados dos funcionários, dos setores em que trabalham e dos seus acompanhantes.
select f.*, s.*, a.* from funcionario as f join setor as s on f.fkSetor = s.idSetor join acompanhante as a on f.idFunc = a.fkFuncionario;