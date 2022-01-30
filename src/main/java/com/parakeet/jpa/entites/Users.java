package com.parakeet.jpa.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "contact_id")
    private Long contactId;


}
