package com.example.filmajanlo.service;

import com.example.filmajanlo.model.Director;
import com.example.filmajanlo.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public Optional<Director> findById(Long id) {
        return directorRepository.findById(id);
    }

    public Director save(Director director) {
        return directorRepository.save(director);
    }

    public void deleteById(Long id) {
        directorRepository.deleteById(id);
    }
}