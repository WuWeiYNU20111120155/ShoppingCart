package com.wuwei.shopping_cart.order.model;

public class UpdateOrderResponse {
    private Order order;

    public UpdateOrderResponse(Order order) {
        this.order = order;
    }

    public UpdateOrderResponse() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
