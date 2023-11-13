-- Neste arquivo devem conter as instruções DML (insert, update e delete)
-- que serão executados na inicialização do projeto
-- Importante: Aqui estamos usando SQL nativo e não JPQL!
-- este arquivo só é executado se a propriedade
-- spring.jpa.defer-datasource-initialization for igual a true.
insert into tipo_pokemon(nome, forca_maxima) values
('aquatico', 999),
('eletrico', 500),
('dragao', 400);

insert into Pokemon(forca, livre, nome, tipo_codigo) values
(100.0, false, 'Pokemon A', 1),
(222.2, true, 'Pokemon B', 2),
(303.0, false, 'Pokemon C', 2);
