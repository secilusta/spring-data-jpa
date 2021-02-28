package com.secilusta.repositories;

import com.secilusta.entities.Author;
import com.secilusta.entities.Book;
import com.secilusta.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, String> {

    Book findByName(String name);

    List<Book> findByCategory(Category category);

    List<Book> findByAuthors(Author author);

}
