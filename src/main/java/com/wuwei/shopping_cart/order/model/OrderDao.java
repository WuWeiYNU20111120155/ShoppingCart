package com.wuwei.shopping_cart.order.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDao extends CrudRepository<Order,Integer> {

    Order findById(int id);
    List<Order> findAll();
    Order save(Order order);
    void  delete(Order order);

}
