package com.wuwei.shopping_cart.web.order.view;

public class UpdateOrderRequest {

    private int quantity;
    private String status;
    private String address;

    public UpdateOrderRequest(){}

    public UpdateOrderRequest(int quantity, String status, String address) {
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
