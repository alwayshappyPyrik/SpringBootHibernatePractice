--liquibase formatted sql

--changeset ypyrikov: 1
insert
into test.persons (firstname, surname, age, phone_number, city_of_living)
values ('Yaroslav', 'Pyrikov', 31, '', 'Moscow');

insert
into test.persons (firstname, surname, age, phone_number, city_of_living)
values ('Vasiliy', 'Ogurсhov', 31, '', 'Moscow');

insert
into test.persons (firstname, surname, age, phone_number, city_of_living)
values ('Roberto', 'Carlos', 40, '', 'Brazil');

insert
into test.persons (firstname, surname, age, phone_number, city_of_living)
values ('Vania', 'Poddupniy', 1, '', 'Volgograd');