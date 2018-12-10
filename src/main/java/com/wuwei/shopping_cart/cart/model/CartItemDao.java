package com.wuwei.shopping_cart.cart.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDao extends CrudRepository<CartItem,Integer> {

    CartItem findById(int id);
    List<CartItem> findAll();
    CartItem save(CartItem item);
    void delete(CartItem item);

}
