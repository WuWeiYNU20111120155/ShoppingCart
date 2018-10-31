package com.wuwei.shopping_cart.cart.model;

public class UpdateCartReponse {

    private Cart cart;

    public UpdateCartReponse(Cart cart) {
        this.cart = cart;
    }

    public UpdateCartReponse() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
