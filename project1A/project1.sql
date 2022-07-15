drop table if exists Reimbursement_status;
create table Reimbursement_status(
id serial primary key,
status  varchar(10) default 'pending'
);

insert into Reimbursement_status (reimb_status) values ('pending');
insert into Reimbursement_status (reimb_status) values ('denied');
insert into Reimbursement_status (reimb_status) values ('approved');

drop table if exists Reimbursement_type;
create table Reimbursement_type(
id serial primary key,
type  varchar(10)
);

insert into Reimbursement_type (reimb_type) values ('Lodging');
insert into Reimbursement_type (reimb_type) values ('Travel');
insert into Reimbursement_type (reimb_type) values ('Food');
insert into Reimbursement_type (reimb_type) values ('Other');


drop table if exists Users_roles;
create table Users_roles(
id serial primary key,
users_role varchar (10)
);


insert into Users_roles (users_role) values ('employee');
insert into Users_roles (users_role) values ('manager');





drop table if exists users;
create table users(
id serial primary key,
username varchar(30) unique not null,
password varchar(30) not null,
user_first_name varchar(30)not null,
user_last_name varchar(30)not null,
user_email varchar(30),
user_role_id integer references Users_roles(id)
);


insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id ) values ('atomanek0', 'rvMIoQey8od', 'Amabelle', 'Tomanek', 'atomanek0@twitter.com', '2');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('plievesley1', 'y4td9I', 'Parker', 'Lievesley', 'plievesley1@addtoany.com', '2');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('cvoice2', 'CrEkWr', 'Cristian', 'Voice', 'cvoice2@yahoo.co.jp', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('ethornewill3', 'itRZHdhF', 'Eden', 'Thornewill', 'ethornewill3@ovh.net', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('kelcome4', 'jozjgkd', 'Krysta', 'Elcome', 'kelcome4@biblegateway.com', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('eraiment5', 'M5RSzEw', 'Elias', 'Raiment', 'eraiment5@soundcloud.com', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('jsaunter6', '03tR6dEkHU', 'Jeanna', 'Saunter', 'jsaunter6@walmart.com', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('sscannell7', 'NXw6FMXTVY5', 'Shel', 'Scannell', 'sscannell7@samsung.com', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('vlatey8', '0yNkwwFo', 'Valentino', 'Latey', 'vlatey8@odnoklassniki.ru', '1');
insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id) values ('dedworthie9', 'cMUH5GMy', 'Dolly', 'Edworthie', 'dedworthie9@intel.com', '1');






drop table if exists Reimbursement;
create table Reimbursement(
id serial primary key,
amount Numeric(15,2) not null,
submitted timestamp default current_date,
resolved timestamp ,
description varchar(250),
author integer references users(id),
resolver integer references users(id),
status_id integer references Reimbursement_status(id),
type_id integer references Reimbursement_type(id)
);

insert into Reimbursement (amount, description, author, resolver, status_id, type_id  ) values ('300', 'Hotel fees', ' 3', '1', '1', '1');
insert into Reimbursement (amount, description, author, resolver, status_id, type_id  ) values ('100', 'Food', '8 ', '2', '1', '3');
insert into Reimbursement (amount, description, author, resolver, status_id, type_id  ) values ('100', 'Food', '4 ', '2', '1', '3');










