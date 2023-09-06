package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.CinemaMovie;
import com.tickettogo.TicketToGoBackend.repository.CinemaMovieRepository;
import com.tickettogo.TicketToGoBackend.service.dto.MovieDetailsDto;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.exception.NoMovieException;
import com.tickettogo.TicketToGoBackend.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    CinemaMovieRepository cinemaMovieRepository;

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public List<Movie> getAllShowingMovies() {
        List<Movie> allMovies = getAllMovies();

        return allMovies.stream()
                .filter(Movie::getIsShowing)
                .collect(Collectors.toList());
    }

    public List<Movie> getAllUpComingMovies() {
        List<Movie> allMovies = getAllMovies();
        return allMovies.stream()
                .filter(movie -> !movie.getIsShowing())
                .collect(Collectors.toList());
    }

    public Movie findById(Integer id) {
        return moviesRepository.findById(id).orElseThrow(NoMovieException::new);
    }

    public List<CinemaMovie> getAllCinemaMovie(){
        return cinemaMovieRepository.findAll();
    }
}
