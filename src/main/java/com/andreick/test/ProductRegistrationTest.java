package com.andreick.test;

import com.andreick.dao.ProductDao;
import com.andreick.model.Product;
import com.andreick.util.DatabaseUtil;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        DatabaseUtil.fillDb();

        EntityManager em = JpaUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);

        Product productId1 = productDao.findById(1L);
        System.out.println(productId1);

        List<Product> allProducts = productDao.findAll();
        allProducts.forEach(System.out::println);

        List<Product> productsByName = productDao.findByName("Fairy Tale");
        productsByName.forEach(System.out::println);

        List<Product> productsByCategoryName = productDao.findByCategoryName("MOBILE PHONES");
        productsByCategoryName.forEach(System.out::println);

        BigDecimal productPrice = productDao.getProdutPriceById(2L);
        System.out.println("Product price = " + productPrice);

        em.close();
    }
}
