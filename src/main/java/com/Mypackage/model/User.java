package com.yourpackage.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password; // Store hashed password
    private String role; // e.g., "USER" or "ADMIN"

    // Getters and Setters
}
