package com.andreick.test;

import com.andreick.dao.ProductDao;
import com.andreick.model.Product;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        Product phone = new Product();
        phone.setName("Xiaomi Redmi");
        phone.setDescription("Muito legal");
        phone.setPrice(new BigDecimal("800"));

        EntityManager em = JpaUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);

        em.getTransaction().begin();
        dao.register(phone);
        em.getTransaction().commit();

        em.close();
    }
}
