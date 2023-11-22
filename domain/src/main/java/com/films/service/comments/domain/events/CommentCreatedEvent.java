package com.films.service.comments.domain.events;

import com.films.service.comments.domain.models.Comment;

import java.time.ZonedDateTime;

public class CommentCreatedEvent extends CommentEvent {

  private final Integer meanRating;

  public CommentCreatedEvent(Comment comment, ZonedDateTime createdAt, Integer meanRating) {
    super(comment, createdAt);
    this.meanRating = meanRating;
  }

  public Integer getMeanRating() {
    return meanRating;
  }
}
