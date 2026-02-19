package com.socialing.start.User.controller;

import com.socialing.start.User.dtos.LoginRequest;
import com.socialing.start.User.dtos.RegisterRequest;
import com.socialing.start.User.dtos.UserDTO;
import com.socialing.start.User.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequest loginRequest){
        UserDTO user = authService.loginUser(loginRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    /*@PostMapping("/register")
    public ResponseEntity<UserDTO> addUser(@RequestBody RegisterRequest request){
        UserDTO user1 = userService.addUser(request);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }*/
}
