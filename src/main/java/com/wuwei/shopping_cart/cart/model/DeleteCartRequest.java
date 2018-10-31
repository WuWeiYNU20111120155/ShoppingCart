package com.wuwei.shopping_cart.cart.model;

public class DeleteCartRequest {

    private  String cartId;

    public DeleteCartRequest() {
    }

    public DeleteCartRequest(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
