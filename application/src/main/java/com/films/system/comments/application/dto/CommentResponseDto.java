package com.films.system.comments.application.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CommentResponseDto {
  private final UUID id;
  private final String description;
  private final Integer rating;
  private final UUID filmId;
  private final UUID userId;
  private final ZonedDateTime createdAt;

  private CommentResponseDto(Builder builder) {
    id = builder.id;
    description = builder.description;
    rating = builder.rating;
    filmId = builder.filmId;
    userId = builder.userId;
    createdAt = builder.createdAt;
  }

  public static Builder builder() {
    return new Builder();
  }

  public UUID getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Integer getRating() {
    return rating;
  }

  public UUID getFilmId() {
    return filmId;
  }

  public UUID getUserId() {
    return userId;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public static final class Builder {
    private UUID id;
    private String description;
    private Integer rating;
    private UUID filmId;
    private UUID userId;
    private ZonedDateTime createdAt;

    private Builder() {}

    public Builder id(UUID val) {
      id = val;
      return this;
    }

    public Builder description(String val) {
      description = val;
      return this;
    }

    public Builder rating(Integer val) {
      rating = val;
      return this;
    }

    public Builder filmId(UUID val) {
      filmId = val;
      return this;
    }

    public Builder userId(UUID val) {
      userId = val;
      return this;
    }

    public Builder createdAt(ZonedDateTime val) {
      createdAt = val;
      return this;
    }

    public CommentResponseDto build() {
      return new CommentResponseDto(this);
    }
  }
}
