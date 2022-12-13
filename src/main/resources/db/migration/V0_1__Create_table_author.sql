create table author
(
    id     serial,
    name varchar not null unique,
    particularity varchar,
    birth_date date,
    primary key (id)
);