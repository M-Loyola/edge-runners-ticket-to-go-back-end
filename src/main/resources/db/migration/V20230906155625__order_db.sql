create table if not exists orders (
    orderNumber int auto_increment primary key,
    title varchar(255) NOT NULL,
    CinemaName varchar(255) NOT NULL,
    Location varchar(255) NOT NULL,
    reservedSeats varchar(255) NOT NULL,
    schedule varchar(255) NOT NULL,
    duration int NOT NULL,
    isPayed Boolean NOT NULL,
    price int NOT NULL,
    quantity int NOT NULL,
    totalPrice int NOT NULL
);