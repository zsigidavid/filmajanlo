package com.example.filmajanlo.repository;

import com.example.filmajanlo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}