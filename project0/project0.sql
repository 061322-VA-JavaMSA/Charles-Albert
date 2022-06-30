drop table if exists customer_info;
create table customer_info(
id serial primary key,
username varchar(30) unique not null check(length(username) >2),
password varchar(30) not null,
customer_name varchar(30)not null,
account_number varchar(10)
);

insert into customer_info (username, password, customer_name, account_number) values ('jbramsen0', 'baqyu8sgWV', 'Jenni', '6678719034');
insert into customer_info (username, password, customer_name, account_number) values ('plambis1', '96GKDMIFp', 'Park', '0003369242');
insert into customer_info (username, password, customer_name, account_number) values ('kmaple2', 'bG6gOlUy7J8U', 'Krishna', '2860933549');
insert into customer_info (username, password, customer_name, account_number) values ('vpepper3', '9QaLBrRMvR', 'Violante', '5517236413');
insert into customer_info (username, password, customer_name, account_number) values ('svedyasov4', 'hfKkrz5w3Mc', 'Sula', '4410868136');
insert into customer_info (username, password, customer_name, account_number) values ('dguest5', 'S74wbafN7gvX', 'Doralin', '9460897371');
insert into customer_info (username, password, customer_name, account_number) values ('rwatkiss6', 'K5LcOts', 'Rosabel', '6124706016');
insert into customer_info (username, password, customer_name, account_number) values ('twooder7', 'yc3NMd', 'Tobey', '4576676989');
insert into customer_info (username, password, customer_name, account_number) values ('dgloucester8', 'LowU0Xa', 'Devi', '9738705150');
insert into customer_info (username, password, customer_name, account_number) values ('tpowney9', 'UX8bcV6sIhT', 'Teena', '3699866319');


drop table if exists inventory;
create table inventory(
item_id serial primary key,
item_name varchar (30),
item_model varchar (30),
item_price int,
buyers_id integer references customer_info(id)
);

insert into inventory (item_name, item_model, item_price) values ('Isuzu', 'Impulse', '15000');
insert into inventory (item_name, item_model, item_price) values ('Toyota', 'Paseo', '10000');
insert into inventory (item_name, item_model, item_price) values ('Lincoln', 'Continental', '12000');
insert into inventory (item_name, item_model, item_price) values ('Dodge', 'Spirit','19000');
insert into inventory (item_name, item_model, item_price) values ('GMC', 'Rally Wagon 3500', '8000');
insert into inventory (item_name, item_model, item_price) values ('Buick', 'Park Avenue', '11000');
insert into inventory (item_name, item_model, item_price) values ('Pontiac', 'Bonneville', '9000');
insert into inventory (item_name, item_model, item_price) values ('Chevrolet', 'Cavalier', '95000');
insert into inventory (item_name, item_model, item_price) values ('Mitsubishi', 'Pajero', '7000');
insert into inventory (item_name, item_model, item_price) values ('Ford', 'Bronco', '85000');




drop table if exists employee_info;
create table employee_info(
id serial primary key,
username varchar(30) unique not null check(length(username) >2),
password varchar(30) not null,
employee_name varchar(30)not null,
badge_number varchar(10)
);

insert into employee_info (username, password, employee_name, badge_number) values ('lmulheron0', 'hgSOm0ZtY2', 'Lutero', '5888130966');
insert into employee_info (username, password, employee_name, badge_number) values ('bbick1', '8NNUFVyA2aSx', 'Bearnard', '7934299958');
insert into employee_info (username, password, employee_name, badge_number) values ('edreakin2', '7NgKJCyE', 'Edithe', '2051482764');
insert into employee_info (username, password, employee_name, badge_number) values ('rgoretti3', 'M3nZ9e57PfK', 'Renault', '7927798588');
insert into employee_info (username, password, employee_name, badge_number) values ('mkindon4', '2duII5Ud', 'Mufinella', '3218170303');
insert into employee_info (username, password, employee_name, badge_number) values ('dmeaddowcroft5', 'gjBA9ijl8Ftm', 'Donella', '1099516811');
insert into employee_info (username, password, employee_name, badge_number) values ('aconquest6', 'peC8zWky93', 'Addy', '9235446864');
insert into employee_info (username, password, employee_name, badge_number) values ('vkeaysell7', 'bMSVU2PcoQ', 'Vinita', '9684535112');
insert into employee_info (username, password, employee_name, badge_number) values ('ecraister8', 'H02G23f', 'Elie', '1004986017');
insert into employee_info (username, password, employee_name, badge_number) values ('sseggie9', 'gY530KHVDPK', 'Saundra', '1497986974');

drop table if exists offers;
create table offers(
offer_cus_id integer references customer_info(id),
offer_item_id integer references inventory(item_id),
offer float,
payments float
);

insert into offers (offer_cus_id, offer_item_id, offer, payments) values ('1','1','3000','3000');
insert into offers (offer_cus_id, offer_item_id, offer, payments) values ('2','2','1500', '1500');

select * from offers join inventory on offer_cus_id = buyers_id;
update customer_info set password = 'Rocket' where id = 5;
update inventory set buyers_id ='2' where item_id = 1;
select * from offers  join inventory on offer_cus_id = buyers_id;
update inventory set buyers_id  = '2' where item_id = 2;
select * from inventory where buyers_id  = 2;
update inventory set buyers_id  = 1 where item_id = 1;
update inventory set buyers_id  = 3 where item_id = 3;


select * from offers join inventory on offer_cus_id = buyers_id ;