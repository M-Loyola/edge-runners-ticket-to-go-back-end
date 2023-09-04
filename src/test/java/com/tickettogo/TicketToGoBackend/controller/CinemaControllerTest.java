package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.repository.CinemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CinemaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CinemaRepository cinemaRepository;

    @BeforeEach
    void clearAll() {
        cinemaRepository.deleteAll();
    }

    @Test
    void should_show_all_cinema_when_perform_get_companies_given_company_controller() throws Exception {
        //given
        cinemaRepository.save(new Cinema("Cinema 1", "Manila"));
        cinemaRepository.save(new Cinema("Cinema 2", "Taguig"));

        //when and then
        mockMvc.perform(get("/cinemas"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[0].name")).value("Cinema 1"))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[1].name")).value("Cinema 2"));
    }
}
