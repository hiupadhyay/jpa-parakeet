package com.parakeet.jpa.service;

import com.parakeet.jpa.dto.CreateUserRequestDTO;
import com.parakeet.jpa.entites.Users;
import com.parakeet.jpa.repository.UserRepository;
import com.parakeet.jpa.service.mappers.CreateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(CreateUserRequestDTO createUserDTO) {
        return userRepository.save(CreateUserMapper.mapUserDTOToUser(createUserDTO));
    }

    public Optional<Users> getUser(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }
}
