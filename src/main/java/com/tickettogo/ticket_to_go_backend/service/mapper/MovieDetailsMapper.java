package com.tickettogo.ticket_to_go_backend.service.mapper;

import com.tickettogo.ticket_to_go_backend.entity.Cinema;
import com.tickettogo.ticket_to_go_backend.entity.DetailsMovAndCin;
import com.tickettogo.ticket_to_go_backend.entity.Movie;
import com.tickettogo.ticket_to_go_backend.service.dto.MovieDetailsDto;

public class MovieDetailsMapper {
    private MovieDetailsMapper() {
        // empty constructor
    }

    public static MovieDetailsDto toEntity(Movie movie, Cinema cinema, DetailsMovAndCin cinemaMovie){
        MovieDetailsDto movieDetailsDto = new MovieDetailsDto();

        movieDetailsDto.setId(cinemaMovie.getCinemaMovieId());
        movieDetailsDto.setTitle(movie.getTitle());
        movieDetailsDto.setDescription(movie.getDescription());
        movieDetailsDto.setDuration(movie.getDuration());
        movieDetailsDto.setCinemaName(cinema.getName());
        movieDetailsDto.setLocation(cinema.getLocation());
        movieDetailsDto.setPrice(cinemaMovie.getPrice());
        movieDetailsDto.setSchedule(cinemaMovie.getSchedule());
        movieDetailsDto.setOccupiedSeats(cinemaMovie.getOccupiedSeats());
        return movieDetailsDto;
    }
}
