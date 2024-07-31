package com.example.spring.security.repositories;

import com.example.spring.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

}
