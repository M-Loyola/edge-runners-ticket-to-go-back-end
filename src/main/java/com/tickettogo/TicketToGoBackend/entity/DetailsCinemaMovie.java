package com.tickettogo.TicketToGoBackend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailsCinemaMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaMovieId;
    private Integer movie_Id;
    private Integer cinema_Id;

    private Integer price;

    private String schedule;
    private String occupiedSeats;
}

