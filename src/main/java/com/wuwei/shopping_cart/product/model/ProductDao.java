package com.wuwei.shopping_cart.product.model;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

/*
ORM 会帮我们实现这个接口，也就是实现其中的操作（输出Sql语句，执行sql语句，转换返回的结果到JAVA对象）
 */

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {

    //根据ORM的命名惯例，声明操作方法就可以了
    Product findById(int id);
    List<Product>findAll();
    Product save(Product product);
    //Product update(Product product);

}
