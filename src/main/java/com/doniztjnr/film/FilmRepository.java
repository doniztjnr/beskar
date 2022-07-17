package com.doniztjnr.film;

/*
 * A repository is a mechanism for encapsulating storage, retrieval,
 * and search behavior which emulates a collection of objects.
 * */

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findByName(String name);
}
