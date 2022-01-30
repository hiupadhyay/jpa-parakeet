package com.parakeet.jpa.service.mappers;

import com.parakeet.jpa.dto.CreateUserRequestDTO;
import com.parakeet.jpa.dto.UserActivityDTO;
import com.parakeet.jpa.dto.UserDTO;
import com.parakeet.jpa.entites.UserActivity;
import com.parakeet.jpa.entites.Users;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class UserMapper {
    public static Users mapUserDTOToUser(CreateUserRequestDTO createUserDTO) {
        final Users user = new Users();
        user.setFirstName(createUserDTO.getFirstName());
        user.setMiddleName(createUserDTO.getMiddleName());
        user.setLastName(createUserDTO.getLastName());
        user.setDateOfBirth(LocalDateTime.ofInstant(Instant.ofEpochMilli(createUserDTO.getDobInMillis()), TimeZone.getDefault().toZoneId()).toLocalDate());
        user.setGender(createUserDTO.getGender());
        return user;
    }

    public static UserDTO userEntityToDTO(Users user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setUserActivity(mapUserActivity(user.getUseractivity()));
        return userDTO;
    }

    private static List<UserActivityDTO> mapUserActivity(Set<UserActivity> useractivity) {
        final List<UserActivityDTO> userActivityDTOS = new ArrayList<>();
        for (UserActivity userActivityDTO : useractivity) {
            UserActivityDTO activityDTO = new UserActivityDTO();
            activityDTO.setDetails(userActivityDTO.getDetails());
            userActivityDTOS.add(activityDTO);
        }
        return userActivityDTOS;
    }
}
