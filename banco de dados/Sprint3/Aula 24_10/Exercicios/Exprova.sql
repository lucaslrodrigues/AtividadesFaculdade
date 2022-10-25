# Script da prova
create database venda;
use venda;

create table cliente(
idCliente int primary key auto_increment,
nome varchar(45),
email varchar(45),
cep char(9),
cidade varchar(45),
estado varchar(45),
fkIndicacao int,
foreign key (fkIndicacao) references cliente(idCliente)
) auto_increment = 100;

create table vendas (
idVenda int auto_increment,
totalVenda decimal(10,2),
dtVenda date,
desconto decimal (10,2),
fkCliente int, foreign key (fkCliente) references cliente(idCliente),
primary key (idVenda, fkCliente)
);

create table produto(
idProduto int primary key auto_increment,
nome varchar(45),
descricao varchar(45),
preco decimal(10,2));

create table produtosVenda (
fkVenda int, foreign key (fkVenda) references vendas(idVenda),
fkProduto int, foreign key (fkProduto) references produto(idProduto),
quantidade int
);

insert into cliente values
	(null, 'Lucas', 'lucas@sptech.school', 04180999, 'São Paulo', 'São Paulo', null),
	(null, 'Leonardo', 'leonardo@sptech.school', 04481000, 'São Paulo', 'São Paulo', 100),
	(null, 'Domenica', 'domenica@sptech.school', 05871001, 'Ubiratã', 'Paraná', 100),
    (null, 'Marise', 'marise@sptech.school', 04180999, 'São Paulo', 'São Paulo', 101);

insert into produto values
	(null, 'Desinfetante', 'Desinfetante para pisos brancos', 1.99),
	(null, 'Caderno', 'Caderno com 1000 páginas e meia', 2.99),
	(null, 'Borracha', 'Só apaga a cor branca', 1.00),
	(null, 'Lapis', 'Lapis sem grafite', 0.35),
	(null, 'Mesa', 'Escrivaninha hexagonal', 0.35);
    
insert into vendas values
	(null, 5.99, '2022-04-21', 0, 100),
	(null, 6.99, '2022-05-12', 0.99, 100),
	(null, 1.99, '2022-11-30', 0, 102),
	(null, 3.99, '2022-10-08', 0, 102),
	(null, 10.99, '2022-10-27', 2.99, 102);

insert into produtosVenda values
	(1, 2, 1),
	(1, 3, 1),
	(1, 4, 2),
	(2, 1, 1),
	(2, 5, 1),
	(3, 2, 1),
	(3, 1, 1),
	(4, 2, 2),
	(4, 3, 1),
	(4, 4, 3),
	(5, 5, 1);

# Exibir todos os dados de cada tabela criada, separadamente.

select * from cliente;
select * from vendas;
select * from produto;
select * from produtosVenda;

# Exibir os dados dos clientes e os dados de suas respectivas vendas
select * from cliente
	join vendas on idCliente = fkCliente;

# Exibir os dados de um determinado cliente (informar o nome do cliente na consulta) e os dados de suas respectivas vendas.
select * from cliente
	join vendas on idCliente = fkCliente
    where nome = 'Lucas';

# Exibir os dados dos clientes e de suas respectivas indicações de clientes.
select cliente.*, indicador.* from cliente as cliente
	join cliente as indicador
    on cliente.fkindicacao = indicador.idCliente;

#  Exibir os dados dos clientes indicados e os dados dos respectivos clientes
# indicadores, porém somente de um determinado cliente indicador (informar o nome
# do cliente que indicou na consulta).
select cliente.*, indicador.* from cliente as cliente
	join cliente as indicador
    on cliente.fkindicacao = indicador.idCliente
	where indicador.nome = 'Lucas';
    
# Exibir os dados dos clientes, os dados dos respectivos clientes que indicaram, os dados das respectivas vendas e dos produtos.
select c.*, i.*, v.*, p.*, pv.*
	from cliente as c
		join cliente as i
			on c.fkindicacao = i.idCliente
				join vendas as v on c.idCliente = v.fkCliente
					join produtosVenda as pv on v.idVenda = pv.fkVenda
						join produto as p on pv.fkProduto = p.idProduto;
                    
                    
# Exibir apenas a data da venda, o nome do produto e a quantidade do produto numa determinada venda.
select v.dtVenda 'Data', p.nome 'Nome', pv.quantidade 'Quantidade'
	from vendas as v join produtosVenda as pv
		on v.idVenda = pv.fkVenda
			join produto as p
				on p.idProduto = pv.fkProduto
					where idVenda = 1;

# Exibir apenas o nome do produto, o valor do produto e a soma da quantidade de produtos vendidos agrupados pelo nome do produto.
select p.nome, p.preco, sum(quantidade)
	from produto as p join produtosVenda as pv
		on pv.fkProduto = idProduto
			group by p.nome;

# Inserir dados de um novo cliente. Exibir os dados dos clientes, das respectivas vendas, e os clientes que não realizaram nenhuma venda.
insert into cliente values
	(null, 'Paulo', 'paula@sptech.school', 05777000, 'São José dos Campos', 'São Paulo', 101);
    
select cliente.*, vendas.*
	from cliente left join vendas
		on idCliente = fkCliente;

# Exibir o valor mínimo e o valor máximo dos preços dos produtos
select max(preco) 'Valor máximo' , min(preco) 'Valor mínimo' from produto;

# Exibir a soma e a média dos preços dos produtos
select sum(preco) 'Soma dos preços', avg(preco) 'Média de preços' from produto;

# Exibir a quantidade de preços acima da média entre todos os produtos;
select count(preco) 'Quantidade acima da média' from produto where preco > (select avg(preco) from produto);

# Exibir a soma dos preços distintos dos produtos;
select sum(preco) 'Soma' from produto;

# Exibir a soma dos preços dos produtos agrupado por uma determinada venda
select sum(preco) 'Soma de preços'
	from produto join produtosVenda
		on idProduto = fkProduto
			join vendas
				on idVenda = fkVenda
					group by idVenda = 1;