package com.films.system.comments.application.adapter.input.usecases;

import com.films.service.comments.domain.events.CommentCreatedEvent;
import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.ports.input.usecases.CommentCreator;
import com.films.service.comments.domain.ports.output.repository.CommentRepository;
import com.films.service.comments.domain.valueobjects.CommentDescription;
import com.films.service.comments.domain.valueobjects.CommentRating;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public final class CommentCreatorImpl implements CommentCreator {

  private final CommentRepository commentRepository;

  @Override
  public CommentCreatedEvent create(
      UUID commentId,
      String commentDescription,
      Integer commentRating,
      UUID filmId,
      UUID userId,
      LocalDateTime createdAt) {
    Comment comment =
        Comment.builder()
            .commentId(new CommentId(commentId))
            .description(new CommentDescription(commentDescription))
            .rating(new CommentRating(commentRating))
            .filmId(new FilmId(filmId))
            .userId(new UserId(userId))
            .createdAt(ZonedDateTime.of(createdAt, ZoneId.of("UTC")))
            .build();

    Comment savedComment = commentRepository.save(comment);

    Double meanRating = commentRepository.getMeanRatingByFilmId(comment.getFilmId());
    log.info("{} average", meanRating);

    return new CommentCreatedEvent(
        savedComment, ZonedDateTime.now(ZoneId.of("UTC")), meanRating.intValue());
  }
}
