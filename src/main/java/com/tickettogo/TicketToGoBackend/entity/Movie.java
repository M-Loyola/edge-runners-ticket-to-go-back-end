package com.tickettogo.TicketToGoBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer duration;

    public Movie(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public Movie() {
    }
}
