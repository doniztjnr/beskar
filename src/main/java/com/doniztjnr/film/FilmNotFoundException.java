package com.doniztjnr.film;

public class FilmNotFoundException extends RuntimeException {

    FilmNotFoundException(Long id) {
        super("Could not found film " + id);
    }
}
