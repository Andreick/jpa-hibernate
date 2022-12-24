package com.andreick.test;

import com.andreick.dao.OrderDao;
import com.andreick.model.Order;
import com.andreick.util.DatabaseUtil;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;

public class PerformanceTest {

    public static void main(String[] args) {

        DatabaseUtil.fillDb();

        EntityManager em = JpaUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(em);

        Order order = orderDao.findByIdWithClient(1L);
        em.close();
        System.out.println(order.getClient().getName());
    }
}
