package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.Users;
import com.tickettogo.TicketToGoBackend.exception.UserAlreadyExistsException;
import com.tickettogo.TicketToGoBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Users> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/{userId}")
    public Users getUserDetails(@PathVariable Integer userId) {
        return userService.findById(userId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createUser")
    public Users createNewUser(@RequestBody Users user) throws SQLIntegrityConstraintViolationException {
        return userService.save(user);
    }
}
