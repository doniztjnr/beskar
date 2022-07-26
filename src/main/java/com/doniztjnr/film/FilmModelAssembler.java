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
public class FilmModelAssembler implements RepresentationModelAssembler<FilmDTO, EntityModel<FilmDTO>> {

    @Override
    public EntityModel<FilmDTO> toModel(FilmDTO filmDTO) {
        return EntityModel.of(filmDTO,
                linkTo(methodOn(FilmController.class).one(filmDTO.getId())).withSelfRel(),
                linkTo(methodOn(FilmController.class).all()).withRel("films"));
    }

    @Override
    public CollectionModel<EntityModel<FilmDTO>> toCollectionModel(Iterable<? extends FilmDTO> entities) {
        CollectionModel<EntityModel<FilmDTO>> collectionModel =  RepresentationModelAssembler
                .super.toCollectionModel(entities);

        return collectionModel
                .add(linkTo(methodOn(FilmController.class).all()).withSelfRel());
    }
}
