create table students (
	id serial primary key,
	name varchar(50),
	surname text,
	course int,
	date_of_birth date
);
insert into students(name, surname, course, date_of_birth) values ('Иван', 'Иванов', 3, '2001-07-10');
select * from students;
update students set course = 4;
delete from students;