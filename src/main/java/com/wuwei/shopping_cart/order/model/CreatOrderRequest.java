package com.wuwei.shopping_cart.order.model;

import com.wuwei.shopping_cart.product.model.Product;

import java.util.List;

public class CreatOrderRequest {

    private List<Product> products;
    private long totalPrice;

    public CreatOrderRequest() {
    }

    public CreatOrderRequest(List<Product> products, long totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
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
