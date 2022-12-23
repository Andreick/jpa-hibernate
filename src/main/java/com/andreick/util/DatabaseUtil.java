package com.andreick.util;

import com.andreick.dao.CategoryDao;
import com.andreick.dao.ClientDao;
import com.andreick.dao.ProductDao;
import com.andreick.model.Category;
import com.andreick.model.Client;
import com.andreick.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DatabaseUtil {

    public static void fillDb(EntityManager em) {
        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);
        ClientDao clientDao = new ClientDao(em);

        List<Category> categories = Arrays.asList(
                new Category("MOBILE PHONES"),
                new Category("COMPUTING"),
                new Category("BOOKS")
        );

        List<Product> products = Arrays.asList(
                new Product("Xiaomi Redmi", "Xiaomi", new BigDecimal("1300"), categories.get(0)),
                new Product("iPhone 11", "Apple", new BigDecimal("3700"), categories.get(0)),
                new Product("Fairy Tale", "Sthepen King", new BigDecimal("16"), categories.get(2))
        );

        List<Client> clients = Arrays.asList(
                new Client("Someone", "1234")
        );

        em.getTransaction().begin();

        categories.forEach(categoryDao::register);
        products.forEach(productDao::register);
        clients.forEach(clientDao::register);

        em.getTransaction().commit();
    }
}
