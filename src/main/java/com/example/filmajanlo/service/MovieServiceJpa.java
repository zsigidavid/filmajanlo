package com.example.filmajanlo.service;

import com.example.filmajanlo.model.Movie;
import com.example.filmajanlo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaService")
public class MovieServiceJpa implements MovieService {
    private final MovieRepository repo;

    public MovieServiceJpa(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        return repo.findById(id).map(m -> {
            m.setTitle(movie.getTitle());
            m.setGenre(movie.getGenre());
            m.setRating(movie.getRating());
            m.setWatched(movie.isWatched());
            return repo.save(m);
        }).orElse(null);
    }

    @Override
    public void deleteMovie(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    @Override
    public Movie rateMovie(Long id, int rating) {
        return repo.findById(id).map(m -> {
            m.setRating(rating);
            return repo.save(m);
        }).orElse(null);
    }
}