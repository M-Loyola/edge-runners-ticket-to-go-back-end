package com.tickettogo.TicketToGoBackend.service.dto;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.CinemaMovie;
import com.tickettogo.TicketToGoBackend.entity.Movie;

public class MovieDetailsMapper {

    public static MovieDetailsDto toEntity(Movie movie, Cinema cinema, CinemaMovie cinemaMovie){
        MovieDetailsDto movieDetailsDto = new MovieDetailsDto();

        movieDetailsDto.setId(movie.getId());
        movieDetailsDto.setTitle(movie.getTitle());
        movieDetailsDto.setDescription(movie.getDescription());
        movieDetailsDto.setDuration(movie.getDuration());
        movieDetailsDto.setCinemaName(cinema.getName());
        movieDetailsDto.setLocation(cinema.getLocation());
        movieDetailsDto.setPrice(cinemaMovie.getPrice());
        movieDetailsDto.setSchedule(cinemaMovie.getSchedule());
        return movieDetailsDto;
    }
}
