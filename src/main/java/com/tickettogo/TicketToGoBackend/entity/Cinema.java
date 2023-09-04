package com.tickettogo.TicketToGoBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    @OneToMany
    @JoinTable(
            name = "cinema_movie",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    List<Movie> movieList;

    public Cinema(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Cinema() {
    }
}
