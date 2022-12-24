package com.andreick.dao;

import com.andreick.model.Category;
import com.andreick.model.CategoryId;

import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category) {
        em.persist(category);
    }

    public void update(Category category) {
        em.merge(category);
    }

    public void delete(Category category) {
        category = em.merge(category);
        em.remove(category);
    }

    public Category findById(CategoryId id) {
        return em.find(Category.class, id);
    }
}
