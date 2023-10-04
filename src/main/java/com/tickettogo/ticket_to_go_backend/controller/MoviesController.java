package com.tickettogo.ticket_to_go_backend.controller;

import com.tickettogo.ticket_to_go_backend.entity.DetailsMovAndCin;
import com.tickettogo.ticket_to_go_backend.entity.Movie;
import com.tickettogo.ticket_to_go_backend.service.MovieService;
import com.tickettogo.ticket_to_go_backend.service.dto.MovieDetailsDto;
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

    @GetMapping("/{movieId}/{cinemaId}/reservationDetails")
    public MovieDetailsDto getReservationDetails(@PathVariable Integer movieId, @PathVariable Integer cinemaId) {

        return movieService.getReservationDetails(movieId, cinemaId);
    }

    @PutMapping("/{cinemaMovieId}/occupiedSeats")
    public DetailsMovAndCin updateScheduleDetails(@PathVariable Integer cinemaMovieId, @RequestBody String newReservedSeats) {
        return movieService.updateScheduleDetails(cinemaMovieId, newReservedSeats);
    }
}
