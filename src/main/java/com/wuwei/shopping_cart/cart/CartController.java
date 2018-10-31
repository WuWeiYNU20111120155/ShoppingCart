package com.wuwei.shopping_cart.cart;

import com.sun.org.apache.regexp.internal.RE;
import com.wuwei.shopping_cart.cart.model.GetCartResponse;
import com.wuwei.shopping_cart.cart.model.ListCartResponse;
import com.wuwei.shopping_cart.cart.model.UpdateCartReponse;
import com.wuwei.shopping_cart.cart.model.UpdateCartRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CartController {

    @PostMapping("/carts")
    public ResponseEntity<UpdateCartReponse> createCart(@RequestBody UpdateCartRequest updateCartRequest){
        //实现
        return new ResponseEntity<>(new UpdateCartReponse(), HttpStatus.CREATED);
    }

    @PutMapping("/carts/{cartId}")
    public ResponseEntity<UpdateCartReponse> updateCart(@PathVariable String cartId, @RequestBody UpdateCartRequest updateCartRequest){
        //实现
        return new ResponseEntity<>(new UpdateCartReponse(), HttpStatus.OK);
    }

    @DeleteMapping("carts/{cartId}")
    public void deleteCart(@PathVariable String cartId)
    {
        //代码实现
    }

    @GetMapping("/carts/{cartId}")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable String cartId){
        //实现
        return new ResponseEntity<>(new GetCartResponse(), HttpStatus.OK);
    }

    @GetMapping("/carts")
    public ResponseEntity<ListCartResponse> listCarts(){
        //实现
        return new ResponseEntity<>(new ListCartResponse (), HttpStatus.OK);
    }

}
