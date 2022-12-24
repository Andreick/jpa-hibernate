package com.andreick.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CategoryId implements Serializable {

    private String name;
    private String type;

    public CategoryId() {
    }

    public CategoryId(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
