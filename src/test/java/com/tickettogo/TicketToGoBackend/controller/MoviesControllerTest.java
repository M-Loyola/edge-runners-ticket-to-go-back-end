package com.tickettogo.TicketToGoBackend.controller;

import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.repository.MoviesRepository;
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
class MoviesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MoviesRepository moviesRepository;

    @BeforeEach
    void clearAll() {
        moviesRepository.deleteAll();
    }

    @Test
    void should_show_all_movies_when_perform_get_given_movies() throws Exception {
        //given
        Movie movie1 = new Movie("John Wick 7", 120);
        Movie movie2 = new Movie("Spider-Man: Across the Spider-Verse", 240);
        moviesRepository.save(movie1);
        moviesRepository.save(movie2);
        //when and then
        mockMvc.perform(get("/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[0].title")).value("John Wick 7"))
                .andExpect(MockMvcResultMatchers.jsonPath(("$[1].title")).value("Spider-Man: Across the Spider-Verse"));
    }
    @Test
    void should_show_all_movies_when_perform_get_given_movie_id() throws Exception {
        //given
        Movie movie1 = new Movie("John Wick 7", 120);
        Movie movie2 = new Movie("Spider-Man: Across the Spider-Verse", 240);
        moviesRepository.save(movie1);
        moviesRepository.save(movie2);
        //when and then
        mockMvc.perform(get("/movies/{id}",movie1.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.title")).value("John Wick 7"))
                .andExpect(MockMvcResultMatchers.jsonPath(("$.duration")).value(120));
    }
}