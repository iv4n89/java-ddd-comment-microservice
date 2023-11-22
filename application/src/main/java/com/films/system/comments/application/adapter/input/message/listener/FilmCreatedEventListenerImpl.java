package com.films.system.comments.application.adapter.input.message.listener;

import com.films.service.comments.domain.models.Film;
import com.films.service.comments.domain.ports.input.message.listener.FilmCreatedEventListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FilmCreatedEventListenerImpl implements FilmCreatedEventListener {

    @Override
    public void filmCreated(Film film) {
        log.info("Received film with id: {} title: {}", film.getFilmId().getValue(), film.getTitle());
    }
}
