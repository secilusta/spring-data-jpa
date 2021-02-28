package com.secilusta.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private double total;

    @ManyToMany()
    @JoinTable(
            name = "order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private Set<Book> orderBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public Set<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Set<Book> orderBooks) {
        this.orderBooks = orderBooks;
        this.total = orderBooks.stream().mapToDouble(b -> b.getPrice()).sum();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String orderDateString = created_at != null ? ", created_at=" + formatter.format(created_at) : "";

        return "Orders{" +
                "id=" + id +
                orderDateString +
                ", user=" + user +
                ", total=" + String.format("%.2f", total) +
                ", orderBooks=" + orderBooks +
                '}';
    }
}
