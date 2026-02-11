package com.socialing.start.service.impl;

import com.socialing.start.entity.User;
import com.socialing.start.repositories.UserRepository;
import com.socialing.start.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        String email = user.getEmail();
        //User user1 = userRepository.findByEmail(email);
        /*if(user1==null){
            return new
        }*/
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        userRepository.save(user);
        return user;
    }
}
