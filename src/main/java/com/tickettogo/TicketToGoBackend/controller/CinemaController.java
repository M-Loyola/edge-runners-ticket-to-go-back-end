package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<Cinema> getAllCinema() {
        return cinemaService.getAllCinema();
    }

    @GetMapping("/{location}/movies")
    public List<Cinema> getAllMoviesInCinema(@PathVariable String location) {
        return cinemaService.getAllMoviesInCinema(location);
    }
}
