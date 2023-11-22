package com.films.system.comments.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments", schema = "comment")
public class CommentEntity {
  @Id private UUID id;
  private String description;
  private Integer rating;
  private UUID filmId;
  private UUID userId;
  private LocalDateTime createdAt;

  private CommentEntity(Builder builder) {
    setId(builder.id);
    setDescription(builder.description);
    setRating(builder.rating);
    setFilmId(builder.filmId);
    setUserId(builder.userId);
    setCreatedAt(builder.createdAt);
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public static final class Builder {
    private UUID id;
    private String description;
    private Integer rating;
    private UUID filmId;
    private UUID userId;
    private LocalDateTime createdAt;

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

    public Builder createdAt(LocalDateTime val) {
      createdAt = val;
      return this;
    }

    public CommentEntity build() {
      return new CommentEntity(this);
    }
  }
}
