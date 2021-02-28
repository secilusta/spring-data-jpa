package com.secilusta;

import com.secilusta.services.BookService;
import com.secilusta.services.OrderService;
import com.secilusta.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.secilusta");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperations();

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        orderService.orderOperations();

        appContext.close();
    }
}
