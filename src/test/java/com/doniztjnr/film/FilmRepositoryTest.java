package com.doniztjnr.film;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class FilmRepositoryTest {

    @Autowired
    private FilmRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void itTryFindOneFilmByName() throws Exception {
        // given
        Film starWarFilm = new Film("Star Wars: The Phantom Menace (Episode I)",
                "June 24, 1999",
                "George Lucas");

        this.entityManager.persist(starWarFilm);
        this.entityManager.flush();

        // when
        Film found = repository.findByName(starWarFilm.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(starWarFilm.getName());
    }
}