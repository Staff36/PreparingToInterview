create table students(
    id bigserial primary key ,
    name varchar(64) not null ,
    age integer
);

insert into students (name, age) VALUES ('Petr', 23),
                                        ('Dima',24),
                                        ('Andrey', 23),
                                        ('Valeriy', 21);