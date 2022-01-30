package com.parakeet.jpa.entites;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "useractivity")
@Data
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "details")
    private String details;
    @Column(name = "login_ts")
    private LocalDate loginTs;
    @Column(name = "logout_ts")
    private LocalDate logoutTs;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users users;


}
