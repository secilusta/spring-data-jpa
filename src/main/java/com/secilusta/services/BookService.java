package com.secilusta.services;

import com.secilusta.entities.Author;
import com.secilusta.entities.Book;
import com.secilusta.entities.Category;
import com.secilusta.repositories.AuthorRepo;
import com.secilusta.repositories.BookRepo;
import com.secilusta.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class BookService {

    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;
    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo,
                       CategoryRepo categoryRepo,
                       AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
        this.authorRepo = authorRepo;
    }

    public List<Book> findBooksByCategory(String categoryName){
        Category category = categoryRepo.findByName(categoryName);
        return bookRepo.findByCategory(category);
    }

    public Book findByName(String name){
        return bookRepo.findByName(name);
    }

    public List<Book> findBooksByAuthor(String authorName){
        Author author = authorRepo.findByName(authorName);
        return bookRepo.findByAuthors(author);
    }

    public void bookOperations() {

        Category c1 = new Category();
        c1.setName("Computer Science");

        Author a1 = new Author();
        a1.setName("Thomas Cormen");

        Author a3 = new Author();
        a3.setName("Andrew Ng");

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setCurrency("TL");
        b1.setPrice(49.99);
        b1.setCategory(c1);

        Book b3 = new Book();
        b3.setIsbn(UUID.randomUUID().toString());
        b3.setName("Machine Learning");
        b3.setCurrency("TL");
        b3.setPrice(124.10);
        b3.setCategory(c1);

        a1.setAuthorBooks(Collections.singleton(b1));
        b1.setAuthors(Collections.singleton(a1));

        a3.setAuthorBooks(Collections.singleton(b3));
        b3.setAuthors(Collections.singleton(a3));

        categoryRepo.save(c1);
        authorRepo.save(a1);
        System.out.println(a1);
        System.out.println(b1);

        authorRepo.save(a3);
        System.out.println(a3);
        System.out.println(b3);

        Author a2 = new Author();
        a2.setName("Agatha Christie");

        Category c2 = new Category();
        c2.setName("Detective");
        //c2.setBooks(Collections.singletonList(b2));

        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Poirot's Early Cases");
        b2.setCurrency("TL");
        b2.setPrice(11.0);
        b2.setPublishedDate(LocalDateTime.of(2008,9,12,14,30,00));
        b2.setCategory(c2);

        a2.setAuthorBooks(Collections.singleton(b2));
        b2.setAuthors(Collections.singleton(a2));

        categoryRepo.save(c2);
        authorRepo.save(a2);
        System.out.println(a2);
        System.out.println(b2);
        System.out.println(c2);
    }
}
