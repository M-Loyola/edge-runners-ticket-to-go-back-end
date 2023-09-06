package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Users;
import com.tickettogo.TicketToGoBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public Users save(Users user) throws SQLIntegrityConstraintViolationException {
        return userRepository.save(user);
    }
}
