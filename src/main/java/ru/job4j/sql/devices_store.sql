create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('Apple iPhone X', 54999.00);
insert into devices (name, price) values ('Apple Watch series 7', 31999.00);
insert into devices (name, price) values ('Mikrotik hAP ac2', 4699.00);
insert into devices (name, price) values ('Xiaomi Redmi 9', 8399.00);

insert into people (name) values ('Иванов С.П.');
insert into people (name) values ('Петров В.Ф.');
insert into people (name) values ('Александров Иван');
insert into people (name) values ('Степанов А.');
insert into people (name) values ('Григорьев');
insert into people (name) values ('Васильев Н.Р.');
insert into people (name) values ('Федоров М.О.');

insert into devices_people (device_id, people_id) values (1, 3);
insert into devices_people (device_id, people_id) values (1, 5);
insert into devices_people (device_id, people_id) values (2, 3);
insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (2, 4);
insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (3, 2);
insert into devices_people (device_id, people_id) values (3, 5);
insert into devices_people (device_id, people_id) values (4, 2);
insert into devices_people (device_id, people_id) values (4, 6);
insert into devices_people (device_id, people_id) values (3, 7);

select avg(price) as "Средняя цена товаров" from devices;

select p.name as Имя, avg(d.price) as "Средний чек"
from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name
order by "Средний чек" desc;

select p.name as Имя, avg(d.price) as "Средний чек"
from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000.00
order by "Средний чек" desc;