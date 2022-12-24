package com.andreick.dao;

import com.andreick.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    private final EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void register(Product product) {
        em.persist(product);
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        String jpql = "SELECT p FROM Product p";
        return em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findByCategoryName(String categoryName) {
        return em.createNamedQuery("Product.findByCategoryName", Product.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
    }

    public BigDecimal getProdutPriceById(Long id) {
        String jpql = "SELECT p.price FROM Product p WHERE p.id = :id";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
