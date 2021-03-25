package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmManagerTest {
    private FilmManager manager = new FilmManager();
    FilmItem first = new FilmItem(1, "img1.jpg", "Name1", "horror");
    FilmItem second = new FilmItem(2, "img2.jpg", "Name2", "fantasy");
    FilmItem third = new FilmItem(3, "img3.jpg,", "Name3", "comedy");
    FilmItem fourth = new FilmItem(4, "img4.jpg", "Name4", "drama");
    FilmItem fifth = new FilmItem(5, "img5.jpg", "Name5", "crime");
    FilmItem sixth = new FilmItem(6, "img6.jpg", "Name6", "musical");
    FilmItem seventh = new FilmItem(7, "img7.jpg", "Name7", "action");
    FilmItem eighth = new FilmItem(8, "img8.jpg", "Name8", "detective");
    FilmItem ninth = new FilmItem(9, "img9.jpg", "Name9", "romance");
    FilmItem tenth = new FilmItem(10, "img10.jpg", "Name10", "cartoon");
    FilmItem eleventh = new FilmItem(11, "img11.jpg", "Name11", "art-house");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    void ShouldShowWhenZero() {
        manager = new FilmManager(0);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldShowAllTen() {
        manager.add(tenth);

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldShowLessThanTen() {
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldShowMoreThanTen() {
        manager.add(tenth);
        manager.add(eleventh);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldAddOneMovie() {
        manager = new FilmManager(1);
        manager.add(first);

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldAddTenMovies() {
        manager = new FilmManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldAddMoreThanTenMovies() {
        manager = new FilmManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}