create table if not exists orders (
    order_number int auto_increment primary key,
    title varchar(255) NOT NULL,
    cinema_name varchar(255) NOT NULL,
    location varchar(255) NOT NULL,
    reserved_seats varchar(255) NOT NULL,
    schedule varchar(255) NOT NULL,
    duration int NOT NULL,
    is_payed Boolean NOT NULL,
    price int NOT NULL,
    quantity int NOT NULL,
    total_price int NOT NULL,
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id)
);