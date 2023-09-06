CREATE TABLE IF NOT EXISTS users(
    id int auto_increment primary key,
    last_name varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    mobile_number varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    orders varchar(255),
    CONSTRAINT UC_Users UNIQUE(email, mobile_number)
);

INSERT INTO users(last_name, first_name, email, mobile_number, password) VALUES("John", "Smith", "johnsmith@johnsmith.com", "09987654321", "password");