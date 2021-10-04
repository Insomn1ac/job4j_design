create table roles(
	id serial primary key,
	role_name varchar(50)
);

create table users(
	id serial primary key,
	full_name varchar(100),
	role_id int references roles(id)
);

create table rules(
	id serial primary key,
	rules varchar(50)
);

create table rules_of_roles(
	id serial primary key,
	rule_id int references rules(id),
	role_id int references roles(id)
);

create table item_category(
	id serial primary key,
	category_of_item varchar(100)
);

create table item_state(
	id serial primary key,
	state_of_item varchar(100)
);

create table item(
	id serial primary key,
	item_description varchar(255),
	user_id int references users(id),
	category_id int references item_category(id),
	state_id int references item_state(id)
);

create table item_comments(
	id serial primary key,
	commentary text,
	item_id int references item(id)
);

create table item_attachments(
	id serial primary key,
	attach_description varchar(255),
	item_id int references item(id)
);