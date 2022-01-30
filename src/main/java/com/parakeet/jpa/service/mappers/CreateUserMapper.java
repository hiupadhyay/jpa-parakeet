package com.parakeet.jpa.service.mappers;

import com.parakeet.jpa.dto.CreateUserRequestDTO;
import com.parakeet.jpa.entites.Users;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class CreateUserMapper {
    public static Users mapUserDTOToUser(CreateUserRequestDTO createUserDTO) {
        final Users user = new Users();
        user.setFirstName(createUserDTO.getFirstName());
        user.setMiddleName(createUserDTO.getMiddleName());
        user.setLastName(createUserDTO.getLastName());
        user.setDateOfBirth(LocalDateTime.ofInstant(Instant.ofEpochMilli(createUserDTO.getDobInMillis()), TimeZone.getDefault().toZoneId()).toLocalDate());
        user.setGender(createUserDTO.getGender());
        return user;
    }
}
