insert into cinema(name, location )
values ("Sm Sta rosa Cinema 1", "Laguna");

insert into cinema(name, location )
values ("Sm Sta rosa Cinema 2", "Laguna");

insert into cinema(name, location )
values ("Sm Ortigas Cinema 1", "Ortigas");

insert into cinema(name, location )
values ("Sm Ortigas Cinema 2", "Ortigas");

insert into cinema(name, location )
values ("Sm manila Cinema 1", "Manila");

insert into cinema(name, location )
values ("Sm manila Cinema 2", "Manila");

insert into cinema(name, location )
values ("Taguig cinema", "Taguig");
insert into movie(title, duration, description, image, is_showing )
values ("John Wick", 140, "Lorem ipsum just john wick things", "https://sg-test-11.slatic.net/p/48f11fbde5fc8191bbfce7b5985633e6.jpg", true );
insert into movie(title, duration, description, image,is_showing)
values ("spider man", 150,"Lorem ipsum just spider man things", "https://m.media-amazon.com/images/I/815IBWT+WeL._AC_UF1000,1000_QL80_.jpg",true);
insert into movie(title, duration, description, image,is_showing )
values ("Forrest Gump", 160,"Lorem ipsum just kung fu panda  things", "https://flxt.tmsimg.com/assets/p15829_v_v13_aa.jpg",true);
insert into movie(title, duration, description, image,is_showing )
values ("Insidious", 160,"Lorem ipsum just Insidious  things", "https://miro.medium.com/v2/resize:fit:500/1*I9zDkUL5PfD7aT0O2Zk8mg.jpeg",true);

insert into movie(title, duration, description, image,is_showing )
values ("BumbleeBee", 160,"Lorem ipsum just kung fu panda 5  things", "https://m.media-amazon.com/images/I/71LlMXBogbL.jpg",true);

insert into movie(title, duration, description, image,is_showing )
values ("Home Alone", 160,"Lorem ipsum just kung fu panda 5  things", "https://image.tmdb.org/t/p/original/onTSipZ8R3bliBdKfPtsDuHTdlL.jpg",false);

insert into movie(title, duration, description, image,is_showing )
values ("Hypnotic", 160,"Lorem ipsum hypnotic things", "https://m.media-amazon.com/images/M/MV5BNmNmNWNiMjUtZmYyMC00OWVhLThmMTItNjkxYzU4Yzk2NTdlXkEyXkFqcGdeQXVyMDc5ODIzMw@@._V1_FMjpg_UX1000_.jpg",false);
insert into movie(title, duration, description, image,is_showing )
values ("Bohemian Rhapsody", 160,"Lorem ipsum just Bohemian Rhapsody things", "https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/bohemian-rhapsody-web.jpg",false);
insert into movie(title, duration, description, image,is_showing )
values ("Avengers", 160,"Lorem ipsum just avengers  things", "https://www.movieposters.com/cdn/shop/products/108b520c55e3c9760f77a06110d6a73b_240x360_crop_center.progressive.jpg?v=1573652543",false);


insert into details_cinema_movie(movie_id, cinema_id, price, schedule, occupied_seats)
values (1, 1, 240, '2023-09-04 10:30:00', 'A1,A2');
insert into details_cinema_movie(movie_id, cinema_id, price, schedule, occupied_seats)
values (2, 2, 240, '2023-09-04 13:30:00', 'B2,B3,C10');
insert into details_cinema_movie(movie_id, cinema_id, price, schedule, occupied_seats)
values (3, 3, 1000, '2023-06-04 15:30:12', 'C5');

insert into details_cinema_movie(movie_id, cinema_id, price, schedule )
values (4, 4, 1000, '2023-06-04 15:30:12');

insert into details_cinema_movie(movie_id, cinema_id, price, schedule )
values (5, 5, 1000, '2023-06-04 15:30:12');

insert into details_cinema_movie(movie_id, cinema_id, price, schedule )
values (6, 6, 1000, '2023-06-04 15:30:12');

insert into details_cinema_movie(movie_id, cinema_id, price, schedule )
values (2, 6, 1000, '2023-06-04 15:30:12');

