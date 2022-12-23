package com.andreick.dao;

import com.andreick.model.Order;

import javax.persistence.EntityManager;

public class OrderDao {

    private EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    public void register(Order order) {
        em.persist(order);
    }
}
