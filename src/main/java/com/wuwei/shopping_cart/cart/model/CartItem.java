package com.wuwei.shopping_cart.cart.model;

import com.sun.prism.shader.FillEllipse_Color_AlphaTest_Loader;
import com.wuwei.shopping_cart.product.model.Product;
import com.wuwei.shopping_cart.user.model.User;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "product_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public CartItem() {
    }

    public CartItem( User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
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
}
