package com.films.service.comments.domain.models;

import com.films.service.comments.domain.valueobjects.CommentDescription;
import com.films.service.comments.domain.valueobjects.CommentRating;
import com.films.system.common.domain.AggregateRoot;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Comment extends AggregateRoot implements Serializable {

  private final CommentId commentId;
  private final CommentDescription description;
  private final CommentRating rating;
  private final FilmId filmId;
  private final UserId userId;
  private final ZonedDateTime createdAt;

  private Comment(Builder builder) {
    commentId = builder.commentId;
    description = builder.description;
    rating = builder.rating;
    filmId = builder.filmId;
    userId = builder.userId;
    createdAt = builder.createdAt;
  }

  public static Builder builder() {
    return new Builder();
  }

  public CommentId getCommentId() {
    return commentId;
  }

  public CommentDescription getDescription() {
    return description;
  }

  public CommentRating getRating() {
    return rating;
  }

  public FilmId getFilmId() {
    return filmId;
  }

  public UserId getUserId() {
    return userId;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public static final class Builder {
    private CommentId commentId;
    private CommentDescription description;
    private CommentRating rating;
    private FilmId filmId;
    private UserId userId;
    private ZonedDateTime createdAt;

    private Builder() {}

    public Builder commentId(CommentId val) {
      commentId = val;
      return this;
    }

    public Builder description(CommentDescription val) {
      description = val;
      return this;
    }

    public Builder rating(CommentRating val) {
      rating = val;
      return this;
    }

    public Builder filmId(FilmId val) {
      filmId = val;
      return this;
    }

    public Builder userId(UserId val) {
      userId = val;
      return this;
    }

    public Builder createdAt(ZonedDateTime val) {
      createdAt = val;
      return this;
    }

    public Comment build() {
      return new Comment(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Comment comment = (Comment) o;
    return Objects.equals(commentId, comment.commentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentId);
  }
}
