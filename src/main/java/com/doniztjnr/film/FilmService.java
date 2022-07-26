package com.doniztjnr.film;

/*
 * Service Components are the class file which contains
 * @Service annotation. These class files are used to
 * write business logic in a different layer, separated
 * from @RestController class file.
 * */

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    FilmDTO insertNewFilm(Film newFilm) {
        Film film = repository.save(newFilm);
        return new FilmDTO(film);
    }

    List<FilmDTO> displayAllFilms() {
        List<Film> films = repository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return films.stream()
                .map(film -> modelMapper.map(film, FilmDTO.class))
                .toList();
    }

    FilmDTO displayOneFilmById(Long id) {
        Film film = repository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
        return new FilmDTO(film);
    }

    FilmDTO changeOneFilmById(Film newFilm, Long id) {
        Film filmUp = repository.findById(id)
                .map(film -> {
                    film.setName(newFilm.getName());
                    film.setRelease(newFilm.getRelease());
                    film.setDirector(newFilm.getDirector());
                    return repository.save(film);
                }).orElseGet(() -> {
                    newFilm.setId(id);
                    return repository.save(newFilm);
                });
        return new FilmDTO(filmUp);
    }

    void deleteOneFilmById(Long id) {
        repository.deleteById(id);
    }
}
