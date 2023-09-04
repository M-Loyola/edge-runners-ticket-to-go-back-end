package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.exception.NoCinemaFound;
import com.tickettogo.TicketToGoBackend.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public List<Movie> getAllMoviesInCinema(Integer id) {

        Cinema CinemaById = cinemaRepository.findById(id).orElseThrow(NoCinemaFound::new);

        return CinemaById.getMovieList();
    }
}
