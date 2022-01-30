package com.parakeet.jpa.controller;

import com.parakeet.jpa.dto.CreateUserRequestDTO;
import com.parakeet.jpa.dto.CreateUserResponseDTO;
import com.parakeet.jpa.entites.Users;
import com.parakeet.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public Mono<ResponseEntity> create(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        Users user = userService.createUser(createUserRequestDTO);
        CreateUserResponseDTO createUserResponseDTO = new CreateUserResponseDTO();
        if (user != null) {
            createUserResponseDTO.setResponse("user created successfully");
            createUserResponseDTO.setResourceId(user.getId().toString());
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(createUserResponseDTO));
        }
        createUserResponseDTO.setResponse("error while creating user");
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createUserResponseDTO));
    }

    @GetMapping("/{userId}")
    public Mono<ResponseEntity> user(@PathVariable("userId") String userId) {
        Optional<Users> user = userService.getUser(userId);
        if (user.isPresent())
            return Mono.just(ResponseEntity.status(HttpStatus.OK).body(user));
        else
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
