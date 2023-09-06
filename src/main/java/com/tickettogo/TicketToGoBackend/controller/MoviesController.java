package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.CinemaMovie;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/cinemamovie")
    public List<CinemaMovie> getAllCinemaMovie(){
        return  movieService.getAllCinemaMovie();
    }
}
