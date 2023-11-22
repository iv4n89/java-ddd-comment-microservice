package com.films.system.comments.application.adapter.input.usecases;

import com.films.service.comments.domain.events.CommentDeletedEvent;
import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.ports.input.usecases.CommentDeleter;
import com.films.service.comments.domain.ports.output.repository.CommentRepository;
import com.films.system.comments.application.exceptions.CommentNotFoundException;
import com.films.system.common.domain.valueobject.CommentId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public final class CommentDeleterImpl implements CommentDeleter {

  private final CommentRepository commentRepository;

  @Override
  public CommentDeletedEvent delete(UUID commentId) {
    Optional<Comment> comment = commentRepository.findById(new CommentId(commentId));
    if (comment.isEmpty()) {
      log.error("Comment with id: {} could not be found", commentId.toString());
      throw new CommentNotFoundException(
          "Comment with id: " + commentId.toString() + " could not be found");
    }
    commentRepository.delete(new CommentId(commentId));
    return new CommentDeletedEvent(comment.get(), ZonedDateTime.now(ZoneId.of("UTC")));
  }
}
