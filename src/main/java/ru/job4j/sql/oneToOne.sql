create table phone(
	id serial primary key,
	phone_number varchar(25)
);

create table person(
	id serial primary key,
	person_fullName varchar(100)
);

create table phone_link_person(
	id serial primary key,
	phone_id int references phone(id) unique,
	person_id int references person(id) unique
);

insert into phone(phone_number) values('89999999999');
insert into phone(phone_number) values('89111111111');

insert into person(person_fullName) values('Ivanov Ivan Ivanovich');
insert into person(person_fullName) values('Petrov Petr Petrovich');

insert into phone_link_person(phone_id, person_id) values(1, 1);
insert into phone_link_person(phone_id, person_id) values(2, 2);

select * from phone_link_person;