package com.andreick.test;

import com.andreick.model.Category;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;

public class ProductRegistrationTest {

    public static void main(String[] args) {

        Category mobilePhones = new Category("MOBILE PHONES");

        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(mobilePhones);

        mobilePhones.setName("XPTO");
        em.flush();

        mobilePhones.setName("1234");
        em.clear();
        mobilePhones = em.merge(mobilePhones);
        em.flush();

        em.remove(mobilePhones);

        em.getTransaction().commit();

        em.close();
    }
}
