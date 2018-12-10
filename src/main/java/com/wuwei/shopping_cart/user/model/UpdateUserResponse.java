package com.wuwei.shopping_cart.user.model;

public class UpdateUserResponse {
    private User user;

    public UpdateUserResponse() {
    }

    public UpdateUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
