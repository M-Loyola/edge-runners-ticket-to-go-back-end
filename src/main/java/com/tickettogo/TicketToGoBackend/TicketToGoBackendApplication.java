package com.tickettogo.TicketToGoBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TicketToGoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketToGoBackendApplication.class, args);
    }

}
