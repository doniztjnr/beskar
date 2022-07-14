package com.doniztjnr.film;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FilmRepository repository) {
        return args -> {
            log.info("Preloading" + repository.save(new Film(
                    "Star Wars: The Phantom Menace (Episode I)",
                    "June 24, 1999",
                    "George Lucas")));
            log.info("Preloading" + repository.save(new Film(
                    "Star Wars: Attack of the Clones (Episode II)",
                    "May 16, 2002",
                    "George Lucas")));
        };
    }
}
