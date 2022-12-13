create table category
(
    id     serial,
    name varchar not null unique,
    primary key (id)
);