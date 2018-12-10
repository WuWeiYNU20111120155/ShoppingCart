package com.wuwei.shopping_cart.user.model;

public class UpdateUserRequest {
    private String name;
    private String password;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
