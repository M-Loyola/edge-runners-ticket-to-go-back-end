package com.tickettogo.TicketToGoBackend.repository;

import com.tickettogo.TicketToGoBackend.entity.DetailsCinemaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaMovieRepository extends JpaRepository<DetailsCinemaMovie, Integer> {
}
