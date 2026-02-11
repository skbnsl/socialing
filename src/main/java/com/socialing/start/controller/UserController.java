package com.socialing.start.controller;

import com.socialing.start.entity.User;
import com.socialing.start.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

}
