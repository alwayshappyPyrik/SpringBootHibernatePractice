--liquibase formatted sql

--changeset ypyrikov: 1
create table test.persons
(
    firstname      varchar(255),
    surname        varchar(255),
    age            smallint,
    phone_number   varchar(50),
    city_of_living varchar(255) not null,
    primary key (firstname, surname, age)
);