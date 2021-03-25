package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmItem {
    private int filmId;
    private String imageUrl;
    private String nameFilm;
    private String genre;
}
