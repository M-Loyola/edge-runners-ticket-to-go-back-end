package com.tickettogo.ticket_to_go_backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tickettogo.ticket_to_go_backend.entity.Orders;
import com.tickettogo.ticket_to_go_backend.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
 class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void clearAll() {
        orderRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void should_return_order_when_perform_save_given_order() throws Exception {
        //given
        Orders orders = new Orders(null,"John Wick", "Cinema Manila", "Manila","", "A1,A2", "2023-06-04 15:30:12", 120, false, 350, 2, 350,1 ,null);
        ObjectMapper objectMapper = new ObjectMapper();
        //when    //then
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orders)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderNumber").exists())
                .andExpect(jsonPath("$.title").value("John Wick"))
                .andExpect(jsonPath("$.cinemaName").value("Cinema Manila"))
                .andExpect(jsonPath("$.location").value("Manila"))
                .andExpect(jsonPath("$.reservedSeats").value("A1,A2"))
                .andExpect(jsonPath("$.schedule").value("2023-06-04 15:30:12"));
    }
}
