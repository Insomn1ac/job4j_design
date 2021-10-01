create table rallyCars(
    id serial primary key,
    model varchar(50)
);

create table pilots(
    id serial primary key,
    pilot_name varchar(100),
    car_id int references rallyCars(id)
);

insert into rallyCars (model) values ('Ford Focus');
insert into rallyCars (model) values ('Lancia Delta');

insert into pilots (pilot_name, car_id) values ('Fedor Stepanov', 1);
insert into pilots (pilot_name, car_id) values ('Ivan Petrov', 2);
insert into pilots (pilot_name, car_id) values ('Andrey Ivanov', 1);

select * from pilots;

select * from rallyCars where id in (select id from pilots);