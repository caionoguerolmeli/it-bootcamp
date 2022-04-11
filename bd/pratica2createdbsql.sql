-- Criando pratica integradora db

DROP DATABASE IF EXISTS pratica_db;
CREATE DATABASE pratica_db;
USE pratica_db;


CREATE TABLE `departamentos` (
	`depto_nro` varchar(10) unique not null,
	`nome_depto`varchar(100) not null,
	`localizacao` varchar(100) not null,
    PRIMARY KEY (`depto_nro`));
    
INSERT INTO `departamentos` VALUES
	('D-0001', 'Software', 'Los Tigres'),
    ('D-0002', 'Sistemas', 'Guadalupe'),
    ('D-0003', 'Contabilidade', 'La Roca'),
    ('D-0004', 'Vendas', 'Plata');

CREATE TABLE `funcionarios`(
`cod_fuc` varchar(10) unique not null,
`nome`varchar(100) not null,
`sobrenome` varchar(100) not null,
`cargo` varchar(50) not null,
`data_alta` datetime,
`salario` numeric not null,
`comissao` numeric not null,
`depto_nro` varchar(10) not null,
PRIMARY KEY (`cod_fuc`),
KEY `funcionarios_depto_nro_foreign` (`depto_nro`),
CONSTRAINT `funcionarios_depto_nro_foreign` foreign key (`depto_nro`) REFERENCES `departamentos` (`depto_nro`));

-- LOCK TABLES `funcionarios` WRITE;
INSERT INTO `funcionarios` VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 'D-0004'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-0002'),
    ('E-0003', 'Mariela', 'Barrios', 'Diretor', '2014-06-05', 185000.00, 0.00, 'D-0003'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-0004'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-0004'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-0003'),
    ('E-0007', 'Emilio', 'Galarza', 'Desenvolvedor', '2014-08-02', 60000.00, 0.00, 'D-0001');
    

    