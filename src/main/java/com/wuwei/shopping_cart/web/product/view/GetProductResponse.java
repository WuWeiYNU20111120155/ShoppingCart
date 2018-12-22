package com.wuwei.shopping_cart.web.product.view;

import com.wuwei.shopping_cart.web.product.model.Product;

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
