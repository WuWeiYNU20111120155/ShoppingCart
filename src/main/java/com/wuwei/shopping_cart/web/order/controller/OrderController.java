package com.wuwei.shopping_cart.web.order.controller;


import com.wuwei.shopping_cart.web.order.view.*;
import com.wuwei.shopping_cart.web.product.model.Product;
import com.wuwei.shopping_cart.web.product.model.ProductDao;
import com.wuwei.shopping_cart.web.user.model.User;
import com.wuwei.shopping_cart.web.user.model.UserDao;
import com.wuwei.shopping_cart.web.order.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {

    private UserDao userDao;
    private ProductDao productDao;
    private OrderDao orderDao;

    public OrderController(UserDao userDao, ProductDao productDao, OrderDao orderDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    /**
     * List orders
     */
    @GetMapping("/orders")
    public ResponseEntity<ListOrderResponse> listOrders() {
        //System.out.println(orderDao.findById(1));
        List<Order> orders = orderDao.findAll();
        return new ResponseEntity<>(new ListOrderResponse(orders), HttpStatus.OK);
    }

    /**
     * Get order
     */
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable int orderId) {
        Order order = orderDao.findById(orderId);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new GetOrderResponse(order), HttpStatus.OK);
    }

    /**
     * Create order
     * @param createOrderRequest
     * @return
     */
    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {

        User user = userDao.findById(createOrderRequest.getUserId());
        Product product = productDao.findById(createOrderRequest.getProductId());
        Order order = new Order(user, product, createOrderRequest.getQuantity(),
                createOrderRequest.getStatus(), createOrderRequest.getAddress());
        order = orderDao.save(order);

        return new ResponseEntity<>(new CreateOrderResponse(order), HttpStatus.CREATED);
    }

    /**
     * Update order
     * @param orderId
     * @param updateOrderRequest
     * @return
     */
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<UpdateOrderResponse> updateOrder(@PathVariable int orderId, @RequestBody UpdateOrderRequest updateOrderRequest) {
        Order order = orderDao.findById(orderId);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        order.setQuantity(updateOrderRequest.getQuantity());
        order.setAddress(updateOrderRequest.getAddress());
        order.setStatus(updateOrderRequest.getStatus());
        order=orderDao.save(order);
        return new ResponseEntity<>(new UpdateOrderResponse(order), HttpStatus.OK);
    }

    /**
     * Cacel order
     */
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity cancelOrder(@PathVariable int orderId) {
        Order order = orderDao.findById(orderId);

        if (order == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderDao.delete(order);
        return new ResponseEntity(HttpStatus.OK);
    }
}