package com.films.service.comments.domain.ports.input.service;

import com.films.service.comments.domain.models.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentApplicationService {

  void create(
          UUID commentId, String commentDescritption, Integer commentRating, UUID filmId, UUID userId, LocalDateTime createdAt);

  Optional<Comment> findById(UUID commentId);

  List<Comment> findByFilmId(UUID filmId);

  List<Comment> findByUserId(UUID userId);

  void delete(UUID commentId);
}
