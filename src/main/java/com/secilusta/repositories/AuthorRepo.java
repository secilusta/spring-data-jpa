package com.secilusta.repositories;

import com.secilusta.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Integer> {

    Author findByName(String name);

}
