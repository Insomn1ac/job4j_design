create table departments (
	id serial primary key,
	name varchar(50)
);

create table employees (
	id serial primary key,
	name varchar(50),
	dep_id int references departments(id)
);

insert into departments (name) values ('DEP 1'), ('DEP 2'), ('DEP 3'), ('DEP 4');
insert into employees (name, dep_id) values ('Ivan', 1), ('Vladimir', 1), ('Sergey', 1), ('Petr', 3), ('Stepan', 3), ('Fedor', 4);
insert into employees (name) values ('Nikolay');

select d.name as dep_name, e.name as empl_name from departments as d
left join employees as e
on d.id = e.dep_id
order by d.name, e.name;

select d.name, e.name from departments as d
right join employees as e
on d.id = e.dep_id
order by d.name, e.name;

select d.name, e.name from departments as d
full join employees as e
on d.id = e.dep_id
order by d.name, e.name;

select d.name, e.name from departments as d
cross join employees as e
order by d.name, e.name;

select d.name as department from departments as d
left join employees as e
on d.id = e.dep_id
where e.name is null;

select d.name as dep_name, e.name as empl_name from departments as d
left join employees as e
on d.id = e.dep_id
order by d.name, e.name;

select d.name as dep_name, e.name as empl_name from employees as e
right join departments as d
on e.dep_id = d.id
order by d.name, e.name;

create table teens (
	id serial primary key,
	name varchar(50),
	gender varchar(1)
);

insert into teens (name, gender) values ('Catharina', 'F');
insert into teens (name, gender) values ('Josey', 'F');
insert into teens (name, gender) values ('Herta', 'F');
insert into teens (name, gender) values ('Clerkclaude', 'M');
insert into teens (name, gender) values ('Cherrita', 'F');
insert into teens (name, gender) values ('Pris', 'F');
insert into teens (name, gender) values ('Willdon', 'M');
insert into teens (name, gender) values ('Yard', 'M');
insert into teens (name, gender) values ('Drucill', 'F');
insert into teens (name, gender) values ('Toby', 'M');

select m.name, m.gender, f.name, f.gender from teens as f
cross join teens as m
where m.gender = 'M' and f.gender = 'F'
order by m.name, f.name;