package com.tickettogo.ticket_to_go_backend.service;

import com.tickettogo.ticket_to_go_backend.entity.Cinema;
import com.tickettogo.ticket_to_go_backend.repository.CinemaRepository;
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

    public List<Cinema> getAllMoviesInCinema(String location) {

        return cinemaRepository.findByLocation(location);

    }
}
