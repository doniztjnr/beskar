package com.doniztjnr.film;

/*
 * A controller is responsible for controlling the way that a user
 * interacts with an MVC application. A controller contains the flow
 * control logic for an MVC application. A controller determines
 * what response to send back to a user when a user makes a browser
 * request.
 * */

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping(path = "/films")
    ResponseEntity<?> newtFilm(@RequestBody Film newFilm) {
        return service.insertNewFilm(newFilm);
    }

    // READ
    @GetMapping(path = "/films")
    CollectionModel<EntityModel<Film>> all() {
        return service.displayAllFilms();
    }

    // READ BY ID
    @GetMapping(path = "/films/{id}")
    EntityModel<Film> one(@PathVariable Long id) {
        return service.displayOneFilmById(id);
    }

    // UPDATE BY ID
    @PutMapping(path = "/films/{id}")
    ResponseEntity<?> replaceFilm(@RequestBody Film newFilm, @PathVariable Long id) {
        return service.changeOneFilmById(newFilm, id);
    }

    // DELETE BY ID
    @DeleteMapping(path = "/films/{id}")
    ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        return service.deleteOneFilmById(id);
    }
}
