package com.wuwei.shopping_cart.order.model;

import java.util.List;

public class ListOrderResponse {

    private List<Order> orders;

    public ListOrderResponse() {
    }

    public ListOrderResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
