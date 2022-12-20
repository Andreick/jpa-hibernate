package com.andreick.dao;

import com.andreick.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void register(Product product) {
        em.persist(product);
    }
}
