package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Orders;
import com.tickettogo.TicketToGoBackend.entity.Users;
import com.tickettogo.TicketToGoBackend.exception.NoUserFoundException;
import com.tickettogo.TicketToGoBackend.repository.OrderRepository;
import com.tickettogo.TicketToGoBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public Orders saveOrder(Orders order){

        Orders saveOrder = orderRepository.save(order);
        if(saveOrder.getIsPayed()){
            updateOrderQrCodeUrl(saveOrder);
        }
        return saveOrder;
    }

    private void updateOrderQrCodeUrl(Orders order){
        StringBuilder stringBuilder = new StringBuilder();
        String qrCodeBaseUrl = "https://barcode.orcascan.com/?data=";
        Users usersById = userRepository.findById(order.getUser_id()).orElseThrow(NoUserFoundException::new);
        String qrCodeUrl = stringBuilder.append(qrCodeBaseUrl)
                .append(order.getOrderNumber())
                .append(order.getCinemaName())
                .append(usersById.getId())
                .append(usersById.getFirstName())
                .append(usersById.getMobile_number()).toString().replace(" ", "");
        order.setQrCodeUrl(qrCodeUrl);
        orderRepository.save(order);
    }
}
