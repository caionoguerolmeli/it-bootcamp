-- 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores
-- trabalham.

select a.nome, a.cargo, b.localizacao from funcionarios as a inner join departamentos as b where a.depto_nro = b.depto_nro;

-- 2. Visualize departamentos com mais de cinco funcionários.

select a.nome_depto from departamentos as a inner join funcionarios as b  
where   a.depto_nro = b.depto_nro group by a.nome_depto having count(a.nome_depto) >5;

-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo
-- cargo que 'Mito Barchuk'.


explain select a.nome, a.salario, b.nome_depto from funcionarios as a inner join departamentos as b 
on a.depto_nro =b.depto_nro  where a.cargo in (select cargo from funcionarios where nome = 'Mito' and sobrenome = 'Barchuk');

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade,
-- ordenados por nome.

select a.* from funcionarios as a left join departamentos as b on a.depto_nro = b.depto_nro where nome_depto like 'Contabilidade';

-- 5. Mostre o nome do funcionário que tem o menor salário.

select nome from funcionarios order by salario asc limit 1;

-- 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.

select a.* from funcionarios as a inner join departamentos as b on a.depto_nro = b.depto_nro where  nome_depto like 'Vendas' order by salario desc limit 1;