package com.wuwei.shopping_cart.cart.model;

import com.wuwei.shopping_cart.product.model.Product;

import java.util.List;

public class Cart {

    private String id;
    private String name;
    private List<Product> products;

    public Cart(String id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Cart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
