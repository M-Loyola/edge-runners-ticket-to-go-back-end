package com.tickettogo.TicketToGoBackend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRequestLogInDto {
    private String email;
    private String password;
}
