package com.secilusta.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class Book {

    @Id
    private String isbn;

    private String name;

    private String description;

    private LocalDateTime publishedDate;

    @CreationTimestamp
    private LocalDateTime addedDate;

    private double price;

    private String currency;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "authorBooks", fetch = FetchType.EAGER)
    private Set<Author> authors;

    @ManyToMany(mappedBy = "orderBooks", fetch = FetchType.LAZY)
    private Set<Orders> orders;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String publishedDateString = publishedDate != null ? ", publishedDate=" + formatter.format(publishedDate) : "";
        String addedDateString = addedDate != null ? ", addedDate=" + formatter.format(addedDate) : "";

        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                publishedDateString +
                addedDateString +
                ", price=" + price + currency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                ", authors=" + authors +
                '}';
    }

}
