package com.andreick.test;

import com.andreick.dao.ProductDao;
import com.andreick.model.Category;
import com.andreick.model.Product;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        Product phone = new Product("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), Category.MOBILE_PHONES);

        EntityManager em = JpaUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);

        em.getTransaction().begin();
        dao.register(phone);
        em.getTransaction().commit();

        em.close();
    }
}
