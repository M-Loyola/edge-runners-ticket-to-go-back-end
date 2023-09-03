package com.tickettogo.TicketToGoBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://ex-ticket-to-go-front-end-qa.up.railway.app")
@SpringBootApplication
@RestController
public class TicketToGoBackendApplication {

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private MoviesRepository moviesRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketToGoBackendApplication.class, args);
	}

	@GetMapping("/")
	public List<Cinema> getAll(){
		return cinemaRepository.findAll();
	}
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return moviesRepository.findAll();
	}

}
