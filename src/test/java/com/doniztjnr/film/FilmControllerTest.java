package com.doniztjnr.film;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void itShouldVerifyIfControllerPostMethodReturn_201() throws Exception {
        Film starWarOne = new Film("Star Wars: The Phantom Menace (Episode I)",
                "June 24, 1999",
                "George Lucas");

        this.mockMvc.perform(post("/api/films")
                .contentType("application/hal+json")
                        .content(objectMapper.writeValueAsString(starWarOne)))
                .andExpect(status().isCreated());
    }

    @Test
    void itShouldVerifyIfControllerGetMethodReturn_200() throws Exception {
        this.mockMvc.perform(get("/api/films")
                        .contentType("application/hal+json"))
                .andExpect(status().isOk());
    }
}