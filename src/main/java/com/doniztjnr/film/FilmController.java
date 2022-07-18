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
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class FilmController {

    private final FilmService service;
    private final FilmModelAssembler assembler;

    public FilmController(FilmService service, FilmModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    // CREATE
    @PostMapping(path = "/films")
    ResponseEntity<?> newtFilm(@RequestBody Film newFilm) {
        EntityModel<Film> entityModel = assembler.toModel(service.insertNewFilm(newFilm));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    // READ
    @GetMapping(path = "/films")
    CollectionModel<EntityModel<Film>> all() {
        return assembler.toCollectionModel(service.displayAllFilms());
    }

    // READ BY ID
    @GetMapping(path = "/films/{id}")
    EntityModel<Film> one(@PathVariable Long id) {
        return assembler.toModel(service.displayOneFilmById(id));
    }

    // UPDATE BY ID
    @PutMapping(path = "/films/{id}")
    ResponseEntity<?> replaceFilm(@RequestBody Film newFilm, @PathVariable Long id) {
        EntityModel<Film> entityModel = assembler.toModel(service.changeOneFilmById(newFilm, id));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    // DELETE BY ID
    @DeleteMapping(path = "/films/{id}")
    ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        service.deleteOneFilmById(id);

        return ResponseEntity.noContent().build();
    }
}
