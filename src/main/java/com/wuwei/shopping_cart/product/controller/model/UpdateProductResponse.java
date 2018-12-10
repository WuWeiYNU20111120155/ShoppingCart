package com.wuwei.shopping_cart.product.controller.model;

import com.wuwei.shopping_cart.product.model.Product;

public class UpdateProductResponse {

    private Product product;

    public UpdateProductResponse() {
    }

    public UpdateProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}