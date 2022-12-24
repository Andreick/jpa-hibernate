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
import com.andreick.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderRegistrationTest {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        DatabaseUtil.fillDb(em);

        ProductDao productDao = new ProductDao(em);
        ClientDao clientDao = new ClientDao(em);
        OrderDao orderDao = new OrderDao(em);

        Product product1 = productDao.findById(1L);
        Product product2 = productDao.findById(2L);
        Product product3 = productDao.findById(3L);
        Client client = clientDao.findById(1L);

        Order order1 = new Order(client);
        order1.addItem(new OrderItem(product1, 10));
        order1.addItem(new OrderItem(product2, 5));
        Order order2 = new Order(client);
        order2.addItem(new OrderItem(product3, 40));
        order2.addItem(new OrderItem(product1, 5));

        em.getTransaction().begin();

        orderDao.register(order1);
        orderDao.register(order2);

        em.getTransaction().commit();

        BigDecimal totalSold = orderDao.getTotalSold();
        System.out.println("total order sold = " + totalSold);

        List<SalesReportVo> salesReport = orderDao.getSalesReport();
        salesReport.forEach(System.out::println);
    }
}
