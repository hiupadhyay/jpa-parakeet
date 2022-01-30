package com.parakeet.jpa.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class UserDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private List<UserActivityDTO> userActivity;

}
