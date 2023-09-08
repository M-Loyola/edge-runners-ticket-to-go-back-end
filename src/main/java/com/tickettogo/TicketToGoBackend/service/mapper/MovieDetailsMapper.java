package com.tickettogo.TicketToGoBackend.service.mapper;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.DetailsMovAndCin;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.service.dto.MovieDetailsDto;

public class MovieDetailsMapper {

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
