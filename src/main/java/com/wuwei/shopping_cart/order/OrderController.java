package com.wuwei.shopping_cart.order;

import com.wuwei.shopping_cart.order.model.CreateOrderResponse;
import com.wuwei.shopping_cart.order.model.GetOrderResponse;
import com.wuwei.shopping_cart.order.model.ListOrderResponse;
import com.wuwei.shopping_cart.product.model.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class OrderController {

    @GetMapping("/orders")
    public ResponseEntity<ListOrderResponse>listOrders(){
        //实现

        return new ResponseEntity<>(new ListOrderResponse(), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseEntity<GetOrderResponse>getOrder(@PathVariable String orderNo){
        //实现
        return new ResponseEntity<>(new GetOrderResponse(),HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse>getOrder(@RequestBody CreateProductRequest createProductRequest){
        //实现
        return new ResponseEntity<>(new CreateOrderResponse(),HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{orderNo}")
    public void deleteOrder(@PathVariable String orderNo){
        //实现
    }
}
