package com.andreick.dao;

import com.andreick.model.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category) {
        em.persist(category);
    }
}
