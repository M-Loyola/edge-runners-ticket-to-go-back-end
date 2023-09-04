create table if not exists movie (
    id  int auto_increment primary key,
    title varchar(255) NOT NULL,
    duration int NOT NULL
);