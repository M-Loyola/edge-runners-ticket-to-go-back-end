package com.tickettogo.TicketToGoBackend.service.mapper;

import com.tickettogo.TicketToGoBackend.entity.User;
import com.tickettogo.TicketToGoBackend.service.dto.UserResponseDto;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public static UserResponseDto toEntityResponse(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        return userResponseDto;
    }
}
