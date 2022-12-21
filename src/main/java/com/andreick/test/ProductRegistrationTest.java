package com.andreick.test;

import com.andreick.dao.CategoryDao;
import com.andreick.dao.ProductDao;
import com.andreick.model.Category;
import com.andreick.model.Product;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);

        registerCategoriesAndProdutcs(em, categoryDao, productDao);

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

    private static void registerCategoriesAndProdutcs(EntityManager em, CategoryDao categoryDao, ProductDao productDao) {
        List<Category> categories = Arrays.asList(
                new Category("MOBILE PHONES"),
                new Category("COMPUTING"),
                new Category("BOOKS"));

        List<Product> products = Arrays.asList(
                new Product("Xiaomi Redmi", "Xiaomi", new BigDecimal("1300"), categories.get(0)),
                new Product("iPhone 11", "Apple", new BigDecimal("3700"), categories.get(0)),
                new Product("Fairy Tale", "Sthepen King", new BigDecimal("16"), categories.get(2)));

        em.getTransaction().begin();

        categories.forEach(categoryDao::register);
        products.forEach(productDao::register);

        em.getTransaction().commit();
    }
}
