package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }
}
