package com.andreick.test;

import com.andreick.dao.CategoryDao;
import com.andreick.model.Category;
import com.andreick.model.CategoryId;
import com.andreick.util.DatabaseUtil;
import com.andreick.util.JpaUtil;

import javax.persistence.EntityManager;

public class CompositeKeyTest {

    public static void main(String[] args) {

        DatabaseUtil.fillDb();

        EntityManager em = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(em);

        Category category = categoryDao.findById(new CategoryId("BOOKS", "composite"));
        System.out.println(category.getName());
    }
}
