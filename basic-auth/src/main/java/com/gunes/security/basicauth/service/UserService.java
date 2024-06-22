package com.gunes.security.basicauth.service;


import com.gunes.security.basicauth.dto.CreateUserRequest;
import com.gunes.security.basicauth.model.User;
import com.gunes.security.basicauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest request){
        User newUser= User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnable(true)
                .accountNonLocked(true)
                .build();

        return userRepository.save(newUser);
    }
}
