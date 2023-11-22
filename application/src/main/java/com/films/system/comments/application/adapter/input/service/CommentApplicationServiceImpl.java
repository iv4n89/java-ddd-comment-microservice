package com.films.system.comments.application.adapter.input.service;

import com.films.service.comments.domain.events.CommentCreatedEvent;
import com.films.service.comments.domain.events.CommentDeletedEvent;
import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.ports.input.service.CommentApplicationService;
import com.films.service.comments.domain.ports.input.usecases.CommentCreator;
import com.films.service.comments.domain.ports.input.usecases.CommentDeleter;
import com.films.service.comments.domain.ports.input.usecases.CommentFinder;
import com.films.service.comments.domain.ports.output.message.publisher.CommentCreatedRequestMessagePublisher;
import com.films.service.comments.domain.ports.output.message.publisher.CommentDeletedRequestMessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public final class CommentApplicationServiceImpl implements CommentApplicationService {

  private final CommentCreator commentCreator;
  private final CommentFinder commentFinder;
  private final CommentDeleter commentDeleter;
  private final CommentCreatedRequestMessagePublisher commentCreatedRequestMessagePublisher;
  private final CommentDeletedRequestMessagePublisher commentDeletedRequestMessagePublisher;

  @Override
  public void create(
          UUID commentId, String commentDescritption, Integer commentRating, UUID filmId, UUID userId, LocalDateTime createdAt) {
    CommentCreatedEvent event =
        commentCreator.create(commentId, commentDescritption, commentRating, filmId, userId, createdAt);
    commentCreatedRequestMessagePublisher.publish(event);
  }

  @Override
  public Optional<Comment> findById(UUID commentId) {
    return commentFinder.findById(commentId);
  }

  @Override
  public List<Comment> findByFilmId(UUID filmId) {
    return commentFinder.findByFilmId(filmId);
  }

  @Override
  public List<Comment> findByUserId(UUID userId) {
    return commentFinder.findByUserId(userId);
  }

  @Override
  public void delete(UUID commentId) {
    CommentDeletedEvent event = commentDeleter.delete(commentId);
    commentDeletedRequestMessagePublisher.publish(event);
  }
}
