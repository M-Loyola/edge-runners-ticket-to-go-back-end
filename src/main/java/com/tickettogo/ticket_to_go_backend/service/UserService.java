package com.tickettogo.ticket_to_go_backend.service;

import com.tickettogo.ticket_to_go_backend.entity.Orders;
import com.tickettogo.ticket_to_go_backend.entity.User;
import com.tickettogo.ticket_to_go_backend.exception.NoUserFoundException;
import com.tickettogo.ticket_to_go_backend.repository.OrderRepository;
import com.tickettogo.ticket_to_go_backend.repository.UserRepository;
import com.tickettogo.ticket_to_go_backend.service.dto.UserResponseDto;
import com.tickettogo.ticket_to_go_backend.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public UserResponseDto findByEmailAndPassword(User userRequestLogInDto) {

        User oneByEmailAndPassword = userRepository.findOneByEmailAndPassword(userRequestLogInDto
                .getEmail(), userRequestLogInDto.getPassword()).orElseThrow(NoUserFoundException::new);


        return UserMapper.toEntityResponse(oneByEmailAndPassword);
    }

    public List<Orders> findOrdersByUserId(Integer userId) {
        return orderRepository.findOrdersByUserId(userId);
    }
}
