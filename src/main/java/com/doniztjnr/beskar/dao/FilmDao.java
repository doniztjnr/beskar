package com.doniztjnr.beskar.dao;

import com.doniztjnr.beskar.model.Film;

import java.util.List;

public interface FilmDao {

    int insertFilm(Film film);

    List<Film> selectFilms();

    int updateFilmById(Film film, Long id);

    int deleteFilmById(Long id);

    Film selectFilmById(Long id);
}
