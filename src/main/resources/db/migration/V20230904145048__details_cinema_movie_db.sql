create table if not exists details_cinema_movie (
    cinema_movie_id  int auto_increment primary key,
    movie_id int NOT NULL,
    cinema_id int NOT NULL,
    price int NOT NULL,
    schedule varchar(255) NULL,
    occupied_seats varchar(1000) NULL,
    FOREIGN KEY (movie_id)
    REFERENCES movie(id),
	FOREIGN KEY (cinema_id)
    REFERENCES cinema(id)
);