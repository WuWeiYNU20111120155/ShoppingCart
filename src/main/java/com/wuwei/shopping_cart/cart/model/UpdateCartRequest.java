package com.wuwei.shopping_cart.cart.model;

public class UpdateCartRequest {

    private String name;
    private String[] productIds;

    public UpdateCartRequest() {
    }

    public UpdateCartRequest(String name, String[] productIds) {
        this.name = name;
        this.productIds = productIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }
}
