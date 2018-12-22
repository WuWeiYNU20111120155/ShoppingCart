package com.wuwei.shopping_cart.web.cart.view;

import com.wuwei.shopping_cart.web.cart.model.CartItem;

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
