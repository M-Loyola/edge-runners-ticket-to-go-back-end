create table if not exists movie (
    id  int auto_increment primary key,
    name varchar(255) NOT NULL,
    location varchar(255) NOT NULL
);