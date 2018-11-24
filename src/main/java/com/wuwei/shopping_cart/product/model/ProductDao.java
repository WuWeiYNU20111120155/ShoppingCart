package com.wuwei.shopping_cart.product.model;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {

    private Statement statement;

    //注入依賴 在構造函數的時候
    public ProductDao(Statement statement) {
        this.statement = statement;

        //测试代码
        try {
            ResultSet rs = statement.executeQuery("select * from `product`;");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private Product genProduct(ResultSet rs) {
        try {
            return new Product(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public Product createProduct(CreateProductRequest createProductRequest) {
        try {

            String description = createProductRequest.getDescription();
            String name = createProductRequest.getName();
            double price = createProductRequest.getPrice();

            String query = "INSERT INTO `product` (name, description, price)" +
                    "VALUES ('" + name + "'" + "," + "'" + description + "'" + "," + price + ");";
            System.out.println(query);
            statement.executeUpdate(query);

            ResultSet rs = statement.executeQuery("select * from `product` where name='" + name + "';");
            System.out.println(rs);
            if (rs.next()) {
                return genProduct(rs);
            } else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(int id) {
        try {

            String query = "select * from `product` where id=" + id + ";";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                return genProduct(rs);
            } else return null;

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public List<Product> listProducts() {
        try {
            String query = "select * from `product`;";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            List<Product> products = new ArrayList<>();

            while (rs.next()) {
                products.add(genProduct(rs));
            }
            return products;

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public Product updateProduct(int id, UpdateProductRequest updateProductRequest) {
        String description = updateProductRequest.getDescription();
        String name = updateProductRequest.getName();
        double price = updateProductRequest.getPrice();

        try {
            String query = "update `product` set name = " + "'"+name+"'"
                    + ",description = " + "'"+description+"'"
                    + ",price=" + "'"+price+"'"
                    + " where id = " + id;
            System.out.println(query);
            statement.executeUpdate(query);

            ResultSet rs = statement.executeQuery("select * from `product` where id=" + id);
            return genProduct(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
