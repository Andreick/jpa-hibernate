package com.andreick.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Book extends Product {

    private String author;
    private Integer numberOfPages;

    public Book() {
    }

    public Book(String name, String description, BigDecimal price, Category category, String author, Integer numberOfPages) {
        super(name, description, price, category);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }
}
