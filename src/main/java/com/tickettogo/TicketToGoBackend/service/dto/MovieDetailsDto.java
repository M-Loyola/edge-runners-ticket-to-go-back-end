package com.tickettogo.TicketToGoBackend.service.dto;

import lombok.Data;

@Data
public class MovieDetailsDto {
    private Integer id;
    private String title;
    private String description;
    private Integer duration;

    private String CinemaName;

    private String Location;
    private Integer Price;
    private String schedule;
}
