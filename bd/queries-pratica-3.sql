-- 1. Listar os dados dos autores.
select * from autor;

-- 2. Listar nome e idade dos alunos
select nome, idade from aluno;

-- 3. Quais alunos pertencem à carreira de informática?

select * from aluno where carreira like 'informatica';

-- 4. Quais autores são de nacionalidade francesa ou italiana?

select * from autor where nacionalidade like 'francesa' or nacionalidade like 'italiana';

-- 5. Que livros não são da área da internet?

select * from livro where area not like 'internet';

-- 6. Listar os livros da editora Salamandra.

select * from livro where editora like 'salamandra';

-- 7. Listar os dados dos alunos cuja idade é maior que a média.

-- nao sei fazer

-- 8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.

select * from aluno where sobrenome like 'g%';



-- 9. Listar os autores do livro "O Universo: Guia de Viagem". (Apenas nomes
-- devem ser listados.)

select a.nome from autor as a inner join livro_autor as b on a.id = b.id_autor where b.id_livro 
in (select id from livro where titulo like 'O Universo: Guia de Viagem');

-- 10. Listar autores que tenham nacionalidade italiana ou argentina.

select * from autor where nacionalidade like 'francesa' or nacionalidade like 'argentina' ;
-- 11. Que livros foram emprestados ao leitor “Filippo Galli”?

select a.titulo from livro as a inner join emprestimo as b on a.id = b.id_livro where  b.id_aluno 
in (select id from aluno where nome like 'Filippo' and sobrenome like 'Galli');

-- 12. Listar o nome do aluno mais novo.

select nome from aluno order by idade asc limit 1;

-- 13. Listar os nomes dos alunos a quem os livros de Banco de Dados foram
-- emprestados.

select a.nome from aluno as a inner join emprestimo as b on a.id = b.id_aluno inner join livro as c on b.id_livro=c.id where c.area = 'Banco de Dado';
-- 14. Listar os livros que pertencem ao autor J.K. Rowling.

select a.* from livro as a inner join livro_autor as b on a.id = b.id_livro inner join autor as c on b.id_autor = c.id where c.nome like 'J.K. Rowling';


-- 15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.

select a.* from livro as a inner join emprestimo as b on a.id = b.id_livro where data_devolucao ='20210716';