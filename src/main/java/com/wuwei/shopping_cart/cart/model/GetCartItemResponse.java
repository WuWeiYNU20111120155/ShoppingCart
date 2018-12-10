package com.wuwei.shopping_cart.cart.model;


public class GetCartItemResponse {

    private CartItem item;

    public GetCartItemResponse(CartItem item) {
        this.item = item;
    }

    public GetCartItemResponse() {
    }

    public CartItem getCart() {
        return item;
    }

    public void setCart(CartItem item) {
        this.item = item;
    }
}
