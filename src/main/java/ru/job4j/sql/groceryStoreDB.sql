create table type (
	id serial primary key,
	name varchar(50)
);

create table product (
	id serial primary key,
	name varchar(50),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('БАКАЛЕЯ');

insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 1, '2021-10-15', 299.00);
insert into product(name, type_id, expired_date, price) values ('Сыр Моцарелла', 1, '2021-10-23', 449.00);
insert into product(name, type_id, expired_date, price) values ('Сыр косичка', 1, '2022-01-12', 379.00);
insert into product(name, type_id, expired_date, price) values ('Сыр "Российский"', 1, '2021-10-11', 259.00);
insert into product(name, type_id, expired_date, price) values ('Кефир', 2, '2021-10-16', 64.00);
insert into product(name, type_id, expired_date, price) values ('Сметана', 2, '2021-10-19', 48.00);
insert into product(name, type_id, expired_date, price) values ('Молоко 1%', 2, '2021-10-15', 69.00);
insert into product(name, type_id, expired_date, price) values ('Молоко 3.2%', 2, '2021-10-18', 76.00);
insert into product(name, type_id, expired_date, price) values ('Мороженое "Советское"', 2, '2021-11-26', 48.00);
insert into product(name, type_id, expired_date, price) values ('"Максибон", мороженое', 2, '2021-10-29', 84.00);
insert into product(name, type_id, expired_date, price) values ('Макароны рожки', 3, '2022-07-04', 59.00);
insert into product(name, type_id, expired_date, price) values ('Крупа гречневая', 3, '2022-09-14', 107.00);

select p.name, p.price, p.expired_date from product as p
join type as t on p.type_id = t.id
where t.name like 'СЫР';

select name, price, expired_date from product
where name ilike '%мороженое%';

select name, expired_date from product
where expired_date < current_date;

select name, price from product
where price = (select max(price) from product);

select t.name, count(p.type_id) as qty
from product as p
join type as t on p.type_id = t.id
group by t.name
order by qty asc;

select t.name, p.name, p.price, p.expired_date
from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО'
order by t.name desc, p.price desc;

select t.name, count(p.type_id) as qty
from product as p
join type as t on p.type_id = t.id
group by t.name
having count(p.type_id) < 10;

select t.name, p.name from product as p
join type as t on p.type_id = t.id
order by t.name asc, p.name asc;