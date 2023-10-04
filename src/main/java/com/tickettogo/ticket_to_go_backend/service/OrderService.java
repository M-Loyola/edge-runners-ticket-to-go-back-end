package com.tickettogo.ticket_to_go_backend.service;

import com.tickettogo.ticket_to_go_backend.entity.Orders;
import com.tickettogo.ticket_to_go_backend.entity.User;
import com.tickettogo.ticket_to_go_backend.exception.NoUserFoundException;
import com.tickettogo.ticket_to_go_backend.repository.OrderRepository;
import com.tickettogo.ticket_to_go_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public Orders saveOrder(Orders order) {
        Orders saveOrder = orderRepository.save(order);
        if (saveOrder.getIsPayed()) {
            updateOrderQrCodeUrl(saveOrder);
        }
        return saveOrder;
    }

    private void updateOrderQrCodeUrl(Orders order) {
        StringBuilder stringBuilder = new StringBuilder();
        String qrCodeBaseUrl = "https://barcode.orcascan.com/?data=";
        User userById = userRepository.findById(order.getUserId()).orElseThrow(NoUserFoundException::new);
        String qrCodeUrl = stringBuilder.append(qrCodeBaseUrl)
                .append(order.getOrderNumber())
                .append("-")
                .append(order.getCinemaName())
                .append(order.getLocation())
                .append(userById.getId())
                .append(userById.getFirstName())
                .append(userById.getLastName())
                .append(userById.getMobileNumber()).toString().replace(" ", "");
        order.setQrCodeUrl(qrCodeUrl);
        orderRepository.save(order);
    }

    public String updateOrder(Integer orderNumber) {
        Orders toBeUpdatedOrder = orderRepository.findById(orderNumber).orElseThrow(RuntimeException::new);
        toBeUpdatedOrder.setIsPayed(true);
        saveOrder(toBeUpdatedOrder);
        return "Order saved";
    }
}
