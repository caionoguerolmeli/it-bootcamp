
-- 1. Mostrar o título e o nome do gênero de todas as séries.

select a.title, b.name from series as a inner join genres  as b on a.genre_id=genre_id ;

-- 2. Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em
-- cada um deles.

select c.title, d.first_name, d.last_name from episodes as c join (select a.first_name, a.last_name, b.episode_id from actors as a join actor_episode as b on a.id = b.actor_id) d;


-- 3. Mostrar o título de todas as séries e o número total de temporadas que cada uma
-- delas possui.

SELECT series.title, COUNT(*) AS number_of_seasons FROM series 
	INNER JOIN seasons
    ON seasons.serie_id = series.id
    GROUP BY series.title; 
 


-- 4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde
-- que seja maior ou igual a 3.

select genres.name , COUNT(*) as total from genres inner join movies on genres.id = movies.genre_id group by genres.name; 

-- 5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de
-- Star Wars e que estes não se repitam.


SELECT a.first_name, a.last_name FROM actors AS a where a.id in 
(select actor_movie.id from actor_movie inner join movies on actor_movie.movie_id = movies.id where movies.title like 'La Guerra de las galaxias%');



set profiling=1;
SELECT a.first_name, a.last_name FROM actors AS a
INNER JOIN actor_movie AS ac ON ac.actor_id = a.id
INNER JOIN movies AS m ON m.id = ac.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';
show profiles;