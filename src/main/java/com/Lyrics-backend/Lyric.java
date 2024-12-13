package com.yourpackage.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Lyric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String album;
    private String songwriter;
    @Column(length = 10000)
    private String lyrics;

    private String submittedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}

