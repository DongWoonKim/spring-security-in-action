package com.example.spring.security.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String authority;

}
