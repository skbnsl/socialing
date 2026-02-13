package com.socialing.start.User.controller;

import com.socialing.start.User.dtos.UserDTO;
import com.socialing.start.User.entity.User;
import com.socialing.start.User.service.UserService;
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
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO user1 = userService.addUser(userDTO);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId){
        UserDTO user1 = userService.getUserById(userId);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User Deleted with userId "+userId+" successfully!");
    }

    @PatchMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO userDTO, @PathVariable Long userId){
        UserDTO updatedUser = userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
