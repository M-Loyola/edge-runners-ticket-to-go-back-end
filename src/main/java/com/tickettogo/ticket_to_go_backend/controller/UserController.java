package com.tickettogo.ticket_to_go_backend.controller;

import com.tickettogo.ticket_to_go_backend.entity.Orders;
import com.tickettogo.ticket_to_go_backend.entity.User;
import com.tickettogo.ticket_to_go_backend.service.UserService;
import com.tickettogo.ticket_to_go_backend.service.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public User createNewUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/login")
    public UserResponseDto signInUser(@RequestBody User userRequestLogInDto) {
        return userService.findByEmailAndPassword(userRequestLogInDto);
    }

    @GetMapping("/{userId}/orders")
    public List<Orders> getUserOrders(@PathVariable Integer userId) {
        return userService.findOrdersByUserId(userId);
    }
}
