create table patients(
	id serial primary key,
	name varchar(50)
);

create table doctors(
	id serial primary key,
	name varchar(50),
	speciality varchar(50)
);

create table patients_link_doctors(
	id serial primary key,
	patient_id int references patients(id),
	doctor_id int references doctors(id)
);

insert into patients(name) values ('Ivan Ivanov');
insert into patients(name) values ('Petr Petrov');
insert into patients(name) values ('Stepan Stepanov');

insert into doctors(name, speciality) values ('Maria Ivanova', 'Surgeon');
insert into doctors(name, speciality) values ('Fedor Alekseev', 'Ophtalmologist');
insert into doctors(name, speciality) values ('Irina Efremova', 'Therapist');

insert into patients_link_doctors(patient_id, doctor_id) values (1, 1);
insert into patients_link_doctors(patient_id, doctor_id) values (1, 2);
insert into patients_link_doctors(patient_id, doctor_id) values (2, 1);
insert into patients_link_doctors(patient_id, doctor_id) values (2, 2);
insert into patients_link_doctors(patient_id, doctor_id) values (2, 3);
insert into patients_link_doctors(patient_id, doctor_id) values (3, 2);

select * from doctors;

select * from patients;

select * from patients_link_doctors;