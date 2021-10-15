create table body (
	id serial primary key,
	body varchar(50)
);

create table engine(
	id serial primary key,
	engine varchar(50)
);

create table transmission(
	id serial primary key,
	transmission varchar(50)
);

create table car(
	id serial primary key,
	car_name varchar(50),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);