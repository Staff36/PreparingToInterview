-- DATABASE POSTGRES
--DDL
create schema if not exists cinema;
create table if not exists cinema.films
(
    id     bigserial    not null
        constraint films_pk
            primary key,
    name   varchar(255) NOT NULL,
    length int          NOT NULL
);

create table if not exists cinema.shows
(
    id      bigserial  not null
        constraint shows_pk primary key,
    start   timestamp   NOT NULL,
    film_id bigint references cinema.films (id),
    price   float NOT NULL
);

CREATE TABLE if not exists cinema.tickets
(
    id      bigserial not null
        constraint tickets_pk primary key,
    show_id bigint references cinema.shows (id)
);

-- Fill tables
INSERT INTO cinema.films (name, length)
VALUES ('Terminator', 90),
       ('Matrix', 120),
       ('Throne', 90),
       ('Transformers', 90),
       ('17 moments of spring', 120);
INSERT INTO cinema.shows (start, film_id, price)
VALUES ('2021-11-25 09:00:00', 1, 200),
       ('2021-11-25 14:30:00', 1, 400),
       ('2021-11-25 18:30:00', 4, 600),
       ('2021-11-25 21:15:00', 3, 600),
       ('2021-11-25 22:45:00', 1, 400),
       ('2021-11-25 11:00:00', 2, 300),
       ('2021-11-25 14:00:00', 2, 300),
       ('2021-11-25 18:30:00', 2, 400);
INSERT INTO cinema.tickets (show_id)
VALUES (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (3),
       (3),
       (1),
       (1),
       (1),
       (1),
       (1),
       (5),
       (6),
       (6),
       (6),
       (6),
       (7),
       (2);
