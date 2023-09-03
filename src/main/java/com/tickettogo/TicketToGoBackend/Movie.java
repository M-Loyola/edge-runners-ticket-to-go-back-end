package com.tickettogo.TicketToGoBackend;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer duration;

    @ManyToMany(mappedBy = "movies")
    private List<Cinema> cinemas;
}
