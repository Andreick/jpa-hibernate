package com.andreick.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    @EmbeddedId
    private CategoryId id;

    public Category() {
    }

    public Category(String name) {
        id = new CategoryId(name, "composite");
    }

    public String getName() {
        return id.getName();
    }
}
