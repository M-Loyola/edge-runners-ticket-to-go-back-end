package com.tickettogo.TicketToGoBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;
    private String title;
    private String cinemaName;
    private String location;

    private String reservedSeats;
    private String schedule;
    private Integer duration;
    private Boolean isPayed;
    private Integer price;
    private Integer quantity;
    private Integer totalPrice;
    private Integer user_id;

    public Orders(String title, String cinemaName, String location, String reservedSeats, String schedule, Integer duration, Boolean isPayed, Integer price, Integer quantity, Integer totalPrice) {
        this.title = title;
        this.cinemaName = cinemaName;
        this.location = location;
        this.reservedSeats = reservedSeats;
        this.schedule = schedule;
        this.duration = duration;
        this.isPayed = isPayed;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Orders() {
    }
}
