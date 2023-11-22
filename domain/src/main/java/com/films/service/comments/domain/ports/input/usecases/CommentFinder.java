package com.films.service.comments.domain.ports.input.usecases;

import com.films.service.comments.domain.models.Comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentFinder {
    Optional<Comment> findById(UUID commentId);
    List<Comment> findByFilmId(UUID filmId);
    List<Comment> findByUserId(UUID userId);
}
