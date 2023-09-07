package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.User;
import com.tickettogo.TicketToGoBackend.exception.NoUserFoundException;
import com.tickettogo.TicketToGoBackend.repository.UserRepository;
import com.tickettogo.TicketToGoBackend.service.dto.UserResponseDto;
import com.tickettogo.TicketToGoBackend.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public User save(User user) throws SQLIntegrityConstraintViolationException {
        return userRepository.save(user);
    }

    public UserResponseDto findByEmailAndPassword(User userRequestLogInDto) {

        User oneByEmailAndPassword = userRepository.findOneByEmailAndPassword(userRequestLogInDto
                .getEmail(), userRequestLogInDto.getPassword()).orElseThrow(NoUserFoundException::new);


        return UserMapper.toEntityResponse(oneByEmailAndPassword);
    }
}
