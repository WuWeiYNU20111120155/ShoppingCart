package com.wuwei.shopping_cart.web.user.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User,Integer> {
    User findById(int id);
    User getByName(String name);
    List<User> findAll();
    User save(User user);

}
