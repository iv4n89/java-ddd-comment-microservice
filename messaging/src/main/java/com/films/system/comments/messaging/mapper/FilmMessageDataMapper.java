package com.films.system.comments.messaging.mapper;

import com.films.service.comments.domain.models.Film;
import com.films.system.common.application.dto.message.FilmMessageDto;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.ImageId;
import org.springframework.stereotype.Component;

@Component
public class FilmMessageDataMapper {

  public Film filmMessageDtoToFilm(FilmMessageDto filmMessageDto) {
    return Film.builder()
        .filmId(new FilmId(filmMessageDto.getId()))
        .title(filmMessageDto.getTitle())
        .launchDate(filmMessageDto.getLaunchDate())
        .meanRating(filmMessageDto.getMeanRating())
        .imageId(new ImageId(filmMessageDto.getImageId()))
        .build();
  }

  public FilmMessageDto filmToFilmMessageDto(Film film) {
    return FilmMessageDto.builder()
        .id(film.getFilmId().getValue())
        .title(film.getTitle())
        .launchDate(film.getLaunchDate())
        .meanRating(film.getMeanRating())
        .imageId(film.getImageId().getValue())
        .build();
  }
}
