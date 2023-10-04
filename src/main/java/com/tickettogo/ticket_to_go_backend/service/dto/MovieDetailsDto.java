package com.tickettogo.ticket_to_go_backend.service.dto;

import lombok.Data;

@Data
public class MovieDetailsDto {
    private Integer id;
    private String title;
    private String description;
    private Integer duration;

    private String cinemaName;

    private String location;
    private Integer price;
    private String schedule;
    private String occupiedSeats;
}
