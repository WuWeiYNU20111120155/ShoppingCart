package com.wuwei.shopping_cart.web.user.view;

import com.wuwei.shopping_cart.web.user.model.User;

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
