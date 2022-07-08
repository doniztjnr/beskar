package com.doniztjnr.beskar.controller;

/*
 * A controller is responsible for controlling the way that a user
 * interacts with an MVC application. A controller contains the flow
 * control logic for an MVC application. A controller determines
 * what response to send back to a user when a user makes a browser
 * request.
 * */

import com.doniztjnr.beskar.model.Film;
import com.doniztjnr.beskar.service.FilmService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // CREATE
    @PostMapping
    public void addFilm(@Valid @NonNull @RequestBody Film film) {
        filmService.addFilm(film);
    }

    // READ
    @GetMapping
    public List<Film> getFilms() {
        return filmService.getFilms();
    }

    // UPDATE
    @PutMapping(path = "{id}")
    public void updateFilm(@Valid @NonNull @RequestBody Film film, @PathVariable(value = "id") Long id) {
        filmService.updateFilm(film, id);
    }

    // DELETE
    @DeleteMapping(path = "{id}")
    public void deleteFilm(@PathVariable(value = "id") Long id) {
        filmService.deleteFilm(id);
    }

    // READ BY ID
    @GetMapping(path = "{id}")
    public Film getFilm(@PathVariable(value = "id") Long id) {
        return filmService.getFilm(id);
    }
}
