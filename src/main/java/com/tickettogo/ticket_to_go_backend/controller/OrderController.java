package com.tickettogo.ticket_to_go_backend.controller;

import com.tickettogo.ticket_to_go_backend.entity.Orders;
import com.tickettogo.ticket_to_go_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orders saveOrder(@RequestBody Orders orders){
        return orderService.saveOrder(orders);
    }

    @PutMapping("/{orderNumber}")
    public String updateOrder(@PathVariable Integer orderNumber) {
         return orderService.updateOrder(orderNumber);
    }
}
