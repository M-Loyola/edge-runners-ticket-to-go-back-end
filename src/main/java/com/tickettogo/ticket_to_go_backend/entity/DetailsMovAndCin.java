package com.tickettogo.ticket_to_go_backend.entity;


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
    private Integer movieId;
    private Integer cinemaId;

    private Integer price;

    private String schedule;
    private String occupiedSeats;
}

