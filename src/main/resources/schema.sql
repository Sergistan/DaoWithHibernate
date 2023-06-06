CREATE table persons
(
    name           varchar(15) not null,
    surname        varchar(15) not null,
    age            int check (age > 0),
    phone_number   varchar(15),
    city_of_living varchar(15) not null,
    PRIMARY KEY (name, surname, age)
);

