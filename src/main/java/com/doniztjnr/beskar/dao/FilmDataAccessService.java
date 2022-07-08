package com.doniztjnr.beskar.dao;

/*
 * DAO stands for data access object. Usually, the DAO class
 * is responsible for two concepts. Encapsulating the details
 * of the persistence layer and provide a CRUD interface for
 * a single entity.
 * */

import com.doniztjnr.beskar.model.Film;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "postgres")
public class FilmDataAccessService implements FilmDao {

    private final JdbcTemplate jdbcTemplate;

    public FilmDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertFilm(Film film) {
        final String SQL = "INSERT INTO film (name, release, director) VALUES (?, ?, ?)";
        return jdbcTemplate.update(SQL, film.getName(), film.getRelease(), film.getDirector());
    }

    @Override
    public List<Film> selectFilms() {
        final String SQL = "SELECT id, name, release, director FROM film";
        return jdbcTemplate.query(SQL, (resultSet, rs) -> {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String release = resultSet.getString("release");
            String director = resultSet.getString("director");
            return new Film(id, name, release, director);
        });
    }

    @Override
    public int updateFilmById(Film film, Long id) {
        final String SQL = "UPDATE film SET name = ?, release = ?, director = ? WHERE id = ?";
        return jdbcTemplate.update(SQL, film.getName(), film.getRelease(), film.getDirector(), id);
    }

    @Override
    public int deleteFilmById(Long id) {
        final String SQL = "DELETE FROM film WHERE id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Film selectFilmById(Long id) {
        final String SQL = "SELECT id, name, release, director FROM film WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, (resultSet, rs) -> {
            Long filmId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String release = resultSet.getString("release");
            String director = resultSet.getString("director");
            return new Film(filmId, name, release, director);
        });
    }
}
