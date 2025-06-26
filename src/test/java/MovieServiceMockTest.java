package com.example.filmajanlo.service;
import com.example.filmajanlo.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceMockTest {

    private MovieServiceMock service;

    @BeforeEach
    void setUp() {
        service = new MovieServiceMock();
    }

    @Test
    void testAddMovie() {
        Movie movie = new Movie(null, "Test Movie", "Action", 5, false, null);
        Movie saved = service.addMovie(movie);
        assertNotNull(saved.getId());
        assertEquals("Test Movie", saved.getTitle());
    }

    @Test
    void testGetAllMovies() {
        service.addMovie(new Movie(null, "A", "Drama", 3, false, null));
        service.addMovie(new Movie(null, "B", "Comedy", 4, true, null));
        List<Movie> movies = service.getAllMovies();
        assertEquals(2, movies.size());
    }

    @Test
    void testUpdateMovie() {
        Movie movie = service.addMovie(new Movie(null, "Old", "Action", 2, false, null));
        Movie updated = new Movie(null, "New", "Drama", 5, true, null);
        Movie result = service.updateMovie(movie.getId(), updated);
        assertNotNull(result);
        assertEquals("New", result.getTitle());
        assertEquals("Drama", result.getGenre());
        assertEquals(5, result.getRating());
        assertTrue(result.isWatched());
    }

    @Test
    void testDeleteMovie() {
        Movie movie = service.addMovie(new Movie(null, "ToDelete", "Action", 1, false, null));
        service.deleteMovie(movie.getId());
        assertTrue(service.getAllMovies().isEmpty());
    }

    @Test
    void testRateMovie() {
        Movie movie = service.addMovie(new Movie(null, "ToRate", "Action", 1, false, null));
        Movie rated = service.rateMovie(movie.getId(), 8);
        assertNotNull(rated);
        assertEquals(8, rated.getRating());
    }

    @Test
    void testUpdateNonExistingMovie() {
        Movie result = service.updateMovie(999L, new Movie(null, "X", "Y", 1, false, null));
        assertNull(result);
    }

    @Test
    void testRateNonExistingMovie() {
        Movie result = service.rateMovie(999L, 10);
        assertNull(result);
    }
}
