drop table if exists sales_office;
create table sales_office(
id serial primary key,
street_adress varchar(30),
city varchar(30),
state varchar(20),
zip	integer
);                                                                                                                                



/*
 eployees
  id 			    SERIAL
  employee_name 	VARCHAR
  birth_date 		Date
 



*/
drop table if exists employees;
create table employees (
id serial primary key, 
employee_name varchar(30),
birth_date date,
employee_store_id integer references sales_office(id)
);

/*


store_id integer references sales_office(store_id),
employee_id integer references empolyees (id)

*/
drop table if exists cutomer;
create table customer(
customer_id serial primary key,
customer_name varchar(30),
employee_id integer references empolyees (id)
);


insert into sales_office (street_adress, city, state, zip) values ('572 Forest Run Lane', 'Boston', 'Massachusetts', '02114');
insert into sales_office (street_adress, city, state, zip) values ('25709 Kensington Plaza', 'Oklahoma City', 'Oklahoma', '73104');
insert into sales_office (street_adress, city, state, zip) values ('426 Maple Wood Plaza', 'Tacoma', 'Washington', '98481');
insert into sales_office (street_adress, city, state, zip) values ('4 West Pass', 'Schenectady', 'New York', '12305');
insert into sales_office (street_adress, city, state, zip) values ('63105 Sachtjen Avenue', 'Wilmington', 'Delaware', '19886');
insert into sales_office (street_adress, city, state, zip) values ('1718 Walton Trail', 'Jacksonville', 'Florida', '32204');
insert into sales_office (street_adress, city, state, zip) values ('685 Calypso Circle', 'Lexington', 'Kentucky', '40581');


insert
	into
	employees (employee_name,
	birth_date,
	state,
	zip)
values ('Karmen',
'9/9/2021',
'New Jersey',
'07310');