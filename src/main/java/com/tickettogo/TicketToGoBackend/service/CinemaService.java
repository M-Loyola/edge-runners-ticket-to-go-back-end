package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.exception.NoCinemaFound;
import com.tickettogo.TicketToGoBackend.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public Set<Movie> getAllMoviesInCinema(Integer id) {

        Cinema byId = cinemaRepository.findById(id).orElseThrow(NoCinemaFound::new);

        return byId.getMovieSet();
    }
}
