package com.films.service.comments.domain.ports.input.message.listener;

import com.films.service.comments.domain.models.Film;

public interface FilmCreatedEventListener {
    void filmCreated(Film film);
}
