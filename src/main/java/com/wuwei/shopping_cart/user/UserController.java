package com.wuwei.shopping_cart.user;

import com.wuwei.shopping_cart.user.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){

        User user = new User(createUserRequest.getName(),createUserRequest.getPassword());
        userDao.save(user);
        return new ResponseEntity<>(new CreateUserResponse(user), HttpStatus.CREATED);

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable int id, UpdateUserRequest updateUserRequest){

        User user = userDao.getById(id);
        user.setName(updateUserRequest.getName());
        user.setPassword(updateUserRequest.getPassword());
        user = userDao.save(user);
        return new ResponseEntity<>(new UpdateUserResponse(user),HttpStatus.OK);
    }
}
