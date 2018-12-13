package com.wuwei.shopping_cart.user.model;

public class GetUserResponse {
    private User user;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public GetUserResponse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
