package ru.netology.manager;

import ru.netology.domain.FilmItem;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    private int maxFilm = 10;

    public FilmManager() {

    }

    public void add(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] getAll() {
        FilmItem[] result = new FilmItem[Math.min(items.length, maxFilm)];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public FilmManager(int numberFilm) {
        if (numberFilm < 0) {
            return;
        }
        this.maxFilm = numberFilm;
    }
}
