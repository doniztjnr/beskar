package com.doniztjnr;

import com.doniztjnr.film.FilmController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeskarApplicationTests {

    @Autowired
    private FilmController controller;

    @Test
    public void itShouldVerifyIfControllerHaveContent() throws Exception {
        assertThat(controller).isNotNull();
    }
}
