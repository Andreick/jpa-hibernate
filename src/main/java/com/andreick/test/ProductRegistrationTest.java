package com.andreick.test;

import com.andreick.dao.CategoryDao;
import com.andreick.dao.ProductDao;
import com.andreick.model.Category;
import com.andreick.model.Product;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        Category mobilePhones = new Category("MOBILE PHONES");
        Product phone = new Product("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), mobilePhones);

        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);

        em.getTransaction().begin();
        categoryDao.register(mobilePhones);
        productDao.register(phone);
        em.getTransaction().commit();

        em.close();
    }
}
