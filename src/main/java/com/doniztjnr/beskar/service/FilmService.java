package com.doniztjnr.beskar.service;

/*
 * Service Components are the class file which contains
 * @Service annotation. These class files are used to
 * write business logic in a different layer, separated
 * from @RestController class file.
 * */

import com.doniztjnr.beskar.dao.FilmDao;
import com.doniztjnr.beskar.model.Film;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmDao filmDao;

    public FilmService(@Qualifier(value = "postgres") FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public int addFilm(Film film) {
        return filmDao.insertFilm(film);
    }

    public List<Film> getFilms() {
        return filmDao.selectFilms();
    }

    public int updateFilm(Film film, Long id) {
        return filmDao.updateFilmById(film, id);
    }

    public int deleteFilm(Long id) {
        return filmDao.deleteFilmById(id);
    }

    public Film getFilm(Long id) {
        return filmDao.selectFilmById(id);
    }
}
