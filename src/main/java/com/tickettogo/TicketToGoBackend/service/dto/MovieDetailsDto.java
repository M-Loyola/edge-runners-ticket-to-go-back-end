package com.tickettogo.TicketToGoBackend.service.dto;

import lombok.Data;

@Data
public class MovieDetailsDto {
    private Integer id;
    private String title;
    private String description;
    private Integer duration;

    public MovieDetailsDto(Integer id, String title, String description, Integer duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public MovieDetailsDto() {
    }
}
