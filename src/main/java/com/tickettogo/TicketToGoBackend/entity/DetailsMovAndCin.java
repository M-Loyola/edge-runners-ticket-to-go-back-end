package com.tickettogo.TicketToGoBackend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "details_mov_and_cin")
public class DetailsMovAndCin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaMovieId;
    private Integer movie_Id;
    private Integer cinema_Id;

    private Integer price;

    private String schedule;
    private String occupiedSeats;
}

