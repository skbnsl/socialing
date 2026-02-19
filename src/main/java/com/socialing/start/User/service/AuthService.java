package com.socialing.start.User.service;

import com.socialing.start.User.dtos.LoginRequest;
import com.socialing.start.User.dtos.LoginResponse;
import com.socialing.start.User.dtos.UserDTO;

public interface AuthService {
    LoginResponse loginUser(LoginRequest loginRequest);
}
