package com.wuwei.shopping_cart.cart.model;

import java.util.List;

public class ListCartItemResponse {

    private List<CartItem> items;

    public ListCartItemResponse() {
    }

    public ListCartItemResponse(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getCarts() {
        return items;
    }

    public void setCarts(List<CartItem> items) {
        this.items = items;
    }
}
