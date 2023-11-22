package com.films.system.comments.messaging.listener.kafka;

import com.films.service.comments.domain.ports.input.message.listener.FilmDeletedEventListener;
import com.films.system.comments.messaging.mapper.FilmMessageDataMapper;
import com.films.system.common.application.dto.message.FilmMessageDto;
import com.films.system.common.kafka.consumer.KafkaConsumer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FilmDeletedKafkaListener implements KafkaConsumer<FilmMessageDto> {

  private final FilmDeletedEventListener filmDeletedEventListener;
  private final FilmMessageDataMapper filmMessageDataMapper;

  @Override
  @KafkaListener(
      id = "${kafka-consumer-config.film-deleted-group-id}",
      topics = "${comments-service.film-deleted-topic}")
  public void receive(FilmMessageDto payload) {
    log.info("Received message with payload: {}", payload.getId());
    filmDeletedEventListener.filmDeleted(filmMessageDataMapper.filmMessageDtoToFilm(payload));
  }
}
