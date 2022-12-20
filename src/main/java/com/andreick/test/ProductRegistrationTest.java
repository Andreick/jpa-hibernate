package com.andreick.test;

import com.andreick.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        Product phone = new Product();
        phone.setName("Xiaomi Redmi");
        phone.setDescription("Muito legal");
        phone.setPrice(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        em.persist(phone);

        em.getTransaction().commit();

        em.close();
    }
}
