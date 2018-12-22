package com.wuwei.shopping_cart.web.order.view;

import com.wuwei.shopping_cart.web.order.model.Order;

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
