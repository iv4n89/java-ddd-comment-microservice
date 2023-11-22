package com.films.service.comments.domain.ports.input.usecases;

import com.films.service.comments.domain.events.CommentDeletedEvent;

import java.util.UUID;

public interface CommentDeleter {
  CommentDeletedEvent delete(UUID commentId);
}
