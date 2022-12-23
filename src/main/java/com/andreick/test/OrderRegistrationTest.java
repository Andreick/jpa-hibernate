package com.andreick.test;

import com.andreick.dao.ClientDao;
import com.andreick.dao.OrderDao;
import com.andreick.dao.ProductDao;
import com.andreick.model.Client;
import com.andreick.model.Order;
import com.andreick.model.OrderItem;
import com.andreick.model.Product;
import com.andreick.util.DatabaseUtil;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;

public class OrderRegistrationTest {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        DatabaseUtil.fillDb(em);

        ProductDao productDao = new ProductDao(em);
        ClientDao clientDao = new ClientDao(em);
        OrderDao orderDao = new OrderDao(em);

        Product product = productDao.findById(1L);
        Client client = clientDao.findById(1L);

        Order order = new Order(client);
        order.addItem(new OrderItem(product, 2));

        em.getTransaction().begin();

        orderDao.register(order);

        em.getTransaction().commit();
    }
}
