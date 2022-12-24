package com.andreick.dao;

import com.andreick.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Product> findByParameter(String name, BigDecimal price, LocalDate registrationDate) {
        boolean nameIsNotBlank = name != null && !name.trim().isEmpty();
        boolean priceIsNotNull = price != null;
        boolean registrationDateIsNotNull = registrationDate != null;

        String jpql = "SELECT p FROM Product p WHERE 1=1";

        if (nameIsNotBlank) {
            jpql += " AND p.name = :name";
        }
        if (priceIsNotNull) {
            jpql += " AND p.price = :price";
        }
        if (registrationDateIsNotNull) {
            jpql += " AND p.registrationDate = :registrationDate";
        }

        TypedQuery<Product> query = em.createQuery(jpql, Product.class);

        if (nameIsNotBlank) {
            query.setParameter("name", name);
        }
        if (priceIsNotNull) {
            query.setParameter("price", price);
        }
        if (registrationDateIsNotNull) {
            query.setParameter("registrationDate", registrationDate);
        }

        return query.getResultList();
    }

    public List<Product> findByParameterCriteriaApi(String name, BigDecimal price, LocalDate registrationDate) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        Predicate predicate = builder.and();

        if (name != null && !name.trim().isEmpty()) {
            predicate = builder.and(predicate, builder.equal(from.get("name"), name));
        }
        if (price != null) {
            predicate = builder.and(predicate, builder.equal(from.get("price"), price));
        }
        if (registrationDate != null) {
            predicate = builder.and(predicate, builder.equal(from.get("registrationDate"), registrationDate));
        }

        query.where(predicate);

        return em.createQuery(query)
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
