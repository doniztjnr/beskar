package com.doniztjnr.film;

/*
 * The Model is the part of MVC which implements the domain logic.
 * In simple terms, this logic is used to handle the data passed
 * between the database and the user interface (UI). The Model is
 * known as domain object or domain entity. The domain objects
 * are stored under the Model folder.
 * */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class Film {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String release;
    private String director;

    public Film() {}

    public Film(String name, String release, String director) {
        this.name = name;
        this.release = release;
        this.director = director;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return Objects.equals(id, film.id)
                && Objects.equals(name, film.name)
                && Objects.equals(release, film.release)
                && Objects.equals(director, film.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, release, director);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", release='" + release + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
