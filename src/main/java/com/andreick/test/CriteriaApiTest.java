package com.andreick.test;

import com.andreick.dao.ProductDao;
import com.andreick.model.Product;
import com.andreick.util.DatabaseUtil;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CriteriaApiTest {

    public static void main(String[] args) {

        DatabaseUtil.fillDb();

        EntityManager em = JpaUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);

        List<Product> productsByPrice = productDao.findByParameter(null, new BigDecimal("1300"), null);
        productsByPrice.forEach(product -> System.out.println(product.getName()));

        List<Product> productsByDate = productDao.findByParameterCriteriaApi(null, null, LocalDate.now());
        productsByDate.forEach(product -> System.out.println(product.getName()));
    }
}
