package com.wuwei.shopping_cart.cart.model;

public class UpdateCartItemReponse {

    private CartItem item;

    public UpdateCartItemReponse(CartItem item) {
        this.item = item;
    }

    public UpdateCartItemReponse() {
    }

    public CartItem getCart() {
        return item;
    }

    public void setCart(CartItem item) {
        this.item = item;
    }
}
