package com.parakeet.jpa.repository;

import com.parakeet.jpa.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
}
