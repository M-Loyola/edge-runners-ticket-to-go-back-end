package com.tickettogo.ticket_to_go_backend.service.dto;

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
