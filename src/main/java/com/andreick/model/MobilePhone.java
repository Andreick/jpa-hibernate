package com.andreick.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class MobilePhone extends Product {

    String brand;
    String model;

    public MobilePhone() {
    }

    public MobilePhone(String name, String description, BigDecimal price, Category category, String brand, String model) {
        super(name, description, price, category);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
