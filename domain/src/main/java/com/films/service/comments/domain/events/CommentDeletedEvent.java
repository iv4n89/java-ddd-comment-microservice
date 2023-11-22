package com.films.service.comments.domain.events;

import com.films.service.comments.domain.models.Comment;

import java.time.ZonedDateTime;

public class CommentDeletedEvent extends CommentEvent {
  public CommentDeletedEvent(Comment comment, ZonedDateTime createdAt) {
    super(comment, createdAt);
  }
}
