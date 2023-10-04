package com.tickettogo.ticket_to_go_backend.service.mapper;

import com.tickettogo.ticket_to_go_backend.entity.User;
import com.tickettogo.ticket_to_go_backend.service.dto.UserResponseDto;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    private UserMapper() {
        // empty constructor
    }

    public static UserResponseDto toEntityResponse(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        return userResponseDto;
    }
}
