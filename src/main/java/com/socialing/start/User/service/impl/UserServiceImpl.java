package com.socialing.start.User.service.impl;

import com.socialing.start.User.dtos.UserDTO;
import com.socialing.start.User.entity.User;
import com.socialing.start.User.enums.Role;
import com.socialing.start.User.repositories.UserRepository;
import com.socialing.start.User.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        userDTO.setPasswordHash(bCryptPasswordEncoder.encode(userDTO.getPasswordHash()));

        User user = modelMapper.map(userDTO, User.class);
        user.setRole(Role.USER);

        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not exist"));
        return modelMapper.map(user, UserDTO.class);
    }


    @Override
    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not exist"));
        userRepository.delete(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not exist"));

        if(userDTO.getFirstName() != null){
            user.setFirstName(userDTO.getFirstName());
        }

        if(userDTO.getLastName() != null){
            user.setLastName(userDTO.getLastName());
        }

        User updateUser = userRepository.save(user);
        return modelMapper.map(updateUser, UserDTO.class);
    }
}
