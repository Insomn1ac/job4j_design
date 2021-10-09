create table feeding_type(
    id serial primary key,
    type_of_feeding varchar(50)
);

create table animals(
    id serial primary key,
    species varchar(255),
	type_of_animal varchar(50),
    type_of_feeding_id int references feeding_type(id)
);

insert into feeding_type (type_of_feeding) values ('Carnivore');
insert into feeding_type (type_of_feeding) values ('Herbivore');
insert into feeding_type (type_of_feeding) values ('Omnivore');

insert into animals (species, type_of_animal, type_of_feeding_id) values ('Giraffe', 'Mammal', 2);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Grizzly', 'Mammal', 3);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Polar bear', 'Mammal', 1);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Pig', 'Mammal', 3);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Human', 'Mammal', 3);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Coala', 'Marsupial', 2);
insert into animals (species, type_of_animal, type_of_feeding_id) values ('Eagle', 'Bird', 1);

select an.species, f.type_of_feeding
from animals as an
join feeding_type as f
on an.type_of_feeding_id = f.id
order by f.type_of_feeding asc;

select a.species as "Вид животного", f.type_of_feeding as "Тип кормления"
from animals as a
join feeding_type as f
on a.type_of_feeding_id = f.id;

select an.species, an.type_of_animal, feed.type_of_feeding
from animals as an
join feeding_type as feed
on an.type_of_feeding_id = feed.id
order by an.type_of_animal asc;