package ru.netology.poster.manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmManagerTest {

    @Test
    void shouldCreateWithDefaultLimit() {
        FilmManager manager = new FilmManager();
        assertEquals(0, manager.findAll().length);
    }

    @Test
    void shouldCreateWithCustomLimit() {
        FilmManager manager = new FilmManager(3);
        assertEquals(0, manager.findAll().length);
    }

    @Test
    void shouldAddOneMovie() {
        FilmManager manager = new FilmManager();
        manager.addFilm("film1");
        String[] expected = {"film1"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindAllMultiple() {
        FilmManager manager = new FilmManager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        String[] expected = {"film1", "film2", "film3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastEmpty() {
        FilmManager manager = new FilmManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastLessThanLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        String[] expected = {"film3", "film2", "film1"};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastEqualLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        String[] expected = {"film5", "film4", "film3", "film2", "film1"};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastMoreThanLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        String[] expected = {"film6", "film5","film4", "film3", "film2"};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastWithCustomLimitLess() {
        FilmManager manager = new FilmManager(3);
        manager.addFilm("film1");
        manager.addFilm("film2");
        String[] expected = {"film2", "film1"};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastWithCustomLimitMore() {
        FilmManager manager = new FilmManager(3);
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        String[] expected = {"film4", "film3", "film2"};
        assertArrayEquals(expected, manager.findLastFilms());
    }

    @Test
    void shouldFindLastWithZeroLimit() {
        FilmManager manager = new FilmManager(0);
        manager.addFilm("film1");
        String[] expected = {};
        assertArrayEquals(expected, manager.findLastFilms());
    }
}
