package com.tickettogo.ticket_to_go_backend.repository;

import com.tickettogo.ticket_to_go_backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
}
