package com.wuwei.shopping_cart.cart;

import com.wuwei.shopping_cart.cart.model.*;
import com.wuwei.shopping_cart.product.model.Product;
import com.wuwei.shopping_cart.product.model.ProductDao;
import com.wuwei.shopping_cart.user.model.User;
import com.wuwei.shopping_cart.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private ProductDao productDao;
    private UserDao userDao;
    private CartItemDao cartItemDao;

    public CartController(ProductDao productDao, UserDao userDao, CartItemDao cartItemDao) {
        this.productDao = productDao;
        this.userDao = userDao;
        this.cartItemDao = cartItemDao;
    }

    @PostMapping("/carts")
    public ResponseEntity<UpdateCartItemReponse> createCart(@RequestBody CreateCarItemRequest createCarItemRequest){
        //实现
        int quantity = createCarItemRequest.getQuantity();
        Product product = productDao.findById(createCarItemRequest.getProductId());
        User user =userDao.findById(createCarItemRequest.getUserId());
        CartItem item = new CartItem(user,product,quantity);
        cartItemDao.save(item);
        return new ResponseEntity<>(new UpdateCartItemReponse(item), HttpStatus.CREATED);
    }

    @PutMapping("/carts/{cartId}")
    public ResponseEntity<UpdateCartItemReponse> updateCart(@PathVariable int cartId, @RequestBody UpdateCartItemRequest updateCartItemRequest){
        //实现
        CartItem item = cartItemDao.findById(cartId);
        item.setQuantity(updateCartItemRequest.getQuantity());
        item = cartItemDao.save(item);
        return new ResponseEntity<>(new UpdateCartItemReponse(item), HttpStatus.OK);
    }

    @DeleteMapping("carts/{cartId}")
    public void deleteCartItem(@PathVariable int cartId)
    {
        //代码实现
        CartItem item = cartItemDao.findById(cartId);
        cartItemDao.delete(item);

    }

    @GetMapping("/carts/{cartId}")
    public ResponseEntity<GetCartItemResponse> getCart(@PathVariable int cartId){

        CartItem item = cartItemDao.findById(cartId);
        return new ResponseEntity<>(new GetCartItemResponse(item), HttpStatus.OK);
    }

    @GetMapping("/carts")
    public ResponseEntity<ListCartItemResponse> listCarts(){
        //实现
        List<CartItem> items = cartItemDao.findAll();
        return new ResponseEntity<>(new ListCartItemResponse(items), HttpStatus.OK);
    }

}
