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

        DatabaseUtil.fillDb();

        EntityManager em = JpaUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(em);

        BigDecimal totalSold = orderDao.getTotalSold();
        System.out.println("total order sold = " + totalSold);

        List<SalesReportVo> salesReport = orderDao.getSalesReport();
        salesReport.forEach(System.out::println);
    }
}
