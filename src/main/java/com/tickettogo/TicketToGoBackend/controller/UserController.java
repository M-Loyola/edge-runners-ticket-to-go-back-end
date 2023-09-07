package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.User;
import com.tickettogo.TicketToGoBackend.service.UserService;
import com.tickettogo.TicketToGoBackend.service.dto.UserResponseDto;
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
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/{userId}")
    public User getUserDetails(@PathVariable Integer userId) {
        return userService.findById(userId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createUser")
    public User createNewUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        return userService.save(user);
    }
    @PostMapping ("/login")
    public UserResponseDto signInUser(@RequestBody User userRequestLogInDto){
        return userService.findByEmailAndPassword(userRequestLogInDto);
    }
}
