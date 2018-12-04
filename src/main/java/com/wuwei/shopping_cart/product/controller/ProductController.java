package com.wuwei.shopping_cart.product.controller;

import com.wuwei.shopping_cart.product.controller.model.*;
import com.wuwei.shopping_cart.product.model.*;
import org.hibernate.validator.internal.util.privilegedactions.NewProxyInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductDao productDao;

    public  ProductController(ProductDao productDao){
        this.productDao = productDao;
    }
    /*
    * List products
    */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts(){
        //取出数据库中的products然后转化为product的list对象放到ListProductResponse(List<product>)
        //List<Product> products = productDao.listProducts();
        List<Product> products = productDao.findAll();
        return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
    }

    /*
    * Get product
    */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable int productId ){

        //实现 在数据库中取出该product然后转化为product对象放到GetProductResponse(product)
        // Product product = productDao.getProductById(productId);
        Product product = productDao.findById(productId);


        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }

    /*
    * Create Product
    */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest){
        //实现校验等代码，
        //Product product = productDao.createProduct(createProductRequest);
        Product product = productDao.save(new Product(createProductRequest.getName(),createProductRequest.getDescription(),createProductRequest.getPrice()));
        return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
    }
    /*
    * 更新商品
    */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable int productId,@RequestBody UpdateProductRequest updateProductRequest){
        //实现代码

        Product product = productDao.findById(productId);
        product.setDescription(updateProductRequest.getDescription());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product = productDao.save(product);
        return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.OK);
    }


}
