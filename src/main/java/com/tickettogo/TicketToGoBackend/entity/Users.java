package com.tickettogo.TicketToGoBackend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile_number;
    private String password;

    public Users(String firstName, String lastName, String email, String mobile_number, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile_number = mobile_number;
        this.password = password;
    }
}
