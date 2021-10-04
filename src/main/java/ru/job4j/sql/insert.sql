insert into roles(role_name) values ('superuser');
insert into roles(role_name) values ('user');

insert into users(full_name, role_id) values ('Фёдор Степанович Иванов', 1);
insert into users(full_name, role_id) values ('Иван Иванов', 2);
insert into users(full_name, role_id) values ('Александров Петр Иванович', 2);

insert into rules(rules) values ('stub for rule of superusers');
insert into rules(rules) values ('stub for rule of users');

insert into rules_of_roles(rule_id, role_id) values (1, 1);
insert into rules_of_roles(rule_id, role_id) values (2, 2);

insert into item_category(category_of_item) values ('pull request');
insert into item_category(category_of_item) values ('patch');

insert into item_state(state_of_item) values ('in process');
insert into item_state(state_of_item) values ('done');

insert into item(item_description, user_id, category_id, state_id) values ('new patch', 1, 2, 2);
insert into item(item_description, user_id, category_id, state_id) values ('new item 1', 2, 1, 1);
insert into item(item_description, user_id, category_id, state_id) values ('new item 2', 3, 1, 1);

insert into item_comments(commentary, item_id) values ('i found a new bug in program', 2);
insert into item_comments(commentary, item_id) values ('a new patch released', 1);
insert into item_comments(commentary, item_id) values ('can you pls fix a problem?', 3);

insert into item_attachments(attach_description, item_id) values ('bug.jpg', 2);
insert into item_attachments(attach_description, item_id) values ('patch_description.txt', 1);