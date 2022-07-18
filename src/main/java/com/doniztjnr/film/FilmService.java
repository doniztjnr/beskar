package com.doniztjnr.film;

/*
 * Service Components are the class file which contains
 * @Service annotation. These class files are used to
 * write business logic in a different layer, separated
 * from @RestController class file.
 * */

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    Film insertNewFilm(Film newFilm) {
        return repository.save(newFilm);
    }

    List<Film> displayAllFilms() {
        return repository.findAll();
    }

    Film displayOneFilmById(Long id) {
        return repository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    Film changeOneFilmById(Film newFilm, Long id) {
        return repository.findById(id).map(film -> {
            film.setName(newFilm.getName());
            film.setRelease(newFilm.getRelease());
            film.setDirector(newFilm.getDirector());
            return repository.save(film);
        }).orElseGet(() -> {
            newFilm.setId(id);
            return repository.save(newFilm);
        });
    }

    void deleteOneFilmById(Long id) {
        repository.deleteById(id);
    }
}
