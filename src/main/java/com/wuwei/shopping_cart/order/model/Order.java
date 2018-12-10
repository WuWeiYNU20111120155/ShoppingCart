package com.wuwei.shopping_cart.order.model;

import com.wuwei.shopping_cart.product.model.Product;
import com.wuwei.shopping_cart.user.model.User;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn (name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name ="product_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name ="status")
    private String status;

    @Column(name ="address")
    private String address;

    public Order() {
    }

    public Order(User user, Product product, int quantity, String status, String address) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
