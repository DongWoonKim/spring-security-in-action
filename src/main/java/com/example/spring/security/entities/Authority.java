package com.example.spring.security.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;

}
