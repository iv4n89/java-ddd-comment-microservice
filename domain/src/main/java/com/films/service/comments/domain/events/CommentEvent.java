package com.films.service.comments.domain.events;

import com.films.service.comments.domain.models.Comment;
import com.films.system.common.domain.events.DomainEvent;

import java.time.ZonedDateTime;

public abstract class CommentEvent implements DomainEvent<Comment> {
  private final Comment comment;
  private final ZonedDateTime createdAt;

  protected CommentEvent(Comment comment, ZonedDateTime createdAt) {
    this.comment = comment;
    this.createdAt = createdAt;
  }

  public Comment getComment() {
    return comment;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }
}
