package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.Users;
import com.tickettogo.TicketToGoBackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void should_show_all_users_when_perform_get_given_few_users() throws Exception {
        //given
        Users savedUser1 = userRepository.save(new Users("Jens", "Jovellano", "jensjovellano@gmail.com", "09228509618", "jenspassword"));
        Users savedUser2 = userRepository.save(new Users("Clark", "Kent", "clarkkent@gmail.com", "123123123", "wewewew"));
        //when
        mockMvc.perform(get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[0].firstName")).value("Jens"))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[1].firstName")).value("Clark"));
        //then
    }
}