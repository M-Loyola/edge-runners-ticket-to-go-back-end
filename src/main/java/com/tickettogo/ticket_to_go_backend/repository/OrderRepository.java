package com.tickettogo.ticket_to_go_backend.repository;

import com.tickettogo.ticket_to_go_backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findOrdersByUserId(Integer userId);
}
