package com.wuwei.shopping_cart.product;
import com.wuwei.shopping_cart.product.model.*;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class ProductControllerTest {
    ProductDao productDao ;
    private ProductController productController = new ProductController(productDao);

    @Test
    public void shouldListProducts() {

        ResponseEntity<ListProductResponse> response = productController.listProducts();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        //assertEquals(response.getBody(),);
        //其他的代码
    }

    @Test
    public void shouldGetProduct() {
        //Product product = new Product("342sr","spoon","to eat something",12);
        //GetProductResponse getProductResponse = new GetProductResponse(product);
        ResponseEntity<GetProductResponse> response = productController.getProduct(1);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        // assertEquals(response.getBody(),getProductResponse);
    }

    @Test
    public void shouldCreateProduct() {
        CreateProductRequest createProductRequest = new CreateProductRequest("spoon", "metal,good quality", 23);
        //CreateProductResponse createProductResponse  = new CreateProductResponse()
        ResponseEntity<CreateProductResponse> responseEntity = productController.createProduct(createProductRequest);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
       // assertEquals(responseEntity.getBody(), createProductResponse);
    }

@Test
public void shouldUpdateProduct(){

    UpdateProductRequest request = new UpdateProductRequest("pencil","to write",1);
    ResponseEntity<UpdateProductResponse> responseEntity = productController.updateProduct(0111,request);
    assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
}
}