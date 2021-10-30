select p.name as "Имя сотрудника", c.name as "Название компании"
from person as p
join company as c on p.company_id = c.id
where c.id <> 5;

select "Название компании", "Количество сотрудников"
from (select c.name as "Название компании", count(p.id) as "Количество сотрудников"
	from company as c
	join person as p on c.id = p.company_id
	group by c.name) as subtable
order by "Количество сотрудников" desc
limit 1;

select c.name as "Название компании", count(p.id) as "Количество сотрудников"
from company as c
join person as p on c.id = p.company_id
group by c.name
having count(p.id) >= all(select count(p.id) from person as p
						  join company as c on p.company_id = c.id
						  group by c.name);