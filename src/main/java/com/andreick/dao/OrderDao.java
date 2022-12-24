package com.andreick.dao;

import com.andreick.model.Order;
import com.andreick.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDao {

    private EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    public void register(Order order) {
        em.persist(order);
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public Order findByIdWithClient(Long id) {
        String jpql = "SELECT o FROM Order o JOIN FETCH o.client WHERE o.id = :id";
        return em.createQuery(jpql, Order.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public BigDecimal getTotalSold() {
        String jpql = "SELECT SUM(o.totalPrice) FROM Order o";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<SalesReportVo> getSalesReport() {
        String jpql = "SELECT new " + SalesReportVo.class.getName() +
                "(product.name, SUM(item.quantity), MAX(ord.date)) " +
                "FROM Order ord " +
                "JOIN ord.items item " +
                "JOIN item.product product " +
                "GROUP BY product.name " +
                "ORDER BY SUM(item.quantity) DESC";
        return em.createQuery(jpql, SalesReportVo.class)
                .getResultList();
    }
}
