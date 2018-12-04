package com.wuwei.shopping_cart.product.controller.model;

import com.wuwei.shopping_cart.product.model.Product;

public class GetProductResponse {

    private Product product;

    public GetProductResponse() {
    }

    public GetProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
