
-- Mostrar todos os registros da tabela de filmes.
select * from movies;

--  Mostrar o nome, sobrenome e classificação de todos os atores.-- 

select first_name, last_name, rating from actors;

--  Mostrar o título de todas as séries e use alias para que tanto o nome da tabela
-- quanto o campo estejam em Português.

select title as titulo from series;

-- ➔ Mostrar o nome e sobrenome dos atores cuja classificação é superior a 7,5.

select first_name, last_name  from actors where rating >7.5;
-- ➔ Mostrar o título dos filmes, a classificação e os prêmios dos filmes com classificação
-- superior a 7,5 e com mais de dois prêmios.

select title, rating, awards from movies where rating >7.5;
-- ➔ Mostrar o título dos filmes e a classificação ordenados por classificação em ordem
-- crescente.

select title, rating from movies order by rating asc;

-- ➔ Mostrar os títulos dos três primeiros filmes no banco de dados.

select title from movies limit 3;

-- ➔ Mostrar os 5 melhores filmes com a classificação mais alta.

select title from movies order by rating desc limit 5;

-- ➔ Listar os 10 primeiros atores.

select * from actors limit 10;

-- ➔ Mostrar o título e a classificação de todos os filmes cujo título é Toy Story.

select title, rating from movies where title like "Toy Story";

-- ➔ Mostrar todos os atores cujos nomes começam com Sam.

select * from actors where first_name like "Sam";

-- ➔ Mostrar o título dos filmes que saíram entre 2004 e 2008.

select title from movies where release_date between 20040101 and 20081231;

-- ➔ Mostrar o título dos filmes com classificação superior a 3, com mais de 1 prêmio e
-- com data de lançamento entre 1988 e 2009. Ordenar os resultados por
-- classificação.

select title from movies where rating >3 and awards > 1 and release_date between 19880101 and 20091231 order by rating asc;