package com.doniztjnr.beskar.model;

/*
 * The Model is the part of MVC which implements the domain logic.
 * In simple terms, this logic is used to handle the data passed
 * between the database and the user interface (UI). The Model is
 * known as domain object or domain entity. The domain objects
 * are stored under the Model folder.
 * */

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String release;
    @NotBlank
    private final String director;

    public Film(@JsonProperty(value = "id") Long id,
                @JsonProperty(value = "name") String name,
                @JsonProperty(value = "release") String release,
                @JsonProperty(value = "director") String director) {
        this.id = id;
        this.name = name;
        this.release = release;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelease() {
        return release;
    }

    public String getDirector() {
        return director;
    }
}
