package com.example.filmajanlo.service;

import com.example.filmajanlo.model.Movie;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service("mockService")
public class MovieServiceMock implements MovieService {
    private final List<Movie> movies = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong();

    @Override
    public Movie addMovie(Movie movie) {
        movie.setId(idGen.incrementAndGet());
        movies.add(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        for (Movie m : movies) {
            if (m.getId().equals(id)) {
                m.setTitle(movie.getTitle());
                m.setGenre(movie.getGenre());
                m.setRating(movie.getRating());
                m.setWatched(movie.isWatched());
                return m;
            }
        }
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        movies.removeIf(m -> m.getId().equals(id));
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    @Override
    public Movie rateMovie(Long id, int rating) {
        for (Movie m : movies) {
            if (m.getId().equals(id)) {
                m.setRating(rating);
                return m;
            }
        }
        return null;
    }
}