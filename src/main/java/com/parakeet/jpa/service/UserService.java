package com.parakeet.jpa.service;

import com.parakeet.jpa.dto.CreateUserRequestDTO;
import com.parakeet.jpa.entites.Users;
import com.parakeet.jpa.repository.UserRepository;
import com.parakeet.jpa.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(CreateUserRequestDTO createUserDTO) {
        return userRepository.save(UserMapper.mapUserDTOToUser(createUserDTO));
    }

    public Optional<Users> getUser(String userId) {
        UUID uuid=UUID.fromString(userId);
        return userRepository.findById(uuid);
    }
}
