package com.secilusta.services;

import com.secilusta.entities.Book;
import com.secilusta.entities.Orders;
import com.secilusta.entities.User;
import com.secilusta.repositories.OrderRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class OrderService {

    private final OrderRepo orderRepo;
    private final UserService userService;
    private final BookService bookService;

    public OrderService(OrderRepo orderRepo,
                        UserService userService,
                        BookService bookService) {
        this.orderRepo = orderRepo;
        this.userService = userService;
        this.bookService = bookService;
    }

    public void orderOperations() {
        User user = userService.findUserByName("seciluser");
        Orders ord = new Orders();
        ord.setUser(user);
        Set<Book> books = new HashSet<>(bookService.findBooksByCategory("Computer Science"));
        ord.setOrderBooks(books);
        orderRepo.save(ord);
        System.out.println(ord);

        Orders ord2 = new Orders();
        ord2.setUser(user);
        Set<Book> books2 = Collections.singleton(bookService.findByName("Poirot's Early Cases"));
        ord2.setOrderBooks(books2);
        orderRepo.save(ord2);
        System.out.println(ord2);

        Orders ord3 = new Orders();
        ord3.setUser(user);
        Set<Book> books3 = new HashSet<>(bookService.findBooksByAuthor("Andrew Ng"));
        ord3.setOrderBooks(books3);
        orderRepo.save(ord3);
        System.out.println(ord3);

    }
}
