package com.doniztjnr.film;

/*
* DTO stands for data transfer object.
* As the name suggests, a DTO is an object made
* to transfer data
* */

public class FilmDTO {

    private Long id;
    private String name;
    private String release;
    private String director;

    public FilmDTO() {}

    public FilmDTO(Long id, String name, String release, String director) {
        this.id = id;
        this.name = name;
        this.release = release;
        this.director = director;
    }

    public FilmDTO(Film film) {
        id = film.getId();
        name = film.getName();
        release = film.getRelease();
        director = film.getDirector();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
