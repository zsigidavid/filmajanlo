package com.example.filmajanlo.service;

import com.example.filmajanlo.model.Movie;
import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);
    List<Movie> getAllMovies();
    Movie rateMovie(Long id, int rating);
}