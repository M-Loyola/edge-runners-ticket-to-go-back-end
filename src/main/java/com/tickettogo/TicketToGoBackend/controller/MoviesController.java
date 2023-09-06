package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.CinemaMovie;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.service.MovieService;
import com.tickettogo.TicketToGoBackend.service.dto.MovieDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @GetMapping()
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/showing")
    public List<Movie> getNowShowingMovies() {
        return movieService.getAllShowingMovies();
    }

    @GetMapping("/upcoming")
    public List<Movie> getUpComingMovies() {
        return movieService.getAllUpComingMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    @GetMapping("/reservationDetails/{cinemaMovieId}")
    public MovieDetailsDto getAllCinemaMovie(@PathVariable Integer cinemaMovieId){
        return  movieService.getAllCinemaMovie(cinemaMovieId);
    }
}
