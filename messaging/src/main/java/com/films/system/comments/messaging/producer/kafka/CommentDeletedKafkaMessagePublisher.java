package com.films.system.comments.messaging.producer.kafka;

import com.films.service.comments.domain.events.CommentDeletedEvent;
import com.films.service.comments.domain.ports.output.message.publisher.CommentDeletedRequestMessagePublisher;
import com.films.system.comments.messaging.config.CommentMessagingConfigData;
import com.films.system.comments.messaging.mapper.CommentMessageDataMapper;
import com.films.system.common.application.dto.message.CommentMessageDto;
import com.films.system.common.kafka.producer.KafkaMessageHelper;
import com.films.system.common.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CommentDeletedKafkaMessagePublisher implements CommentDeletedRequestMessagePublisher {

  private final KafkaProducer<CommentMessageDto> kafkaProducer;
  private final CommentMessageDataMapper commentMessageDataMapper;

  @Value("${kafka-producer.comment-deleted-topic}")
  private String topic;

  @Override
  public void publish(CommentDeletedEvent domainEvent) {
    String commentId = domainEvent.getComment().getCommentId().getValue().toString();
    try {
      kafkaProducer.send(
          topic, commentMessageDataMapper.commentToCommentMessageDto(domainEvent.getComment()));
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
