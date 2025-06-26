package com.example.filmajanlo.repository;

import com.example.filmajanlo.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}