package com.example.filmajanlo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int rating;
    private boolean watched;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}