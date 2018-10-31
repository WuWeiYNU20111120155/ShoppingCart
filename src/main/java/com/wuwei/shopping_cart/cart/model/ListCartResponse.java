package com.wuwei.shopping_cart.cart.model;

import java.util.List;

public class ListCartResponse {

    private List<Cart> carts;

    public ListCartResponse() {
    }

    public ListCartResponse(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
