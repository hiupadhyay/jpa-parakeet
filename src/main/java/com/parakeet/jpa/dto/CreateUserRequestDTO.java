package com.parakeet.jpa.dto;

import lombok.Data;

@Data
public class CreateUserRequestDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private Long dobInMillis;
    private String gender;


}
