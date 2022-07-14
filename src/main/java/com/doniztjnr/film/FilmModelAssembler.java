package com.doniztjnr.film;

/*
 * HATEOAS acronyms for Hypermedia as the Engine of Application State.
 * The term hypermedia refers to content that contains a link to other
 * forms of media like images, movies, and text. It is a component of
 * the REST application that distinguishes it from other network
 * architecture.
 * */

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FilmModelAssembler implements RepresentationModelAssembler<Film, EntityModel<Film>> {

    @Override
    public EntityModel<Film> toModel(Film film) {
        return EntityModel.of(film,
                linkTo(methodOn(FilmController.class)
                        .one(film.getId()))
                        .withSelfRel(),

                linkTo(methodOn(FilmController.class)
                        .all())
                        .withRel("films"));
    }

    @Override
    public CollectionModel<EntityModel<Film>> toCollectionModel(Iterable<? extends Film> entities) {
        CollectionModel<EntityModel<Film>> collectionModel =  RepresentationModelAssembler
                .super
                .toCollectionModel(entities);

        return collectionModel
                .add(linkTo(methodOn(FilmController.class)
                        .all())
                        .withSelfRel());
    }
}
