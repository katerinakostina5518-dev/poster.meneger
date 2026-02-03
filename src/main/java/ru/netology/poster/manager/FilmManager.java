package ru.netology.poster.manager;

public class FilmManager {
    String[] films = new String[0];
    private final int limit;

    public FilmManager() {
        this.limit = 5;
    }

    public FilmManager(int customLimit) {
        this.limit = customLimit;
    }
    public String[] findAll() {
        return films;
    }

    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findLastFilms() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}

