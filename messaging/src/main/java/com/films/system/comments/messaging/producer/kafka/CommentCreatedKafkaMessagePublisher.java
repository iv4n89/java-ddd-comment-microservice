package com.films.system.comments.messaging.producer.kafka;

import com.films.service.comments.domain.events.CommentCreatedEvent;
import com.films.service.comments.domain.ports.output.message.publisher.CommentCreatedRequestMessagePublisher;
import com.films.system.common.application.dto.message.CommentCreatedMessageDto;
import com.films.system.common.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CommentCreatedKafkaMessagePublisher implements CommentCreatedRequestMessagePublisher {

  private final KafkaProducer<CommentCreatedMessageDto> kafkaProducer;

  @Value("${kafka-producer.comment-created-topic}")
  private String topic;

  @Override
  public void publish(CommentCreatedEvent domainEvent) {
    String commentId = domainEvent.getComment().getCommentId().getValue().toString();
    try {
      CommentCreatedMessageDto message =
          CommentCreatedMessageDto.builder()
              .filmId(domainEvent.getComment().getFilmId().getValue())
              .meanRating(domainEvent.getMeanRating())
              .build();
      kafkaProducer.send(topic, message);
      log.info(
          "Comment sent to kafka for comment id: {} and film id: {}",
          commentId,
          domainEvent.getComment().getFilmId().getValue().toString());
    } catch (Exception e) {
      log.error(
          "Error while sending Comment message to kafka with comment id: {} and film id: {}, error: {}",
          commentId,
          domainEvent.getComment().getFilmId().getValue().toString(),
          e.getMessage(),
          e);
    }
  }
}
