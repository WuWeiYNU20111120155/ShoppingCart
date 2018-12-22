package com.wuwei.shopping_cart.web.order.view;

import com.wuwei.shopping_cart.web.order.model.Order;

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
