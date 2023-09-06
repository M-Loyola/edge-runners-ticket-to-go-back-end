package com.tickettogo.TicketToGoBackend.entity;

import lombok.AllArgsConstructor;
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
    private String image;

    private String description;

    private Boolean isShowing;

    public Movie(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public Movie(Integer id, String title, Integer duration, String image, String description, Boolean isShowing) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.image = image;
        this.description = description;
        this.isShowing = isShowing;
    }

    public Movie() {
    }
}
