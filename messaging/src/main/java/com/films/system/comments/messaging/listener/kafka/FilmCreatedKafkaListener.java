package com.films.system.comments.messaging.listener.kafka;

import com.films.service.comments.domain.ports.input.message.listener.FilmCreatedEventListener;
import com.films.system.comments.messaging.mapper.FilmMessageDataMapper;
import com.films.system.common.application.dto.message.FilmMessageDto;
import com.films.system.common.kafka.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FilmCreatedKafkaListener implements KafkaConsumer<FilmMessageDto> {

  private final FilmCreatedEventListener filmCreatedEventListener;
  private final FilmMessageDataMapper filmMessageDataMapper;

  @Override
  @KafkaListener(
      id = "${kafka-consumer-config.film-created-group-id}",
      topics = "${comments-service.film-created-topic}")
  public void receive(FilmMessageDto payload) {
    log.info("Received message with payload: {}", payload.getId());

    filmCreatedEventListener.filmCreated(filmMessageDataMapper.filmMessageDtoToFilm(payload));
  }
}
