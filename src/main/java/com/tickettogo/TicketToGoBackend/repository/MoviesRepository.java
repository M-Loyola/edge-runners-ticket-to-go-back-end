package com.tickettogo.TicketToGoBackend.repository;

import com.tickettogo.TicketToGoBackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
}
