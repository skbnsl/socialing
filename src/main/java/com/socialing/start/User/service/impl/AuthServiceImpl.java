package com.socialing.start.User.service.impl;

import com.socialing.start.User.dtos.LoginRequest;
import com.socialing.start.User.dtos.UserDTO;
import com.socialing.start.User.entity.User;
import com.socialing.start.User.repositories.UserRepository;
import com.socialing.start.User.security.jwts.JwtService;
import com.socialing.start.User.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO loginUser(LoginRequest loginRequest) {
        String email = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not exist with username: " + email));

        if(!bCryptPasswordEncoder.matches(password, user.getPasswordHash())){
            throw new RuntimeException("username/password invalid!");
        }
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        String jwtToen = jwtService.generateToken(userDTO.getEmail());
        userDTO.setToken(jwtToen);

        return userDTO;

    }
}
