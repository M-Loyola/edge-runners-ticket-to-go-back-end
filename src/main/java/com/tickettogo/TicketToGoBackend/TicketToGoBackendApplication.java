package com.tickettogo.TicketToGoBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class TicketToGoBackendApplication {

	@Autowired
	private CinemaRepository cinemaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketToGoBackendApplication.class, args);
	}

	@GetMapping("/")
	public List<Cinema> getAll(){
		return cinemaRepository.findAll();
	}

}
