package com.wuwei.shopping_cart.order.model;

import com.wuwei.shopping_cart.product.model.Product;

import java.util.List;

public class Order {

    private String orderNo;
    private List<Product> products;
    private long totalPrice;

    public Order(String orderNo, List<Product> products, long totalPrice) {
        this.orderNo = orderNo;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
