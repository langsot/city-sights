CREATE TABLE cities(
    id serial primary key ,
    name varchar (30),
    population  int ,
    metro boolean,
    country varchar (30)
);

CREATE TABLE sights(
    id serial primary key ,
    name varchar (50),
    date date,
    description varchar(500),
    sight_type varchar(30),
    city_id int references cities(id)
);