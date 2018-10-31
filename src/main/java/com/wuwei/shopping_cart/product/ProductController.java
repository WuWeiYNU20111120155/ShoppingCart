package com.wuwei.shopping_cart.product;

import com.wuwei.shopping_cart.product.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ProductController {

    /*
    * List products
    */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts(){
        //取出数据库中的products然后转化为product的list对象放到ListProductResponse(List<product>)
        return new ResponseEntity<>(new ListProductResponse(), HttpStatus.OK);
    }

    /*
    * Get product
    */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId ){

        //实现 在数据库中取出该product然后转化为product对象放到GetProductResponse(product)
        return new ResponseEntity<>(new GetProductResponse(), HttpStatus.OK);
    }

    /*
    * Create Product
    */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest){
        //实现校验等代码，
        return new ResponseEntity<>(new CreateProductResponse(), HttpStatus.CREATED);
    }
    /*
    * 更新商品
    */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable String productId,@RequestBody UpdateProductRequest updateProductRequest){

        return new ResponseEntity<>(new UpdateProductResponse(), HttpStatus.OK);
    }


}
