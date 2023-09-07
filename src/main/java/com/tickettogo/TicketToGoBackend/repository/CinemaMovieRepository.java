package com.tickettogo.TicketToGoBackend.repository;

import com.tickettogo.TicketToGoBackend.entity.DetailsMovAndCin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaMovieRepository extends JpaRepository<DetailsMovAndCin, Integer> {

    @Query(value = "SELECT * FROM details_mov_and_cin WHERE movie_id = ?1 and cinema_id = ?2",
    nativeQuery = true)
    List<DetailsMovAndCin> findOneByMovieIdAndCinemaId(Integer movie_Id, Integer cinemaId);
}
