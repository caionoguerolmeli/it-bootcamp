-- 1. Adicione um filme à tabela de filmes.

insert into movies values (22,NULL,NULL,'Avatar 2',7.9,3,'2022-10-04 00:00:00',120,5);

-- 2. Adicione um gênero à tabela de gêneros.

insert into genres values (13,'2013-07-04 03:00:00',NULL,'Noir',13,1);


-- 3. Associe o filme do ponto 1. com o gênero criado no ponto 2.

update movies set genre_id = 13 where id = 22;

-- 4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado
-- no ponto 1 como favorito.

update actors set favorite_movie_id = 22 where id = 1;

-- 5. Crie uma tabela temporária da tabela filmes.

create temporary table movies_temp select * from movies;

-- 6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
SET SQL_SAFE_UPDATES = 0;
delete from movies_temp where awards < 5;
select * from movies_temp;
select * from movies;

-- 7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.

select distinct a.* from genres  as a inner join movies as b on a.id = b.genre_id;

-- 8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.

select a.* from actors as a inner join movies as b on a.favorite_movie_id = b.id where b.awards > 3;

-- 9. Crie um índice no nome na tabela de filmes.

alter table movies add index  movies_title (title);

-- 10. Verifique se o índice foi criado corretamente.

show index from movies;
-- 11. No banco de dados movies, haveria uma melhoria notável na criação de índices?
-- Analise e justifique a resposta.
-- 12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta