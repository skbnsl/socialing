package com.socialing.start.User.service;

import com.socialing.start.User.dtos.UserDTO;
import com.socialing.start.User.entity.User;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    void deleteUserById(Long userId);

    UserDTO updateUser(UserDTO userDTO, Long userId);

}
