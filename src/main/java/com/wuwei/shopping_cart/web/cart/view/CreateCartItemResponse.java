package com.wuwei.shopping_cart.web.cart.view;

import com.wuwei.shopping_cart.web.cart.model.CartItem;

public class CreateCartItemResponse {

    private CartItem item;

    public CreateCartItemResponse() {
    }

    public CreateCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}
