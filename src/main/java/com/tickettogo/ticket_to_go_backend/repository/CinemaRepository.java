package com.tickettogo.ticket_to_go_backend.repository;

import com.tickettogo.ticket_to_go_backend.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
     List<Cinema> findByLocation(String location);
}
