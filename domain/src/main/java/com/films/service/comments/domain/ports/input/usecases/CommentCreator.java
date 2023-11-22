package com.films.service.comments.domain.ports.input.usecases;

import com.films.service.comments.domain.events.CommentCreatedEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CommentCreator {
  CommentCreatedEvent create(
          UUID commentId,
          String commentDescription,
          Integer commentRating,
          UUID filmId,
          UUID userId,
          LocalDateTime createdAt);
}
