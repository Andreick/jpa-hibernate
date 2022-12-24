package com.andreick.vo;

import java.time.LocalDate;

public class SalesReportVo {

    private String productName;
    private long soldAmount;
    private LocalDate lastSaleDate;

    public SalesReportVo(String productName, long soldAmount, LocalDate lastSaleDate) {
        this.productName = productName;
        this.soldAmount = soldAmount;
        this.lastSaleDate = lastSaleDate;
    }

    public String getProductName() {
        return productName;
    }

    public long getSoldAmount() {
        return soldAmount;
    }

    public LocalDate getLastSaleDate() {
        return lastSaleDate;
    }

    @Override
    public String toString() {
        return "SalesReportVo{" +
                "productName='" + productName + '\'' +
                ", soldAmount=" + soldAmount +
                ", lastSaleDate=" + lastSaleDate +
                '}';
    }
}
