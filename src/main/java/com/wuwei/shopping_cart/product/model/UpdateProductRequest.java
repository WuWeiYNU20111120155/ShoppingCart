package com.wuwei.shopping_cart.product.model;

public class UpdateProductRequest {

    private String name;
    private String description;
    private long price;

    public UpdateProductRequest() {
    }

    public UpdateProductRequest(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
