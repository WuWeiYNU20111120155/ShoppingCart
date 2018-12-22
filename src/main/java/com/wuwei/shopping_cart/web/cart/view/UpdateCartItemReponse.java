package com.wuwei.shopping_cart.web.cart.view;

import com.wuwei.shopping_cart.web.cart.model.CartItem;

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
