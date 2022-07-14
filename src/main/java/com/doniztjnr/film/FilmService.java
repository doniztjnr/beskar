package com.doniztjnr.film;

/*
 * Service Components are the class file which contains
 * @Service annotation. These class files are used to
 * write business logic in a different layer, separated
 * from @RestController class file.
 * */

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository repository;
    private final FilmModelAssembler assembler;

    public FilmService(FilmRepository repository, FilmModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // CREATE
    ResponseEntity<?> insertNewFilm(Film newFilm) {
        EntityModel<Film> entityModel = assembler.toModel(repository.save(newFilm));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    // READ
    CollectionModel<EntityModel<Film>> displayAllFilms() {
        List<Film> entityModelList = repository.findAll();

        return assembler.toCollectionModel(entityModelList);
    }

    // READ BY ID
    EntityModel<Film> displayOneFilmById(Long id) {
        Film film = repository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));

        return assembler.toModel(film);
    }

    // UPDATE BY ID
    ResponseEntity<?> changeOneFilmById(Film newFilm, Long id) {
        Film updateFilm = repository.findById(id)
                .map(film -> {
                    film.setName(newFilm.getName());
                    film.setRelease(newFilm.getRelease());
                    film.setDirector(newFilm.getDirector());
                    return repository.save(film);
                })
                .orElseGet(() -> {
                    newFilm.setId(id);
                    return repository.save(newFilm);
                });

        EntityModel<Film> entityModel = assembler.toModel(updateFilm);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    // DELETE BY ID
    ResponseEntity<?> deleteOneFilmById(Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
